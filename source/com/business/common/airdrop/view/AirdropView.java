package com.business.common.airdrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.j;
import androidx.lifecycle.v;
import androidx.lifecycle.z;
import com.business.common.R$raw;
import com.business.common.R$string;
import com.business.common.R$styleable;
import com.business.common.airdrop.AirdropManager;
import com.business.common.airdrop.data.AirdropCloseIdBean;
import com.business.common.airdrop.data.AirdropHeaderBean;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import i4.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.f;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class AirdropView extends FrameLayout implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final k f64305b;

    /* renamed from: c  reason: collision with root package name */
    public final List<n1> f64306c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<FragmentActivity> f64307d;

    /* renamed from: e  reason: collision with root package name */
    public int f64308e;

    /* renamed from: f  reason: collision with root package name */
    public String f64309f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64310g;

    /* renamed from: h  reason: collision with root package name */
    public String f64311h;

    /* renamed from: i  reason: collision with root package name */
    public String f64312i;

    /* renamed from: j  reason: collision with root package name */
    public long f64313j;

    /* renamed from: k  reason: collision with root package name */
    public String f64314k;

    /* renamed from: l  reason: collision with root package name */
    public int f64315l;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64316a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.business.common.airdrop.data.AirdropBusinessId[] r0 = com.business.common.airdrop.data.AirdropBusinessId.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.business.common.airdrop.data.AirdropBusinessId r1 = com.business.common.airdrop.data.AirdropBusinessId.OPEN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.business.common.airdrop.data.AirdropBusinessId r1 = com.business.common.airdrop.data.AirdropBusinessId.CLOSE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f64316a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.view.AirdropView.a.<clinit>():void");
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f64317b;

        public b(l lVar) {
            this.f64317b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f64317b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f64317b.invoke(obj);
        }
    }

    public AirdropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    public AirdropView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k K = k.K(LayoutInflater.from(context));
        this.f64305b = K;
        this.f64306c = new ArrayList();
        this.f64308e = -1;
        this.f64309f = "";
        this.f64311h = "";
        this.f64312i = "";
        this.f64313j = Calendar.getInstance(TimeZone.getTimeZone(UtcDates.UTC)).getTimeInMillis();
        this.f64314k = "";
        this.f64315l = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AirdropView);
        this.f64308e = obtainStyledAttributes.getInt(R$styleable.AirdropView_topicType, -1);
        obtainStyledAttributes.recycle();
        addView(K.getRoot());
        E(this, (AirdropDetailBean) null, 0, (String) null, 7, (Object) null);
        x();
    }

    public static /* synthetic */ void E(AirdropView airdropView, AirdropDetailBean airdropDetailBean, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            airdropDetailBean = null;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            str = "";
        }
        airdropView.D(airdropDetailBean, i11, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r4 = r11.getFirstTimeMillis();
     */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void F(com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r11, com.business.common.airdrop.view.AirdropView r12, int r13, java.lang.String r14, android.view.View r15) {
        /*
            java.lang.String r0 = "UTC"
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)
            long r0 = r0.getTimeInMillis()
            r2 = 0
            if (r11 == 0) goto L_0x001d
            java.lang.Long r4 = r11.getFirstTimeMillis()
            if (r4 == 0) goto L_0x001d
            long r4 = r4.longValue()
            goto L_0x001e
        L_0x001d:
            r4 = r2
        L_0x001e:
            r6 = 0
            if (r11 == 0) goto L_0x0032
            com.hbg.lib.network.hbg.core.bean.AirdropRuleBean r7 = r11.getRule()
            if (r7 == 0) goto L_0x0032
            java.lang.Integer r7 = r7.getPrizeTime()
            if (r7 == 0) goto L_0x0032
            int r7 = r7.intValue()
            goto L_0x0033
        L_0x0032:
            r7 = r6
        L_0x0033:
            r8 = 1000(0x3e8, float:1.401E-42)
            int r7 = r7 * r8
            long r9 = (long) r7
            long r4 = r4 + r9
            long r4 = r4 - r0
            long r0 = (long) r8
            long r4 = r4 / r0
            r0 = 3
            kotlin.Pair[] r1 = new kotlin.Pair[r0]
            java.lang.String r7 = "location"
            java.lang.String r8 = "app_community_square_sideways"
            kotlin.Pair r7 = kotlin.l.a(r7, r8)
            r1[r6] = r7
            java.lang.String r7 = "button_name"
            java.lang.String r8 = "sideways_close"
            kotlin.Pair r7 = kotlin.l.a(r7, r8)
            r8 = 1
            r1[r8] = r7
            boolean r7 = r12.z()
            if (r7 != 0) goto L_0x005d
            java.lang.String r4 = "1"
            goto L_0x0066
        L_0x005d:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0064
            java.lang.String r4 = "2"
            goto L_0x0066
        L_0x0064:
            java.lang.String r4 = "3"
        L_0x0066:
            java.lang.String r5 = "button_state"
            kotlin.Pair r4 = kotlin.l.a(r5, r4)
            r5 = 2
            r1[r5] = r4
            java.util.HashMap r1 = kotlin.collections.MapsKt__MapsKt.j(r1)
            java.lang.String r4 = "app_community_sideways_click"
            com.hbg.module.libkt.helper.SensorsDataHelper.track(r4, r1)
            if (r11 == 0) goto L_0x0097
            boolean r1 = r12.z()
            if (r1 == 0) goto L_0x0092
            com.business.common.airdrop.AirdropManager r1 = com.business.common.airdrop.AirdropManager.f64272a
            long r7 = r1.c(r11)
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x008e
            r1.r(r13, r14, r6, r5)
            goto L_0x0097
        L_0x008e:
            r1.r(r13, r14, r6, r0)
            goto L_0x0097
        L_0x0092:
            com.business.common.airdrop.AirdropManager r0 = com.business.common.airdrop.AirdropManager.f64272a
            r0.r(r13, r14, r6, r8)
        L_0x0097:
            java.lang.ref.WeakReference<androidx.fragment.app.FragmentActivity> r0 = r12.f64307d
            if (r0 == 0) goto L_0x00a2
            java.lang.Object r0 = r0.get()
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            goto L_0x00a3
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            if (r0 == 0) goto L_0x0108
            android.content.Context r1 = r12.getContext()
            int r2 = com.business.common.R$string.staring_remind
            java.lang.String r1 = r1.getString(r2)
            android.content.Context r2 = r12.getContext()
            int r3 = com.business.common.R$string.n_airdrop_dialog_close_content
            java.lang.String r2 = r2.getString(r3)
            android.content.Context r3 = r12.getContext()
            int r4 = com.business.common.R$string.string_confirm
            java.lang.String r3 = r3.getString(r4)
            android.content.Context r4 = r12.getContext()
            int r5 = com.business.common.R$string.string_cancel
            java.lang.String r4 = r4.getString(r5)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r5 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
            r5.<init>(r0)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r5.c1(r1)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.C0(r2)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r1 = r1.s0(r3)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r7 = r1.P0(r4)
            com.business.common.airdrop.view.f r8 = new com.business.common.airdrop.view.f
            r1 = r8
            r2 = r11
            r3 = r13
            r4 = r14
            r5 = r12
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r12 = r7.N0(r8)
            com.business.common.airdrop.view.e r1 = new com.business.common.airdrop.view.e
            r1.<init>(r11, r13, r14)
            com.hbg.lib.widgets.dialog.DialogUtils$b$d r11 = r12.Q0(r1)
            com.hbg.lib.widgets.dialog.HBDialogFragment r11 = r11.j0()
            androidx.fragment.app.FragmentManager r12 = r0.getSupportFragmentManager()
            java.lang.String r13 = "AirdropCloseDialog"
            r11.show(r12, r13)
            goto L_0x010b
        L_0x0108:
            r12.x()
        L_0x010b:
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.view.AirdropView.F(com.hbg.lib.network.hbg.core.bean.AirdropDetailBean, com.business.common.airdrop.view.AirdropView, int, java.lang.String, android.view.View):void");
    }

    public static final void G(AirdropDetailBean airdropDetailBean, int i11, String str, AirdropView airdropView, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        if (airdropDetailBean != null) {
            AirdropManager.f64272a.q(i11, str, 1);
        }
        SensorsDataHelper.track("app_community_sideways_click", MapsKt__MapsKt.j(kotlin.l.a("location", "app_community_square_sideways"), kotlin.l.a("button_name", "remind_confirm")));
        hBDialogFragment.dismiss();
        airdropView.x();
        n1 unused = i.d(v.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new AirdropView$setCloseListener$1$dialog$1$1(airdropView, (c<? super AirdropView$setCloseListener$1$dialog$1$1>) null), 3, (Object) null);
    }

    public static final void H(AirdropDetailBean airdropDetailBean, int i11, String str, HBDialogFragment hBDialogFragment) {
        if (airdropDetailBean != null) {
            AirdropManager.f64272a.q(i11, str, 2);
        }
        SensorsDataHelper.track("app_community_sideways_click", MapsKt__MapsKt.j(kotlin.l.a("location", "app_community_square_sideways"), kotlin.l.a("button_name", "remind_cancel")));
        hBDialogFragment.dismiss();
    }

    public static final void J(Throwable th2) {
    }

    @SensorsDataInstrumented
    public static final void K(long j11, AirdropDetailBean airdropDetailBean, int i11, String str, AirdropView airdropView, View view) {
        FragmentActivity fragmentActivity;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = kotlin.l.a("location", "app_community_square_sideways");
        pairArr[1] = kotlin.l.a("button_name", "sideways_blue");
        pairArr[2] = kotlin.l.a("button_state", j11 > 0 ? "3" : "2");
        SensorsDataHelper.track("app_community_sideways_click", MapsKt__MapsKt.j(pairArr));
        AirdropManager airdropManager = AirdropManager.f64272a;
        if (airdropManager.c(airdropDetailBean) > 0) {
            airdropManager.r(i11, str, true, 2);
        } else {
            airdropManager.r(i11, str, true, 3);
        }
        WeakReference<FragmentActivity> weakReference = airdropView.f64307d;
        if (!(weakReference == null || (fragmentActivity = (FragmentActivity) weakReference.get()) == null)) {
            Integer awarded = airdropDetailBean.getAwarded();
            if (awarded != null && awarded.intValue() == 1) {
                airdropView.B(airdropDetailBean);
            } else {
                airdropManager.o(fragmentActivity.getSupportFragmentManager(), airdropDetailBean, i11, str);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void L(int i11, String str, AirdropView airdropView, View view) {
        FragmentActivity fragmentActivity;
        BaseModuleConfig.a a11;
        SensorsDataHelper.track("app_community_sideways_click", MapsKt__MapsKt.j(kotlin.l.a("location", "app_community_square_sideways"), kotlin.l.a("button_name", "sideways_blue"), kotlin.l.a("button_state", "1")));
        AirdropManager.f64272a.r(i11, str, true, 1);
        WeakReference<FragmentActivity> weakReference = airdropView.f64307d;
        if (!(weakReference == null || (fragmentActivity = (FragmentActivity) weakReference.get()) == null || (a11 = BaseModuleConfig.a()) == null)) {
            a11.m0(fragmentActivity);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = (androidx.fragment.app.FragmentActivity) r1.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "空投-"
            r0.append(r1)
            java.lang.ref.WeakReference<androidx.fragment.app.FragmentActivity> r1 = r3.f64307d
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r1.get()
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            if (r1 == 0) goto L_0x0020
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            java.lang.String r2 = "--"
            if (r1 != 0) goto L_0x0026
            r1 = r2
        L_0x0026:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            if (r4 != 0) goto L_0x0030
            r4 = r2
        L_0x0030:
            android.util.Log.d(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.view.AirdropView.A(java.lang.String):void");
    }

    public final void B(AirdropDetailBean airdropDetailBean) {
        FragmentActivity fragmentActivity;
        WeakReference<FragmentActivity> weakReference = this.f64307d;
        if (weakReference != null && (fragmentActivity = (FragmentActivity) weakReference.get()) != null) {
            n1 unused = i.d(v.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new AirdropView$openResult$1$1(this, fragmentActivity, airdropDetailBean, (c<? super AirdropView$openResult$1$1>) null), 3, (Object) null);
        }
    }

    public final void C() {
        for (n1 next : this.f64306c) {
            if (next != null && next.isActive()) {
                n1.a.a(next, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    public final void D(AirdropDetailBean airdropDetailBean, int i11, String str) {
        this.f64305b.B.setOnClickListener(new c(airdropDetailBean, this, i11, str));
    }

    public final void I(long j11, String str, AirdropDetailBean airdropDetailBean, int i11, String str2) {
        FragmentActivity fragmentActivity;
        LifecycleCoroutineScope a11;
        String str3 = str;
        AirdropDetailBean airdropDetailBean2 = airdropDetailBean;
        int i12 = i11;
        String str4 = str2;
        C();
        D(airdropDetailBean2, i12, str4);
        AirdropManager.f64272a.s(i12, str4);
        k kVar = this.f64305b;
        kVar.C.setFailureListener(d.f64330a);
        n1 n1Var = null;
        if (!x.b(this.f64314k, str3)) {
            kVar.C.cancelAnimation();
            A("动画地址 : " + str3);
            if ((str.length() == 0) || !StringsKt__StringsJVMKt.v(str3, ".json", false, 2, (Object) null)) {
                kVar.C.setAnimation(R$raw.airdrop_animation_side);
            } else {
                kVar.C.setAnimationFromUrl(str3, str3);
                kVar.C.setRepeatCount(-1);
                kVar.C.setRepeatMode(1);
                kVar.C.playAnimation();
            }
            this.f64314k = str3;
        }
        if (z()) {
            kVar.getRoot().setOnClickListener(new b(j11, airdropDetailBean, i11, str2, this));
        } else {
            kVar.D.setText(getContext().getString(R$string.n_airdrop_login));
            kVar.getRoot().setOnClickListener(new a(i12, str4, this));
        }
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = j11;
        WeakReference<FragmentActivity> weakReference = this.f64307d;
        if (!(weakReference == null || (fragmentActivity = (FragmentActivity) weakReference.get()) == null || (a11 = v.a(fragmentActivity)) == null)) {
            n1Var = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AirdropView$showClaimCountdown$job$1(ref$LongRef, this, airdropDetailBean2, (c<? super AirdropView$showClaimCountdown$job$1>) null), 3, (Object) null);
        }
        this.f64306c.add(n1Var);
        SensorsDataHelper.track("app_community_sideways_show", MapsKt__MapsKt.j(kotlin.l.a("location", "app_community_square_sideways")));
        this.f64305b.getRoot().setVisibility(0);
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        j.a(this, lifecycleOwner);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        j.b(this, lifecycleOwner);
        A("onDestroy");
        C();
        lifecycleOwner.getLifecycle().d(this);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        j.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        j.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        j.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        j.f(this, lifecycleOwner);
    }

    public final void q(FragmentActivity fragmentActivity) {
        FragmentActivity fragmentActivity2;
        FragmentActivity fragmentActivity3;
        Lifecycle lifecycle;
        this.f64307d = new WeakReference<>(fragmentActivity);
        A("绑定生命周期");
        WeakReference<FragmentActivity> weakReference = this.f64307d;
        if (!(weakReference == null || (fragmentActivity3 = (FragmentActivity) weakReference.get()) == null || (lifecycle = fragmentActivity3.getLifecycle()) == null)) {
            lifecycle.a(this);
        }
        WeakReference<FragmentActivity> weakReference2 = this.f64307d;
        if (weakReference2 != null && (fragmentActivity2 = (FragmentActivity) weakReference2.get()) != null) {
            AirdropManager airdropManager = AirdropManager.f64272a;
            airdropManager.i().observe(fragmentActivity2, new b(new AirdropView$bind$1$1(fragmentActivity2, this)));
            airdropManager.g().observe(fragmentActivity2, new b(new AirdropView$bind$1$2(fragmentActivity2, this)));
            airdropManager.h().observe(fragmentActivity2, new b(new AirdropView$bind$1$3(fragmentActivity2, this)));
        }
    }

    public final void r(String str) {
        this.f64311h = str;
        this.f64309f = str;
        A("绑定TopicType : " + this.f64308e + " , DynamicId : " + str);
    }

    public final void s(boolean z11) {
        if (this.f64310g != z11) {
            this.f64310g = z11;
            if (z11) {
                AirdropManager.f64272a.i().g(new AirdropHeaderBean("", String.valueOf(this.f64308e), "", 1));
            } else {
                k kVar = this.f64305b;
                if (kVar.getRoot().getVisibility() != 8) {
                    kVar.getRoot().setVisibility(8);
                }
            }
            A("绑定TopicType : " + this.f64308e + " , stickyHeader : " + z11);
        }
    }

    public final void t(String str) {
        this.f64312i = str;
        this.f64309f = str;
        A("绑定TopicType : " + this.f64308e + " , Symbol : " + str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(com.business.common.airdrop.data.AirdropChannelBean r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getTopicType()
            if (r0 == 0) goto L_0x0011
            java.lang.Integer r0 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r0)
            if (r0 == 0) goto L_0x0011
            int r0 = r0.intValue()
            goto L_0x0012
        L_0x0011:
            r0 = -1
        L_0x0012:
            java.util.List r1 = r9.getTopicIdList()
            if (r1 == 0) goto L_0x003f
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0027:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0043
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.toLowerCase(r4)
            r2.add(r3)
            goto L_0x0027
        L_0x003f:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0043:
            int r1 = r8.f64308e
            if (r1 != r0) goto L_0x017a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "TopicType("
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = ") Channel 处理 : "
            r1.append(r3)
            java.lang.String r3 = com.hbg.module.libkt.base.ext.f.f(r9)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r8.A(r1)
            com.business.common.airdrop.data.AirdropBusinessId r1 = r9.getBusinessID()
            int[] r3 = com.business.common.airdrop.view.AirdropView.a.f64316a
            int r1 = r1.ordinal()
            r1 = r3[r1]
            r3 = 28
            r4 = 24
            r5 = 20
            r6 = 4
            r7 = 1
            if (r1 == r7) goto L_0x00c4
            r9 = 2
            if (r1 == r9) goto L_0x0082
            goto L_0x017a
        L_0x0082:
            if (r0 == r6) goto L_0x00b1
            if (r0 == r5) goto L_0x00ac
            if (r0 == r4) goto L_0x00a7
            if (r0 == r3) goto L_0x008c
            goto L_0x017a
        L_0x008c:
            java.lang.String r9 = r8.f64312i
            java.util.Locale r10 = java.util.Locale.getDefault()
            java.lang.String r9 = r9.toLowerCase(r10)
            boolean r9 = r2.contains(r9)
            if (r9 != 0) goto L_0x00a2
            boolean r9 = r2.isEmpty()
            if (r9 == 0) goto L_0x017a
        L_0x00a2:
            r8.x()
            goto L_0x017a
        L_0x00a7:
            r8.x()
            goto L_0x017a
        L_0x00ac:
            r8.x()
            goto L_0x017a
        L_0x00b1:
            java.lang.String r9 = r8.f64311h
            boolean r9 = r2.contains(r9)
            if (r9 != 0) goto L_0x00bf
            boolean r9 = r2.isEmpty()
            if (r9 == 0) goto L_0x017a
        L_0x00bf:
            r8.x()
            goto L_0x017a
        L_0x00c4:
            if (r0 == r6) goto L_0x014b
            java.lang.String r1 = ""
            if (r0 == r5) goto L_0x012c
            if (r0 == r4) goto L_0x0107
            if (r0 == r3) goto L_0x00d0
            goto L_0x017a
        L_0x00d0:
            java.lang.String r1 = r8.f64312i
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.toLowerCase(r3)
            boolean r1 = r2.contains(r1)
            if (r1 != 0) goto L_0x00e6
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x017a
        L_0x00e6:
            com.business.common.airdrop.data.AirdropHeaderBean r1 = new com.business.common.airdrop.data.AirdropHeaderBean
            java.lang.String r9 = r9.getGroupId()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r8.f64312i
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.a.c(r7)
            r1.<init>(r9, r0, r2, r3)
            java.lang.Object r9 = r8.w(r1, r10)
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r9 != r10) goto L_0x0104
            return r9
        L_0x0104:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x0107:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x017a
            com.business.common.airdrop.data.AirdropHeaderBean r2 = new com.business.common.airdrop.data.AirdropHeaderBean
            java.lang.String r9 = r9.getGroupId()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.a.c(r7)
            r2.<init>(r9, r0, r1, r3)
            java.lang.Object r9 = r8.w(r2, r10)
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r9 != r10) goto L_0x0129
            return r9
        L_0x0129:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x012c:
            com.business.common.airdrop.data.AirdropHeaderBean r2 = new com.business.common.airdrop.data.AirdropHeaderBean
            java.lang.String r9 = r9.getGroupId()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.a.c(r7)
            r2.<init>(r9, r0, r1, r3)
            java.lang.Object r9 = r8.w(r2, r10)
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r9 != r10) goto L_0x0148
            return r9
        L_0x0148:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x014b:
            java.lang.String r1 = r8.f64311h
            boolean r1 = r2.contains(r1)
            if (r1 != 0) goto L_0x0159
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x017a
        L_0x0159:
            com.business.common.airdrop.data.AirdropHeaderBean r1 = new com.business.common.airdrop.data.AirdropHeaderBean
            java.lang.String r9 = r9.getGroupId()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r8.f64311h
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.a.c(r7)
            r1.<init>(r9, r0, r2, r3)
            java.lang.Object r9 = r8.w(r1, r10)
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r9 != r10) goto L_0x0177
            return r9
        L_0x0177:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x017a:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.view.AirdropView.u(com.business.common.airdrop.data.AirdropChannelBean, kotlin.coroutines.c):java.lang.Object");
    }

    public final void v(AirdropCloseIdBean airdropCloseIdBean) {
        if (-1 != this.f64315l && -1 != airdropCloseIdBean.getId() && airdropCloseIdBean.getId() == this.f64315l) {
            x();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0138, code lost:
        if (y(r5) != false) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013a, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013c, code lost:
        if (1 == r13) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0143, code lost:
        if (r0.f64310g != false) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0159, code lost:
        if (kotlin.jvm.internal.x.b(r5, r0.f64311h) != false) goto L_0x013a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0224 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x024b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ff A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w(com.business.common.airdrop.data.AirdropHeaderBean r25, kotlin.coroutines.c<? super kotlin.Unit> r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            boolean r2 = r1 instanceof com.business.common.airdrop.view.AirdropView$handleHeader$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.business.common.airdrop.view.AirdropView$handleHeader$1 r2 = (com.business.common.airdrop.view.AirdropView$handleHeader$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.business.common.airdrop.view.AirdropView$handleHeader$1 r2 = new com.business.common.airdrop.view.AirdropView$handleHeader$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.label
            r6 = 5
            r7 = 3
            r8 = 4
            r9 = 2
            r10 = 41
            java.lang.String r11 = ""
            java.lang.String r12 = "Airdrop"
            r14 = 1
            if (r4 == 0) goto L_0x00a2
            if (r4 == r14) goto L_0x0093
            if (r4 == r9) goto L_0x007e
            if (r4 == r7) goto L_0x006b
            if (r4 == r8) goto L_0x0057
            if (r4 != r6) goto L_0x004f
            int r3 = r2.I$0
            java.lang.Object r4 = r2.L$2
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r4 = (com.hbg.lib.network.hbg.core.bean.AirdropDetailBean) r4
            java.lang.Object r6 = r2.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r2.L$0
            com.business.common.airdrop.view.AirdropView r2 = (com.business.common.airdrop.view.AirdropView) r2
            kotlin.k.b(r1)
            r15 = r2
            goto L_0x024e
        L_0x004f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0057:
            int r4 = r2.I$0
            java.lang.Object r7 = r2.L$2
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r7 = (com.hbg.lib.network.hbg.core.bean.AirdropDetailBean) r7
            java.lang.Object r8 = r2.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r15 = r2.L$0
            com.business.common.airdrop.view.AirdropView r15 = (com.business.common.airdrop.view.AirdropView) r15
            kotlin.k.b(r1)
            r6 = r8
            goto L_0x0227
        L_0x006b:
            int r4 = r2.I$0
            java.lang.Object r7 = r2.L$2
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r7 = (com.hbg.lib.network.hbg.core.bean.AirdropDetailBean) r7
            java.lang.Object r15 = r2.L$1
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r5 = r2.L$0
            com.business.common.airdrop.view.AirdropView r5 = (com.business.common.airdrop.view.AirdropView) r5
            kotlin.k.b(r1)
            goto L_0x0201
        L_0x007e:
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$2
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r5 = (com.hbg.lib.network.hbg.core.bean.AirdropDetailBean) r5
            java.lang.Object r15 = r2.L$1
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r13 = r2.L$0
            com.business.common.airdrop.view.AirdropView r13 = (com.business.common.airdrop.view.AirdropView) r13
            kotlin.k.b(r1)
            r1 = r5
        L_0x0090:
            r5 = r13
            goto L_0x01dc
        L_0x0093:
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r13 = r2.L$0
            com.business.common.airdrop.view.AirdropView r13 = (com.business.common.airdrop.view.AirdropView) r13
            kotlin.k.b(r1)
            goto L_0x0185
        L_0x00a2:
            kotlin.k.b(r1)
            java.lang.String r1 = r25.getTopicType()
            if (r1 == 0) goto L_0x00b7
            java.lang.Integer r1 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r1)
            if (r1 == 0) goto L_0x00b7
            int r1 = r1.intValue()
            r4 = r1
            goto L_0x00b8
        L_0x00b7:
            r4 = -1
        L_0x00b8:
            int r1 = r0.f64308e
            if (r4 != r1) goto L_0x03cc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "TopicType("
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = ") Header 处理 : "
            r1.append(r5)
            java.lang.String r5 = com.hbg.module.libkt.base.ext.f.f(r25)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.A(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "HandleHeader("
            r1.append(r5)
            java.lang.String r5 = com.hbg.module.libkt.base.ext.f.f(r25)
            r1.append(r5)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r1)
            com.business.common.airdrop.AirdropManager r1 = com.business.common.airdrop.AirdropManager.f64272a
            java.lang.String r5 = r25.getGroupId()
            java.lang.String r13 = r25.getTopicType()
            r1.f(r5, r13)
            java.lang.String r5 = r25.getTopicId()
            if (r5 != 0) goto L_0x010b
            r5 = r11
        L_0x010b:
            java.lang.Integer r13 = r25.getHasAirdrop()
            if (r13 == 0) goto L_0x0116
            int r13 = r13.intValue()
            goto L_0x0117
        L_0x0116:
            r13 = 0
        L_0x0117:
            if (r4 == r8) goto L_0x0146
            r15 = 20
            if (r4 == r15) goto L_0x013f
            r15 = 24
            if (r4 == r15) goto L_0x013c
            r15 = 28
            if (r4 == r15) goto L_0x0127
        L_0x0125:
            r13 = 0
            goto L_0x015c
        L_0x0127:
            if (r14 != r13) goto L_0x0125
            int r13 = r5.length()
            if (r13 <= 0) goto L_0x0131
            r13 = r14
            goto L_0x0132
        L_0x0131:
            r13 = 0
        L_0x0132:
            if (r13 == 0) goto L_0x0125
            boolean r13 = r0.y(r5)
            if (r13 == 0) goto L_0x0125
        L_0x013a:
            r13 = r14
            goto L_0x015c
        L_0x013c:
            if (r14 != r13) goto L_0x0125
            goto L_0x013a
        L_0x013f:
            if (r14 != r13) goto L_0x0125
            boolean r13 = r0.f64310g
            if (r13 == 0) goto L_0x0125
            goto L_0x013a
        L_0x0146:
            if (r14 != r13) goto L_0x0125
            int r13 = r5.length()
            if (r13 <= 0) goto L_0x0150
            r13 = r14
            goto L_0x0151
        L_0x0150:
            r13 = 0
        L_0x0151:
            if (r13 == 0) goto L_0x0125
            java.lang.String r13 = r0.f64311h
            boolean r13 = kotlin.jvm.internal.x.b(r5, r13)
            if (r13 == 0) goto L_0x0125
            goto L_0x013a
        L_0x015c:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "HandleHeader-isShow("
            r15.append(r6)
            r15.append(r13)
            r15.append(r10)
            java.lang.String r6 = r15.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r6)
            if (r13 == 0) goto L_0x03c9
            r2.L$0 = r0
            r2.L$1 = r5
            r2.I$0 = r4
            r2.label = r14
            java.lang.Object r1 = r1.l(r4, r5, r2)
            if (r1 != r3) goto L_0x0184
            return r3
        L_0x0184:
            r13 = r0
        L_0x0185:
            com.hbg.module.libkt.base.ext.g r1 = (com.hbg.module.libkt.base.ext.g) r1
            boolean r6 = r1 instanceof com.hbg.module.libkt.base.ext.g.b
            if (r6 == 0) goto L_0x0370
            com.hbg.module.libkt.base.ext.g$b r1 = (com.hbg.module.libkt.base.ext.g.b) r1
            java.lang.Object r1 = r1.a()
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r1 = (com.hbg.lib.network.hbg.core.bean.AirdropDetailBean) r1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r15 = "HandleHeader-data("
            r6.append(r15)
            if (r1 != 0) goto L_0x01a1
            r15 = r14
            goto L_0x01a2
        L_0x01a1:
            r15 = 0
        L_0x01a2:
            r6.append(r15)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r6)
            if (r1 == 0) goto L_0x036c
            com.business.common.airdrop.AirdropManager r6 = com.business.common.airdrop.AirdropManager.f64272a
            android.content.Context r15 = r13.getContext()
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r16 = r1.getMaterial()
            if (r16 == 0) goto L_0x01c7
            java.lang.String r16 = r16.getSideImageUrl()
            if (r16 != 0) goto L_0x01c4
            goto L_0x01c7
        L_0x01c4:
            r14 = r16
            goto L_0x01c8
        L_0x01c7:
            r14 = r11
        L_0x01c8:
            r2.L$0 = r13
            r2.L$1 = r5
            r2.L$2 = r1
            r2.I$0 = r4
            r2.label = r9
            java.lang.Object r6 = r6.d(r15, r14, r2)
            if (r6 != r3) goto L_0x01d9
            return r3
        L_0x01d9:
            r15 = r5
            goto L_0x0090
        L_0x01dc:
            com.business.common.airdrop.AirdropManager r6 = com.business.common.airdrop.AirdropManager.f64272a
            android.content.Context r13 = r5.getContext()
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r14 = r1.getMaterial()
            if (r14 == 0) goto L_0x01ee
            java.lang.String r14 = r14.getOpenRedEnvelopeStyleImageUrl()
            if (r14 != 0) goto L_0x01ef
        L_0x01ee:
            r14 = r11
        L_0x01ef:
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r1
            r2.I$0 = r4
            r2.label = r7
            java.lang.Object r6 = r6.d(r13, r14, r2)
            if (r6 != r3) goto L_0x0200
            return r3
        L_0x0200:
            r7 = r1
        L_0x0201:
            com.business.common.airdrop.AirdropManager r1 = com.business.common.airdrop.AirdropManager.f64272a
            android.content.Context r6 = r5.getContext()
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r13 = r7.getMaterial()
            if (r13 == 0) goto L_0x0213
            java.lang.String r13 = r13.getOpenSphericalStyleImageUrl()
            if (r13 != 0) goto L_0x0214
        L_0x0213:
            r13 = r11
        L_0x0214:
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r7
            r2.I$0 = r4
            r2.label = r8
            java.lang.Object r1 = r1.d(r6, r13, r2)
            if (r1 != r3) goto L_0x0225
            return r3
        L_0x0225:
            r6 = r15
            r15 = r5
        L_0x0227:
            com.business.common.airdrop.AirdropManager r1 = com.business.common.airdrop.AirdropManager.f64272a
            android.content.Context r5 = r15.getContext()
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r8 = r7.getMaterial()
            if (r8 == 0) goto L_0x0239
            java.lang.String r8 = r8.getShowImageUrl()
            if (r8 != 0) goto L_0x023a
        L_0x0239:
            r8 = r11
        L_0x023a:
            r2.L$0 = r15
            r2.L$1 = r6
            r2.L$2 = r7
            r2.I$0 = r4
            r13 = 5
            r2.label = r13
            java.lang.Object r1 = r1.d(r5, r8, r2)
            if (r1 != r3) goto L_0x024c
            return r3
        L_0x024c:
            r3 = r4
            r4 = r7
        L_0x024e:
            java.lang.String r1 = "HandleHeader-DownloadAnimation-结束"
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r2 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2)
            long r7 = r2.getTimeInMillis()
            r15.f64313j = r7
            java.lang.Integer r2 = r4.getId()
            if (r2 == 0) goto L_0x026e
            int r5 = r2.intValue()
            goto L_0x026f
        L_0x026e:
            r5 = -1
        L_0x026f:
            r15.f64315l = r5
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            long r1 = r1.getTimeInMillis()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "当前UTC : "
            r5.append(r7)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r15.A(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "HandleHeader-NowUtcTime("
            r5.append(r7)
            r5.append(r1)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r5)
            java.lang.Long r5 = r4.getStartTime()
            r7 = 0
            if (r5 == 0) goto L_0x02b6
            long r12 = r5.longValue()
            goto L_0x02b7
        L_0x02b6:
            r12 = r7
        L_0x02b7:
            int r5 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r5 < 0) goto L_0x0368
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r5 = r4.getMaterial()
            if (r5 == 0) goto L_0x02cb
            java.lang.String r5 = r5.getSideImageUrl()
            if (r5 != 0) goto L_0x02c8
            goto L_0x02cb
        L_0x02c8:
            r20 = r5
            goto L_0x02cd
        L_0x02cb:
            r20 = r11
        L_0x02cd:
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r5 = r4.getMaterial()
            if (r5 == 0) goto L_0x02e2
            java.lang.Integer r5 = r5.getInteractive()
            if (r5 != 0) goto L_0x02da
            goto L_0x02e2
        L_0x02da:
            int r5 = r5.intValue()
            if (r5 != r9) goto L_0x02e2
            r5 = 1
            goto L_0x02e3
        L_0x02e2:
            r5 = 0
        L_0x02e3:
            if (r5 == 0) goto L_0x0310
            boolean r5 = r15.z()
            if (r5 == 0) goto L_0x0310
            java.lang.Integer r5 = r4.getAwarded()
            if (r5 != 0) goto L_0x02f2
            goto L_0x02f9
        L_0x02f2:
            int r5 = r5.intValue()
            r9 = 1
            if (r5 == r9) goto L_0x0310
        L_0x02f9:
            java.lang.ref.WeakReference<androidx.fragment.app.FragmentActivity> r1 = r15.f64307d
            if (r1 == 0) goto L_0x03cc
            java.lang.Object r1 = r1.get()
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            if (r1 == 0) goto L_0x03cc
            com.business.common.airdrop.AirdropManager r2 = com.business.common.airdrop.AirdropManager.f64272a
            androidx.fragment.app.FragmentManager r1 = r1.getSupportFragmentManager()
            r2.o(r1, r4, r3, r6)
            goto L_0x03cc
        L_0x0310:
            com.hbg.lib.network.hbg.core.bean.AirdropRuleBean r5 = r4.getRule()
            if (r5 == 0) goto L_0x031f
            int r5 = r5.getAwardRule()
            r9 = 1
            if (r5 != r9) goto L_0x031f
            r14 = r9
            goto L_0x0320
        L_0x031f:
            r14 = 0
        L_0x0320:
            if (r14 == 0) goto L_0x0337
            boolean r5 = r15.z()
            if (r5 == 0) goto L_0x0337
            r18 = -1
            r17 = r15
            r21 = r4
            r22 = r3
            r23 = r6
            r17.I(r18, r20, r21, r22, r23)
            goto L_0x03cc
        L_0x0337:
            java.lang.Long r5 = r4.getFirstTimeMillis()
            if (r5 == 0) goto L_0x0341
            long r7 = r5.longValue()
        L_0x0341:
            com.hbg.lib.network.hbg.core.bean.AirdropRuleBean r5 = r4.getRule()
            if (r5 == 0) goto L_0x0352
            java.lang.Integer r5 = r5.getPrizeTime()
            if (r5 == 0) goto L_0x0352
            int r13 = r5.intValue()
            goto L_0x0353
        L_0x0352:
            r13 = 0
        L_0x0353:
            r5 = 1000(0x3e8, float:1.401E-42)
            int r13 = r13 * r5
            long r9 = (long) r13
            long r7 = r7 + r9
            long r7 = r7 - r1
            long r1 = (long) r5
            long r18 = r7 / r1
            r17 = r15
            r21 = r4
            r22 = r3
            r23 = r6
            r17.I(r18, r20, r21, r22, r23)
            goto L_0x03cc
        L_0x0368:
            r15.x()
            goto L_0x03cc
        L_0x036c:
            r13.x()
            goto L_0x03cc
        L_0x0370:
            boolean r2 = r1 instanceof com.hbg.module.libkt.base.ext.g.a
            if (r2 == 0) goto L_0x03cc
            com.hbg.module.libkt.base.ext.g$a r1 = (com.hbg.module.libkt.base.ext.g.a) r1
            com.hbg.lib.network.retrofit.exception.APIStatusErrorException r2 = r1.a()
            java.lang.Throwable r1 = r1.b()
            if (r2 != 0) goto L_0x039e
            if (r1 == 0) goto L_0x03c5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "HandleHeader-OtherError(Msg:"
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = r2.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r1)
            goto L_0x03c5
        L_0x039e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "HandleHeader-APIError(Code:"
            r1.append(r3)
            java.lang.String r3 = r2.getErrCode()
            r1.append(r3)
            java.lang.String r3 = ",Msg:"
            r1.append(r3)
            java.lang.String r2 = r2.getErrMsg()
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            com.hbg.lib.common.utils.LogAndWoodRecorder.a(r12, r1)
        L_0x03c5:
            r13.x()
            goto L_0x03cc
        L_0x03c9:
            r24.x()
        L_0x03cc:
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.view.AirdropView.w(com.business.common.airdrop.data.AirdropHeaderBean, kotlin.coroutines.c):java.lang.Object");
    }

    public final void x() {
        C();
        this.f64305b.getRoot().setVisibility(8);
    }

    public final boolean y(String str) {
        return StringsKt__StringsKt.R(str.toLowerCase(Locale.getDefault()), this.f64312i.toLowerCase(Locale.getDefault()), false, 2, (Object) null);
    }

    public final boolean z() {
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        if (a11 != null) {
            return a11.a();
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirdropView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
