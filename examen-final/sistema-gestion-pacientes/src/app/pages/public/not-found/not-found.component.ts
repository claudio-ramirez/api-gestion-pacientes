// Angular
import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";

// Service authentication
import { AuthenticationService } from "../../../services/public";

@Component({
	selector: "app-not-found",
	templateUrl: "./not-found.component.html",
	styleUrls: ["./not-found.component.sass"],
})
export class NotFoundComponent implements OnInit {
	titulo: string;
	subtitulo: string;
	pathImage: string;

	activeSession: boolean;

	constructor(private router: Router, private activateRoute: ActivatedRoute, private authenticationService: AuthenticationService) {
		this.titulo = "Página No Encontrada";
		this.subtitulo = "Error 404";
		this.pathImage = "assets/images/error404.jpg";

		const currentUser = this.authenticationService.currentUserValue;

		if (currentUser) {
			this.activeSession = true;
		} else {
			this.activeSession = false;
		}
	}

	ngOnInit() {}
}
