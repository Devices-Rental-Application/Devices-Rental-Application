package com.neonadeuri.devices_rental_application;

public class User {
    private static String name="이름";
    private static String phoneNumber="01012345678";

    public static void setName(String name) {
        User.name = name;
    }

    public static void setPhoneNumber(String phoneNumber) {
        User.phoneNumber = phoneNumber;
    }

    public static String getName() {
        return name;
    }


    public static String getPhoneNumber() {
        return phoneNumber;
    }
}
