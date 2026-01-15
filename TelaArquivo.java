import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaArquivo extends JFrame implements ActionListener {
    
    private JButton jButtonExportar;
    private JButton jButtonSair; 

    public TelaArquivo() throws HeadlessException {
        setTitle("Configurações de Arquivo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); 
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Arquivos - Opções de Dados e Sistema", JLabel.CENTER);
        label.setBounds(10, 20, 380, 20);
        add(label);
        
        
        jButtonExportar = new JButton("Exportar Dados");
        jButtonExportar.setBounds(60, 150, 130, 30);
        jButtonExportar.setActionCommand("exportar");
        jButtonExportar.addActionListener(this);
        add(jButtonExportar);
        
        jButtonSair = new JButton("Sair");
        jButtonSair.setBounds(210, 150, 130, 30);
        jButtonSair.setActionCommand("sair");
        jButtonSair.addActionListener(this);
        add(jButtonSair);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if (comando.equals("exportar")) {
            JOptionPane.showMessageDialog(this, 
                "Exportação de dados para CSV/XML", 
                "Arquivo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Exportação de dados executada.");
            
        } else if (comando.equals("sair")) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Tem certeza que deseja fechar a aplicação?", "Sair do Sistema", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                System.out.println("Aplicação encerrada pelo usuário.");
                System.exit(0); 
            }
        }
    }
}
