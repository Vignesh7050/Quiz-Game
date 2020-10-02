import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Cursor;

public class UserPage {
	
	 static JFrame frame3;
	 static Connection con;
	 static Statement stmt;
	 static ResultSet rss;
     UserPage() throws SQLException{
    	 
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
	public void initialize3(String uname) throws SQLException {
		frame3 = new JFrame();
		frame3.getContentPane().setIgnoreRepaint(true);
		frame3.getContentPane().setBackground(new Color(255, 255, 255));
		frame3.setVisible(true);
		frame3.setBounds(-7, 0, 1390, 780);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JLabel yourName = new JLabel("");
		yourName.setHorizontalAlignment(SwingConstants.CENTER);
		yourName.setFont(new Font("Tahoma", Font.BOLD, 27));
		yourName.setBounds(394, 79, 594, 40);
		frame3.getContentPane().add(yourName);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back !");
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setForeground(new Color(0, 0, 205));
		lblWelcomeBack.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblWelcomeBack.setBounds(543, 28, 290, 40);
		frame3.getContentPane().add(lblWelcomeBack);
		
		String myName = "select * from logintable where username='"+uname+"'";
		rss = stmt.executeQuery(myName);
		rss.next();
		String m = rss.getString(1);
		yourName.setText(m);
		
		ToEnterQuiz ob=new ToEnterQuiz();
		 ob.initialize4();
	
		JLabel lblScienceQuiz = new JLabel("Science Quiz");
		lblScienceQuiz.setOpaque(true);
		lblScienceQuiz.setBackground(Color.ORANGE);
		lblScienceQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblScienceQuiz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblScienceQuiz.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					try {
						String f2="delete from differentquiz";
						stmt.executeUpdate(f2);
						
						String ss="science";
						String sc="insert into differentquiz values('"+ss+"','2');";
						stmt.executeUpdate(sc);
	
				         ob.a();
		            }
					
					catch(Exception e3) {
						e3.printStackTrace();
					}
			}
		});
		
		lblScienceQuiz.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		lblScienceQuiz.setBounds(511, 373, 396, 78);
		frame3.getContentPane().add(lblScienceQuiz);
				
		JLabel lblGeneralQuiz = new JLabel("General Quiz");
		lblGeneralQuiz.setOpaque(true);
		lblGeneralQuiz.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGeneralQuiz.setBounds(511, 218, 396, 78);
		frame3.getContentPane().add(lblGeneralQuiz);
		
		lblGeneralQuiz.setForeground(Color.BLACK);
		//System.out.println(lblGeneralQuiz);
		lblGeneralQuiz.setFocusCycleRoot(true);
		lblGeneralQuiz.setBackground(Color.LIGHT_GRAY);
		lblGeneralQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneralQuiz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblGeneralQuiz.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		JLabel lblNewLabel = new JLabel("________________________________________________________________________________________________");
		lblNewLabel.setBounds(394, 139, 861, 14);
		frame3.getContentPane().add(lblNewLabel);

		
		lblGeneralQuiz.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent e) {
	
				try {
				
					String f1="delete from differentquiz";
					stmt.executeUpdate(f1);
					
				    String s="general";
					String gn="insert into differentquiz values('"+s+"','1');";
					stmt.executeUpdate(gn);
					ob.a();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}	
			}
		});
	}
}
