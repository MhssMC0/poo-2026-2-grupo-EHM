public class Guerreiro extends Personagem{
    private int defesa;

    //metodo para retornar o valor da defesa
    public int getDefesa(){
        return this.defesa;
    }

    //metodo para definir o valor da defesa
    public void setDefesa(int defesa){
        if(defesa < 0){
            throw new IllegalArgumentException("A defesa deve ser maior ou igual a 0. Valor recebido: " + defesa + ".");
        }

        this.defesa = defesa;
    }

    //construtor padrao inicializando a defesa em 5
    public Guerreiro(){
        super("Dragasco", 100, 20, 15);
        setDefesa(5);
    }

    //construtor parametrizado inicializando a defesa em 5
    public Guerreiro(String nome, int vida, int forca, int nivel){
        super(nome, vida, forca, nivel);
        setDefesa(5);
    }

    //metodo ficha sobrescrito mostrando o valor de defesa do Guerreiro
    @Override 
    public void ficha(){
        super.ficha();
        System.out.println("Defesa: " + getDefesa());
    }

    //sobrescrita da habilidade do personagem
    @Override 
    public String habilidade(){
        return "Escudo de aco";
        
    }

    //metodo para tentar um golpe especial que exige mais força
    public void golpeEspecial(Personagem alvo) throws ForcaInsuficienteException {
        if (getForca() < 25) {
            throw new ForcaInsuficienteException(getForca());
        }

        System.out.println(getNome() + " usou o golpe especial em " + alvo.getNome() + " causando 30 de dano!");
        alvo.receberDano(30);
    }
}
