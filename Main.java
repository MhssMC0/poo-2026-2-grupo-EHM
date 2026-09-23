/*
USO DE IA

Usamos IA para tirar duvidas sobre quase tudo relacionado a OO, Encapsulamento, Sobrecarga, Herança, polimorfismo
ArrayList, Sobrescrita com @Overraide Tratamento de Exceção, Interface gráfica e etc.

Demos uma olhada no nosso código anterior para ter um norte do que fazer.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //herois
        ArrayList<Personagem> herois = new ArrayList<>();

        //criacao valida dos herois protegida pelo try/catch
        try {
            herois.add(new Mago());
            herois.add(new Guerreiro());
            System.out.println("Heróis criados com sucesso!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Não foi possível criar um herói: " + ex.getMessage());
        }

        //criacao invalida para demonstrar o tratamento da excecao
        try {
            new Guerreiro("Heroi Invalido", -50, 20, 15);
        } catch (IllegalArgumentException ex) {
            System.out.println("Criação inválida capturada: " + ex.getMessage());
        }
    
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

        //menu simples para escolher um heroi, tratando entradas invalidas
        Scanner scanner = new Scanner(System.in);
        Personagem heroiEscolhido = escolherHeroi(scanner, herois);
        System.out.println("Herói escolhido: " + heroiEscolhido.getNome());

        //turno do Mago demonstrando a excecao de mana insuficiente
        Mago mago = (Mago) herois.get(0);
        mago.setMana(5);

        try {
            mago.lancarFeitico(chefe);
        } catch (SemManaException ex) {
            System.out.println("O Mago perdeu o turno: " + ex.getMessage());
            System.out.println("O Guerreiro vai atacar no lugar dele.");
            herois.get(1).atacar(chefe);
        } finally {
            System.out.println("fim do turno do Mago");
        }

        //turno do Guerreiro demonstrando uma segunda excecao de dominio
        Guerreiro guerreiro = (Guerreiro) herois.get(1);

        try {
            guerreiro.golpeEspecial(chefe);
        } catch (ForcaInsuficienteException ex) {
            System.out.println("Golpe especial não realizado: " + ex.getMessage());
            guerreiro.atacar(chefe);
        } finally {
            System.out.println("fim do turno do Guerreiro");
        }

        chefe.ficha();

        herois.get(0).showInventario();

        scanner.close();
    }

    //metodo do menu que continua ate receber uma opcao valida
    public static Personagem escolherHeroi(Scanner scanner, ArrayList<Personagem> herois) {
        while (true) {
            System.out.println("\n===== ESCOLHA UM HEROI =====");
            for (int i = 0; i < herois.size(); i++) {
                System.out.println((i + 1) + " - " + herois.get(i).getNome());
            }
            System.out.print("Digite o numero do heroi: ");

            try {
                int numero = Integer.parseInt(scanner.nextLine());
                return herois.get(numero - 1);
            } catch (NumberFormatException ex) {
                System.out.println("digite um número!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Esse herói não existe. Escolha um número da lista.");
            }
        }
    }
}
