import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pin;
    Withdrawl(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 860, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 960, 760);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(170,250,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,300,335,25);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,400,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back=new JButton("Back");
        back.setBounds(355,440,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(960,760);
        setLocation(200,-80);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the amount you want to withdraw");
            }
            else{
                try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pin+"','"+date+"','Withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS "+number+" Withdraw Succesfully");
                    setVisible(false);
                    new Transactions(query).setVisible(true);
                }
                catch(Exception e1){
                    System.out.println(e1);
                }
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
