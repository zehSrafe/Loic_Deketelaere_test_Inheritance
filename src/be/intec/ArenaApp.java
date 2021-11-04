package be.intec;

import java.util.Random;

public class ArenaApp {
    public static void main(String[] args) {
        int round = 1;
        int random = (Math.random() <= 0.5) ? 1 : 2;

        Bear bear = new Bear(50, 5);
        Witch witch = new Witch(30, 100);

        while (witch.getHitPoints() > 0 && bear.getHitPoints() > 0){
            System.out.println("Round " + round + "!");
            if (random == 1){
                bear.takeDamage(witch.fireballAttack());
                if (bear.getHitPoints() <= 0){
                    break;
                } else {
                    witch.takeDamage(bear.bearClawAttack());
                }
            } else {
                witch.takeDamage(bear.bearClawAttack());
                if (witch.getHitPoints() <= 0){
                    break;
                } else {
                    bear.takeDamage(witch.fireballAttack());
                }
            }
            bear.restoreRp(5);
            witch.restoreMp(4);
            System.out.println(bear.toString());
            System.out.println(witch.toString());
            round ++;
            random = (Math.random() <= 0.5) ? 1 : 2;
        }

        System.out.println("Winner winner chicken diner!");
        if (witch.getHitPoints() > bear.getHitPoints()){
            System.out.println(witch.toString());
        } else {
            System.out.println(bear.toString());
        }
    }
}
