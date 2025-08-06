package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;

@PersistWith("ExtractionModeModel")
public final class ExtractionModeModel implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39307a = true;

    public final boolean getDocFinderEnabled() {
        return this.f39307a;
    }

    public final void setDocFinderEnabled(boolean z11) {
        this.f39307a = z11;
    }
}
