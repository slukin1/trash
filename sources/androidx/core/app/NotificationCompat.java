package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.R$color;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$layout;
import androidx.core.R$string;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.view.roundimg.RoundedDrawable;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p0.k;
import p0.q;

public class NotificationCompat {

    public static class Action {

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f8175a;

        /* renamed from: b  reason: collision with root package name */
        public IconCompat f8176b;

        /* renamed from: c  reason: collision with root package name */
        public final q[] f8177c;

        /* renamed from: d  reason: collision with root package name */
        public final q[] f8178d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8179e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8180f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8181g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f8182h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f8183i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f8184j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f8185k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f8186l;

        public static final class WearableExtender {

            /* renamed from: a  reason: collision with root package name */
            public int f8187a = 1;

            /* renamed from: b  reason: collision with root package name */
            public CharSequence f8188b;

            /* renamed from: c  reason: collision with root package name */
            public CharSequence f8189c;

            /* renamed from: d  reason: collision with root package name */
            public CharSequence f8190d;

            /* renamed from: a */
            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f8187a = this.f8187a;
                wearableExtender.f8188b = this.f8188b;
                wearableExtender.f8189c = this.f8189c;
                wearableExtender.f8190d = this.f8190d;
                return wearableExtender;
            }
        }

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final IconCompat f8191a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f8192b;

            /* renamed from: c  reason: collision with root package name */
            public final PendingIntent f8193c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f8194d;

            /* renamed from: e  reason: collision with root package name */
            public final Bundle f8195e;

            /* renamed from: f  reason: collision with root package name */
            public ArrayList<q> f8196f;

            /* renamed from: g  reason: collision with root package name */
            public int f8197g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f8198h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f8199i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f8200j;

            /* renamed from: androidx.core.app.NotificationCompat$Action$a$a  reason: collision with other inner class name */
            public static class C0020a {
                public static Bundle a(Notification.Action action) {
                    return action.getExtras();
                }

                public static RemoteInput[] b(Notification.Action action) {
                    return action.getRemoteInputs();
                }
            }

            public static class b {
                public static Icon a(Notification.Action action) {
                    return action.getIcon();
                }
            }

            public static class c {
                public static boolean a(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            public static class d {
                public static int a(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            public static class e {
                public static boolean a(Notification.Action action) {
                    return action.isContextual();
                }
            }

            public static class f {
                public static boolean a(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }

            public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), (q[]) null, true, 0, true, false, false);
            }

            public static a e(Notification.Action action) {
                a aVar;
                RemoteInput[] b11;
                int i11 = Build.VERSION.SDK_INT;
                if (i11 < 23 || b.a(action) == null) {
                    aVar = new a(action.icon, action.title, action.actionIntent);
                } else {
                    aVar = new a(IconCompat.d(b.a(action)), action.title, action.actionIntent);
                }
                if (!(i11 < 20 || (b11 = C0020a.b(action)) == null || b11.length == 0)) {
                    for (RemoteInput c11 : b11) {
                        aVar.b(q.c(c11));
                    }
                }
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 24) {
                    aVar.f8194d = c.a(action);
                }
                if (i12 >= 28) {
                    aVar.h(d.a(action));
                }
                if (i12 >= 29) {
                    aVar.g(e.a(action));
                }
                if (i12 >= 31) {
                    aVar.f(f.a(action));
                }
                if (i12 >= 20) {
                    aVar.a(C0020a.a(action));
                }
                return aVar;
            }

            public a a(Bundle bundle) {
                if (bundle != null) {
                    this.f8195e.putAll(bundle);
                }
                return this;
            }

            public a b(q qVar) {
                if (this.f8196f == null) {
                    this.f8196f = new ArrayList<>();
                }
                if (qVar != null) {
                    this.f8196f.add(qVar);
                }
                return this;
            }

            /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.core.app.NotificationCompat.Action c() {
                /*
                    r17 = this;
                    r0 = r17
                    r17.d()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.ArrayList<p0.q> r3 = r0.f8196f
                    if (r3 == 0) goto L_0x0031
                    java.util.Iterator r3 = r3.iterator()
                L_0x0017:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x0031
                    java.lang.Object r4 = r3.next()
                    p0.q r4 = (p0.q) r4
                    boolean r5 = r4.k()
                    if (r5 == 0) goto L_0x002d
                    r1.add(r4)
                    goto L_0x0017
                L_0x002d:
                    r2.add(r4)
                    goto L_0x0017
                L_0x0031:
                    boolean r3 = r1.isEmpty()
                    r4 = 0
                    if (r3 == 0) goto L_0x003a
                    r11 = r4
                    goto L_0x0047
                L_0x003a:
                    int r3 = r1.size()
                    p0.q[] r3 = new p0.q[r3]
                    java.lang.Object[] r1 = r1.toArray(r3)
                    p0.q[] r1 = (p0.q[]) r1
                    r11 = r1
                L_0x0047:
                    boolean r1 = r2.isEmpty()
                    if (r1 == 0) goto L_0x004e
                    goto L_0x005b
                L_0x004e:
                    int r1 = r2.size()
                    p0.q[] r1 = new p0.q[r1]
                    java.lang.Object[] r1 = r2.toArray(r1)
                    r4 = r1
                    p0.q[] r4 = (p0.q[]) r4
                L_0x005b:
                    r10 = r4
                    androidx.core.app.NotificationCompat$Action r1 = new androidx.core.app.NotificationCompat$Action
                    androidx.core.graphics.drawable.IconCompat r6 = r0.f8191a
                    java.lang.CharSequence r7 = r0.f8192b
                    android.app.PendingIntent r8 = r0.f8193c
                    android.os.Bundle r9 = r0.f8195e
                    boolean r12 = r0.f8194d
                    int r13 = r0.f8197g
                    boolean r14 = r0.f8198h
                    boolean r15 = r0.f8199i
                    boolean r2 = r0.f8200j
                    r5 = r1
                    r16 = r2
                    r5.<init>((androidx.core.graphics.drawable.IconCompat) r6, (java.lang.CharSequence) r7, (android.app.PendingIntent) r8, (android.os.Bundle) r9, (p0.q[]) r10, (p0.q[]) r11, (boolean) r12, (int) r13, (boolean) r14, (boolean) r15, (boolean) r16)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Action.a.c():androidx.core.app.NotificationCompat$Action");
            }

            public final void d() {
                if (this.f8199i) {
                    Objects.requireNonNull(this.f8193c, "Contextual Actions must contain a valid PendingIntent");
                }
            }

            public a f(boolean z11) {
                this.f8200j = z11;
                return this;
            }

            public a g(boolean z11) {
                this.f8199i = z11;
                return this;
            }

            public a h(int i11) {
                this.f8197g = i11;
                return this;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public a(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i11 != 0 ? IconCompat.l((Resources) null, "", i11) : null, charSequence, pendingIntent, new Bundle(), (q[]) null, true, 0, true, false, false);
            }

            public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, q[] qVarArr, boolean z11, int i11, boolean z12, boolean z13, boolean z14) {
                ArrayList<q> arrayList;
                this.f8194d = true;
                this.f8198h = true;
                this.f8191a = iconCompat;
                this.f8192b = e.p(charSequence);
                this.f8193c = pendingIntent;
                this.f8195e = bundle;
                if (qVarArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(qVarArr));
                }
                this.f8196f = arrayList;
                this.f8194d = z11;
                this.f8197g = i11;
                this.f8198h = z12;
                this.f8199i = z13;
                this.f8200j = z14;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i11 != 0 ? IconCompat.l((Resources) null, "", i11) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f8185k;
        }

        public boolean b() {
            return this.f8179e;
        }

        public q[] c() {
            return this.f8178d;
        }

        public Bundle d() {
            return this.f8175a;
        }

        @Deprecated
        public int e() {
            return this.f8183i;
        }

        public IconCompat f() {
            int i11;
            if (this.f8176b == null && (i11 = this.f8183i) != 0) {
                this.f8176b = IconCompat.l((Resources) null, "", i11);
            }
            return this.f8176b;
        }

        public q[] g() {
            return this.f8177c;
        }

        public int h() {
            return this.f8181g;
        }

        public boolean i() {
            return this.f8180f;
        }

        public CharSequence j() {
            return this.f8184j;
        }

        public boolean k() {
            return this.f8186l;
        }

        public boolean l() {
            return this.f8182h;
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (q[]) null, (q[]) null, true, 0, true, false, false);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i11, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, q[] qVarArr, q[] qVarArr2, boolean z11, int i12, boolean z12, boolean z13, boolean z14) {
            this(i11 != 0 ? IconCompat.l((Resources) null, "", i11) : null, charSequence, pendingIntent, bundle, qVarArr, qVarArr2, z11, i12, z12, z13, z14);
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, q[] qVarArr, q[] qVarArr2, boolean z11, int i11, boolean z12, boolean z13, boolean z14) {
            this.f8180f = true;
            this.f8176b = iconCompat;
            if (iconCompat != null && iconCompat.q() == 2) {
                this.f8183i = iconCompat.n();
            }
            this.f8184j = e.p(charSequence);
            this.f8185k = pendingIntent;
            this.f8175a = bundle == null ? new Bundle() : bundle;
            this.f8177c = qVarArr;
            this.f8178d = qVarArr2;
            this.f8179e = z11;
            this.f8181g = i11;
            this.f8180f = z12;
            this.f8182h = z13;
            this.f8186l = z14;
        }
    }

    public static class BigPictureStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        public IconCompat f8201e;

        /* renamed from: f  reason: collision with root package name */
        public IconCompat f8202f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8203g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f8204h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f8205i;

        public static class a {
            public static Notification.BigPictureStyle a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                return bigPictureStyle.bigPicture(bitmap);
            }

            public static Notification.BigPictureStyle b(Notification.Builder builder) {
                return new Notification.BigPictureStyle(builder);
            }

            public static Notification.BigPictureStyle c(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                return bigPictureStyle.setBigContentTitle(charSequence);
            }

            public static void d(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            public static void e(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        public static class b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        public static class c {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z11) {
                bigPictureStyle.showBigPictureWhenCollapsed(z11);
            }
        }

        public static IconCompat B(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("android.picture");
            if (parcelable != null) {
                return y(parcelable);
            }
            return y(bundle.getParcelable("android.pictureIcon"));
        }

        public static IconCompat y(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 23 && (parcelable instanceof Icon)) {
                return IconCompat.c((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.h((Bitmap) parcelable);
            }
            return null;
        }

        public BigPictureStyle A(Bitmap bitmap) {
            this.f8201e = bitmap == null ? null : IconCompat.h(bitmap);
            return this;
        }

        public BigPictureStyle C(CharSequence charSequence) {
            this.f8234b = e.p(charSequence);
            return this;
        }

        public BigPictureStyle D(CharSequence charSequence) {
            this.f8235c = e.p(charSequence);
            this.f8236d = true;
            return this;
        }

        public void b(k kVar) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 16) {
                Notification.BigPictureStyle c11 = a.c(a.b(kVar.a()), this.f8234b);
                IconCompat iconCompat = this.f8201e;
                Context context = null;
                if (iconCompat != null) {
                    if (i11 >= 31) {
                        c.a(c11, this.f8201e.z(kVar instanceof a ? ((a) kVar).f() : null));
                    } else if (iconCompat.q() == 1) {
                        c11 = a.a(c11, this.f8201e.m());
                    }
                }
                if (this.f8203g) {
                    IconCompat iconCompat2 = this.f8202f;
                    if (iconCompat2 == null) {
                        a.d(c11, (Bitmap) null);
                    } else if (i11 >= 23) {
                        if (kVar instanceof a) {
                            context = ((a) kVar).f();
                        }
                        b.a(c11, this.f8202f.z(context));
                    } else if (iconCompat2.q() == 1) {
                        a.d(c11, this.f8202f.m());
                    } else {
                        a.d(c11, (Bitmap) null);
                    }
                }
                if (this.f8236d) {
                    a.e(c11, this.f8235c);
                }
                if (i11 >= 31) {
                    c.c(c11, this.f8205i);
                    c.b(c11, this.f8204h);
                }
            }
        }

        public void f(Bundle bundle) {
            super.f(bundle);
            bundle.remove("android.largeIcon.big");
            bundle.remove("android.picture");
            bundle.remove("android.pictureIcon");
            bundle.remove("android.showBigPictureWhenCollapsed");
        }

        public String r() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public void w(Bundle bundle) {
            super.w(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f8202f = y(bundle.getParcelable("android.largeIcon.big"));
                this.f8203g = true;
            }
            this.f8201e = B(bundle);
            this.f8205i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public BigPictureStyle z(Bitmap bitmap) {
            this.f8202f = bitmap == null ? null : IconCompat.h(bitmap);
            this.f8203g = true;
            return this;
        }
    }

    public static class BigTextStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f8206e;

        public static class a {
            public static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            public static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            public static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            public static Notification.BigTextStyle d(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }
        }

        public BigTextStyle A(CharSequence charSequence) {
            this.f8235c = e.p(charSequence);
            this.f8236d = true;
            return this;
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f8206e);
            }
        }

        public void b(k kVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle a11 = a.a(a.c(a.b(kVar.a()), this.f8234b), this.f8206e);
                if (this.f8236d) {
                    a.d(a11, this.f8235c);
                }
            }
        }

        public void f(Bundle bundle) {
            super.f(bundle);
            bundle.remove("android.bigText");
        }

        public String r() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public void w(Bundle bundle) {
            super.w(bundle);
            this.f8206e = bundle.getCharSequence("android.bigText");
        }

        public BigTextStyle y(CharSequence charSequence) {
            this.f8206e = e.p(charSequence);
            return this;
        }

        public BigTextStyle z(CharSequence charSequence) {
            this.f8234b = e.p(charSequence);
            return this;
        }
    }

    public static final class BubbleMetadata {

        /* renamed from: a  reason: collision with root package name */
        public PendingIntent f8207a;

        /* renamed from: b  reason: collision with root package name */
        public PendingIntent f8208b;

        /* renamed from: c  reason: collision with root package name */
        public IconCompat f8209c;

        /* renamed from: d  reason: collision with root package name */
        public int f8210d;

        /* renamed from: e  reason: collision with root package name */
        public int f8211e;

        /* renamed from: f  reason: collision with root package name */
        public int f8212f;

        /* renamed from: g  reason: collision with root package name */
        public String f8213g;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public PendingIntent f8214a;

            /* renamed from: b  reason: collision with root package name */
            public IconCompat f8215b;

            /* renamed from: c  reason: collision with root package name */
            public int f8216c;

            /* renamed from: d  reason: collision with root package name */
            public int f8217d;

            /* renamed from: e  reason: collision with root package name */
            public int f8218e;

            /* renamed from: f  reason: collision with root package name */
            public PendingIntent f8219f;

            /* renamed from: g  reason: collision with root package name */
            public String f8220g;

            @Deprecated
            public Builder() {
            }

            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata a() {
                String str = this.f8220g;
                if (str == null) {
                    Objects.requireNonNull(this.f8214a, "Must supply pending intent or shortcut to bubble");
                }
                if (str == null) {
                    Objects.requireNonNull(this.f8215b, "Must supply an icon or shortcut for the bubble");
                }
                BubbleMetadata bubbleMetadata = new BubbleMetadata(this.f8214a, this.f8219f, this.f8215b, this.f8216c, this.f8217d, this.f8218e, str);
                bubbleMetadata.j(this.f8218e);
                return bubbleMetadata;
            }

            public Builder b(boolean z11) {
                f(1, z11);
                return this;
            }

            public Builder c(PendingIntent pendingIntent) {
                this.f8219f = pendingIntent;
                return this;
            }

            public Builder d(int i11) {
                this.f8216c = Math.max(i11, 0);
                this.f8217d = 0;
                return this;
            }

            public Builder e(int i11) {
                this.f8217d = i11;
                this.f8216c = 0;
                return this;
            }

            public final Builder f(int i11, boolean z11) {
                if (z11) {
                    this.f8218e = i11 | this.f8218e;
                } else {
                    this.f8218e = (~i11) & this.f8218e;
                }
                return this;
            }

            public Builder g(boolean z11) {
                f(2, z11);
                return this;
            }

            public Builder(String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.f8220g = str;
                    return;
                }
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            public Builder(PendingIntent pendingIntent, IconCompat iconCompat) {
                Objects.requireNonNull(pendingIntent, "Bubble requires non-null pending intent");
                Objects.requireNonNull(iconCompat, "Bubbles require non-null icon");
                this.f8214a = pendingIntent;
                this.f8215b = iconCompat;
            }
        }

        public static class a {
            public static BubbleMetadata a(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Builder g11 = new Builder(bubbleMetadata.getIntent(), IconCompat.c(bubbleMetadata.getIcon())).b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).g(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    g11.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    g11.e(bubbleMetadata.getDesiredHeightResId());
                }
                return g11.a();
            }

            public static Notification.BubbleMetadata b(BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.g() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.f().y()).setIntent(bubbleMetadata.g()).setDeleteIntent(bubbleMetadata.c()).setAutoExpandBubble(bubbleMetadata.b()).setSuppressNotification(bubbleMetadata.i());
                if (bubbleMetadata.d() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.d());
                }
                if (bubbleMetadata.e() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.e());
                }
                return suppressNotification.build();
            }
        }

        public static class b {
            public static BubbleMetadata a(Notification.BubbleMetadata bubbleMetadata) {
                Builder builder;
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.getShortcutId() != null) {
                    builder = new Builder(bubbleMetadata.getShortcutId());
                } else {
                    builder = new Builder(bubbleMetadata.getIntent(), IconCompat.c(bubbleMetadata.getIcon()));
                }
                builder.b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).g(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.e(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.a();
            }

            public static Notification.BubbleMetadata b(BubbleMetadata bubbleMetadata) {
                Notification.BubbleMetadata.Builder builder;
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.h() != null) {
                    builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.h());
                } else {
                    builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.g(), bubbleMetadata.f().y());
                }
                builder.setDeleteIntent(bubbleMetadata.c()).setAutoExpandBubble(bubbleMetadata.b()).setSuppressNotification(bubbleMetadata.i());
                if (bubbleMetadata.d() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.d());
                }
                if (bubbleMetadata.e() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.e());
                }
                return builder.build();
            }
        }

        public static BubbleMetadata a(Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                return b.a(bubbleMetadata);
            }
            if (i11 == 29) {
                return a.a(bubbleMetadata);
            }
            return null;
        }

        public static Notification.BubbleMetadata k(BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                return b.b(bubbleMetadata);
            }
            if (i11 == 29) {
                return a.b(bubbleMetadata);
            }
            return null;
        }

        public boolean b() {
            return (this.f8212f & 1) != 0;
        }

        public PendingIntent c() {
            return this.f8208b;
        }

        public int d() {
            return this.f8210d;
        }

        public int e() {
            return this.f8211e;
        }

        @SuppressLint({"InvalidNullConversion"})
        public IconCompat f() {
            return this.f8209c;
        }

        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent g() {
            return this.f8207a;
        }

        public String h() {
            return this.f8213g;
        }

        public boolean i() {
            return (this.f8212f & 2) != 0;
        }

        public void j(int i11) {
            this.f8212f = i11;
        }

        public BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i11, int i12, int i13, String str) {
            this.f8207a = pendingIntent;
            this.f8209c = iconCompat;
            this.f8210d = i11;
            this.f8211e = i12;
            this.f8208b = pendingIntent2;
            this.f8212f = i13;
            this.f8213g = str;
        }
    }

    public static class CallStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        public int f8221e;

        /* renamed from: f  reason: collision with root package name */
        public Person f8222f;

        /* renamed from: g  reason: collision with root package name */
        public PendingIntent f8223g;

        /* renamed from: h  reason: collision with root package name */
        public PendingIntent f8224h;

        /* renamed from: i  reason: collision with root package name */
        public PendingIntent f8225i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f8226j;

        /* renamed from: k  reason: collision with root package name */
        public Integer f8227k;

        /* renamed from: l  reason: collision with root package name */
        public Integer f8228l;

        /* renamed from: m  reason: collision with root package name */
        public IconCompat f8229m;

        /* renamed from: n  reason: collision with root package name */
        public CharSequence f8230n;

        public static class a {
            public static void a(Notification.CallStyle callStyle, Notification.Builder builder) {
                callStyle.setBuilder(builder);
            }
        }

        public static class b {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        public static class c {
            public static Parcelable a(Icon icon) {
                return icon;
            }

            public static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            public static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        public static class d {
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            public static Parcelable b(Person person) {
                return person;
            }
        }

        public static class e {
            public static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i11) {
                return callStyle.setAnswerButtonColorHint(i11);
            }

            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z11) {
                return builder.setAuthenticationRequired(z11);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, int i11) {
                return callStyle.setDeclineButtonColorHint(i11);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z11) {
                return callStyle.setIsVideo(z11);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle i(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        public final boolean A(Action action) {
            return action != null && action.d().getBoolean("key_action_priority");
        }

        public final Action B(int i11, int i12, Integer num, int i13, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(ContextCompat.getColor(this.f8233a.f8252a, i13));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(this.f8233a.f8252a.getResources().getString(i12));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            Action c11 = new Action.a(IconCompat.k(this.f8233a.f8252a, i11), (CharSequence) spannableStringBuilder, pendingIntent).c();
            c11.d().putBoolean("key_action_priority", true);
            return c11;
        }

        public final Action C() {
            int i11;
            int i12 = R$drawable.ic_call_answer_video_low;
            int i13 = R$drawable.ic_call_answer_low;
            if (Build.VERSION.SDK_INT >= 21) {
                i12 = R$drawable.ic_call_answer_video;
                i13 = R$drawable.ic_call_answer;
            }
            PendingIntent pendingIntent = this.f8223g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z11 = this.f8226j;
            int i14 = z11 ? i12 : i13;
            if (z11) {
                i11 = R$string.call_notification_answer_video_action;
            } else {
                i11 = R$string.call_notification_answer_action;
            }
            return B(i14, i11, this.f8227k, R$color.call_notification_answer_color, pendingIntent);
        }

        public final Action D() {
            int i11 = R$drawable.ic_call_decline_low;
            if (Build.VERSION.SDK_INT >= 21) {
                i11 = R$drawable.ic_call_decline;
            }
            int i12 = i11;
            PendingIntent pendingIntent = this.f8224h;
            if (pendingIntent == null) {
                return B(i12, R$string.call_notification_hang_up_action, this.f8228l, R$color.call_notification_decline_color, this.f8225i);
            }
            return B(i12, R$string.call_notification_decline_action, this.f8228l, R$color.call_notification_decline_color, pendingIntent);
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt("android.callType", this.f8221e);
            bundle.putBoolean("android.callIsVideo", this.f8226j);
            Person person = this.f8222f;
            if (person != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", d.b(person.j()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", person.k());
                }
            }
            IconCompat iconCompat = this.f8229m;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    bundle.putParcelable("android.verificationIcon", c.a(iconCompat.z(this.f8233a.f8252a)));
                } else {
                    bundle.putParcelable("android.verificationIconCompat", iconCompat.x());
                }
            }
            bundle.putCharSequence("android.verificationText", this.f8230n);
            bundle.putParcelable("android.answerIntent", this.f8223g);
            bundle.putParcelable("android.declineIntent", this.f8224h);
            bundle.putParcelable("android.hangUpIntent", this.f8225i);
            Integer num = this.f8227k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f8228l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        public void b(k kVar) {
            int i11 = Build.VERSION.SDK_INT;
            Notification.CallStyle callStyle = null;
            if (i11 >= 31) {
                int i12 = this.f8221e;
                if (i12 == 1) {
                    callStyle = e.a(this.f8222f.j(), this.f8224h, this.f8223g);
                } else if (i12 == 2) {
                    callStyle = e.b(this.f8222f.j(), this.f8225i);
                } else if (i12 == 3) {
                    callStyle = e.c(this.f8222f.j(), this.f8225i, this.f8223g);
                } else if (Log.isLoggable("NotifCompat", 3)) {
                    Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f8221e));
                }
                if (callStyle != null) {
                    a.a(callStyle, kVar.a());
                    Integer num = this.f8227k;
                    if (num != null) {
                        e.d(callStyle, num.intValue());
                    }
                    Integer num2 = this.f8228l;
                    if (num2 != null) {
                        e.f(callStyle, num2.intValue());
                    }
                    e.i(callStyle, this.f8230n);
                    IconCompat iconCompat = this.f8229m;
                    if (iconCompat != null) {
                        e.h(callStyle, iconCompat.z(this.f8233a.f8252a));
                    }
                    e.g(callStyle, this.f8226j);
                    return;
                }
                return;
            }
            Notification.Builder a11 = kVar.a();
            Person person = this.f8222f;
            a11.setContentTitle(person != null ? person.e() : null);
            Bundle bundle = this.f8233a.E;
            if (bundle != null && bundle.containsKey("android.text")) {
                callStyle = this.f8233a.E.getCharSequence("android.text");
            }
            if (callStyle == null) {
                callStyle = z();
            }
            a11.setContentText(callStyle);
            Person person2 = this.f8222f;
            if (person2 != null) {
                if (i11 >= 23 && person2.c() != null) {
                    c.c(a11, this.f8222f.c().z(this.f8233a.f8252a));
                }
                if (i11 >= 28) {
                    d.a(a11, this.f8222f.j());
                } else if (i11 >= 21) {
                    b.a(a11, this.f8222f.f());
                }
            }
            if (i11 >= 21) {
                b.b(a11, TUIConstants.TUICalling.METHOD_NAME_CALL);
            }
        }

        public String r() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public void w(Bundle bundle) {
            super.w(bundle);
            this.f8221e = bundle.getInt("android.callType");
            this.f8226j = bundle.getBoolean("android.callIsVideo");
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28 && bundle.containsKey("android.callPerson")) {
                this.f8222f = Person.a((Person) bundle.getParcelable("android.callPerson"));
            } else if (bundle.containsKey("android.callPersonCompat")) {
                this.f8222f = Person.b(bundle.getBundle("android.callPersonCompat"));
            }
            if (i11 >= 23 && bundle.containsKey("android.verificationIcon")) {
                this.f8229m = IconCompat.c((Icon) bundle.getParcelable("android.verificationIcon"));
            } else if (bundle.containsKey("android.verificationIconCompat")) {
                this.f8229m = IconCompat.b(bundle.getBundle("android.verificationIconCompat"));
            }
            this.f8230n = bundle.getCharSequence("android.verificationText");
            this.f8223g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.f8224h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.f8225i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            Integer num = null;
            this.f8227k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
            if (bundle.containsKey("android.declineColor")) {
                num = Integer.valueOf(bundle.getInt("android.declineColor"));
            }
            this.f8228l = num;
        }

        public ArrayList<Action> y() {
            Action D = D();
            Action C = C();
            ArrayList<Action> arrayList = new ArrayList<>(3);
            arrayList.add(D);
            int i11 = 2;
            ArrayList<Action> arrayList2 = this.f8233a.f8253b;
            if (arrayList2 != null) {
                for (Action next : arrayList2) {
                    if (next.l()) {
                        arrayList.add(next);
                    } else if (!A(next) && i11 > 1) {
                        arrayList.add(next);
                        i11--;
                    }
                    if (C != null && i11 == 1) {
                        arrayList.add(C);
                        i11--;
                    }
                }
            }
            if (C != null && i11 >= 1) {
                arrayList.add(C);
            }
            return arrayList;
        }

        public final String z() {
            int i11 = this.f8221e;
            if (i11 == 1) {
                return this.f8233a.f8252a.getResources().getString(R$string.call_notification_incoming_text);
            }
            if (i11 == 2) {
                return this.f8233a.f8252a.getResources().getString(R$string.call_notification_ongoing_text);
            }
            if (i11 != 3) {
                return null;
            }
            return this.f8233a.f8252a.getResources().getString(R$string.call_notification_screening_text);
        }
    }

    public static final class CarExtender {

        /* renamed from: a  reason: collision with root package name */
        public int f8231a = 0;
    }

    public static class DecoratedCustomViewStyle extends Style {

        public static class a {
            public static void a(RemoteViews remoteViews, int i11, CharSequence charSequence) {
                remoteViews.setContentDescription(i11, charSequence);
            }
        }

        public static class b {
            public static Notification.Builder a(Notification.Builder builder, Object obj) {
                return builder.setStyle((Notification.Style) obj);
            }
        }

        public static class c {
            public static Notification.DecoratedCustomViewStyle a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        public static List<Action> A(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action next : list) {
                if (!next.l()) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        public void b(k kVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                b.a(kVar.a(), c.a());
            }
        }

        public String r() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        public RemoteViews t(k kVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews h11 = this.f8233a.h();
            if (h11 == null) {
                h11 = this.f8233a.j();
            }
            if (h11 == null) {
                return null;
            }
            return y(h11, true);
        }

        public RemoteViews u(k kVar) {
            if (Build.VERSION.SDK_INT < 24 && this.f8233a.j() != null) {
                return y(this.f8233a.j(), false);
            }
            return null;
        }

        public RemoteViews v(k kVar) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews m11 = this.f8233a.m();
            if (m11 != null) {
                remoteViews = m11;
            } else {
                remoteViews = this.f8233a.j();
            }
            if (m11 == null) {
                return null;
            }
            return y(remoteViews, true);
        }

        public final RemoteViews y(RemoteViews remoteViews, boolean z11) {
            int min;
            boolean z12 = true;
            int i11 = 0;
            RemoteViews c11 = c(true, R$layout.notification_template_custom_big, false);
            c11.removeAllViews(R$id.actions);
            List<Action> A = A(this.f8233a.f8253b);
            if (!z11 || A == null || (min = Math.min(A.size(), 3)) <= 0) {
                z12 = false;
            } else {
                for (int i12 = 0; i12 < min; i12++) {
                    c11.addView(R$id.actions, z(A.get(i12)));
                }
            }
            if (!z12) {
                i11 = 8;
            }
            c11.setViewVisibility(R$id.actions, i11);
            c11.setViewVisibility(R$id.action_divider, i11);
            d(c11, remoteViews);
            return c11;
        }

        public final RemoteViews z(Action action) {
            int i11;
            boolean z11 = action.f8185k == null;
            String packageName = this.f8233a.f8252a.getPackageName();
            if (z11) {
                i11 = R$layout.notification_action_tombstone;
            } else {
                i11 = R$layout.notification_action;
            }
            RemoteViews remoteViews = new RemoteViews(packageName, i11);
            IconCompat f11 = action.f();
            if (f11 != null) {
                remoteViews.setImageViewBitmap(R$id.action_image, n(f11, R$color.notification_action_color_filter));
            }
            remoteViews.setTextViewText(R$id.action_text, action.f8184j);
            if (!z11) {
                remoteViews.setOnClickPendingIntent(R$id.action_container, action.f8185k);
            }
            if (Build.VERSION.SDK_INT >= 15) {
                a.a(remoteViews, R$id.action_container, action.f8184j);
            }
            return remoteViews;
        }
    }

    public static class InboxStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<CharSequence> f8232e = new ArrayList<>();

        public static class a {
            public static Notification.InboxStyle a(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.addLine(charSequence);
            }

            public static Notification.InboxStyle b(Notification.Builder builder) {
                return new Notification.InboxStyle(builder);
            }

            public static Notification.InboxStyle c(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.setBigContentTitle(charSequence);
            }

            public static Notification.InboxStyle d(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.setSummaryText(charSequence);
            }
        }

        public void b(k kVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle c11 = a.c(a.b(kVar.a()), this.f8234b);
                if (this.f8236d) {
                    a.d(c11, this.f8235c);
                }
                Iterator<CharSequence> it2 = this.f8232e.iterator();
                while (it2.hasNext()) {
                    a.a(c11, it2.next());
                }
            }
        }

        public void f(Bundle bundle) {
            super.f(bundle);
            bundle.remove("android.textLines");
        }

        public String r() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        public void w(Bundle bundle) {
            super.w(bundle);
            this.f8232e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f8232e, bundle.getCharSequenceArray("android.textLines"));
            }
        }
    }

    public static abstract class Style {

        /* renamed from: a  reason: collision with root package name */
        public e f8233a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f8234b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f8235c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8236d = false;

        public static class a {
            public static void a(RemoteViews remoteViews, int i11, int i12, float f11) {
                remoteViews.setTextViewTextSize(i11, i12, f11);
            }

            public static void b(RemoteViews remoteViews, int i11, int i12, int i13, int i14, int i15) {
                remoteViews.setViewPadding(i11, i12, i13, i14, i15);
            }
        }

        public static class b {
            public static void a(RemoteViews remoteViews, int i11, boolean z11) {
                remoteViews.setChronometerCountDown(i11, z11);
            }
        }

        public static float g(float f11, float f12, float f13) {
            return f11 < f12 ? f12 : f11 > f13 ? f13 : f11;
        }

        public static Style h(String str) {
            if (str == null) {
                return null;
            }
            char c11 = 65535;
            switch (str.hashCode()) {
                case -716705180:
                    if (str.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -171946061:
                    if (str.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 714386739:
                    if (str.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 912942987:
                    if (str.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 919595044:
                    if (str.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 2090799565:
                    if (str.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return new DecoratedCustomViewStyle();
                case 1:
                    return new BigPictureStyle();
                case 2:
                    return new CallStyle();
                case 3:
                    return new InboxStyle();
                case 4:
                    return new BigTextStyle();
                case 5:
                    return new f();
                default:
                    return null;
            }
        }

        public static Style i(String str) {
            int i11;
            if (str != null && (i11 = Build.VERSION.SDK_INT) >= 16) {
                if (str.equals(Notification.BigPictureStyle.class.getName())) {
                    return new BigPictureStyle();
                }
                if (str.equals(Notification.BigTextStyle.class.getName())) {
                    return new BigTextStyle();
                }
                if (str.equals(Notification.InboxStyle.class.getName())) {
                    return new InboxStyle();
                }
                if (i11 >= 24) {
                    if (str.equals(Notification.MessagingStyle.class.getName())) {
                        return new f();
                    }
                    if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                        return new DecoratedCustomViewStyle();
                    }
                }
            }
            return null;
        }

        public static Style j(Bundle bundle) {
            Style h11 = h(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            if (h11 != null) {
                return h11;
            }
            if (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) {
                return new f();
            }
            if (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) {
                return new BigPictureStyle();
            }
            if (bundle.containsKey("android.bigText")) {
                return new BigTextStyle();
            }
            if (bundle.containsKey("android.textLines")) {
                return new InboxStyle();
            }
            if (bundle.containsKey("android.callType")) {
                return new CallStyle();
            }
            return i(bundle.getString("android.template"));
        }

        public static Style k(Bundle bundle) {
            Style j11 = j(bundle);
            if (j11 == null) {
                return null;
            }
            try {
                j11.w(bundle);
                return j11;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public static Style q(Notification notification) {
            Bundle k11 = NotificationCompat.k(notification);
            if (k11 == null) {
                return null;
            }
            return k(k11);
        }

        public void a(Bundle bundle) {
            if (this.f8236d) {
                bundle.putCharSequence("android.summaryText", this.f8235c);
            }
            CharSequence charSequence = this.f8234b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String r11 = r();
            if (r11 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", r11);
            }
        }

        public void b(k kVar) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x017b  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0191  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x01b3  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01f9  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01fe  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0200  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0209  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews c(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                androidx.core.app.NotificationCompat$e r1 = r0.f8233a
                android.content.Context r1 = r1.f8252a
                android.content.res.Resources r1 = r1.getResources()
                android.widget.RemoteViews r8 = new android.widget.RemoteViews
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                android.content.Context r2 = r2.f8252a
                java.lang.String r2 = r2.getPackageName()
                r3 = r18
                r8.<init>(r2, r3)
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                int r2 = r2.n()
                r3 = -1
                r9 = 1
                r10 = 0
                if (r2 >= r3) goto L_0x0026
                r2 = r9
                goto L_0x0027
            L_0x0026:
                r2 = r10
            L_0x0027:
                int r11 = android.os.Build.VERSION.SDK_INT
                r4 = 21
                r12 = 16
                if (r11 < r12) goto L_0x0052
                if (r11 >= r4) goto L_0x0052
                java.lang.String r5 = "setBackgroundResource"
                if (r2 == 0) goto L_0x0044
                int r2 = androidx.core.R$id.notification_background
                int r6 = androidx.core.R$drawable.notification_bg_low
                r8.setInt(r2, r5, r6)
                int r2 = androidx.core.R$id.icon
                int r6 = androidx.core.R$drawable.notification_template_icon_low_bg
                r8.setInt(r2, r5, r6)
                goto L_0x0052
            L_0x0044:
                int r2 = androidx.core.R$id.notification_background
                int r6 = androidx.core.R$drawable.notification_bg
                r8.setInt(r2, r5, r6)
                int r2 = androidx.core.R$id.icon
                int r6 = androidx.core.R$drawable.notification_template_icon_bg
                r8.setInt(r2, r5, r6)
            L_0x0052:
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                androidx.core.graphics.drawable.IconCompat r5 = r2.f8261j
                r13 = 8
                if (r5 == 0) goto L_0x00b7
                if (r11 < r12) goto L_0x006d
                int r2 = androidx.core.R$id.icon
                r8.setViewVisibility(r2, r10)
                androidx.core.app.NotificationCompat$e r5 = r0.f8233a
                androidx.core.graphics.drawable.IconCompat r5 = r5.f8261j
                android.graphics.Bitmap r5 = r0.n(r5, r10)
                r8.setImageViewBitmap(r2, r5)
                goto L_0x0072
            L_0x006d:
                int r2 = androidx.core.R$id.icon
                r8.setViewVisibility(r2, r13)
            L_0x0072:
                if (r17 == 0) goto L_0x00f8
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                android.app.Notification r2 = r2.U
                int r2 = r2.icon
                if (r2 == 0) goto L_0x00f8
                int r2 = androidx.core.R$dimen.notification_right_icon_size
                int r2 = r1.getDimensionPixelSize(r2)
                int r5 = androidx.core.R$dimen.notification_small_icon_background_padding
                int r5 = r1.getDimensionPixelSize(r5)
                int r5 = r5 * 2
                int r5 = r2 - r5
                if (r11 < r4) goto L_0x00a2
                androidx.core.app.NotificationCompat$e r3 = r0.f8233a
                android.app.Notification r6 = r3.U
                int r6 = r6.icon
                int r3 = r3.i()
                android.graphics.Bitmap r2 = r0.p(r6, r2, r5, r3)
                int r3 = androidx.core.R$id.right_icon
                r8.setImageViewBitmap(r3, r2)
                goto L_0x00b1
            L_0x00a2:
                int r2 = androidx.core.R$id.right_icon
                androidx.core.app.NotificationCompat$e r5 = r0.f8233a
                android.app.Notification r5 = r5.U
                int r5 = r5.icon
                android.graphics.Bitmap r3 = r0.l(r5, r3)
                r8.setImageViewBitmap(r2, r3)
            L_0x00b1:
                int r2 = androidx.core.R$id.right_icon
                r8.setViewVisibility(r2, r10)
                goto L_0x00f8
            L_0x00b7:
                if (r17 == 0) goto L_0x00f8
                android.app.Notification r2 = r2.U
                int r2 = r2.icon
                if (r2 == 0) goto L_0x00f8
                int r2 = androidx.core.R$id.icon
                r8.setViewVisibility(r2, r10)
                if (r11 < r4) goto L_0x00eb
                int r3 = androidx.core.R$dimen.notification_large_icon_width
                int r3 = r1.getDimensionPixelSize(r3)
                int r5 = androidx.core.R$dimen.notification_big_circle_margin
                int r5 = r1.getDimensionPixelSize(r5)
                int r3 = r3 - r5
                int r5 = androidx.core.R$dimen.notification_small_icon_size_as_large
                int r5 = r1.getDimensionPixelSize(r5)
                androidx.core.app.NotificationCompat$e r6 = r0.f8233a
                android.app.Notification r7 = r6.U
                int r7 = r7.icon
                int r6 = r6.i()
                android.graphics.Bitmap r3 = r0.p(r7, r3, r5, r6)
                r8.setImageViewBitmap(r2, r3)
                goto L_0x00f8
            L_0x00eb:
                androidx.core.app.NotificationCompat$e r5 = r0.f8233a
                android.app.Notification r5 = r5.U
                int r5 = r5.icon
                android.graphics.Bitmap r3 = r0.l(r5, r3)
                r8.setImageViewBitmap(r2, r3)
            L_0x00f8:
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                java.lang.CharSequence r2 = r2.f8256e
                if (r2 == 0) goto L_0x0103
                int r3 = androidx.core.R$id.title
                r8.setTextViewText(r3, r2)
            L_0x0103:
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                java.lang.CharSequence r2 = r2.f8257f
                if (r2 == 0) goto L_0x0110
                int r3 = androidx.core.R$id.text
                r8.setTextViewText(r3, r2)
                r2 = r9
                goto L_0x0111
            L_0x0110:
                r2 = r10
            L_0x0111:
                if (r11 >= r4) goto L_0x011b
                androidx.core.app.NotificationCompat$e r3 = r0.f8233a
                androidx.core.graphics.drawable.IconCompat r3 = r3.f8261j
                if (r3 == 0) goto L_0x011b
                r3 = r9
                goto L_0x011c
            L_0x011b:
                r3 = r10
            L_0x011c:
                androidx.core.app.NotificationCompat$e r4 = r0.f8233a
                java.lang.CharSequence r5 = r4.f8262k
                if (r5 == 0) goto L_0x012d
                int r2 = androidx.core.R$id.info
                r8.setTextViewText(r2, r5)
                r8.setViewVisibility(r2, r10)
            L_0x012a:
                r14 = r9
                r15 = r14
                goto L_0x0168
            L_0x012d:
                int r4 = r4.f8263l
                if (r4 <= 0) goto L_0x0161
                int r2 = androidx.core.R$integer.status_bar_notification_info_maxnum
                int r2 = r1.getInteger(r2)
                androidx.core.app.NotificationCompat$e r3 = r0.f8233a
                int r3 = r3.f8263l
                if (r3 <= r2) goto L_0x0149
                int r2 = androidx.core.R$id.info
                int r3 = androidx.core.R$string.status_bar_notification_info_overflow
                java.lang.String r3 = r1.getString(r3)
                r8.setTextViewText(r2, r3)
                goto L_0x015b
            L_0x0149:
                java.text.NumberFormat r2 = java.text.NumberFormat.getIntegerInstance()
                int r3 = androidx.core.R$id.info
                androidx.core.app.NotificationCompat$e r4 = r0.f8233a
                int r4 = r4.f8263l
                long r4 = (long) r4
                java.lang.String r2 = r2.format(r4)
                r8.setTextViewText(r3, r2)
            L_0x015b:
                int r2 = androidx.core.R$id.info
                r8.setViewVisibility(r2, r10)
                goto L_0x012a
            L_0x0161:
                int r4 = androidx.core.R$id.info
                r8.setViewVisibility(r4, r13)
                r14 = r2
                r15 = r3
            L_0x0168:
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                java.lang.CharSequence r2 = r2.f8269r
                if (r2 == 0) goto L_0x018a
                if (r11 < r12) goto L_0x018a
                int r3 = androidx.core.R$id.text
                r8.setTextViewText(r3, r2)
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                java.lang.CharSequence r2 = r2.f8257f
                if (r2 == 0) goto L_0x0185
                int r3 = androidx.core.R$id.text2
                r8.setTextViewText(r3, r2)
                r8.setViewVisibility(r3, r10)
                r2 = r9
                goto L_0x018b
            L_0x0185:
                int r2 = androidx.core.R$id.text2
                r8.setViewVisibility(r2, r13)
            L_0x018a:
                r2 = r10
            L_0x018b:
                if (r2 == 0) goto L_0x01a7
                if (r11 < r12) goto L_0x01a7
                if (r19 == 0) goto L_0x019d
                int r2 = androidx.core.R$dimen.notification_subtext_size
                int r1 = r1.getDimensionPixelSize(r2)
                float r1 = (float) r1
                int r2 = androidx.core.R$id.text
                androidx.core.app.NotificationCompat.Style.a.a(r8, r2, r10, r1)
            L_0x019d:
                int r3 = androidx.core.R$id.line1
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r2 = r8
                androidx.core.app.NotificationCompat.Style.a.b(r2, r3, r4, r5, r6, r7)
            L_0x01a7:
                androidx.core.app.NotificationCompat$e r1 = r0.f8233a
                long r1 = r1.o()
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 == 0) goto L_0x01f9
                androidx.core.app.NotificationCompat$e r1 = r0.f8233a
                boolean r1 = r1.f8266o
                if (r1 == 0) goto L_0x01e8
                if (r11 < r12) goto L_0x01e8
                int r1 = androidx.core.R$id.chronometer
                r8.setViewVisibility(r1, r10)
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                long r2 = r2.o()
                long r4 = android.os.SystemClock.elapsedRealtime()
                long r6 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r6
                long r2 = r2 + r4
                java.lang.String r4 = "setBase"
                r8.setLong(r1, r4, r2)
                java.lang.String r2 = "setStarted"
                r8.setBoolean(r1, r2, r9)
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                boolean r2 = r2.f8267p
                if (r2 == 0) goto L_0x01fa
                r3 = 24
                if (r11 < r3) goto L_0x01fa
                androidx.core.app.NotificationCompat.Style.b.a(r8, r1, r2)
                goto L_0x01fa
            L_0x01e8:
                int r1 = androidx.core.R$id.time
                r8.setViewVisibility(r1, r10)
                androidx.core.app.NotificationCompat$e r2 = r0.f8233a
                long r2 = r2.o()
                java.lang.String r4 = "setTime"
                r8.setLong(r1, r4, r2)
                goto L_0x01fa
            L_0x01f9:
                r9 = r15
            L_0x01fa:
                int r1 = androidx.core.R$id.right_side
                if (r9 == 0) goto L_0x0200
                r2 = r10
                goto L_0x0201
            L_0x0200:
                r2 = r13
            L_0x0201:
                r8.setViewVisibility(r1, r2)
                int r1 = androidx.core.R$id.line3
                if (r14 == 0) goto L_0x0209
                goto L_0x020a
            L_0x0209:
                r10 = r13
            L_0x020a:
                r8.setViewVisibility(r1, r10)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.c(boolean, int, boolean):android.widget.RemoteViews");
        }

        public void d(RemoteViews remoteViews, RemoteViews remoteViews2) {
            s(remoteViews);
            int i11 = R$id.notification_main_column;
            remoteViews.removeAllViews(i11);
            remoteViews.addView(i11, remoteViews2.clone());
            remoteViews.setViewVisibility(i11, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                a.b(remoteViews, R$id.notification_main_column_container, 0, e(), 0, 0);
            }
        }

        public final int e() {
            Resources resources = this.f8233a.f8252a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.notification_top_pad_large_text);
            float g11 = (g(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - g11) * ((float) dimensionPixelSize)) + (g11 * ((float) dimensionPixelSize2)));
        }

        public void f(Bundle bundle) {
            bundle.remove("android.summaryText");
            bundle.remove("android.title.big");
            bundle.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
        }

        public Bitmap l(int i11, int i12) {
            return m(i11, i12, 0);
        }

        public final Bitmap m(int i11, int i12, int i13) {
            return o(IconCompat.k(this.f8233a.f8252a, i11), i12, i13);
        }

        public Bitmap n(IconCompat iconCompat, int i11) {
            return o(iconCompat, i11, 0);
        }

        public final Bitmap o(IconCompat iconCompat, int i11, int i12) {
            Drawable t11 = iconCompat.t(this.f8233a.f8252a);
            int intrinsicWidth = i12 == 0 ? t11.getIntrinsicWidth() : i12;
            if (i12 == 0) {
                i12 = t11.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i12, Bitmap.Config.ARGB_8888);
            t11.setBounds(0, 0, intrinsicWidth, i12);
            if (i11 != 0) {
                t11.mutate().setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_IN));
            }
            t11.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        public final Bitmap p(int i11, int i12, int i13, int i14) {
            int i15 = R$drawable.notification_icon_background;
            if (i14 == 0) {
                i14 = 0;
            }
            Bitmap m11 = m(i15, i14, i12);
            Canvas canvas = new Canvas(m11);
            Drawable mutate = this.f8233a.f8252a.getResources().getDrawable(i11).mutate();
            mutate.setFilterBitmap(true);
            int i16 = (i12 - i13) / 2;
            int i17 = i13 + i16;
            mutate.setBounds(i16, i16, i17, i17);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return m11;
        }

        public String r() {
            return null;
        }

        public final void s(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R$id.title, 8);
            remoteViews.setViewVisibility(R$id.text2, 8);
            remoteViews.setViewVisibility(R$id.text, 8);
        }

        public RemoteViews t(k kVar) {
            return null;
        }

        public RemoteViews u(k kVar) {
            return null;
        }

        public RemoteViews v(k kVar) {
            return null;
        }

        public void w(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f8235c = bundle.getCharSequence("android.summaryText");
                this.f8236d = true;
            }
            this.f8234b = bundle.getCharSequence("android.title.big");
        }

        public void x(e eVar) {
            if (this.f8233a != eVar) {
                this.f8233a = eVar;
                if (eVar != null) {
                    eVar.c0(this);
                }
            }
        }
    }

    public static final class TvExtender {

        /* renamed from: a  reason: collision with root package name */
        public int f8237a = 1;
    }

    public static final class WearableExtender {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<Action> f8238a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public int f8239b = 1;

        /* renamed from: c  reason: collision with root package name */
        public PendingIntent f8240c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Notification> f8241d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        public Bitmap f8242e;

        /* renamed from: f  reason: collision with root package name */
        public int f8243f;

        /* renamed from: g  reason: collision with root package name */
        public int f8244g = 8388613;

        /* renamed from: h  reason: collision with root package name */
        public int f8245h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f8246i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f8247j;

        /* renamed from: k  reason: collision with root package name */
        public int f8248k = 80;

        /* renamed from: l  reason: collision with root package name */
        public int f8249l;

        /* renamed from: m  reason: collision with root package name */
        public String f8250m;

        /* renamed from: n  reason: collision with root package name */
        public String f8251n;

        /* renamed from: a */
        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f8238a = new ArrayList<>(this.f8238a);
            wearableExtender.f8239b = this.f8239b;
            wearableExtender.f8240c = this.f8240c;
            wearableExtender.f8241d = new ArrayList<>(this.f8241d);
            wearableExtender.f8242e = this.f8242e;
            wearableExtender.f8243f = this.f8243f;
            wearableExtender.f8244g = this.f8244g;
            wearableExtender.f8245h = this.f8245h;
            wearableExtender.f8246i = this.f8246i;
            wearableExtender.f8247j = this.f8247j;
            wearableExtender.f8248k = this.f8248k;
            wearableExtender.f8249l = this.f8249l;
            wearableExtender.f8250m = this.f8250m;
            wearableExtender.f8251n = this.f8251n;
            return wearableExtender;
        }
    }

    public static class b {
        public static boolean a(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        public static CharSequence[] b(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        public static Bundle c(Notification.Action action) {
            return action.getExtras();
        }

        public static Bundle d(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        public static String e(Notification notification) {
            return notification.getGroup();
        }

        public static CharSequence f(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        public static RemoteInput[] g(Notification.Action action) {
            return action.getRemoteInputs();
        }

        public static String h(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        public static String i(Notification notification) {
            return notification.getSortKey();
        }
    }

    public static class c {
        public static int a(Notification notification) {
            return notification.getBadgeIconType();
        }

        public static String b(Notification notification) {
            return notification.getChannelId();
        }

        public static int c(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        public static CharSequence d(Notification notification) {
            return notification.getSettingsText();
        }

        public static String e(Notification notification) {
            return notification.getShortcutId();
        }

        public static long f(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    public static class d {
        public static boolean a(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        public static Notification.BubbleMetadata b(Notification notification) {
            return notification.getBubbleMetadata();
        }

        public static int c(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        public static LocusId d(Notification notification) {
            return notification.getLocusId();
        }

        public static boolean e(Notification.Action action) {
            return action.isContextual();
        }
    }

    public static class f extends Style {

        /* renamed from: e  reason: collision with root package name */
        public final List<e> f8278e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public final List<e> f8279f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public Person f8280g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f8281h;

        /* renamed from: i  reason: collision with root package name */
        public Boolean f8282i;

        public static class a {
            public static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            public static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            public static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            public static void d(Notification.Style style, Notification.Builder builder) {
                style.setBuilder(builder);
            }
        }

        public static class b {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            public static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            public static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        public static class c {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        public static class d {
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z11) {
                return messagingStyle.setGroupConversation(z11);
            }
        }

        public static final class e {

            /* renamed from: a  reason: collision with root package name */
            public final CharSequence f8283a;

            /* renamed from: b  reason: collision with root package name */
            public final long f8284b;

            /* renamed from: c  reason: collision with root package name */
            public final Person f8285c;

            /* renamed from: d  reason: collision with root package name */
            public Bundle f8286d = new Bundle();

            /* renamed from: e  reason: collision with root package name */
            public String f8287e;

            /* renamed from: f  reason: collision with root package name */
            public Uri f8288f;

            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j11, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j11, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public static class b {
                public static Parcelable a(Person person) {
                    return person;
                }

                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j11, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j11, person);
                }
            }

            public e(CharSequence charSequence, long j11, Person person) {
                this.f8283a = charSequence;
                this.f8284b = j11;
                this.f8285c = person;
            }

            public static Bundle[] a(List<e> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    bundleArr[i11] = list.get(i11).l();
                }
                return bundleArr;
            }

            public static e e(Bundle bundle) {
                Person person;
                try {
                    if (bundle.containsKey("text")) {
                        if (bundle.containsKey(CrashHianalyticsData.TIME)) {
                            if (bundle.containsKey("person")) {
                                person = Person.b(bundle.getBundle("person"));
                            } else if (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) {
                                person = bundle.containsKey(TUIConstants.TUICalling.SENDER) ? new Person.Builder().f(bundle.getCharSequence(TUIConstants.TUICalling.SENDER)).a() : null;
                            } else {
                                person = Person.a((android.app.Person) bundle.getParcelable("sender_person"));
                            }
                            e eVar = new e(bundle.getCharSequence("text"), bundle.getLong(CrashHianalyticsData.TIME), person);
                            if (bundle.containsKey("type") && bundle.containsKey(ShareConstants.MEDIA_URI)) {
                                eVar.j(bundle.getString("type"), (Uri) bundle.getParcelable(ShareConstants.MEDIA_URI));
                            }
                            if (bundle.containsKey("extras")) {
                                eVar.d().putAll(bundle.getBundle("extras"));
                            }
                            return eVar;
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public static List<e> f(Parcelable[] parcelableArr) {
                e e11;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (int i11 = 0; i11 < parcelableArr.length; i11++) {
                    if ((parcelableArr[i11] instanceof Bundle) && (e11 = e(parcelableArr[i11])) != null) {
                        arrayList.add(e11);
                    }
                }
                return arrayList;
            }

            public String b() {
                return this.f8287e;
            }

            public Uri c() {
                return this.f8288f;
            }

            public Bundle d() {
                return this.f8286d;
            }

            public Person g() {
                return this.f8285c;
            }

            public CharSequence h() {
                return this.f8283a;
            }

            public long i() {
                return this.f8284b;
            }

            public e j(String str, Uri uri) {
                this.f8287e = str;
                this.f8288f = uri;
                return this;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.app.Person} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.CharSequence] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.app.Notification.MessagingStyle.Message k() {
                /*
                    r5 = this;
                    androidx.core.app.Person r0 = r5.g()
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 0
                    r3 = 28
                    if (r1 < r3) goto L_0x001f
                    java.lang.CharSequence r1 = r5.h()
                    long r3 = r5.i()
                    if (r0 != 0) goto L_0x0016
                    goto L_0x001a
                L_0x0016:
                    android.app.Person r2 = r0.j()
                L_0x001a:
                    android.app.Notification$MessagingStyle$Message r0 = androidx.core.app.NotificationCompat.f.e.b.b(r1, r3, r2)
                    goto L_0x0032
                L_0x001f:
                    java.lang.CharSequence r1 = r5.h()
                    long r3 = r5.i()
                    if (r0 != 0) goto L_0x002a
                    goto L_0x002e
                L_0x002a:
                    java.lang.CharSequence r2 = r0.e()
                L_0x002e:
                    android.app.Notification$MessagingStyle$Message r0 = androidx.core.app.NotificationCompat.f.e.a.a(r1, r3, r2)
                L_0x0032:
                    java.lang.String r1 = r5.b()
                    if (r1 == 0) goto L_0x0043
                    java.lang.String r1 = r5.b()
                    android.net.Uri r2 = r5.c()
                    androidx.core.app.NotificationCompat.f.e.a.b(r0, r1, r2)
                L_0x0043:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.f.e.k():android.app.Notification$MessagingStyle$Message");
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f8283a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(CrashHianalyticsData.TIME, this.f8284b);
                Person person = this.f8285c;
                if (person != null) {
                    bundle.putCharSequence(TUIConstants.TUICalling.SENDER, person.e());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f8285c.j()));
                    } else {
                        bundle.putBundle("person", this.f8285c.k());
                    }
                }
                String str = this.f8287e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f8288f;
                if (uri != null) {
                    bundle.putParcelable(ShareConstants.MEDIA_URI, uri);
                }
                Bundle bundle2 = this.f8286d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }
        }

        public boolean A() {
            e eVar = this.f8233a;
            if (eVar == null || eVar.f8252a.getApplicationInfo().targetSdkVersion >= 28 || this.f8282i != null) {
                Boolean bool = this.f8282i;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } else if (this.f8281h != null) {
                return true;
            } else {
                return false;
            }
        }

        public final TextAppearanceSpan B(int i11) {
            return new TextAppearanceSpan((String) null, 0, 0, ColorStateList.valueOf(i11), (ColorStateList) null);
        }

        public final CharSequence C(e eVar) {
            BidiFormatter c11 = BidiFormatter.c();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z11 = Build.VERSION.SDK_INT >= 21;
            int i11 = z11 ? RoundedDrawable.DEFAULT_BORDER_COLOR : -1;
            CharSequence charSequence = "";
            CharSequence e11 = eVar.g() == null ? charSequence : eVar.g().e();
            if (TextUtils.isEmpty(e11)) {
                e11 = this.f8280g.e();
                if (z11 && this.f8233a.i() != 0) {
                    i11 = this.f8233a.i();
                }
            }
            CharSequence h11 = c11.h(e11);
            spannableStringBuilder.append(h11);
            spannableStringBuilder.setSpan(B(i11), spannableStringBuilder.length() - h11.length(), spannableStringBuilder.length(), 33);
            if (eVar.h() != null) {
                charSequence = eVar.h();
            }
            spannableStringBuilder.append("  ").append(c11.h(charSequence));
            return spannableStringBuilder;
        }

        public f D(boolean z11) {
            this.f8282i = Boolean.valueOf(z11);
            return this;
        }

        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f8280g.e());
            bundle.putBundle("android.messagingStyleUser", this.f8280g.k());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f8281h);
            if (this.f8281h != null && this.f8282i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f8281h);
            }
            if (!this.f8278e.isEmpty()) {
                bundle.putParcelableArray("android.messages", e.a(this.f8278e));
            }
            if (!this.f8279f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", e.a(this.f8279f));
            }
            Boolean bool = this.f8282i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        public void b(k kVar) {
            CharSequence charSequence;
            Notification.MessagingStyle messagingStyle;
            D(A());
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                if (i11 >= 28) {
                    messagingStyle = d.a(this.f8280g.j());
                } else {
                    messagingStyle = b.b(this.f8280g.e());
                }
                for (e k11 : this.f8278e) {
                    b.a(messagingStyle, k11.k());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    for (e k12 : this.f8279f) {
                        c.a(messagingStyle, k12.k());
                    }
                }
                if (this.f8282i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    b.c(messagingStyle, this.f8281h);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    d.b(messagingStyle, this.f8282i.booleanValue());
                }
                a.d(messagingStyle, kVar.a());
                return;
            }
            e y11 = y();
            if (this.f8281h != null && this.f8282i.booleanValue()) {
                kVar.a().setContentTitle(this.f8281h);
            } else if (y11 != null) {
                kVar.a().setContentTitle("");
                if (y11.g() != null) {
                    kVar.a().setContentTitle(y11.g().e());
                }
            }
            if (y11 != null) {
                Notification.Builder a11 = kVar.a();
                if (this.f8281h != null) {
                    charSequence = C(y11);
                } else {
                    charSequence = y11.h();
                }
                a11.setContentText(charSequence);
            }
            if (i11 >= 16) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z11 = this.f8281h != null || z();
                for (int size = this.f8278e.size() - 1; size >= 0; size--) {
                    e eVar = this.f8278e.get(size);
                    CharSequence C = z11 ? C(eVar) : eVar.h();
                    if (size != this.f8278e.size() - 1) {
                        spannableStringBuilder.insert(0, "\n");
                    }
                    spannableStringBuilder.insert(0, C);
                }
                a.a(a.c(a.b(kVar.a()), (CharSequence) null), spannableStringBuilder);
            }
        }

        public void f(Bundle bundle) {
            super.f(bundle);
            bundle.remove("android.messagingStyleUser");
            bundle.remove("android.selfDisplayName");
            bundle.remove("android.conversationTitle");
            bundle.remove("android.hiddenConversationTitle");
            bundle.remove("android.messages");
            bundle.remove("android.messages.historic");
            bundle.remove("android.isGroupConversation");
        }

        public String r() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        public void w(Bundle bundle) {
            super.w(bundle);
            this.f8278e.clear();
            if (bundle.containsKey("android.messagingStyleUser")) {
                this.f8280g = Person.b(bundle.getBundle("android.messagingStyleUser"));
            } else {
                this.f8280g = new Person.Builder().f(bundle.getString("android.selfDisplayName")).a();
            }
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f8281h = charSequence;
            if (charSequence == null) {
                this.f8281h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f8278e.addAll(e.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f8279f.addAll(e.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f8282i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public final e y() {
            for (int size = this.f8278e.size() - 1; size >= 0; size--) {
                e eVar = this.f8278e.get(size);
                if (eVar.g() != null && !TextUtils.isEmpty(eVar.g().e())) {
                    return eVar;
                }
            }
            if (this.f8278e.isEmpty()) {
                return null;
            }
            List<e> list = this.f8278e;
            return list.get(list.size() - 1);
        }

        public final boolean z() {
            for (int size = this.f8278e.size() - 1; size >= 0; size--) {
                e eVar = this.f8278e.get(size);
                if (eVar.g() != null && eVar.g().e() == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static int A(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.visibility;
        }
        return 0;
    }

    public static boolean B(Notification notification) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            if ((notification.flags & 512) != 0) {
                return true;
            }
            return false;
        } else if (i11 >= 19) {
            return notification.extras.getBoolean("android.support.isGroupSummary");
        } else {
            if (i11 >= 16) {
                return b.g(notification).getBoolean("android.support.isGroupSummary");
            }
            return false;
        }
    }

    public static Bitmap C(Context context, Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
    }

    public static boolean a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return d.a(notification);
        }
        return false;
    }

    public static boolean b(Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int c(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.a(notification);
        }
        return 0;
    }

    public static BubbleMetadata d(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.a(d.b(notification));
        }
        return null;
    }

    public static String e(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static String f(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.b(notification);
        }
        return null;
    }

    public static int g(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.color;
        }
        return 0;
    }

    public static CharSequence h(Notification notification) {
        return notification.extras.getCharSequence("android.infoText");
    }

    public static CharSequence i(Notification notification) {
        return notification.extras.getCharSequence("android.text");
    }

    public static CharSequence j(Notification notification) {
        return notification.extras.getCharSequence("android.title");
    }

    public static Bundle k(Notification notification) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            return notification.extras;
        }
        if (i11 >= 16) {
            return b.g(notification);
        }
        return null;
    }

    public static String l(Notification notification) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            return b.e(notification);
        }
        if (i11 >= 19) {
            return notification.extras.getString("android.support.groupKey");
        }
        if (i11 >= 16) {
            return b.g(notification).getString("android.support.groupKey");
        }
        return null;
    }

    public static boolean m(Notification notification) {
        return (notification.flags & 128) != 0;
    }

    public static List<Action> n(Notification notification) {
        Bundle bundle;
        Bundle bundle2;
        ArrayList arrayList = new ArrayList();
        if (!(Build.VERSION.SDK_INT < 19 || (bundle = notification.extras.getBundle("android.car.EXTENSIONS")) == null || (bundle2 = bundle.getBundle("invisible_actions")) == null)) {
            for (int i11 = 0; i11 < bundle2.size(); i11++) {
                arrayList.add(b.d(bundle2.getBundle(Integer.toString(i11))));
            }
        }
        return arrayList;
    }

    public static boolean o(Notification notification) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            if ((notification.flags & 256) != 0) {
                return true;
            }
            return false;
        } else if (i11 >= 19) {
            return notification.extras.getBoolean("android.support.localOnly");
        } else {
            if (i11 >= 16) {
                return b.g(notification).getBoolean("android.support.localOnly");
            }
            return false;
        }
    }

    public static q0.b p(Notification notification) {
        LocusId d11;
        if (Build.VERSION.SDK_INT < 29 || (d11 = d.d(notification)) == null) {
            return null;
        }
        return q0.b.c(d11);
    }

    public static boolean q(Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean r(Notification notification) {
        return (notification.flags & 8) != 0;
    }

    public static Notification s(Notification notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            return notification.publicVersion;
        }
        return null;
    }

    public static CharSequence t(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.d(notification);
        }
        return null;
    }

    public static String u(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.e(notification);
        }
        return null;
    }

    public static boolean v(Notification notification) {
        return notification.extras.getBoolean("android.showWhen");
    }

    public static String w(Notification notification) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            return b.i(notification);
        }
        if (i11 >= 19) {
            return notification.extras.getString("android.support.sortKey");
        }
        if (i11 >= 16) {
            return b.g(notification).getString("android.support.sortKey");
        }
        return null;
    }

    public static CharSequence x(Notification notification) {
        return notification.extras.getCharSequence("android.subText");
    }

    public static long y(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.f(notification);
        }
        return 0;
    }

    public static boolean z(Notification notification) {
        return notification.extras.getBoolean("android.showChronometer");
    }

    public static class e {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public q0.b O;
        public long P;
        public int Q;
        public int R;
        public boolean S;
        public BubbleMetadata T;
        public Notification U;
        public boolean V;
        public Object W;
        @Deprecated
        public ArrayList<String> X;

        /* renamed from: a  reason: collision with root package name */
        public Context f8252a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Action> f8253b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Person> f8254c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Action> f8255d;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f8256e;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f8257f;

        /* renamed from: g  reason: collision with root package name */
        public PendingIntent f8258g;

        /* renamed from: h  reason: collision with root package name */
        public PendingIntent f8259h;

        /* renamed from: i  reason: collision with root package name */
        public RemoteViews f8260i;

        /* renamed from: j  reason: collision with root package name */
        public IconCompat f8261j;

        /* renamed from: k  reason: collision with root package name */
        public CharSequence f8262k;

        /* renamed from: l  reason: collision with root package name */
        public int f8263l;

        /* renamed from: m  reason: collision with root package name */
        public int f8264m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f8265n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f8266o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f8267p;

        /* renamed from: q  reason: collision with root package name */
        public Style f8268q;

        /* renamed from: r  reason: collision with root package name */
        public CharSequence f8269r;

        /* renamed from: s  reason: collision with root package name */
        public CharSequence f8270s;

        /* renamed from: t  reason: collision with root package name */
        public CharSequence[] f8271t;

        /* renamed from: u  reason: collision with root package name */
        public int f8272u;

        /* renamed from: v  reason: collision with root package name */
        public int f8273v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f8274w;

        /* renamed from: x  reason: collision with root package name */
        public String f8275x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f8276y;

        /* renamed from: z  reason: collision with root package name */
        public String f8277z;

        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i11) {
                return builder.setContentType(i11);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i11) {
                return builder.setLegacyStreamType(i11);
            }

            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i11) {
                return builder.setUsage(i11);
            }
        }

        public static class b {
            public static Icon a(Notification notification) {
                return notification.getLargeIcon();
            }

            public static Icon b(Notification notification) {
                return notification.getSmallIcon();
            }
        }

        public e(Context context, Notification notification) {
            this(context, NotificationCompat.f(notification));
            ArrayList parcelableArrayList;
            Bundle bundle = notification.extras;
            Style q11 = Style.q(notification);
            C(NotificationCompat.j(notification)).B(NotificationCompat.i(notification)).z(NotificationCompat.h(notification)).d0(NotificationCompat.x(notification)).T(NotificationCompat.t(notification)).c0(q11).A(notification.contentIntent).H(NotificationCompat.l(notification)).I(NotificationCompat.B(notification)).M(NotificationCompat.p(notification)).j0(notification.when).V(NotificationCompat.v(notification)).g0(NotificationCompat.z(notification)).r(NotificationCompat.b(notification)).P(NotificationCompat.r(notification)).O(NotificationCompat.q(notification)).L(NotificationCompat.o(notification)).J(notification.largeIcon).s(NotificationCompat.c(notification)).u(NotificationCompat.e(notification)).t(NotificationCompat.d(notification)).N(notification.number).e0(notification.tickerText).A(notification.contentIntent).E(notification.deleteIntent).G(notification.fullScreenIntent, NotificationCompat.m(notification)).b0(notification.sound, notification.audioStreamType).h0(notification.vibrate).K(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).D(notification.defaults).Q(notification.priority).x(NotificationCompat.g(notification)).i0(NotificationCompat.A(notification)).S(NotificationCompat.s(notification)).Z(NotificationCompat.w(notification)).f0(NotificationCompat.y(notification)).U(NotificationCompat.u(notification)).R(bundle.getInt("android.progressMax"), bundle.getInt("android.progress"), bundle.getBoolean("android.progressIndeterminate")).q(NotificationCompat.a(notification)).Y(notification.icon, notification.iconLevel).c(l(notification, q11));
            if (Build.VERSION.SDK_INT >= 23) {
                this.W = b.b(notification);
                Icon a11 = b.a(notification);
                if (a11 != null) {
                    this.f8261j = IconCompat.c(a11);
                }
            }
            Notification.Action[] actionArr = notification.actions;
            if (!(actionArr == null || actionArr.length == 0)) {
                for (Notification.Action e11 : actionArr) {
                    b(Action.a.e(e11).c());
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                List<Action> n11 = NotificationCompat.n(notification);
                if (!n11.isEmpty()) {
                    for (Action d11 : n11) {
                        d(d11);
                    }
                }
            }
            String[] stringArray = notification.extras.getStringArray("android.people");
            if (!(stringArray == null || stringArray.length == 0)) {
                for (String f11 : stringArray) {
                    f(f11);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList("android.people.list")) != null && !parcelableArrayList.isEmpty()) {
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    e(Person.a((android.app.Person) it2.next()));
                }
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24 && bundle.containsKey("android.chronometerCountDown")) {
                w(bundle.getBoolean("android.chronometerCountDown"));
            }
            if (i11 >= 26 && bundle.containsKey("android.colorized")) {
                y(bundle.getBoolean("android.colorized"));
            }
        }

        public static Bundle l(Notification notification, Style style) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove("android.title");
            bundle.remove("android.text");
            bundle.remove("android.infoText");
            bundle.remove("android.subText");
            bundle.remove("android.intent.extra.CHANNEL_ID");
            bundle.remove("android.intent.extra.CHANNEL_GROUP_ID");
            bundle.remove("android.showWhen");
            bundle.remove("android.progress");
            bundle.remove("android.progressMax");
            bundle.remove("android.progressIndeterminate");
            bundle.remove("android.chronometerCountDown");
            bundle.remove("android.colorized");
            bundle.remove("android.people.list");
            bundle.remove("android.people");
            bundle.remove("android.support.sortKey");
            bundle.remove("android.support.groupKey");
            bundle.remove("android.support.isGroupSummary");
            bundle.remove("android.support.localOnly");
            bundle.remove("android.support.actionExtras");
            Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (style != null) {
                style.f(bundle);
            }
            return bundle;
        }

        public static CharSequence p(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(PendingIntent pendingIntent) {
            this.f8258g = pendingIntent;
            return this;
        }

        public e B(CharSequence charSequence) {
            this.f8257f = p(charSequence);
            return this;
        }

        public e C(CharSequence charSequence) {
            this.f8256e = p(charSequence);
            return this;
        }

        public e D(int i11) {
            Notification notification = this.U;
            notification.defaults = i11;
            if ((i11 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e E(PendingIntent pendingIntent) {
            this.U.deleteIntent = pendingIntent;
            return this;
        }

        public final void F(int i11, boolean z11) {
            if (z11) {
                Notification notification = this.U;
                notification.flags = i11 | notification.flags;
                return;
            }
            Notification notification2 = this.U;
            notification2.flags = (~i11) & notification2.flags;
        }

        public e G(PendingIntent pendingIntent, boolean z11) {
            this.f8259h = pendingIntent;
            F(128, z11);
            return this;
        }

        public e H(String str) {
            this.f8275x = str;
            return this;
        }

        public e I(boolean z11) {
            this.f8276y = z11;
            return this;
        }

        public e J(Bitmap bitmap) {
            IconCompat iconCompat;
            if (bitmap == null) {
                iconCompat = null;
            } else {
                iconCompat = IconCompat.h(NotificationCompat.C(this.f8252a, bitmap));
            }
            this.f8261j = iconCompat;
            return this;
        }

        public e K(int i11, int i12, int i13) {
            Notification notification = this.U;
            notification.ledARGB = i11;
            notification.ledOnMS = i12;
            notification.ledOffMS = i13;
            notification.flags = ((i12 == 0 || i13 == 0) ? 0 : 1) | (notification.flags & -2);
            return this;
        }

        public e L(boolean z11) {
            this.A = z11;
            return this;
        }

        public e M(q0.b bVar) {
            this.O = bVar;
            return this;
        }

        public e N(int i11) {
            this.f8263l = i11;
            return this;
        }

        public e O(boolean z11) {
            F(2, z11);
            return this;
        }

        public e P(boolean z11) {
            F(8, z11);
            return this;
        }

        public e Q(int i11) {
            this.f8264m = i11;
            return this;
        }

        public e R(int i11, int i12, boolean z11) {
            this.f8272u = i11;
            this.f8273v = i12;
            this.f8274w = z11;
            return this;
        }

        public e S(Notification notification) {
            this.H = notification;
            return this;
        }

        public e T(CharSequence charSequence) {
            this.f8270s = p(charSequence);
            return this;
        }

        public e U(String str) {
            this.N = str;
            return this;
        }

        public e V(boolean z11) {
            this.f8265n = z11;
            return this;
        }

        public e W(boolean z11) {
            this.V = z11;
            return this;
        }

        public e X(int i11) {
            this.U.icon = i11;
            return this;
        }

        public e Y(int i11, int i12) {
            Notification notification = this.U;
            notification.icon = i11;
            notification.iconLevel = i12;
            return this;
        }

        public e Z(String str) {
            this.f8277z = str;
            return this;
        }

        public e a(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f8253b.add(new Action(i11, charSequence, pendingIntent));
            return this;
        }

        public e a0(Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                AudioAttributes.Builder e11 = a.e(a.c(a.b(), 4), 5);
                this.U.audioAttributes = a.a(e11);
            }
            return this;
        }

        public e b(Action action) {
            if (action != null) {
                this.f8253b.add(action);
            }
            return this;
        }

        public e b0(Uri uri, int i11) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = i11;
            if (Build.VERSION.SDK_INT >= 21) {
                AudioAttributes.Builder d11 = a.d(a.c(a.b(), 4), i11);
                this.U.audioAttributes = a.a(d11);
            }
            return this;
        }

        public e c(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.E;
                if (bundle2 == null) {
                    this.E = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        public e c0(Style style) {
            if (this.f8268q != style) {
                this.f8268q = style;
                if (style != null) {
                    style.x(this);
                }
            }
            return this;
        }

        public e d(Action action) {
            if (action != null) {
                this.f8255d.add(action);
            }
            return this;
        }

        public e d0(CharSequence charSequence) {
            this.f8269r = p(charSequence);
            return this;
        }

        public e e(Person person) {
            if (person != null) {
                this.f8254c.add(person);
            }
            return this;
        }

        public e e0(CharSequence charSequence) {
            this.U.tickerText = p(charSequence);
            return this;
        }

        @Deprecated
        public e f(String str) {
            if (str != null && !str.isEmpty()) {
                this.X.add(str);
            }
            return this;
        }

        public e f0(long j11) {
            this.P = j11;
            return this;
        }

        public Notification g() {
            return new a(this).c();
        }

        public e g0(boolean z11) {
            this.f8266o = z11;
            return this;
        }

        public RemoteViews h() {
            return this.J;
        }

        public e h0(long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        public int i() {
            return this.F;
        }

        public e i0(int i11) {
            this.G = i11;
            return this;
        }

        public RemoteViews j() {
            return this.I;
        }

        public e j0(long j11) {
            this.U.when = j11;
            return this;
        }

        public Bundle k() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public RemoteViews m() {
            return this.K;
        }

        public int n() {
            return this.f8264m;
        }

        public long o() {
            if (this.f8265n) {
                return this.U.when;
            }
            return 0;
        }

        public e q(boolean z11) {
            this.S = z11;
            return this;
        }

        public e r(boolean z11) {
            F(16, z11);
            return this;
        }

        public e s(int i11) {
            this.M = i11;
            return this;
        }

        public e t(BubbleMetadata bubbleMetadata) {
            this.T = bubbleMetadata;
            return this;
        }

        public e u(String str) {
            this.D = str;
            return this;
        }

        public e v(String str) {
            this.L = str;
            return this;
        }

        public e w(boolean z11) {
            this.f8267p = z11;
            k().putBoolean("android.chronometerCountDown", z11);
            return this;
        }

        public e x(int i11) {
            this.F = i11;
            return this;
        }

        public e y(boolean z11) {
            this.B = z11;
            this.C = true;
            return this;
        }

        public e z(CharSequence charSequence) {
            this.f8262k = p(charSequence);
            return this;
        }

        public e(Context context, String str) {
            this.f8253b = new ArrayList<>();
            this.f8254c = new ArrayList<>();
            this.f8255d = new ArrayList<>();
            this.f8265n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f8252a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.f8264m = 0;
            this.X = new ArrayList<>();
            this.S = true;
        }

        @Deprecated
        public e(Context context) {
            this(context, (String) null);
        }
    }
}
