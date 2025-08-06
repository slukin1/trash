package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class k {

    /* renamed from: g  reason: collision with root package name */
    public static int f7302g;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ConstraintWidget> f7303a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f7304b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7305c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f7306d = 0;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<a> f7307e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f7308f = -1;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<ConstraintWidget> f7309a;

        /* renamed from: b  reason: collision with root package name */
        public int f7310b;

        /* renamed from: c  reason: collision with root package name */
        public int f7311c;

        /* renamed from: d  reason: collision with root package name */
        public int f7312d;

        /* renamed from: e  reason: collision with root package name */
        public int f7313e;

        /* renamed from: f  reason: collision with root package name */
        public int f7314f;

        /* renamed from: g  reason: collision with root package name */
        public int f7315g;

        public a(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i11) {
            this.f7309a = new WeakReference<>(constraintWidget);
            this.f7310b = linearSystem.y(constraintWidget.P);
            this.f7311c = linearSystem.y(constraintWidget.Q);
            this.f7312d = linearSystem.y(constraintWidget.R);
            this.f7313e = linearSystem.y(constraintWidget.S);
            this.f7314f = linearSystem.y(constraintWidget.T);
            this.f7315g = i11;
        }
    }

    public k(int i11) {
        int i12 = f7302g;
        f7302g = i12 + 1;
        this.f7304b = i12;
        this.f7306d = i11;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f7303a.contains(constraintWidget)) {
            return false;
        }
        this.f7303a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<k> arrayList) {
        int size = this.f7303a.size();
        if (this.f7308f != -1 && size > 0) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                k kVar = arrayList.get(i11);
                if (this.f7308f == kVar.f7304b) {
                    g(this.f7306d, kVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f7304b;
    }

    public int d() {
        return this.f7306d;
    }

    public final String e() {
        int i11 = this.f7306d;
        if (i11 == 0) {
            return "Horizontal";
        }
        if (i11 == 1) {
            return "Vertical";
        }
        return i11 == 2 ? "Both" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public int f(LinearSystem linearSystem, int i11) {
        if (this.f7303a.size() == 0) {
            return 0;
        }
        return j(linearSystem, this.f7303a, i11);
    }

    public void g(int i11, k kVar) {
        Iterator<ConstraintWidget> it2 = this.f7303a.iterator();
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            kVar.a(next);
            if (i11 == 0) {
                next.Q0 = kVar.c();
            } else {
                next.R0 = kVar.c();
            }
        }
        this.f7308f = kVar.f7304b;
    }

    public void h(boolean z11) {
        this.f7305c = z11;
    }

    public void i(int i11) {
        this.f7306d = i11;
    }

    public final int j(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i11) {
        int y11;
        int y12;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).L();
        linearSystem.E();
        constraintWidgetContainer.g(linearSystem, false);
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList.get(i12).g(linearSystem, false);
        }
        if (i11 == 0 && constraintWidgetContainer.f7147f1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i11 == 1 && constraintWidgetContainer.f7148g1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.A();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f7307e = new ArrayList<>();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            this.f7307e.add(new a(arrayList.get(i13), linearSystem, i11));
        }
        if (i11 == 0) {
            y11 = linearSystem.y(constraintWidgetContainer.P);
            y12 = linearSystem.y(constraintWidgetContainer.R);
            linearSystem.E();
        } else {
            y11 = linearSystem.y(constraintWidgetContainer.Q);
            y12 = linearSystem.y(constraintWidgetContainer.S);
            linearSystem.E();
        }
        return y12 - y11;
    }

    public String toString() {
        String str = e() + " [" + this.f7304b + "] <";
        Iterator<ConstraintWidget> it2 = this.f7303a.iterator();
        while (it2.hasNext()) {
            str = str + " " + it2.next().u();
        }
        return str + " >";
    }
}
