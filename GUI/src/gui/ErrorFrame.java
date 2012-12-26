
package gui;

/*
 * Chernov Dmitriy
 * 271 group
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ErrorFrame extends JFrame
{
    private JLabel suc = new JLabel(); 
    private JButton returnBut = new JButton("Return");
    
    private void OkMouseClicked(MouseEvent evt) 
    {
        this.setVisible(false);
    }
    
    private void init(String mes) 
    {
        this.setResizable(false);
        suc.setText(mes);
        
        returnBut.addMouseListener(new MouseAdapter() 
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
            addComponent(suc, GroupLayout.Alignment.CENTER).
            addComponent(returnBut, GroupLayout.Alignment.CENTER));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                    addComponent(suc));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                    addComponent(returnBut));
        layout.setVerticalGroup(vGroup);

        this.pack();
    }
    
    public ErrorFrame(String mes) 
    {
        super("Report");
        init(mes);
    }
}
