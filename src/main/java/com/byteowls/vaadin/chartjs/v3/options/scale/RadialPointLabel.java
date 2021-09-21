package com.byteowls.vaadin.chartjs.v3.options.scale;

import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

/**
 * Used to configure the point labels that are shown on the perimeter of the scale.
 *
 * Note that these options only apply if `display` is true.
 */
public class RadialPointLabel<T> extends And<T> implements JsonBuilder {

    private static final long serialVersionUID = 3782246450705674195L;

    // TODO callback Callback function to transform data label to axis label
    private Boolean display;
    private List<String> fontColor;
    private String fontFamily;
    private Integer fontSize;
    private String fontStyle;

    /**
     * If true, point labels are shown. Default: true
     */
    public RadialPointLabel<T> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * Font color. Default: #666
     */
    public RadialPointLabel<T> fontColor(String... fontColor) {
        this.fontColor = Arrays.asList(fontColor);
        return this;
    }

    /**
     * Font family to render. Default: 'Helvetica Neue', 'Helvetica', 'Arial', sans-serif
     */
    public RadialPointLabel<T> fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * Font size in pixels. Default: 10
     */
    public RadialPointLabel<T> fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * Font Style to use. Default: normal
     */
    public RadialPointLabel<T> fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }


    public RadialPointLabel(T parent) {
        super(parent);
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        JUtils.putNotNullList(map, "fontColor", fontColor);
        JUtils.putNotNull(map, "fontFamily", fontFamily);
        JUtils.putNotNull(map, "fontSize", fontSize);
        JUtils.putNotNull(map, "fontStyle", fontStyle);
        return map;
    }

}
