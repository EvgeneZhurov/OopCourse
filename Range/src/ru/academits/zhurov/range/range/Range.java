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

    public Range getIntersection(Range range) {
        if (range.from >= this.to || range.to <= this.from) {
            return null;
        }

        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getUnification(Range range) {
        if (this.from > range.to || this.to < range.from) {
            return new Range[]{this, range};
        }

        return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
    }


    // TODO разобраться с логическими условиями и дописать метода разности интервалов.
    public Range[] getDifference(Range range) {
        if (this.from >= range.from && this.to >= range.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }

        if (this.from >= range.to || this.to <= range.from) {
            return new Range[]{this};
        }

        if (this.from >= range.from && this.to <= range.to) {
            return new Range[0];
        }

        return null;
    }
}
