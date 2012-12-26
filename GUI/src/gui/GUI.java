/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

abstract class MyField extends JTextField implements Observer 
{
    
}

public class GUI extends JFrame implements SendingListener
{
    private JButton getRes = new JButton();
    private JComboBox unit = new JComboBox();
    private JLabel instruct = new JLabel();
    private JTextField temp = new JTextField();
    private MyField celTemp;
    private MyField kelTemp;
    private MyField farTemp;
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu();
    private JMenuItem exit = new JMenuItem();
    private JMenuItem sendMail = new JMenuItem(); 
    private JMenu help = new JMenu();
    private JMenuItem about = new JMenuItem();
    private Controller controller;
    private About aboutframe = new About();
    private Sending send = new Sending();
    private SendFrame sf = new SendFrame();
    private SetEmailFrame sef = new SetEmailFrame(this); 
    
    private void SendItemActionPerformed(ActionEvent evt) 
    {
        sef.setLocationRelativeTo(this);
        sef.setVisible(true);
    }
    
    private void ExitItemActionPerformed(ActionEvent evt) 
    {
        processWindowEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }
    
    private void KeyActionPerformed(KeyEvent evt) 
    {
        try 
        {
            Integer.parseInt(temp.getText());
            controller.getResult((String)unit.getSelectedItem(), temp.getText());
        } 
        catch (Exception e)
        {
            temp.setText("Error");
        }      
    }  
    
    
    private void BoxActionPerformed(ActionEvent evt) 
    {
        controller.getResult((String)unit.getSelectedItem(), temp.getText());    
    }  
    
    private void AboutItemActionPerformed(ActionEvent evt)
    {
        aboutframe.setVisible(true);
    }
    
    private void initComponents() 
    {
        celTemp = new MyField() 
        {

            @Override
            public void update(Observable o, Object o1) 
            {    
                setText(((FieldsPackage) o1).getCel());
            }
        };
        kelTemp = new MyField() 
        {

            @Override
            public void update(Observable o, Object o1) 
            {
                setText(((FieldsPackage) o1).getKel());
            }
        };
        farTemp = new MyField() 
        {

            @Override
            public void update(Observable o, Object o1) 
            {
                setText(((FieldsPackage) o1).getFar());
            }
        };
        
        controller = new Controller ();
        controller.addObserver(celTemp);
        controller.addObserver(kelTemp);
        controller.addObserver(farTemp);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        instruct.setText("Выберите единицу измерения и введите величину");
        
        unit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Celsius", "Kelvin", "Fahrenheit" }));
        unit.addActionListener(new java.awt.event.ActionListener() 
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                BoxActionPerformed(evt);
            }
        });
        
        temp.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyReleased(KeyEvent evt) 
            {
                KeyActionPerformed(evt);
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
        
        sendMail.setText("Send results");
        sendMail.addActionListener(new java.awt.event.ActionListener() 
        {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent evt) 
             {
                 SendItemActionPerformed(evt);
             }
         }); 
        
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
    public void sendingfinished(boolean success) 
    {
        sendMail.setEnabled(true);
        sf.setVisible(false);
        String mes;
        mes = success ? "Mail was sent successfully" : "Message wasn't sent";
        ErrorFrame rf = new ErrorFrame(mes);
        rf.setLocationRelativeTo(sf);
        rf.setVisible(true);
    }

    @Override
    public void sendingbegin(String addr) 
    {
        String mes = celTemp.getText() + "; " + kelTemp.getText() + "; " + farTemp.getText() + "F";
        sendMail.setEnabled(false);
        sf.setLocationRelativeTo(sf);
        sf.setVisible(true);
        send.sending(this, mes, addr);
    }
}
