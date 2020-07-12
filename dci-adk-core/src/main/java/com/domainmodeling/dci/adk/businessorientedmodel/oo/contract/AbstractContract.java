package com.domainmodeling.dci.adk.businessorientedmodel.oo.contract;

import com.domainmodeling.dci.adk.businessorientedmodel.oo.evidence.Evidence;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractContract implements Contract {

    final private Map<String, Evidence> evidences = new HashMap<>();

    @Override
    final public Map<String, Evidence> getEvidences() {
        return evidences;
    }

    @Override
    final public void putEvidence(String name, Evidence evidence) {
        this.evidences.put(name, evidence);
    }

    @Override
    final public void removeEvidence(String name) {
        this.evidences.remove(name);
    }

    @Override
    final public Optional<Evidence> getEvidence(String name) {
        return Optional.of(this.evidences.get(name));
    }

    @Override
    final public boolean hasEvidence(String name) {
        return this.evidences.containsKey(name);
    }
}
