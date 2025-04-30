package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{

    JButton login,clear,signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;

    Login(){
        
        setLayout(null);
        setVisible(true);
        setSize(800,480);
        setLocation(280,120);
        setTitle("AUTOMATED TELLER MACHINE");
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 20,100,100);
         add(label);
         
         

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("\"E:\\CODE\\BankManagementSystem\\BankManagementSystem\\src\\icons\\logo.jpg\""));
        // Image i2 = i1.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel label = new JLabel(i3);
        // label.setBounds(70,20,100,100);
        // add(label);
        

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(250, 50, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300, 150, 250, 30);
        cardtextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtextfield);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 150, 40);
        add(pin);


        pintextfield = new JPasswordField();
        pintextfield.setBounds(300, 220, 250, 30);
        pintextfield.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintextfield);

        login = new JButton("LOGIN");
        login.setBounds(300,300,100,28);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);


         clear = new JButton("CLEAR");
         clear.setBounds(450, 300, 100, 28);
         clear.setBackground(Color.black);
         clear.setForeground(Color.white);
         clear.addActionListener(this);
         add(clear);


         signup = new JButton("SIGN UP");
         signup.setBounds(300,350,250,28);
         signup.setBackground(Color.black);
         signup.setForeground(Color.white);
         signup.addActionListener(this);
         add(signup);

         getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }
        else if(ae.getSource()==login){

            Conn c = new Conn();
            String cardnumber = cardtextfield.getText();
            String pinnumber = pintextfield.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

            try {
                 ResultSet rs =c.s.executeQuery(query);
                 if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                 }
                 else if(cardnumber.equals("")){
                    JOptionPane.showMessageDialog(null,"Card Number is Required");
                 }
                 else if(pinnumber.equals("")){
                    JOptionPane.showMessageDialog(null,"PIN is Required");
                 }
                 else{
                    JOptionPane.showMessageDialog(null,"Icorrect Card Number or Pin");
                 }
            }
            catch(Exception e){
                System.out.println(e); 
            }

        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne();

        }
    }
    public static void main(String[] args) {
       new Login();
    }
    
}
