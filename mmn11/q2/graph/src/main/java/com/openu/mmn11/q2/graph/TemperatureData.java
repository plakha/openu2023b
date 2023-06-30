package com.openu.mmn11.q2.graph;

import java.util.*;

public class TemperatureData {
    public enum Month{
        JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
        JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
        private final int month;
        private Month(int month){
            this.month = month;
        }
        public int getMonth(){
            return month;
        }
    }
    private Map<String, Map<>> temperatures = new HashMap<>();
    {
        for (int year = 2017; year <= 2022; year++) {
            temperatures.put(String.valueOf(year), new HashMap());
            for (int month = 1; month <= 12; month++) {
                Map<Month, Double> monthData = temperatures.get(String.valueOf(year));
                double avgTemperature = Math.random() * 60 - 20;//random temperature from -20 to +40
                monthData.put(Month.valueOf(String.valueOf(month)), avgTemperature);
            }
        }
    }

    public TemperatureData(){

    }

    public static class MonthData{
        private double avgTemperature;
        private final int month;

        public MonthData(int month, double avgTemperature){
            this.month = month;
            this.avgTemperature = avgTemperature;
        }

    }
}
