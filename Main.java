public class Main {
    public static void main(String[] args) {
        Personagem P0 = new Personagem();
        Personagem P1 = new Personagem("Abu", 100, 10, 10);
        Personagem P2 = new Personagem("Aba", 90, 0, 0);
        Personagem M1 = new Mago();
        Personagem G1 = new Guerreiro();
        Item I1 = new Item("Arco", 10 );
        Item I2 = new Item("Espada", 20 );

        
        P0.ficha();
        P1.ficha();
        P2.ficha();
        M1.ficha();
        G1.ficha();
        G1.showInventario();

        I1.descricao();
        I2.descricao();

        G1.addItem(I1);
        G1.addBonus(I1);

        G1.ficha();

        G1.atacar(P0);

        P0.ficha();

        G1.showInventario();
        
    }
}
