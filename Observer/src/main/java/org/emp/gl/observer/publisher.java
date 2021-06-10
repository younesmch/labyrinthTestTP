/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.observer;

import java.util.LinkedList;
import java.util.List;
import org.emp.gl.observer.observer;

/**
 *
 * @author pc
 */
public class publisher {
    int state;
     List<observer> listeners = new LinkedList<>();
    public int getStaete()
    {
        return this.state;
    }
    public void setState(int newState){
    this.state=newState;
    notifyAllObserver();}

    private void notifyAllObserver() {
     for(observer e : listeners)
      e.update();
       // System.err.println("nombre of observer 1 1 ");
       
    }
    public void subscribe(observer newObserver){
        this.listeners.add(newObserver);
    }
    public void unsubscribe(observer newObserver){
        this.listeners.remove(newObserver);
    }
   
    
    
}
