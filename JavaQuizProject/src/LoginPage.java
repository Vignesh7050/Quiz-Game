
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Image;

import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class LoginPage {

	public static JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static Scanner sc;
	private JLabel lblNewLabel;
	private JButton btnClose;
	private JLabel lblUsername;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	public LoginPage() throws SQLException
	{
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2QFGJPI","sa","");
			stmt = con.createStatement();
		    stmt.executeUpdate("use quiz");
		}
		catch(ClassNotFoundException e){
			System.out.println("Unable to load the driver!!");
			e.printStackTrace();
			System.exit(1);
		}
		catch(SQLException e){
			System.out.println("Cannot connect to the database !");
			System.exit(1);
		}
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		initialize();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					LoginPage.frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

   public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 9));
		frame.setResizable(false);
		frame.getContentPane().setForeground(new Color(211, 211, 211));
		frame.setBackground(new Color(0, 0, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(340, 110, 702, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setForeground(new Color(30, 144, 255));
		panel.setBackground(new Color(0, 0, 205));
		panel.setBounds(0, 0, 263, 444);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/loginpage2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(35, 91, 200, 250);
		panel.add(lblNewLabel_1);
		
		lblUsername = new JLabel("username");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setAutoscrolls(true);
		lblUsername.setBackground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Sylfaen", Font.ITALIC, 21));
		lblUsername.setBounds(371, 81, 102, 25);
		frame.getContentPane().add(lblUsername);
		
		lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/login-username4.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(326, 108, 43, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setSelectedTextColor(Color.GRAY);
		txtUsername.setToolTipText("UserName");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setMargin(new Insets(5, 2, 2, 2));
		txtUsername.setBorder(new LineBorder(new Color(0, 0, 128)));
		txtUsername.setInheritsPopupMenu(true);
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtUsername.setBounds(371, 108, 263, 40);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBackground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Sylfaen", Font.ITALIC, 21));
		lblPassword.setBounds(371, 169, 102, 25);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		passwordField.setBorder(new LineBorder(new Color(0, 0, 128)));
		passwordField.setSelectionColor(new Color(0, 0, 0));
		passwordField.setBounds(371, 192, 263, 40);
		frame.getContentPane().add(passwordField);
		
		lblNewLabel_3 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/passwordkey.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		lblNewLabel_3.setBounds(328, 192, 41, 33);
		frame.getContentPane().add(lblNewLabel_3);
	
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(371, 262, 263, 33);
		frame.getContentPane().add(btnLogin);
	
		btnLogin.setFocusCycleRoot(true);
		btnLogin.setBorderPainted(false);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnLogin.setBorder(new LineBorder(new Color(0, 100, 0), 1, true));
		btnLogin.setFocusTraversalPolicyProvider(true);
		btnLogin.setBackground(new Color(0, 255, 0));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNewButton = new JButton("Reset");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				passwordField.setText(null);
			}
		});
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(462, 319, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("don't have an account? register here!");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				try {
					RegisterPage1 ob1=new RegisterPage1();
					ob1.initialize1();
				}
				catch(Exception e1) {
				e1.printStackTrace();
				}	
			}
		});
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(303, 353, 393, 25);
		frame.getContentPane().add(lblNewLabel);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBorderPainted(false);
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(462, 389, 89, 23);
		frame.getContentPane().add(btnClose);
		
		JLabel lblLoginPage = new JLabel("USER LOGIN ");
		lblLoginPage.setBounds(336, 22, 298, 33);
		frame.getContentPane().add(lblLoginPage);
		lblLoginPage.setLocale(new Locale("aa", "IN"));
		lblLoginPage.setDisplayedMnemonic(KeyEvent.VK_AGAIN);
		lblLoginPage.setOpaque(true);
		lblLoginPage.setForeground(new Color(240, 248, 255));
		lblLoginPage.setBackground(new Color(255, 140, 0));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 20));
	
	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String uname=txtUsername.getText();
				String pass=String.valueOf(passwordField.getPassword());
				String s1="select * from logintable where username='"+uname+"'and password='"+pass+"'";
				try {
					rs=stmt.executeQuery(s1);
					if(rs.next()){
						String m=rs.getString(1);
						String n=rs.getString(2);
						
						 if(m.equals(uname)&&n.equals(pass)) {
							 UserPage ob3=new UserPage();
							 ob3.initialize3(uname);
						 }
		 		    }
					
					else if(uname.equals("")&&pass.equals("")){
						 JOptionPane.showMessageDialog(null,"Please enter the username and password !");
						}
					
					else if(uname.equals("")){
						 JOptionPane.showMessageDialog(null,"Please enter the username !");
						}
					
					else if(pass.equals("")){
						 JOptionPane.showMessageDialog(null,"please enter the password !");
						}
					
					else 
						JOptionPane.showMessageDialog(null,"Invalid username or password !!! \nIf you are not registered yet, please register first");
					 }
					
					catch (SQLException e1) {
						e1.printStackTrace();
					}
			}   
		 }
	);}	
}
		
