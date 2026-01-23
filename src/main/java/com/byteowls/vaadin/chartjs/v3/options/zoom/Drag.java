package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Drag<T> extends And<Zoom<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -6625956937344580720L;

    private boolean  enabled = true;
    private Double   threshold;
    private String   backgroundColor;
    private String   borderColor;
    private Double   borderWidth;

    public Drag(Zoom<T> parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Drag<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * threshold.
     */
    public Drag<T> threshold(double threshold) {
        this.threshold = threshold;
        return this;
    }
    
    /**
     * backgroundColor.
     */
    public Drag<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    /**
     * borderColor.
     */
    public Drag<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }
    
    /**
     * borderWidth.
     */
    public Drag<T> borderWidth(double borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        
        JUtils.putNotNull(obj, "enabled", enabled);
        JUtils.putNotNull(obj, "threshold", threshold);
        JUtils.putNotNull(obj, "backgroundColor", backgroundColor);
        JUtils.putNotNull(obj, "borderColor", borderColor);
        JUtils.putNotNull(obj, "borderWidth", borderWidth);

        return obj;
    }

}
