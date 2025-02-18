package com.byteowls.vaadin.chartjs.v3.options.scale;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.Position;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public abstract class BaseScale<B extends BaseScale<?>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -2382244938070735956L;

    public enum Bounds {
        DATA,
        TICKS
    }
    
    static String boundsToString(Bounds bounds) {
        if (bounds==null) return null;
        return bounds.toString().toLowerCase();
    }
    
    private String id;
    protected String type;
    protected Boolean display;
    protected Position position;
    protected Boolean stacked;
    protected Boolean offset;
    protected Double min;
    protected Double max;
    protected Double suggestedMin;
    protected Double suggestedMax;
    protected Bounds bounds = Bounds.TICKS; // should be default
    protected GridLines<B> gridLines;
    protected Ticks<B> ticks;
    protected ScaleLabel<B> scaleLabel;

    /**
     * "category", "linear", "logarithmic", "time", "radialLinear"
     */
    public BaseScale<B> type(String type) {
        this.type = type;
        return this;
    }

    /**
     * If true, show the scale including gridlines, ticks, and labels. Overrides gridLines.display, scaleLabel.display, and ticks.display.
     */
    public BaseScale<B> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * The ID is used to link datasets and scale axes together. The properties `datasets.xAxisID` or `datasets.yAxisID` have to match the scale properties `scales.xAxes.id` or `scales.yAxes.id`. This is especially needed if multi-axes charts are used.
     */
    public BaseScale<B> id(String id) {
        this.id = id;
        return this;
    }

    /**
     * If true, bars are stacked on the x-axis
     */
    public BaseScale<B> stacked(boolean stacked) {
        this.stacked = stacked;
        return this;
    }
    
    /**
     * If true, bars are stacked on the x-axis
     */
    public BaseScale<B> offset(boolean pOffset) {
        offset = pOffset;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value from data.
     */
    public BaseScale<B> min(int min) {
        this.min = (double) min;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value from data.
     */
    public BaseScale<B> min(double min) {
        this.min = min;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value from data.
     */
    public BaseScale<B> max(int max) {
        this.max = (double) max;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value from data.
     */
    public BaseScale<B> max(double max) {
        this.max = max;
        return this;
    }
    
    /**
     * User defined maximum number for the scale, overrides maximum value except for if it is lower than the maximum value.
     */
    public BaseScale<B> suggestedMax(int suggestedMax) {
        this.suggestedMax = (double) suggestedMax;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value except for if it is lower than the maximum value.
     */
    public BaseScale<B> suggestedMax(double suggestedMax) {
        this.suggestedMax = suggestedMax;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value except for if it is higher than the minimum value.
     */
    public BaseScale<B> suggestedMin(int suggestedMin) {
        this.suggestedMin = (double) suggestedMin;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value except for if it is higher than the minimum value.
     */
    public BaseScale<B> suggestedMin(double suggestedMin) {
        this.suggestedMin = suggestedMin;
        return this;
    }

    /**
     * User defined bounds can be "data" or "ticks".
     */
    public BaseScale<B> bounds(Bounds bounds) {
        this.bounds = bounds;
        return this;
    }
    
    /**
     * Position of the scale.
     */
    public BaseScale<B> position(Position position) {
        this.position = position;
        return this;
    }

    /**
     * It defines options for the grid lines that run perpendicular to the axis.
     */
    public GridLines<B> gridLines() {
        if (gridLines == null) {
            gridLines = new GridLines<>(getThis());
        }
        return gridLines;
    }

    /**
     * Define options for the scale title.
     */
    public ScaleLabel<B> scaleLabel() {
        if (scaleLabel == null) {
            scaleLabel = new ScaleLabel<>(getThis());
        }
        return scaleLabel;
    }

    /**
     * It defines options for the tick marks that are generated by the axis.
     */
    public Ticks<B> ticks() {
        if (ticks == null) {
            ticks = new Ticks<>(getThis());
        }
        return ticks;
    }

    public abstract B getThis();


    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNull(map, "display", display);
        JUtils.putNotNull(map, "id", id);
        JUtils.putNotNull(map, "stacked", stacked);
        JUtils.putNotNull(map, "offset", offset);
        JUtils.putNotNull(map, "min", min);
        JUtils.putNotNull(map, "max", max);
        JUtils.putNotNull(map, "suggestedMin", suggestedMin);
        JUtils.putNotNull(map, "suggestedMax", suggestedMax);
        JUtils.putNotNull(map, "bounds", boundsToString(bounds));
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
        JUtils.putNotNull(map, "gridLines", gridLines);
        JUtils.putNotNull(map, "title", scaleLabel);
        JUtils.putNotNull(map, "ticks", ticks);
        return map;
    }
}
