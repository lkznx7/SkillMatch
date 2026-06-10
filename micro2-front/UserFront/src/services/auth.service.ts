import api from './api';
import { LoginData, RegisterData } from '../schemas/auth.schema';
import { AuthResponse } from '../types/user';

export const authService = {
  async login(data: LoginData) {
    const response = await api.post<AuthResponse>('/auth/login', data);
    return response.data;
  },

  async register(data: RegisterData) {
    const response = await api.post('/users', data);
    return response.data;
  },
};
