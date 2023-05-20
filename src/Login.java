import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Login1 extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardText;
    JPasswordField pinText;
    Login1(){
        setTitle("Automated Teller Machine");
        setLayout(null);

        ImageIcon i1=new ImageIcon("icons/logo.jpg");
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno=new JLabel("Card No.:");
        cardno.setBounds(120, 150, 400,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);

        cardText=new JTextField();
        cardText.setBounds(300,150,230,30);
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        add(cardText);

        JLabel pin=new JLabel("PIN:");
        pin.setBounds(120, 220, 400,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        pinText=new JPasswordField();
        pinText.setBounds(300,220,230,30);
        pinText.setFont(new Font("Arial",Font.BOLD,14));
        add(pinText);

        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);
        signup.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(650,500);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==login){
                Conn c1 = new Conn();
                String cardno  = cardText.getText();
                String pin  = pinText.getText();
                String q  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==clear){
                cardText.setText("");
                pinText.setText("");
            }else if(ae.getSource()==signup){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class Login{
    public static void main(String args[]){
        Login1 log=new Login1();
    }
}
