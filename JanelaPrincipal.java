import projeto.cadastros.TelaLivros;
import projeto.cadastros.TelaUsuarios;
import projeto.ferramentas.TelaFerramentas;
import projeto.movimentacao.TelaDevolucao;
import projeto.movimentacao.TelaEmprestimo;
import projeto.pesquisa.TelaPesquisa;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import projeto.ajuda.TelaAjuda;
import projeto.arquivo.TelaArquivo;

public class JanelaPrincipal extends JFrame implements ActionListener {
    private JMenuBar jMenuBar;
    
    private JMenu jMenuArquivos;
    private JMenu jMenuCadastros;
    private JMenu jMenuMovimentacao;
    private JMenu jMenuConsulta;
    private JMenu jMenuFerramenta;
    private JMenu jMenuAjuda;
    
    private JMenuItem jMenuItemCadastroU;
    private JMenuItem jMenuItemCadastroL;
    private JMenuItem jMenuItemEmprestimo;
    private JMenuItem jMenuItemDevolucao;

    public JanelaPrincipal() throws HeadlessException {
        
        setTitle("Sistema de Biblioteca");
        setSize(920, 540);
        
        setLayout(null);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jMenuBar = new JMenuBar();
        jMenuBar.setBounds(0, 0, 960, 25);
        add(jMenuBar);
        
        jMenuArquivos = new JMenu("Arquivos");
        jMenuBar.add(jMenuArquivos);
        
        jMenuCadastros = new JMenu("Cadastros");
        jMenuBar.add(jMenuCadastros);
        
        jMenuMovimentacao = new JMenu("Movimentações");
        jMenuBar.add(jMenuMovimentacao);
        
        jMenuConsulta = new JMenu("Pesquisa");
        jMenuBar.add(jMenuConsulta);
        
        jMenuFerramenta = new JMenu("Ferramentas");
        jMenuBar.add(jMenuFerramenta);
        
        jMenuAjuda = new JMenu("Ajuda");
        jMenuBar.add(jMenuAjuda);
        
        jMenuItemCadastroU = new JMenuItem("Cadastro de Usuário");
        jMenuItemCadastroU.setActionCommand("cadUsuario");
        jMenuItemCadastroU.addActionListener(this);
        jMenuCadastros.add(jMenuItemCadastroU);
        
        jMenuItemCadastroL = new JMenuItem("Cadastro de Livro");
        jMenuItemCadastroL.setActionCommand("cadLivro");
        jMenuItemCadastroL.addActionListener(this);
        jMenuCadastros.add(jMenuItemCadastroL);
        
        jMenuItemEmprestimo = new JMenuItem("Empréstimos");
        jMenuItemEmprestimo.setActionCommand("emprestimo");
        jMenuItemEmprestimo.addActionListener(this);
        jMenuMovimentacao.add(jMenuItemEmprestimo);
        
        jMenuItemDevolucao = new JMenuItem("Devolução");
        jMenuItemDevolucao.setActionCommand("devolucao");
        jMenuItemDevolucao.addActionListener(this);
        jMenuMovimentacao.add(jMenuItemDevolucao);
        
        JMenuItem menuConsulta = new JMenuItem("Pesquisar Livros");
        menuConsulta.setActionCommand("consulta");
        menuConsulta.addActionListener(this);
        jMenuConsulta.add(menuConsulta);

        JMenuItem menuFerramentas = new JMenuItem("Ferramentas");
        menuFerramentas.setActionCommand("ferramentas");
        menuFerramentas.addActionListener(this);
        jMenuFerramenta.add(menuFerramentas);

        JMenuItem menuArquivo = new JMenuItem("Arquivo");
        menuArquivo.setActionCommand("arquivo");
        menuArquivo.addActionListener(this);
        jMenuArquivos.add(menuArquivo);

        JMenuItem menuAjuda = new JMenuItem("Ajuda");
        menuAjuda.setActionCommand("ajuda");
        menuAjuda.addActionListener(this);
        jMenuAjuda.add(menuAjuda);
        
        setLocationRelativeTo(null);
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {

            case "cadUsuario":
                new TelaUsuarios();
                break;

            case "cadLivro":
                new TelaLivros();
                break;

            case "emprestimo":
                new TelaEmprestimo();
                break;

            case "devolucao":
                new TelaDevolucao();
                break;

            case "consulta":
                new TelaPesquisa();
                break;

            case "ferramentas":
                new TelaFerramentas();
                break;

            case "arquivo":
                new TelaArquivo();
                break;

            case "ajuda":
                new TelaAjuda();
                break;
        }
    }
}
