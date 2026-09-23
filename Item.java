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
            System.out.println("Erro, nome vazio.");
            return;
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
            System.out.println("Bonus invalido.");
            return;
        }
        this.bonus = bonus;
    }
    
    //metodo para mostrar a descricao completa do item, com nome e o bonus
    public void descricao (){
        System.out.println(nome + " (" +"+"+ bonus +")");
     }



}