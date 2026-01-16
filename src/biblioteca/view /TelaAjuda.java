import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaAjuda extends JFrame implements ActionListener {

    private JButton jButtonSobre;
    private JButton jButtonSuporte;
    private JButton jButtonTermos;

    public TelaAjuda() throws HeadlessException {
        setTitle("Ajuda do Sistema");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Informações de Apoio e Versão do Sistema", JLabel.CENTER);
        label.setBounds(10, 20, 380, 20);
        add(label);
        
        jButtonSobre = new JButton("Sobre");
        jButtonSobre.setBounds(30, 150, 115, 30);
        jButtonSobre.setActionCommand("sobre");
        jButtonSobre.addActionListener(this);
        add(jButtonSobre);
        
        jButtonSuporte = new JButton("Suporte");
        jButtonSuporte.setBounds(145, 150, 100, 30);
        jButtonSuporte.setActionCommand("suporte");
        jButtonSuporte.addActionListener(this);
        add(jButtonSuporte);
        
        jButtonTermos = new JButton("Termos");
        jButtonTermos.setBounds(255, 150, 115, 30);
        jButtonTermos.setActionCommand("termos");
        jButtonTermos.addActionListener(this);
        add(jButtonTermos);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if (comando.equals("sobre")) {
            JOptionPane.showMessageDialog(this, 
                "Sistema de Gerenciamento de Biblioteca (SGB)\nVersão: 1.0 \nAutor: Jeniffer Leme", 
                "Sobre o SGB", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Detalhes da versão exibidos.");
            
        } else if (comando.equals("suporte")) {
            JOptionPane.showMessageDialog(this, 
                "Para suporte, entre em contato:\nEmail: suporte@biblioteca.com\nTelefone: (XX) 9999-9999", 
                "Suporte Técnico", JOptionPane.QUESTION_MESSAGE);
            System.out.println("Informações de contato exibidas.");
            
        } else if (comando.equals("termos")) {
            JOptionPane.showMessageDialog(this, 
                "Abertura do documento 'Termos e Condições de Uso do Software'.", 
                "Documentos Legais", JOptionPane.WARNING_MESSAGE);
            System.out.println("Termos de Uso executada.");
        }
    }
}
