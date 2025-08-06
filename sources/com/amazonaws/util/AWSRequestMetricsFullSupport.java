package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {

    /* renamed from: d  reason: collision with root package name */
    public static final Log f15534d = LogFactory.c("com.amazonaws.latency");

    /* renamed from: e  reason: collision with root package name */
    public static final Object f15535e = ContainerUtils.KEY_VALUE_DELIMITER;

    /* renamed from: f  reason: collision with root package name */
    public static final Object f15536f = ", ";

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<Object>> f15537b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, TimingInfo> f15538c = new HashMap();

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.n());
    }

    public void a(MetricType metricType, Object obj) {
        h(metricType.name(), obj);
    }

    public void b(MetricType metricType) {
        i(metricType.name());
    }

    public void d(MetricType metricType) {
        j(metricType.name());
    }

    public void e() {
        if (f15534d.a()) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.f15537b.entrySet()) {
                k(next.getKey(), next.getValue(), sb2);
            }
            for (Map.Entry next2 : this.f15533a.d().entrySet()) {
                k(next2.getKey(), next2.getValue(), sb2);
            }
            for (Map.Entry next3 : this.f15533a.g().entrySet()) {
                k(next3.getKey(), next3.getValue(), sb2);
            }
            f15534d.j(sb2.toString());
        }
    }

    public void f(MetricType metricType, long j11) {
        l(metricType.name(), j11);
    }

    public void g(MetricType metricType) {
        m(metricType.name());
    }

    public void h(String str, Object obj) {
        List list = this.f15537b.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f15537b.put(str, list);
        }
        list.add(obj);
    }

    public void i(String str) {
        TimingInfo timingInfo = this.f15538c.get(str);
        if (timingInfo == null) {
            Log b11 = LogFactory.b(getClass());
            b11.g("Trying to end an event which was never started: " + str);
            return;
        }
        timingInfo.c();
        this.f15533a.a(str, TimingInfo.p(timingInfo.f(), Long.valueOf(timingInfo.e())));
    }

    public void j(String str) {
        this.f15533a.j(str);
    }

    public final void k(Object obj, Object obj2, StringBuilder sb2) {
        sb2.append(obj);
        sb2.append(f15535e);
        sb2.append(obj2);
        sb2.append(f15536f);
    }

    public void l(String str, long j11) {
        this.f15533a.l(str, j11);
    }

    public void m(String str) {
        this.f15538c.put(str, TimingInfo.o(System.nanoTime()));
    }
}
