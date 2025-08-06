package com.sumsub.sns.internal.core.common;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.LocaleList;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.camera.core.CameraInfo;
import androidx.fragment.app.FragmentActivity;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.common.f0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.remote.o;
import d10.l;
import d10.p;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.LinkResolverDef;
import io.noties.markwon.Markwon;
import io.noties.markwon.b;
import io.noties.markwon.d;
import java.io.Closeable;
import java.io.File;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;
import sz.a;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static Markwon f32068a;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.CommonExtensionsKt$copyContentsToCacheFile$2", f = "CommonExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super String>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32070a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32071b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f32072c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Uri f32073d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, Uri uri, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f32072c = context;
            this.f32073d = uri;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super String> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f32072c, this.f32073d, cVar);
            bVar.f32071b = obj;
            return bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0093, code lost:
            if (r2 != null) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
            r2 = r0.getContentResolver();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r11.f32070a
                if (r0 != 0) goto L_0x00e6
                kotlin.k.b(r12)
                java.lang.Object r12 = r11.f32071b
                kotlinx.coroutines.h0 r12 = (kotlinx.coroutines.h0) r12
                android.content.Context r0 = r11.f32072c
                r1 = 0
                if (r0 == 0) goto L_0x0024
                android.content.ContentResolver r2 = r0.getContentResolver()
                if (r2 == 0) goto L_0x0024
                android.net.Uri r3 = r11.f32073d
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)
                goto L_0x0025
            L_0x0024:
                r0 = r1
            L_0x0025:
                r2 = -1
                if (r0 == 0) goto L_0x002f
                java.lang.String r3 = "_display_name"
                int r3 = r0.getColumnIndex(r3)
                goto L_0x0030
            L_0x002f:
                r3 = r2
            L_0x0030:
                if (r0 == 0) goto L_0x0039
                boolean r4 = r0.moveToFirst()
                kotlin.coroutines.jvm.internal.a.a(r4)
            L_0x0039:
                if (r3 != r2) goto L_0x0041
                if (r0 == 0) goto L_0x0040
                r0.close()
            L_0x0040:
                return r1
            L_0x0041:
                if (r0 == 0) goto L_0x0048
                java.lang.String r3 = r0.getString(r3)
                goto L_0x0049
            L_0x0048:
                r3 = r1
            L_0x0049:
                if (r0 == 0) goto L_0x004e
                r0.close()
            L_0x004e:
                r0 = 0
                r10 = 1
                if (r3 == 0) goto L_0x005b
                int r4 = r3.length()
                if (r4 != 0) goto L_0x0059
                goto L_0x005b
            L_0x0059:
                r4 = r0
                goto L_0x005c
            L_0x005b:
                r4 = r10
            L_0x005c:
                if (r4 == 0) goto L_0x005f
                return r1
            L_0x005f:
                r6 = 0
                r7 = 0
                r8 = 6
                r9 = 0
                java.lang.String r5 = "."
                r4 = r3
                int r4 = kotlin.text.StringsKt__StringsKt.m0(r4, r5, r6, r7, r8, r9)
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.c(r4)
                int r5 = r4.intValue()
                if (r5 <= r2) goto L_0x0076
                r2 = r10
                goto L_0x0077
            L_0x0076:
                r2 = r0
            L_0x0077:
                if (r2 == 0) goto L_0x007a
                goto L_0x007b
            L_0x007a:
                r4 = r1
            L_0x007b:
                if (r4 == 0) goto L_0x0096
                int r2 = r4.intValue()
                java.lang.String r2 = r3.substring(r2)
                if (r2 == 0) goto L_0x0096
                r3 = 47
                r4 = 2
                boolean r0 = kotlin.text.StringsKt__StringsKt.Q(r2, r3, r0, r4, r1)
                r0 = r0 ^ r10
                if (r0 == 0) goto L_0x0092
                goto L_0x0093
            L_0x0092:
                r2 = r1
            L_0x0093:
                if (r2 == 0) goto L_0x0096
                goto L_0x0098
            L_0x0096:
                java.lang.String r2 = ""
            L_0x0098:
                java.lang.String r0 = "from_gallery"
                android.content.Context r3 = r11.f32072c     // Catch:{ Exception -> 0x00c7 }
                java.io.File r3 = r3.getCacheDir()     // Catch:{ Exception -> 0x00c7 }
                java.io.File r0 = java.io.File.createTempFile(r0, r2, r3)     // Catch:{ Exception -> 0x00c7 }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c7 }
                r2.<init>(r0)     // Catch:{ Exception -> 0x00c7 }
                android.content.Context r3 = r11.f32072c     // Catch:{ Exception -> 0x00c7 }
                android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x00c7 }
                android.net.Uri r4 = r11.f32073d     // Catch:{ Exception -> 0x00c7 }
                java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ Exception -> 0x00c7 }
                if (r3 != 0) goto L_0x00b8
                return r1
            L_0x00b8:
                boolean r2 = com.sumsub.sns.internal.core.common.r0.a(r3, r2)     // Catch:{ Exception -> 0x00c7 }
                com.sumsub.sns.internal.core.common.i.a((java.io.Closeable) r3)     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r12 = r0.getPath()     // Catch:{ Exception -> 0x00c7 }
                if (r2 == 0) goto L_0x00c6
                r1 = r12
            L_0x00c6:
                return r1
            L_0x00c7:
                r0 = move-exception
                com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r12)
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r4 = "Error copying content: "
                r12.append(r4)
                r12.append(r0)
                java.lang.String r4 = r12.toString()
                r5 = 0
                r6 = 4
                r7 = 0
                com.sumsub.log.logger.a.b(r2, r3, r4, r5, r6, r7)
                return r1
            L_0x00e6:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.CommonExtensionsKt", f = "CommonExtensions.kt", l = {241, 245}, m = "copyFileFromActivityResultToCacheDir")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f32074a;

        /* renamed from: b  reason: collision with root package name */
        public int f32075b;

        public c(kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f32074a = obj;
            this.f32075b |= Integer.MIN_VALUE;
            return i.a((Context) null, (String) null, (Uri) null, (kotlin.coroutines.c<? super Uri>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.CommonExtensionsKt", f = "CommonExtensions.kt", l = {273, 280, 284}, m = "copyFromImageGalleryToCacheIfPossible")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32076a;

        /* renamed from: b  reason: collision with root package name */
        public Object f32077b;

        /* renamed from: c  reason: collision with root package name */
        public Object f32078c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f32079d;

        /* renamed from: e  reason: collision with root package name */
        public int f32080e;

        public d(kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f32079d = obj;
            this.f32080e |= Integer.MIN_VALUE;
            return i.c((Uri) null, (Context) null, this);
        }
    }

    public static final int b(int i11) {
        if (i11 == 90) {
            return 6;
        }
        if (i11 != 180) {
            return i11 != 270 ? 1 : 8;
        }
        return 3;
    }

    @SuppressLint({"DefaultLocale"})
    public static final String b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        Locale locale = Locale.ROOT;
        if (StringsKt__StringsJVMKt.M(str2.toLowerCase(locale), str.toLowerCase(locale), false, 2, (Object) null)) {
            if (!(str2.length() > 0)) {
                return str2;
            }
            StringBuilder sb2 = new StringBuilder();
            char charAt = str2.charAt(0);
            sb2.append(Character.isLowerCase(charAt) ? CharsKt__CharKt.f(charAt) : String.valueOf(charAt));
            sb2.append(str2.substring(1));
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        if (str.length() > 0) {
            StringBuilder sb4 = new StringBuilder();
            char charAt2 = str.charAt(0);
            sb4.append(Character.isLowerCase(charAt2) ? CharsKt__CharKt.f(charAt2) : String.valueOf(charAt2));
            sb4.append(str.substring(1));
            str = sb4.toString();
        }
        sb3.append(str);
        sb3.append(' ');
        sb3.append(str2);
        return sb3.toString();
    }

    public static final String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
        }
    }

    public static final f0 d(Context context) {
        try {
            Object systemService = context.getSystemService("nfc");
            NfcAdapter nfcAdapter = null;
            NfcManager nfcManager = systemService instanceof NfcManager ? (NfcManager) systemService : null;
            if (nfcManager != null) {
                nfcAdapter = nfcManager.getDefaultAdapter();
            }
            if (nfcAdapter != null && nfcAdapter.isEnabled()) {
                return f0.b.f32060b;
            }
            if (nfcAdapter != null) {
                return f0.a.f32059b;
            }
            return f0.d.f32062b;
        } catch (Exception e11) {
            return new f0.c(e11);
        }
    }

    public static final void e(View view) {
        int i11 = R.id.ANIMATION_TAG;
        boolean z11 = true;
        if (!x.b(view.getTag(i11), 1)) {
            if (view.getVisibility() != 0) {
                z11 = false;
            }
            if (!z11) {
                view.setTag(i11, 1);
                view.setAlpha(0.0f);
                view.setVisibility(0);
                view.animate().alpha(1.0f).setDuration(100).withEndAction(new g1(view)).start();
            }
        }
    }

    public static final void f(View view) {
        view.setTag(R.id.ANIMATION_TAG, 0);
    }

    public static final boolean g(View view) {
        return view.postDelayed(new h1(view), (long) view.getResources().getInteger(17694720));
    }

    public static final void h(View view) {
        if (view.requestFocus()) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public static final class a extends AbstractMarkwonPlugin {

        /* renamed from: com.sumsub.sns.internal.core.common.i$a$a  reason: collision with other inner class name */
        public static final class C0326a extends LinkResolverDef {
            public void resolve(View view, String str) {
                try {
                    super.resolve(view, str);
                } catch (Exception unused) {
                    i.a(view.getContext(), Uri.parse(str));
                }
            }
        }

        public static final class b extends Lambda implements l<g, CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            public static final b f32069a = new b();

            public b() {
                super(1);
            }

            /* renamed from: a */
            public final CharSequence invoke(g gVar) {
                return "@@" + gVar.b().get(1) + "$$";
            }
        }

        public static final void a(b00.d dVar) {
            dVar.a(2, '@', DecodedChar.FNC1, j1.f32092a);
        }

        public void configure(d.b bVar) {
            bVar.a(b00.d.class, i1.f32084a);
        }

        public void configureConfiguration(b.C0649b bVar) {
            bVar.i(new C0326a());
        }

        public void configureTheme(a.C0676a aVar) {
            super.configureTheme(aVar);
            aVar.B(i.a(4));
            aVar.D(0);
        }

        public String processMarkdown(String str) {
            return new Regex("^><\\s*(.+\\S)\\s*$", RegexOption.MULTILINE).replace((CharSequence) str, (l<? super g, ? extends CharSequence>) b.f32069a);
        }

        public static final Object a(io.noties.markwon.b bVar, rz.c cVar) {
            return new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
        }
    }

    public static final String a(Object obj) {
        return obj.getClass().getSimpleName() + '@' + System.identityHashCode(obj);
    }

    public static final Spanned a(CharSequence charSequence, Context context) {
        try {
            Markwon markwon = f32068a;
            if (markwon == null) {
                markwon = Markwon.a(context).a(io.noties.markwon.html.a.b()).a(a00.a.c()).a(b00.d.b()).a(new a()).build();
                f32068a = markwon;
            }
            return markwon.b(charSequence.toString());
        } catch (Exception unused) {
            return new SpannableString(charSequence);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(android.net.Uri r23, android.content.Context r24, kotlin.coroutines.c<? super android.net.Uri> r25) {
        /*
            r0 = r24
            r1 = r25
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.common.i.d
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.common.i$d r2 = (com.sumsub.sns.internal.core.common.i.d) r2
            int r3 = r2.f32080e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f32080e = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.common.i$d r2 = new com.sumsub.sns.internal.core.common.i$d
            r2.<init>(r1)
        L_0x001c:
            java.lang.Object r1 = r2.f32079d
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f32080e
            r5 = 3
            r6 = 1
            r7 = 2
            r8 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 == r6) goto L_0x0053
            if (r4 == r7) goto L_0x0041
            if (r4 != r5) goto L_0x0039
            java.lang.Object r0 = r2.f32076a
            android.net.Uri r0 = (android.net.Uri) r0
            kotlin.k.b(r1)
            goto L_0x0100
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            java.lang.Object r0 = r2.f32077b
            android.net.Uri r0 = (android.net.Uri) r0
            java.lang.Object r4 = r2.f32076a
            android.content.Context r4 = (android.content.Context) r4
            kotlin.k.b(r1)
            r22 = r4
            r4 = r0
            r0 = r22
            goto L_0x00e7
        L_0x0053:
            java.lang.Object r0 = r2.f32078c
            android.database.Cursor r0 = (android.database.Cursor) r0
            java.lang.Object r4 = r2.f32077b
            android.net.Uri r4 = (android.net.Uri) r4
            java.lang.Object r6 = r2.f32076a
            android.content.Context r6 = (android.content.Context) r6
            kotlin.k.b(r1)
            r9 = r0
            r0 = r6
            goto L_0x00ca
        L_0x0065:
            kotlin.k.b(r1)
            java.lang.String r1 = "_data"
            java.lang.String[] r11 = new java.lang.String[]{r1}
            java.lang.String r4 = r23.toString()
            java.lang.String r9 = "content://com.android.gallery3d.provider"
            r15 = 0
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.M(r4, r9, r15, r7, r8)
            if (r4 == 0) goto L_0x0092
            java.lang.String r16 = r23.toString()
            r19 = 0
            r20 = 4
            r21 = 0
            java.lang.String r17 = "com.android.gallery3d"
            java.lang.String r18 = "com.google.android.gallery3d"
            java.lang.String r4 = kotlin.text.StringsKt__StringsJVMKt.G(r16, r17, r18, r19, r20, r21)
            android.net.Uri r4 = android.net.Uri.parse(r4)
            goto L_0x0094
        L_0x0092:
            r4 = r23
        L_0x0094:
            android.content.ContentResolver r9 = r24.getContentResolver()
            r12 = 0
            r13 = 0
            r14 = 0
            r10 = r4
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14)
            if (r9 == 0) goto L_0x00da
            int r10 = r9.getCount()
            if (r10 <= 0) goto L_0x00da
            int r1 = r9.getColumnIndex(r1)
            r9.moveToFirst()
            java.lang.String r10 = r4.toString()
            java.lang.String r11 = "content://com.sec.android.gallery3d"
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.M(r10, r11, r15, r7, r8)
            if (r7 == 0) goto L_0x00cd
            r2.f32076a = r0
            r2.f32077b = r4
            r2.f32078c = r9
            r2.f32080e = r6
            java.lang.Object r1 = b(r4, r0, r2)
            if (r1 != r3) goto L_0x00ca
            return r3
        L_0x00ca:
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x00d6
        L_0x00cd:
            r6 = -1
            if (r1 == r6) goto L_0x00d5
            java.lang.String r1 = r9.getString(r1)
            goto L_0x00d6
        L_0x00d5:
            r1 = r8
        L_0x00d6:
            r9.close()
            goto L_0x00e9
        L_0x00da:
            r2.f32076a = r0
            r2.f32077b = r4
            r2.f32080e = r7
            java.lang.Object r1 = b(r4, r0, r2)
            if (r1 != r3) goto L_0x00e7
            return r3
        L_0x00e7:
            java.lang.String r1 = (java.lang.String) r1
        L_0x00e9:
            r22 = r1
            r1 = r0
            r0 = r4
            r4 = r22
            if (r4 != 0) goto L_0x0103
            r2.f32076a = r0
            r2.f32077b = r8
            r2.f32078c = r8
            r2.f32080e = r5
            java.lang.Object r1 = b(r0, r1, r2)
            if (r1 != r3) goto L_0x0100
            return r3
        L_0x0100:
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
        L_0x0103:
            if (r4 == 0) goto L_0x010e
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
        L_0x010e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.c(android.net.Uri, android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }

    public static final int b(Context context) {
        try {
            return (int) r0.a.a(context.getPackageManager().getPackageInfo(context.getPackageName(), 0));
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final Object b(Uri uri, Context context, kotlin.coroutines.c<? super String> cVar) {
        return kotlinx.coroutines.g.g(v0.b(), new b(context, uri, (kotlin.coroutines.c<? super b>) null), cVar);
    }

    public static final /* synthetic */ <A, B, C> Map<A, Map<B, C>> d(Map<?, ?> map) {
        Set keySet;
        Map s11;
        Pair pair;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            x.f(2, "A");
            Pair pair2 = null;
            if (key != null) {
                Object value = next.getValue();
                Map map2 = value instanceof Map ? (Map) value : null;
                if (!(map2 == null || (keySet = map2.keySet()) == null)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object next2 : keySet) {
                        x.f(3, "B");
                        if (next2 instanceof Object) {
                            arrayList2.add(next2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object next3 : arrayList2) {
                        Object obj = map2.get(next3);
                        x.f(3, "C");
                        if (!(obj instanceof Object)) {
                            obj = null;
                        }
                        if (obj != null) {
                            x.f(1, "C");
                            pair = kotlin.l.a(next3, obj);
                        } else {
                            pair = null;
                        }
                        if (pair != null) {
                            arrayList3.add(pair);
                        }
                    }
                    if (!(!arrayList3.isEmpty())) {
                        arrayList3 = null;
                    }
                    if (!(arrayList3 == null || (s11 = MapsKt__MapsKt.s(arrayList3)) == null)) {
                        pair2 = kotlin.l.a(key, s11);
                    }
                }
            }
            if (pair2 != null) {
                arrayList.add(pair2);
            }
        }
        return MapsKt__MapsKt.s(arrayList);
    }

    public static final void b(View view, boolean z11) {
        view.setVisibility(z11 ? 0 : 4);
    }

    public static final void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x000d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <A, B> java.util.Map<A, B> e(java.util.Map<?, ?> r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x000d:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            r3 = 2
            java.lang.String r4 = "A"
            kotlin.jvm.internal.x.f(r3, r4)
            if (r2 != 0) goto L_0x0026
            goto L_0x0031
        L_0x0026:
            java.lang.Object r1 = r1.getValue()
            java.lang.String r4 = "B"
            kotlin.jvm.internal.x.f(r3, r4)
            if (r1 != 0) goto L_0x0033
        L_0x0031:
            r1 = 0
            goto L_0x0037
        L_0x0033:
            kotlin.Pair r1 = kotlin.l.a(r2, r1)
        L_0x0037:
            if (r1 == 0) goto L_0x000d
            r0.add(r1)
            goto L_0x000d
        L_0x003d:
            java.util.Map r5 = kotlin.collections.MapsKt__MapsKt.s(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.e(java.util.Map):java.util.Map");
    }

    public static final int a(int i11) {
        return (int) (((float) i11) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static final int b(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public static final float a(float f11) {
        return f11 * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final Locale a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0);
        }
        return Locale.getDefault();
    }

    public static final o b(Map<?, ?> map) {
        Object obj = map.get("regex");
        List list = null;
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("placeholders");
        List list2 = obj2 instanceof List ? (List) obj2 : null;
        if (list2 != null) {
            list = new ArrayList();
            for (Object next : list2) {
                if (next instanceof String) {
                    list.add(next);
                }
            }
        } else {
            Object obj3 = map.get("placeholder");
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            if (str2 != null) {
                list = CollectionsKt__CollectionsJVMKt.e(str2);
            }
        }
        return new o(list, str);
    }

    public static final String a(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        }
        return android.util.Base64.encodeToString(str.getBytes(kotlin.text.b.f56908b), 10);
    }

    public static final boolean a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception e11) {
                com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(context), "Error while opening activity", e11);
            }
        }
        return false;
    }

    public static final void b(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setVisibility(4);
            }
        }
    }

    public static final void c(View view) {
        int i11 = R.id.ANIMATION_TAG;
        boolean z11 = true;
        if (!x.b(view.getTag(i11), 1)) {
            if (view.getAlpha() != 1.0f) {
                z11 = false;
            }
            if (z11) {
                view.setTag(i11, 1);
                view.setAlpha(1.0f);
                view.animate().alpha(0.0f).setDuration(100).withEndAction(new f1(view)).start();
            }
        }
    }

    @SuppressLint({"DiscouragedApi"})
    public static final int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    public static /* synthetic */ CharSequence a(x0 x0Var, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return a(x0Var, str, str2, str3);
    }

    public static final void d(View view) {
        view.setVisibility(8);
        view.setTag(R.id.ANIMATION_TAG, 0);
    }

    public static final CharSequence a(x0 x0Var, String str, String str2, String str3) {
        CharSequence a11 = x0Var.a(str);
        if (a11 != null) {
            return a11;
        }
        CharSequence a12 = x0Var.a(str2);
        if (a12 != null) {
            return a12;
        }
        CharSequence a13 = str3 != null ? x0Var.a(str3) : null;
        return a13 == null ? "" : a13;
    }

    public static final String a(Uri uri, Context context) {
        String path = uri.getPath();
        if (path == null || path.length() == 0) {
            return null;
        }
        String type = context.getContentResolver().getType(uri);
        if (type != null) {
            return type;
        }
        try {
            return URLConnection.guessContentTypeFromName(new File(uri.getPath()).getName());
        } catch (Exception unused) {
            return type;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(android.content.Context r6, java.lang.String r7, android.net.Uri r8, kotlin.coroutines.c<? super android.net.Uri> r9) {
        /*
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.common.i.c
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.core.common.i$c r0 = (com.sumsub.sns.internal.core.common.i.c) r0
            int r1 = r0.f32075b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32075b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.common.i$c r0 = new com.sumsub.sns.internal.core.common.i$c
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f32074a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32075b
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L_0x003a
            if (r2 == r3) goto L_0x0035
            if (r2 != r5) goto L_0x002d
            kotlin.k.b(r9)
            goto L_0x0084
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.k.b(r9)
            goto L_0x009d
        L_0x003a:
            kotlin.k.b(r9)
            if (r7 != 0) goto L_0x0043
            java.lang.String r7 = a((android.net.Uri) r8, (android.content.Context) r6)
        L_0x0043:
            r9 = 0
            if (r7 == 0) goto L_0x004f
            int r2 = r7.length()
            if (r2 != 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r2 = r9
            goto L_0x0050
        L_0x004f:
            r2 = r3
        L_0x0050:
            if (r2 != 0) goto L_0x0094
            java.lang.String r2 = "image"
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r2, r9, r5, r4)
            if (r2 != 0) goto L_0x0094
            java.lang.String r2 = "/image"
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.v(r7, r2, r9, r5, r4)
            if (r7 == 0) goto L_0x0063
            goto L_0x0094
        L_0x0063:
            java.lang.String r7 = r8.toString()
            java.lang.String r2 = "content://"
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r2, r9, r5, r4)
            if (r7 != 0) goto L_0x007b
            java.lang.String r7 = r8.toString()
            java.lang.String r2 = "file://"
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.M(r7, r2, r9, r5, r4)
            if (r7 == 0) goto L_0x00a0
        L_0x007b:
            r0.f32075b = r5
            java.lang.Object r9 = b(r8, r6, r0)
            if (r9 != r1) goto L_0x0084
            return r1
        L_0x0084:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x008a
            r8 = r4
            goto L_0x00a0
        L_0x008a:
            java.io.File r6 = new java.io.File
            r6.<init>(r9)
            android.net.Uri r8 = android.net.Uri.fromFile(r6)
            goto L_0x00a0
        L_0x0094:
            r0.f32075b = r3
            java.lang.Object r9 = c(r8, r6, r0)
            if (r9 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r8 = r9
            android.net.Uri r8 = (android.net.Uri) r8
        L_0x00a0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.a(android.content.Context, java.lang.String, android.net.Uri, kotlin.coroutines.c):java.lang.Object");
    }

    public static final void c(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public static final Map<String, o> c(Map<String, ? extends Object> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            Pair pair = null;
            Map map2 = value instanceof Map ? (Map) value : null;
            o b11 = map2 != null ? b((Map<?, ?>) map2) : null;
            if (b11 != null) {
                pair = kotlin.l.a(str, b11);
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt__MapsKt.s(arrayList);
    }

    public static final void a(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
    }

    public static final void a(View view, boolean z11) {
        view.setVisibility(z11 ? 8 : 0);
    }

    public static /* synthetic */ void a(Integer num, Integer num2, Integer num3, Integer num4, View[] viewArr, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 2) != 0) {
            num2 = null;
        }
        if ((i11 & 4) != 0) {
            num3 = null;
        }
        if ((i11 & 8) != 0) {
            num4 = null;
        }
        a(num, num2, num3, num4, viewArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> T a(java.util.Map<java.lang.String, ? extends java.lang.Object> r8, java.lang.String r9, char r10) {
        /*
            r0 = 1
            char[] r2 = new char[r0]
            r7 = 0
            r2[r7] = r10
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r9
            java.util.List r9 = kotlin.text.StringsKt__StringsKt.K0(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r8
            int r8 = r9.size()
            int r8 = r8 - r0
            kotlin.ranges.h r8 = kotlin.ranges.RangesKt___RangesKt.o(r7, r8)
            java.util.Iterator r8 = r8.iterator()
        L_0x0023:
            boolean r0 = r8.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x008f
            r0 = r8
            kotlin.collections.IntIterator r0 = (kotlin.collections.IntIterator) r0
            int r0 = r0.a()
            T r2 = r10.element
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r0 = r9.get(r0)
            java.lang.Object r0 = r2.get(r0)
            boolean r2 = r0 instanceof java.util.Map
            if (r2 == 0) goto L_0x0044
            java.util.Map r0 = (java.util.Map) r0
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            if (r0 == 0) goto L_0x00a1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0054:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0085
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r5 = r4 instanceof java.lang.String
            if (r5 != 0) goto L_0x0069
            r4 = r1
        L_0x0069:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x006e
            goto L_0x0079
        L_0x006e:
            java.lang.Object r3 = r3.getValue()
            boolean r5 = r3 instanceof java.lang.Object
            if (r5 != 0) goto L_0x0077
            r3 = r1
        L_0x0077:
            if (r3 != 0) goto L_0x007b
        L_0x0079:
            r3 = r1
            goto L_0x007f
        L_0x007b:
            kotlin.Pair r3 = kotlin.l.a(r4, r3)
        L_0x007f:
            if (r3 == 0) goto L_0x0054
            r2.add(r3)
            goto L_0x0054
        L_0x0085:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r2)
            if (r0 != 0) goto L_0x008c
            goto L_0x00a1
        L_0x008c:
            r10.element = r0
            goto L_0x0023
        L_0x008f:
            T r8 = r10.element
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r9)
            java.lang.Object r1 = r8.get(r9)
            r8 = 2
            java.lang.String r9 = "T?"
            kotlin.jvm.internal.x.f(r8, r9)
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.a(java.util.Map, java.lang.String, char):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(java.util.Map r7, java.lang.String r8, char r9, int r10, java.lang.Object r11) {
        /*
            r11 = 2
            r10 = r10 & r11
            if (r10 == 0) goto L_0x0006
            r9 = 47
        L_0x0006:
            r10 = 1
            char[] r1 = new char[r10]
            r6 = 0
            r1[r6] = r9
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r8
            java.util.List r8 = kotlin.text.StringsKt__StringsKt.K0(r0, r1, r2, r3, r4, r5)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            r9.element = r7
            int r7 = r8.size()
            int r7 = r7 - r10
            kotlin.ranges.h r7 = kotlin.ranges.RangesKt___RangesKt.o(r6, r7)
            java.util.Iterator r7 = r7.iterator()
        L_0x0029:
            boolean r10 = r7.hasNext()
            r0 = 0
            if (r10 == 0) goto L_0x0095
            r10 = r7
            kotlin.collections.IntIterator r10 = (kotlin.collections.IntIterator) r10
            int r10 = r10.a()
            T r1 = r9.element
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r10 = r8.get(r10)
            java.lang.Object r10 = r1.get(r10)
            boolean r1 = r10 instanceof java.util.Map
            if (r1 == 0) goto L_0x004a
            java.util.Map r10 = (java.util.Map) r10
            goto L_0x004b
        L_0x004a:
            r10 = r0
        L_0x004b:
            if (r10 == 0) goto L_0x00a6
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x005a:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x008b
            java.lang.Object r2 = r10.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r4 = r3 instanceof java.lang.String
            if (r4 != 0) goto L_0x006f
            r3 = r0
        L_0x006f:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0074
            goto L_0x007f
        L_0x0074:
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof java.lang.Object
            if (r4 != 0) goto L_0x007d
            r2 = r0
        L_0x007d:
            if (r2 != 0) goto L_0x0081
        L_0x007f:
            r2 = r0
            goto L_0x0085
        L_0x0081:
            kotlin.Pair r2 = kotlin.l.a(r3, r2)
        L_0x0085:
            if (r2 == 0) goto L_0x005a
            r1.add(r2)
            goto L_0x005a
        L_0x008b:
            java.util.Map r10 = kotlin.collections.MapsKt__MapsKt.s(r1)
            if (r10 != 0) goto L_0x0092
            goto L_0x00a6
        L_0x0092:
            r9.element = r10
            goto L_0x0029
        L_0x0095:
            T r7 = r9.element
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r8)
            java.lang.Object r0 = r7.get(r8)
            java.lang.String r7 = "T?"
            kotlin.jvm.internal.x.f(r11, r7)
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.a(java.util.Map, java.lang.String, char, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0047 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> T a(java.util.Map<java.lang.String, ? extends java.lang.Object> r7, java.util.List<java.lang.String> r8) {
        /*
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r0.element = r7
            int r7 = r8.size()
            int r7 = r7 + -1
            r1 = 0
            kotlin.ranges.h r7 = kotlin.ranges.RangesKt___RangesKt.o(r1, r7)
            java.util.Iterator r7 = r7.iterator()
        L_0x0016:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0083
            r1 = r7
            kotlin.collections.IntIterator r1 = (kotlin.collections.IntIterator) r1
            int r1 = r1.a()
            T r2 = r0.element
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r1 = r8.get(r1)
            java.lang.Object r1 = r2.get(r1)
            boolean r2 = r1 instanceof java.util.Map
            r3 = 0
            if (r2 == 0) goto L_0x0037
            java.util.Map r1 = (java.util.Map) r1
            goto L_0x0038
        L_0x0037:
            r1 = r3
        L_0x0038:
            if (r1 == 0) goto L_0x0082
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0047:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0078
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 != 0) goto L_0x005c
            r5 = r3
        L_0x005c:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x0061
            goto L_0x006c
        L_0x0061:
            java.lang.Object r4 = r4.getValue()
            boolean r6 = r4 instanceof java.lang.Object
            if (r6 != 0) goto L_0x006a
            r4 = r3
        L_0x006a:
            if (r4 != 0) goto L_0x006e
        L_0x006c:
            r4 = r3
            goto L_0x0072
        L_0x006e:
            kotlin.Pair r4 = kotlin.l.a(r5, r4)
        L_0x0072:
            if (r4 == 0) goto L_0x0047
            r2.add(r4)
            goto L_0x0047
        L_0x0078:
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r2)
            if (r1 != 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            r0.element = r1
            goto L_0x0016
        L_0x0082:
            return r3
        L_0x0083:
            T r7 = r0.element
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r8)
            java.lang.Object r7 = r7.get(r8)
            r8 = 2
            java.lang.String r0 = "T"
            kotlin.jvm.internal.x.f(r8, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.i.a(java.util.Map, java.util.List):java.lang.Object");
    }

    public static final ColorStateList a(TypedArray typedArray, Context context, int i11) {
        switch (typedArray.getType(i11)) {
            case 28:
            case 29:
            case 30:
            case 31:
                return ColorStateList.valueOf(typedArray.getColor(i11, 0));
            default:
                int resourceId = typedArray.getResourceId(i11, -1);
                if (resourceId != -1) {
                    return c.a.a(context, resourceId);
                }
                return ColorStateList.valueOf(0);
        }
    }

    public static final boolean a(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }

    public static final float a(View view) {
        return view.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final int a(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public static final <K, V> Map<K, V> a(Map<K, ? extends V> map, K k11, V v11) {
        if (v11 == null && !map.containsKey(k11)) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        if (v11 == null) {
            linkedHashMap.remove(k11);
        } else {
            linkedHashMap.put(k11, v11);
        }
        return linkedHashMap;
    }

    public static final FragmentActivity a(Context context) {
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
            if (baseContext instanceof FragmentActivity) {
                return (FragmentActivity) baseContext;
            }
        }
        return null;
    }

    public static final void a(TextView textView, CharSequence charSequence) {
        if (charSequence == null || StringsKt__StringsJVMKt.z(charSequence)) {
            textView.setVisibility(8);
            textView.setText((CharSequence) null);
            return;
        }
        textView.setText(charSequence);
        textView.setVisibility(0);
    }

    public static final void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception unused) {
        }
    }

    public static final <T> List<T> a(List<? extends T> list) {
        return Collections.unmodifiableList(CollectionsKt___CollectionsKt.L0(list));
    }

    public static final void a(ViewGroup viewGroup) {
        LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
        if (layoutTransition != null) {
            layoutTransition.enableTransitionType(4);
            layoutTransition.setDuration(100);
        }
    }

    public static final List<Document> a(List<Document> list, com.sumsub.sns.internal.core.data.model.g gVar) {
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            Document document = (Document) next;
            boolean z11 = false;
            if (gVar.I().k()) {
                List<String> j11 = gVar.I().j();
                if (!(j11 != null && j11.contains(document.getType().c()))) {
                    z11 = true;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static final void a(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public static final void a(Integer num, Integer num2, Integer num3, Integer num4, View... viewArr) {
        int length = viewArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            View view = viewArr[i11];
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams != null) {
                if (num != null) {
                    marginLayoutParams.setMarginStart(num.intValue());
                }
                if (num2 != null) {
                    marginLayoutParams.setMarginEnd(num2.intValue());
                }
                if (num3 != null) {
                    marginLayoutParams.topMargin = num3.intValue();
                }
                if (num4 != null) {
                    marginLayoutParams.bottomMargin = num4.intValue();
                }
            }
        }
    }

    public static final <A, B> Map<A, B> a(Map<A, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final void a(ImageView imageView, Drawable drawable) {
        if (drawable == null) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(0);
    }
}
