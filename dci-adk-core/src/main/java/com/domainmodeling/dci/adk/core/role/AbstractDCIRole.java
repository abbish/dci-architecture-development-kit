package com.domainmodeling.dci.adk.core.role;

import com.domainmodeling.dci.adk.core.data.DCIData;

public abstract class AbstractDCIRole<D extends DCIData> implements DCIRole<D> {
    final private D data;

    protected AbstractDCIRole(D data) {
        this.data = data;
    }

    public D data() {
        return data;
    }
}
