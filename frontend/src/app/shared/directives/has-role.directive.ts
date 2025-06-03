/*
import { Directive, Input, TemplateRef, ViewContainerRef, inject } from '@angular/core';
import { AuthService } from 'src/app/core/services/auth.service';

@Directive({
  selector: '[appHasRole]',
  standalone: true
})
export class HasRoleDirective {
  private authService = inject(AuthService);

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) {}

  @Input() set appHasRole(role: string | string[]) {
    const userRoles = this.authService.getUserRoles(); // méthode personnalisée à toi
    const roles = Array.isArray(role) ? role : [role];

    const hasAccess = roles.some(r => userRoles.includes(r));

    this.viewContainer.clear();
    if (hasAccess) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    }
  }
}

<button *appHasRole="'ADMIN'">Supprimer la recette</button>

<!-- Visible pour ADMIN ou MODERATOR -->
<div *appHasRole="['ADMIN', 'MODERATOR']">
  Zone de modération
</div>


 */
