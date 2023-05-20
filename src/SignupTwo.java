import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
    JTextField religionField,categoryField,eduactionField,panField,aadharField;
    JButton next;
    JRadioButton yes,no;
    JComboBox religionC,categoryC,inC,edC;
    JPanel panel;
    String formno;
    SignupTwo(String formno){
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");

        this.formno = formno;

        JLabel additionaldetails=new JLabel("Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,32));
        additionaldetails.setBounds(290,40,400,40);
        add(additionaldetails);

        JPanel panel=new JPanel();
        panel.setBounds(0,0,850,50);
        panel.add(additionaldetails);
        panel.setBackground(new Color(255, 154, 48));
        add(panel);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,120,200,30);
        add(religion);

        String[] valrel={"Hindu","Muslim","Sikh","Christian","Other"};
        religionC=new JComboBox(valrel);
        religionC.setBounds(300,120,400,30);
        add(religionC);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,170,200,30);
        add(category);

        String[] valcat={"General","OBC","SC","ST","Other"};
        categoryC=new JComboBox(valcat);
        categoryC.setBounds(300,170,400,30);
        add(categoryC);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,220,200,30);
        add(income);

        String[] valin={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        inC=new JComboBox(valin);
        inC.setBounds(300,220,400,30);
        add(inC);

        JLabel education=new JLabel("Education:");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,270,200,30);
        add(education);

        String[] edval={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        edC=new JComboBox(edval);
        edC.setBounds(300,270,400,30);
        add(edC);

        JLabel pan=new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,320,200,30);
        add(pan);

        panField=new JTextField();
        panField.setFont(new Font("Raleway",Font.BOLD,14));
        panField.setBounds(300,320,400,30);
        add(panField);

        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,370,200,30);
        add(aadhar);

        aadharField=new JTextField();
        aadharField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharField.setBounds(300,370,400,30);
        add(aadharField);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,420,200,30);
        add(senior);

        yes=new JRadioButton("Yes");
        yes.setBounds(300,420,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no=new JRadioButton("No");
        no.setBounds(450,420,100,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup seniorgrp=new ButtonGroup();
        seniorgrp.add(yes);
        seniorgrp.add(no);

        JLabel existing=new JLabel("Existing Acccount:");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,470,200,30);
        add(existing);

        yes=new JRadioButton("Yes");
        yes.setBounds(300,470,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no=new JRadioButton("No");
        no.setBounds(450,470,100,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup existinggrp=new ButtonGroup();
        existinggrp.add(yes);
        existinggrp.add(no);

        next=new JButton("Next");
        next.setBackground(new Color(255, 154, 48));
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBounds(500,530,200,40);
        add(next);
        next.addActionListener(this);
    
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,650);
        setLocation(250,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String religion = (String)religionC.getSelectedItem(); 
        String category = (String)categoryC.getSelectedItem();
        String income = (String)inC.getSelectedItem();
        String education = (String)edC.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();
        
        String scitizen = "";
        if(yes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(no.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(yes.isSelected()){ 
            eaccount = "Yes";
        }else if(no.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(panField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
            }
        }
        catch(Exception ae){
            System.out.println(ae);
        }
    }
    public static void main(String args[]){
        new SignupTwo("").setVisible(true);;
    }
}

