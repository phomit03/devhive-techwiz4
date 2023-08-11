import { Category } from "./category-response.interface";

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