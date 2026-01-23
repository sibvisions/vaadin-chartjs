package com.byteowls.vaadin.chartjs.v3.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.zoom.Limits;
import com.byteowls.vaadin.chartjs.v3.options.zoom.Pan;
import com.byteowls.vaadin.chartjs.v3.options.zoom.Reset;
import com.byteowls.vaadin.chartjs.v3.options.zoom.Zoom;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author m.oberwasserlechner@byteowls.com
 */
public class ZoomPlugin<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -5811119010899248987L;

    private Zoom<T> zoom = new Zoom<>(this);
    private Pan<T> pan = new Pan<>(this);
    private Reset<T> reset = new Reset<>(this);
    private Limits<T> limits;

    public ZoomPlugin(T parent) {
        super(parent);
    }

    /**
     * Zoom configuration.
     * @return Zoom configuration.
     */
    public Zoom<T> zoom() {
        if (zoom == null) {
            zoom = new Zoom<>(this);
        }
        return zoom;
    }

    /**
     * Pan configuration.
     * @return Pan configuration.
     */
    public Pan<T> pan() {
        if (pan == null) {
            pan = new Pan<>(this);
        }
        return pan;
    }

    /**
     * Pan configuration.
     * @return Pan configuration.
     */
    public Reset<T> reset() {
        if (reset == null) {
            reset = new Reset<>(this);
        }
        return reset;
    }

    /**
     * Limits configuration.
     * @return Limits configuration.
     */
    public Limits<T> limits() {
        if (limits == null) {
            limits = new Limits<>(this);
        }
        return limits;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        
        JUtils.putNotNull(map, "zoom", zoom);
        JUtils.putNotNull(map, "pan", pan);
        JUtils.putNotNull(map, "reset", reset);
        JUtils.putNotNull(map, "limits", limits);

        return map;
    }
}
