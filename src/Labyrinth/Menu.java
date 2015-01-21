/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Menu {
    public static boolean MenuOpen=false;
    
    public static void show() throws InterruptedException, IOException {
        while(MenuOpen){
            String save = "2. Save game", help = "1. Legend", title="*Game paused*";
            String load = "3. Load game", resume = "4. Resume";
            String select = "Please choose an option by pressing the number.";
            Main.terminal.clearScreen();
            Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
            Main.terminal.moveCursor(3, 2);
            for(int i=0; i<title.length(); i++) {
                Main.terminal.putCharacter(title.charAt(i));
            }
            Main.terminal.moveCursor(1, 5);
            for(int i=0; i<help.length(); i++) {
                Main.terminal.putCharacter(help.charAt(i));
            }
            Main.terminal.moveCursor(1, 6);
            for(int i=0; i<save.length(); i++) {
                Main.terminal.putCharacter(save.charAt(i));
            }
            Main.terminal.moveCursor(1, 7);
            for(int i=0; i<load.length(); i++) {
                Main.terminal.putCharacter(load.charAt(i));
            }
            Main.terminal.moveCursor(1, 8);
            for(int i=0; i<resume.length(); i++) {
                Main.terminal.putCharacter(resume.charAt(i));
            }
            Main.terminal.moveCursor(1, 10);
            for(int i=0; i<select.length(); i++) {
                Main.terminal.putCharacter(select.charAt(i));
            }
            Key key = Main.terminal.readInput();
            while(key == null) {
                Thread.sleep(5);
                key = Main.terminal.readInput();
            }
            switch(key.getCharacter()) {
                case '1':
                    String wall = "X = Wall";
                    String statEnemy = "\u2620 = non-moving Enemy";
                    String dynEnemy = "\u2623 = moving Enemy";
                    String tries = "\u2665 = Represents the tries left";
                    String keys = "\u26BF = Key";
                    String player = "\u265C = Player";
                    String entrance = "\u26CC = Entrance";
                    String exit = "\u2691 = Exit";
                    Main.terminal.clearScreen();
                    Main.terminal.moveCursor(1, 2);
                    for(int i=0; i<wall.length(); i++) {
                        Main.terminal.putCharacter(wall.charAt(i));
                    }
                    Main.terminal.moveCursor(1, 3);
                    Main.terminal.applyForegroundColor(Terminal.Color.RED);
                    for(int i=0; i<statEnemy.length(); i++) {
                        Main.terminal.putCharacter(statEnemy.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    Main.terminal.moveCursor(1, 4);
                    Main.terminal.applyForegroundColor(Terminal.Color.RED);
                    for(int i=0; i<dynEnemy.length(); i++) {
                        Main.terminal.putCharacter(dynEnemy.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    Main.terminal.moveCursor(1, 5);
                    Main.terminal.applyForegroundColor(Terminal.Color.YELLOW);
                    for(int i=0; i<keys.length(); i++) {
                        Main.terminal.putCharacter(keys.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    Main.terminal.moveCursor(1, 6);
                    Main.terminal.applyForegroundColor(Terminal.Color.WHITE);
                    for(int i=0; i<entrance.length(); i++) {
                        Main.terminal.putCharacter(entrance.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    Main.terminal.moveCursor(1, 7);
                    Main.terminal.applyForegroundColor(Terminal.Color.GREEN);
                    for(int i=0; i<exit.length(); i++) {
                        Main.terminal.putCharacter(exit.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    Main.terminal.moveCursor(1, 8);
                    Main.terminal.applyForegroundColor(Terminal.Color.BLUE);
                    for(int i=0; i<player.length(); i++) {
                        Main.terminal.putCharacter(player.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    Main.terminal.moveCursor(1, 9);
                    Main.terminal.applyForegroundColor(Terminal.Color.RED);
                    for(int i=0; i<tries.length(); i++) {
                        Main.terminal.putCharacter(tries.charAt(i));
                        Main.terminal.applyForegroundColor(Terminal.Color.DEFAULT);
                    }
                    

                    String anykey = "Press a button to get back to main menu.";
                    Main.terminal.moveCursor(1, 12);
                    for(int i=0; i<anykey.length(); i++) {
                        Main.terminal.putCharacter(anykey.charAt(i));
                    }

                    Key key_ = Main.terminal.readInput();
                    while(key_ == null) {
                        Thread.sleep(5);
                        key_ = Main.terminal.readInput();
                    }
                    break;
                case '2':
                    Game.save();
                    break;
                case '3':
                    //load game here;
                    break;
                case '4':
                    MenuOpen = false;
                    break;
            }
        }
    }
}
