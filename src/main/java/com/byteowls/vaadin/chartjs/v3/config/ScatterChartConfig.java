package com.byteowls.vaadin.chartjs.v3.config;

import com.byteowls.vaadin.chartjs.v3.data.Data;
import com.byteowls.vaadin.chartjs.v3.options.types.LineChartOptions;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * A line chart is a way of plotting data points on a line.
 *
 * Often, it is used to show trend data, and the comparison of two data sets.
 *
 * @author michael@byteowls.com
 */
public class ScatterChartConfig implements ChartConfig {

    private static final long serialVersionUID = 1912287250650988200L;

    private Data<ScatterChartConfig> data;
    private LineChartOptions options;

    public Data<ScatterChartConfig> data() {
        if (this.data == null) {
            this.data = new Data<>(this);
        }
        return this.data;
    }

    public LineChartOptions options() {
        if (options == null) {
            options = new LineChartOptions(this);
        }
        return options;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", "scatter");
        if (data != null) {
            JUtils.putNotNull(map, "data", data.buildJson());
        }
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }
}
