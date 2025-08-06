package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimingInfoFullSupport extends TimingInfo {

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, List<TimingInfo>> f15564d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Number> f15565e = new HashMap();

    public TimingInfoFullSupport(Long l11, long j11, Long l12) {
        super(l11, j11, l12);
    }

    public void a(String str, TimingInfo timingInfo) {
        List list = this.f15564d.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f15564d.put(str, list);
        }
        if (timingInfo.k()) {
            list.add(timingInfo);
            return;
        }
        Log b11 = LogFactory.b(getClass());
        b11.h("Skip submeasurement timing info with no end time for " + str);
    }

    public Map<String, Number> d() {
        return this.f15565e;
    }

    public Map<String, List<TimingInfo>> g() {
        return this.f15564d;
    }

    public void j(String str) {
        Number q11 = q(str);
        l(str, (long) ((q11 != null ? q11.intValue() : 0) + 1));
    }

    public void l(String str, long j11) {
        this.f15565e.put(str, Long.valueOf(j11));
    }

    public Number q(String str) {
        return this.f15565e.get(str);
    }
}
