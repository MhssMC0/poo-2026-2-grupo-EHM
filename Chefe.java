public class Chefe extends Personagem{
    
    //construtor padrao do chefe
    public Chefe(){
        super("Bixo Bruto", 200, 20, 25);
    }

    //construtor parametizado do chefe
    public Chefe(String nome, int vida, int forca, int nivel){
        super(nome, vida, forca, nivel);
    }
    
    //ficha sobrescrita do chefe
    @Override 
    public void ficha(){
        super.ficha();
        System.out.println(" [CHEFE] Rei Lich (vida: 200, forca: 20) ");
    }
    
    //habilidade sobrescrita do chefe
    @Override 
    public String habilidade(){
        return "ATAQUE DEVASTADOR!!!";
    }
}
