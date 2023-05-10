package com.byteowls.vaadin.chartjs.v3.options.scale;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * The time scale is used to display times and dates. It can only be placed on the X axis. 
 * 
 * When building its ticks, it will automatically calculate the most comfortable unit base on the size of the scale.
 *
 * @author michael@byteowls.com
 */
public class TimeScale extends BaseScale<TimeScale> {
    
    private TimeScaleOptions timeOptions;
    
    private String locale;

    public TimeScale() {
        type("time");
    }
    
    public TimeScaleOptions time() {
        this.timeOptions = new TimeScaleOptions(this);
        return timeOptions;
    }
    
    public TimeScale locale(String locale)
    {
        this.locale = locale;
        return this;
    }

    @Override
    public TimeScale getThis() {
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "time", timeOptions);
        if (locale != null)
        {
            JsonObject date = Json.createObject();
            JUtils.putNotNull(date, "locale", locale);
            
            JsonObject adapters = Json.createObject();
            JUtils.putNotNull(adapters, "date", date);

            JUtils.putNotNull(map, "adapters", adapters);
        }
        return map;
    }
}
