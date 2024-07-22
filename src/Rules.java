

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to Java Quiz");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Algerian", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Please revise the basic concepts of Java before attempting this test" + "<br><br>" +
                "2. All questions are MCQs and there is only one correct answer for each question" + "<br><br>" +
                "3. It is mandatory to attemp all the questions" + "<br><br>" +
                "4. You will be alotted 30 sec to answer each question" + "<br><br>" +
                "5. Once the alotted time runs out you will be taken to the next question automatically" + "<br><br>" +
                "6. The 50-50 lifeline helps you to narrow down the given options making it easier for you to choose the correct answer" + "<br><br>" +
                "7. The lifeline can only be used once. So use it carefully and only when required" + "<br><br>" +
                "8. Take your time reading the rules and select start when you are ready. Good Luck Mr."+ name + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new Rules("User");
    }
}