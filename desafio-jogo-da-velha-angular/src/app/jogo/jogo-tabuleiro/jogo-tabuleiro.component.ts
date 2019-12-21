import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { JogoService } from "../jogo.service";

@Component({
  selector: "app-jogo-tabuleiro",
  templateUrl: "./jogo-tabuleiro.component.html",
  styleUrls: ["./jogo-tabuleiro.component.css"]
})
export class JogoTabuleiroComponent implements OnInit {
  quad: any[];
  vencedor: string;
  service: JogoService;

  constructor(gameService: JogoService) {
    this.service = gameService;
    this.quad = gameService.quad;
    this.vencedor = gameService.vencedor;
  }

  ngOnInit() {}

  jogada(index: number) {
    this.service.jogada(index);
    console.log(this.service.placarO, this.service.placarX);
  }

  reiniciar() {
    this.service.restartBoard();
  }

  reset() {
    this.service.restartGame();
  }
}
