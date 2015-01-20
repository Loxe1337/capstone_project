/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Player {
    public static int PlayerPos_x, PlayerPos_y;
    static int rst_nr = 1;
    
    public static void MovePlayer(int direction, boolean reset) {  //Methode, um Spieler zu bewegen bzw. auf den Eingang zu setzen
        if(reset) {
            PlayerPos_x = Configuration.entrance_x[Configuration.entrance_nr-rst_nr];
            PlayerPos_y = Configuration.entrance_y[Configuration.entrance_nr-rst_nr];
            if(rst_nr>=Configuration.entrance_nr) {
                rst_nr =1;
            } else {
                rst_nr +=1;
            }
        } else {
            switch(direction) {
                case 0:
                    break;
                case 1:
                    if(PlayerPos_x>1) {
                        PlayerPos_x-=1;
                    }
                    break;
                case 2:
                    if(PlayerPos_y>1) {
                        PlayerPos_y-=1;
                    }
                    break;
                case 3:
                    if(PlayerPos_x<(Configuration.width-1)) {
                        PlayerPos_x+=1;
                    }
                    break;
                case 4:
                    if(PlayerPos_y<(Configuration.height-1)) {
                        PlayerPos_y+=1;
                    }
                    break;
            }
        }
    }
}
