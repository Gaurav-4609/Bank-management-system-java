package BankManagementSystem.BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener  {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;

    PinChange(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,770);
        add(label);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(265,240,300,35);
        label.add(text);

        JLabel pintext = new JLabel("NEW PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("SYSTEM",Font.BOLD,16));
        pintext.setBounds(160,280,300,25);
        label.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,280,180,25);
        label.add(pin);

        JLabel repintext = new JLabel("Re-Enter NEW PIN:");
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(160,315,300,25);
        label.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,315,180,25);
        label.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,415,150,28);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("BACK");
        back.setBounds(355,445,150,28);
        back.addActionListener(this);
        label.add(back);


       setSize(900,770);
       setUndecorated(true);
       setLocation(270,0);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }
            

            Conn c = new Conn();
            String query1 ="update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String query2 ="update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String query3 ="update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null,"PIN changed Successfully");

            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }


        catch(Exception e){
            System.out.println(e);
        }
    }
    else{
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    }

   
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
        
    }
}
    

