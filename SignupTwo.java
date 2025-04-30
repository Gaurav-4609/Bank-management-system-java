package BankManagementSystem.BankManagementSystem;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pannotextfield,aadhartextfield;
    JRadioButton scyes,scno,eayes,eano;
    JButton next;
    JComboBox religioncombobox,incomecombobox,categorycombobox,eq,occupationcombobox;
    String formno;
    
    SignupTwo(String formno){

        this.formno = formno;

       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetail = new JLabel("Page 2: Additional Details");
        additionaldetail.setBounds(280,70,500,25);
        additionaldetail.setFont(new Font("Raleway",Font.BOLD,20));
        add(additionaldetail);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(80,120,100,25);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        add(religion);


        String ValReligion[]  = {"Hindu","Muslim","Sikh","Christian","Other"};
        religioncombobox = new JComboBox<>(ValReligion);
        religioncombobox.setBounds(280,120,365,25);
        religioncombobox.setBackground(Color.WHITE);
        add(religioncombobox);

        JLabel category = new JLabel("Category:");
        category.setBounds(80,165,150,25);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);

        String ValCategory[] = {"General","OBC","SC","ST","Other"};
        categorycombobox = new JComboBox<>(ValCategory);
        categorycombobox.setBounds(280,165,365,25);
        categorycombobox.setBackground(Color.WHITE);
        add(categorycombobox);


        JLabel income = new JLabel("Income:");
        income.setBounds(80,210,150,25);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);


        String ValIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        incomecombobox = new JComboBox<>(ValIncome); 
        incomecombobox.setBounds(280,210,365,25);
        incomecombobox.setBackground(Color.WHITE);
        add(incomecombobox);


        JLabel educational = new JLabel("Educational/");
        educational.setBounds(80,255,150,25);
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(80,280,150,25);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualification);

        String ValEQ[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
        eq = new JComboBox<>(ValEQ);
        eq.setBounds(280,280,365,25);
        eq.setBackground(Color.WHITE);
        add(eq);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(80,345,150,25);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);


        String ValOccupation[] = {"Salried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupationcombobox = new JComboBox<>(ValOccupation);
        occupationcombobox.setBounds(280,345,365,25);
        occupationcombobox.setBackground(Color.WHITE);
        add(occupationcombobox);


        JLabel panno = new JLabel("PAN Number:");
        panno.setBounds(80,390,150,25);
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        add(panno);

        pannotextfield = new JTextField();
        pannotextfield.setBounds(280,390,365,25);
        pannotextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(pannotextfield);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(80,435,175,25);
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhar);

        aadhartextfield = new JTextField();
        aadhartextfield.setBounds(280,435,365,25);
        aadhartextfield.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadhartextfield);

        JLabel sc= new JLabel("Senior Citizen:");
        sc.setBounds(80,480,150,25);
        sc.setFont(new Font("Raleway",Font.BOLD,20));
        add(sc);


        scyes= new JRadioButton("YES");
        scyes.setBounds(280,480,100,25);
        scyes.setBackground(Color.WHITE);
        add(scyes);

        scno = new JRadioButton("NO");
        scno.setBounds(380,480,100,25);
        scno.setBackground(Color.WHITE);
        add(scno);

        ButtonGroup scbgr = new ButtonGroup();
        scbgr.add(scyes);
        scbgr.add(scno);

        JLabel ea = new JLabel("Exisiting Account:");
        ea.setBounds(80,525,175,25);
        ea.setFont(new Font("Raleway",Font.BOLD,20));
        add(ea);

        eayes= new JRadioButton("YES");
        eayes.setBounds(280,525,100,25);
        eayes.setBackground(Color.WHITE);
        add(eayes);

        eano = new JRadioButton("NO");
        eano.setBounds(380,525,100,25);
        eano.setBackground(Color.WHITE);
        add(eano);

        ButtonGroup eabgr = new ButtonGroup();
        eabgr.add(eayes);
        eabgr.add(eano);


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
        
        String religion = (String) religioncombobox.getSelectedItem();
        String category = (String) categorycombobox.getSelectedItem();
        String income = (String)  incomecombobox.getSelectedItem();
        String occupation = (String) occupationcombobox.getSelectedItem();
        String qualification = (String) eq.getSelectedItem();
        

        String SeniorCitizen = null;
        if(scyes.isSelected()){
            SeniorCitizen = "YES";
        }
        else if(scno.isSelected()){
            SeniorCitizen = "NO";   
        }

        String exisiting = null;
        if(eayes.isSelected()){
            exisiting = "YES";
        }
        else if(eano.isSelected()){
            exisiting = "NO";
        }
       
        String pan = pannotextfield.getText();
        String aadhar= aadhartextfield.getText();
        
        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+occupation+"','"+qualification+"','"+SeniorCitizen+"','"+exisiting+"','"+pan+"','"+aadhar+"')";
                
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

