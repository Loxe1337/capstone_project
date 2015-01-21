/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;

import java.util.Random;

/**
 *
 * @author _Lennart_Rehkaemper_
 */
public class Elements {
    public static int[] EnemyFirstPos_x, EnemyFirstPos_y;
    public static int[] DynEnemyPos_x, DynEnemyPos_y;
    public static int Enemy_Nr=0;
    
    public static void MoveDynEnemy(boolean reset) {
        if(reset) {
            DynEnemyPos_x = new int[Enemy_Nr];
            DynEnemyPos_y = new int[Enemy_Nr];
            for(int i=0; i<Enemy_Nr; i++) {
                DynEnemyPos_x[i] = EnemyFirstPos_x[i];
                DynEnemyPos_y[i] = EnemyFirstPos_y[i];
            }
        }
        //Zufällige Bewegungsrichtung wählen und Bewegung ausführen:
        for(int i=0; i<Enemy_Nr; i++) {
            Random random = new Random();
            int x = random.nextInt(4);
            switch(x) {
                case 1:
                    if(DynEnemyPos_x[i]>1) {
                        if(Configuration.field[DynEnemyPos_x[i]-1][DynEnemyPos_y[i]]==6) {
                            DynEnemyPos_x[i]-=1;
                        }
                    }
                    break;
                case 2:
                    if(DynEnemyPos_y[i]>1) {
                        if(Configuration.field[DynEnemyPos_x[i]][DynEnemyPos_y[i]-1]==6) {
                            DynEnemyPos_y[i]-=1;
                        }
                    }
                    break;
                case 3:
                    if(DynEnemyPos_x[i]<(Configuration.width-1)) {
                        if(Configuration.field[DynEnemyPos_x[i]+1][DynEnemyPos_y[i]]==6) {
                            DynEnemyPos_x[i]+=1;
                        }
                    }
                    break;
                case 4:
                    if(DynEnemyPos_y[i]<(Configuration.height-1)) {
                        if(Configuration.field[DynEnemyPos_x[i]][DynEnemyPos_y[i]+1]==6) {
                            DynEnemyPos_y[i]+=1;
                        }
                    }
                    break;
            }
        }
    }
}