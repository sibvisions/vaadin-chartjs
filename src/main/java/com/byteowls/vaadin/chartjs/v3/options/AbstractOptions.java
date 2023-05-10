package com.byteowls.vaadin.chartjs.v3.options;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.config.ChartConfig;
import com.byteowls.vaadin.chartjs.v3.options.elements.Element;
import com.byteowls.vaadin.chartjs.v3.utils.JUtils;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public abstract class AbstractOptions<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 2220469604021816291L;

    private ChartConfig chartConfig;

    protected Boolean responsive;
    private Integer responsiveAnimationDuration;
    private Boolean maintainAspectRatio;
    private Double aspectRatio;
    private Integer devicePixelRatio;
    private String locale;
    private List<String> events;
    private Title<T> title;
    private Tooltips<T> tooltips;
    private Hover<T> hover;
    private Animation<T> animation;
    private Legend<T> legend;
    private Element<T> elements;
    private Pan<T> pan;
    private Zoom<T> zoom;
    private DataLabels<T> dataLabels;
    private DoughnutPlugin<T> doughnutPlugin;

    public AbstractOptions(ChartConfig chartConfig) {
        this.chartConfig = chartConfig;
    }

    /**
     * Resizes when the canvas container does.
     */
    public T responsive(boolean responsive) {
        this.responsive = responsive;
        return getThis();
    }

    /**
     * Canvas aspect ratio (i.e. width / height, a value of 1 representing a square canvas).
     * Note that this option is ignored if the height is explicitly defined either as attribute or via the style.
     */
    public T aspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
        return getThis();
    }
    
    /**
     * Maintain the original canvas aspect ratio (width / height) when resizing.
     */
    public T maintainAspectRatio(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
        return getThis();
    }

    /**
     * Duration in milliseconds it takes to animate to new size after a resize event.
     */
    public T responsiveAnimationDuration(int responsiveAnimationDurationMs) {
        this.responsiveAnimationDuration = responsiveAnimationDurationMs;
        return getThis();
    }

    /**
     * Defines the ratio between display pixels and rendered pixels.
     */
    public T devicePixelRatio(int devicePixelRatio) {
        this.devicePixelRatio = devicePixelRatio;
        return getThis();
    }

    /**
     * Defines the language for number axis.
     */
    public T locale(String locale)
    {
        this.locale = locale;
        return getThis();
    }

    /**
     * Events that the chart should listen to for tooltips and hovering
     */
    public T events(String... events) {
        this.events = Arrays.asList(events);
        return getThis();
    }

    /**
     * Step into the charts title configuration
     */
    public Title<T> title() {
        if (title == null) {
            title = new Title<>(getThis());
        }
        return title;
    }

    /**
     * Step into the charts animation configuration
     */
    public Animation<T> animation() {
        if (animation == null) {
            animation = new Animation<>(getThis());
        }
        return animation;
    }

    /**
     * Step into the charts hover configuration
     */
    public Hover<T> hover() {
        if (hover == null) {
            hover = new Hover<>(getThis());
        }
        return hover;
    }

    /**
     * Step into the charts tooltip configuration
     */
    public Tooltips<T> tooltips() {
        if (tooltips == null) {
            tooltips = new Tooltips<>(getThis());
        }
        return tooltips;
    }

    /**
     * Step into the charts legend configuration
     */
    public Legend<T> legend() {
        if (legend == null) {
            legend = new Legend<>(getThis());
        }
        return legend;
    }

    /**
     * Step into the charts elements configuration
     */
    public Element<T> elements() {
        if (elements == null) {
            elements = new Element<>(getThis());
        }
        return elements;
    }


    /**
     * Step into the pan configuration.
     */
    public Pan<T> pan() {
        if (pan == null) {
            pan = new Pan<>(getThis());
        }
        return pan;
    }

    /**
     * Step into the zoom configuration
     */
    public Zoom<T> zoom() {
        if (zoom == null) {
            zoom = new Zoom<>(getThis());
        }
        return zoom;
    }
    
    /**
     * Step into the data labels configuration. 
     */
    public DataLabels<T> dataLabels() {
        if (dataLabels == null)
        {
            dataLabels = new DataLabels<>(getThis());
        }
        return dataLabels;
    }
    
    /**
     * Step into the doughnut plugin configuration. 
     */
    public DoughnutPlugin<T> doughnutPlugin() {
        if (doughnutPlugin == null)
        {
            doughnutPlugin = new DoughnutPlugin<>(getThis());
        }
        return doughnutPlugin;
    }
    
    public abstract T getThis();

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        
        JsonObject plugins = Json.createObject();
        
        JUtils.putNotNull(plugins, "title", title);
        JUtils.putNotNull(plugins, "legend", legend);
        JUtils.putNotNull(plugins, "tooltip", tooltips);
        JUtils.putNotNull(plugins, "datalabels", dataLabels);
        JUtils.putNotNull(plugins, "doughnutlabel", doughnutPlugin);
        
        JUtils.putNotNull(map, "plugins", plugins);
        
        JUtils.putNotNull(map, "responsive", responsive);
        JUtils.putNotNull(map, "aspectRatio", aspectRatio);
        JUtils.putNotNull(map, "maintainAspectRatio", maintainAspectRatio);
        JUtils.putNotNull(map, "responsiveAnimationDuration", responsiveAnimationDuration);
        JUtils.putNotNull(map, "devicePixelRatio", devicePixelRatio);
        JUtils.putNotNull(map, "locale", locale);
        JUtils.putNotNull(map, "events", events);
        JUtils.putNotNull(map, "title", title);
        JUtils.putNotNull(map, "hover", hover);
        JUtils.putNotNull(map, "animation", animation);
        JUtils.putNotNull(map, "legend", legend);
        JUtils.putNotNull(map, "elements", elements);
        JUtils.putNotNull(map, "pan", pan);
        JUtils.putNotNull(map, "zoom", zoom);
        return map;
    }

    public ChartConfig done() {
        return chartConfig;
    }

}
