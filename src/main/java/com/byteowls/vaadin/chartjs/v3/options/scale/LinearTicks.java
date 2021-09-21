package com.byteowls.vaadin.chartjs.v3.options.scale;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class LinearTicks<T> extends Ticks<T> implements JsonBuilder {

    private static final long serialVersionUID = -7751881366365153424L;

    private Boolean beginAtZero;
    private Integer maxTicksLimit;
    private Double fixedStepSize;
    private Double stepSize;

    public LinearTicks(T parent) {
        super(parent);
    }

    /**
     * if true, scale will include 0 if it is not already included.
     */
    public LinearTicks<T> beginAtZero(Boolean beginAtZero) {
        this.beginAtZero = beginAtZero;
        return this;
    }
    
    /**
     * Maximum number of ticks and gridlines to show. If not defined, it will limit to 11 ticks but will show all gridlines.
     */
    public LinearTicks<T> maxTicksLimit(int maxTicksLimit) {
        this.maxTicksLimit = maxTicksLimit;
        return this;
    }

    /**
     * User defined fixed step size for the scale. If set, the scale ticks will be enumerated by multiple of stepSize, having one tick per increment.
     * If not set, the ticks are labeled automatically using the nice numbers algorithm.
     */
    public LinearTicks<T> fixedStepSize(double fixedStepSize) {
        this.fixedStepSize = fixedStepSize;
        return this;
    }

    /**
     * if defined, it can be used along with the min and the max to give a custom number of steps. See the example below.
     */
    public LinearTicks<T> stepSize(double stepSize) {
        this.stepSize = stepSize;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "beginAtZero", beginAtZero);
        JUtils.putNotNull(map, "maxTicksLimit", maxTicksLimit);
        JUtils.putNotNull(map, "fixedStepSize", fixedStepSize);
        JUtils.putNotNull(map, "stepSize", stepSize);
        return map;
    }
}
