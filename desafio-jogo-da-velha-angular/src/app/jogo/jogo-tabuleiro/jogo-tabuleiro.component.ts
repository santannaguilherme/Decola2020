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
  placarX: number;
  placarO: number;

  constructor(gameService: JogoService) {
    this.service = gameService;
    this.quad = gameService.quad;
    this.placarO = gameService.placarO;
    this.placarX = gameService.placarX;
    this.vencedor = gameService.vencedor;
  }

  ngOnInit() {}

  jogada(index: number) {
    this.service.jogada(index);
  }

  reset(){
    this.service.restartBoard();
  }
}
