package InterfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class InterfaceJogo {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private AtorJogador atorJogador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceJogo window = new InterfaceJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceJogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		atorJogador = new AtorJogador();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1279, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Iniciar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmConectar = new JMenuItem("Conectar");
		mntmConectar.setAction(action);
		mnNewMenu.add(mntmConectar);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mntmDesconectar.setAction(action_1);
		mnNewMenu.add(mntmDesconectar);
		
		JMenuItem mntmIniciarPartida = new JMenuItem("Iniciar Partida");
		mntmIniciarPartida.setAction(action_2);
		mnNewMenu.add(mntmIniciarPartida);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmIniciarPartida.setAction(action_3);
		mnNewMenu.add(mntmSair);
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Conectar");
			putValue(SHORT_DESCRIPTION, "Conectar ao Servidor Netgames");
		}
		public void actionPerformed(ActionEvent e) {
			// Necessário definir endereço do servidor e nome do jogador
			String mensagem = atorJogador.conectar("localhost", "nomeJogador?");
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Desconectar");
			putValue(SHORT_DESCRIPTION, "Desconectar do servidor Netgames");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.desconectar();
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "Iniciar Partida");
			putValue(SHORT_DESCRIPTION, "Iniciar Partida do seu Jogo");
		}
		public void actionPerformed(ActionEvent e) {
			String mensagem = atorJogador.iniciarPartida();
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_3() {
//			putValue(NAME, "Sair");
//			putValue(SHORT_DESCRIPTION, "Saindo do Jogo");
		}
		public void actionPerformed(ActionEvent e) {
			//Fechar programa
			JOptionPane.showMessageDialog(null, "Saindo do Jogo");
			System.exit(0);
		}
	}
}
