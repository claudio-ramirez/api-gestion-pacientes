import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { SessionStartedComponent } from "./session-started.component";

const routesSessionStarted: Routes = [
	{
		path: "",
		component: SessionStartedComponent
	}
];

@NgModule({
	imports: [RouterModule.forChild(routesSessionStarted)],
	exports: [RouterModule]
})
export class SessionStartedRoutingModule {}
