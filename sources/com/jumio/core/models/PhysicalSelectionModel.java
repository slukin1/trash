package com.jumio.core.models;

import com.jumio.core.data.country.Country;
import com.jumio.core.data.document.DocumentVariant;
import com.jumio.core.data.document.PhysicalDocumentType;
import kotlin.jvm.internal.r;

public final class PhysicalSelectionModel extends SelectionModel {

    /* renamed from: b  reason: collision with root package name */
    public final PhysicalDocumentType f39361b;

    /* renamed from: c  reason: collision with root package name */
    public final DocumentVariant f39362c;

    public PhysicalSelectionModel(Country country, PhysicalDocumentType physicalDocumentType, DocumentVariant documentVariant) {
        super(country, (r) null);
        this.f39361b = physicalDocumentType;
        this.f39362c = documentVariant;
    }

    public final PhysicalDocumentType getPhysicalDocumentType() {
        return this.f39361b;
    }

    public final DocumentVariant getVariant() {
        return this.f39362c;
    }
}
