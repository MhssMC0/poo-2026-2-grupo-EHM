/*
USO DE IA

Usamos IA para tirar duvidas sobre quase tudo relacionado a OO, Encapsulamento, Sobrecarga, Herança, polimorfismo
ArrayList, Sobrescrita com @Overraide Tratamento de Exceção, Interface gráfica e etc.

Demos uma olhada no nosso código anterior para ter um norte do que fazer.
*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //herois
        ArrayList<Personagem> herois = new ArrayList<>();
        herois.add(new Mago());
        herois.add(new Guerreiro());
    
        //chefe
        Personagem chefe = new Chefe();

        //itens
        Item arco = new Item("Arco", 10 );
        Item espada = new Item("Espada", 20 ); 

        herois.get(0).addItem(arco);
        herois.get(1).addItem(espada);

        chefe.ficha();

        for(Personagem heroi : herois){
            heroi.ficha();

            System.out.println(heroi.getNome() + " usa " + heroi.habilidade());

            heroi.atacar(chefe);
        }      

        chefe.ficha();

        herois.get(0).showInventario();
        
        
        
    }
}
