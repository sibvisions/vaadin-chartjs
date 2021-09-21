package com.byteowls.vaadin.chartjs.v3.options.zoom;

import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.Pan;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

public class PanRange<T> extends And<Pan<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -1684615390757864843L;

    private Object x;
    private Object y;

    public PanRange(Pan<T> parent) {
        super(parent);
    }

    public PanRange<T> x(double x) {
        this.x = x;
        return this;
    }

    public PanRange<T> x(String x) {
        this.x = x;
        return this;
    }

    public PanRange<T> y(double y) {
        this.y = y;
        return this;
    }

    public PanRange<T> y(String x) {
        this.x = x;
        return this;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        setValue(obj, "x", x);
        setValue(obj, "y", y);
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
