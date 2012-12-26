/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SendFrame extends JFrame 
{
    private JLabel wait = new JLabel();
    
    private void init() 
    {
        
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        wait.setText("Sending in process...");
        
        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(wait, GroupLayout.Alignment.CENTER));
        layout.setHorizontalGroup(hGroup);
        
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(wait, GroupLayout.Alignment.CENTER));
        layout.setVerticalGroup(vGroup);
        
        this.pack();
    }
    
    public SendFrame()
    {
        super("Sending");
        init();
    }
}