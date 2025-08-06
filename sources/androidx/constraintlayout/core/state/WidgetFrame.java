package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.a;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;
import java.util.Set;

public class WidgetFrame {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidget f7058a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7059b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7060c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f7061d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7062e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f7063f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public float f7064g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    public float f7065h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    public float f7066i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    public float f7067j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f7068k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f7069l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7070m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f7071n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f7072o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f7073p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f7074q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    public int f7075r = 0;

    /* renamed from: s  reason: collision with root package name */
    public final HashMap<String, a> f7076s = new HashMap<>();

    /* renamed from: t  reason: collision with root package name */
    public String f7077t = null;

    public WidgetFrame() {
    }

    public a a(String str) {
        return this.f7076s.get(str);
    }

    public Set<String> b() {
        return this.f7076s.keySet();
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.f7058a = constraintWidget;
    }
}
