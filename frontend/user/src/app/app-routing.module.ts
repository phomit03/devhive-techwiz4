import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component';
import { HomeComponent } from './components/home/home.component'; 
import { MatchesComponent } from './components/matches/matches.component';
import { TeamsComponent } from './components/teams/teams.component';
import { TeamsDetailComponent } from './components/teams/teams-detail/teams-detail.component';
import { NewsComponent } from './components/news/news.component';
import { NewsDetailComponent } from './components/news/news-detail/news-detail.component';
import { FeedbackComponent } from './components/feedback/feedback.component';

import { LoginComponent } from './components/account/login/login.component';
import { RegisterComponent } from './components/account/register/register.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},

  {path: '', component: LayoutComponent, children: [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'matches', component: MatchesComponent},
    {path: 'teams', component: TeamsComponent},
    {path: 'teams/detail', component: TeamsDetailComponent},
    {path: 'news', component: NewsComponent},
    {path: 'news/detail', component: NewsDetailComponent},
    {path: 'feedbacks', component: FeedbackComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
