export interface Category{
  name:string,
  description:string
}

/**
 * service
 * @Injectable({ providedIn: 'root' })
 * export class AuthService {
 *   private readonly tokenKey = 'jwt';
 *
 *   login(credentials: LoginDto): Observable<void> {
 *     return this.http.post<{ token: string }>('/api/auth/login', credentials).pipe(
 *       tap(res => localStorage.setItem(this.tokenKey, res.token))
 *     );
 *   }
 *
 *   logout() {
 *     localStorage.removeItem(this.tokenKey);
 *   }
 *
 *   isAuthenticated(): boolean {
 *     return !!localStorage.getItem(this.tokenKey);
 *   }
 * }
 * //guard
 * @Injectable({ providedIn: 'root' })
 * export class AuthGuard implements CanActivateFn {
 *   return (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
 *     const token = localStorage.getItem('jwt');
 *     if (token) return true;
 *     return inject(Router).createUrlTree(['/login']);
 *   };
 * }
 * //naviagation
 *
 * export const routes: Routes = [
 *   {
 *     path: 'login',
 *     loadComponent: () => import('./auth/pages/login/login.component')
 *       .then(m => m.LoginComponent)
 *   },
 *   {
 *     path: 'recipes',
 *     loadChildren: () => import('./features/recipes/recipe.routes')
 *       .then(m => m.RECIPE_ROUTES)
 *   },
 *   {
 *     path: '',
 *     redirectTo: 'recipes',
 *     pathMatch: 'full'
 *   }
 * ];
 */
