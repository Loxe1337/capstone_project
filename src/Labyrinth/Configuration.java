/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Configuration {
    public static int width, height;
    public static int[][] field;                //zweidimensionales Array, welches die Eigenschaften des Spielfeldes beinhaltet
    public static int[] entrance_x, entrance_y, exit_x, exit_y;
    public static int entrance_nr = 0, exit_nr = 0;
    
    public static void setProps(String file) throws IOException {          //Methode, um Eigenschaften des Labyrinths festzulegen
        Properties properties = new Properties();
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));        //Datei in gepufferten Stream einlesen
        if(stream != null) {                                                //Validierung, dass Datei eingelesen wurde
            properties.load(stream);                                        //Properties aus Stream "abfangen"
        } else {
            throw new FileNotFoundException("Property file "+file+" not found!");
        }
        stream.close();
        
        //Werte setzen & Spielfeld initialisieren:
        width = Integer.parseInt(properties.getProperty("Width"));
        height = Integer.parseInt(properties.getProperty("Height"));
        field = new int[width][height];
        for(int i=0; i<width; i++) {
            for(int n=0; n<height; n++) {
                String value = properties.getProperty(Integer.toString(i) + "," + Integer.toString(n));
                if(value != null) {
                    if (value.equals("1")) {
                        entrance_nr += 1;
                    } else if(value.equals("2")) {
                        exit_nr += 1;
                    } else if(value.equals("4")) {
                        Elements.Enemy_Nr += 1;
                    } else {
                        field[i][n] = Integer.parseInt(value);
                    }
                } else if(value == null){
                    field[i][n] = 6;
                }
            }
        }
        //Position der Eingänge bestimmen:
        entrance_x = new int[entrance_nr];
        entrance_y = new int[entrance_nr];
        int x=0;
        while(x<entrance_nr){
            for(int i=0; i<width; i++) {
                for(int n=0; n<height; n++) {
                    String key = Integer.toString(i) + "," + Integer.toString(n);
                    if(properties.getProperty(key) != null) {
                        if(properties.getProperty(key).equals("1")) {
                            entrance_x[x] = i;
                            entrance_y[x] = n;
                            x+=1;
                        }
                    }
                }
            }
        }
        
        //Position der Ausgänge bestimmen:
        exit_x = new int[exit_nr];
        exit_y = new int[exit_nr];
        x=0;
        while(x<exit_nr) {
            for(int i=0; i<width; i++) {
                for(int n=0; n<height; n++) {
                    String key = Integer.toString(i) + "," + Integer.toString(n);
                    if(properties.getProperty(key) != null) {
                        if (properties.getProperty(key).equals("2")) {
                            exit_x[x] = i;
                            exit_y[x] = n;
                            x+=1;
                        }
                    }
                }
            }
        }
        
        //Initiale Position der Dynamischen Hindernisse bestimmen:
        Elements.EnemyFirstPos_x = new int[Elements.Enemy_Nr];
        Elements.EnemyFirstPos_y = new int[Elements.Enemy_Nr];
        x=0;
        while(x<Elements.Enemy_Nr) {
            for(int i=0; i<width; i++) {
                for(int n=0; n<height; n++) {
                    String key = Integer.toString(i) + "," + Integer.toString(n);
                    if(properties.getProperty(key) != null) {
                        if (properties.getProperty(key).equals("4")) {
                            Elements.EnemyFirstPos_x[x] = i;
                            Elements.EnemyFirstPos_y[x] = n;
                            x+=1;
                        }
                    }
                }
            }
        }
    }
}


