/*
 * Chernov Dmitriy
 * 271 group
 */

package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class About extends JFrame 
{
    private JLabel author = new JLabel();
    private JLabel app = new JLabel();
    private JButton ok = new JButton("Return");
    
    private void returnToConv(MouseEvent evt) 
    {
        this.setVisible(false);
    }
    
    private void init() 
    {
        this.setResizable(false);
        
        app.setText("Конвертер температур");
        author.setText("Автор: Чернов Дмитрий");
        
        ok.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                 returnToConv(evt);
            }
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(app).addComponent(author).addComponent(ok, GroupLayout.Alignment.CENTER));
        layout.setHorizontalGroup(hGroup);
        
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(app));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(author));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(ok));
        layout.setVerticalGroup(vGroup);
        
        this.pack();
    }
    
    public About() 
    {
        super("About");
        init();
    }
}

