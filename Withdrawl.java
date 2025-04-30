package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdraw,back;
    JTextField text;
    String pinnumber;

    Withdrawl(String pinnumber){
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

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,415,150,28);
        withdraw.addActionListener(this);
        label.add(withdraw);

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
        String number= text.getText();
            Date date = new Date();
        if(ae.getSource() == withdraw ){
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }
             else {
           // String amount = ((JButton)ae.getSource()).getText().substring(3);

            Conn c = new Conn();
            try{
                ResultSet rs =  c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){

                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                

                if(ae.getSource()!=back && balance < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE");
                    return;
                }
                
                else{
                  //  Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " +number+ " Debited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                
            



            // else{
            //     try{
            //     Conn c = new Conn();
            //     String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
            //     c.s.executeUpdate(query);
            //     JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
            //     setVisible(false);
            //     new Transactions(pinnumber).setVisible(true);

            //     }
            //      catch(Exception e){
            //         System.out.println(e);
            //     }
            // }

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
        else{
             setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
