package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Wheel<T> extends And<Zoom<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -206539156696482093L;

    private boolean      enabled = true;
    private ModifierKey  modifierKey;
    private Double       speed;

    public Wheel(Zoom<T> parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Wheel<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * modifierKey.
     */
    public Wheel<T> modifierKey(ModifierKey modifierKey) {
        this.modifierKey = modifierKey;
        return this;
    }
    
    /**
     * speed.
     */
    public Wheel<T> speed(double speed) {
        this.speed = speed;
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        
        JUtils.putNotNull(obj, "enabled", enabled);
        if (modifierKey != null) {
            JUtils.putNotNull(obj, "modifierKey", modifierKey.name().toLowerCase());
        }
        JUtils.putNotNull(obj, "speed", speed);

        return obj;
    }

}
