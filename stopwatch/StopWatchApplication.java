/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stopwatch;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author yjama
 */
public class StopWatchApplication extends JFrame {

    /**
     * @param args the command line arguments
     */
//    Declared Controls Used
    //    Buttons
    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    JButton exitButton = new JButton();

//    Labels
    JLabel startLabel = new JLabel();
    JLabel stopLabel = new JLabel();
    JLabel elapsedLabel = new JLabel();

//    TextFields
    JTextField startTextField = new JTextField();
    JTextField stopTextField = new JTextField();
    JTextField elapsedTextField = new JTextField();
    
    //        these variables are to be used in actionListeners
        long startTime;
        long stopTime;
        double elapsedTime;
        
        
        Timer timer;    // Timer to update elapsed time
        

    public static void main(String[] args) {
        StopWatchApplication swa = new StopWatchApplication();

//        Setting Size, Visibility and Exit-on-close Operations
        swa.setSize(500, 500);
        
        // Changes background of page
        Container container=swa.getContentPane(); 
        container.setBackground(Color.GRAY);
        
        swa.setVisible(true);
        swa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public StopWatchApplication() {
//        Frame Constructor
        setTitle("Stopwatch Application");
        getContentPane().setLayout(new GridBagLayout()); // add controls
        GridBagConstraints gridConstraints = new GridBagConstraints();

//        Start Button
        startButton.setText("Start Timing");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        getContentPane().add(startButton, gridConstraints);

//        Stop Button
        stopButton.setText("Stop Timing");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        getContentPane().add(stopButton, gridConstraints);

//        End Button
        exitButton.setText("Exit");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(exitButton, gridConstraints);

//        Start Label
        startLabel.setText("Start Time");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        getContentPane().add(startLabel, new GridBagConstraints());

//        Stop Label
        stopLabel.setText("Stop Time");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(stopLabel, gridConstraints);

//        Elapsed Label
        elapsedLabel.setText("Elapsed Time(sec) ");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(elapsedLabel, gridConstraints);

//        Start Text Field
        startTextField.setText("");
        startTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        getContentPane().add(startTextField, gridConstraints);

//        Stop TextField
        stopTextField.setText("");
        stopTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        getContentPane().add(stopTextField, gridConstraints);

//        Elapsed TextField
        elapsedTextField.setText("");
        elapsedTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        getContentPane().add(elapsedTextField, gridConstraints);
        
        pack();
        
//        Initially disable stopButton
        stopButton.setEnabled(false);
        
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                startButtonActionPerformed(e);
                
//                Stop button will only enable after start Button
                stopButton.setEnabled(true);
            }
        }
        );
                
        stopButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stopButtonActionPerformed(e);
            }
        }
        );
        
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionListener(e);
            }
        }
        );
        
        // Create and start Timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateElapsedTime();
            }
        });
        timer.start();
        
    }
    
    private void startButtonActionPerformed(ActionEvent e)
    {
        // click of start timing button
        startTime = System.currentTimeMillis();
        startTextField.setText(String.valueOf(startTime));
        stopTextField.setText("");
        elapsedTextField.setText("");
    }
    
    private void stopButtonActionPerformed(ActionEvent e)
    {
        // click if stop timing button
        stopTime = System.currentTimeMillis();
        stopTextField.setText(String.valueOf(stopTime));
        updateElapsedTime();    // calling elapsed time method
    }
    
    private void exitButtonActionListener(ActionEvent e)
    {
        System.exit(0);
    }
    
    private void updateElapsedTime() {
        elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
        elapsedTextField.setText(String.valueOf(elapsedTime));
    }
}
