package com.example.lyndsea.mysolodiceroller;

public class DiceRoller {
    private int diceSides;
    private int diceAmount;

    public DiceRoller(String diceSides, String diceAmount) {
        if (diceSides.isEmpty()) {
            this.diceSides = 0;
        } else {
            this.diceSides = Integer.parseInt(diceSides);
        }
        if (diceAmount.isEmpty()) {
            this.diceAmount = 0;
        } else {
            this.diceAmount = Integer.parseInt(diceAmount);
        }

    }

    public int getDiceSides() {
        return diceSides;
    }

    public int getDiceAmount() {
        return diceAmount;
    }

    public String rollDice (boolean isOn) {
        String result = "";
        int totalRoll = 0;

        String error = errorCheck(isOn);
        if (!error.isEmpty()) {
            return error;
        }

        for ( int x = diceAmount; x > 0; x--) {
            int diceRoll = (int) (Math.random() * diceSides + 1);
            totalRoll += diceRoll;
            result += diceRoll + " ";
            if (x > 1) {
                result += "+ ";
            } else {
                result += "= " + totalRoll;
            }

        }
        if (!isOn){
            result = "" + totalRoll;
        }
            return result;
    }
    private String errorCheck(boolean isOn) {

        if (diceSides == 0) {
            return "0";
        }

        if (diceAmount > 200 && isOn){
            return "to see individual rolls please enter an amount of dice less 201";
        }

        if (diceSides > 1000000) {
            return "please enter a die with less then 1000001";
        }

        if (diceAmount < 0 || diceSides < 0) {
            return "Please enter a positive number";
        }

        return "";
    }
}
