package com.byteowls.vaadin.chartjs.v3.data;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Data for the bubble chart is passed in the form of an object. 
 * 
 * It is important to note that the radius property, r is not scaled by the chart. It is the raw radius in pixels of the bubble that is drawn on the canvas.
 * 
 * @author michael@byteowls.com
 *
 */
public class BubbleData implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -579013867118626066L;

    private Double x;
    private Double y;
    private Double r;

    /**
     * X Value
     */
    public BubbleData x(Double x) {
        this.x = x;
        return this;
    }

    /**
     * Y Value
     */
    public BubbleData y(Double y) {
        this.y = y;
        return this;
    }

    /**
     * Radius of bubble. This is not scaled.
     */
    public BubbleData r(Double r) {
        this.r = r;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        JUtils.putNotNull(obj, "x", x);
        JUtils.putNotNull(obj, "y", y);
        JUtils.putNotNull(obj, "r", r);
        return obj;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + ", r=" + r + "]";
    }

}
