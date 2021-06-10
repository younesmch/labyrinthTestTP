/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.state;

import org.emp.gl.core.lookup.Lookup;


/**
 *
 * @author pc
 */
public class context implements state{
    state up;
    state down;
    state left;
    state right;
    state looser;
    state state;
  
        	
    


     public context(){
          up=new up(this);
          down=new down(this);
          left=new left(this);
          right=new right(this);
           looser=new looser(this);
          state=left;
          
    }
      public void setState(state newState)
    {
        state=newState;
        System.err.println("staet changed");
    }
      public state getupState(){return up;}
    public state getdownState(){return down;}
    public state getleftState(){return left;}
    public state getrightState(){return right;}
     public state getlooserState(){return looser;}
    @Override
    public void go_up() {
        state.go_up();
    }

    @Override
    public void go_down() {
            state.go_down();
    }

    @Override
    public void go_left() {
            state.go_left();
    }

    @Override
    public void go_right() {
        state.go_right();
    }

    @Override
    public void go_looser() {
        state.go_looser();
        System.err.println("you are looser");
    }

  


}
