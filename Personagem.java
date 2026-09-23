import java.util.ArrayList;

public abstract class Personagem {
    private String nome;
    private int vida;
    private int forca;
    private int nivel;
    private int bonus;
    private ArrayList<Item> inventario = new ArrayList<>();

    //metodo abstrato de habilidade
    public abstract String habilidade();

    // set da vida
    public void setVida(int vida) {
        if (vida < 0 || vida > 999) {
            throw new IllegalArgumentException("A vida deve estar entre 0 e 999. Valor recebido: " + vida + ".");
        }
        this.vida = vida;
    }

    // get da vida
    public int getVida() {
        return vida;
    }

    // set do nome
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    // get do nome
    public String getNome() {
        return nome;
    }

    // set da força
    public void setForca(int forca) {
        if (forca < 1) {
            throw new IllegalArgumentException("A força deve ser maior ou igual a 1. Valor recebido: " + forca + ".");
        }
        this.forca = forca;
    }

    // get da forca
    public int getForca() {
        return forca;
    }

    // set do nivel
    public void setNivel(int nivel) {
        if (nivel < 1) {
            throw new IllegalArgumentException("O nível deve ser maior ou igual a 1. Valor recebido: " + nivel + ".");
        }
        this.nivel = nivel;
    }

    // get do nivel
    public int getNivel() {
        return nivel;
    }

    // construtor com parametros
    public Personagem(String nome, int vida, int forca, int nivel) {
        setNome(nome);
        setVida(vida);
        setForca(forca);
        setNivel(nivel);
    }

    // cnstrutor padrão
    public Personagem() {
        this.nome = "Vladimir";
        this.vida = 100;
        this.forca = 20;
        this.nivel = 10;
    }

    // metodo para o personagem receber dano
    public void receberDano(int dano) {
        this.vida -= (dano + bonus);

        if (vida < 0) {
            vida = 0;
        }
    }

    // metodo padrão para atacar
    public void atacar(Personagem alvo) {
        System.out.println(nome + " atacou " + alvo.getNome() + " causando " + (forca + bonus) + " de dano!");
        alvo.receberDano(forca + bonus);
    }

    // metado para adicionar item na lista
    public void addItem(Item item) {
        this.inventario.add(item);
    }

    // metodo para atacar
    public void atacar(Personagem alvo, int dano) {
        System.out.println(nome + " atacou " + alvo.getNome() + " causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }

    // metodo para ver se o personagem está vivo
    public boolean estaVivo() {
        if (vida == 0) {
            System.out.println(this.nome + " Morreu!");
            return false;
        }

        System.out.println(this.nome + " Esta vivo!");
        return true;
    }

    //mostra o inventario
    public void showInventario() {
        System.out.println("============================== Inventario ==============================");
        for (Item i : inventario) {
            i.descricao();
        }
        System.out.println("==============================");
    }

    //adicionar bonus a força do personagem
    public void addBonus(Item bonus){
        this.bonus = bonus.getBonus();
    }

    // metodo para mostrar a ficha dos objetos/personagens
    public void ficha() {
        System.out.println("\n" + "=====FICHA=====");
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Forca: " + (getForca() + bonus));
        System.out.println("Nivel: " + getNivel() + "\n");
    }
}
