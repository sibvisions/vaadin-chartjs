package com.byteowls.vaadin.chartjs.v3.options.types;

import com.byteowls.vaadin.chartjs.v3.config.ChartConfig;
import com.byteowls.vaadin.chartjs.v3.options.AbstractScalableOptions;

public class BarChartOptions extends AbstractScalableOptions<BarChartOptions> {

    private static final long serialVersionUID = 6873332861426634973L;

    public BarChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    @Override
    public BarChartOptions getThis() {
        return this;
    }

}
