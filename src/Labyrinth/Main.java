/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package Labyrinth;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.*;
import java.nio.charset.Charset;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Main {
    public static Terminal terminal = TerminalFacade.createSwingTerminal();
    public static boolean run = true;
    public static boolean won = false;
    
    public static void main(String args[]) throws InterruptedException {
        try {
            Configuration.setProps("level.properties");
        }
        catch (IOException e) {
            System.err.println("Property-File not found!");
        }
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        Player.MovePlayer(0, true);
        Elements.MoveDynEnemy(true);
        while(run) {
            Draw.Static();
            Draw.Dyn();
            Elements.MoveDynEnemy(false);
            Input.Analyse();
            for(int i=0; i<Configuration.exit_nr; i++) {
                if(Player.key_found && Configuration.exit_x[i] == Player.PlayerPos_x && Configuration.exit_y[i] == Player.PlayerPos_y) {
                    Main.run = false;
                    won = true;
                }
            }
        }
        terminal.exitPrivateMode();
        if(won) {
            System.out.print("Congrats! You've won the game!");
        }
    }
}