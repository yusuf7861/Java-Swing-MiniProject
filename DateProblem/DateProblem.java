/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DateProblem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author yjama
 */
public class DateProblem extends JFrame {

    JButton button;
    JTextField textField;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Timer timer;

    public static void main(String[] args) {
        DateProblem frame = new DateProblem();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    Constructor
    public DateProblem() throws HeadlessException {
        setTitle("Date Problem");
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Button
        button = new JButton("Today ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        getContentPane().add(button, constraints);

//        TextField
        textField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        getContentPane().add(textField, constraints);
        pack();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        formatDate(e);
                    }
                });
                timer.start();
                formatDate(e);
            }
        }
        );

    }

    private void formatDate(ActionEvent e) {
        String formattedDate = dateFormat.format(new Date()); // Format the current date and time
        textField.setText(formattedDate);
    }

}
