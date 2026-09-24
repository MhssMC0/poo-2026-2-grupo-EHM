public class ForcaInsuficienteException extends Exception {

    //construtor da excecao informando a força atual do Guerreiro
    public ForcaInsuficienteException(int forcaAtual) {
        super("Força insuficiente. Força atual: " + forcaAtual + ". É necessário ter pelo menos 25 de força.");
    }
}
