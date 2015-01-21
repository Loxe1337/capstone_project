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
    public static int lives=3;
    public static boolean key_found = false;
    public static int rst_nr = 1;
    
    public static void MovePlayer(int direction, boolean reset) {  //Methode, um Spieler zu bewegen bzw. auf den Eingang zu setzen
        if(reset) {
            //Spieler nach jedem Reset auf anderen Eingang setzen:
            PlayerPos_x = Configuration.entrance_x[Configuration.entrance_nr-rst_nr];
            PlayerPos_y = Configuration.entrance_y[Configuration.entrance_nr-rst_nr];
            if(rst_nr>=Configuration.entrance_nr) {
                rst_nr =1;
            } else {
                rst_nr +=1;
            }
        } else {
            boolean step; //Step-Variable, um bei Ausgang keine 2 Schritte zu machen.
            
            //Bewegung ausführen:
            switch(direction) {
                case 0:
                    break;
                case 1:
                    step=false;
                    if(PlayerPos_x>1) {
                        if(Configuration.field[PlayerPos_x-1][PlayerPos_y]==6) {
                            PlayerPos_x-=1;
                            step=true;
                        } else if(Configuration.field[PlayerPos_x-1][PlayerPos_y]==3) {
                            lives-=1;
                        } else if(Configuration.field[PlayerPos_x-1][PlayerPos_y]==5) {
                            key_found = true;
                            PlayerPos_x-=1;
                        }
                        for(int i=0; i<Elements.Enemy_Nr; i++) {
                            if((PlayerPos_x-1)==Elements.DynEnemyPos_x[i] && PlayerPos_y==Elements.DynEnemyPos_y[i]) {
                                lives-=1;
                            }
                        }
                    }
                    for(int i=0; i<Configuration.exit_nr; i++) {
                        if(Configuration.exit_y[i]==PlayerPos_y && PlayerPos_x>0 && !step) {
                            PlayerPos_x-=1;
                        }
                    }
                    break;
                case 2:
                    step=false;
                    if(PlayerPos_y>1) {
                        if(Configuration.field[PlayerPos_x][PlayerPos_y-1]==6) {
                            PlayerPos_y-=1;
                            step=true;
                        } else if(Configuration.field[PlayerPos_x][PlayerPos_y-1]==3) {
                            lives-=1;
                        } else if(Configuration.field[PlayerPos_x][PlayerPos_y-1]==5) {
                            key_found = true;
                            PlayerPos_y-=1;
                        }
                        for(int i=0; i<Elements.Enemy_Nr; i++) {
                            if(PlayerPos_x==Elements.DynEnemyPos_x[i] && (PlayerPos_y-1)==Elements.DynEnemyPos_y[i]) {
                                lives-=1;
                            }
                        }
                    }
                    for(int i=0; i<Configuration.exit_nr; i++) {
                        if(Configuration.exit_x[i]==PlayerPos_x && PlayerPos_y>0 && !step) {
                            PlayerPos_y-=1;
                        }
                    }
                    break;
                case 3:
                    step=false;
                    if(PlayerPos_x<(Configuration.width-1)) {
                        if(Configuration.field[PlayerPos_x+1][PlayerPos_y]==6) {
                            PlayerPos_x+=1;
                            step=true;
                        } else if(Configuration.field[PlayerPos_x+1][PlayerPos_y]==3) {
                            lives-=1;
                        } else if(Configuration.field[PlayerPos_x+1][PlayerPos_y]==5) {
                            key_found = true;
                            PlayerPos_x+=1;
                        }
                        for(int i=0; i<Elements.Enemy_Nr; i++) {
                            if((PlayerPos_x+1)==Elements.DynEnemyPos_x[i] && PlayerPos_y==Elements.DynEnemyPos_y[i]) {
                                lives-=1;
                            }
                        }
                    }
                    for(int i=0; i<Configuration.exit_nr; i++) {
                        if(Configuration.exit_y[i]==PlayerPos_y && PlayerPos_x<Configuration.width && !step) {
                            PlayerPos_x+=1;
                        }
                    }
                    break;
                case 4:
                    step=false;
                    if(PlayerPos_y<(Configuration.height-1)) {
                        if(Configuration.field[PlayerPos_x][PlayerPos_y+1]==6) {
                            PlayerPos_y+=1;
                            step=true;
                        } else if(Configuration.field[PlayerPos_x][PlayerPos_y+1]==3) {
                            lives-=1;
                        } else if(Configuration.field[PlayerPos_x][PlayerPos_y+1]==5) {
                            key_found = true;
                            PlayerPos_y+=1;
                        }
                        for(int i=0; i<Elements.Enemy_Nr; i++) {
                            if(PlayerPos_x==Elements.DynEnemyPos_x[i] && (PlayerPos_y+1)==Elements.DynEnemyPos_y[i]) {
                                lives-=1;
                            }
                        }
                    }
                    for(int i=0; i<Configuration.exit_nr; i++) {
                        if(Configuration.exit_x[i]==PlayerPos_x && PlayerPos_y<Configuration.height && !step) {
                            PlayerPos_y+=1;
                        }
                    }
                    break;
            }
        }
    }
}
