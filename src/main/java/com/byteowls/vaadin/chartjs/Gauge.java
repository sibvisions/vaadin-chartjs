package com.byteowls.vaadin.chartjs;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;

import elemental.json.JsonObject;

/**
 * The <code>Gauge</code> is the vaadin javascript component used to integrate gauge library with vaadin.
 * 
 * @author Jozef Dorko
 */
@JavaScript({"vaadin://chartjs/bundle.js", "vaadin://chartjs/gauge-connector.js"})
@StyleSheet("vaadin://chartjs/bundle.min.css")
public class Gauge extends AbstractJavaScriptComponent
{
    private static final long serialVersionUID = 3785716889040172732L;

    @Override
    protected GaugeState getState()
    {
        return (GaugeState) super.getState();
    }
    
    public void setGaugeStyle(int pGaugeStyle)
    {
        getState().gaugeStyle = pGaugeStyle;
    }
    
    public int getGaugeStyle()
    {
        return getState().gaugeStyle;
    }
    
    public void setConfiguration(JsonObject pConfiguration)
    {
        getState().configurationJson = pConfiguration;
    }
    
    public JsonObject getConfiguration()
    {
        return getState().configurationJson;
    }
    
}
