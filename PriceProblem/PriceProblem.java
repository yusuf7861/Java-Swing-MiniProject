/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/*
The neighborhood children built a lemonade stand.The hotter it is, the more they can charge. Build an application that
produces the selling price, based on temperature:
*/

package PriceProblem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 * @author yjama
 */
public class PriceProblem extends JFrame
{
    JButton generatePriceButton;
    JLabel priceLabel;
    JTextField priceTextField;
    
    int temp=0;
    
    public static void main(String[] args) {
        PriceProblem frame=new PriceProblem();
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

    public PriceProblem() throws HeadlessException 
    {
        setTitle("Price Problem");
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        
        
//        Generate button
        generatePriceButton=new JButton("Generate Price");
        constraints.gridx=1;
        constraints.gridy=0;
        getContentPane().add(generatePriceButton, constraints);
        
//        textField
        priceTextField=new JTextField(15);
        constraints.gridx=1;
        constraints.gridy=3;
        getContentPane().add(priceTextField, constraints);
        
//        Label
        priceLabel=new JLabel("");
        constraints.gridx=1;
        constraints.gridy=4;
        getContentPane().add(priceLabel, constraints);
        
        
        pack();
        
        generatePriceButton.addActionListener((ActionEvent e) -> 
        {
            generatePriceButtonActionEvent(e);
        });
    }

    private void generatePriceButtonActionEvent(ActionEvent e) 
    {
        String price= priceTextField.getText();
        temp = Integer.parseInt(price);
        
        if(temp < 50)
        {
            priceLabel.setText("Don't bother");
        }
        else if(temp >= 50 && temp <= 60)
        {
            priceLabel.setText("\u20B9 20");
        }
        else if(temp >= 61 && temp <= 70)
        {
            priceLabel.setText("\u20B9 25");
        }
        else if(temp >= 71 && temp <= 80)
        {
            priceLabel.setText("\u20B9 30");
        }
        else if(temp >= 81 && temp <= 85)
        {
            priceLabel.setText("\u20B9 40");
        }
        else if(temp >= 86 && temp <= 90)
        {
            priceLabel.setText("\u20B9 50");
        }
        else if(temp >= 91 && temp <= 95)
        {
            priceLabel.setText("\u20B9 55");
        }
        else if(temp >= 96 && temp <= 100)
        {
            priceLabel.setText("\u20B9 65");
        }
        else if(temp > 100)
        {
            priceLabel.setText("\u20B9 75");
        }
        
    }
    
    
}
