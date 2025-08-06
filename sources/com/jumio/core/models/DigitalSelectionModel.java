package com.jumio.core.models;

import com.jumio.core.data.country.Country;
import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import kotlin.jvm.internal.r;

public final class DigitalSelectionModel extends SelectionModel {

    /* renamed from: b  reason: collision with root package name */
    public final DigitalDocumentType f39278b;

    public DigitalSelectionModel(Country country, DigitalDocumentType digitalDocumentType) {
        super(country, (r) null);
        this.f39278b = digitalDocumentType;
    }

    public final DigitalDocumentType getDigitalDocumentType() {
        return this.f39278b;
    }
}
