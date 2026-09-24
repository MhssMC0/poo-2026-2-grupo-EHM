public class Mago extends Personagem {

    private int mana;

    //metodo para retornar o valor da mana
    public int getMana(){
        return this.mana;
    }

    //metodo para setar o valor da mana
    public void setMana(int mana){
        if(mana < 0){
            throw new IllegalArgumentException("A mana deve ser maior ou igual a 0. Valor recebido: " + mana + ".");
        }

        this.mana = mana;
    }

    //construtor padrao do mago
    public Mago(){
        super("Magoo", 100, 10, 12);
        setMana(50);
    }

    //construtor com parametros do mago inicializando a mana om o valor de 50
    public Mago(String nome, int vida, int forca, int nivel){
        super(nome, vida, forca, nivel);
        setMana(50);
    }

    //metodo ficha sobrescrito adicionando o valor de mana definido poara o Mago
    @Override 
    public void ficha(){
        super.ficha();
        System.out.println("Mana: " + getMana());
    }

    //sobrescrita da habilidade do personagem
    @Override 
    public String habilidade(){
        return "Rajada arcana";
    }

    //metodo para lançar um feitico gastando mana
    public void lancarFeitico(Personagem alvo) throws SemManaException {
        if (mana < 10) {
            throw new SemManaException(mana);
        }

        mana -= 10;
        System.out.println(getNome() + " lançou Rajada arcana em " + alvo.getNome() + " causando 20 de dano!");
        alvo.receberDano(20);
    }
}
