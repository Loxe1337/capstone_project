/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

import com.googlecode.lanterna.terminal.Terminal;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Draw {
    public static char[][] screenArray = new char[Configuration.width][Configuration.height];
    
    public static void Static() {        //statische Elemente zeichnen
        Main.terminal.clearScreen();
        for(int i=0; i<Configuration.height; i++) {
            for(int n=0; n<Configuration.width; n++) {
                Main.terminal.moveCursor(i, n+1);
                switch(Configuration.field[i][n]) {
                    case 0:
                        Main.terminal.applyForegroundColor(Terminal.Color.WHITE);
                        Main.terminal.putCharacter('\u2612');
                        break;
                    case 1:
                        Main.terminal.applyForegroundColor(Terminal.Color.WHITE);
                        Main.terminal.putCharacter('\u26CC');
                        break;
                    case 2:
                        Main.terminal.applyForegroundColor(Terminal.Color.GREEN);
                        Main.terminal.putCharacter('\u2691');
                        break;
                    case 3:
                        Main.terminal.applyForegroundColor(Terminal.Color.RED);
                        Main.terminal.putCharacter('\u2620');
                        break;
                    case 5:
                        if(!Player.key_found) {
                            Main.terminal.applyForegroundColor(Terminal.Color.YELLOW);
                            Main.terminal.putCharacter('\u26BF');
                        }
                        break;
                    case 6:
                        Main.terminal.putCharacter(' ');
                        break;
                }
            }
        }
    }
    
    public static void Dyn() {
        //Draw statistics:
        for(int i=0; i<Player.tries; i++) {
            Main.terminal.moveCursor(i, 0);
            Main.terminal.applyForegroundColor(Terminal.Color.RED);
            Main.terminal.putCharacter('\u2665');
        }
        if(Player.key_found) {
            String key = "Key has been found!";
        }
        //Draw dynamic Enemies:
        for(int i=0; i<Elements.Enemy_Nr; i++){
            Main.terminal.moveCursor(Elements.DynEnemyPos_x[i], Elements.DynEnemyPos_y[i]+1);
            Main.terminal.applyForegroundColor(Terminal.Color.RED);
            Main.terminal.putCharacter('\u2623');
        }
        //Draw Player:
        Main.terminal.moveCursor(Player.PlayerPos_x,Player.PlayerPos_y+1);
        Main.terminal.applyForegroundColor(Terminal.Color.BLUE);
        Main.terminal.putCharacter('\u265C');
    }
}
