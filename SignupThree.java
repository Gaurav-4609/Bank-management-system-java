package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){

        this.formno= formno;

        setLayout(null);
        setSize(780,700);
        setVisible(true);
        setLocation(300,15);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100,170,150,20);
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBackground(Color.WHITE);
        add(r1);


        r2 = new JRadioButton("Current Account");
        r2.setBounds(100,210,170,20);
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBackground(Color.WHITE);
        add(r2);


        r3 = new JRadioButton("Fixed Deposit Acoount");
        r3.setBounds(350,170,200,20);
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,210,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setBounds(100,260,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);

         JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setBounds(100,280,200,30);
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        add(carddetails);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-9826");
        number.setBounds(350,260,500,30);
        number.setFont(new Font("Raleway",Font.BOLD,22));
        add(number);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100,320,100,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);

         JLabel pindetails = new JLabel("Your 4 Digit Password");
        pindetails.setBounds(100,340,200,30);
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        add(pindetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setBounds(350,320,100,30);
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        add(pnumber);

        JLabel sr = new JLabel("Service Required:");
        sr.setBounds(100,380,200,30);
        sr.setFont(new Font("Raleway",Font.BOLD,22));
        add(sr);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,420,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(300,420,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,470,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(300,470,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(300,520,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,560,600,30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150,610,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(300,610,100,30);
        cancel.addActionListener(this);
        add(cancel);

         getContentPane().setBackground(Color.WHITE);

         Label l1 = new Label("Page 3 :Account Details");
        l1.setBounds(250,40,250,40);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);

        Label type = new Label("Account Type:");
        type.setBounds(100,120,150,30);
        type.setFont(new Font("Raleway",Font.BOLD,22));
        add(type);

         

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==submit){

            String accountType =null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r2.isSelected()){
                accountType = "Current Account";
            }
            else if (r3.isSelected()){
                accountType = "Fixed Deposite Account";
            }
            else if(r4.isSelected()){
                accountType = "Recurring Deposite Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000l) + 5040936000000000l);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000l ) + 1000l);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }
            else if (c2.isSelected()){
                facility = facility + " INTERNET Banking";
            }
            else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if (c4.isSelected()){
                facility = facility + " EMAIL & SMS Alerts";
            }
            else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if (c6.isSelected()){
                facility = facility + " E-Statement";
            }
            try {
               if(accountType.equals("")){
                JOptionPane.showMessageDialog(null,"Account type is Required");

               }

                else{
                    Conn c = new Conn();
                    String query1 = "Insert into Signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "Insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n PIN: "+pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }

            }
            catch(Exception e){
                System.out.println(e);

            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);

        }
    
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
    
}
