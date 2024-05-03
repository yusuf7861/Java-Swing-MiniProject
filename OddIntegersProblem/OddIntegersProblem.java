/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OddIntegersProblem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author yjama
 */
public class OddIntegersProblem extends JFrame
{
    JLabel targetLabel;
    JTextField targetField;
    JButton generateButton;
    JTextArea outputArea;
    
    int targetValue;
    
    
    public static void main(String[] args) {
        OddIntegersProblem frame=new OddIntegersProblem();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public OddIntegersProblem() throws HeadlessException 
    {
        setTitle("Odd Integer Problem");
        
//        Creating Layout
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        
//        Label
        targetLabel=new JLabel("Enter target value: ");
        constraints.gridx=0;
        constraints.gridy=0;
        getContentPane().add(targetLabel, constraints);
        
//        TextField
        targetField=new JTextField(15);
        constraints.gridx=1;
        constraints.gridy=0;
        getContentPane().add(targetField, constraints);
        
        
//        Button
        generateButton=new JButton("Add Odd Integers");
        constraints.gridx=1;
        constraints.gridy=1;
        getContentPane().add(generateButton, constraints);
//      ActionListener
        generateButton.addActionListener(((e) -> {
            generateResult(e);
        }));
        
        
//        TextArea
        outputArea=new JTextArea();
        outputArea.setColumns(20);
        outputArea.setRows(20);
        outputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        constraints.gridx=0;
        constraints.gridy=4;
        getContentPane().add(outputArea, constraints);
        outputArea.setEnabled(false);
        
        
        
    }

    private void generateResult(ActionEvent e) {
        // Clear previous result
        outputArea.setText("");

        
        try {
            targetValue = Integer.parseInt(targetField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate the sum of consecutive odd integers until the sum exceeds the target value
        int sum = 0;
        int count = 0;
        int number = 1;
        while (sum < targetValue) {
            sum += number;
            number += 2; // Increment by 2 to get the next odd number
            count++;
        }

        // Display the result in the text area
        outputArea.append("Sum: " + sum + "\n");
        outputArea.append("Number of odd integers added: " + count + "\n");
    } 
    
}
