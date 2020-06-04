package com.domainmodeling.dci.adk.core.role;

import com.domainmodeling.dci.adk.core.data.DCIData;

public interface DCIRole<D extends DCIData> {
   D data();
}
