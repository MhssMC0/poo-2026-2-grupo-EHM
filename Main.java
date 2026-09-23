public class Main {
    public static void main(String[] args) {
        Personagem P0 = new Personagem();
        Personagem P1 = new Personagem("Abu", 100, 10, 10);
        Personagem P2 = new Personagem("Aba", 90, 0, 0);
        P0.ficha();
        P1.ficha();
        P2.ficha();

        
        P1.atacar(P2, 20);

        P1.ficha();
        P2.ficha();
        P1.estaVivo();
        P2.estaVivo();
    }
}
