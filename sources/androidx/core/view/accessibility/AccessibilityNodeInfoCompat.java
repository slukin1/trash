package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {

    /* renamed from: d  reason: collision with root package name */
    public static int f8530d;

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f8531a;

    /* renamed from: b  reason: collision with root package name */
    public int f8532b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f8533c = -1;

    public static class CollectionItemInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Object f8534a;

        public static final class Builder {
        }

        public CollectionItemInfoCompat(Object obj) {
            this.f8534a = obj;
        }

        public static CollectionItemInfoCompat a(int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 21) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, i12, i13, i14, z11, z12));
            }
            if (i15 >= 19) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, i12, i13, i14, z11));
            }
            return new CollectionItemInfoCompat((Object) null);
        }
    }

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;
        public static final a V;

        /* renamed from: e  reason: collision with root package name */
        public static final a f8535e = new a(1, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f8536f = new a(2, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f8537g = new a(4, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f8538h = new a(8, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f8539i = new a(16, (CharSequence) null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f8540j = new a(32, (CharSequence) null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f8541k = new a(64, (CharSequence) null);

        /* renamed from: l  reason: collision with root package name */
        public static final a f8542l = new a(128, (CharSequence) null);

        /* renamed from: m  reason: collision with root package name */
        public static final a f8543m;

        /* renamed from: n  reason: collision with root package name */
        public static final a f8544n;

        /* renamed from: o  reason: collision with root package name */
        public static final a f8545o;

        /* renamed from: p  reason: collision with root package name */
        public static final a f8546p;

        /* renamed from: q  reason: collision with root package name */
        public static final a f8547q = new a(4096, (CharSequence) null);

        /* renamed from: r  reason: collision with root package name */
        public static final a f8548r = new a(8192, (CharSequence) null);

        /* renamed from: s  reason: collision with root package name */
        public static final a f8549s = new a(16384, (CharSequence) null);

        /* renamed from: t  reason: collision with root package name */
        public static final a f8550t = new a(32768, (CharSequence) null);

        /* renamed from: u  reason: collision with root package name */
        public static final a f8551u = new a(65536, (CharSequence) null);

        /* renamed from: v  reason: collision with root package name */
        public static final a f8552v = new a(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);

        /* renamed from: w  reason: collision with root package name */
        public static final a f8553w = new a(262144, (CharSequence) null);

        /* renamed from: x  reason: collision with root package name */
        public static final a f8554x = new a(524288, (CharSequence) null);

        /* renamed from: y  reason: collision with root package name */
        public static final a f8555y = new a(1048576, (CharSequence) null);

        /* renamed from: z  reason: collision with root package name */
        public static final a f8556z = new a(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);

        /* renamed from: a  reason: collision with root package name */
        public final Object f8557a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8558b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<? extends AccessibilityViewCommand.CommandArguments> f8559c;

        /* renamed from: d  reason: collision with root package name */
        public final AccessibilityViewCommand f8560d;

        static {
            Class<AccessibilityViewCommand.MoveHtmlArguments> cls = AccessibilityViewCommand.MoveHtmlArguments.class;
            Class<AccessibilityViewCommand.MoveAtGranularityArguments> cls2 = AccessibilityViewCommand.MoveAtGranularityArguments.class;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            f8543m = new a(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls2);
            f8544n = new a(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls2);
            f8545o = new a(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls);
            f8546p = new a(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls);
            int i11 = Build.VERSION.SDK_INT;
            A = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            B = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            C = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            D = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            E = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            F = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            G = new a(i11 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            H = new a(i11 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            I = new a(i11 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            J = new a(i11 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            K = new a(i11 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            L = new a(i11 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.SetProgressArguments.class);
            M = new a(i11 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.MoveWindowArguments.class);
            N = new a(i11 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            O = new a(i11 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            P = new a(i11 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            Q = new a(i11 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            R = new a(i11 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            S = new a(i11 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            T = new a(i11 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            U = new a(i11 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, 16908376, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 34) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
            }
            V = new a(accessibilityAction, 16908382, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public a(int i11, CharSequence charSequence) {
            this((Object) null, i11, charSequence, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public a a(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new a((Object) null, this.f8558b, charSequence, accessibilityViewCommand, this.f8559c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f8557a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f8557a).getLabel();
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.AccessibilityViewCommand r0 = r4.f8560d
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r2 = r4.f8559c
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments r1 = (androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r1 = r4.f8559c
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                androidx.core.view.accessibility.AccessibilityViewCommand r6 = r4.f8560d
                boolean r5 = r6.perform(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.a.d(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f8557a;
            if (obj2 == null) {
                if (aVar.f8557a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.f8557a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f8557a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AccessibilityActionCompat: ");
            String j11 = AccessibilityNodeInfoCompat.j(this.f8558b);
            if (j11.equals("ACTION_UNKNOWN") && c() != null) {
                j11 = c().toString();
            }
            sb2.append(j11);
            return sb2.toString();
        }

        public a(int i11, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this((Object) null, i11, charSequence, accessibilityViewCommand, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public a(Object obj) {
            this(obj, 0, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public a(int i11, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this((Object) null, i11, charSequence, (AccessibilityViewCommand) null, cls);
        }

        public a(Object obj, int i11, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.f8558b = i11;
            this.f8560d = accessibilityViewCommand;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.f8557a = obj;
            } else {
                this.f8557a = new AccessibilityNodeInfo.AccessibilityAction(i11, charSequence);
            }
            this.f8559c = cls;
        }
    }

    public static class b {
        public static CollectionItemInfoCompat a(int i11, int i12, int i13, int i14, boolean z11) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, i12, i13, i14, z11));
        }

        public static Object b(int i11, float f11, float f12, float f13) {
            return AccessibilityNodeInfo.RangeInfo.obtain(i11, f11, f12, f13);
        }

        public static Bundle c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    public static class c {
        public static Object a(int i11, float f11, float f12, float f13) {
            return new AccessibilityNodeInfo.RangeInfo(i11, f11, f12, f13);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    public static class d {
        public static CollectionItemInfoCompat a(boolean z11, int i11, int i12, int i13, int i14, boolean z12, String str, String str2) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z11).setColumnIndex(i11).setRowIndex(i12).setColumnSpan(i13).setRowSpan(i14).setSelected(z12).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static AccessibilityNodeInfoCompat b(AccessibilityNodeInfo accessibilityNodeInfo, int i11, int i12) {
            return AccessibilityNodeInfoCompat.V0(accessibilityNodeInfo.getChild(i11, i12));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static AccessibilityNodeInfoCompat f(AccessibilityNodeInfo accessibilityNodeInfo, int i11) {
            return AccessibilityNodeInfoCompat.V0(accessibilityNodeInfo.getParent(i11));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z11) {
            accessibilityNodeInfo.setTextSelectable(z11);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    public static class e {
        public static void a(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z11) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z11);
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, long j11) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j11));
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z11) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z11);
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, boolean z11) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z11);
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final Object f8561a;

        public f(Object obj) {
            this.f8561a = obj;
        }

        public static f a(int i11, int i12, boolean z11) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new f(AccessibilityNodeInfo.CollectionInfo.obtain(i11, i12, z11));
            }
            return new f((Object) null);
        }

        public static f b(int i11, int i12, boolean z11, int i13) {
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 21) {
                return new f(AccessibilityNodeInfo.CollectionInfo.obtain(i11, i12, z11, i13));
            }
            if (i14 >= 19) {
                return new f(AccessibilityNodeInfo.CollectionInfo.obtain(i11, i12, z11));
            }
            return new f((Object) null);
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final Object f8562a;

        public g(Object obj) {
            this.f8562a = obj;
        }

        public static g a(int i11, float f11, float f12, float f13) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new g(AccessibilityNodeInfo.RangeInfo.obtain(i11, f11, f12, f13));
            }
            return new g((Object) null);
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.f8531a = (AccessibilityNodeInfo) obj;
    }

    public static AccessibilityNodeInfoCompat U0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public static AccessibilityNodeInfoCompat V0(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public static AccessibilityNodeInfoCompat a0() {
        return U0(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat b0(View view) {
        return U0(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat c0(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return U0(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f8531a));
    }

    public static String j(int i11) {
        if (i11 == 1) {
            return "ACTION_FOCUS";
        }
        if (i11 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i11) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908382:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i11) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i11) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i11) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] r(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public final SparseArray<WeakReference<ClickableSpan>> A(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    public void A0(boolean z11) {
        this.f8531a.setLongClickable(z11);
    }

    public CharSequence B() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            return c.b(this.f8531a);
        }
        if (i11 >= 19) {
            return b.c(this.f8531a).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
        }
        return null;
    }

    public void B0(int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f8531a.setMaxTextLength(i11);
        }
    }

    public CharSequence C() {
        if (!G()) {
            return this.f8531a.getText();
        }
        List<Integer> h11 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> h12 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> h13 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> h14 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f8531a.getText(), 0, this.f8531a.getText().length()));
        for (int i11 = 0; i11 < h11.size(); i11++) {
            spannableString.setSpan(new b1.a(h14.get(i11).intValue(), this, v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), h11.get(i11).intValue(), h12.get(i11).intValue(), h13.get(i11).intValue());
        }
        return spannableString;
    }

    public void C0(int i11) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8531a.setMovementGranularities(i11);
        }
    }

    public CharSequence D() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return this.f8531a.getTooltipText();
        }
        if (i11 >= 19) {
            return b.c(this.f8531a).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
        }
        return null;
    }

    public void D0(CharSequence charSequence) {
        this.f8531a.setPackageName(charSequence);
    }

    public String E() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            return d.g(this.f8531a);
        }
        if (i11 >= 19) {
            return b.c(this.f8531a).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        }
        return null;
    }

    public void E0(CharSequence charSequence) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.f8531a.setPaneTitle(charSequence);
        } else if (i11 >= 19) {
            b.c(this.f8531a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public String F() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f8531a.getViewIdResourceName();
        }
        return null;
    }

    public void F0(View view) {
        this.f8532b = -1;
        this.f8531a.setParent(view);
    }

    public final boolean G() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void G0(View view, int i11) {
        this.f8532b = i11;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8531a.setParent(view, i11);
        }
    }

    public final int H(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i11).get())) {
                    return sparseArray.keyAt(i11);
                }
            }
        }
        int i12 = f8530d;
        f8530d = i12 + 1;
        return i12;
    }

    public void H0(g gVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f8531a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) gVar.f8562a);
        }
    }

    public boolean I() {
        if (Build.VERSION.SDK_INT >= 34) {
            return e.e(this.f8531a);
        }
        return l(64);
    }

    public void I0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            b.c(this.f8531a).putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public boolean J() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f8531a.isAccessibilityFocused();
        }
        return false;
    }

    public void J0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f8531a.setScreenReaderFocusable(z11);
        } else {
            i0(1, z11);
        }
    }

    public boolean K() {
        return this.f8531a.isCheckable();
    }

    public void K0(boolean z11) {
        this.f8531a.setScrollable(z11);
    }

    public boolean L() {
        return this.f8531a.isChecked();
    }

    public void L0(boolean z11) {
        this.f8531a.setSelected(z11);
    }

    public boolean M() {
        return this.f8531a.isClickable();
    }

    public void M0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8531a.setShowingHintText(z11);
        } else {
            i0(4, z11);
        }
    }

    public boolean N() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f8531a.isContextClickable();
        }
        return false;
    }

    public void N0(View view) {
        this.f8533c = -1;
        this.f8531a.setSource(view);
    }

    public boolean O() {
        return this.f8531a.isEnabled();
    }

    public void O0(View view, int i11) {
        this.f8533c = i11;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8531a.setSource(view, i11);
        }
    }

    public boolean P() {
        return this.f8531a.isFocusable();
    }

    public void P0(CharSequence charSequence) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            c.c(this.f8531a, charSequence);
        } else if (i11 >= 19) {
            b.c(this.f8531a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean Q() {
        return this.f8531a.isFocused();
    }

    public void Q0(CharSequence charSequence) {
        this.f8531a.setText(charSequence);
    }

    public boolean R() {
        return l(67108864);
    }

    public void R0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f8531a.setTraversalAfter(view);
        }
    }

    public boolean S() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f8531a.isImportantForAccessibility();
        }
        return true;
    }

    public void S0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8531a.setVisibleToUser(z11);
        }
    }

    public boolean T() {
        return this.f8531a.isLongClickable();
    }

    public AccessibilityNodeInfo T0() {
        return this.f8531a;
    }

    public boolean U() {
        return this.f8531a.isPassword();
    }

    public boolean V() {
        return this.f8531a.isScrollable();
    }

    public boolean W() {
        return this.f8531a.isSelected();
    }

    public boolean X() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f8531a.isShowingHintText();
        }
        return l(4);
    }

    public boolean Y() {
        if (Build.VERSION.SDK_INT >= 33) {
            return d.h(this.f8531a);
        }
        return l(8388608);
    }

    public boolean Z() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f8531a.isVisibleToUser();
        }
        return false;
    }

    public void a(int i11) {
        this.f8531a.addAction(i11);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f8531a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f8557a);
        }
    }

    public void c(View view) {
        this.f8531a.addChild(view);
    }

    public void d(View view, int i11) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8531a.addChild(view, i11);
        }
    }

    public boolean d0(int i11, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f8531a.performAction(i11, bundle);
        }
        return false;
    }

    public final void e(ClickableSpan clickableSpan, Spanned spanned, int i11) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i11));
    }

    @Deprecated
    public void e0() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f8531a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.f8531a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f8531a)) {
            return false;
        }
        return this.f8533c == accessibilityNodeInfoCompat.f8533c && this.f8532b == accessibilityNodeInfoCompat.f8532b;
    }

    public void f(CharSequence charSequence, View view) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19 && i11 < 26) {
            g();
            g0(view);
            ClickableSpan[] r11 = r(charSequence);
            if (r11 != null && r11.length > 0) {
                v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> y11 = y(view);
                for (int i12 = 0; i12 < r11.length; i12++) {
                    int H = H(r11[i12], y11);
                    y11.put(H, new WeakReference(r11[i12]));
                    e(r11[i12], (Spanned) charSequence, H);
                }
            }
        }
    }

    public boolean f0(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f8531a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f8557a);
        }
        return false;
    }

    public final void g() {
        if (Build.VERSION.SDK_INT >= 19) {
            b.c(this.f8531a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            b.c(this.f8531a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            b.c(this.f8531a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            b.c(this.f8531a).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    public final void g0(View view) {
        SparseArray<WeakReference<ClickableSpan>> A = A(view);
        if (A != null) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < A.size(); i11++) {
                if (A.valueAt(i11).get() == null) {
                    arrayList.add(Integer.valueOf(i11));
                }
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                A.remove(((Integer) arrayList.get(i12)).intValue());
            }
        }
    }

    public final List<Integer> h(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = b.c(this.f8531a).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        b.c(this.f8531a).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void h0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f8531a.setAccessibilityFocused(z11);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f8531a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List<a> i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f8531a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new a(actionList.get(i11)));
        }
        return arrayList;
    }

    public final void i0(int i11, boolean z11) {
        Bundle v11 = v();
        if (v11 != null) {
            int i12 = v11.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i11);
            if (!z11) {
                i11 = 0;
            }
            v11.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i11 | i12);
        }
    }

    @Deprecated
    public void j0(Rect rect) {
        this.f8531a.setBoundsInParent(rect);
    }

    @Deprecated
    public int k() {
        return this.f8531a.getActions();
    }

    public void k0(Rect rect) {
        this.f8531a.setBoundsInScreen(rect);
    }

    public final boolean l(int i11) {
        Bundle v11 = v();
        if (v11 != null && (v11.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i11) == i11) {
            return true;
        }
        return false;
    }

    public void l0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f8531a.setCanOpenPopup(z11);
        }
    }

    @Deprecated
    public void m(Rect rect) {
        this.f8531a.getBoundsInParent(rect);
    }

    public void m0(boolean z11) {
        this.f8531a.setCheckable(z11);
    }

    public void n(Rect rect) {
        this.f8531a.getBoundsInScreen(rect);
    }

    public void n0(boolean z11) {
        this.f8531a.setChecked(z11);
    }

    public void o(Rect rect) {
        Rect rect2;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            e.a(this.f8531a, rect);
        } else if (i11 >= 19 && (rect2 = (Rect) b.c(this.f8531a).getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY")) != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void o0(CharSequence charSequence) {
        this.f8531a.setClassName(charSequence);
    }

    public int p() {
        return this.f8531a.getChildCount();
    }

    public void p0(boolean z11) {
        this.f8531a.setClickable(z11);
    }

    public CharSequence q() {
        return this.f8531a.getClassName();
    }

    public void q0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f8531a;
            if (obj == null) {
                collectionInfo = null;
            } else {
                collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((f) obj).f8561a;
            }
            accessibilityNodeInfo.setCollectionInfo(collectionInfo);
        }
    }

    public void r0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f8531a;
            if (obj == null) {
                collectionItemInfo = null;
            } else {
                collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f8534a;
            }
            accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
        }
    }

    public CharSequence s() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            return e.b(this.f8531a);
        }
        if (i11 >= 19) {
            return b.c(this.f8531a).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
        }
        return null;
    }

    public void s0(CharSequence charSequence) {
        this.f8531a.setContentDescription(charSequence);
    }

    public CharSequence t() {
        return this.f8531a.getContentDescription();
    }

    public void t0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f8531a.setDismissable(z11);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb2.append("; boundsInParent: " + rect);
        n(rect);
        sb2.append("; boundsInScreen: " + rect);
        o(rect);
        sb2.append("; boundsInWindow: " + rect);
        sb2.append("; packageName: ");
        sb2.append(z());
        sb2.append("; className: ");
        sb2.append(q());
        sb2.append("; text: ");
        sb2.append(C());
        sb2.append("; error: ");
        sb2.append(u());
        sb2.append("; maxTextLength: ");
        sb2.append(w());
        sb2.append("; stateDescription: ");
        sb2.append(B());
        sb2.append("; contentDescription: ");
        sb2.append(t());
        sb2.append("; tooltipText: ");
        sb2.append(D());
        sb2.append("; viewIdResName: ");
        sb2.append(F());
        sb2.append("; uniqueId: ");
        sb2.append(E());
        sb2.append("; checkable: ");
        sb2.append(K());
        sb2.append("; checked: ");
        sb2.append(L());
        sb2.append("; focusable: ");
        sb2.append(P());
        sb2.append("; focused: ");
        sb2.append(Q());
        sb2.append("; selected: ");
        sb2.append(W());
        sb2.append("; clickable: ");
        sb2.append(M());
        sb2.append("; longClickable: ");
        sb2.append(T());
        sb2.append("; contextClickable: ");
        sb2.append(N());
        sb2.append("; enabled: ");
        sb2.append(O());
        sb2.append("; password: ");
        sb2.append(U());
        sb2.append("; scrollable: " + V());
        sb2.append("; containerTitle: ");
        sb2.append(s());
        sb2.append("; granularScrollingSupported: ");
        sb2.append(R());
        sb2.append("; importantForAccessibility: ");
        sb2.append(S());
        sb2.append("; visible: ");
        sb2.append(Z());
        sb2.append("; isTextSelectable: ");
        sb2.append(Y());
        sb2.append("; accessibilityDataSensitive: ");
        sb2.append(I());
        sb2.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> i11 = i();
            for (int i12 = 0; i12 < i11.size(); i12++) {
                a aVar = i11.get(i12);
                String j11 = j(aVar.b());
                if (j11.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    j11 = aVar.c().toString();
                }
                sb2.append(j11);
                if (i12 != i11.size() - 1) {
                    sb2.append(", ");
                }
            }
        } else {
            int k11 = k();
            while (k11 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(k11);
                k11 &= ~numberOfTrailingZeros;
                sb2.append(j(numberOfTrailingZeros));
                if (k11 != 0) {
                    sb2.append(", ");
                }
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public CharSequence u() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f8531a.getError();
        }
        return null;
    }

    public void u0(boolean z11) {
        this.f8531a.setEnabled(z11);
    }

    public Bundle v() {
        if (Build.VERSION.SDK_INT >= 19) {
            return b.c(this.f8531a);
        }
        return new Bundle();
    }

    public void v0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f8531a.setError(charSequence);
        }
    }

    public int w() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f8531a.getMaxTextLength();
        }
        return -1;
    }

    public void w0(boolean z11) {
        this.f8531a.setFocusable(z11);
    }

    public int x() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f8531a.getMovementGranularities();
        }
        return 0;
    }

    public void x0(boolean z11) {
        this.f8531a.setFocused(z11);
    }

    public final SparseArray<WeakReference<ClickableSpan>> y(View view) {
        SparseArray<WeakReference<ClickableSpan>> A = A(view);
        if (A != null) {
            return A;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void y0(boolean z11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f8531a.setHeading(z11);
        } else {
            i0(2, z11);
        }
    }

    public CharSequence z() {
        return this.f8531a.getPackageName();
    }

    public void z0(CharSequence charSequence) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            this.f8531a.setHintText(charSequence);
        } else if (i11 >= 19) {
            b.c(this.f8531a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f8531a = accessibilityNodeInfo;
    }
}
