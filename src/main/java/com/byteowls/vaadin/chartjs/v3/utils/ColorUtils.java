package com.byteowls.vaadin.chartjs.v3.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ColorUtils {

    public static long randomColorFactor() {
        return Math.round(Math.random() * 255);
    }

    public static String randomColor(double alphaFactor) {
        return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + "," + alphaFactor + ")";
    }

    public static String toRgb(int[] rgb) {
        if (rgb != null && rgb.length == 3) {
            String joined = Arrays.stream(rgb)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
            return "rgb(" + joined + ")";
        }
        return null;
    }

    public static String toRgba(int[] rgb, double alpha) {
        if (rgb != null && rgb.length == 3) {
            String joined = Arrays.stream(rgb)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

            if (alpha > 1) {
                alpha = 1;
            } else if (alpha < 0) {
                alpha = 0;
            }
            return "rgba(" + joined + "," +alpha+ ")";
        }
        return null;
    }

}
