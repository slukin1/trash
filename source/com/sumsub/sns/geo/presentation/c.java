package com.sumsub.sns.geo.presentation;

import android.location.Location;
import android.location.LocationListener;

public final /* synthetic */ class c implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f31307a;

    public /* synthetic */ c(a aVar) {
        this.f31307a = aVar;
    }

    public final void onLocationChanged(Location location) {
        a.b(this.f31307a, location);
    }
}
