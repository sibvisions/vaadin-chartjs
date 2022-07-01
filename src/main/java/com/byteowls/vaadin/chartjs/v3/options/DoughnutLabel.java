package com.byteowls.vaadin.chartjs.v3.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class DoughnutLabel implements JsonBuilder, Serializable
{
    private static final long serialVersionUID = 4192293779407043082L;
    
    private String text;
    private String color;
    private Font font;
    
    /**
     * Text of inner label
     */
    public DoughnutLabel text(String text) {
        this.text = text;
        return this;
    }
    
    /**
     * Color of inner label
     */
    public DoughnutLabel color(String color) {
        this.color = color;
        return this;
    }
    
    /**
     * Font of inner label
     */
    public Font font() {
        if (font == null)
        {
            font = new Font();
        }
        return font;
    }
    
    @Override
    public JsonObject buildJson()
    {
        JsonObject label = Json.createObject();
        
        JUtils.putNotNull(label, "text", text);
        JUtils.putNotNull(label, "color", color);
        JUtils.putNotNull(label, "font", font);
        
        return label;
    }

}
