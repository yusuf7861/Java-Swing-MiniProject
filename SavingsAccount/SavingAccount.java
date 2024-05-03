/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
    F=D[(1+I)^M-1]/I

    where, 
    F=Final Amount
    D=Monthly deposit amount
    I=Monthly Interest Rate
    M=Number of Months
 */
package SavingsAccount;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

/**
 *
 * @author yjama
 */
public class SavingAccount extends JFrame {
//    Labels

    JLabel depositLabel;
    JLabel interestLabel;
    JLabel monthsLabel;
    JLabel finalLabel;

//    TextFields
    JTextField depositTextField;
    JTextField interestTextField;
    JTextField monthsTextField;
    JTextField finalTextField;

//    Buttons
    JButton calculateButton;
    JButton ExitButton;
    JButton clearButton;

//    MAIN METHOD
    public static void main(String[] args) {
        SavingAccount frame = new SavingAccount();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    Constructors
    public SavingAccount() throws HeadlessException {

//        creating GridBagConstraints
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

//        Labels
        depositLabel = new JLabel("Monthly Deposit");
        cons.gridx = 0;
        cons.gridy = 0;
        getContentPane().add(depositLabel, cons);
        interestLabel = new JLabel("Yearly Interest");
        cons.gridx = 0;
        cons.gridy = 1;
        getContentPane().add(interestLabel, cons);
        monthsLabel = new JLabel("Number of Months");
        cons.gridx = 0;
        cons.gridy = 2;
        getContentPane().add(monthsLabel, cons);
        finalLabel = new JLabel("Final Balance");
        cons.gridx = 0;
        cons.gridy = 3;
        getContentPane().add(finalLabel, cons);

//      TextFields
        depositTextField = new JTextField(15);
        cons.gridx = 2;
        cons.gridy = 0;
        getContentPane().add(depositTextField, cons);
        interestTextField = new JTextField(15);
        cons.gridx = 2;
        cons.gridy = 1;
        getContentPane().add(interestTextField, cons);
        monthsTextField = new JTextField(15);
        cons.gridx = 2;
        cons.gridy = 2;
        getContentPane().add(monthsTextField, cons);

        finalTextField = new JTextField(15);
        finalTextField.setFocusable(false);     // Setting Focus to false so that the cursor will not go to finaltextfield as it can't be editable
        cons.gridx = 2;
        cons.gridy = 3;
        getContentPane().add(finalTextField, cons);

//      Buttons
        calculateButton = new JButton("Calculate");
        cons.gridx = 1;
        cons.gridy = 4;
        getContentPane().add(calculateButton, cons);

        ExitButton = new JButton("Exit");
        ExitButton.setFocusable(false);
        cons.gridx = 1;
        cons.gridy = 5;
        getContentPane().add(ExitButton, cons);

        clearButton = new JButton("Clear");
        clearButton.setFocusable(false);
        cons.gridx = 2;
        cons.gridy = 4;
        getContentPane().add(clearButton, cons);
        clearButton.addActionListener((ActionEvent e)
                -> {
            clearButtonActionPerformed(e);
        });

        pack();

//        Buttons ActionListeners
        calculateButton.addActionListener((ActionEvent e) -> {
            calculateButtonListener(e);
        });

        ExitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        }
        );

        depositTextField.addActionListener((ActionEvent e) -> {
            depositTextFieldActionPerfomed(e); // transfer focus 
        });
        interestTextField.addActionListener((ActionEvent e) -> {
            interestTextFieldActionPerformed(e); // transfer focus
        });
        monthsTextField.addActionListener((ActionEvent e) -> {
            monthsTextFieldActionPerformed(e); // transfer focus
        });
        finalTextField.addActionListener((ActionEvent e) -> {
            finalTextFieldActionPerformed(e);
        });
    }

    private void calculateButtonListener(ActionEvent e) {
        double deposit;
        double interest;
        double months;
        double finalBalance;
        double monthlyInterest;

        double finalCompute, intChange;
        int intDirection;

//        compute that missing value and put in text box
        if (depositTextField.getText().trim().equals("")) {
            // deposit missing
            // read other values from text fields
            // make sure valid before computing
            if (!validateDecimalNumber(monthsTextField) || !validateDecimalNumber(interestTextField) || !validateDecimalNumber(depositTextField)) {

            }
        }

//        read values from textfields
        deposit = Double.parseDouble(depositTextField.getText());
        interest = Double.parseDouble(interestTextField.getText());
        monthlyInterest = interest / 1200;
        months = Double.parseDouble(monthsTextField.getText());

//        compute value and put in text field
        if (interest == 0) {
            finalBalance = deposit * months;
        } else {
            finalBalance = deposit * (Math.pow((1 + monthlyInterest), months) - 1) / monthlyInterest;
            finalTextField.setText(new DecimalFormat("0.00").format(finalBalance));
        }
    }

    public boolean validateDecimalNumber(JTextField tf) {
        // checks to see if text fields contains valid decimal number with only digits and a single decimal point 
        String s = tf.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;

        if (s.length() == 0) {
            valid = false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    continue;
                } else if (c == '.' && !hasDecimal) {
                    hasDecimal = true;
                } else {
                    // invalid character found
                    valid = false;
                }
            }
        }
        if (valid) {
            tf.setText(s);
        } else {
            tf.setText("");
            tf.requestFocus();
        }
        return (valid);
    }

    private void clearButtonActionPerformed(ActionEvent e) {
        // clear TextFiles
        depositTextField.setText("");
        interestTextField.setText("");
        monthsTextField.setText("");
        finalTextField.setText("");
        depositTextField.requestFocus();
    }

//    Methods 
    private void depositTextFieldActionPerfomed(ActionEvent e) {
        depositTextField.transferFocus();
    }

    private void interestTextFieldActionPerformed(ActionEvent e) {
        interestTextField.transferFocus();
    }

    private void monthsTextFieldActionPerformed(ActionEvent e) {
        monthsTextField.transferFocus();
    }

    private void finalTextFieldActionPerformed(ActionEvent e) {
        finalTextField.transferFocus();
    }

}
