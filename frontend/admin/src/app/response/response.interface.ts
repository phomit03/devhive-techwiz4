import { Category } from "./category-response.interface";
import { UserResponse } from "./login-response.interface";

export interface Product {
  id: number;
  name: string;
  image: string;
  quantity: string;
  price: number;
  category: Category;
  status: number;
}

export interface Match {
  id: number;
  date: string; 
  time: string;
  score: string;
  soccerInfo: string;
  status: number;
  teams: Team[];
}

export interface Team {
  id: number;
  name: string;
  country: string;
  logoImage: string;
  status: number;
  matches: Match[];
}

export interface Player {
  id: number;
  name: string;
  dateOfBirth: string;
  nationality: string;
  position: string;
  achievements: string;
  status: number;
  team: Team;
}

export interface News {
  id: number;
  title: string;
  image: string;
  description: string;
}

export interface Order {
  id: number;
  user: UserResponse;
  totalPrice: number;
  status: number;
  orderProducts: any[];
}
