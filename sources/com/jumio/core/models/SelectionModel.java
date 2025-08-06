package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.country.Country;
import com.jumio.core.model.StaticModel;
import kotlin.jvm.internal.r;

@PersistWith("SelectionModel")
public abstract class SelectionModel implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public final Country f39372a;

    public SelectionModel(Country country) {
        this.f39372a = country;
    }

    public /* synthetic */ SelectionModel(Country country, r rVar) {
        this(country);
    }

    public final Country getCountry() {
        return this.f39372a;
    }
}
