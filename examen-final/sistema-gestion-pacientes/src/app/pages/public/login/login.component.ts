// Angular
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

// RxJS
import { timer, throwError } from "rxjs";

// Service authentication
import { AuthenticationService } from "../../../services/public";

@Component({
	selector: "app-login",
	templateUrl: "./login.component.html",
	styleUrls: ["./login.component.sass"],
})
export class LoginComponent implements OnInit {
	public formLogin: FormGroup;
	public cargando = false;
	public enviado = false;
	public retornarUrl: string;

	public titulo: string;
	public tituloPiePagina: string;
	public rutaImagenLogo: string;
	public rutaImagenCargando: string;

	// Declaración de usuario
	public usuario: any;

	// Declaración de variables captcha
	public siteKey: string;
	public theme: string;

	constructor(private formBuilder: FormBuilder, private activateRoute: ActivatedRoute, private authenticationService: AuthenticationService, private router: Router) {
		this.titulo = "Inicio de Sesión";
		this.tituloPiePagina = "Sociedad Chilena de Autores e Intérpretes Musicales";

		this.siteKey = "6LcrH74ZAAAAAGcNDxfm6IHUFDswT6vqn0pgb7T-";
		this.theme = "Light";

		this.rutaImagenLogo = "assets/images/logo_transparente.png";
		this.rutaImagenCargando = "assets/images/loading.gif";
	}

	ngOnInit() {
		this.formLogin = this.formBuilder.group({
			username: ["", Validators.required],
			password: ["", [Validators.required, Validators.minLength(4)]],
			recaptcha: ["", Validators.required],
		});

		this.retornarUrl = this.activateRoute.snapshot.queryParams["returnUrl"] || "inicio";
	}

	get f() {
		return <any>this.formLogin.controls;
	}

	enviarFormulario() {
		this.enviado = true;

		if (this.formLogin.invalid) {
			return;
		}

		let _nombreUsuario: string = this.f.username.value;
		let _contrasena: string = this.f.password.value;

		this.authenticationService.login(_nombreUsuario, _contrasena).subscribe(
			(data: any) => {
				if (data) {
					let token = { token: data, username: _nombreUsuario };

					localStorage.setItem("data", JSON.stringify(token));

					this.router.navigate(["sesion"]);
				} else {
					this.authenticationService.logout();
				}
			},
			(error: any) => {
				this.authenticationService.logout();

				return throwError(error);
			}
		);
	}
}
