import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JogoTabuleiroComponent } from './jogo/jogo-tabuleiro/jogo-tabuleiro.component';
import { JogoQuadradoComponent } from './jogo/jogo-quadrado/jogo-quadrado.component';
import { JogoPlacarComponent } from './jogo/jogo-placar/jogo-placar.component';

@NgModule({
  declarations: [
    AppComponent,
    JogoTabuleiroComponent,
    JogoQuadradoComponent,
    JogoPlacarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
