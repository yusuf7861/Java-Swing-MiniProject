/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeepProblem;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author yjama
 */
public class BeepApplication extends JFrame {
    
    JButton btn;
    
    public static void main(String[] args) {
        BeepApplication ba=new BeepApplication();
        ba.setSize(300, 300);
        Container cnt=new Container();
        cnt.setBackground(Color.GRAY);
        ba.setVisible(true);
        ba.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public BeepApplication() {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        
//        Beep Button
        btn=new JButton("Beep");
        constraints.gridx=1;
        constraints.gridy=1;
        getContentPane().add(btn, constraints);
        pack();
        
        btn.addActionListener((ActionEvent e) -> {      // used lambda expression
            beepActionListener(e);
        });
    }
    
    
    private void beepActionListener(ActionEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
    }
    
}
