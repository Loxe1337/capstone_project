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
    
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Geben Sie den Namen der properties-Datei an:");
        String s = ((new java.util.Scanner(System.in)).next())+".properties";
        try {
            Configuration.setProps(s);
        }
        catch (IOException e) {
            System.err.println("Property-File not found!");
        }
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        Player.MovePlayer(0, true);
        while(run) {
            Draw.Static();
            Draw.Dyn();
            Input.Analyse();
        }
        Thread.sleep(10000);
        System.out.println(Player.PlayerPos_x+","+Player.PlayerPos_y);
        terminal.exitPrivateMode();
    }
}