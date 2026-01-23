package com.byteowls.vaadin.chartjs.v3.options.zoom;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.ZoomPlugin;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Reset<T> extends And<ZoomPlugin<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 5578767748164388843L;

    private boolean      enabled = true;
    private ModifierKey  modifierKey;

    public Reset(ZoomPlugin<T> parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Reset<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * modifierKey.
     */
    public Reset<T> modifierKey(ModifierKey modifierKey) {
        this.modifierKey = modifierKey;
        return this;
    }
    

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        
        JUtils.putNotNull(obj, "enabled", enabled);
        if (modifierKey != null) {
            JUtils.putNotNull(obj, "modifierKey", modifierKey.name().toLowerCase());
        }
        
        return obj;
    }

}
