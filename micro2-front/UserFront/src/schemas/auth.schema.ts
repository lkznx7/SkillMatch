import { z } from 'zod';

export const loginSchema = z.object({
  email: z.string().email('Email inválido'),
  senha: z.string().min(6, 'A senha deve ter pelo menos 6 caracteres'),
});

export type LoginData = z.infer<typeof loginSchema>;

export const registerSchema = z.object({
  nome: z.string().min(3, 'O nome deve ter pelo menos 3 caracteres'),
  email: z.string().email('Email inválido'),
  senha: z.string().min(6, 'A senha deve ter pelo menos 6 caracteres'),
  tipo: z.enum(['CLIENTE', 'PROFISSIONAL'], {
    errorMap: () => ({ message: 'Selecione um tipo de usuário' }),
  }),
});

export type RegisterData = z.infer<typeof registerSchema>;
