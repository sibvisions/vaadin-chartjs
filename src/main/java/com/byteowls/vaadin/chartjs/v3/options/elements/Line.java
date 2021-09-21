package com.byteowls.vaadin.chartjs.v3.options.elements;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.options.FillMode;
import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Line elements are used to represent the line in a line chart.
 *
 * @author michael@byteowls.com
 */
public class Line<T> extends And<Element<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 7489460081517158968L;

    public enum CapStyle {
        BUTT, ROUND, SQUARE
    }

    public enum JoinStyle {
        BEVEL, ROUND, MITER
    }

    private Double tension;
    private String backgroundColor;
    private Integer borderWidth;
    private String borderColor;
    private CapStyle borderCapStyle;
    private List<Integer> borderDash;
    private Double borderDashOffset;
    private JoinStyle borderJoinStyle;
    private Boolean capBezierPoints;
    private Boolean fill;
    private FillMode fillMode;


    public Line(Element<T> parent) {
        super(parent);
    }


    /**
     * Default bezier curve tension. Set to 0 for no bezier curves. Default: 0.4
     */
    public Line<T> tension(double tension) {
        this.tension = tension;
        return this;
    }

    /**
     * Default line fill color. Default: 'rgba(0,0,0,0.1)'
     */
    public Line<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Default line stroke width. Default: 3
     */
    public Line<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Default line stroke color. Default: 'rgba(0,0,0,0.1)'
     */
    public Line<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Default line cap style. Default: {@link CapStyle#BUTT}
     */
    public Line<T> borderCapStyle(CapStyle borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
        return this;
    }

    /**
     * Length and spacing of dashes.
     */
    public Line<T> borderDash(Integer... borderDash) {
        this.borderDash = Arrays.asList(borderDash);
        return this;
    }


    /**
     * Default line dash offset. Default: 0.0
     */
    public Line<T> borderDashOffset(double borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    /**
     * Default join cap style. Default: {@link JoinStyle#MITER}
     */
    public Line<T> borderJoinStyle(JoinStyle borderJoinStyle) {
        this.borderJoinStyle = borderJoinStyle;
        return this;
    }

    /**
     * If true, bezier control points are kept inside the chart. If false, no restriction is enforced. Default: true
     */
    public Line<T> capBezierPoints(boolean capBezierPoints) {
        this.capBezierPoints = capBezierPoints;
        return this;
    }

    /**
     * If true, the line is filled. Default: true
     */
    public Line<T> fill(boolean fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Use the modes to fill different locations.
     */
    public Line<T> fill(FillMode fillMode) {
        this.fillMode = fillMode;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "tension", tension);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        if (borderCapStyle != null) {
            JUtils.putNotNull(map, "borderCapStyle", borderCapStyle.name().toLowerCase());
        }
        JUtils.putNotNullIntList(map, "borderDash", borderDash);
        JUtils.putNotNull(map, "borderDashOffset", borderDashOffset);
        if (borderJoinStyle != null) {
            JUtils.putNotNull(map, "borderJoinStyle", borderJoinStyle.name().toLowerCase());
        }
        JUtils.putNotNull(map, "capBezierPoints", capBezierPoints);
        if (this.fillMode == null) {
            JUtils.putNotNull(map, "fill", fill);
        } else {
            JUtils.putNotNull(map, "fill", fillMode.name().toLowerCase());
        }
        return map;
    }

}
