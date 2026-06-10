import React, { createContext, useContext, useState, useEffect, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';
import { User } from '../types/user';
import { LoginData } from '../schemas/auth.schema';
import { authService } from '../services/auth.service';

interface AuthContextData {
  user: User | null;
  loading: boolean;
  login(data: LoginData): Promise<void>;
  logout(): void;
  getToken(): string | null;
}

const AuthContext = createContext<AuthContextData>({} as AuthContextData);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  const getToken = useCallback(() => {
    return localStorage.getItem('@SkillMatch:token');
  }, []);

  const logout = useCallback(() => {
    localStorage.removeItem('@SkillMatch:token');
    setUser(null);
    navigate('/login');
  }, [navigate]);

  useEffect(() => {
    const token = getToken();
    if (token) {
      try {
        const decoded = jwtDecode<{ sub: string; nome: string; email: string; tipo: string }>(token);
        setUser({
          id: decoded.sub,
          nome: decoded.nome,
          email: decoded.email,
          tipo: decoded.tipo as any,
        });
      } catch (error) {
        logout();
      }
    }
    setLoading(false);
  }, [getToken, logout]);

  const login = async (data: LoginData) => {
    const response = await authService.login(data);
    localStorage.setItem('@SkillMatch:token', response.token);
    
    const decoded = jwtDecode<{ sub: string; nome: string; email: string; tipo: string }>(response.token);
    setUser({
      id: decoded.sub,
      nome: decoded.nome,
      email: decoded.email,
      tipo: decoded.tipo as any,
    });

    navigate('/dashboard');
  };

  return (
    <AuthContext.Provider value={{ user, loading, login, logout, getToken }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
