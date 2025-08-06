package com.sumsub.sns.geo.presentation;

import android.location.Location;
import android.location.LocationListener;

public final /* synthetic */ class b implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f31306a;

    public /* synthetic */ b(a aVar) {
        this.f31306a = aVar;
    }

    public final void onLocationChanged(Location location) {
        a.a(this.f31306a, location);
    }
}
