// Angular
import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse, HttpErrorResponse, HttpHeaders } from "@angular/common/http";

// RXJS
import { BehaviorSubject, Observable, throwError } from "rxjs";
import { map } from "rxjs/operators";

// Configuración global de parametros (desarrollo - qa - producción)
import { environment } from "src/environments/environment";

@Injectable()
export class AuthenticationService {
	private apiSeguridad: string = `${environment.autenticacion}`;

	private currentUserSubject: BehaviorSubject<any>;

	public currentUser: Observable<any>;

	constructor(private httpClient: HttpClient) {
		this.currentUserSubject = new BehaviorSubject<any>(false);

		this.currentUser = this.currentUserSubject.asObservable();
	}

	public get currentUserValue(): any {
		return this.currentUserSubject.value;
	}

	public login(nombreUsuario: string, contrasena: string) {
		let cuerpoConsulta = { username: nombreUsuario, password: contrasena };

		let obtenerToken$ = this.httpClient.post(this.apiSeguridad, cuerpoConsulta, { observe: "response" }).pipe(
			map((response: HttpResponse<any>) => {
				let token: string;

				if (response.headers.get("authorization")) {
					token = response.headers.get("authorization");

					this.currentUserSubject.next(true);

					return token;
				} else {
					token = "";

					this.currentUserSubject.next(null);

					return token;
				}
			})
		);

		return obtenerToken$;
	}

	public logout() {
		localStorage.clear();

		this.currentUserSubject.next(null);
	}

	handleError(error: HttpErrorResponse) {
		let mensaje = "";

		if (error.error instanceof ErrorEvent) {
			mensaje = error.error.message;
		} else {
			mensaje = `Código del error: ${error.status} \n Mensaje: ${error.message}`;
		}

		return throwError(mensaje);
	}
}
