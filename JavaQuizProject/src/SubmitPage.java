import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SubmitPage{
	public static JFrame frame;
	int count = 0;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	SubmitPage() throws SQLException{
			
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
	 * Initialize the contents of the frame.
	 * @param count 
	 * @wbp.parser.entryPoint
	 */
	public void initialize() throws SQLException {	
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(490, 220, 422, 229);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	void u() {
		
		JLabel lblAreYouSure = new JLabel("Are you sure want to sumbit ?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAreYouSure.setBounds(0, 23, 406, 34);
		frame.getContentPane().add(lblAreYouSure);
		
		JButton btnYes = new JButton("yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			QuizQuestion.frame.setVisible(false);
			
			try { 
				Statement stmt;
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2QFGJPI","sa","1234");
				stmt = con.createStatement();
			    stmt.executeUpdate("use quiz");
			    stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			    ResultSet rss; 
			 
			    String r="select * from differentquiz";
		            rss=stmt.executeQuery(r);
		            rss.first();
		            int f=rss.getInt(2);
		            
		            if(f==1) {
			      		  String s5="select * from  generalquiz"; 
			      		
			      			rs=stmt.executeQuery(s5);
			      			while(rs.next()==true) {
			      				  String t=rs.getString(7);
			      				  String o=rs.getString(8);
			      				  if(t.equals(o)) count++;
			      			}
			      	}
		         
		            else if(f==2) {
		            	String s5="select * from sciencequestions"; 
		            	rs=stmt.executeQuery(s5);
		      			while(rs.next()==true) {
		      				
		      				  String t=rs.getString(7);
		      				  String o=rs.getString(8);
		      				  if(t.equals(o)) count++;
		      			}
		      		}
		           
		            JOptionPane.showMessageDialog(frame,"total="+count);
		            
			}
		      	 
			catch(Exception b) {
		      		 b.printStackTrace();
		    }
		}
	});
		
		btnYes.setBorderPainted(false);
		btnYes.setBackground(new Color(0, 255, 0));
		btnYes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnYes.setBounds(156, 92, 89, 23);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("no");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		btnNo.setForeground(new Color(255, 255, 255));
		btnNo.setBorderPainted(false);
		btnNo.setBackground(new Color(255, 0, 0));
		btnNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNo.setBounds(156, 144, 89, 23);
		frame.getContentPane().add(btnNo);
	}
}
