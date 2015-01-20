/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

import com.googlecode.lanterna.input.Key;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Input {
    public static void Analyse() throws InterruptedException {
        // Eingabe lesen
        Key key = Main.terminal.readInput();
        //Auf Eingabe reagieren:
        if(Main.terminal.readInput()!=null) {
            System.out.print("Success");
            switch(key.getKind()) {
                case Escape:
                    /*Show Menu here*/;
                    Draw.Static();
                    break;
                case NormalKey:
                    if(key.getCharacter()=='s') {
                        /*save level here*/;
                    }
                    Draw.Static();
                    break;
                case ArrowLeft:
                    Player.MovePlayer(1, false);
                    break;
                case ArrowUp:
                    Player.MovePlayer(2, false);
                    break;
                case ArrowRight:
                    Player.MovePlayer(3, false);
                    break;
                case ArrowDown:
                    Player.MovePlayer(4, false);
                    break;
            }
        }
    }
}