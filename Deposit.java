package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit,back;
    JTextField text;
    String pinnumber;

    Deposit(String pinnumber){
        this.pinnumber= pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label =  new JLabel(i3);
        label.setBounds(0,0,900,770);
        add(label);

        JLabel amount = new JLabel("Enter the amount you want to deposit ");
        amount.setBounds(170,260,500,20);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("SYSTEM",Font.BOLD,16));
        label.add(amount);

        text = new JTextField();
        text.setBounds(170,300,300,25);
        text.setFont(new Font("RALEWAY",Font.BOLD,22));
        label.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,415,150,28);
        deposit.addActionListener(this);
        label.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,445,150,28);
        back.addActionListener(this);
        label.add(back);

        setSize(900,770);
        setUndecorated(true);
        setLocation(270,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit ){

            String number= text.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }
            else{
                try{
                Conn c = new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

                }
                 catch(Exception e){
                    System.out.println(e);
                }
            }

        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
