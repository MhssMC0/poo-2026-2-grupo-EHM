import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCriacaoHeroi extends JFrame {

    private JLabel titulo;
    private JTextField campoNome;
    private JTextField campoVida;
    private JTextField campoClasse;
    private JLabel mensagem;
    private JButton botaoCriar;

    //construtor da tela de criacao de heroi
    public TelaCriacaoHeroi() {
        super("IF Quest");
        setSize(450, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        //titulo da tela
        titulo = new JLabel("Criação de Herói", JLabel.CENTER);
        titulo.setText("Criação de Herói - IF Quest");
        add(titulo, BorderLayout.NORTH);

        //painel central organizado com GridLayout
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));

        painelCampos.add(new JLabel("Nome do herói:"));
        campoNome = new JTextField();
        painelCampos.add(campoNome);

        painelCampos.add(new JLabel("Vida inicial:"));
        campoVida = new JTextField();
        painelCampos.add(campoVida);

        painelCampos.add(new JLabel("Classe do herói:"));
        campoClasse = new JTextField();
        painelCampos.add(campoClasse);

        add(painelCampos, BorderLayout.CENTER);

        //mensagem de sucesso fica na parte inferior junto do botao
        JPanel painelInferior = new JPanel(new BorderLayout());
        mensagem = new JLabel(" ", JLabel.CENTER);
        painelInferior.add(mensagem, BorderLayout.CENTER);

        botaoCriar = new JButton("Criar Herói");
        painelInferior.add(botaoCriar, BorderLayout.SOUTH);
        add(painelInferior, BorderLayout.SOUTH);

        //o botao foi desabilitado no inicio na aula anterior; nesta aula ele precisa
        //ficar habilitado para que o modelo de eventos possa ser demonstrado.
        botaoCriar.setEnabled(true);

        //registrando o ouvinte do botao
        botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarHeroi();
            }
        });

        //o Enter pressionado no campo Vida tambem dispara o mesmo evento
        campoVida.addActionListener(e -> criarHeroi());
    }

    //metodo chamado pelo evento do botao e do campo Vida
    public void criarHeroi() {
        botaoCriar.setEnabled(false);

        try {
            String nome = campoNome.getText();
            int vida = Integer.parseInt(campoVida.getText());

            //quem decide se a vida e valida e o proprio Guerreiro, no setVida, e nao a tela.
            Guerreiro guerreiro = new Guerreiro();
            guerreiro.setNome(nome);
            guerreiro.setVida(vida);

            mensagem.setText("Herói criado: " + guerreiro.getNome() + " - Vida: " + guerreiro.getVida());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vida deve ser um número!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            botaoCriar.setEnabled(true);
        }
    }

    //segunda versao da tela usando FlowLayout.
    //A primeira versao usa BorderLayout + GridLayout e organiza os campos em uma grade.
    //A segunda usa FlowLayout e deixa os componentes em fluxo, ficando mais simples,
    //mas com menos controle sobre o alinhamento dos campos.
    public static void mostrarVersaoFlowLayout() {
        JFrame segundaTela = new JFrame("IF Quest - Versão FlowLayout");
        segundaTela.setSize(450, 180);
        segundaTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        segundaTela.setLayout(new FlowLayout());

        segundaTela.add(new JLabel("Criação de Herói"));
        segundaTela.add(new JLabel("Nome:"));
        segundaTela.add(new JTextField(10));
        segundaTela.add(new JLabel("Vida:"));
        segundaTela.add(new JTextField(5));
        segundaTela.add(new JLabel("Classe:"));
        segundaTela.add(new JTextField(8));
        segundaTela.add(new JButton("Criar Herói"));

        segundaTela.setVisible(true);
    }

    public static void main(String[] args) {
        TelaCriacaoHeroi tela = new TelaCriacaoHeroi();
        tela.setVisible(true);
    }
}
