package com.example.listview.util;


public class ValueFormatter extends com.github.mikephil.charting.formatter.ValueFormatter {
    @Override
    public String getFormattedValue(float value) {
        return (int)value + " từ";
    }
}
