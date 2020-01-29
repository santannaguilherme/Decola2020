package src;

public class Main {

    public static void main(String args[]) {
        Warudo warudo = new Warudo("Za Warudo! ±");
        System.out.println(warudo.getName());
        PessoaFisica pf = new PessoaFisica();
        print(pf);
        PessoaJuridica pj = new PessoaJuridica();
        print(pj);

    }

    static void print(PessoaBase p) {
        System.out.println(p.metodoConcreto() + " " + p.metodoAbstrato());
    }
}