// Angular
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";

// Rutas
import { SessionStartedRoutingModule } from "./session-started.routing.module";

// Componentes
import { SessionStartedComponent } from "./session-started.component";

// Servicios
// import { NoticiasService } from "@services/privados";

@NgModule({
	imports: [CommonModule, RouterModule, SessionStartedRoutingModule],
	declarations: [SessionStartedComponent],
	exports: [SessionStartedComponent],
	providers: [SessionStartedComponent],
})
export class SessionStartedModule {}
