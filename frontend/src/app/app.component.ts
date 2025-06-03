import { Component } from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {NavbarComponent} from './shared/components/navbar/navbar.component';
import {NgIf} from '@angular/common';
import {FooterComponent} from './shared/components/footer/footer.component';
import {HomeComponent} from './pages/home/home/home.component';
import {LoginComponent} from './auth/pages/login/login/login.component';
import {CategoryComponent} from './features/categories/category/category.component';
import {  NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet,NavbarComponent,NgIf,FooterComponent,HomeComponent,LoginComponent,
    CategoryComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'wague-cheick';
  hideNavbar = false;

  constructor(private router: Router) {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.hideNavbar = event.url === '/login';
      });
  }
}
