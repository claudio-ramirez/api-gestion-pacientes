// Angular
import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";

// Servicio de autentificación
import { AuthenticationService } from "src/app/services/publicos";

@Injectable({ providedIn: "root" })
export class NoAuthenticationGuard implements CanActivate {
	constructor(private router: Router, private authenticationService: AuthenticationService) {}

	canActivate(activatedRouteSnapshot: ActivatedRouteSnapshot, routerStateSnapshot: RouterStateSnapshot) {
		const currentUserValue = this.authenticationService.currentUserValue;

		if (currentUserValue) {
			this.router.navigate(["afiliado/datos-personales/editar"]);

			return false;
		} else {
			return true;
		}
	}
}
