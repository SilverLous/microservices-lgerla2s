package com.services.dice.dice;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class diceService {
    public int[] diceList(String diceString){
        int throwAmount = 0;
        int throwValue = 0;
        throwAmount = Integer.parseInt(diceString.substring(0,diceString.indexOf("d")));
        throwValue = Integer.parseInt(diceString.substring(diceString.indexOf("d")+1));

        int[] ergebnisListe = new int[throwAmount];
        for (int i = 0;i<throwAmount;i++){
            ergebnisListe[i] = new Random().nextInt(throwValue)+1;
        }

//        ergebnisListe[0] = 1;
        return ergebnisListe;
    }
}
