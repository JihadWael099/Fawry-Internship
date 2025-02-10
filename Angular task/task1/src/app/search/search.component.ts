import { Component, EventEmitter, Input, input, NgModule, Output } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { Product } from '../product';
@Component({
  selector: 'app-search',
  imports: [FormsModule],
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  @Output() searchChanged: EventEmitter<string> = new EventEmitter();

  searchQuery: string = '';

  onSearch() {
    console.log('Search query:', this.searchQuery); 
    this.searchChanged.emit(this.searchQuery); 
  }

}
