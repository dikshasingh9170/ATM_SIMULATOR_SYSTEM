import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameField,fnameField,emailField,addField,cityField,stateField,pincodeField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    JPanel panel;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,28));
        formno.setBounds(140,10,600,30);
        formno.setForeground(Color.BLACK);

        JPanel panel=new JPanel();
        panel.setBounds(0,0,850,40);
        panel.add(formno);
        panel.setBackground(new Color(255, 154, 48));
        add(panel);
        JLabel personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,60,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,120,100,20);
        add(name);

        nameField=new JTextField();
        nameField.setFont(new Font("Raleway",Font.BOLD,14));
        nameField.setBounds(300,120,400,20);
        add(nameField);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,150,20);
        add(fname);

        fnameField=new JTextField();
        fnameField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameField.setBounds(300,170,400,20);
        add(fnameField);

        JLabel Dob=new JLabel("Date of Birth:");
        Dob.setFont(new Font("Raleway",Font.BOLD,20));
        Dob.setBounds(100,220,150,20);
        add(Dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,220,400,20);
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBackground(new Color(255, 154, 48));
        add(dateChooser);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,270,150,20);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,270,60,20);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450,270,120,20);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergrp=new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,150,20);
        add(email);

        emailField=new JTextField();
        emailField.setFont(new Font("Raleway",Font.BOLD,14));
        emailField.setBounds(300,320,400,20);
        add(emailField);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,370,150,20);
        add(marital);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(300,370,100,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        married=new JRadioButton("Married");
        married.setBounds(450,370,100,20);
        married.setBackground(Color.WHITE);
        add(married);

        other=new JRadioButton("Other");
        other.setBounds(600,370,100,20);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgrp=new ButtonGroup();
        maritalgrp.add(unmarried);
        maritalgrp.add(married);
        maritalgrp.add(other);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,420,150,20);
        add(address);

        addField=new JTextField();
        addField.setFont(new Font("Raleway",Font.BOLD,14));
        addField.setBounds(300,420,400,20);
        add(addField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,470,150,20);
        add(city);

        cityField=new JTextField();
        cityField.setFont(new Font("Raleway",Font.BOLD,14));
        cityField.setBounds(300,470,400,20);
        add(cityField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,520,150,20);
        add(state);

        stateField=new JTextField();
        stateField.setFont(new Font("Raleway",Font.BOLD,14));
        stateField.setBounds(300,520,400,20);
        add(stateField);

        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,570,150,20);
        add(pincode);

        pincodeField=new JTextField();
        pincodeField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeField.setBounds(300,570,400,20);
        add(pincodeField);

        next=new JButton("Next");
        next.setBackground(new Color(255, 154, 48));
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBounds(500,610,200,30);
        add(next);
        next.addActionListener(this);
    
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,700);
        setLocation(250,-10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String name=nameField.getText();
        String fname=fnameField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else if(female.isSelected()){
            gender="female";
        }
        String email=emailField.getText();
        String marital="";
        if(married.isSelected()){
            marital="married";
        }
        else if(unmarried.isSelected()){
            marital="unmarried";
        }
        else if(other.isSelected()){
            marital="Other";
        }
        String address=addField.getText();
        String city=cityField.getText();
        String state=stateField.getText();
        String pincode=pincodeField.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
                Conn c1=new Conn();
                String query="insert into signup(formno,name,fname,dob,gender,email,marital,address,city,state,pincode) values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c1.s.executeUpdate(query);
            }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
    }
    public static void main(String args[]){
        new SignupOne().setVisible(true);;
    }
}
