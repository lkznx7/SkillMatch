export type UserType = 'CLIENTE' | 'PROFISSIONAL';

export interface User {
  id: string;
  nome: string;
  email: string;
  tipo: UserType;
}

export interface AuthResponse {
  token: string;
}
