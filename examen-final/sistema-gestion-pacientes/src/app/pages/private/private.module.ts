// Angular
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

// Enrutador
import { PrivateRoutingModule } from "./private.routing.module";

// Componente
import { PrivateComponent } from "./private.component";

@NgModule({
	declarations: [PrivateComponent],
	imports: [CommonModule, PrivateRoutingModule],
})
export class PrivateModule {}
