package com.clark.basemodel;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //自动装箱
        Integer total = 99;

        //自定拆箱
        int totalprim = total;
        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.DATE, endDate.get(Calendar.DATE) + 1);
        System.out.println("endDate :"+ endDate.get(Calendar.YEAR) + endDate.get(Calendar.MONTH)+endDate.get(Calendar.DAY_OF_MONTH));

    }
}