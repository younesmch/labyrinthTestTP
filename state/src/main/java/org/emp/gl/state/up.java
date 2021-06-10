/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.state;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.observer.publisher;

import org.emp.gl.state.state;
/**
 *
 * @author pc
 */
public class up implements state{
    context ctx;
    //publisher pub=Lookup.getInstance().getService(publisher.class);
    public up(context new_state){ctx=new_state;}
    @Override
    public void go_up() {

       
       
    }

    @Override
    public void go_down() {
          System.err.println("impossible de tourner");
       
    }

    @Override
    public void go_left() {
        
            //go to next pos
             Lookup.getInstance().getService(publisher.class).setState(3);
            ctx.setState(ctx.getleftState());
        
       
    }

    @Override
    public void go_right() {
       
            //go to next pos
             Lookup.getInstance().getService(publisher.class).setState(4);
            ctx.setState(ctx.getrightState());
     
       
    }

    @Override
    public void go_looser() {
             ctx.setState(ctx.getlooserState());
    }

  
    
}
