window.com_byteowls_vaadin_chartjs_Gauge = function() {
    // see the javadoc of com.vaadin.ui.
    // for all functions on this.
    var e = this.getElement();
    // Please note that in JavaScript, this is not necessarily defined inside callback functions and it might therefore be necessary to assign the reference to a separate variable
    var self = this;
    var loggingEnabled = false;
    var gaugeDiv;
    var gauge;
    var stateChangedCnt = 0;
    
    /** 
     * enum for different gauge styles 
     */
    const GAUGE_STYLES = {
        STYLE_SPEEDOMETER:	0,
        STYLE_METER: 		1,
        STYLE_RING:			2,
        STYLE_FLAT:			3,
    }

    // called every time the state is changed
    this.onStateChange = function() {
        stateChangedCnt++;
        var state = this.getState();
        loggingEnabled = state.loggingEnabled;
        if (loggingEnabled) {
            console.log("chartjs: accessing onStateChange the "+stateChangedCnt+". time");
        }
        if (typeof gaugeDiv === 'undefined') {
            if (loggingEnabled) {
                console.log("gauge: create gauge div");
            }
            gaugeDiv = document.createElement('div');
            if (state.width && state.width.length > 0) {
                if (loggingEnabled) {
                    console.log("gauge: gauge width " + state.width);
                }
                gaugeDiv.setAttribute('width', state.width);
            }
            if (state.height && state.height.length > 0) {
                if (loggingEnabled) {
                    console.log("chartjs: canvas height " + state.height);
                }
                gaugeDiv.setAttribute('height', state.height);
            }
            e.appendChild(gaugeDiv)
        } else {
            if (loggingEnabled) {
                console.log("gauge: gauge div already exists");
            }
        }

        if (typeof gauge === 'undefined' && state.configurationJson !== 'undefined') {
            if (loggingEnabled) {
                console.log("gauge: init");
            }

            if (loggingEnabled) {
                console.log("gauge: configuration is\n", JSON.stringify(state.configurationJson, null, 2));
            }
            
            if (state.gaugeStyle === GAUGE_STYLES.STYLE_SPEEDOMETER) {
            	gauge = new UIGauges.SpeedometerGauge(gaugeDiv, state.configurationJson);
            } else if (state.gaugeStyle === GAUGE_STYLES.STYLE_METER) {
            	gauge = new UIGauges.MeterGauge(gaugeDiv, state.configurationJson);
            } else if (state.gaugeStyle === GAUGE_STYLES.STYLE_RING) {
            	gauge = new UIGauges.RingGauge(gaugeDiv, state.configurationJson);
            } else if (state.gaugeStyle === GAUGE_STYLES.STYLE_FLAT) {
            	gauge = new UIGauges.ArcGauge(gaugeDiv, state.configurationJson);
            }
            
        } else {
            // update the data
        	gauge.update(state.configurationJson);
        }

    };

    /**
     * Creates and returns a new div element and sets the class attribute to the
     * given css classes.
     */
    this.createDiv = function(className) {
        var div = document.createElement('div');
        if (className) {
            div.className = className;
        }
        return div;
    };

};
