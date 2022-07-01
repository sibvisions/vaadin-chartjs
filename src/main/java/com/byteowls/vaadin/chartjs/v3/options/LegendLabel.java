package com.byteowls.vaadin.chartjs.v3.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class LegendLabel<T> extends And<Legend<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -7792493411933479339L;

    private Integer boxWidth;
    private String fontColor;
    private Font font;
    private Integer padding;
    // TODO callback generateLabels
    private Boolean usePointStyle;

    /**
     * Width of coloured box. Defaults: 40
     */
    public LegendLabel<T> boxWidth(int boxWidth) {
        this.boxWidth = boxWidth;
        return this;
    }

    /**
     *  Font color.
     */
    public LegendLabel<T> fontColor(String fontColor) {
        this.fontColor = fontColor;
        return this;
    }
    
    /**
     * Font of legend label
     */
    public Font font() {
        if (font == null)
        {
            font = new Font();
        }
        return font;
    }

    /**
     * Padding between rows of colored boxes. Default: 10
     */
    public LegendLabel<T> padding(int padding) {
        this.padding = padding;
        return this;
    }


    public LegendLabel(Legend<T> parent) {
        super(parent);
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "boxWidth", boxWidth);
        JUtils.putNotNull(map, "color", fontColor);
        JUtils.putNotNull(map, "font", font);
        JUtils.putNotNull(map, "padding", padding);
        JUtils.putNotNull(map, "usePointStyle", usePointStyle);
        return map;
    }


}
