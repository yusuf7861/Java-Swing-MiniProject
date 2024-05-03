/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PizzaMaker;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author yjama
 */
public class PizzaMaker extends JFrame {

//        Size Radio Buttons
    JPanel sizePanel = new JPanel();
    ButtonGroup sizeButtonGroup = new ButtonGroup();
    JRadioButton smallRadioButton = new JRadioButton();
    JRadioButton mediumRadioButton = new JRadioButton();
    JRadioButton largeRadioButton = new JRadioButton();
    GridBagConstraints gridConstraints;

//    Crust Panel
    JPanel crustPanel = new JPanel();
    ButtonGroup crustButtonGroup = new ButtonGroup();     // This class is used to create a multiple-exclusion scope for a set of buttons. Creating a set of buttons with the same ButtonGroup object means that turning "on" one of those buttons turns off all other buttons in the group.
    JRadioButton thinRadioButton = new JRadioButton();
    JRadioButton thikRadioButton = new JRadioButton();

//    Toppings
    JPanel toppingsPanel = new JPanel();
    JCheckBox cheeseCheckBox = new JCheckBox();
    JCheckBox mushroomsCheckBox = new JCheckBox();
    JCheckBox olivesCheckBox = new JCheckBox();
    JCheckBox onionsCheckBox = new JCheckBox();
    JCheckBox peppersCheckBox = new JCheckBox();
    JCheckBox tomatoesCheckBox = new JCheckBox();

    ButtonGroup whereButtonGroup = new ButtonGroup();
    JRadioButton eatInRadioButton = new JRadioButton();
    JRadioButton takeOutJRadioButton = new JRadioButton();
    JButton buildButton = new JButton();  // build button
    JButton exitButton = new JButton();   // exitButton

    String pizzaSize;
    String pizzaCrust;
    String pizzaWhere;
    String message;

    JCheckBox[] topping = new JCheckBox[6];

    public PizzaMaker() {
        setTitle("Pizza Order");
        setResizable(false);

        getContentPane().setLayout(new GridBagLayout());

//      Size Panel
        sizePanel.setLayout(new GridBagLayout());
        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
        smallRadioButton.setText("Small");
        smallRadioButton.setSelected(true);
        sizeButtonGroup.add(smallRadioButton);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        sizePanel.add(smallRadioButton, gridConstraints);

        smallRadioButton.addActionListener((ActionEvent e) -> {
            sizeRadioButtonActionPerformed(e);
        });

        mediumRadioButton.setText("Medium");
        sizeButtonGroup.add(mediumRadioButton);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.anchor = GridBagConstraints.WEST;
        sizePanel.add(mediumRadioButton, gridConstraints);
        mediumRadioButton.addActionListener((ActionEvent e) -> {
            sizeRadioButtonActionPerformed(e);
        });

        largeRadioButton.setText("Large");
        sizeButtonGroup.add(largeRadioButton);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        sizePanel.add(largeRadioButton, gridConstraints);
        largeRadioButton.addActionListener((ActionEvent e) -> {
            sizeRadioButtonActionPerformed(e);
        });
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=0;
        getContentPane().add(sizePanel, gridConstraints);
        
        
//        Crust Panel (Position and add each control, adding needed events)
        crustPanel.setLayout(new GridBagLayout());
        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust"));
        
//        Thin Crust 
        thinRadioButton.setText("Thin Crust");
        thinRadioButton.setSelected(true);
        crustButtonGroup.add(thinRadioButton);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=1;
        gridConstraints.anchor=GridBagConstraints.WEST;
        crustPanel.add(thinRadioButton, gridConstraints);
        thinRadioButton.addActionListener((ActionEvent e) -> {
            crustRadioButtonActionPerformed(e);
        });
        
//        Thick Crust
        thikRadioButton.setText("Thik Crust");
        crustButtonGroup.add(thikRadioButton);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=2;
        gridConstraints.anchor=GridBagConstraints.WEST;
        crustPanel.add(thikRadioButton, gridConstraints);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=1; 
        getContentPane().add(crustPanel, gridConstraints);
        thikRadioButton.addActionListener((ActionEvent e) -> {
            crustRadioButtonActionPerformed(e);
        });
        
        
//        Toppings Panel (Position and add each control) there are no methods for check boxes.
        toppingsPanel.setLayout(new GridBagLayout());
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        
//        Extra Cheese
        cheeseCheckBox.setText("Extra Cheese");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=0;
        gridConstraints.anchor=GridBagConstraints.WEST;
        toppingsPanel.add(cheeseCheckBox, gridConstraints);
        
//        Mushroom
        mushroomsCheckBox.setText("Mushroom");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=1;
        gridConstraints.anchor=GridBagConstraints.WEST;
        toppingsPanel.add(mushroomsCheckBox, gridConstraints);
        
//        Olives
        olivesCheckBox.setText("Olives");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=2;
        gridConstraints.anchor=GridBagConstraints.WEST;
        toppingsPanel.add(olivesCheckBox, gridConstraints);
        
//        Onions
        onionsCheckBox.setText("Onions");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=0;
        gridConstraints.anchor=GridBagConstraints.WEST;
        toppingsPanel.add(onionsCheckBox, gridConstraints);
        
//        Peppers
        peppersCheckBox.setText("Peppers");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=1;
        gridConstraints.anchor=GridBagConstraints.WEST;
        toppingsPanel.add(peppersCheckBox, gridConstraints);
        
//        Tomatoes
        tomatoesCheckBox.setText("Tomatoes");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=2;
        gridConstraints.anchor=GridBagConstraints.WEST;
        toppingsPanel.add(tomatoesCheckBox, gridConstraints);
        
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=0;
        gridConstraints.gridwidth=2;
        getContentPane().add(toppingsPanel, gridConstraints);
        
        
//        Now, Adding the four controls not in panels, two more radio buttons and two buttons.
//       EatIn
        eatInRadioButton.setText("Eat In");
        whereButtonGroup.add(eatInRadioButton);
        eatInRadioButton.setSelected(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=1;
        gridConstraints.anchor=GridBagConstraints.WEST;
        getContentPane().add(eatInRadioButton, gridConstraints);
        eatInRadioButton.addActionListener((ActionEvent e)->{
            whereButtonActionPerformed(e);
        });
        
//        Take Out
        takeOutJRadioButton.setText("Take Out");
        whereButtonGroup.add(takeOutJRadioButton);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=2;
        gridConstraints.gridy=1;
        gridConstraints.anchor=GridBagConstraints.WEST;
        getContentPane().add(takeOutJRadioButton, gridConstraints);
        takeOutJRadioButton.addActionListener((ActionEvent e)-> {
            whereButtonActionPerformed(e);
        });
        
//        Build Button
        buildButton.setText("Build");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx= 1;
        gridConstraints.gridy=2;
        getContentPane().add(buildButton, gridConstraints);
        buildButton.addActionListener((ActionEvent e) -> {
            buildButtonActionPerformed(e);
        });
        
//        Exit Button
        exitButton.setText("Exit");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=2;
        gridConstraints.gridy=2;
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener((ActionEvent e) -> {
            exitButtonActionPerformed(e);
        });
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 *(screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());

//        Initialize parameters
        pizzaSize = smallRadioButton.getText();
        pizzaCrust = thinRadioButton.getText();
        pizzaWhere = eatInRadioButton.getText();
        
//        Define an array of topping check boxes
        topping[0] = cheeseCheckBox;
        topping[1] = mushroomsCheckBox;
        topping[2] = olivesCheckBox;
        topping[3] = onionsCheckBox;
        topping[4] = peppersCheckBox;
        topping[5] = tomatoesCheckBox;

        
    }



    public static void main(String[] args) {
        PizzaMaker frame = new PizzaMaker();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void sizeRadioButtonActionPerformed(ActionEvent e) {
           pizzaSize = e.getActionCommand();
    }
    
    private void crustRadioButtonActionPerformed(ActionEvent e) {
        pizzaCrust = e.getActionCommand();
    }

    private void whereButtonActionPerformed(ActionEvent e) {
        pizzaWhere = e.getActionCommand();
    }

    private void buildButtonActionPerformed(ActionEvent e) {
//        Build a confirm dialogue box that displays your pizza type String message

        message = pizzaWhere + "\n";
        message += pizzaSize + " Pizza " + "\n";
        message += pizzaCrust + "\n";
        
//        Check each topping using the array
            for(int i= 0; i < 6; i++)
            {
                if(topping[i].isSelected())
                {
                    message += topping[i].getText() + "\n";
                }
            }
            
            JOptionPane.showConfirmDialog(null, message, "Your pizza", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void exitButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
