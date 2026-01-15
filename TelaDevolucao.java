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

public class TelaDevolucao extends JFrame implements ActionListener {

    private JLabel jLabelEmprestimoId;
    private JTextField jTextFiledEmprestimoId;
    
    private JButton jButtonDevolver;
    private JButton jButtonCancelar;

    public TelaDevolucao() throws HeadlessException {
        setTitle("Realizar Devolução");
        setSize(400, 200);
        
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(20, 20, 350, 70);
        painel.setBorder(new TitledBorder("Devolução"));
        add(painel);

        Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 14);
        
        jLabelEmprestimoId = new JLabel("ID Livro:");
        jLabelEmprestimoId.setFont(fonteLabel);
        jLabelEmprestimoId.setBounds(10, 30, 150, 25);
        painel.add(jLabelEmprestimoId);

        jTextFiledEmprestimoId = new JTextField();
        jTextFiledEmprestimoId.setBounds(150, 30, 180, 25);
        painel.add(jTextFiledEmprestimoId);
        
        jButtonDevolver = new JButton("Devolver");
        jButtonDevolver.setBackground(new Color(255, 87, 34));
        jButtonDevolver.setForeground(Color.WHITE);
        jButtonDevolver.setBounds(90, 110, 100, 30);
        jButtonDevolver.setActionCommand("devolver");
        jButtonDevolver.addActionListener(this); 
        add(jButtonDevolver);

        jButtonCancelar = new JButton("Cancelar");
        jButtonCancelar.setBackground(new Color(158, 158, 158));
        jButtonCancelar.setForeground(Color.WHITE);
        jButtonCancelar.setBounds(210, 110, 100, 30);
        jButtonCancelar.setActionCommand("cancelar");
        jButtonCancelar.addActionListener(this); 
        add(jButtonCancelar);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("devolver")) {
            String idLivro = jTextFiledEmprestimoId.getText();

            if (idLivro.isEmpty()) {
                 JOptionPane.showMessageDialog(this, 
                    "Informe o ID do Livro para realizar a devolução.", 
                    "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            } else {
                String mensagem = String.format("Devolução do Livro ID: %s realizada com sucesso!", idLivro);
                JOptionPane.showMessageDialog(this, mensagem, "Devolução Efetuada", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("DEVOLUÇÃO REGISTRADA: Livro ID: " + idLivro);
                this.dispose();
            }

        } else if (e.getActionCommand().equals("cancelar")) {
            this.dispose(); 
        }
    }
}
