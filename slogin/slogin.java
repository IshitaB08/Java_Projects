import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;

class slogin extends JFrame implements ActionListener
{
  JButton b1,b2,b3; JLabel l1,l2; JTextField t1,t2;Connection con; Statement st; ResultSet rs;
  FlowLayout fl; BorderLayout bl;
  slogin()
  {
    try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_core","root","123456i");
st=con.createStatement(); //3
}catch(Exception e)
{System.out.println("EXC  "+e);}
    bl=new BorderLayout();
    fl=new FlowLayout();
    setLayout(null);
    l1 = new JLabel("Username:");
    l1.setBounds(60,100,80,30);
    add(l1);
    t1 = new JTextField(20);
    t1.setBounds(140,100,140,30);
    add(t1);
    l2 = new JLabel("Password:");
    l2.setBounds(60,150,80,30);
    add(l2);
    t2 = new JTextField(20);
    t2.setBounds(140,150,140,30);
    add(t2);

    b3=new JButton("Exit");
    b3.setBounds(230,220,80,30);
    b3.addActionListener(this);   //3

    b1=new JButton("Login");
    b1.setBounds(30,220,80,30);
    b1.addActionListener(this);   //3
    add(b1);
    b2=new JButton("New User");
    b2.setBounds(130,220,80,30);
    b2.addActionListener(this);   //3
    add(b2);add(b3);
    mywin w1=new mywin();
    addWindowListener(w1);

  }


public void actionPerformed(ActionEvent e)
{
   try{
   rs=st.executeQuery("select * from data"); //4 execute method for sql query

//  rs.getXXX(column name)
  String s1=t1.getText();
  String s2=t2.getText();
  while(rs.next())
  {
    String s3=rs.getString("Username");
    String s4=rs.getString("Password");
    String s5=rs.getString("Role");

    if(s1.equals(s3) && s2.equals(s4))
    {
      if(s5.equals("admin"))
      {
        sadmin t1=new sadmin();
    		t1.setSize(1200,700);
    		t1.setTitle("Admin_Window");
    		t1.setLocation(new Point(0,0));
    		t1.setVisible(true);

      break;
    }

      else
       {
         MenuFrame menuFrame = new MenuFrame();
          menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          menuFrame.setSize(400,400);
          menuFrame.getContentPane().setBackground( Color.PINK );
          menuFrame.setVisible(true);

        break;
            }
    }
    else
    if(e.getSource()==b2)
    {
      String s6=new String("clerk");
      st.executeUpdate("INSERT INTO data (Username,Password,Role) VALUES ('"+s1+"','"+s2+"','"+s6+"')");

       MenuFrame menuFrame = new MenuFrame();
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.getContentPane().setBackground( Color.PINK );
        menuFrame.setSize(400,400);
        menuFrame.setVisible(true);
    }

 }
   rs.close();    st.close();   con.close();
      }

    catch(Exception e1){}
}




class mywin extends WindowAdapter
{
  public void windowDeactivated(WindowEvent we)
  {
   getContentPane().setBackground(Color.gray);
  }
  public void windowClosing(WindowEvent we)
  {
   dispose();
  }
}

}


/* class slogin
{
  public static void main(String args[])
 {
  fr f1=new fr();
  f1.setSize(400,400);
  f1.getContentPane().setBackground(Color.cyan);
  f1.setVisible(true);
 }

} */
