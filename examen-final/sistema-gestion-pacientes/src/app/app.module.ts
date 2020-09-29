// Angular
import { BrowserModule } from "@angular/platform-browser";
import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgModule } from "@angular/core";

// Enrutador
import { AppRoutingModule } from "./app.routing.module";

// Componente principal
import { AppComponent } from "./app.component";

// Componentes Iniciales
import { LoginComponent } from "./pages/public/login/login.component";
import { NotFoundComponent } from "./pages/public/not-found/not-found.component";

// Interceptores
import { JwtInterceptor, ErrorInterceptor } from "./shared/interceptors";

@NgModule({
	declarations: [AppComponent],
	imports: [BrowserModule, AppRoutingModule],
	providers: [LoginComponent, NotFoundComponent, { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }, { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
	bootstrap: [AppComponent],
})
export class AppModule {}
