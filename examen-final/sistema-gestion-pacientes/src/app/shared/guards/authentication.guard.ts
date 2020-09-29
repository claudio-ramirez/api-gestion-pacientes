// Angular
import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";

// Servicio de autentificación
import { AuthenticationService } from "@services/publicos";

@Injectable({ providedIn: "root" })
export class AuthenticationGuard implements CanActivate {
	constructor(private router: Router, private authenticationService: AuthenticationService) {}

	canActivate(activatedRouteSnapshot: ActivatedRouteSnapshot, routerStateSnapshot: RouterStateSnapshot) {
		const currentUserValue = this.authenticationService.currentUserValue;

		if (currentUserValue) {
			// Autorizado por lo que devuelve verdadero
			return true;
		}

		// No ha iniciado sesión, se redirige a la página de inicio de sesión con la URL de retorno
		this.router.navigate(["inicio-sesion"], { queryParams: { returnUrl: routerStateSnapshot.url } });

		return false;
	}
}
