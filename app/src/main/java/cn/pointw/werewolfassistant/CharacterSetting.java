package cn.pointw.werewolfassistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by outen on 16/7/21.
 */
public class CharacterSetting implements Serializable {
    CharacterSetting(){
        this.godCharacter = new ArrayList<>();
    }
//    private boolean haveHunter = true;
//    private boolean haveSeer = true;
//    private boolean haveWitch = false;
//    private boolean haveIdiot = false;
    private int playerNumber;
    private int civilianNumber;
    private int werewolfNumber;
    private List<Globals.God> godCharacter;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getCivilianNumber() {
        return civilianNumber;
    }

    public void setCivilianNumber(int civilianNumber) {
        this.civilianNumber = civilianNumber;
    }

    public int getWerewolfNumber() {
        return werewolfNumber;
    }

    public void setWerewolfNumber(int werewolfNumber) {
        this.werewolfNumber = werewolfNumber;
    }

    public List<Globals.God> getGodCharacter() {
        return godCharacter;
    }

    public void setGodCharacter(List<Globals.God> godCharacter) {
        this.godCharacter = godCharacter;
    }

    public void addGod(Globals.God god){
        for (Globals.God g : godCharacter){
            if (g == god) return;
        }
        godCharacter.add(god);
    }

    public void addGod(Globals.God god, boolean b){
        if (b) {
            addGod(god);
        }
    }

    public int getGodNumber(){
        return godCharacter.size();
    }

    //    public boolean isHaveHunter() {
//        return haveHunter;
//    }
//
//    public void setHaveHunter(boolean haveHunter) {
//        this.haveHunter = haveHunter;
//    }
//
//    public boolean isHaveSeer() {
//        return haveSeer;
//    }
//
//    public void setHaveSeer(boolean haveSeer) {
//        this.haveSeer = haveSeer;
//    }
//
//    public boolean isHaveWitch() {
//        return haveWitch;
//    }
//
//    public void setHaveWitch(boolean haveWitch) {
//        this.haveWitch = haveWitch;
//    }
//
//    public boolean isHaveIdiot() {
//        return haveIdiot;
//    }
//
//    public void setHaveIdiot(boolean haveIdiot) {
//        this.haveIdiot = haveIdiot;
//    }
//
//    public int getPlayerNumber() {
//        return playerNumber;
//    }
//
//    public void setPlayerNumber(int playerNumber) {
//        this.playerNumber = playerNumber;
//    }
//
//    public int getCivilianNumber() {
//        return civilianNumber;
//    }
//
//    public void setCivilianNumber(int civilianNumber) {
//        this.civilianNumber = civilianNumber;
//    }
//
//    public int getWerewolfNumber() {
//        return werewolfNumber;
//    }
//
//    public void setWerewolfNumber(int werewolfNumber) {
//        this.werewolfNumber = werewolfNumber;
//    }
//
//    public int getGodNumber(){
//        int n = 0;
//        if (haveHunter) n++;
//        if (haveSeer) n++;
//        if (haveWitch) n++;
//        if (haveIdiot) n++;
//        return n;
//    }
}

