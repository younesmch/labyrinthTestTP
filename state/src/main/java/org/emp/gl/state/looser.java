/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.state;

/**
 *
 * @author pc
 */
public class looser implements state{
       context ctx;
    public looser(context new_state){ctx=new_state;}
    @Override
    public void go_up() {
        System.err.println("you are looser can't do anything");    }

    @Override
    public void go_down() {
System.err.println("you are looser can't do anything");      }

    @Override
    public void go_left() {
System.err.println("you are looser can't do anything");      }

    @Override
    public void go_right() {
System.err.println("you are looser can't do anything");      }


    @Override
    public void go_looser() {
System.err.println("you are looser can't do anything");      }
    
}
