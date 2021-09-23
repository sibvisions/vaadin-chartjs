package com.byteowls.vaadin.chartjs.v3.config;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;

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
public class DonutChartConfig extends PieChartConfig {

    private static final long serialVersionUID = 8942176191780485298L;

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        
        JUtils.putNotNull(map, "type", "doughnut");
        
        return map;
    }
}
