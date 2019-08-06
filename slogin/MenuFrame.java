import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.util.*;
import javax.swing.table.*;
import javax.swing.JTable;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;


class MenuFrame extends JFrame implements ActionListener
{
  private JLabel displayJLabel; ResultSet rs; Statement st; Connection con; JTextField t1,t2; JLabel l1,l2; JButton b1,b2;
  MenuFrame()
  {
    super("UserWindow");

  setLayout(null);
    b1 = new JButton("Search");
    b1.setBounds(75,150,90,30);
    b1.addActionListener(this);
    add(b1);


  /*  b1.addActionListener(
    new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        search bus = new search();
          bus.setSize(1500,1200);
          bus.setVisible(true);
        /* JPanel panel = new JPanel();
  			panel.setLayout(null);

  			panel.setPreferredSize(new Dimension(1500,900));

  			DefaultTableModel m1=new DefaultTableModel(new String[]{"Time","From","To"},0);
  			JTable table=new JTable(m1);
  			table.setBackground(Color.decode("#ff8080"));
  			table.setFont(new Font("Console",Font.BOLD,20));
  			table.setRowHeight(50);
        panel.add(table);

  			JTableHeader header = table.getTableHeader();
  			header.setBackground(Color.YELLOW);
  			header.setFont(new Font("Console",Font.BOLD,18));
  			header.setPreferredSize(new Dimension(130,50));
  			panel.add(header);

  			JScrollPane pane = new JScrollPane(table);
  			panel.add(pane);

  		JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  		add(scrollBar);

  			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        //this.setUndecorated(true);
  		    //this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

  //	table.setModel(m1);
    table.setLocation(new Point(0,0));
    //table.setTitle("Bus_Info");
    //table.setVisible(true);

        //String t5= t1.getText();
        String s1="";
        String s2="";
        String s3="";
        String ss ="";
      try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_core","root","123456i");
          Statement st = con.createStatement();
          String sql = "select * from tables1 where source ="+"'Kota'";

          ResultSet rs = st.executeQuery("select * from tables1");
          ss = t1.getText();
        //   int i=0;
          while(rs.next())
          {
            s1=rs.getString("time");
            s2=rs.getString("source");
            s3=rs.getString("destination");

            m1.addRow(new Object[]{s1,s2,s3});

            }
      /*    }
          else
          if(i<1)
          {
            JOptionPane.showMessageDialog(null,"No Record Found","Error",JOptionPane.ERROR_MESSAGE);
          }
          else
          {
            JOptionPane.showMessageDialog(null,"Got an exception!");
          }

          con.close();

    } catch(Exception e1){System.out.println("Error"+e1);}

    table.setModel(m1);

  }
  }
    );   */


    l1 = new JLabel("From:");
    l1.setBounds(30,50,80,30);
    add(l1);
    t1 = new JTextField();
    t1.setBounds(90,50,140,30);
    add(t1);
    l2 = new JLabel("To:");
    l2.setBounds(30,100,80,30);
    add(l2);
    t2 = new JTextField();
    t2.setBounds(90,100,140,30);
    add(t2);
    b2 = new JButton("Exit");
    b2.setBounds(160,280,70,30);
    b2.addActionListener(this);
    add(b2);


    JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic('F');

    JMenuItem updateItem = new JMenuItem("Update");
    updateItem.setMnemonic('U');
    fileMenu.add(updateItem);
  /*  updateItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          JOptionPane.showMessageDialog(MenuFrame.this,"Update","Update",JOptionPane.PLAIN_MESSAGE);
        }
      }
    );  */  //End call to action why above?

    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.setMnemonic('E');
    fileMenu.add(exitItem);
  /*  exitItem.addActionListener(

    new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    }
    );
*/
    JMenu viewMenu = new JMenu("View");
    viewMenu.setMnemonic('V');

    JMenuItem My_infoItem = new JMenuItem("My_info");
    My_infoItem.setMnemonic('o');
    viewMenu.add(My_infoItem);
/*    My_infoItem.addActionListener(

    new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        try{
        rs=st.executeQuery("select * from data"); //4 execute method for sql query

     //  rs.getXXX(column name)
    //   String s1=t1.getText();
    //   String s2=t2.getText();
       while(rs.next())
       {
         String s3=rs.getString("Username");
         String s4=rs.getString("Password");
        // String s5=rs.getString("Role");
         System.out.println("Hi "+rs.getString("Username")+"   "+rs.getString("Password"));

        }
        rs.close();    st.close();   con.close();
           }

         catch(Exception e1){}
         }
       }
    );   */


    JMenuBar bar = new JMenuBar();
    setJMenuBar(bar);
    bar.add(fileMenu);
    bar.add(viewMenu);
}

public void actionPerformed( ActionEvent ae){

  if(ae.getSource()==b1)
  {
    search bus = new search();
      bus.setSize(1500,1200);
      bus.setVisible(true);
  }
  if(ae.getSource()==b2)
  {
    dispose();
  }
}
}
