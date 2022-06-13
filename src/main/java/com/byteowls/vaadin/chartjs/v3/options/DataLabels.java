package com.byteowls.vaadin.chartjs.v3.options;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class DataLabels<T> extends And<T> implements JsonBuilder
{
    private static final long serialVersionUID = 5663612698207442549L;
    
    private Boolean display;
    private String align;
    private String backgroundColor;
    private String borderRadius;
    private String formatter;
    
    public DataLabels(T parent)
    {
        super(parent);
    }
    
    /**
     * Is the legend displayed. Default: true
     */
    public DataLabels<T> display(boolean display) {
        this.display = display;
        return this;
    }
    
    /**
     * Alignment of data labels
     */
    public DataLabels<T> align(String align) {
        this.align = align;
        return this;
    }
    
    /**
     * Background color of data labels
     */
    public DataLabels<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    /**
     * Border radius of background rectangle
     */
    public DataLabels<T> borderRadius(String borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }
    
    /**
     * Arguments: tooltipItem, data
     */
    public DataLabels<T> formatter(String formatter) {
        this.formatter = formatter;
        return this;
    }

    @Override
    public JsonObject buildJson()
    {
        JsonObject obj = Json.createObject();
        JUtils.putNotNull(obj, "display", display);
        JUtils.putNotNull(obj, "align", align);
        JUtils.putNotNull(obj, "backgroundColor", backgroundColor);
        JUtils.putNotNull(obj, "borderRadius", borderRadius);
        JUtils.putNotNullCallback(obj, "formatter", formatter, "value");
        
        return obj;
    }

}
