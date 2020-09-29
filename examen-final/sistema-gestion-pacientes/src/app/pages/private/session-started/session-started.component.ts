// Angular
import { Component, OnInit } from "@angular/core";

// RxJS
import { throwError, timer } from "rxjs";

// Servicios
// import { NoticiasService } from "@services/privados";

@Component({
	selector: "app-session-started",
	templateUrl: "./session-started.component.html",
	styleUrls: ["./session-started.component.sass"],
})
export class SessionStartedComponent implements OnInit {
	public titulo: string;

	// Declaración de noticias
	public noticias: Array<any>;

	// Opciones de las Alertas
	public options = {
		autoClose: true,
		keepAfterRouteChange: false,
	};

	constructor() {
		this.titulo = "Sesión Iniciada";
	}

	ngOnInit() {
		let pagina: number = 0;
		let cantidad: number = 5;

		// this.obtenerNoticias(pagina, cantidad);
	}

	async obtenerNoticias(pagina: number, cantidad: number) {
		// this.noticiasService.postNoticia(pagina, cantidad).subscribe(
		// 	(data) => {
		// 		this.noticias = data.items.sort((a: any, b: any) => b.fechaCreacion - a.fechaCreacion);
		// 	},
		// 	(error: any) => {
		// 		this.alertService.error("Error al consultar el servicio de noticias", this.options);
		// 		return throwError(error);
		// 	}
		// );
		// timer(1000).subscribe(() => {
		// 	this.spinnerService.deactivate();
		// });
	}
}
