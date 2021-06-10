/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.Board;

/**
 *
 * @author pc
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author AYMEN
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.state.state;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 1000;
    private final int B_HEIGHT = 1000;
    private final int DOT_SIZE = 100;
    private final int ALL_DOTS = 100;
    private final int RAND_POS = 9;
    private final int DELAY = 1000;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
    private final int ox[] =new int [7];
    private final int oy[] =new int [7];
    

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    private Image wall;

    public Board() {
        
        initBoard();
    }
    
    private void initBoard() {
      
    
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("head.png");
        head = iih.getImage();
        ImageIcon iiw = new ImageIcon("wall.png");
        wall = iiw.getImage();
    }

    private void initGame() {

        dots = 3;
        oy[0]=250;
        oy[1]=250;
        oy[2]=250;
        oy[3]=650;
        oy[4]=750;
        oy[5]=850;
        oy[6]=850;
        ox[0]=250;
        ox[1]=350;
        ox[2]=450;
        ox[3]=650;
        ox[4]=650;
        ox[5]=150;
        ox[6]=250;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 100;
            y[z] = 50;
        }
        
        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }
            for (int k = 0; k < 7; k++) {
                
                g.drawImage(wall, ox[k], oy[k], this);
                
            }
            

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }

    private void gameOver(Graphics g) {
        Lookup.getInstance().getService(state.class).go_looser();
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            locateApple();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
        
        for (int l = 0; l < 7; l++) {

            if ( (ox[l] == x[0]) && (oy[l] == y[0])) {
                inGame = false;
            }
        }
        

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = (50+(r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = (50+(r * DOT_SIZE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }
    public void update_up(){
        System.err.println("i am going up fdghgwhgwdhttdwh");
       upDirection = true;
                rightDirection = false;
                leftDirection = false;
    }
     public void update_down(){System.err.println("i am going down d<qgsdfjsrteqzEDF");
      downDirection = true;
                rightDirection = false;
                leftDirection = false;}
      public void update_left(){System.err.println("i am going left QFDHGKGJERQZ");
         leftDirection = true;
                upDirection = false;
                downDirection = false;}
       public void update_right(){System.err.println("i am going right EFRDFHJKJRFE");
           rightDirection = true;
                upDirection = false;
                downDirection = false;}

    }

