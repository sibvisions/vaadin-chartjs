package com.byteowls.vaadin.chartjs.v3.options.scale;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class Scales<P> extends And<P> implements JsonBuilder {

    private static final long serialVersionUID = -187367367922131753L;
    
    private Map<String, BaseScale<?>> mAxes;

    public Scales(P parent) {
        super(parent);
    }

    /**
     *
     * @param axisName on which axis should the scale be placed
     * @param scale a scale
     * @return this for chaining.
     */
    public Scales<P> add(String axisName, BaseScale<?> scale)
    {
        addToAxes(axisName, scale);
        return this;
    }

    private void addToAxes(String axisName, BaseScale<?> scale) {
        if (mAxes == null)
        {
            mAxes = new LinkedHashMap<String, BaseScale<?>>();
        }
        
        mAxes.put(axisName, scale);
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        
        for (Entry<String, BaseScale<?>> entry : mAxes.entrySet())
        {
            JUtils.putNotNull(map, entry.getKey(), entry.getValue().buildJson());
        }
        
        return map;
    }
}
