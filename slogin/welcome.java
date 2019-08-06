import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class fr extends JFrame implements ActionListener
{
  JButton b1; JLabel l1;
  fr()
  {
    setLayout(null);
    l1 = new JLabel("Welcome To Bus Services");
    l1.setFont(new Font("Courier New", Font.ITALIC, 24));
   l1.setForeground(Color.RED);
    l1.setBounds(10,20,400,100);
    add(l1);

    b1 = new JButton(new ImageIcon("time.jpg"));
    b1.setBounds(30,220,300,100);
    b1.addActionListener(this);
    add(b1);


  }

  public void actionPerformed(ActionEvent e){
  //  if (e.getSource==b1){
      slogin s1 = new slogin();
      s1.setSize(400,400);
      s1.getContentPane().setBackground(Color.cyan);
      s1.setVisible(true);

  }



}

class welcome{
  public static void main(String args[])
 {
  fr f1=new fr();
  f1.setSize(400,400);
  f1.getContentPane().setBackground(Color.yellow);
  f1.setVisible(true);
 }

}
