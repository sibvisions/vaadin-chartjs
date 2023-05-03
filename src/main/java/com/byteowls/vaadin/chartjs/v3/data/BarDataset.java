package com.byteowls.vaadin.chartjs.v3.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.utils.ColorUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class BarDataset extends ScatterDataset {

    private static final long serialVersionUID = -5049884704390777087L;

    public enum Edge {
        BOTTOM, LEFT, TOP, RIGHT
    }

    private String type;
    protected Integer barThickness;
    protected Integer maxBarThickness;
    protected Double categoryPercentage;
    protected Double barPercentage;
    private Boolean hidden;
    private String label;
    private String xAxisID;
    private String yAxisID;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private List<Integer> borderWidth;
    private List<Edge> borderSkipped;
    private List<String> hoverBackgroundColor;
    private List<String> hoverBorderColor;
    private List<Integer> hoverBorderWidth;
    private String stack;

    private boolean randomBackgroundColors;

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public BarDataset type() {
        type = "bar";
        return this;
    }

    /**
     * Manually set width of each bar in pixels. If not set, the bars are sized automatically.
     */
    public BarDataset barThickness(int barThickness) {
        this.barThickness = barThickness;
        return this;
    }

    /**
     * Set this to ensure that the automatically sized bars are not sized thicker than this. Only works if barThickness is not set (automatic sizing is enabled).
     */
    public BarDataset maxBarThickness(int maxBarThickness) {
        this.maxBarThickness = maxBarThickness;
        return this;
    }

    /**
     * Percent (0-1) of the available width (the space between the gridlines for small datasets) for each data-point to use for the bars.
     */
    public BarDataset categoryPercentage(double categoryPercentage) {
        this.categoryPercentage = categoryPercentage;
        return this;
    }

    /**
     * Percent (0-1) of the available width each bar should be within the category percentage. 1.0 will take the whole category width and put the bars right next to each other.
     */
    public BarDataset barPercentage(double barPercentage) {
        this.barPercentage = barPercentage;
        return this;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips
     */
    public BarDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The ID of the x axis to plot this dataset on
     */
    public BarDataset xAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    /**
     * The ID of the y axis to plot this dataset on
     */
    public BarDataset yAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    /**
     * If true, the dataset is hidden
     */
    public BarDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * The fill color of the bars.
     */
    public BarDataset backgroundColor(String...  backgroundColor) {
        this.backgroundColor = Arrays.asList(backgroundColor);
        return this;
    }
    
    /**
     * The fill color of the bars.
     */
    public BarDataset backgroundColor(String  backgroundColor) {
        this.backgroundColor = Arrays.asList(backgroundColor);
        return this;
    }

    /**
     * Set random background colors for every data
     */
    public BarDataset randomBackgroundColors(boolean randomBackgroundColors) {
        this.randomBackgroundColors = randomBackgroundColors;
        return this;
    }

    /**
     * Bar border color.
     */
    public BarDataset borderColor(String... borderColor) {
        this.borderColor = Arrays.asList(borderColor);
        return this;
    }
    
    /**
     * Bar border color.
     */
    public BarDataset borderColor(String borderColor) {
        this.borderColor = Arrays.asList(borderColor);
        return this;
    }

    /**
     * Border width of bar in pixels
     */
    public BarDataset borderWidth(Integer... borderWidth) {
        this.borderWidth = Arrays.asList(borderWidth);
        return this;
    }

    /**
     * Which edge to skip drawing the border for. Options are 'bottom', 'left', 'top', and 'right'
     */
    public BarDataset borderSkipped(Edge... borderSkipped) {
        this.borderSkipped = Arrays.asList(borderSkipped);
        return this;
    }

    /**
     * Bar background color when hovered
     */
    public BarDataset hoverBackgroundColor(String...  hoverBackgroundColor) {
        this.hoverBackgroundColor = Arrays.asList(hoverBackgroundColor);
        return this;
    }

    /**
     * Bar border color when hovered
     */
    public BarDataset hoverBorderColor(String... hoverBorderColor) {
        this.hoverBorderColor = Arrays.asList(hoverBorderColor);
        return this;
    }

    /**
     * Border width of bar when hovered
     */
    public BarDataset hoverBorderWidth(Integer... hoverBorderWidth) {
        this.hoverBorderWidth = Arrays.asList(hoverBorderWidth);
        return this;
    }

    /**
     * The ID of the group to which this dataset belongs to (when stacked, each group will be a separate stack)
     */
    public BarDataset stack(String stack) {
        this.stack = stack;
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNull(map, "barThickness", barThickness);
        JUtils.putNotNull(map, "maxBarThickness", maxBarThickness);
        JUtils.putNotNull(map, "categoryPercentage", categoryPercentage);
        JUtils.putNotNull(map, "barPercentage", barPercentage);
        
        List<ScatterData> data = getData();
        JUtils.putNotNullYNumbers(map, "data", data);
        
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "xAxisID", xAxisID);
        JUtils.putNotNull(map, "yAxisID", yAxisID);
        JUtils.putNotNull(map, "hidden", hidden);
        if (randomBackgroundColors && data != null) {
            List<String> bgColors = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                bgColors.add(ColorUtils.randomColor(0.7));
            }
            backgroundColor = bgColors;
        }
        JUtils.putNotNullStringListOrSingle(map, "backgroundColor", backgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "borderColor", borderColor);
        JUtils.putNotNullIntListOrSingle(map, "borderWidth", borderWidth);
        if (borderSkipped != null) {
            List<String> list = new ArrayList<>();
            for (Edge e : borderSkipped) {
                list.add(e.name().toLowerCase());
            }
            JUtils.putNotNull(map, "borderSkipped", list);
        }
        JUtils.putNotNullStringListOrSingle(map, "hoverBackgroundColor", hoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "hoverBorderColor", hoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "hoverBorderWidth", hoverBorderWidth);
        JUtils.putNotNull(map, "stack", stack);
        return map;
    }

    public BarDataset getThis() {
        return this;
    }
}
