package com.game.handlers;

import com.game.entity.Player;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PlayerFieldsHandler {

    public static boolean isPlayerParamsNull(Player player){
        return player.getName() == null && player.getTitle() == null && player.getRace() == null &&
                player.getProfession() == null && player.getBirthday() == null && player.getBanned() == null
                && player.getExperience() == null;
    }

    public static boolean canCreate(Player player) {
        return !(player.getName() == null || player.getTitle() == null || player.getRace() == null ||
                player.getProfession() == null || player.getBirthday() == null || player.getExperience() == null);
    }

    public static boolean isCorrectPlayer(Player player) {
        return !(!checkName(player.getName()) ||
                !checkTitle(player.getTitle()) ||
                checkBirthday(player.getBirthday()) ||
                checkExp(player.getExperience()));
    }

    public static boolean checkName(String name) {
        return name.length() < 12 || !name.matches("^\\s*$");
    }

    public static boolean checkTitle(String name) {
        return name.length() < 30;
    }

    public static boolean checkBirthday(Date date) {
        if(date == null) return false;
        long birthday = date.getTime();
        long start = new GregorianCalendar(2000, Calendar.JANUARY,0).getTimeInMillis();
        long end = new GregorianCalendar(3000, Calendar.JANUARY,0).getTimeInMillis();
        return birthday < 0 || (birthday < start || birthday > end);
    }

    public static boolean checkExp(Integer exp) {
        return (exp != null) && (exp <= 0 || exp >= 10000000);
    }
}
