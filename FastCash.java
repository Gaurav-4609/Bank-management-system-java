package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawl,fastcash,ministatement,balance,pinchange,exit,hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,770);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(220,260,500,30);
        text.setFont(new Font("SYSTEM",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        hundred = new JButton("Rs 100");
        hundred.setBounds(170,355,150,28);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355,355,150,28);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(170,385,150,28);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355,385,150,28);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170,415,150,28);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand= new JButton("Rs 10000");
        tenThousand.setBounds(355,415,150,28);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("BACK");
        back.setBounds(355,445,150,28);
        back.addActionListener(this);
        image.add(back);

       setSize(900,770);
       setUndecorated(true);
       setLocation(270,0);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);

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

                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE");
                    return;
                }
                else{
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+"Debited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }


            }
            catch(Exception e){
                System.out.println(e);
            }
        }
       

    }
    public static void main(String[] args) {
        new FastCash("");
        
    }
}
