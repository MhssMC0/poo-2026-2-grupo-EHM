public class Item{

    private String nome;
    private int bonus;

    public Item(String nome, int bonus) {
        setNome(nome);
        setBonus(bonus);
        
    }

     public String getNome(){
        return nome;
    }

     public void setNome(String nome){
        if(nome == null || nome.isEmpty()){
            System.out.println("Erro, nome vazio.");
            return;
        }
        this.nome = nome;
     }

     public int getBonus(){
        return bonus;
    }

    public void setBonus(int bonus){
        if(bonus < 1){
            System.out.println("Bonus invalido.");
            return;
        }
        this.bonus = bonus;
    }
    
    public void descricao (){
        System.out.println(nome + " (" +"+"+ bonus +")");
        System.out.println();
        System.out.println();
     }



}