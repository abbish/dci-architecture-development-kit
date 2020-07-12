package com.domainmodeling.dci.adk.businessorientedmodel;

import java.util.Map;
import java.util.Optional;

public interface Contract extends Fulfillable {
    Map<String, Evidence> getEvidences();

    void putEvidence(String name, Evidence evidence);

    void removeEvidence(String name);

    Optional<Evidence> getEvidence(String name);

    boolean hasEvidence(String name);
}
