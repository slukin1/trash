package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class i0 implements h0 {

    /* renamed from: a  reason: collision with root package name */
    public final SensorManager f34614a;

    public static final class a extends Lambda implements d10.a<List<? extends g0>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i0 f34615a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i0 i0Var) {
            super(0);
            this.f34615a = i0Var;
        }

        /* renamed from: a */
        public final List<g0> invoke() {
            List<Sensor> sensorList;
            SensorManager a11 = this.f34615a.f34614a;
            if (a11 == null || (sensorList = a11.getSensorList(-1)) == null) {
                return CollectionsKt__CollectionsKt.k();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(sensorList, 10));
            for (Sensor sensor : sensorList) {
                arrayList.add(new g0(sensor.getName(), sensor.getVendor()));
            }
            return arrayList;
        }
    }

    public i0(SensorManager sensorManager) {
        this.f34614a = sensorManager;
    }

    public List<g0> a() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }
}
