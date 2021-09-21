package com.byteowls.vaadin.chartjs.v3.data;

import java.io.Serializable;
import java.util.List;

import com.byteowls.vaadin.chartjs.v3.utils.JsonBuilder;

/**
 * @author michael@byteowls.com
 */
public interface Dataset<T, D> extends JsonBuilder, Serializable {

    T data(@SuppressWarnings("unchecked") D... data);

    T dataAsList(List<D> data);

    List<D> getData();

    /**
     * Add the data value with a label. This is useful if you dynamically build labels and the datasets.
     * @param label the label the data belongs to
     * @param data
     * @return
     * @see Data#extractLabelsFromDataset(boolean)
     */
    T addLabeledData(String label, D data);

    /**
     * Gets the datasets labels.
     * @return a {@link List} of labels
     */
    List<String> getDataLabels();

}
