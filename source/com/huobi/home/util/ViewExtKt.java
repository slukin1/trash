package com.huobi.home.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.h0;
import d10.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.x;

public final class ViewExtKt {

    public static final class a implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f72561b;

        public a(c cVar) {
            this.f72561b = cVar;
        }

        public void onChildViewAdded(View view, View view2) {
            this.f72561b.a(view2);
        }

        public void onChildViewRemoved(View view, View view2) {
            this.f72561b.a((View) null);
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f72562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f72563c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f72564d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnWindowFocusChangeListener f72565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<ViewTreeObserver.OnScrollChangedListener> f72566f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List<ViewGroup> f72567g;

        public b(View view, int i11, c cVar, ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener, Ref$ObjectRef<ViewTreeObserver.OnScrollChangedListener> ref$ObjectRef, List<? extends ViewGroup> list) {
            this.f72562b = view;
            this.f72563c = i11;
            this.f72564d = cVar;
            this.f72565e = onWindowFocusChangeListener;
            this.f72566f = ref$ObjectRef;
            this.f72567g = list;
        }

        public static final void b(View view, c cVar, ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener, Ref$ObjectRef ref$ObjectRef, List list) {
            try {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(cVar);
            } catch (Exception unused) {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(cVar);
            }
            view.getViewTreeObserver().removeOnWindowFocusChangeListener(onWindowFocusChangeListener);
            if (ref$ObjectRef.element != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener) ref$ObjectRef.element);
            }
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ((ViewGroup) it2.next()).setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener) null);
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.f72562b.post(new d(view, this.f72564d, this.f72565e, this.f72566f, this.f72567g));
            this.f72562b.removeOnAttachStateChangeListener(this);
            this.f72562b.setTag(this.f72563c, Boolean.FALSE);
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public View f72568b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p<View, Boolean, Unit> f72569c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f72570d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f72571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f72572f;

        public c(p<? super View, ? super Boolean, Unit> pVar, View view, int i11, d10.a<Unit> aVar) {
            this.f72569c = pVar;
            this.f72570d = view;
            this.f72571e = i11;
            this.f72572f = aVar;
        }

        public final void a(View view) {
            this.f72568b = view;
        }

        public void onGlobalLayout() {
            if (this.f72568b != null) {
                Rect rect = new Rect();
                View view = this.f72568b;
                if (view != null) {
                    view.getGlobalVisibleRect(rect);
                }
                Rect rect2 = new Rect();
                this.f72570d.getGlobalVisibleRect(rect2);
                if (rect.contains(rect2)) {
                    p<View, Boolean, Unit> pVar = this.f72569c;
                    View view2 = this.f72570d;
                    Boolean bool = Boolean.FALSE;
                    pVar.invoke(view2, bool);
                    this.f72570d.setTag(this.f72571e, bool);
                    return;
                }
                p<View, Boolean, Unit> pVar2 = this.f72569c;
                View view3 = this.f72570d;
                Boolean bool2 = Boolean.TRUE;
                pVar2.invoke(view3, bool2);
                this.f72570d.setTag(this.f72571e, bool2);
                return;
            }
            this.f72572f.invoke();
        }
    }

    public static final void c(View view, List<? extends ViewGroup> list, boolean z11, p<? super View, ? super Boolean, Unit> pVar) {
        if (!x.b(view.getTag(112828121), Boolean.TRUE)) {
            Rect rect = new Rect();
            ViewExtKt$onVisibilityChange$checkVisibility$1 viewExtKt$onVisibilityChange$checkVisibility$1 = new ViewExtKt$onVisibilityChange$checkVisibility$1(view, -208931566, rect, pVar);
            c cVar = new c(pVar, view, -208931566, viewExtKt$onVisibilityChange$checkVisibility$1);
            if (list != null) {
                int i11 = 0;
                for (T next : list) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    ((ViewGroup) next).setOnHierarchyChangeListener(new a(cVar));
                    i11 = i12;
                }
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            if (z11) {
                ref$ObjectRef.element = new a(viewExtKt$onVisibilityChange$checkVisibility$1);
                view.getViewTreeObserver().addOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener) ref$ObjectRef.element);
            }
            b bVar = new b(view, -208931566, rect, pVar);
            view.getViewTreeObserver().addOnWindowFocusChangeListener(bVar);
            view.addOnAttachStateChangeListener(new b(view, 112828121, cVar, bVar, ref$ObjectRef, list));
            view.setTag(112828121, Boolean.TRUE);
        }
    }

    public static final void d(d10.a aVar) {
        aVar.invoke();
    }

    public static final void e(View view, int i11, Rect rect, p pVar, boolean z11) {
        Object tag = view.getTag(i11);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        boolean z12 = f(view, rect) > 0.0f;
        if (z11) {
            if (!x.b(bool, Boolean.valueOf(z12))) {
                pVar.invoke(view, Boolean.valueOf(z12));
                view.setTag(i11, Boolean.valueOf(z12));
            }
        } else if (x.b(bool, Boolean.TRUE)) {
            Boolean bool2 = Boolean.FALSE;
            pVar.invoke(view, bool2);
            view.setTag(i11, bool2);
        }
    }

    public static final float f(View view, Rect rect) {
        boolean localVisibleRect = view.getLocalVisibleRect(rect);
        if (!h0.Z(view) || view.getVisibility() != 0 || !localVisibleRect) {
            return 0.0f;
        }
        return ((float) (rect.width() * rect.height())) / ((float) (view.getWidth() * view.getHeight()));
    }
}
