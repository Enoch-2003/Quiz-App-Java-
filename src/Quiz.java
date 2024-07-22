

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {

        count=0; //initialize count to zero in case user chooses to polay again

        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
questions[0][0] = "Which method must be implemented by all threads?";
questions[0][1] = "start()";
questions[0][2] = "stop()";
questions[0][3] = "run()";
questions[0][4] = "main()";

questions[1][0] = "What is the default value of a local variable?";
questions[1][1] = "null";
questions[1][2] = "0";
questions[1][3] = "Depends on the data type";
questions[1][4] = "No default value for local variables";

questions[2][0] = "Which of the following is not an OOP concept in Java?";
questions[2][1] = "Inheritance";
questions[2][2] = "Encapsulation";
questions[2][3] = "Polymorphism";
questions[2][4] = "Compilation";

questions[3][0] = "Which of the following is a reserved keyword in Java?";
questions[3][1] = "object";
questions[3][2] = "strictfp";
questions[3][3] = "main";
questions[3][4] = "system";

questions[4][0] = "Which exception is thrown when a division by zero occurs?";
questions[4][1] = "NullPointerException";
questions[4][2] = "NumberFormatException";
questions[4][3] = "ArithmeticException";
questions[4][4] = "ArrayIndexOutOfBoundsException";

questions[5][0] = "Which of the following is not a Java feature?";
questions[5][1] = "Object-oriented";
questions[5][2] = "Use of pointers";
questions[5][3] = "Portable";
questions[5][4] = "Dynamic";

questions[6][0] = "What is the size of int in Java?";
questions[6][1] = "4 bytes";
questions[6][2] = "2 bytes";
questions[6][3] = "8 bytes";
questions[6][4] = "16 bytes";

questions[7][0] = "Which of the following is a superclass of every class in Java?";
questions[7][1] = "ArrayList";
questions[7][2] = "Abstract class";
questions[7][3] = "Object class";
questions[7][4] = "String";

questions[8][0] = "Which operator is used by Java run-time implementations to free memory?";
questions[8][1] = "delete";
questions[8][2] = "free";
questions[8][3] = "new";
questions[8][4] = "None";

questions[9][0] = "Which of these cannot be used for a variable name in Java?";
questions[9][1] = "identifier";
questions[9][2] = "keyword";
questions[9][3] = "identifier_name";
questions[9][4] = "none of the mentioned";

answers[0][1] = "run()";
answers[1][1] = "No default value for local variables";
answers[2][1] = "Compilation";
answers[3][1] = "strictfp";
answers[4][1] = "ArithmeticException";
answers[5][1] = "Use of pointers";
answers[6][1] = "4 bytes";
answers[7][1] = "Object class";
answers[8][1] = "None";
answers[9][1] = "keyword";

        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color (0,255,0));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        submit.setVisible(false);
        add(submit);
        
        start(count);
        
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                next.setVisible(false);
                submit.setVisible(true);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 30
        g.setColor(Color.GREEN);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.setColor(Color.GREEN);
            if(timer < 15 && timer%2 == 0){
                g.setColor(Color.RED);
            }
            g.drawString(time, 1100, 500);
        } else {
            g.setColor(Color.RED);
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 29
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 30;
        } else if (timer < 0) {
            timer = 30;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setVisible(true);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Login();
    }
}