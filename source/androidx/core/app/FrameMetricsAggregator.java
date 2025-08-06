package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FrameMetricsAggregator {

    /* renamed from: a  reason: collision with root package name */
    public final b f8141a;

    public static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public int f8142a;

        /* renamed from: b  reason: collision with root package name */
        public SparseIntArray[] f8143b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<WeakReference<Activity>> f8144c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public Window.OnFrameMetricsAvailableListener f8145d = new C0019a();

        /* renamed from: androidx.core.app.FrameMetricsAggregator$a$a  reason: collision with other inner class name */
        public class C0019a implements Window.OnFrameMetricsAvailableListener {
            public C0019a() {
            }

            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i11) {
                a aVar = a.this;
                if ((aVar.f8142a & 1) != 0) {
                    aVar.a(aVar.f8143b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f8142a & 2) != 0) {
                    aVar2.a(aVar2.f8143b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f8142a & 4) != 0) {
                    aVar3.a(aVar3.f8143b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f8142a & 8) != 0) {
                    aVar4.a(aVar4.f8143b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f8142a & 16) != 0) {
                    aVar5.a(aVar5.f8143b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f8142a & 64) != 0) {
                    aVar6.a(aVar6.f8143b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f8142a & 32) != 0) {
                    aVar7.a(aVar7.f8143b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f8142a & 128) != 0) {
                    aVar8.a(aVar8.f8143b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f8142a & 256) != 0) {
                    aVar9.a(aVar9.f8143b[8], frameMetrics.getMetric(2));
                }
            }
        }

        public a(int i11) {
            this.f8142a = i11;
        }

        public void a(SparseIntArray sparseIntArray, long j11) {
            if (sparseIntArray != null) {
                int i11 = (int) ((500000 + j11) / 1000000);
                if (j11 >= 0) {
                    sparseIntArray.put(i11, sparseIntArray.get(i11) + 1);
                }
            }
        }
    }

    public static class b {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f8141a = new a(i11);
        } else {
            this.f8141a = new b();
        }
    }
}
