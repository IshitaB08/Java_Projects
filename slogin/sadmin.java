import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.util.*;
import javax.swing.table.*;
import javax.swing.JTable;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;



class sadmin extends JFrame
{
    sadmin()
		{
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			panel.setPreferredSize(new Dimension(1500,900));


			DefaultTableModel m1=new DefaultTableModel(new String[]{"Time","Source","Destination"},0);
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



			this.setUndecorated(true);
		    this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);



			try
			{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_core","root","123456i");

			Statement st = con.createStatement();

      //String ss="select * from tables1 where source ="+"'kota'";
			ResultSet rs = st.executeQuery("select * from tables1");


			while(rs.next())
			{
				String s1 = rs.getString("time");
				String s2 = rs.getString("source");
				String s3 = rs.getString("destination");

				m1.addRow(new Object[]{s1,s2,s3});

			}

			con.close();

		}catch(Exception e){System.out.println("Error"+e);}

		table.setModel(m1);

  JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic('F');


    JMenuItem CreateAdminItem = new JMenuItem("CreateAdmin");
     CreateAdminItem.setMnemonic('N');
    fileMenu.add(CreateAdminItem);
    CreateAdminItem.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          snadmin a2=new snadmin();
          a2.setSize(400,400);
          a2.getContentPane().setBackground(Color.YELLOW);
          a2.setVisible(true);
        }
      }
    );


    JMenu exitMenu = new JMenu("Exit");
    exitMenu.setMnemonic('E');
    exitMenu.addActionListener(

    new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        System.exit(0);
      }
    }
    );


    JMenuItem My_infoItem = new JMenuItem("My_info");
    My_infoItem.setMnemonic('o');
    fileMenu.add(My_infoItem);


    JMenuBar bar = new JMenuBar();
    setJMenuBar(bar);
    bar.add(fileMenu);
    bar.add(exitMenu);
	}
}
