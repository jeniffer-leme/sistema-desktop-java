import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TelaLivros extends JFrame implements ActionListener { 
    private JLabel jLabelTitulo;
    private JLabel jLabelAutor;
    private JLabel jLabelAno;
    private JLabel jLabelGenero;
    private JLabel jLabelEditora;
    private JLabel jLabelId;

    private JTextField jTextFiledTitulo;
    private JTextField jTextFiledAutor;
    private JTextField jTextFiledAno;
    private JTextField jTextFiledGenero;
    private JTextField jTextFiledEditora;
    private JTextField jTextFiledId;

    private JButton jButtonSalvar;
    private JButton jButtonCancelar;


    public TelaLivros() throws HeadlessException {
        setTitle("Cadastro de Livros");
        setSize(500, 430);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(20, 20, 450, 310);
        painel.setBorder(new TitledBorder("Dados do Livro"));
        add(painel);
        
        Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 14);

        jLabelTitulo = new JLabel("Título:");
        jLabelTitulo.setFont(fonteLabel);
        jLabelTitulo.setBounds(30, 35, 100, 25);
        painel.add(jLabelTitulo);
        jTextFiledTitulo = new JTextField();
        jTextFiledTitulo.setBounds(130, 35, 250, 25);
        painel.add(jTextFiledTitulo);

        jLabelAutor = new JLabel("Autor:");
        jLabelAutor.setFont(fonteLabel);
        jLabelAutor.setBounds(30, 75, 100, 25);
        painel.add(jLabelAutor);
        jTextFiledAutor = new JTextField();
        jTextFiledAutor.setBounds(130, 75, 250, 25);
        painel.add(jTextFiledAutor);

        jLabelAno = new JLabel("Ano:");
        jLabelAno.setFont(fonteLabel);
        jLabelAno.setBounds(30, 115, 100, 25);
        painel.add(jLabelAno);
        jTextFiledAno = new JTextField();
        jTextFiledAno.setBounds(130, 115, 250, 25);
        painel.add(jTextFiledAno);

        jLabelGenero = new JLabel("Gênero:");
        jLabelGenero.setFont(fonteLabel);
        jLabelGenero.setBounds(30, 155, 100, 25);
        painel.add(jLabelGenero);
        jTextFiledGenero = new JTextField();
        jTextFiledGenero.setBounds(130, 155, 250, 25);
        painel.add(jTextFiledGenero);

        jLabelEditora = new JLabel("Editora:");
        jLabelEditora.setFont(fonteLabel);
        jLabelEditora.setBounds(30, 195, 100, 25);
        painel.add(jLabelEditora);
        jTextFiledEditora = new JTextField();
        jTextFiledEditora.setBounds(130, 195, 250, 25);
        painel.add(jTextFiledEditora);

        jLabelId = new JLabel("ID:");
        jLabelId.setFont(fonteLabel);
        jLabelId.setBounds(30, 235, 100, 25);
        painel.add(jLabelId);
        jTextFiledId = new JTextField();
        jTextFiledId.setBounds(130, 235, 250, 25);
        painel.add(jTextFiledId);

        jButtonSalvar = new JButton("Salvar");
        jButtonSalvar.setBackground(new Color(34, 197, 94));
        jButtonSalvar.setForeground(Color.WHITE);
        jButtonSalvar.setBounds(150, 350, 90, 30);
        jButtonSalvar.setActionCommand("salvar"); 
        jButtonSalvar.addActionListener(this); 
        add(jButtonSalvar);

        jButtonCancelar = new JButton("Cancelar");
        jButtonCancelar.setBackground(new Color(158, 158, 158));
        jButtonCancelar.setForeground(Color.WHITE);
        jButtonCancelar.setBounds(260, 350, 90, 30);
        jButtonCancelar.setActionCommand("cancelar"); 
        jButtonCancelar.addActionListener(this); 
        add(jButtonCancelar);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("salvar")) {
            String titulo = jTextFiledTitulo.getText();
            String autor = jTextFiledAutor.getText();
            String id = jTextFiledId.getText();

            if (titulo.isEmpty() || autor.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Preencha Título, Autor e ID para cadastrar!", 
                    "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            } else {
                String mensagem = String.format("Livro '%s' (ID: %s) cadastrado com sucesso!", titulo, id);
                JOptionPane.showMessageDialog(this, mensagem, "Cadastro Efetuado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("LIVRO CADASTRADO: " + titulo + " por " + autor);
                this.dispose(); 
            }

        } else if (e.getActionCommand().equals("cancelar")) {
            this.dispose(); 
        }
    }
}
