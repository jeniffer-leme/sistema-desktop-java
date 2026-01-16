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

public class TelaEmprestimo extends JFrame implements ActionListener { 

    private JLabel jLabelUsuario;
    private JLabel jLabelLivro;
    private JLabel jLabelDataPrevista;
    
    private JTextField jTextFiledUsuario;
    private JTextField jTextFiledLivro;
    private JTextField jTextFiledDataPrevista;
    
    private JButton jButtonConfirmar;
    private JButton jButtonLimpar;

    public TelaEmprestimo() throws HeadlessException {
        setTitle("Realizar Empréstimo");
        setSize(500, 300);
        
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(20, 20, 450, 180);
        painel.setBorder(new TitledBorder("Dados do Empréstimo"));
        add(painel);

        Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 14);
        
        jLabelUsuario = new JLabel("ID Usuário:");
        jLabelUsuario.setFont(fonteLabel);
        jLabelUsuario.setBounds(30, 35, 150, 25);
        painel.add(jLabelUsuario);

        jTextFiledUsuario = new JTextField();
        jTextFiledUsuario.setBounds(190, 35, 200, 25);
        painel.add(jTextFiledUsuario);

        jLabelLivro = new JLabel("ID Livro:");
        jLabelLivro.setFont(fonteLabel);
        jLabelLivro.setBounds(30, 75, 150, 25);
        painel.add(jLabelLivro);

        jTextFiledLivro = new JTextField();
        jTextFiledLivro.setBounds(190, 75, 200, 25);
        painel.add(jTextFiledLivro);

        jLabelDataPrevista = new JLabel("Devolução Prevista (DD/MM):");
        jLabelDataPrevista.setFont(fonteLabel);
        jLabelDataPrevista.setBounds(30, 115, 200, 25);
        painel.add(jLabelDataPrevista);

        jTextFiledDataPrevista = new JTextField();
        jTextFiledDataPrevista.setBounds(230, 115, 160, 25);
        painel.add(jTextFiledDataPrevista);
        
        jButtonConfirmar = new JButton("Confirmar");
        jButtonConfirmar.setBackground(new Color(34, 197, 94));
        jButtonConfirmar.setForeground(Color.WHITE);
        jButtonConfirmar.setBounds(140, 220, 100, 30);
        jButtonConfirmar.setActionCommand("confirmar");
        jButtonConfirmar.addActionListener(this); 
        add(jButtonConfirmar);

        jButtonLimpar = new JButton("Limpar");
        jButtonLimpar.setBackground(new Color(158, 158, 158));
        jButtonLimpar.setForeground(Color.WHITE);
        jButtonLimpar.setBounds(260, 220, 100, 30);
        jButtonLimpar.setActionCommand("limpar");
        jButtonLimpar.addActionListener(this); 
        add(jButtonLimpar);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("confirmar")) {
            String idUsuario = jTextFiledUsuario.getText();
            String idLivro = jTextFiledLivro.getText();
            String dataPrevista = jTextFiledDataPrevista.getText();
            
            if (idUsuario.isEmpty() || idLivro.isEmpty()) {
                JOptionPane.showMessageDialog(this, "IDs de Usuário e Livro são obrigatórios.", 
                    "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Empréstimo de Livro ID: " + idLivro + " para Usuário ID: " + idUsuario + " confirmado! Devolução: " + dataPrevista, 
                    "Empréstimo Efetuado", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("EMPRÉSTIMO: Usuário: " + idUsuario + ", Livro: " + idLivro);
                this.dispose(); 
            }
        } else if (comando.equals("limpar")) {
            jTextFiledUsuario.setText("");
            jTextFiledLivro.setText("");
            jTextFiledDataPrevista.setText("");
            System.out.println("Campos de empréstimo limpos.");
        }
    }
}
