// Angular
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

// Componentes
import { LoginComponent } from "./pages/public/login/login.component";
import { NotFoundComponent } from "./pages/public/not-found/not-found.component";

// Guardia de autentificación
import { AuthenticationGuard, NoAuthenticationGuard } from "./shared/guards";

const routes: Routes = [
	{
		path: "",
		redirectTo: "session-started",
		canActivate: [AuthenticationGuard],
		pathMatch: "full",
	},
	{
		path: "login",
		component: LoginComponent,
		canActivate: [NoAuthenticationGuard],
	},
	{
		path: "",
		loadChildren: () => import("./pages/private/private.module").then((m) => m.PrivateModule),
		canActivate: [AuthenticationGuard],
	},
	{
		path: "**",
		component: NotFoundComponent,
	},
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule],
})
export class AppRoutingModule {}
