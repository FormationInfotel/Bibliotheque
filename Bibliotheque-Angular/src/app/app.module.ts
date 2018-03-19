import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AppRoutingComponent } from './app-routing/app-routing.component';
import { AccueilComponent } from './accueil/accueil.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MesageService } from './mesage.service';


@NgModule({
  declarations: [
    AppComponent,
    AppRoutingComponent,
    AccueilComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [MesageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
