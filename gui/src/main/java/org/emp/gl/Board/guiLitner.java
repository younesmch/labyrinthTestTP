/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.Board;

import org.emp.gl.observer.observer;
import org.emp.gl.observer.publisher;

/**
 *
 * @author pc
 */
public class guiLitner  extends observer{
    Board gui;
     public guiLitner(publisher newPublisher,Board mygui)
    {this.publisher=newPublisher;
    this.publisher.subscribe(this);
    gui=mygui;
    
    }
      @Override
      public void update(){
          int tmp=this.publisher.getStaete();
          System.err.println("state = "+this.publisher.getStaete()); 
        if(tmp==1)
              
                  gui.update_up();
            if(tmp==2)
                  
                  gui.update_down();
             if(tmp==3)
                  gui.update_left();
            if(tmp==4)
                  gui.update_right();
                  
          }
        
    
}
