import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaFerramentas extends JFrame implements ActionListener {

    private JButton jButtonBackup;
    private JButton jButtonLimparLogs; 

    public TelaFerramentas() throws HeadlessException {
        setTitle("Ferramentas do Sistema");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Ferramentas - Manutenção e Administração", JLabel.CENTER);
        label.setBounds(10, 20, 380, 20);
        add(label);
        
        jButtonBackup = new JButton("Fazer Backup");
        jButtonBackup.setBounds(40, 150, 160, 30);
        jButtonBackup.setActionCommand("backup");
        jButtonBackup.addActionListener(this);
        add(jButtonBackup);
        
        jButtonLimparLogs = new JButton("Limpar Logs");
        jButtonLimparLogs.setBounds(210, 150, 150, 30);
        jButtonLimparLogs.setActionCommand("limpar_logs");
        jButtonLimparLogs.addActionListener(this);
        add(jButtonLimparLogs);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if (comando.equals("backup")) {
            JOptionPane.showMessageDialog(this, 
                "Backup de Dados do Sistema executado com sucesso!", 
                "Ferramentas - Backup", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Backup de dados executado.");
            
        } else if (comando.equals("limpar_logs")) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Deseja realmente limpar todos os logs do sistema?", "Confirmação", 
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, 
                    "Logs de atividade removidos!", 
                    "Ferramentas - Logs", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
