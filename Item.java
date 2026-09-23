public class Item{

    private String nome;
    private int bonus;

    //construtor da classe item
    public Item(String nome, int bonus) {
        setNome(nome);
        setBonus(bonus);
        
    }

    //metodo para retornar o nome do item
     public String getNome(){
        return nome;
    }

    //metodo para definir o nome do item
     public void setNome(String nome){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome do item não pode ser vazio.");
        }
        this.nome = nome;
     }

     //metodo para retornar o bonus do item
     public int getBonus(){
        return bonus;
    }

    //metodo para definir o bonus do item
    public void setBonus(int bonus){
        if(bonus < 1){
            throw new IllegalArgumentException("O bônus deve ser maior ou igual a 1. Valor recebido: " + bonus + ".");
        }
        this.bonus = bonus;
    }
    
    //metodo para mostrar a descricao completa do item, com nome e o bonus
    public void descricao (){
        System.out.println(nome + " (" +"+"+ bonus +")");
     }
}
