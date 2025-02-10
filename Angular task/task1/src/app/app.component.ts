import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Product } from './product';
import productData from './../../public/db.json';
import { HomeComponent } from "./home/home.component";
@Component({
  selector: 'app-root',
  imports: [HomeComponent,RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  products : Product[] = productData;
  appData: string=''; 

  onHomeDataReceived(data: any) {
    this.appData = data;
    this.products = this.products.filter((product) =>
      product.category?.toLowerCase().includes(this.appData.toLowerCase())
    );
  }
}
