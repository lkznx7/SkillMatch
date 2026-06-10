import api from './api';
import { User } from '../types/user';

export const userService = {
  async getProfile(id: string) {
    const response = await api.get<User>(`/users/${id}`);
    return response.data;
  },

  async listUsers() {
    const response = await api.get<User[]>('/users');
    return response.data;
  },

  async deleteUser(id: string) {
    await api.delete(`/users/${id}`);
  },
};
