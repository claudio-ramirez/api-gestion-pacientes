// Angular
import { Injectable } from "@angular/core";
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from "@angular/common/http";

// RXJS
import { Observable } from "rxjs";

// Service authentication
import { AuthenticationService } from "../../services/public";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
	constructor(private authenticationService: AuthenticationService) {}

	intercept(_HttpRequest: HttpRequest<any>, _HttpHandler: HttpHandler): Observable<HttpEvent<any>> {
		let currentUser = this.authenticationService.currentUserValue;

		let dataLocalStorage: any = JSON.parse(localStorage.getItem("data"));

		if (currentUser) {
			_HttpRequest = _HttpRequest.clone({
				setHeaders: {
					Authorization: `Bearer ${dataLocalStorage.token}`,
				},
			});
		}

		return _HttpHandler.handle(_HttpRequest);
	}
}
