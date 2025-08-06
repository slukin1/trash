package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.state.WidgetFrame;
import java.util.Set;

public class MotionWidget {

    /* renamed from: a  reason: collision with root package name */
    public WidgetFrame f6703a = new WidgetFrame();

    /* renamed from: b  reason: collision with root package name */
    public Motion f6704b = new Motion();

    /* renamed from: c  reason: collision with root package name */
    public PropertySet f6705c = new PropertySet();

    public static class Motion {

        /* renamed from: a  reason: collision with root package name */
        public int f6706a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f6707b = 0;

        /* renamed from: c  reason: collision with root package name */
        public String f6708c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f6709d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f6710e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f6711f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public int f6712g = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f6713h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f6714i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public int f6715j = -1;

        /* renamed from: k  reason: collision with root package name */
        public String f6716k = null;

        /* renamed from: l  reason: collision with root package name */
        public int f6717l = -3;

        /* renamed from: m  reason: collision with root package name */
        public int f6718m = -1;
    }

    public static class PropertySet {

        /* renamed from: a  reason: collision with root package name */
        public int f6719a = 4;

        /* renamed from: b  reason: collision with root package name */
        public int f6720b = 0;

        /* renamed from: c  reason: collision with root package name */
        public float f6721c = 1.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f6722d = Float.NaN;
    }

    public MotionWidget() {
    }

    public float a() {
        return this.f6705c.f6721c;
    }

    public a b(String str) {
        return this.f6703a.a(str);
    }

    public Set<String> c() {
        return this.f6703a.b();
    }

    public int d() {
        WidgetFrame widgetFrame = this.f6703a;
        return widgetFrame.f7062e - widgetFrame.f7060c;
    }

    public int e() {
        return this.f6703a.f7059b;
    }

    public float f() {
        return this.f6703a.f7063f;
    }

    public float g() {
        return this.f6703a.f7064g;
    }

    public float h() {
        return this.f6703a.f7065h;
    }

    public float i() {
        return this.f6703a.f7066i;
    }

    public float j() {
        return this.f6703a.f7067j;
    }

    public float k() {
        return this.f6703a.f7071n;
    }

    public float l() {
        return this.f6703a.f7072o;
    }

    public int m() {
        return this.f6703a.f7060c;
    }

    public float n() {
        return this.f6703a.f7068k;
    }

    public float o() {
        return this.f6703a.f7069l;
    }

    public float p() {
        return this.f6703a.f7070m;
    }

    public int q() {
        return this.f6705c.f6719a;
    }

    public int r() {
        WidgetFrame widgetFrame = this.f6703a;
        return widgetFrame.f7061d - widgetFrame.f7059b;
    }

    public int s() {
        return this.f6703a.f7059b;
    }

    public int t() {
        return this.f6703a.f7060c;
    }

    public String toString() {
        return this.f6703a.f7059b + ", " + this.f6703a.f7060c + ", " + this.f6703a.f7061d + ", " + this.f6703a.f7062e;
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.f6703a = widgetFrame;
    }
}
