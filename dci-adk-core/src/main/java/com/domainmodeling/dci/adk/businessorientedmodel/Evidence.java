package com.domainmodeling.dci.adk.businessorientedmodel;

import java.time.Instant;

public interface Evidence<D> {
    String getEvidenceId();

    String getEvidenceName();

    Instant getCreatedAt();

    D getContent();
}
