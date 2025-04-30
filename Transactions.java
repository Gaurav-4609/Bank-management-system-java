package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawl,fastcash,ministatement,balance,pinchange,exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,770);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220,260,500,30);
        text.setFont(new Font("SYSTEM",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,355,150,28);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,355,150,28);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,385,150,28);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,385,150,28);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,415,150,28);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(355,415,150,28);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("EXIT");
        exit.setBounds(355,445,150,28);
        exit.addActionListener(this);
        image.add(exit);

       setSize(900,770);
       setUndecorated(true);
       setLocation(270,0);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Transactions("");
        
    }
}
