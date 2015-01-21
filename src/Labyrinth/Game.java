/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author _Lennart_
 */
public class Game {
    public static void save() throws FileNotFoundException, IOException {
        File del = new File("save.xml");
        del.delete();
        Properties props = new Properties();
        props.setProperty("PlayerPos_x", Integer.toString(Player.PlayerPos_x));
        props.setProperty("PlayerPos_y", Integer.toString(Player.PlayerPos_y));
        props.setProperty("Tries", Integer.toString(Player.tries));
        if(Player.key_found) {
            props.setProperty("KeyFound", "1");
        } else {
            props.setProperty("KeyFound", "0");
        }
        for(int i=0; i<Elements.Enemy_Nr; i++) {
            props.setProperty("EnemyPos_x_"+i, Integer.toString(Elements.DynEnemyPos_x[i]));
            props.setProperty("EnemyPos_y_"+i, Integer.toString(Elements.DynEnemyPos_y[i]));
        }
        File f = new File("save.xml");
        if(f != null) {                                                //Validierung, dass Datei eingelesen wurde
            OutputStream out = new FileOutputStream(f);
            props.storeToXML(out, null);
            String success = "Game saved!";
            Main.terminal.moveCursor(1, 15);
            for(int i=0; i<success.length(); i++) {
                Main.terminal.putCharacter(success.charAt(i));
            }
        } else {
            throw new FileNotFoundException("Game couldn't be saved!");
        }
    }
    
    public static void load() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream("save.xml"));        //Datei in gepufferten Stream einlesen
        if(stream != null) {                                                //Validierung, dass Datei eingelesen wurde
            properties.loadFromXML(stream);                                        //Properties aus Stream "abfangen"
        } else {
            throw new FileNotFoundException("Saved game not found!");
        }
        stream.close();
    }
}
