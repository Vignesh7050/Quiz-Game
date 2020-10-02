
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class RegisterPage1 {
	private JTextField tffname;
	private JFormattedTextField tfmobile;
	private JTextField tfuname;
	private JPasswordField tfpassword;

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	
	private JTextField tflname;
	private JTextField tfbdate;
	private JPasswordField tfrepassword;
	
	public RegisterPage1() throws SQLException
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
	}
		 /**
		  * @wbp.parser.entryPoint
		  */
		void initialize1() throws SQLException{
	
		JFrame frame2 = new JFrame();
		frame2.getContentPane().setBackground(new Color(255, 255, 255));
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setResizable(false);
		frame2.setBounds(400, 10, 604, 676);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(51, 79, 113, 21);
		frame2.getContentPane().add(lblName);
		
		tffname = new JTextField();
		tffname.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tffname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tffname.setBounds(174, 75, 244, 30);
		frame2.getContentPane().add(tffname);
		tffname.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Mobile no");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhoneNo.setBounds(70, 173, 94, 21);
		frame2.getContentPane().add(lblPhoneNo);
		
		tfmobile = new JFormattedTextField();
		tfmobile.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tfmobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfmobile.setBounds(174, 169, 244, 30);
		frame2.getContentPane().add(tfmobile);
		tfmobile.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(70, 276, 94, 21);
		frame2.getContentPane().add(lblUsername);
		
		tfuname = new JTextField();
		tfuname.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tfuname.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tfuname.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tfuname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfuname.setBounds(174, 272, 244, 30);
		frame2.getContentPane().add(tfuname);
		tfuname.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(75, 330, 89, 21);
		frame2.getContentPane().add(lblPassword);
		
		tfpassword = new JPasswordField();
		tfpassword.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfpassword.setBounds(174, 326, 244, 30);
		frame2.getContentPane().add(tfpassword);
		
		tfbdate = new JTextField();
		tfbdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfbdate.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tfbdate.setBounds(174, 220, 244, 30);
		frame2.getContentPane().add(tfbdate);
		tfbdate.setColumns(10);
		
		tflname = new JTextField();
		tflname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tflname.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tflname.setBounds(174, 122, 244, 30);
		frame2.getContentPane().add(tflname);
		tflname.setColumns(10);
		
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setBackground(new Color(255, 215, 0));
		lblRegister.setOpaque(true);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRegister.setBounds(143, 25, 301, 30);
		frame2.getContentPane().add(lblRegister);
		
		JLabel lblNewLabel_1 = new JLabel("Retype password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(16, 385, 148, 21);
		frame2.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(51, 126, 113, 21);
		frame2.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Date of birth");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(46, 224, 118, 21);
		frame2.getContentPane().add(lblNewLabel_5);
		
		JLabel lblMandatory = new JLabel("All fields are mandatory");
		lblMandatory.setForeground(new Color(255, 0, 0));
		lblMandatory.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMandatory.setBounds(222, 434, 148, 25);
		frame2.getContentPane().add(lblMandatory);
		
		JLabel label = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/register1.jpg")).getImage();
		label.setIcon(new ImageIcon(img3));
		label.setBounds(452, 21, 104, 103);
		frame2.getContentPane().add(label);
		
		tfrepassword = new JPasswordField();
		tfrepassword.setBorder(new LineBorder(Color.BLACK, 1, true));
		tfrepassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfrepassword.setBounds(174, 381, 244, 30);
		frame2.getContentPane().add(tfrepassword);
		
		JButton btnRegister = new JButton("register");
		btnRegister.setBorderPainted(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		btnRegister.setBackground(new Color(102, 255, 0));
		btnRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String fname=tffname.getText();
				String lname =tflname.getText();
			    String mobile =tfmobile.getText();
				String uname=tfuname.getText();
				String dob=	tfbdate.getText();
				String pass=String.valueOf(tfpassword.getPassword());
				String repass=String.valueOf(tfrepassword.getPassword());
				
				if(fname.equals("")||lname.equals("")||uname.equals("")||pass.equals("")||repass.equals("")){
					
                	   JOptionPane.showMessageDialog(null,"Fields shouldnot be empty!!!");
                }
				
				else {
					
					String ss="^[0-9]{10}$";
					boolean v=Pattern.matches(ss,mobile);
		
				    if(v==false) {
						if(mobile.length()<10){
							JOptionPane.showMessageDialog(null,"mobile number is lessthan 10");
						}
						
						if(mobile.length()>10){
							JOptionPane.showMessageDialog(null,"mobile number is greaterthan 10");
						}
						
						System.out.println("mobile");
					}
					
					else {
						String s2="select * from registertable where mobileno="+mobile+"or username='"+uname+"'";
						
					try {  
						rs=stmt.executeQuery(s2);
						boolean n = rs.next();
						
						if(n == false) {
							String se="insert into registertable values('"+fname+"','"+lname+"','"+mobile+"','"+dob+"','"+uname+"','"+pass+"');";
							stmt.executeUpdate(se);
							String l="insert into logintable values('"+uname+"','"+pass+"');";
							stmt.executeUpdate(l);
							JOptionPane.showMessageDialog(null,"registered successfully");
							
							tffname.setText(null);
							tflname.setText(null);
							tfmobile.setText(null);
							tfbdate.setText(null); 
							tfuname.setText(null);
							tfpassword.setText(null);
							tfrepassword.setText(null);
							
						}
							
						else {
							
							String nm=rs.getString(1);
						    String nmm=rs.getString(2);
						      int mob=rs.getInt(3);
							
							if(!pass.equals(repass)) JOptionPane.showMessageDialog(null,"password is not matching");
							if(nm.equals(fname)) JOptionPane.showMessageDialog(null,"name already exist");
							if(nmm.equals(lname)) JOptionPane.showMessageDialog(null,"lname already exist");
							if(mobile.equals(mob)) JOptionPane.showMessageDialog(null,"mobno already exist");
								
						}
						
					}
				
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
				
	}});
		
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBounds(174, 481, 244, 29);
		frame2.getContentPane().add(btnRegister);
		
		JButton btnReset = new JButton("reset");
		btnReset.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		btnReset.setBackground(new Color(221, 160, 221));
		btnReset.setBorderPainted(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tffname.setText(null);
				tflname.setText(null);
				tfmobile.setText(null);
				tfbdate.setText(null); 
				tfuname.setText(null);
				tfpassword.setText(null);
				tfrepassword.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReset.setBounds(232, 531, 138, 29);
		frame2.getContentPane().add(btnReset);
		
		
		JButton btnClose = new JButton("close");
		btnClose.setBorderPainted(false);
		btnClose.setBackground(new Color(255, 0, 0));
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				LoginPage.frame.setVisible(true);
			}
		});
		
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setBounds(232, 582, 138, 29);
		frame2.getContentPane().add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 204));
		panel.setBounds(0, 0, 14, 647);
		frame2.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 204));
		panel_1.setBounds(10, 0, 588, 14);
		frame2.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 204));
		panel_2.setBounds(566, 0, 32, 636);
		frame2.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 204));
		panel_3.setBounds(0, 622, 598, 24);
		frame2.getContentPane().add(panel_3);
	}
}
