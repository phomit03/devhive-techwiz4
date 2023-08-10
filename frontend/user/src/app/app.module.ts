import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './components/layout/layout.component';
import { HomeComponent } from './components/home/home.component';
import { MatchesComponent } from './components/matches/matches.component';
import { TeamsComponent } from './components/teams/teams.component';
import { NewsComponent } from './components/news/news.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { LoginComponent } from './components/account/login/login.component';
import { RegisterComponent } from './components/account/register/register.component';
import { NewsDetailComponent } from './components/news/news-detail/news-detail.component';
import { TeamsDetailComponent } from './components/teams/teams-detail/teams-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    HomeComponent,
    MatchesComponent,
    TeamsComponent,
    NewsComponent,
    FeedbackComponent,
    LoginComponent,
    RegisterComponent,
    NewsDetailComponent,
    TeamsDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
