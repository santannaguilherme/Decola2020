import { Component, Input,} from "@angular/core";


@Component({
  selector: "app-jogo-quadrado",
  templateUrl: "./jogo-quadrado.component.html",
  styleUrls: ["./jogo-quadrado.component.css"]
})
export class JogoQuadradoComponent {
  @Input() campo: 'X' | 'O';

}
