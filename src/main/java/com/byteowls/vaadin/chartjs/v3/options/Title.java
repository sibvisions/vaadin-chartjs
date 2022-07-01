package com.byteowls.vaadin.chartjs.v3.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.utils.And;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Title<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 6746540710106258245L;

    private Boolean display;
    private Position position;
    private String text;
    private Boolean fullSize;
    private Font font;
    private String color; //
    private Integer padding;

    public Title(T parent) {
        super(parent);
    }

    /**
     * Display the title block
     */
    public Title<T> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * Position of the title. Only 'top' or 'bottom' are currently allowed
     */
    public Title<T> position(Position position) {
        this.position = position;
        return this;
    }

    /**
     * Title text
     */
    public Title<T> text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Marks that this box should take the full width/height of the canvas.
     */
    public Title<T> fullSize(boolean fullSize) {
        this.fullSize = fullSize;
        return this;
    }

    /**
     * Title font
     */
    public Font font() {
        if (font == null)
        {
            font = new Font();
        }
        return font;
    }

    /**
     * Color of title text
     */
    public Title<T> color(String fontColor) {
        this.color = fontColor;
        return this;
    }

    /**
     * Number of pixels to add above and below the title text
     */
    public Title<T> padding(int padding) {
        this.padding = padding;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
        JUtils.putNotNull(map, "text", text);
        JUtils.putNotNull(map, "fullSize", fullSize);
        JUtils.putNotNull(map, "color", color);
        JUtils.putNotNull(map, "padding", padding);
        JUtils.putNotNull(map, "font", font);
        
        return map;
    }
}
