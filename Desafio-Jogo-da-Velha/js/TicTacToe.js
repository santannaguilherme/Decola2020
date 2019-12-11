function main() {
  var a1 = document.getElementById("a1");
  var b1 = document.getElementById("b1");
  var c1 = document.getElementById("c1");
  var a2 = document.getElementById("a2");
  var b2 = document.getElementById("b2");
  var c2 = document.getElementById("c2");
  var a3 = document.getElementById("a3");
  var b3 = document.getElementById("b3");
  var c3 = document.getElementById("c3");
  var matriz = [a1, b1, c1, a2, b2, c2, a3, b3, c3];
  var jogador = 0;
  var placar01 = 0;
  var placar02 = 0;
  var jogadas = 0;

  var matrizVitoria = [
    [0, 1, 2],
    [0, 3, 6],
    [0, 4, 8],
    [1, 4, 7],
    [2, 4, 6],
    [2, 5, 8],
    [3, 4, 5],
    [6, 7, 8]
  ];

  document.getElementById("reset").addEventListener('click',restart);

  document.getElementById("clear").addEventListener("click", clear);
  document
    .querySelector(".tabuleiro")
    .addEventListener("click", function(elemento) {
      var peca = document.getElementById(elemento.target.id);
      if (
        peca.innerText !== "X" &&
        peca.innerText !== "O" &&
        elemento.target.id !== "tabuleiro" &&
        elemento.target.id !== "linha"
      ) {
        jogadas++;
        if (jogador === 0) {
          peca.innerText = "X";
          jogador++;
        } else {
          peca.innerText = "O";
          jogador--;
        }
        validaGanhador();
      }
    });

  function validaGanhador() {
    for (var teste of matrizVitoria) {
      if (
        matriz[teste[0]].innerText.length > 0 &&
        matriz[teste[0]].innerText == matriz[teste[1]].innerText &&
        matriz[teste[0]].innerText == matriz[teste[2]].innerText &&
        matriz[teste[1]].innerText == matriz[teste[2]].innerText
      ) {
        ganhador();
        break;
      }

      
    }
    if (jogadas > 9) {
      reset();
    }
  }

  function reset() {
    startOver();
    confirm("Empate!!!");
    cleanGame();
  }
  function ganhador() {
    cleanGame();
    if (jogador == 1) {
      confirm("Jogador X ganhou");
      placar01++;
    } else {
      confirm("Jogador O ganhou");
      placar02++;
    }
    setScore();
    startOver();
  }
  function clear() {
    cleanGame();
    startOver();
    placar01 = 0;
    placar02 = 0;
    setScore();
  }

  function restart(){
    cleanGame();
    startOver();
  }

  function cleanGame(){
    for (var limpador of matriz) {
      limpador.innerText = "";
    }
  }

  function setScore(){
    document.getElementById("placar-01").innerText = placar01;
    document.getElementById("placar-02").innerText = placar02;
  }

  function startOver(){
    jogador = 0;
    jogadas = 0;
  }
}

document.addEventListener("DOMContentLoaded", main);
