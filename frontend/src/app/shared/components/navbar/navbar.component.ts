import {Component} from '@angular/core';
import {NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';


@Component({
  selector: 'app-navbar',
  imports: [NgIf,RouterLink],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  isMobileMenuOpen = false;
  isShowUserMenuOpen:boolean=false;

  toggleMobileMenu(): void {
    this.isMobileMenuOpen = !this.isMobileMenuOpen;
  }
  toggleUserMenu(): void {
    this.isShowUserMenuOpen = !this.isShowUserMenuOpen;
  }


}
