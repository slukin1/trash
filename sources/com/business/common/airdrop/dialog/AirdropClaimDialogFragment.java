package com.business.common.airdrop.dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.v;
import com.business.common.R$drawable;
import com.business.common.R$style;
import com.business.common.airdrop.AirdropManager;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean;
import com.hbg.module.libkt.utils.r;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.HashMap;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class AirdropClaimDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final AirdropDetailBean f64279b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64280c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64281d;

    /* renamed from: e  reason: collision with root package name */
    public i4.a f64282e;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f64283b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f64284c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AirdropClaimDialogFragment f64285d;

        public a(View view, long j11, AirdropClaimDialogFragment airdropClaimDialogFragment) {
            this.f64283b = view;
            this.f64284c = j11;
            this.f64285d = airdropClaimDialogFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f64283b) > this.f64284c || (this.f64283b instanceof Checkable)) {
                rVar.e(this.f64283b, currentTimeMillis);
                this.f64285d.Fh(true, 2);
                n1 unused = i.d(v.a(this.f64285d), (CoroutineContext) null, (CoroutineStart) null, new AirdropClaimDialogFragment$activityClaim$1$1(this.f64285d, (c<? super AirdropClaimDialogFragment$activityClaim$1$1>) null), 3, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public AirdropClaimDialogFragment(AirdropDetailBean airdropDetailBean, int i11, String str) {
        this.f64279b = airdropDetailBean;
        this.f64280c = i11;
        this.f64281d = str;
    }

    @SensorsDataInstrumented
    public static final void Ah(AirdropClaimDialogFragment airdropClaimDialogFragment, View view) {
        airdropClaimDialogFragment.Fh(true, 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Bh(AirdropClaimDialogFragment airdropClaimDialogFragment, View view) {
        airdropClaimDialogFragment.Fh(true, 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Ch(AirdropClaimDialogFragment airdropClaimDialogFragment, View view) {
        airdropClaimDialogFragment.Fh(true, 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Gh(Throwable th2) {
    }

    @SensorsDataInstrumented
    public static final void Hh(AirdropClaimDialogFragment airdropClaimDialogFragment, View view) {
        if (AirdropManager.f64272a.c(airdropClaimDialogFragment.f64279b) > 0) {
            airdropClaimDialogFragment.Fh(false, 1);
        } else {
            airdropClaimDialogFragment.Fh(false, 2);
        }
        airdropClaimDialogFragment.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Dh(TextView textView, View view) {
        textView.setVisibility(8);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(Color.parseColor("#FEFEFE"));
            view.setBackgroundResource(R$drawable.shape_airdrop_button_claim_enable);
        }
        r rVar = r.f24939a;
        view.setOnClickListener(new a(view, 800, this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        r9 = r9.getOpenStyle();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Eh(kotlinx.coroutines.h0 r9, long r10, kotlin.coroutines.c<? super kotlin.Unit> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.business.common.airdrop.dialog.AirdropClaimDialogFragment$activityCountDown$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.business.common.airdrop.dialog.AirdropClaimDialogFragment$activityCountDown$1 r0 = (com.business.common.airdrop.dialog.AirdropClaimDialogFragment$activityCountDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.common.airdrop.dialog.AirdropClaimDialogFragment$activityCountDown$1 r0 = new com.business.common.airdrop.dialog.AirdropClaimDialogFragment$activityCountDown$1
            r0.<init>(r8, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            long r9 = r0.J$0
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.h0 r11 = (kotlinx.coroutines.h0) r11
            java.lang.Object r2 = r0.L$0
            com.business.common.airdrop.dialog.AirdropClaimDialogFragment r2 = (com.business.common.airdrop.dialog.AirdropClaimDialogFragment) r2
            kotlin.k.b(r12)
            goto L_0x00bc
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.k.b(r12)
            r2 = r8
        L_0x0040:
            boolean r12 = kotlinx.coroutines.i0.i(r9)
            if (r12 == 0) goto L_0x00c4
            r4 = 0
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x00a5
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r9 = r2.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r9 = r9.getMaterial()
            r10 = 0
            if (r9 == 0) goto L_0x0064
            java.lang.Integer r9 = r9.getOpenStyle()
            if (r9 != 0) goto L_0x005c
            goto L_0x0064
        L_0x005c:
            int r9 = r9.intValue()
            if (r9 != r3) goto L_0x0064
            r9 = r3
            goto L_0x0065
        L_0x0064:
            r9 = r10
        L_0x0065:
            r11 = 0
            if (r9 == 0) goto L_0x0070
            i4.a r9 = r2.f64282e
            if (r9 != 0) goto L_0x006d
            r9 = r11
        L_0x006d:
            androidx.appcompat.widget.AppCompatTextView r9 = r9.J
            goto L_0x0077
        L_0x0070:
            i4.a r9 = r2.f64282e
            if (r9 != 0) goto L_0x0075
            r9 = r11
        L_0x0075:
            androidx.appcompat.widget.AppCompatTextView r9 = r9.I
        L_0x0077:
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r12 = r2.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r12 = r12.getMaterial()
            if (r12 == 0) goto L_0x008d
            java.lang.Integer r12 = r12.getOpenStyle()
            if (r12 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            int r12 = r12.intValue()
            if (r12 != r3) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r3 = r10
        L_0x008e:
            if (r3 == 0) goto L_0x0099
            i4.a r10 = r2.f64282e
            if (r10 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r11 = r10
        L_0x0096:
            com.airbnb.lottie.LottieAnimationView r10 = r11.F
            goto L_0x00a1
        L_0x0099:
            i4.a r10 = r2.f64282e
            if (r10 != 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r11 = r10
        L_0x009f:
            androidx.appcompat.widget.AppCompatTextView r10 = r11.H
        L_0x00a1:
            r2.Dh(r9, r10)
            goto L_0x00c4
        L_0x00a5:
            r2.zh(r10)
            r4 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r2
            r0.L$1 = r9
            r0.J$0 = r10
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r12 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            r6 = r10
            r11 = r9
            r9 = r6
        L_0x00bc:
            r4 = 1
            long r9 = r9 - r4
            r6 = r9
            r9 = r11
            r10 = r6
            goto L_0x0040
        L_0x00c4:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.dialog.AirdropClaimDialogFragment.Eh(kotlinx.coroutines.h0, long, kotlin.coroutines.c):java.lang.Object");
    }

    public final void Fh(boolean z11, int i11) {
        Integer openStyle;
        HashMap hashMap = new HashMap();
        int i12 = this.f64280c;
        if (i12 == 4) {
            hashMap.put("location", "app_community_dynamic_details_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, this.f64281d);
        } else if (i12 == 20) {
            hashMap.put("location", "app_community_homepage_find_sideways");
        } else if (i12 == 24) {
            hashMap.put("location", "app_community_square_sideways");
        } else if (i12 == 28) {
            hashMap.put("location", "app_community_k_line_comment_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, this.f64281d);
        }
        hashMap.put("button_name", z11 ? "Open_now" : "close");
        hashMap.put("button_state", Integer.valueOf(i11));
        AirdropMaterialBean material = this.f64279b.getMaterial();
        boolean z12 = true;
        if (material == null || (openStyle = material.getOpenStyle()) == null || openStyle.intValue() != 1) {
            z12 = false;
        }
        hashMap.put("award_winning_pop_up_style", z12 ? "red_envelope" : "ball");
        vf.a.a("app_community_award_winning_pop_up_click", hashMap);
    }

    public final void Ih(FragmentManager fragmentManager) {
        show(fragmentManager, "AirdropClaimDialogFragment");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(1, R$style.CenterDialogFragmentStyle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r10 = r10.getOpenStyle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
            r7 = this;
            i4.a r8 = i4.a.K(r8)
            r7.f64282e = r8
            r9 = 0
            if (r8 != 0) goto L_0x000a
            r8 = r9
        L_0x000a:
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r10 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r10 = r10.getMaterial()
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L_0x0023
            java.lang.Integer r10 = r10.getOpenStyle()
            if (r10 != 0) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            int r10 = r10.intValue()
            if (r10 != r0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r1
        L_0x0024:
            java.lang.String r2 = ""
            if (r10 == 0) goto L_0x0037
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r10 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r10 = r10.getMaterial()
            if (r10 == 0) goto L_0x0045
            java.lang.String r10 = r10.getOpenRedEnvelopeStyleImageUrl()
            if (r10 != 0) goto L_0x0046
            goto L_0x0045
        L_0x0037:
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r10 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r10 = r10.getMaterial()
            if (r10 == 0) goto L_0x0045
            java.lang.String r10 = r10.getOpenSphericalStyleImageUrl()
            if (r10 != 0) goto L_0x0046
        L_0x0045:
            r10 = r2
        L_0x0046:
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r3 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r3 = r3.getMaterial()
            if (r3 == 0) goto L_0x005d
            java.lang.Integer r3 = r3.getOpenStyle()
            if (r3 != 0) goto L_0x0055
            goto L_0x005d
        L_0x0055:
            int r3 = r3.intValue()
            if (r3 != r0) goto L_0x005d
            r3 = r0
            goto L_0x005e
        L_0x005d:
            r3 = r1
        L_0x005e:
            r4 = 8
            if (r3 == 0) goto L_0x0075
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.C
            r3.setVisibility(r1)
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.B
            r3.setVisibility(r4)
            android.widget.TextView r3 = r8.L
            android.widget.TextView r4 = r8.K
            com.airbnb.lottie.LottieAnimationView r5 = r8.F
            androidx.appcompat.widget.AppCompatImageView r8 = r8.G
            goto L_0x0087
        L_0x0075:
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.C
            r3.setVisibility(r4)
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.B
            r3.setVisibility(r1)
            androidx.appcompat.widget.AppCompatTextView r3 = r8.N
            androidx.appcompat.widget.AppCompatTextView r4 = r8.M
            com.airbnb.lottie.LottieAnimationView r5 = r8.D
            androidx.appcompat.widget.AppCompatImageView r8 = r8.E
        L_0x0087:
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r6 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r6 = r6.getMaterial()
            if (r6 == 0) goto L_0x0096
            java.lang.String r6 = r6.getTitle()
            if (r6 == 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r6 = r2
        L_0x0097:
            r3.setText(r6)
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r3 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r3 = r3.getMaterial()
            if (r3 == 0) goto L_0x00a9
            java.lang.String r3 = r3.getSubtitle()
            if (r3 == 0) goto L_0x00a9
            r2 = r3
        L_0x00a9:
            r4.setText(r2)
            com.business.common.airdrop.dialog.e r2 = com.business.common.airdrop.dialog.e.f64302a
            r5.setFailureListener(r2)
            int r2 = r10.length()
            if (r2 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r0 = r1
        L_0x00b9:
            r2 = 2
            if (r0 != 0) goto L_0x00cb
            java.lang.String r0 = ".json"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.v(r10, r0, r1, r2, r9)
            if (r0 != 0) goto L_0x00c5
            goto L_0x00cb
        L_0x00c5:
            com.business.common.airdrop.AirdropManager r0 = com.business.common.airdrop.AirdropManager.f64272a
            r0.n(r5, r10)
            goto L_0x00dc
        L_0x00cb:
            java.lang.String r0 = ".png"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.v(r10, r0, r1, r2, r9)
            if (r0 == 0) goto L_0x00d7
            com.hbg.module.libkt.base.ext.b.B(r5, r10)
            goto L_0x00dc
        L_0x00d7:
            int r10 = com.business.common.R$raw.airdrop_animation_open
            r5.setAnimation((int) r10)
        L_0x00dc:
            com.business.common.airdrop.dialog.b r10 = new com.business.common.airdrop.dialog.b
            r10.<init>(r7)
            r8.setOnClickListener(r10)
            i4.a r8 = r7.f64282e
            if (r8 != 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r9 = r8
        L_0x00ea:
            android.view.View r8 = r9.getRoot()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.dialog.AirdropClaimDialogFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        Integer openStyle;
        Window window;
        Window window2;
        Window window3;
        Window window4;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window4 = dialog.getWindow()) == null)) {
            window4.setGravity(17);
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window3 = dialog2.getWindow()) == null)) {
            window3.setLayout(-1, -2);
        }
        Dialog dialog3 = getDialog();
        if (!(dialog3 == null || (window2 = dialog3.getWindow()) == null)) {
            window2.addFlags(2);
        }
        Dialog dialog4 = getDialog();
        if (!(dialog4 == null || (window = dialog4.getWindow()) == null)) {
            window.setDimAmount(0.8f);
        }
        HashMap hashMap = new HashMap();
        int i11 = this.f64280c;
        if (i11 == 4) {
            hashMap.put("location", "app_community_dynamic_details_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, this.f64281d);
        } else if (i11 == 20) {
            hashMap.put("location", "app_community_homepage_find_sideways");
        } else if (i11 == 24) {
            hashMap.put("location", "app_community_square_sideways");
        } else if (i11 == 28) {
            hashMap.put("location", "app_community_k_line_comment_sideways");
            hashMap.put(CommunityConstants.TOPIC_ID, this.f64281d);
        }
        AirdropMaterialBean material = this.f64279b.getMaterial();
        boolean z11 = true;
        if (material == null || (openStyle = material.getOpenStyle()) == null || openStyle.intValue() != 1) {
            z11 = false;
        }
        hashMap.put("award_winning_pop_up_style", z11 ? "red_envelope" : "ball");
        vf.a.a("app_community_award_winning_pop_up_show", hashMap);
        n1 unused = i.d(v.a(this), (CoroutineContext) null, (CoroutineStart) null, new AirdropClaimDialogFragment$onStart$1(this, (c<? super AirdropClaimDialogFragment$onStart$1>) null), 3, (Object) null);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r1 = r1.getOpenStyle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zh(long r8) {
        /*
            r7 = this;
            i4.a r0 = r7.f64282e
            if (r0 != 0) goto L_0x0005
            r0 = 0
        L_0x0005:
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r1 = r7.f64279b
            com.hbg.lib.network.hbg.core.bean.AirdropMaterialBean r1 = r1.getMaterial()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001e
            java.lang.Integer r1 = r1.getOpenStyle()
            if (r1 != 0) goto L_0x0016
            goto L_0x001e
        L_0x0016:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x001e
            r1 = r2
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            java.lang.String r4 = "#99FEFEFE"
            if (r1 == 0) goto L_0x0035
            com.airbnb.lottie.LottieAnimationView r1 = r0.F
            com.business.common.airdrop.dialog.d r5 = new com.business.common.airdrop.dialog.d
            r5.<init>(r7)
            r1.setOnClickListener(r5)
            androidx.appcompat.widget.AppCompatTextView r1 = r0.J
            r1.setVisibility(r3)
            androidx.appcompat.widget.AppCompatTextView r1 = r0.J
            goto L_0x0056
        L_0x0035:
            androidx.appcompat.widget.AppCompatTextView r1 = r0.H
            int r5 = android.graphics.Color.parseColor(r4)
            r1.setTextColor(r5)
            androidx.appcompat.widget.AppCompatTextView r1 = r0.H
            int r5 = com.business.common.R$drawable.shape_airdrop_button_claim_disable
            r1.setBackgroundResource(r5)
            androidx.appcompat.widget.AppCompatTextView r1 = r0.H
            com.business.common.airdrop.dialog.a r5 = new com.business.common.airdrop.dialog.a
            r5.<init>(r7)
            r1.setOnClickListener(r5)
            androidx.appcompat.widget.AppCompatTextView r1 = r0.I
            r1.setVisibility(r3)
            androidx.appcompat.widget.AppCompatTextView r1 = r0.I
        L_0x0056:
            android.content.Context r5 = r7.requireContext()
            int r6 = com.business.common.R$string.n_airdrop_count_down_claim_second
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r2[r3] = r8
            java.lang.String r8 = r5.getString(r6, r2)
            r1.setText(r8)
            androidx.appcompat.widget.AppCompatTextView r8 = r0.H
            int r9 = android.graphics.Color.parseColor(r4)
            r8.setTextColor(r9)
            androidx.appcompat.widget.AppCompatTextView r8 = r0.H
            int r9 = com.business.common.R$drawable.shape_airdrop_button_claim_disable
            r8.setBackgroundResource(r9)
            androidx.appcompat.widget.AppCompatTextView r8 = r0.H
            com.business.common.airdrop.dialog.c r9 = new com.business.common.airdrop.dialog.c
            r9.<init>(r7)
            r8.setOnClickListener(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.dialog.AirdropClaimDialogFragment.zh(long):void");
    }
}
