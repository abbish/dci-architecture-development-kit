package adk.role;

import adk.data.DCIData;

public interface DCIRole<D extends DCIData> {
   D data();
}
