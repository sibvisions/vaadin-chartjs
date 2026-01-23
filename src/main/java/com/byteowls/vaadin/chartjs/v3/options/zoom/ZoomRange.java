package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class ZoomRange<T> extends And<Limits<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 5017169168790295313L;

    private Object min;
    private Object max;
    private Double minRange;

    public ZoomRange(Limits<T> parent) {
        super(parent);
    }

    public ZoomRange<T> min(double min) {
        this.min = min;
        return this;
    }

    public ZoomRange<T> min(String min) {
        this.min = min;
        return this;
    }

    public ZoomRange<T> max(double max) {
        this.max = max;
        return this;
    }

    public ZoomRange<T> max(String max) {
        this.max = max;
        return this;
    }

    public ZoomRange<T> minRange(double minRange) {
        this.minRange = minRange;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        
        setValue(obj, "min", min);
        setValue(obj, "max", max);
        JUtils.putNotNull(obj, "minRange", minRange);
        
        return obj;
    }

    private void setValue(JsonObject obj, String key, Object value) {
        if (value instanceof String) {
            JUtils.putNotNull(obj, "x", (String) value);
        } else if (value instanceof Double) {
            JUtils.putNotNull(obj, "x", (Double) value);
        }
    }
}
