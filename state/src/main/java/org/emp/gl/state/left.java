/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.state;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.observer.publisher;


/**
 *
 * @author pc
 */
public class left implements state{
     context ctx;
        publisher pub=Lookup.getInstance().getService(publisher.class);
    public left(context new_state){ctx=new_state;}
    @Override
    public void go_up() {
       
            //go to next pos
             pub.setState(1);
            ctx.setState(ctx.getupState());
        
    }

    @Override
    public void go_down() {
        
            //go to next pos
             pub.setState(2);
            ctx.setState(ctx.getdownState());
        
    }

    @Override
    public void go_left() {
        
         
        
    }

    @Override
    public void go_right() {
        System.err.println("impossible de tourner");
    }


    @Override
    public void go_looser() {
          ctx.setState(ctx.getlooserState());
    }
    
}
