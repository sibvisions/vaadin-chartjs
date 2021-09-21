package com.byteowls.vaadin.chartjs.v3.options;

import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.zoom.PanRange;
import com.byteowls.vaadin.chartjs.v3.options.zoom.XYMode;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

/**
 * @author m.oberwasserlechner@byteowls.com
 */
public class Pan<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 809245656623461157L;

    private boolean enabled = true;
    private Double speed;
    private Double threshold;
    private XYMode mode;
    private PanRange<T> rangeMin;
    private PanRange<T> rangeMax;


    public Pan(T parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Pan<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Pan<T> speed(double speed) {
        this.speed = speed;
        return this;
    }

    public Pan<T> threshold(double threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * Axes on which pan is enabled.
     */
    public Pan<T> mode(XYMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Minimum range limits for pan.
     * Range currently supports Double and String values. Usage depends on the datatypes in your scales.
     */
    public PanRange<T> rangeMin() {
        if (rangeMin == null) {
            rangeMin = new PanRange<>(this);
        }
        return rangeMin;
    }

    /**
     * Maximum range limits for pan.
     * Range currently supports Double and String values. Usage depends on the datatypes in your scales.
     */
    public PanRange<T> rangeMax() {
        if (rangeMax == null) {
            rangeMax = new PanRange<>(this);
        }
        return rangeMax;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        JUtils.putNotNull(map, "speed", speed);
        JUtils.putNotNull(map, "threshold", threshold);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
//        JUtils.putNotNull(map, "limits", limits);
        JUtils.putNotNull(map, "rangeMin", rangeMin);
        JUtils.putNotNull(map, "rangeMax", rangeMax);
        return map;
    }
}
