/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class SetEmailFrame extends JFrame {
    private JTextField email = new JTextField();
    private JLabel label = new JLabel();
    private JButton ok = new JButton("Send!");
    private SendingListener sl;
    
    private void OkMouseClicked(MouseEvent evt) 
    {
        this.setVisible(false);
        sl.sendingbegin(email.getText());
    }
    
    private void init() 
    {
        
        this.setResizable(false);

        label.setText("Enter email address");
        
        ok.addMouseListener(new MouseAdapter() 
        {
             @Override
             public void mouseClicked(java.awt.event.MouseEvent evt) 
             {
                  OkMouseClicked(evt);
             }
         });


        GroupLayout layout = new GroupLayout(getContentPane());    

        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
            addComponent(label, GroupLayout.Alignment.CENTER).
            addComponent(email, GroupLayout.Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE).
            addComponent(ok, GroupLayout.Alignment.CENTER));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                    addComponent(label));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                    addComponent(email));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                    addComponent(ok));
        layout.setVerticalGroup(vGroup);

        this.pack();
    }
    
    public SetEmailFrame(SendingListener dl) 
    {
        super("Set email");
        this.sl = dl;
        init();
    }
}

