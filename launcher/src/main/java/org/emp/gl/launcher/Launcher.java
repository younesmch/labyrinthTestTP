/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.launcher;

import org.emp.gl.Board.Board;
import org.emp.gl.core.lookup.Lookup;

import org.emp.gl.gui.config_gui;






import org.emp.gl.state.context;
import org.emp.gl.state.state;


import java.awt.EventQueue;
import javax.swing.JFrame;
import org.emp.gl.Board.guiLitner;
import org.emp.gl.observer.publisher;
/**
 *
 * @author billal
 */
public class Launcher extends JFrame{
      static {
        // initialisation du Lookup 
       // Lookup.getInstance().register(MessagingService.class, new MessagingServiceImpl() ); 
         Lookup.getInstance().register(publisher.class, new publisher()); 
         Lookup.getInstance().register(state.class, new context()); 
          Lookup.getInstance().register(Board.class, new Board());
    }

    public Launcher() {
        
        initUI();
    }
    
    private void initUI() {
      
        
        add(Lookup.getInstance().getService(Board.class));
               
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     //   Board affich_gui = new Board();
      EventQueue.invokeLater(() -> {
            JFrame ex = new Launcher();
            ex.setVisible(true);
        });
           config_gui config_gui = new config_gui();
        guiLitner mysender=new guiLitner( Lookup.getInstance().getService(publisher.class), Lookup.getInstance().getService(Board.class));
     
        /* Create and display the form */
    
        
    }

}
