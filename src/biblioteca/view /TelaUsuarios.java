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

public class TelaUsuarios extends JFrame implements ActionListener {
    private JLabel jLabelNome;
    private JLabel jLabelMatricula;
    private JLabel jLabelTelefone;
    private JLabel jLabelEmail;
    private JLabel jLabelTipo;
    
    private JTextField jTextFiledNome;
    private JTextField jTextFiledMatricula;
    private JTextField jTextFiledTelefone;
    private JTextField jTextFiledEmail;
    private JTextField jTextFiledTipo;
    
    private JButton jButtonSalvar;
    private JButton jButtonCancelar;

    public TelaUsuarios() throws HeadlessException {
        setTitle("Cadastro de Usuários");
        setSize(500, 380);
        
        setLayout(null);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(20, 20, 450, 260);
        painel.setBorder(new TitledBorder("Dados do Usuário"));
        add(painel);

        Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 14);
        
        
        jLabelNome = new JLabel("Nome:");
        jLabelNome.setFont(fonteLabel);
        jLabelNome.setBounds(30, 35, 100, 25);
        painel.add(jLabelNome);

        jTextFiledNome = new JTextField();
        jTextFiledNome.setBounds(130, 35, 250, 25);
        painel.add(jTextFiledNome);

        jLabelMatricula = new JLabel("ID:");
        jLabelMatricula.setFont(fonteLabel);
        jLabelMatricula.setBounds(30, 75, 100, 25);
        painel.add(jLabelMatricula);

        jTextFiledMatricula = new JTextField();
        jTextFiledMatricula.setBounds(130, 75, 250, 25);
        painel.add(jTextFiledMatricula);

        jLabelTelefone = new JLabel("Telefone:");
        jLabelTelefone.setFont(fonteLabel);
        jLabelTelefone.setBounds(30, 115, 100, 25);
        painel.add(jLabelTelefone);

        jTextFiledTelefone = new JTextField();
        jTextFiledTelefone.setBounds(130, 115, 250, 25);
        painel.add(jTextFiledTelefone);

        jLabelEmail = new JLabel("Email:");
        jLabelEmail.setFont(fonteLabel);
        jLabelEmail.setBounds(30, 155, 100, 25);
        painel.add(jLabelEmail);

        jTextFiledEmail = new JTextField();
        jTextFiledEmail.setBounds(130, 155, 250, 25);
        painel.add(jTextFiledEmail);

        jLabelTipo = new JLabel("Tipo Usuário:");
        jLabelTipo.setFont(fonteLabel);
        jLabelTipo.setBounds(30, 195, 100, 25);
        painel.add(jLabelTipo);

        jTextFiledTipo = new JTextField();
        jTextFiledTipo.setBounds(130, 195, 250, 25);
        painel.add(jTextFiledTipo);
        
        jButtonSalvar = new JButton("Salvar");
        jButtonSalvar.setBackground(new Color(34, 197, 94));
        jButtonSalvar.setForeground(Color.WHITE);
        jButtonSalvar.setBounds(150, 295, 90, 30);
        jButtonSalvar.setActionCommand("salvar");
        jButtonSalvar.addActionListener(this); 
        add(jButtonSalvar);

        jButtonCancelar = new JButton("Cancelar");
        jButtonCancelar.setBackground(new Color(158, 158, 158));
        jButtonCancelar.setForeground(Color.WHITE);
        jButtonCancelar.setBounds(260, 295, 90, 30);
        jButtonCancelar.setActionCommand("cancelar");
        jButtonCancelar.addActionListener(this); 
        add(jButtonCancelar);

        setLocationRelativeTo(null);
        
        setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("salvar")) {
            String nome = jTextFiledNome.getText();
            String id = jTextFiledMatricula.getText();

            if (nome.isEmpty() || id.isEmpty()) {
                 JOptionPane.showMessageDialog(this, 
                    "Preencha Nome e ID para cadastrar!", 
                    "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            } else {
                String mensagem = String.format("Usuário '%s' (ID: %s) cadastrado com sucesso!", nome, id);
                JOptionPane.showMessageDialog(this, mensagem, "Cadastro Efetuado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("USUÁRIO CADASTRADO: " + nome + " (ID: " + id + ")");
                this.dispose();
            }
        } else if (e.getActionCommand().equals("cancelar")) {
            this.dispose();
        }
    }
}
