import { Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { CardComponent } from './card/card.component';

export const routes: Routes = [
    {path:'', component:HomeComponent},
    {path:'signin',component:SigninComponent},
    {path:'register', component:RegisterComponent},
    {path:'home', component:CardComponent}

];
