package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.ZoomPlugin;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Zoom<T> extends And<ZoomPlugin<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 3020015510398494071L;

    private Wheel<T> wheel = new Wheel<>(this);
    private Pinch<T> pinch = new Pinch<>(this);
    private Drag<T>  drag  = new Drag<>(this);
    private XYMode   mode;

    public Zoom(ZoomPlugin<T> parent) {
        super(parent);
    }

    /**
     * Wheel configuration.
     * @return Wheel configuration.
     */
    public Wheel<T> wheel() {
        if (wheel == null) {
            wheel = new Wheel<>(this);
        }
        return wheel;
    }

    /**
     * Wheel configuration.
     * @return Wheel configuration.
     */
    public Pinch<T> pinch() {
        if (pinch == null) {
            pinch = new Pinch<>(this);
        }
        return pinch;
    }

    /**
     * Drag configuration.
     * @return Drag configuration.
     */
    public Drag<T> drag() {
        if (drag == null) {
            drag = new Drag<>(this);
        }
        return drag;
    }

    /**
     * Axes on which zoom is enabled.
     */
    public Zoom<T> mode(XYMode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        
        JUtils.putNotNull(map, "wheel", wheel);
        JUtils.putNotNull(map, "pinch", pinch);
        JUtils.putNotNull(map, "drag",  drag);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        
        return map;
    }

}
