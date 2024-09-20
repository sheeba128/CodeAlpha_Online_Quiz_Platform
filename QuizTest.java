import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class QuizTest extends JFrame implements ActionListener {

    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext, btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    QuizTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);

        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30, 40, 450, 20);
        radioButtons[0].setBounds(50, 80, 450, 20);
        radioButtons[1].setBounds(50, 110, 200, 20);
        radioButtons[2].setBounds(50, 140, 200, 20);
        radioButtons[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);


    }

    void setData() {
        radioButtons[4].setSelected(true);
        if (current == 0) {
            label.setText("Question 1: Which is the official language for Android Development? ");
            radioButtons[0].setText("Java");
            radioButtons[1].setText("Kotlin");
            radioButtons[2].setText("C++");
            radioButtons[3].setText("JavaScript");


        }
        if (current == 1) {
            label.setText("Question 2: What is the default value of a boolean variable in Java? ");
            radioButtons[0].setText("null");
            radioButtons[1].setText("false");
            radioButtons[2].setText("true");
            radioButtons[3].setText("0");


        }
        if (current == 2) {
            label.setText("Question 3: Which of the following is not a valid access modifier in Java? ");
            radioButtons[0].setText("protected");
            radioButtons[1].setText("default");
            radioButtons[2].setText("private");
            radioButtons[3].setText("package");


        }
        if (current == 3) {
            label.setText("Question 4: What is the primary function of an operating system?");
            radioButtons[0].setText("To browse the internet");
            radioButtons[1].setText("To manage hardware resources and provide services to applications");
            radioButtons[2].setText(" To run antivirus software");
            radioButtons[3].setText("To design websites");


        }
        if (current == 4) {
            label.setText("Question 5: Which of the following data types does not exist in Java? ");
            radioButtons[0].setText("byte");
            radioButtons[1].setText("float");
            radioButtons[2].setText("long");
            radioButtons[3].setText("doublefloat");


        }
        if (current == 5) {
            label.setText("Question 6:  Which keyword is used to create an object in Java? ");
            radioButtons[0].setText("new");
            radioButtons[1].setText("create");
            radioButtons[2].setText("make");
            radioButtons[3].setText("instantiate");


        }


        if (current == 6) {
            label.setText("Question 7:Which one of these is a type of network topology?");
            radioButtons[0].setText("Circular");
            radioButtons[1].setText("Square");
            radioButtons[2].setText("Star");
            radioButtons[3].setText("Hexagon");


        }
        if (current == 7) {
            label.setText("Question 8:Which of the following loops will always execute at least once?");
            radioButtons[0].setText("for");
            radioButtons[1].setText("while");
            radioButtons[2].setText("do-while");
            radioButtons[3].setText("for-each");


        }
        if (current == 8) {
            label.setText("Question 9: What is the purpose of the final keyword in Java?");
            radioButtons[0].setText("To make a variable immutable");
            radioButtons[1].setText("To allow inheritance of a class");
            radioButtons[2].setText("To allow method overriding");
            radioButtons[3].setText("To make a class abstract");


        }
        if (current == 9) {
            label.setText("Question 10: What is JDK ");
            radioButtons[0].setText("Java Development Kit");
            radioButtons[1].setText("Java Dynamic Kotlin");
            radioButtons[2].setText("Java Develop Kit");
            radioButtons[3].setText("Java Dynamic Kerberos");


        }

        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButtons[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    boolean checkAns() {
        if (current == 0) {
            return (radioButtons[1].isSelected());
        }
        if (current == 1) {
            return (radioButtons[1].isSelected());
        }
        if (current == 2) {
            return (radioButtons[3].isSelected());
        }
        if (current == 3) {
            return (radioButtons[1].isSelected());
        }
        if (current == 4) {
            return (radioButtons[3].isSelected());
        }
        if (current == 5) {
            return (radioButtons[0].isSelected());
        }
        if (current == 6) {
            return (radioButtons[2].isSelected());
        }
        if (current == 7) {
            return (radioButtons[2].isSelected());
        }
        if (current == 8) {
            return (radioButtons[0].isSelected());
        }
        if (current == 9) {
            return (radioButtons[0].isSelected());
        }
        return false;


    }

    public static void main(String[] args) {
        new QuizTest("Simple Quiz App");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (checkAns())
                count = count + 1;
            current++;
            setData();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (checkAns())
                count += 1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers are" + count);
            System.exit(0);
        }

    }
}
