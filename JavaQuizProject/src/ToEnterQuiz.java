import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class ToEnterQuiz  {
	 public static JFrame frame;
	 static Connection con;
	 static Statement stmt;
	 static ResultSet rs;
	 private JTextField textField;
	 String s;

	ToEnterQuiz() throws SQLException{
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
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	public void initialize4() throws SQLException {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBackground(new Color(192, 192, 192));
		frame.setResizable(false);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(500, 200, 407, 275);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total number of questions :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 47, 242, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblToEnterInto = new JLabel("To attmpt the quiz press the button ");
		lblToEnterInto.setForeground(new Color(0, 0, 0));
		lblToEnterInto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblToEnterInto.setBounds(20, 83, 289, 25);
		frame.getContentPane().add(lblToEnterInto);
		
		JButton btnNext = new JButton("next");
		btnNext.setBorderPainted(false);
		btnNext.setBackground(new Color(0, 255, 0));
		btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(s.equals(null)) JOptionPane.showMessageDialog(frame,"no questions available");
					LoginPage.frame.setVisible(false);
					frame.setVisible(false);
				    String s1="select * from differentquiz ";	
					rs=stmt.executeQuery(s1);
					rs.next();
					int a=rs.getInt(2);
					if(a==2) {
						QuizQuestion j=new QuizQuestion();
						j.msciencequiz();
					}
					
					if(a==1){
					    QuizQuestion j=new QuizQuestion();
						j.mgeneralquiz();
				    }
				}
				catch (SQLException e1) {
						e1.printStackTrace();
				}
			}
		});
		
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNext.setBounds(141, 132, 102, 28);
		frame.getContentPane().add(btnNext);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBorderPainted(false);
		
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				String f1="delete from differentquiz";
				try {
					stmt.executeUpdate(f1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.setBounds(141, 183, 101, 28);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("-  next");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(290, 83, 61, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(239, 47, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
    }
	
	public void a() throws SQLException {
		int count = 0;
		JTextField SelQuizName;
		SelQuizName = new JTextField();
		SelQuizName.setForeground(new Color(75, 0, 130));
		SelQuizName.setBackground(SystemColor.window);
		SelQuizName.setEditable(false);
		SelQuizName.setBorder(new EmptyBorder(0, 0, 0, 0));
		SelQuizName.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		SelQuizName.setBounds(10, 11, 381, 25);
		frame.getContentPane().add(SelQuizName);
		SelQuizName.setColumns(10);
		
		frame.setVisible(true);
		String s1="select * from differentquiz ";	
		rs=stmt.executeQuery(s1);
		rs.next();
		int n=rs.getInt(2);
		
		if(n==1) {
			 SelQuizName.setText("General Quiz"); 
			   String m="select * from generalquiz";
				rs=stmt.executeQuery(m);
		}
		
		if(n==2) {
	   		SelQuizName.setText("Science Quiz"); 
				  String s="select * from sciencequestions"; 
				  rs=stmt.executeQuery(s);
		}
		
		rs.previous();
		frame.setVisible(true);
		
		while(rs.next()==true) {
			count++;
		}
		s=String.valueOf(count);
		textField.setText(s);
		
	}
}
