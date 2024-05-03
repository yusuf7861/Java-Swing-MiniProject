
package RandomNumberProblem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author yjama
 */
public class RandomNumberProblem extends JFrame
{
    JButton btn;
    JTextArea textArea;
    
    public static void main(String[] args) {
        RandomNumberProblem frame=new RandomNumberProblem();
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

//    Constructor
    public RandomNumberProblem() throws HeadlessException 
    {
        setTitle("Random Number Generator");
//        Creating Layout
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        
//        Button
        btn=new JButton("Generate");
        constraints.gridx=1;
        constraints.gridy=0;
        getContentPane().add(btn, constraints);
        
//        textArea
        textArea=new JTextArea();
        textArea.setColumns(20);
        constraints.gridx=1;
        constraints.gridy=1;
        getContentPane().add(textArea, constraints);
        
        
        btn.addActionListener((ActionEvent e) -> {
            btnActionPerformed(e);
        });
        
        pack();
    }

    private void btnActionPerformed(ActionEvent e) {
        Random randomNo = new Random();
        int number = randomNo.nextInt(100) + 1; // Generates a number between 1 and 100
        textArea.setText(String.valueOf(number));
    }
    
    
}
