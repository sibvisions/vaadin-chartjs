package com.byteowls.vaadin.chartjs.v3.options.scale;

import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

/**
 * @author michael@byteowls.com
 */
public class GridLines<T> extends And<T> implements JsonBuilder {

    private static final long serialVersionUID = 8138642242241971120L;

    private Boolean display;
    private List<String> color;
    private Integer lineWidth;
    private Boolean drawBorder;
    private Boolean drawOnChartArea;
    private Boolean drawTicks;
    private Integer tickMarkLength;
    private Integer zeroLineWidth;
    private String zeroLineColor;
    private List<Integer> zeroLineBorderDash;
    private Double zeroLineBorderDashOffset;
    private Boolean offsetGridLines;
    private Boolean circular;

    public GridLines(T parent) {
        super(parent);
    }

    public GridLines<T> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * Color of the grid lines.
     */
    public GridLines<T> color(String... color) {
        this.color = Arrays.asList(color);
        return this;
    }

    /**
     * Stroke width of grid lines
     */
    public GridLines<T> lineWidth(Integer lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    /**
     * If true draw border on the edge of the chart
     */
    public GridLines<T> drawBorder(boolean drawBorder) {
        this.drawBorder = drawBorder;
        return this;
    }

    /**
     * If true, draw lines on the chart area inside the axis lines.
     * This is useful when there are multiple axes and you need to control which grid lines are drawn
     */
    public GridLines<T> drawOnChartArea(boolean drawOnChartArea) {
        this.drawOnChartArea = drawOnChartArea;
        return this;
    }

    /**
     * If true, draw lines beside the ticks in the axis area beside the chart.
     */
    public GridLines<T> drawTicks(boolean drawTicks) {
        this.drawTicks = drawTicks;
        return this;
    }

    /**
     * Length in pixels that the grid lines will draw into the axis area.
     */
    public GridLines<T> tickMarkLength(Integer tickMarkLength) {
        this.tickMarkLength = tickMarkLength;
        return this;
    }

    /**
     * Stroke width of the grid line for the first index (index 0).
     */
    public GridLines<T> zeroLineWidth(Integer zeroLineWidth) {
        this.zeroLineWidth = zeroLineWidth;
        return this;
    }

    /**
     * Stroke color of the grid line for the first index (index 0).
     */
    public GridLines<T> zeroLineColor(String zeroLineColor) {
        this.zeroLineColor = zeroLineColor;
        return this;
    }

    /**
     * Length and spacing of dashes of the grid line for the first index (index 0). See [MDN](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/setLineDash)
     */
    public  GridLines<T> zeroLineBorderDash(Integer... zeroLineBorderDash) {
        this.zeroLineBorderDash = Arrays.asList(zeroLineBorderDash);
        return this;
    }

    /**
     * Offset for line dashes of the grid line for the first index (index 0). See [MDN](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineDashOffset)
     */
    public GridLines<T> zeroLineBorderDashOffset(double zeroLineBorderDashOffset) {
        this.zeroLineBorderDashOffset = zeroLineBorderDashOffset;
        return this;
    }

    /**
     * If true, offset labels from grid lines.
     */
    public GridLines<T> offsetGridLines(boolean offsetGridLines) {
        this.offsetGridLines = offsetGridLines;
        return this;
    }

    /**
     * If true, radial lines are circular. If false, they are straight lines connecting the the different angle line locations. Default: false
     */
    public GridLines<T> circular(boolean circular) {
        this.circular = circular;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        JUtils.putNotNullStringListOrSingle(map, "color", color);
        JUtils.putNotNull(map, "lineWidth", lineWidth);
        JUtils.putNotNull(map, "drawBorder", drawBorder);
        JUtils.putNotNull(map, "drawOnChartArea", drawOnChartArea);
        JUtils.putNotNull(map, "drawTicks", drawTicks);
        JUtils.putNotNull(map, "tickMarkLength", tickMarkLength);
        JUtils.putNotNull(map, "zeroLineWidth", zeroLineWidth);
        JUtils.putNotNull(map, "zeroLineColor", zeroLineColor);
        JUtils.putNotNullIntListOrSingle(map, "zeroLineBorderDash", zeroLineBorderDash);
        JUtils.putNotNull(map, "zeroLineBorderDashOffset", zeroLineBorderDashOffset);
        JUtils.putNotNull(map, "offsetGridLines", offsetGridLines);
        JUtils.putNotNull(map, "circular", circular);
        return map;
    }
}
