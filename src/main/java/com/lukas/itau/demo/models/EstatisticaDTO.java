package com.lukas.itau.demo.models;

public class EstatisticaDTO {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public EstatisticaDTO(long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
    
    
}







