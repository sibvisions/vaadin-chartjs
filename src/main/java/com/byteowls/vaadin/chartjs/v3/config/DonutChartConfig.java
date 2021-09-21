package com.byteowls.vaadin.chartjs.v3.config;

import com.byteowls.vaadin.chartjs.v3.data.Data;
import com.byteowls.vaadin.chartjs.v3.options.types.PieChartOptions;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Pie and doughnut charts are probably the most commonly used chart there are. 
 * They are divided into segments, the arc of each segment shows the proportional value of each piece of data.
 * 
 * They are excellent at showing the relational proportions between data.
 * 
 * Pie and doughnut charts are effectively the same class in Chart.js, but have one different default value - their cutoutPercentage. This equates what percentage of the inner should be cut out. This defaults to 0 for pie charts, and 50 for doughnuts.
 * 
 * They are also registered under two aliases in the Chart core. Other than their different default value, and different alias, they are exactly the same.
 *
 * Often, it is used to show trend data, and the comparison of two data sets.
 *
 * @author michael@byteowls.com
 */
public class DonutChartConfig implements ChartConfig {

    private static final long serialVersionUID = 8942176191780485298L;

    private Data<DonutChartConfig> data;
    private PieChartOptions options;

    public Data<DonutChartConfig> data() {
        if (this.data == null) {
            this.data = new Data<>(this);
        }
        return this.data;
    }

    public PieChartOptions options() {
        if (options == null) {
            options = new PieChartOptions(this);
        }
        return options;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", "doughnut");
        if (data != null) {
            JUtils.putNotNull(map, "data", data.buildJson());
        }
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }
}
