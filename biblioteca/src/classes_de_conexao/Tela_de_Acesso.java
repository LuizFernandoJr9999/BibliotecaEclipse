package classes_de_conexao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_de_Acesso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JTextField jtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Acesso frame = new Tela_de_Acesso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_de_Acesso() {
		getContentPane().setLayout(null);
		
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(76, 91, 101, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 255));
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSenha.setBounds(86, 158, 101, 57);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setBounds(174, 91, 144, 41);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pfSenha.setBounds(174, 158, 144, 41);
		contentPane.add(pfSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Connection con = Conexao.faz_conexao();
					
					String sql = "select * from dados_senha where usuario = ? and senha = ?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
										
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String (pfSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						
						Tela_cadastro_livro exibir = new Tela_cadastro_livro();
						exibir.setVisible(true);
						setVisible(false);
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto!!!");
						
					}
					
					stmt.close();
					
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(174, 256, 144, 41);
		contentPane.add(btnNewButton);
	}
}
