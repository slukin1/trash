package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.h0;
import androidx.core.view.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
public abstract class FragmentTransitionImpl {

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f9650b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9651c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9652d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f9654f;

        public a(int i11, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f9650b = i11;
            this.f9651c = arrayList;
            this.f9652d = arrayList2;
            this.f9653e = arrayList3;
            this.f9654f = arrayList4;
        }

        public void run() {
            for (int i11 = 0; i11 < this.f9650b; i11++) {
                h0.U0((View) this.f9651c.get(i11), (String) this.f9652d.get(i11));
                h0.U0((View) this.f9653e.get(i11), (String) this.f9654f.get(i11));
            }
        }
    }

    public static void d(List<View> list, View view) {
        int size = list.size();
        if (!g(list, view, size)) {
            if (h0.P(view) != null) {
                list.add(view);
            }
            for (int i11 = size; i11 < list.size(); i11++) {
                View view2 = list.get(i11);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i12 = 0; i12 < childCount; i12++) {
                        View childAt = viewGroup.getChildAt(i12);
                        if (!g(list, childAt, size) && h0.P(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static boolean g(List<View> list, View view, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (list.get(i12) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    public void h(View view, Rect rect) {
        if (h0.Z(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    public ArrayList<String> l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = arrayList.get(i11);
            arrayList2.add(h0.P(view));
            h0.U0(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view, ArrayList<View> arrayList);

    public abstract void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void o(Object obj, Rect rect);

    public abstract void p(Object obj, View view);

    public void q(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        runnable.run();
    }

    public void r(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i11 = 0; i11 < size; i11++) {
            View view2 = arrayList.get(i11);
            String P = h0.P(view2);
            arrayList4.add(P);
            if (P != null) {
                h0.U0(view2, (String) null);
                String str = map.get(P);
                int i12 = 0;
                while (true) {
                    if (i12 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i12))) {
                        h0.U0(arrayList2.get(i12), P);
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        y.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void s(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object u(Object obj);
}
