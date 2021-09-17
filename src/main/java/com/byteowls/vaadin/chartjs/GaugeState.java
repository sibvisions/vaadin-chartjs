package com.byteowls.vaadin.chartjs;

import com.vaadin.shared.ui.JavaScriptComponentState;

import elemental.json.JsonObject;

public class GaugeState extends JavaScriptComponentState
{
    private static final long serialVersionUID = 7043791981214917704L;

    public boolean loggingEnabled;
    public JsonObject configurationJson;
    public int gaugeStyle;
    public double value;
}
