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
    private int fontSize;
    private String fontFamily;
    private String fontStyle;
    private String fontWeight;
    
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
     * Font size of inner label
     */
    public DoughnutLabel fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }
    
    /**
     * Font family of inner label
     */
    public DoughnutLabel fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }
    
    /**
     * Font style of inner label
     */
    public DoughnutLabel fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }
    
    /**
     * Font weight of inner label
     */
    public DoughnutLabel fontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
        return this;
    }

    @Override
    public JsonObject buildJson()
    {
        JsonObject label = Json.createObject();
        
        JUtils.putNotNull(label, "text", text);
        JUtils.putNotNull(label, "color", color);
        
        JsonObject font = Json.createObject();
        
        JUtils.putNotNull(font, "size", fontSize);
        JUtils.putNotNull(font, "family", fontFamily);
        JUtils.putNotNull(font, "style", fontStyle);
        JUtils.putNotNull(font, "weight", fontWeight);
        
        label.put("font", font);
        
        return label;
    }

}
