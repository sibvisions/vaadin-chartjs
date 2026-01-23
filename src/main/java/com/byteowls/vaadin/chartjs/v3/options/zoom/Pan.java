package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.ZoomPlugin;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Pan<T> extends And<ZoomPlugin<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 5578767748164388843L;

    private boolean      enabled = true;
    private XYMode       mode;
    private XYMode       overScaleMode;
    private ModifierKey  modifierKey;
    private Double       threshold;

    public Pan(ZoomPlugin<T> parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Pan<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * modifierKey.
     */
    public Pan<T> modifierKey(ModifierKey modifierKey) {
        this.modifierKey = modifierKey;
        return this;
    }
    
    /**
     * Axes on which zoom is enabled.
     */
    public Pan<T> mode(XYMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Axes on which zoom is enabled.
     */
    public Pan<T> overScaleMode(XYMode mode) {
        this.overScaleMode = mode;
        return this;
    }

    /**
     * threshold.
     */
    public Pan<T> threshold(double threshold) {
        this.threshold = threshold;
        return this;
    }
    

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        
        JUtils.putNotNull(obj, "enabled", enabled);
        if (mode != null) {
            JUtils.putNotNull(obj, "mode", mode.name().toLowerCase());
        }
        if (overScaleMode != null) {
            JUtils.putNotNull(obj, "overScaleMode", overScaleMode.name().toLowerCase());
        }
        if (modifierKey != null) {
            JUtils.putNotNull(obj, "modifierKey", modifierKey.name().toLowerCase());
        }
        JUtils.putNotNull(obj, "threshold", threshold);
        
        return obj;
    }

}
