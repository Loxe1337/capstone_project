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
public class Menu {
    public static void showMenu() {
        String help = "", title="*Game paused*";
        Main.terminal.applyForegroundColor(Terminal.Color.BLACK);
        Main.terminal.moveCursor(3, 3);
        for(int i=0; i<title.length(); i++) {
            Main.terminal.putCharacter(title.charAt(i));
        }
        
    }
}
