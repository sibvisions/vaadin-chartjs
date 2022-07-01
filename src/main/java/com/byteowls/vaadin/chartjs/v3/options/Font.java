package com.byteowls.vaadin.chartjs.v3.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Font implements JsonBuilder, Serializable
{
    private static final long serialVersionUID = 2553097528336831077L;
    
    private int size;
    private String family;
    private String style;
    private String weight;
    
    /**
     * Font size. Defaults: 12
     */
    public Font size(int size) {
        this.size = size;
        return this;
    }
    
    /**
     * Font family.
     */
    public Font family(String family) {
        this.family = family;
        return this;
    }
    
    /**
     * Font style. Defaults: normal
     */
    public Font style(String style) {
        this.style = style;
        return this;
    }
    
    /**
     * Font weight.
     */
    public Font weight(String weight) {
        this.weight = weight;
        return this;
    }
    
    @Override
    public JsonObject buildJson()
    {
        JsonObject font = Json.createObject();
        
        JUtils.putNotNull(font, "size", size);
        JUtils.putNotNull(font, "family", family);
        JUtils.putNotNull(font, "style", style);
        JUtils.putNotNull(font, "weight", weight);
        
        return font;
    }

}
