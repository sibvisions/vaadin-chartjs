package com.byteowls.vaadin.chartjs.v3.options;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;

public class DoughnutPlugin<T> extends And<T> implements JsonBuilder
{
    private static final long serialVersionUID = 3882783015489056264L;
    
    private List<DoughnutLabel> labels;

    public DoughnutPlugin(T parent)
    {
        super(parent);
    }
    
    public DoughnutPlugin<T> addLabel(DoughnutLabel label)
    {
        if (label != null)
        {
            if (labels == null)
            {
                labels = new ArrayList<DoughnutLabel>();
            }
            
            labels.add(label);
        }
        return this;
    }

    @Override
    public JsonObject buildJson()
    {
        JsonObject obj = Json.createObject();
        
        if (labels != null && labels.size() > 0)
        {
            JsonArray jaLabels = Json.createArray();
            
            for (DoughnutLabel label : labels)
            {
                jaLabels.set(jaLabels.length(), label.buildJson());
            }
                    
            obj.put("labels", jaLabels);
        }
        
        return obj;
    }

}
