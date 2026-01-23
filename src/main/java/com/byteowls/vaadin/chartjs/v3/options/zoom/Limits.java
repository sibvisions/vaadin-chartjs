package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.ZoomPlugin;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Limits<T> extends And<ZoomPlugin<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 8967179713461327763L;

    private ZoomRange<T> x;
    private ZoomRange<T> y;

    public Limits(ZoomPlugin<T> parent) {
        super(parent);
    }

    /**
     * x configuration.
     * @return x configuration.
     */
    public ZoomRange<T> x() {
        if (x == null) {
            x = new ZoomRange<>(this);
        }
        return x;
    }

    /**
     * x configuration.
     * @return x configuration.
     */
    public ZoomRange<T> y() {
        if (y == null) {
            y = new ZoomRange<>(this);
        }
        return y;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        
        JUtils.putNotNull(map, "x", x);
        JUtils.putNotNull(map, "y", y);
        
        return map;
    }

}
