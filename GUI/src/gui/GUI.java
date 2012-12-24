/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class GUI extends JFrame implements FieldChanger
{
    private JButton getRes = new JButton();
    private JComboBox unit = new JComboBox();
    private JLabel instruct = new JLabel();
    private JTextField temp = new JTextField();
    private JTextField celTemp = new JTextField();
    private JTextField kelTemp = new JTextField();
    private JTextField farTemp = new JTextField();
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu();
    private JMenuItem exit = new JMenuItem();
    private JMenuItem sendMail = new JMenuItem(); 
    private JMenu help = new JMenu();
    private JMenuItem about = new JMenuItem();
    private Controller controller;
    private About aboutframe = new About();
    
    private void ExitItemActionPerformed(ActionEvent evt) 
    {
        processWindowEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }
    
    private void getResActionPerformed(ActionEvent evt) 
    {
        if ("".equals(temp.getText()))
        {
            temp.setText("0");
        }
        controller.getResult();
    }  
    
    private void AboutItemActionPerformed(ActionEvent evt)
    {
        aboutframe.setVisible(true);
    }
    
    private void initComponents() 
    {
        controller = new Controller (unit, temp, this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        instruct.setText("Выберите единицу измерения и введите величину");
        unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Celsius", "Kelvin", "Fahrenheit" }));
        
        getRes.setText("Get result!");
        getRes.addActionListener(new java.awt.event.ActionListener() 
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                getResActionPerformed(evt);
            }
        });
        
        celTemp.setText(" ");
        celTemp.setEditable(false);
        
        kelTemp.setText(" ");
        kelTemp.setEditable(false);
        
        farTemp.setText(" ");
        farTemp.setEditable(false);   
        
        sendMail.setText("Send email");
        exit.setText("Exit");
        
        file.setText("File");    
        file.add(sendMail);
        file.add(exit);
        
        exit.addActionListener(new java.awt.event.ActionListener() 
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                ExitItemActionPerformed(evt);
            }
        });
        
        about.addActionListener(new java.awt.event.ActionListener() 
        {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) 
             {
                 AboutItemActionPerformed(evt);
             }
         });
        
        help.setText("Help");
        about.setText("About");
        help.add(about);

        menu.add(file);
        menu.add(help);
        
        
        setJMenuBar(menu);
  
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instruct)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(celTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getRes)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kelTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(farTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instruct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getRes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(farTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }
    public GUI() 
    {
        super("Temperature converter");
        initComponents();
    }
    
    public static void main(String[] args) 
    {
        GUI app = new GUI();
        app.setVisible(true);
    }

    @Override
    public void changeFields(String cel, String kel, String far) 
    {
        celTemp.setText(cel);
        kelTemp.setText(kel);
        farTemp.setText(far);
    }
}
