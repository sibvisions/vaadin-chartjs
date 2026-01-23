package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Pinch<T> extends And<Zoom<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 7789432773404357588L;

    private boolean      enabled = true;

    public Pinch(Zoom<T> parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Pinch<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        
        JUtils.putNotNull(obj, "enabled", enabled);
        
        return obj;
    }

}
