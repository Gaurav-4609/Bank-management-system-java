package BankManagementSystem.BankManagementSystem;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinnumber;

    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,770, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,770);
        add(label);

        JButton back = new JButton("Back");
        back.setBounds(355,445,150,28);
        back.addActionListener(this);
        label.add(back);

         Conn c = new Conn();
         int balance = 0;
            try{


        //         Class.forName("com.mysql.cj.jdbc.Driver");
        //   Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","uttu");
        //   Statement s = c.createStatement();

        
                ResultSet rs =  c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){

                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
                catch(Exception e){
                    System.out.println(e);
                }

                JLabel text = new JLabel("Your Current Account Banlance is: "+ balance);
                text.setBounds(170,250,400,30);
                text.setForeground(Color.WHITE);
                label.add(text);


        setLocation(270,0);
        setUndecorated(true);
        setVisible(true);
        setSize(900,770);
        
    }


    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber);
    }

    public static void main(String[] args) {

        new BalanceEnquiry("");

        
        
    }
}
