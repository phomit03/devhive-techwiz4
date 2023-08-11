import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/account/login/login.component';
import { RegisterComponent } from './components/account/register/register.component';
import { LayoutComponent } from './components/layout/layout.component';
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
import { PlayeListComponent } from './components/player/player-list/playe-list.component';
import { PlayerCreateComponent } from './components/player/player-create/player-create.component';
import { PlayerEditComponent } from './components/player/player-edit/player-edit.component';
import { ProductListComponent } from './components/product/product-list/product-list.component';
import { ProductCreateComponent } from './components/product/product-create/product-create.component';
import { ProductEditComponent } from './components/product/product-edit/product-edit.component';
import { TeamListComponent } from './components/team/team-list/team-list.component';
import { TeamCreateComponent } from './components/team/team-create/team-create.component';
import { TeamEditComponent } from './components/team/team-edit/team-edit.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserCreateComponent } from './components/user/user-create/user-create.component';
import { UserEditComponent } from './components/user/user-edit/user-edit.component';
import { OrderEditComponent } from './components/order/order-edit/order-edit.component';
import { OrderListComponent } from './components/order/order-list/order-list.component';
import { AuthGuardService } from './services/auth/auth-guard.service';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  
  {path: '', component: LayoutComponent, canActivate: [AuthGuardService], children: [
    {path: '', component: DashboardComponent},
    {path: 'dashboard', component: DashboardComponent},

    {path: 'category', component: CategoryListComponent},
    {path: 'category/create', component: CategoryCreateComponent},
    {path: 'category/edit/:id', component: CategoryEditComponent},

    {path: 'match', component: MatchListComponent},
    {path: 'match/create', component: MatchCreateComponent},
    {path: 'match/edit', component: MatchEditComponent},

    {path: 'news', component: NewsListComponent},
    {path: 'news/create', component: NewsCreateComponent},
    {path: 'news/edit', component: NewsEditComponent},

    {path: 'player', component: PlayeListComponent},
    {path: 'player/create', component: PlayerCreateComponent},
    {path: 'player/edit', component: PlayerEditComponent},

    {path: 'product', component: ProductListComponent},
    {path: 'product/create', component: ProductCreateComponent},
    {path: 'product/edit/:id', component: ProductEditComponent},

    {path: 'team', component: TeamListComponent},
    {path: 'team/create', component: TeamCreateComponent},
    {path: 'team/edit', component: TeamEditComponent},

    {path: 'user', component: UserListComponent},
    {path: 'user/create', component: UserCreateComponent},
    {path: 'user/edit', component: UserEditComponent},

    {path: 'order', component: OrderListComponent},
    {path: 'order/create', component: OrderEditComponent},
    {path: 'order/edit', component: OrderEditComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
