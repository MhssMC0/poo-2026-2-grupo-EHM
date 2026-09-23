public class Mago extends Personagem {

    private int mana;

    //metodo para retornar o valor da mana
    public int getMana(){
        return this.mana;
    }

    //metodo para setar o valor da mana
    public void setMana(int mana){
        if(mana < 0){
            System.out.println("Erro, mana invalida!");
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
}
