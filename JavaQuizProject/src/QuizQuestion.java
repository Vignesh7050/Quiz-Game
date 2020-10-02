import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


public class QuizQuestion {
	int count = 0;int no=0;String g;
	public static JFrame frame;
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private JRadioButton option1;
	private JRadioButton option2;
	private JRadioButton option3;
	private JRadioButton option4;
	private JTextField textField_1;
	private JButton btnSubmit;
	protected Object JOptionPane;
	private JTextField txtQuestionno;


	
	public QuizQuestion() throws SQLException {
		
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
	 * @wbp.pareser.entryPoint
	 * @wbp.parser.entryPoint
	 */
	public void initialize() throws SQLException { 
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setUndecorated(true);
		frame.setVisible(true);
			
		frame.setBounds(-7, 0, 1390, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 139));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBorder(null);
		textField_1.setEnabled(true);
		textField_1.setBounds(412, 104, 1028, 40);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		ButtonGroup bg=new ButtonGroup(); 
		
		option1 = new JRadioButton(); 
		option1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		option1.setBackground(new Color(255, 255, 255));
		bg.add(option1);
		option1.setBounds(487, 173, 953, 38);
		frame.getContentPane().add(option1);
	
		option2 = new JRadioButton();
		option2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		option2.setBackground(new Color(255, 255, 255));
		bg.add(option2);
		option2.setBounds(487, 243, 953, 38);
		frame.getContentPane().add(option2);
		
		option3 = new JRadioButton();
		option3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		option3.setBackground(new Color(255, 255, 255));
		bg.add(option3);
		option3.setBounds(487, 309, 953, 38);
		frame.getContentPane().add(option3);
		
		option4 = new JRadioButton();
		option4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		option4.setBackground(new Color(255, 255, 255));
		bg.add(option4);
		option4.setBounds(487, 374, 914, 38);
		frame.getContentPane().add(option4);
		
		SubmitPage s=new SubmitPage();
		s.initialize();
			JButton btnNext = new JButton("next");
			btnNext.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnNext.setForeground(new Color(0, 0, 0));
			btnNext.setBorderPainted(false);
			btnNext.setBackground(new Color(0, 255, 0));
			btnNext.setFont(new Font("Times New Roman", Font.PLAIN, 21));
			btnNext.setBounds(442, 521, 128, 40);
			frame.getContentPane().add(btnNext);
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					 try {
						 if(rs.next()==false) {
							 rs.previous();
							 d();	
							SubmitPage.frame.setVisible(true);s.u();
					 }
						 else {
							 rs.previous();		
							d();
							 
							 rs.next();
							 method1();
													   
						 }
					 } 
					 
					 catch (SQLException e1) {
						 e1.printStackTrace();
					 } 
					 catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						 e1.printStackTrace();
					 }
			
				}	
				
			}); 
			
		btnSubmit = new JButton("submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 0, 255));
		btnSubmit.setBorderPainted(false);
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnSubmit.setBounds(816, 521, 128, 40);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
			            d();
			            SubmitPage.frame.setVisible(true);  
					    s.u();
					}
					catch (SQLException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		
		JButton btnPrevious = new JButton("previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.previous()==false) {
						rs.first();
					}
					else {
						rs.next();
						d();
						rs.previous();
				       method1();
					}
					
	            } catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnPrevious.setForeground(new Color(255, 255, 255));
		btnPrevious.setBorderPainted(false);
		btnPrevious.setBackground(new Color(153, 50, 204));
		btnPrevious.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnPrevious.setBounds(625, 521, 128, 40);
		frame.getContentPane().add(btnPrevious);
		
		txtQuestionno = new JTextField();
		txtQuestionno.setText("<dynamic>");
		txtQuestionno.setSelectedTextColor(Color.BLACK);
		txtQuestionno.setHorizontalAlignment(SwingConstants.LEFT);
		txtQuestionno.setForeground(new Color(102, 0, 51));
		txtQuestionno.setBackground(Color.WHITE);
		txtQuestionno.setBorder(null);
		txtQuestionno.setEditable(false);
		txtQuestionno.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		txtQuestionno.setBounds(613, 42, 86, 38);
		frame.getContentPane().add(txtQuestionno);
		txtQuestionno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Question :");
		lblNewLabel.setForeground(new Color(102, 0, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(412, 42, 191, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("____________________________________________");
		label.setForeground(Color.BLUE);
		label.setBounds(413, 73, 340, 14);
		frame.getContentPane().add(label);
		
		method1();	
	
	}
		
    void mgeneralquiz() throws SQLException {
    	String b=" ";
	     String h="update generalquiz set optionchoosed ='"+b+"'";
	     stmt.executeUpdate(h);
	      
	    String m="select * from generalquiz";
		rs=stmt.executeQuery(m);
	
		rs.next();
		initialize();
	}
    
	void msciencequiz() throws SQLException {
		  String b=" ";
	      String h="update sciencequestions set optionchoosed ='"+b+"'";
	      stmt.executeUpdate(h);
	      
		  String s="select * from sciencequestions"; 
		  rs=stmt.executeQuery(s);
          rs.next();
		  initialize();
	}
	
	 void method1( ) throws SQLException{     
		 try {	      
			 textField_1.setText("<dynamic>");
			 option1.setText(" ");
			 option2.setText(" ");
			 option3.setText(" ");
			 option4.setText(" ");
			 
		     String a1=rs.getString(2);
		     String b=rs.getString(3);
		     String c=rs.getString(4);
		     String d=rs.getString(5);
		     String e4=rs.getString(6);
		     String a=rs.getString(7);
	         String o=rs.getString(1);
	         
	         txtQuestionno.setText(o);
	         textField_1.setText(a1);
			 option1.setText(b);
			 option2.setText(c);
			 option3.setText(d);
			 option4.setText(e4);
	    }
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	 
	void d() throws SQLException, ClassNotFoundException {
		   String b=rs.getString(3);
	     String c=rs.getString(4);
	     String d=rs.getString(5);
	     String e4=rs.getString(6);
	     String a=rs.getString(7);
	    
		if(option1.isSelected()) {
			 g=b;
			mark();
			
		}
		else if(option2.isSelected()) {
			g=c;
			mark();
			 
		}
		
		else if(option3.isSelected()) {
			g=d;
			mark();
			 
		}
		
		else if(option4.isSelected()) {
			g=e4;
			mark();
			 
		}
			
	}
	void mark() throws SQLException, ClassNotFoundException {
	    Statement stmt;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2QFGJPI","sa","1234");
		stmt = con.createStatement();
	    stmt.executeUpdate("use quiz");
	    stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    ResultSet ress; 
	 
	    String r="select * from differentquiz";
	    ress=stmt.executeQuery(r);
	    ress.first();
	    int f=ress.getInt(2);
	    int t=rs.getInt(1);
	 
	    if(f==2) {
	      	 String h="update sciencequestions set optionchoosed ='"+g+"'where qno="+t;
	   		 stmt.executeUpdate(h);	
	    }
	    
	    else if(f==1) {
	    	 String h="update  generalquiz set optionchoosed ='"+g+"'where qno="+t;
	 		 stmt.executeUpdate(h);	
	    }
	 
	}
}
	

