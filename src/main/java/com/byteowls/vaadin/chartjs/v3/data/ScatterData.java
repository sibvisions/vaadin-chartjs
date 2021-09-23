package com.byteowls.vaadin.chartjs.v3.data;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Data for the scatter line chart is passed in the form of an object. 
 * 
 * @author michael@byteowls.com
 *
 */
public class ScatterData implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 680613867864908619L;

    private Double x;
    private Double y;

    /**
     * X Value
     */
    public ScatterData x(Double x) {
        this.x = x;
        return this;
    }

    /**
     * Y Value
     */
    public ScatterData y(Double y) {
        this.y = y;
        return this;
    }
    
    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        JUtils.putNotNull(obj, "x", x);
        JUtils.putNotNull(obj, "y", y);
        return obj;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + "]";
    }

}
