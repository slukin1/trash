package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {

    /* renamed from: a  reason: collision with root package name */
    public HashSet<ConstraintAnchor> f7078a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7079b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7080c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintWidget f7081d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f7082e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintAnchor f7083f;

    /* renamed from: g  reason: collision with root package name */
    public int f7084g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f7085h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public SolverVariable f7086i;

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7087a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7087a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7087a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintAnchor.a.<clinit>():void");
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f7081d = constraintWidget;
        this.f7082e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i11) {
        return b(constraintAnchor, i11, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i11, int i12, boolean z11) {
        if (constraintAnchor == null) {
            q();
            return true;
        } else if (!z11 && !p(constraintAnchor)) {
            return false;
        } else {
            this.f7083f = constraintAnchor;
            if (constraintAnchor.f7078a == null) {
                constraintAnchor.f7078a = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f7083f.f7078a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f7084g = i11;
            this.f7085h = i12;
            return true;
        }
    }

    public void c(int i11, ArrayList<k> arrayList, k kVar) {
        HashSet<ConstraintAnchor> hashSet = this.f7078a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                Grouping.a(it2.next().f7081d, i11, arrayList, kVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> d() {
        return this.f7078a;
    }

    public int e() {
        if (!this.f7080c) {
            return 0;
        }
        return this.f7079b;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f7081d.T() == 8) {
            return 0;
        }
        if (this.f7085h == Integer.MIN_VALUE || (constraintAnchor = this.f7083f) == null || constraintAnchor.f7081d.T() != 8) {
            return this.f7084g;
        }
        return this.f7085h;
    }

    public final ConstraintAnchor g() {
        switch (a.f7087a[this.f7082e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f7081d.R;
            case 3:
                return this.f7081d.P;
            case 4:
                return this.f7081d.S;
            case 5:
                return this.f7081d.Q;
            default:
                throw new AssertionError(this.f7082e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f7081d;
    }

    public SolverVariable i() {
        return this.f7086i;
    }

    public ConstraintAnchor j() {
        return this.f7083f;
    }

    public Type k() {
        return this.f7082e;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f7078a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (it2.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f7078a;
        if (hashSet != null && hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        return this.f7080c;
    }

    public boolean o() {
        return this.f7083f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        boolean z11 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type k11 = constraintAnchor.k();
        Type type = this.f7082e;
        if (k11 != type) {
            switch (a.f7087a[type.ordinal()]) {
                case 1:
                    if (k11 == Type.BASELINE || k11 == Type.CENTER_X || k11 == Type.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    boolean z12 = k11 == Type.LEFT || k11 == Type.RIGHT;
                    if (!(constraintAnchor.h() instanceof Guideline)) {
                        return z12;
                    }
                    if (z12 || k11 == Type.CENTER_X) {
                        z11 = true;
                    }
                    return z11;
                case 4:
                case 5:
                    boolean z13 = k11 == Type.TOP || k11 == Type.BOTTOM;
                    if (!(constraintAnchor.h() instanceof Guideline)) {
                        return z13;
                    }
                    if (z13 || k11 == Type.CENTER_Y) {
                        z11 = true;
                    }
                    return z11;
                case 6:
                    if (k11 == Type.LEFT || k11 == Type.RIGHT) {
                        return false;
                    }
                    return true;
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f7082e.name());
            }
        } else if (type != Type.BASELINE || (constraintAnchor.h().X() && h().X())) {
            return true;
        } else {
            return false;
        }
    }

    public void q() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f7083f;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.f7078a) == null)) {
            hashSet.remove(this);
            if (this.f7083f.f7078a.size() == 0) {
                this.f7083f.f7078a = null;
            }
        }
        this.f7078a = null;
        this.f7083f = null;
        this.f7084g = 0;
        this.f7085h = Integer.MIN_VALUE;
        this.f7080c = false;
        this.f7079b = 0;
    }

    public void r() {
        this.f7080c = false;
        this.f7079b = 0;
    }

    public void s(Cache cache) {
        SolverVariable solverVariable = this.f7086i;
        if (solverVariable == null) {
            this.f7086i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.f();
        }
    }

    public void t(int i11) {
        this.f7079b = i11;
        this.f7080c = true;
    }

    public String toString() {
        return this.f7081d.u() + ":" + this.f7082e.toString();
    }

    public void u(int i11) {
        if (o()) {
            this.f7085h = i11;
        }
    }
}
