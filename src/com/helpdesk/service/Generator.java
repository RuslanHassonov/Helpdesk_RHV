package com.helpdesk.service;

import java.util.Random;

public class Generator {
    public static int createRandomCustomerId() {
        return getRandomNumberInRange(1, 5000);
    }

    public static int createRandomEmployeeId() {
        return getRandomNumberInRange(6000, 9999);
    }

    public static String createRandomEmployeeRole(){
        RoleEnum role = getRandomEmployeeRole();

        switch (role){
            case MANAGER:
                return "MNG";
            case DISPATCHER:
                return "DSP";
            case TECHNICIAN:
                return "TCH";
            default:
                return "EMPL";
        }
    }

    private static RoleEnum getRandomEmployeeRole() {
        RoleEnum[] role =  RoleEnum.values();
        Random random = new Random();

        return role[random.nextInt(role.length)];
    }

    private static int getRandomNumberInRange(int min, int max){
        Random random = new Random();
        if (min == 0 && max == 0){
            return random.nextInt();
        } else {
            return random.nextInt((max - min) + 1) + min;
        }
    }
}
