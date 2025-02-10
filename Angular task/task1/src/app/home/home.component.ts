import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NavbarComponent } from "../navbar/navbar.component";
import { SearchComponent } from "../search/search.component";
import { Product } from '../product';
import { CardComponent } from '../card/card.component';

@Component({
  selector: 'app-home',
  imports: [NavbarComponent, SearchComponent, CardComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
@Input() data!:Product[];

searchResult: string=''; 

@Output() homeData = new EventEmitter<any>(); 

onSearchDataReceived(data: any) {
  this.searchResult = data;
  this.homeData.emit(data);
}

}
