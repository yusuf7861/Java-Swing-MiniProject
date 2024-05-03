/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EnabledProblem;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author yjama
 */
public class EnabledProblem extends JFrame {

    JButton btn1;
    JButton btn2;

    private boolean isButton1Disabled = false;
    private boolean isButton2Disabled = false;

    public static void main(String[] args) {

        EnabledProblem frame = new EnabledProblem();
        frame.setSize(300, 300);

//        Change Background color
        Container container = frame.getContentPane();
        container.setBackground(Color.black);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public EnabledProblem() {
        setTitle("Button Enabled Disable Problem");
        btn1 = new JButton();
        btn2 = new JButton();
        getContentPane().setLayout(new GridBagLayout());
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

//        Button 1
        btn1.setText("Click Me");
        constraints.gridx = 1;
        constraints.gridy = 0;
//        btn1.setMargin();
        getContentPane().add(btn1, constraints);

//        Button 2
        btn2.setText("Click Me");
        constraints.gridx = 1;
        constraints.gridy = 1;
        getContentPane().add(btn2, constraints);
        pack();

// Button 1 Action
btn1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Toggle the state of Button 1
        isButton1Disabled = !isButton1Disabled;

        // Update Button 2 based on the state of Button 1
        btn2.setEnabled(isButton1Disabled);

        // Change the text of Button 1 to indicate its state
        if (isButton1Disabled) {
            btn1.setText("Button 1 (Disabled)");
        } else {
            btn1.setText("Button 1 (Enabled)");
        }
    }
});

// Button 2 Action
btn2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Toggle the state of Button 2
        isButton2Disabled = !isButton2Disabled;

        // Update Button 1 based on the state of Button 2
        btn1.setEnabled(isButton2Disabled);

        // Change the text of Button 2 to indicate its state
        if (isButton2Disabled) {
            btn2.setText("Button 2 (Disabled)");
        } else {
            btn2.setText("Button 2 (Enabled)");
        }
    }
});

        
        
    }

}
