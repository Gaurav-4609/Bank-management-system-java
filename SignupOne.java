package BankManagementSystem.BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    Long random;
    JTextField nametextfield,fnametextfield,eatextfield,addresstextfield,citytextfield,statetextfield,pincodetextfield;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser datechooser;
    SignupOne(){

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel formno = new JLabel("APPLICATION  FORM  NO."+random);
        formno.setBounds(100, 20, 600, 40);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        add(formno);

        JLabel pageno = new JLabel("Page 1: Personal Details");
        pageno.setBounds(280,70,500,25);
        pageno.setFont(new Font("Raleway",Font.BOLD,20));
        add(pageno);

        JLabel name = new JLabel("Name:");
        name.setBounds(80,120,100,25);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

         nametextfield = new JTextField();
        nametextfield.setBounds(280,120,365,25);
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(nametextfield);
        

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(80,165,150,25);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);

         fnametextfield =new JTextField();
        fnametextfield.setBounds(280,165,365,25);
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnametextfield);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(80,210,150,25);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        datechooser = new JDateChooser(); 
        datechooser.setBounds(280,210,365,25);
        datechooser.setFont(new Font("Raleway",Font.BOLD,14));
        add(datechooser);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(80,255,150,25);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(280,255,100,25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(380,255,100,25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel ea = new JLabel("Email Address:");
        ea.setBounds(80,300,150,25);
        ea.setFont(new Font("Raleway",Font.BOLD,20));
        add(ea);

        eatextfield = new JTextField();
        eatextfield.setBounds(280,300,365,25);
        eatextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(eatextfield);

        JLabel ms = new JLabel("Maritial Status:");
        ms.setBounds(80,345,150,25);
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        add(ms);

        married = new JRadioButton("Married");
        married.setBounds(280,345,100,25);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(380,345,100,25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(500,345,100,25);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup bgr = new ButtonGroup();
        bgr.add(married);
        bgr.add(unmarried);
        bgr.add(other);

        JLabel address = new JLabel("Address:");
        address.setBounds(80,390,150,25);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        addresstextfield = new JTextField();
        addresstextfield.setBounds(280,390,365,25);
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(addresstextfield);

        JLabel city = new JLabel("City");
        city.setBounds(80,435,150,25);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        citytextfield = new JTextField();
        citytextfield.setBounds(280,435,365,25);
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(citytextfield);

        JLabel state = new JLabel("State");
        state.setBounds(80,480,150,25);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        statetextfield = new JTextField();
        statetextfield.setBounds(280,480,365,25);
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(statetextfield);

        JLabel pincode = new JLabel("Pincode");
        pincode.setBounds(80,525,150,25);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        pincodetextfield = new JTextField();
        pincodetextfield.setBounds(280,525,365,25);
        pincodetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(pincodetextfield);

        next = new JButton("Next");
        next.setBounds(545,575,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
    

        setLayout(null);
        setVisible(true);
        setSize(780,670);
        setLocation(250,10);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String dob =((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";   
        }

        String email = eatextfield.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if (other.isSelected()){
            marital = "Other";
        }

        String address = addresstextfield.getText();
        String city = citytextfield.getText();
        String state = statetextfield.getText();
        String pincode = pincodetextfield.getText();

        try{
            if(name.equals ("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     
    public static void main(String[] args) {
        new SignupOne();
    }
}
