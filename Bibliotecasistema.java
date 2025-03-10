/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecasistema;

/**
 *
 * @author Elise
 */
/*public class Bibliotecasistema {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
    
//}




import java.util.ArrayList;
import javax.swing.*;

public class Bibliotecasistema extends JPanel {

    private ArrayList<Livro> livros = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    private JButton jButtonAdicionar;
    private JLabel jLabel1, jLabel2, jLabel3;
    private JList<String> jListLivros;
    private JScrollPane jScrollPane1;
    private JTextField jTextFieldAno, jTextFieldAutor, jTextFieldTitulo;

    public Bibliotecasistema() {
        initComponents();
        jListLivros.setModel(listModel);
    }

    private void initComponents() {
        jLabel1 = new JLabel("Título:");
        jLabel2 = new JLabel("Autor:");
        jLabel3 = new JLabel("Ano de Publicação:");
        
        jTextFieldTitulo = new JTextField(20);
        jTextFieldAutor = new JTextField(20);
        jTextFieldAno = new JTextField(10);
        
        jButtonAdicionar = new JButton("Adicionar Livro");
        jButtonAdicionar.addActionListener(evt -> jButtonAdicionarActionPerformed());

        jListLivros = new JList<>();
        jScrollPane1 = new JScrollPane(jListLivros);

        // Layout do painel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(jLabel1);
        add(jTextFieldTitulo);
        add(jLabel2);
        add(jTextFieldAutor);
        add(jLabel3);
        add(jTextFieldAno);
        add(jButtonAdicionar);
        add(jScrollPane1);
    }

    private void jButtonAdicionarActionPerformed() {
        String titulo = jTextFieldTitulo.getText();
        String autor = jTextFieldAutor.getText();
        int ano = Integer.parseInt(jTextFieldAno.getText());

        Livro livro = new Livro(titulo, autor, ano);
        livros.add(livro);
        listModel.addElement(livro.toString());

        jTextFieldTitulo.setText("");
        jTextFieldAutor.setText("");
        jTextFieldAno.setText("");
    }

    // Método para retornar o painel e adicioná-lo a um JFrame
    public JPanel getPanel() {
        return this;
    }

    // Teste do JPanel dentro de um JFrame
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new Bibliotecasistema());
        frame.setVisible(true);
    }
}