package com.byteowls.vaadin.chartjs.v3.config;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.v3.options.AbstractOptions;
import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

public interface ChartConfig extends JsonBuilder, Serializable {

    /**
     * Generic options for all chart configs. 
     */
    public AbstractOptions<?> options();
    
}
