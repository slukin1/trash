package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f8622a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    public static Field f8623b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8624c;

    /* renamed from: d  reason: collision with root package name */
    public static Field f8625d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f8626e;

    /* renamed from: f  reason: collision with root package name */
    public static WeakHashMap<View, String> f8627f;

    /* renamed from: g  reason: collision with root package name */
    public static WeakHashMap<View, n0> f8628g = null;

    /* renamed from: h  reason: collision with root package name */
    public static Field f8629h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f8630i = false;

    /* renamed from: j  reason: collision with root package name */
    public static ThreadLocal<Rect> f8631j;

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f8632k = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* renamed from: l  reason: collision with root package name */
    public static final x f8633l = g0.f8619b;

    /* renamed from: m  reason: collision with root package name */
    public static final e f8634m = new e();

    public class a extends f<Boolean> {
        public a(int i11, Class cls, int i12) {
            super(i11, cls, i12);
        }

        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(q.d(view));
        }

        /* renamed from: j */
        public void e(View view, Boolean bool) {
            q.j(view, bool.booleanValue());
        }

        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class b extends f<CharSequence> {
        public b(int i11, Class cls, int i12, int i13) {
            super(i11, cls, i12, i13);
        }

        /* renamed from: i */
        public CharSequence d(View view) {
            return q.b(view);
        }

        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            q.h(view, charSequence);
        }

        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class c extends f<CharSequence> {
        public c(int i11, Class cls, int i12, int i13) {
            super(i11, cls, i12, i13);
        }

        /* renamed from: i */
        public CharSequence d(View view) {
            return s.b(view);
        }

        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            s.e(view, charSequence);
        }

        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends f<Boolean> {
        public d(int i11, Class cls, int i12) {
            super(i11, cls, i12);
        }

        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(q.c(view));
        }

        /* renamed from: j */
        public void e(View view, Boolean bool) {
            q.g(view, bool.booleanValue());
        }

        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f8635b = new WeakHashMap<>();

        public void a(View view) {
            this.f8635b.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                c(view);
            }
        }

        public final void b(View view, boolean z11) {
            boolean z12 = view.isShown() && view.getWindowVisibility() == 0;
            if (z11 != z12) {
                h0.f0(view, z12 ? 16 : 32);
                this.f8635b.put(view, Boolean.valueOf(z12));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f8635b.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.f8635b.entrySet()) {
                    b((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f8636a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f8637b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8638c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8639d;

        public f(int i11, Class<T> cls, int i12) {
            this(i11, cls, 0, i12);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            if ((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue())) {
                return true;
            }
            return false;
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        public final boolean c() {
            return Build.VERSION.SDK_INT >= this.f8638c;
        }

        public abstract T d(View view);

        public abstract void e(View view, T t11);

        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.f8636a);
            if (this.f8637b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void g(View view, T t11) {
            if (c()) {
                e(view, t11);
            } else if (b() && h(f(view), t11)) {
                h0.m(view);
                view.setTag(this.f8636a, t11);
                h0.f0(view, this.f8639d);
            }
        }

        public abstract boolean h(T t11, T t12);

        public f(int i11, Class<T> cls, int i12, int i13) {
            this.f8636a = i11;
            this.f8637b = cls;
            this.f8639d = i12;
            this.f8638c = i13;
        }
    }

    public static class g {
        public static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    public static class h {
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        public static int d(View view) {
            return view.getMinimumHeight();
        }

        public static int e(View view) {
            return view.getMinimumWidth();
        }

        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        public static boolean i(View view) {
            return view.hasTransientState();
        }

        public static boolean j(View view, int i11, Bundle bundle) {
            return view.performAccessibilityAction(i11, bundle);
        }

        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        public static void l(View view, int i11, int i12, int i13, int i14) {
            view.postInvalidateOnAnimation(i11, i12, i13, i14);
        }

        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void n(View view, Runnable runnable, long j11) {
            view.postOnAnimationDelayed(runnable, j11);
        }

        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void r(View view, boolean z11) {
            view.setHasTransientState(z11);
        }

        public static void s(View view, int i11) {
            view.setImportantForAccessibility(i11);
        }
    }

    public static class i {
        public static int a() {
            return View.generateViewId();
        }

        public static Display b(View view) {
            return view.getDisplay();
        }

        public static int c(View view) {
            return view.getLabelFor();
        }

        public static int d(View view) {
            return view.getLayoutDirection();
        }

        public static int e(View view) {
            return view.getPaddingEnd();
        }

        public static int f(View view) {
            return view.getPaddingStart();
        }

        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        public static void h(View view, int i11) {
            view.setLabelFor(i11);
        }

        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void j(View view, int i11) {
            view.setLayoutDirection(i11);
        }

        public static void k(View view, int i11, int i12, int i13, int i14) {
            view.setPaddingRelative(i11, i12, i13, i14);
        }
    }

    public static class j {
        public static Rect a(View view) {
            return view.getClipBounds();
        }

        public static boolean b(View view) {
            return view.isInLayout();
        }

        public static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    public static class k {
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean c(View view) {
            return view.isLaidOut();
        }

        public static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void e(ViewParent viewParent, View view, View view2, int i11) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i11);
        }

        public static void f(View view, int i11) {
            view.setAccessibilityLiveRegion(i11);
        }

        public static void g(AccessibilityEvent accessibilityEvent, int i11) {
            accessibilityEvent.setContentChangeTypes(i11);
        }
    }

    public static class l {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    public static class m {

        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            public WindowInsetsCompat f8640a = null;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f8641b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ v f8642c;

            public a(View view, v vVar) {
                this.f8641b = view;
                this.f8642c = vVar;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsetsCompat y11 = WindowInsetsCompat.y(windowInsets, view);
                int i11 = Build.VERSION.SDK_INT;
                if (i11 < 30) {
                    m.a(windowInsets, this.f8641b);
                    if (y11.equals(this.f8640a)) {
                        return this.f8642c.onApplyWindowInsets(view, y11).w();
                    }
                }
                this.f8640a = y11;
                WindowInsetsCompat onApplyWindowInsets = this.f8642c.onApplyWindowInsets(view, y11);
                if (i11 >= 30) {
                    return onApplyWindowInsets.w();
                }
                h0.u0(view);
                return onApplyWindowInsets.w();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets w11 = windowInsetsCompat.w();
            if (w11 != null) {
                return WindowInsetsCompat.y(view.computeSystemWindowInsets(w11, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static boolean c(View view, float f11, float f12, boolean z11) {
            return view.dispatchNestedFling(f11, f12, z11);
        }

        public static boolean d(View view, float f11, float f12) {
            return view.dispatchNestedPreFling(f11, f12);
        }

        public static boolean e(View view, int i11, int i12, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i11, i12, iArr, iArr2);
        }

        public static boolean f(View view, int i11, int i12, int i13, int i14, int[] iArr) {
            return view.dispatchNestedScroll(i11, i12, i13, i14, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat j(View view) {
            return WindowInsetsCompat.a.a(view);
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f11) {
            view.setElevation(f11);
        }

        public static void t(View view, boolean z11) {
            view.setNestedScrollingEnabled(z11);
        }

        public static void u(View view, v vVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, vVar);
            }
            if (vVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, vVar));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f11) {
            view.setTranslationZ(f11);
        }

        public static void x(View view, float f11) {
            view.setZ(f11);
        }

        public static boolean y(View view, int i11) {
            return view.startNestedScroll(i11);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    public static class n {
        public static WindowInsetsCompat a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat x11 = WindowInsetsCompat.x(rootWindowInsets);
            x11.u(x11);
            x11.d(view.getRootView());
            return x11;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i11) {
            view.setScrollIndicators(i11);
        }

        public static void d(View view, int i11, int i12) {
            view.setScrollIndicators(i11, i12);
        }
    }

    public static class o {
        public static void a(View view) {
            view.cancelDragAndDrop();
        }

        public static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        public static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        public static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        public static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i11) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i11);
        }

        public static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    public static class p {
        public static void a(View view, Collection<View> collection, int i11) {
            view.addKeyboardNavigationClusters(collection, i11);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        public static int c(View view) {
            return view.getImportantForAutofill();
        }

        public static int d(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View i(View view, View view2, int i11) {
            return view.keyboardNavigationClusterSearch(view2, i11);
        }

        public static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        public static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void l(View view, boolean z11) {
            view.setFocusedByDefault(z11);
        }

        public static void m(View view, int i11) {
            view.setImportantForAutofill(i11);
        }

        public static void n(View view, boolean z11) {
            view.setKeyboardNavigationCluster(z11);
        }

        public static void o(View view, int i11) {
            view.setNextClusterForwardId(i11);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static class q {
        public static void a(View view, v vVar) {
            int i11 = R$id.tag_unhandled_key_listeners;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i11);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i11, simpleArrayMap);
            }
            Objects.requireNonNull(vVar);
            i0 i0Var = new i0(vVar);
            simpleArrayMap.put(vVar, i0Var);
            view.addOnUnhandledKeyEventListener(i0Var);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, v vVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R$id.tag_unhandled_key_listeners);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(vVar)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        public static <T> T f(View view, int i11) {
            return view.requireViewById(i11);
        }

        public static void g(View view, boolean z11) {
            view.setAccessibilityHeading(z11);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AutofillId autofillId) {
            view.setAutofillId(autofillId);
        }

        public static void j(View view, boolean z11) {
            view.setScreenReaderFocusable(z11);
        }
    }

    public static class r {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i11, int i12) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i11, i12);
        }

        public static void e(View view, ContentCaptureSession contentCaptureSession) {
            view.setContentCaptureSession(contentCaptureSession);
        }

        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static class s {
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static boolean c(View view) {
            return view.isImportantForContentCapture();
        }

        public static void d(View view, int i11) {
            view.setImportantForContentCapture(i11);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public static final class t {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static b b(View view, b bVar) {
            ContentInfo f11 = bVar.f();
            ContentInfo performReceiveContent = view.performReceiveContent(f11);
            if (performReceiveContent == null) {
                return null;
            }
            if (performReceiveContent == f11) {
                return bVar;
            }
            return b.g(performReceiveContent);
        }

        public static void c(View view, String[] strArr, w wVar) {
            if (wVar == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new u(wVar));
            }
        }
    }

    public static final class u implements OnReceiveContentListener {

        /* renamed from: a  reason: collision with root package name */
        public final w f8643a;

        public u(w wVar) {
            this.f8643a = wVar;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            b g11 = b.g(contentInfo);
            b a11 = this.f8643a.a(view, g11);
            if (a11 == null) {
                return null;
            }
            if (a11 == g11) {
                return contentInfo;
            }
            return a11.f();
        }
    }

    public interface v {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    public static class w {

        /* renamed from: d  reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f8644d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap<View, Boolean> f8645a = null;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<WeakReference<View>> f8646b = null;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<KeyEvent> f8647c = null;

        public static w a(View view) {
            int i11 = R$id.tag_unhandled_key_event_manager;
            w wVar = (w) view.getTag(i11);
            if (wVar != null) {
                return wVar;
            }
            w wVar2 = new w();
            view.setTag(i11, wVar2);
            return wVar2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c11 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c11 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c11));
                }
            }
            return c11 != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f8645a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c11 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c11 != null) {
                            return c11;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray<WeakReference<View>> d() {
            if (this.f8646b == null) {
                this.f8646b = new SparseArray<>();
            }
            return this.f8646b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((v) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f8647c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f8647c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> d11 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d11.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d11.valueAt(indexOfKey);
                d11.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d11.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && h0.Z(view)) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f8645a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f8644d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f8645a == null) {
                        this.f8645a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f8644d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f8645a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f8645a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Rect A() {
        if (f8631j == null) {
            f8631j = new ThreadLocal<>();
        }
        Rect rect = f8631j.get();
        if (rect == null) {
            rect = new Rect();
            f8631j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void A0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            k0().g(view, charSequence);
            if (charSequence != null) {
                f8634m.a(view);
            } else {
                f8634m.d(view);
            }
        }
    }

    public static x B(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        return f8633l;
    }

    public static void B0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.q(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static boolean C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.b(view);
        }
        return false;
    }

    public static void C0(View view, ColorStateList colorStateList) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            m.q(view, colorStateList);
            if (i11 == 21) {
                Drawable background = view.getBackground();
                boolean z11 = (m.g(view) == null && m.h(view) == null) ? false : true;
                if (background != null && z11) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    h.q(view, background);
                }
            }
        } else if (view instanceof e0) {
            ((e0) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.c(view);
        }
        return 0;
    }

    public static void D0(View view, PorterDuff.Mode mode) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            m.r(view, mode);
            if (i11 == 21) {
                Drawable background = view.getBackground();
                boolean z11 = (m.g(view) == null && m.h(view) == null) ? false : true;
                if (background != null && z11) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    h.q(view, background);
                }
            }
        } else if (view instanceof e0) {
            ((e0) view).setSupportBackgroundTintMode(mode);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int E(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.c(view);
        }
        return 0;
    }

    public static void E0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            j.c(view, rect);
        }
    }

    public static int F(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.d(view);
        }
        return 0;
    }

    public static void F0(View view, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.s(view, f11);
        }
    }

    public static int G(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.d(view);
        }
        if (!f8626e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f8625d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f8626e = true;
        }
        Field field = f8625d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    @Deprecated
    public static void G0(View view, boolean z11) {
        view.setFitsSystemWindows(z11);
    }

    public static int H(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.e(view);
        }
        if (!f8624c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f8623b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f8624c = true;
        }
        Field field = f8623b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void H0(View view, boolean z11) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.r(view, z11);
        }
    }

    public static String[] I(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return t.a(view);
        }
        return (String[]) view.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static void I0(View view, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 19) {
            h.s(view, i11);
        } else if (i12 >= 16) {
            if (i11 == 4) {
                i11 = 2;
            }
            h.s(view, i11);
        }
    }

    @Deprecated
    public static int J(View view) {
        return view.getOverScrollMode();
    }

    public static void J0(View view) {
        if (D(view) == 0) {
            I0(view, 1);
        }
    }

    public static int K(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.e(view);
        }
        return view.getPaddingRight();
    }

    public static void K0(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.m(view, i11);
        }
    }

    public static int L(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.f(view);
        }
        return view.getPaddingLeft();
    }

    public static void L0(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            i.i(view, paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static ViewParent M(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.f(view);
        }
        return view.getParent();
    }

    @Deprecated
    public static void M0(View view, int i11, Paint paint) {
        view.setLayerType(i11, paint);
    }

    public static WindowInsetsCompat N(View view) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return n.a(view);
        }
        if (i11 >= 21) {
            return m.j(view);
        }
        return null;
    }

    public static void N0(View view, boolean z11) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.t(view, z11);
        } else if (view instanceof p) {
            ((p) view).setNestedScrollingEnabled(z11);
        }
    }

    public static CharSequence O(View view) {
        return X0().f(view);
    }

    public static void O0(View view, v vVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.u(view, vVar);
        }
    }

    public static String P(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.k(view);
        }
        WeakHashMap<View, String> weakHashMap = f8627f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static void P0(View view, int i11, int i12, int i13, int i14) {
        if (Build.VERSION.SDK_INT >= 17) {
            i.k(view, i11, i12, i13, i14);
        } else {
            view.setPadding(i11, i12, i13, i14);
        }
    }

    @Deprecated
    public static float Q(View view) {
        return view.getTranslationX();
    }

    public static void Q0(View view, z zVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.d(view, (PointerIcon) (zVar != null ? zVar.a() : null));
        }
    }

    @Deprecated
    public static float R(View view) {
        return view.getTranslationY();
    }

    public static void R0(View view, boolean z11) {
        w0().g(view, Boolean.valueOf(z11));
    }

    public static float S(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.l(view);
        }
        return 0.0f;
    }

    public static void S0(View view, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 23) {
            n.d(view, i11, i12);
        }
    }

    @Deprecated
    public static int T(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.g(view);
        }
        return 0;
    }

    public static void T0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            X0().g(view, charSequence);
        }
    }

    public static float U(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.m(view);
        }
        return 0.0f;
    }

    public static void U0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.v(view, str);
            return;
        }
        if (f8627f == null) {
            f8627f = new WeakHashMap<>();
        }
        f8627f.put(view, str);
    }

    public static boolean V(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return g.a(view);
        }
        return false;
    }

    public static void V0(View view, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.w(view, f11);
        }
    }

    public static boolean W(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.h(view);
        }
        return true;
    }

    public static void W0(View view, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.x(view, f11);
        }
    }

    public static boolean X(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.i(view);
        }
        return false;
    }

    public static f<CharSequence> X0() {
        return new c(R$id.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean Y(View view) {
        Boolean f11 = b().f(view);
        return f11 != null && f11.booleanValue();
    }

    public static void Y0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.z(view);
        } else if (view instanceof p) {
            ((p) view).stopNestedScroll();
        }
    }

    public static boolean Z(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.b(view);
        }
        return view.getWindowToken() != null;
    }

    public static void Z0(View view, int i11) {
        if (view instanceof o) {
            ((o) view).stopNestedScroll(i11);
        } else if (i11 == 0) {
            Y0(view);
        }
    }

    public static boolean a0(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.c(view);
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static void a1(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static f<Boolean> b() {
        return new d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static boolean b0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.p(view);
        }
        if (view instanceof p) {
            return ((p) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static int c(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int u11 = u(view, charSequence);
        if (u11 != -1) {
            d(view, new AccessibilityNodeInfoCompat.a(u11, charSequence, accessibilityViewCommand));
        }
        return u11;
    }

    public static boolean c0(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.g(view);
        }
        return false;
    }

    public static void d(View view, AccessibilityNodeInfoCompat.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m(view);
            s0(aVar.b(), view);
            t(view).add(aVar);
            f0(view, 0);
        }
    }

    public static boolean d0(View view) {
        Boolean f11 = w0().f(view);
        return f11 != null && f11.booleanValue();
    }

    public static n0 e(View view) {
        if (f8628g == null) {
            f8628g = new WeakHashMap<>();
        }
        n0 n0Var = f8628g.get(view);
        if (n0Var != null) {
            return n0Var;
        }
        n0 n0Var2 = new n0(view);
        f8628g.put(view, n0Var2);
        return n0Var2;
    }

    public static /* synthetic */ b e0(b bVar) {
        return bVar;
    }

    @Deprecated
    public static boolean f(View view, int i11) {
        return view.canScrollHorizontally(i11);
    }

    public static void f0(View view, int i11) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z11 = s(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            int i12 = 32;
            if (r(view) != 0 || z11) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z11) {
                    i12 = 2048;
                }
                obtain.setEventType(i12);
                k.g(obtain, i11);
                if (z11) {
                    obtain.getText().add(s(view));
                    J0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i11 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                k.g(obtain2, i11);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(s(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i11);
                } catch (AbstractMethodError e11) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e11);
                }
            }
        }
    }

    public static void g(View view, int i11) {
        view.offsetLeftAndRight(i11);
        if (view.getVisibility() == 0) {
            a1(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                a1((View) parent);
            }
        }
    }

    public static void g0(View view, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 23) {
            view.offsetLeftAndRight(i11);
        } else if (i12 >= 21) {
            Rect A = A();
            boolean z11 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                A.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z11 = !A.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            g(view, i11);
            if (z11 && A.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(A);
            }
        } else {
            g(view, i11);
        }
    }

    public static void h(View view, int i11) {
        view.offsetTopAndBottom(i11);
        if (view.getVisibility() == 0) {
            a1(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                a1((View) parent);
            }
        }
    }

    public static void h0(View view, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 23) {
            view.offsetTopAndBottom(i11);
        } else if (i12 >= 21) {
            Rect A = A();
            boolean z11 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                A.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z11 = !A.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            h(view, i11);
            if (z11 && A.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(A);
            }
        } else {
            h(view, i11);
        }
    }

    public static WindowInsetsCompat i(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? m.b(view, windowInsetsCompat, rect) : windowInsetsCompat;
    }

    public static WindowInsetsCompat i0(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets w11;
        if (Build.VERSION.SDK_INT >= 21 && (w11 = windowInsetsCompat.w()) != null) {
            WindowInsets b11 = l.b(view, w11);
            if (!b11.equals(w11)) {
                return WindowInsetsCompat.y(b11, view);
            }
        }
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat j(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets w11;
        if (Build.VERSION.SDK_INT >= 21 && (w11 = windowInsetsCompat.w()) != null) {
            WindowInsets a11 = l.a(view, w11);
            if (!a11.equals(w11)) {
                return WindowInsetsCompat.y(a11, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void j0(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.T0());
    }

    public static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return w.a(view).b(view, keyEvent);
    }

    public static f<CharSequence> k0() {
        return new b(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static boolean l(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return w.a(view).f(keyEvent);
    }

    public static boolean l0(View view, int i11, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.j(view, i11, bundle);
        }
        return false;
    }

    public static void m(View view) {
        AccessibilityDelegateCompat o11 = o(view);
        if (o11 == null) {
            o11 = new AccessibilityDelegateCompat();
        }
        x0(view, o11);
    }

    public static b m0(View view, b bVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + bVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return t.b(view, bVar);
        }
        w wVar = (w) view.getTag(R$id.tag_on_receive_content_listener);
        if (wVar == null) {
            return B(view).onReceiveContent(bVar);
        }
        b a11 = wVar.a(view, bVar);
        if (a11 == null) {
            return null;
        }
        return B(view).onReceiveContent(a11);
    }

    public static int n() {
        AtomicInteger atomicInteger;
        int i11;
        int i12;
        if (Build.VERSION.SDK_INT >= 17) {
            return i.a();
        }
        do {
            atomicInteger = f8622a;
            i11 = atomicInteger.get();
            i12 = i11 + 1;
            if (i12 > 16777215) {
                i12 = 1;
            }
        } while (!atomicInteger.compareAndSet(i11, i12));
        return i11;
    }

    public static void n0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.k(view);
        } else {
            view.postInvalidate();
        }
    }

    public static AccessibilityDelegateCompat o(View view) {
        View.AccessibilityDelegate p11 = p(view);
        if (p11 == null) {
            return null;
        }
        if (p11 instanceof AccessibilityDelegateCompat.a) {
            return ((AccessibilityDelegateCompat.a) p11).f8485a;
        }
        return new AccessibilityDelegateCompat(p11);
    }

    public static void o0(View view, int i11, int i12, int i13, int i14) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.l(view, i11, i12, i13, i14);
        } else {
            view.postInvalidate(i11, i12, i13, i14);
        }
    }

    public static View.AccessibilityDelegate p(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return r.a(view);
        }
        return q(view);
    }

    public static void p0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.m(view, runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static View.AccessibilityDelegate q(View view) {
        if (f8630i) {
            return null;
        }
        if (f8629h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f8629h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f8630i = true;
                return null;
            }
        }
        try {
            Object obj = f8629h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f8630i = true;
            return null;
        }
    }

    @SuppressLint({"LambdaLast"})
    public static void q0(View view, Runnable runnable, long j11) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.n(view, runnable, j11);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j11);
        }
    }

    public static int r(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.a(view);
        }
        return 0;
    }

    public static void r0(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            s0(i11, view);
            f0(view, 0);
        }
    }

    public static CharSequence s(View view) {
        return k0().f(view);
    }

    public static void s0(int i11, View view) {
        List<AccessibilityNodeInfoCompat.a> t11 = t(view);
        for (int i12 = 0; i12 < t11.size(); i12++) {
            if (t11.get(i12).b() == i11) {
                t11.remove(i12);
                return;
            }
        }
    }

    public static List<AccessibilityNodeInfoCompat.a> t(View view) {
        int i11 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i11);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i11, arrayList2);
        return arrayList2;
    }

    public static void t0(View view, AccessibilityNodeInfoCompat.a aVar, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            r0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, accessibilityViewCommand));
        }
    }

    public static int u(View view, CharSequence charSequence) {
        List<AccessibilityNodeInfoCompat.a> t11 = t(view);
        for (int i11 = 0; i11 < t11.size(); i11++) {
            if (TextUtils.equals(charSequence, t11.get(i11).c())) {
                return t11.get(i11).b();
            }
        }
        int i12 = -1;
        int i13 = 0;
        while (true) {
            int[] iArr = f8632k;
            if (i13 >= iArr.length || i12 != -1) {
                return i12;
            }
            int i14 = iArr[i13];
            boolean z11 = true;
            for (int i15 = 0; i15 < t11.size(); i15++) {
                z11 &= t11.get(i15).b() != i14;
            }
            if (z11) {
                i12 = i14;
            }
            i13++;
        }
        return i12;
    }

    public static void u0(View view) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            l.c(view);
        } else if (i11 >= 16) {
            h.p(view);
        }
    }

    public static ColorStateList v(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.g(view);
        }
        if (view instanceof e0) {
            return ((e0) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void v0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.d(view, context, iArr, attributeSet, typedArray, i11, i12);
        }
    }

    public static PorterDuff.Mode w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.h(view);
        }
        if (view instanceof e0) {
            return ((e0) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static f<Boolean> w0() {
        return new a(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static Rect x(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return j.a(view);
        }
        return null;
    }

    public static void x0(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (accessibilityDelegateCompat == null && (p(view) instanceof AccessibilityDelegateCompat.a)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        J0(view);
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = accessibilityDelegateCompat.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static Display y(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.b(view);
        }
        if (Z(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void y0(View view, boolean z11) {
        b().g(view, Boolean.valueOf(z11));
    }

    public static float z(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.i(view);
        }
        return 0.0f;
    }

    public static void z0(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 19) {
            k.f(view, i11);
        }
    }
}
