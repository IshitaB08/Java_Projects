import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;

class snadmin extends JFrame
{
  JButton jbtn2,jbtn3; JLabel l1,l2; JTextField t1,t2;Connection con; Statement st; ResultSet rs;
  FlowLayout fl; BorderLayout bl;
  snadmin()
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

    jbtn3=new JButton("Exit");
    jbtn3.setBounds(230,220,80,30);
      add(jbtn3);
    jbtn3.addActionListener(

    new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    }

    );   //3


    jbtn2=new JButton("New Admin");
    jbtn2.setBounds(130,220,80,30);
    add(jbtn2);
    jbtn2.addActionListener(

    new ActionListener(){

      public void actionPerformed(ActionEvent e)
      {
        try{
          rs=st.executeQuery("select * from data");

        String s1=t1.getText();
        String s2=t2.getText();
        String s6=new String("admin");

        while(rs.next())
          {
            
          st.executeUpdate("INSERT INTO data (Username,Password,Role) VALUES ('"+s1+"','"+s2+"','"+s6+"')");
          JOptionPane.showMessageDialog(snadmin.this,"New Admin created.","Update",JOptionPane.PLAIN_MESSAGE);

          }    rs.close();    st.close();   con.close();
             }

           catch(Exception e1){}

      }

    }

    );   //3


    mywin w1=new mywin();
    addWindowListener(w1);


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
