import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-jogo-placar',
  templateUrl: './jogo-placar.component.html',
  styleUrls: ['./jogo-placar.component.css']
})
export class JogoPlacarComponent {

  @Input() jogador:'X'|'O';
  @Input() pontos:number;


}
