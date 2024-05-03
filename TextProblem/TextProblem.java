/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TextProblem;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author yjama
 */
public class TextProblem extends JFrame {

    JButton btn;
    
    private boolean isToggled = false;
    
    public static void main(String[] args) {
        TextProblem textProblem = new TextProblem();
        textProblem.setSize(300, 300);
//        Changing background of page
        Container cont = textProblem.getContentPane();
        cont.setBackground(Color.BLUE);

        textProblem.setVisible(true);
        textProblem.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    Constructor
    TextProblem() {
        setTitle("Toggle Button");
        btn = new JButton("Click Me");
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        getContentPane().add(btn, constraints);

        pack();
        
        btn.addActionListener((ActionEvent e) -> {
            textActionEvent(e);
        });
    }
    
    private void textActionEvent(ActionEvent e)
    {
        if(isToggled)
        {
            btn.setText("Click Me");
        }
        else
        {
            btn.setText("Clicked");
        }
        isToggled= !isToggled;
    }
}
