// Angular
import { Injectable } from "@angular/core";
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from "@angular/common/http";

// RXJS
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";

// Service authentication
import { AuthenticationService } from "../../services/public";

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
	constructor(private authenticationService: AuthenticationService) {}

	intercept(_HttpRequest: HttpRequest<any>, _HttpHandler: HttpHandler): Observable<HttpEvent<any>> {
		return _HttpHandler.handle(_HttpRequest).pipe(
			catchError((error) => {
				if ([401, 403].indexOf(error.status) !== -1) {
					// Cerrar la sesión automáticamente si la respuesta es 401 (no autorizada) o 403 (prohibida la consulta a la API)
					this.authenticationService.logout();

					if (!error.url.includes("auth")) {
						location.reload(true);
					}
				}

				const message = error.error.message || error.statusText;

				return throwError(message);
			})
		);
	}
}
