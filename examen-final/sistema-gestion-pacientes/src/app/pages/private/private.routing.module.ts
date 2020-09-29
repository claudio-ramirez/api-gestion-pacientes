// Angular
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

// Componente
import { PrivateComponent } from "./private.component";

// Guardia de autentificación
import { AuthenticationGuard } from "../../shared/guards";

const routesPrivate: Routes = [
	{
		path: "",
		component: PrivateComponent,
		children: [
			{
				path: "session-started",
				// loadChildren: () => import("./session-started/session-started.module").then((m) => m.SessionStartedModule),
				canActivate: [AuthenticationGuard],
			},
		],
	},
];

@NgModule({
	imports: [RouterModule.forChild(routesPrivate)],
	exports: [RouterModule],
})
export class PrivateRoutingModule {}
