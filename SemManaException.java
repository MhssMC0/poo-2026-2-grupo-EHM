public class SemManaException extends Exception {

    //construtor da excecao informando a mana atual do Mago
    public SemManaException(int manaAtual) {
        super("Mana insuficiente. Mana atual: " + manaAtual + ". É necessário ter pelo menos 10 de mana.");
    }
}
