package com.byteowls.vaadin.chartjs.v3.options;

import com.byteowls.vaadin.chartjs.v3.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

public class PieAnimation<T> extends Animation<T> {

    private static final long serialVersionUID = 5928748231789002901L;

    private Integer duration;
    private AnimationEasing easing;
    // TODO callback functions http://www.chartjs.org/docs/#chart-configuration-animation-configuration
    // onProgress Callback called on each step of an animation. Passed a single argument, an object, containing the chart instance and an object with details of the animation.
    // onComplete Callback called at the end of an animation. Passed the same arguments as onProgress
    private Boolean animateRotate;
    private Boolean animateScale;

    public PieAnimation(T parent) {
        super(parent);
    }

    /**
     * If true, will animate the rotation of the chart.
     */
    public PieAnimation<T> animateRotate(boolean animateRotate) {
        this.animateRotate = animateRotate;
        return this;
    }

    /**
     * If true, will animate scaling the Doughnut from the centre.
     */
    public PieAnimation<T> animateScale(boolean animateScale) {
        this.animateScale = animateScale;
        return this;
    }

    /**
     * The number of milliseconds an animation takes.
     */
    public PieAnimation<T> duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Easing function to use.
     */
    public PieAnimation<T> easing(AnimationEasing easing) {
        this.easing = easing;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        JUtils.putNotNull(obj, "duration", duration);
        if (easing != null) {
            JUtils.putNotNull(obj, "easing", easing.name());
        }
        JUtils.putNotNull(obj, "animateRotate", animateRotate);
        JUtils.putNotNull(obj, "animateScale", animateScale);
        return obj;
    }

}
