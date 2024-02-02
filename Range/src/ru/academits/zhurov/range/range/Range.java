package ru.academits.zhurov.range.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double length() {
        return this.to - this.getFrom();
    }

    public boolean isInside(double value) {
        return this.from <= value && this.to >= value;
    }
}
