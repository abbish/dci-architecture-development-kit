package com.domainmodeling.dci.adk.businessorientedmodel.oo.fulfillment;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;

import java.lang.reflect.InvocationTargetException;

public interface RequestEvidenceConfirmation<CE extends Evidence, CC> {
    CE confirm(CC confirmationRequest) throws InvocationTargetException, IllegalAccessException;
}
