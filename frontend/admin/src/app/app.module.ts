import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './components/layout/layout.component';
import { LoginComponent } from './components/account/login/login.component';
import { RegisterComponent } from './components/account/register/register.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CategoryListComponent } from './components/category/category-list/category-list.component';
import { CategoryCreateComponent } from './components/category/category-create/category-create.component';
import { CategoryEditComponent } from './components/category/category-edit/category-edit.component';
import { MatchCreateComponent } from './components/match/match-create/match-create.component';
import { MatchEditComponent } from './components/match/match-edit/match-edit.component';
import { MatchListComponent } from './components/match/match-list/match-list.component';
import { NewsListComponent } from './components/news/news-list/news-list.component';
import { NewsCreateComponent } from './components/news/news-create/news-create.component';
import { NewsEditComponent } from './components/news/news-edit/news-edit.component';
import { PlayerCreateComponent } from './components/player/player-create/player-create.component';
import { PlayerEditComponent } from './components/player/player-edit/player-edit.component';
import { PlayeListComponent } from './components/player/player-list/playe-list.component';
import { ProductListComponent } from './components/product/product-list/product-list.component';
import { ProductCreateComponent } from './components/product/product-create/product-create.component';
import { ProductEditComponent } from './components/product/product-edit/product-edit.component';
import { TeamListComponent } from './components/team/team-list/team-list.component';
import { TeamCreateComponent } from './components/team/team-create/team-create.component';
import { TeamEditComponent } from './components/team/team-edit/team-edit.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserCreateComponent } from './components/user/user-create/user-create.component';
import { UserEditComponent } from './components/user/user-edit/user-edit.component';
import { OrderListComponent } from './components/order/order-list/order-list.component';
import { OrderEditComponent } from './components/order/order-edit/order-edit.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    CategoryListComponent,
    CategoryCreateComponent,
    CategoryEditComponent,
    MatchCreateComponent,
    MatchEditComponent,
    MatchListComponent,
    NewsListComponent,
    NewsCreateComponent,
    NewsEditComponent,
    PlayerCreateComponent,
    PlayerEditComponent,
    PlayeListComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    TeamListComponent,
    TeamCreateComponent,
    TeamEditComponent,
    UserListComponent,
    UserCreateComponent,
    UserEditComponent,
    OrderListComponent,
    OrderEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
