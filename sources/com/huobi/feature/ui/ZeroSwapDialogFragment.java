package com.huobi.feature.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroPosition;
import com.huobi.view.roundview.RoundLinearLayout;
import com.huobi.view.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.xiaomi.mipush.sdk.Constants;
import gs.g;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.jvm.internal.d0;
import lj.e0;
import lj.u;
import pk.i3;
import pk.j3;
import pk.k3;
import pro.huobi.R;

public final class ZeroSwapDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public final ActivityZeroCreateBean f45015b;

    /* renamed from: c  reason: collision with root package name */
    public final List<ActivityZeroPosition> f45016c;

    /* renamed from: d  reason: collision with root package name */
    public final int f45017d;

    /* renamed from: e  reason: collision with root package name */
    public u f45018e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnDismissListener f45019f;

    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ZeroSwapDialogFragment f45020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f45021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f45022d;

        public a(ZeroSwapDialogFragment zeroSwapDialogFragment, int i11, View view) {
            this.f45020b = zeroSwapDialogFragment;
            this.f45021c = i11;
            this.f45022d = view;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f45020b.Gh(0, ((float) this.f45021c) - ((float) this.f45022d.getHeight()));
            int th2 = this.f45020b.f45017d;
            long j11 = th2 != 1 ? th2 != 2 ? 700 : 528 : 448;
            ZeroSwapDialogFragment zeroSwapDialogFragment = this.f45020b;
            u sh2 = zeroSwapDialogFragment.f45018e;
            if (sh2 == null) {
                sh2 = null;
            }
            zeroSwapDialogFragment.Fh(sh2.B, j11);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ZeroSwapDialogFragment f45023b;

        public b(ZeroSwapDialogFragment zeroSwapDialogFragment) {
            this.f45023b = zeroSwapDialogFragment;
        }

        public void onAnimationEnd(Animator animator) {
            u sh2 = this.f45023b.f45018e;
            if (sh2 == null) {
                sh2 = null;
            }
            for (View alpha : SequencesKt___SequencesKt.w(ViewGroupKt.a(sh2.F))) {
                alpha.setAlpha(1.0f);
            }
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ZeroSwapDialogFragment f45024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f45025c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f45026d;

        public c(ZeroSwapDialogFragment zeroSwapDialogFragment, int i11, float f11) {
            this.f45024b = zeroSwapDialogFragment;
            this.f45025c = i11;
            this.f45026d = f11;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f45024b.Gh(this.f45025c + 1, this.f45026d);
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ZeroSwapDialogFragment f45027b;

        public d(ZeroSwapDialogFragment zeroSwapDialogFragment) {
            this.f45027b = zeroSwapDialogFragment;
        }

        public void onAnimationStart(Animator animator) {
            ZeroSwapDialogFragment zeroSwapDialogFragment = this.f45027b;
            u sh2 = zeroSwapDialogFragment.f45018e;
            if (sh2 == null) {
                sh2 = null;
            }
            zeroSwapDialogFragment.Eh(sh2.H);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.X(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ZeroSwapDialogFragment(com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean r1) {
        /*
            r0 = this;
            r0.<init>()
            r0.f45015b = r1
            java.util.List r1 = r1.getPositionList()
            if (r1 == 0) goto L_0x0011
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.X(r1)
            if (r1 != 0) goto L_0x0015
        L_0x0011:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x0015:
            r0.f45016c = r1
            int r1 = r1.size()
            r0.f45017d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.ui.ZeroSwapDialogFragment.<init>(com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean):void");
    }

    @SensorsDataInstrumented
    public static final void Ah(ZeroSwapDialogFragment zeroSwapDialogFragment, View view) {
        zeroSwapDialogFragment.dismiss();
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "usdt_0_yuan_buy");
        hashMap.put("button_name", "usdt_go_0_yuan");
        g.i("appclick_contracts", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Bh(ZeroSwapDialogFragment zeroSwapDialogFragment) {
        Window window;
        Window window2;
        u uVar = zeroSwapDialogFragment.f45018e;
        u uVar2 = null;
        if (uVar == null) {
            uVar = null;
        }
        int height = 0 + uVar.H.getHeight() + com.hbg.module.libkt.base.ext.c.a(20.0f);
        u uVar3 = zeroSwapDialogFragment.f45018e;
        if (uVar3 == null) {
            uVar3 = null;
        }
        int height2 = height + uVar3.B.getHeight();
        u uVar4 = zeroSwapDialogFragment.f45018e;
        if (uVar4 == null) {
            uVar4 = null;
        }
        Iterator x11 = CollectionsKt__IteratorsKt.x(ViewGroupKt.a(uVar4.F).iterator());
        while (x11.hasNext()) {
            m mVar = (m) x11.next();
            int a11 = mVar.a();
            View view = (View) mVar.b();
            if (a11 > 2) {
                break;
            }
            height2 += view.getHeight();
        }
        u uVar5 = zeroSwapDialogFragment.f45018e;
        if (uVar5 == null) {
            uVar5 = null;
        }
        RoundLinearLayout roundLinearLayout = uVar5.G;
        ViewGroup.LayoutParams layoutParams = roundLinearLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.height = height2;
        roundLinearLayout.setLayoutParams(layoutParams);
        Dialog dialog = zeroSwapDialogFragment.getDialog();
        if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
            window2.setLayout(-1, height2);
        }
        Dialog dialog2 = zeroSwapDialogFragment.getDialog();
        if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
            window.setGravity(80);
        }
        u uVar6 = zeroSwapDialogFragment.f45018e;
        if (uVar6 != null) {
            uVar2 = uVar6;
        }
        zeroSwapDialogFragment.Hh(uVar2.G);
    }

    @SensorsDataInstrumented
    public static final void Ch(ZeroSwapDialogFragment zeroSwapDialogFragment, View view) {
        zeroSwapDialogFragment.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Dh(DialogInterface.OnDismissListener onDismissListener) {
        this.f45019f = onDismissListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r0 = (r0 = r0.getWindow()).getDecorView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Eh(android.view.View r11) {
        /*
            r10 = this;
            android.app.Dialog r0 = r10.getDialog()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0018
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x0018
            int r0 = r0.getHeight()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            r2 = 2
            float[] r3 = new float[r2]
            float r4 = (float) r0
            r3[r1] = r4
            r4 = 0
            r5 = 1
            r3[r5] = r4
            java.lang.String r4 = "translationY"
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r11, r4, r3)
            int r4 = r10.f45017d
            if (r4 == r5) goto L_0x0035
            if (r4 == r2) goto L_0x0032
            r6 = 80
            goto L_0x0037
        L_0x0032:
            r6 = 100
            goto L_0x0037
        L_0x0035:
            r6 = 125(0x7d, double:6.2E-322)
        L_0x0037:
            r3.setStartDelay(r6)
            int r4 = r10.f45017d
            if (r4 == r5) goto L_0x0046
            if (r4 == r2) goto L_0x0043
            r6 = 700(0x2bc, double:3.46E-321)
            goto L_0x0048
        L_0x0043:
            r6 = 560(0x230, double:2.767E-321)
            goto L_0x0048
        L_0x0046:
            r6 = 448(0x1c0, double:2.213E-321)
        L_0x0048:
            r3.setDuration(r6)
            float[] r4 = new float[r2]
            r4 = {0, 1065353216} // fill-array
            java.lang.String r6 = "alpha"
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r11, r6, r4)
            int r6 = r10.f45017d
            if (r6 == r5) goto L_0x005f
            if (r6 == r2) goto L_0x005f
            r6 = 400(0x190, double:1.976E-321)
            goto L_0x0061
        L_0x005f:
            r6 = 320(0x140, double:1.58E-321)
        L_0x0061:
            r4.setDuration(r6)
            long r6 = r3.getStartDelay()
            long r8 = r4.getDuration()
            long r6 = r6 + r8
            long r8 = r4.getDuration()
            long r6 = r6 - r8
            r4.setStartDelay(r6)
            android.animation.AnimatorSet r6 = new android.animation.AnimatorSet
            r6.<init>()
            android.animation.Animator[] r2 = new android.animation.Animator[r2]
            r2[r1] = r3
            r2[r5] = r4
            r6.playTogether(r2)
            com.huobi.feature.ui.ZeroSwapDialogFragment$a r1 = new com.huobi.feature.ui.ZeroSwapDialogFragment$a
            r1.<init>(r10, r0, r11)
            r6.addListener(r1)
            r6.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.ui.ZeroSwapDialogFragment.Eh(android.view.View):void");
    }

    public final void Fh(View view, long j11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) view.getHeight(), 0.0f});
        ofFloat.setStartDelay(j11);
        int i11 = this.f45017d;
        ofFloat.setDuration(i11 != 1 ? i11 != 2 ? 700 : 560 : 448);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        int i12 = this.f45017d;
        ofFloat2.setDuration((i12 == 1 || i12 == 2) ? 320 : 400);
        ofFloat2.setStartDelay((ofFloat.getStartDelay() + ofFloat.getDuration()) - ofFloat2.getDuration());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new b(this));
        animatorSet.start();
    }

    public final void Gh(int i11, float f11) {
        int i12 = this.f45017d;
        long j11 = i12 != 1 ? i12 != 2 ? 460 : 368 : 294;
        u uVar = this.f45018e;
        if (uVar == null) {
            uVar = null;
        }
        View view = (View) CollectionsKt___CollectionsKt.d0(SequencesKt___SequencesKt.w(ViewGroupKt.a(uVar.F)), i11);
        if (view != null) {
            float height = f11 - ((float) (view.getHeight() * i11));
            if (height > ((float) view.getHeight()) && i11 <= 2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{height, 0.0f});
                ofFloat.setStartDelay(j11 + (((long) i11) * 80));
                int i13 = this.f45017d;
                ofFloat.setDuration(i13 != 1 ? i13 != 2 ? 700 : 560 : 448);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
                int i14 = this.f45017d;
                ofFloat2.setDuration((i14 == 1 || i14 == 2) ? 320 : 400);
                ofFloat2.setStartDelay((ofFloat.getStartDelay() + ofFloat.getDuration()) - ofFloat2.getDuration());
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                animatorSet.addListener(new c(this, i11, f11));
                animatorSet.start();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r0 = (r0 = r0.getWindow()).getDecorView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Hh(android.view.View r8) {
        /*
            r7 = this;
            android.app.Dialog r0 = r7.getDialog()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0018
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x0018
            int r0 = r0.getHeight()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            r2 = 2
            int[] r3 = new int[r2]
            r8.getLocationInWindow(r3)
            float r0 = (float) r0
            r4 = 1
            r3 = r3[r4]
            float r3 = (float) r3
            float r0 = r0 - r3
            float[] r3 = new float[r2]
            r3[r1] = r0
            r0 = 0
            r3[r4] = r0
            java.lang.String r0 = "translationY"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r8, r0, r3)
            int r3 = r7.f45017d
            if (r3 == r4) goto L_0x003e
            if (r3 == r2) goto L_0x003b
            r5 = 700(0x2bc, double:3.46E-321)
            goto L_0x0040
        L_0x003b:
            r5 = 560(0x230, double:2.767E-321)
            goto L_0x0040
        L_0x003e:
            r5 = 448(0x1c0, double:2.213E-321)
        L_0x0040:
            r0.setDuration(r5)
            float[] r3 = new float[r2]
            r3 = {1008981770, 1065353216} // fill-array
            java.lang.String r5 = "alpha"
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r5, r3)
            int r3 = r7.f45017d
            r5 = 320(0x140, double:1.58E-321)
            if (r3 == r4) goto L_0x0058
            if (r3 == r2) goto L_0x0058
            r5 = 400(0x190, double:1.976E-321)
        L_0x0058:
            r8.setDuration(r5)
            android.animation.AnimatorSet r3 = new android.animation.AnimatorSet
            r3.<init>()
            android.animation.Animator[] r2 = new android.animation.Animator[r2]
            r2[r1] = r0
            r2[r4] = r8
            r3.playTogether(r2)
            com.huobi.feature.ui.ZeroSwapDialogFragment$d r8 = new com.huobi.feature.ui.ZeroSwapDialogFragment$d
            r8.<init>(r7)
            r3.addListener(r8)
            r3.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.ui.ZeroSwapDialogFragment.Hh(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.BaseDialogFragmentStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        u K = u.K(layoutInflater);
        this.f45018e = K;
        if (K == null) {
            K = null;
        }
        K.getRoot().setAlpha(0.0f);
        u uVar = this.f45018e;
        if (uVar == null) {
            uVar = null;
        }
        uVar.H.setAlpha(0.0f);
        u uVar2 = this.f45018e;
        if (uVar2 == null) {
            uVar2 = null;
        }
        uVar2.B.setAlpha(0.0f);
        int j11 = w.j(getContext(), "1");
        int j12 = w.j(getContext(), "-1");
        int i11 = w.i(getContext(), "1");
        int i12 = w.i(getContext(), "-1");
        u uVar3 = this.f45018e;
        if (uVar3 == null) {
            uVar3 = null;
        }
        AppCompatTextView appCompatTextView = uVar3.J;
        String mainTitle = this.f45015b.getMainTitle();
        if (mainTitle == null) {
            mainTitle = "";
        }
        appCompatTextView.setText(mainTitle);
        u uVar4 = this.f45018e;
        if (uVar4 == null) {
            uVar4 = null;
        }
        AppCompatTextView appCompatTextView2 = uVar4.I;
        String subTitle = this.f45015b.getSubTitle();
        if (subTitle == null) {
            subTitle = "";
        }
        appCompatTextView2.setText(subTitle);
        u uVar5 = this.f45018e;
        if (uVar5 == null) {
            uVar5 = null;
        }
        uVar5.C.setOnClickListener(new i3(this));
        for (ActivityZeroPosition next : this.f45016c) {
            String symbol = next.getSymbol();
            if (symbol == null) {
                symbol = "";
            }
            String zh2 = zh(symbol);
            String xh2 = xh(symbol);
            String yh2 = yh(symbol);
            String e11 = kc.a.f19139a.e(xh2);
            LayoutInflater layoutInflater2 = getLayoutInflater();
            u uVar6 = this.f45018e;
            if (uVar6 == null) {
                uVar6 = null;
            }
            e0 K2 = e0.K(layoutInflater2, uVar6.F, false);
            com.hbg.module.libkt.base.ext.b.B(K2.B, e11);
            K2.J.setText(zh2);
            Integer direction = next.getDirection();
            if (direction != null && 1 == direction.intValue()) {
                K2.E.setText(getString(R.string.n_asset_future_buy));
                K2.E.setTextColor(j11);
                K2.E.getDelegate().setBackgroundColor(i11);
            } else {
                Integer direction2 = next.getDirection();
                if (direction2 != null && 2 == direction2.intValue()) {
                    K2.E.setText(getString(R.string.n_asset_future_sell));
                    K2.E.setTextColor(j12);
                    K2.E.getDelegate().setBackgroundColor(i12);
                }
            }
            K2.D.setText(getString(R.string.n_contract_trade_margin));
            RoundTextView roundTextView = K2.C;
            d0 d0Var = d0.f56774a;
            Object[] objArr = new Object[1];
            Integer leverageRatio = next.getLeverageRatio();
            String str2 = "--";
            if (leverageRatio == null || (str = leverageRatio.toString()) == null) {
                str = str2;
            }
            objArr[0] = str;
            roundTextView.setText(String.format("%sX", Arrays.copyOf(objArr, 1)));
            AppCompatTextView appCompatTextView3 = K2.K;
            String positionAmount = next.getPositionAmount();
            if (positionAmount == null) {
                positionAmount = str2;
            }
            appCompatTextView3.setText(positionAmount);
            K2.L.setText(String.format(getString(R.string.n_contarct_position_volume_label), Arrays.copyOf(new Object[]{xh2}, 1)));
            AppCompatTextView appCompatTextView4 = K2.H;
            String openPrice = next.getOpenPrice();
            if (openPrice == null) {
                openPrice = str2;
            }
            appCompatTextView4.setText(openPrice);
            K2.I.setText(String.format(getString(R.string.n_linear_swap_open_price), Arrays.copyOf(new Object[]{yh2}, 1)));
            AppCompatTextView appCompatTextView5 = K2.F;
            Object[] objArr2 = new Object[2];
            String highestProfit = next.getHighestProfit();
            if (highestProfit != null) {
                str2 = highestProfit;
            }
            objArr2[0] = str2;
            objArr2[1] = yh2;
            appCompatTextView5.setText(String.format("%s %s", Arrays.copyOf(objArr2, 2)));
            K2.F.setTextColor(j11);
            View root = K2.getRoot();
            root.setAlpha(0.0f);
            u uVar7 = this.f45018e;
            if (uVar7 == null) {
                uVar7 = null;
            }
            uVar7.F.addView(root);
        }
        u uVar8 = this.f45018e;
        return (uVar8 == null ? null : uVar8).getRoot();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "usdt_0_yuan_pop_up");
        hashMap.put("button_name", "usdt_0_yuan_pop_up_go");
        g.i("appclick_contracts", hashMap);
        DialogInterface.OnDismissListener onDismissListener = this.f45019f;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
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
        Window window;
        View decorView;
        Window window2;
        Window window3;
        Window window4;
        Window window5;
        Window window6;
        super.onStart();
        u uVar = this.f45018e;
        if (uVar == null) {
            uVar = null;
        }
        uVar.getRoot().post(new k3(this));
        Dialog dialog = getDialog();
        if (!(dialog == null || (window6 = dialog.getWindow()) == null)) {
            window6.setLayout(-1, com.hbg.module.libkt.base.ext.c.a(512.0f));
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window5 = dialog2.getWindow()) == null)) {
            window5.setGravity(80);
        }
        Dialog dialog3 = getDialog();
        if (!(dialog3 == null || (window4 = dialog3.getWindow()) == null)) {
            window4.setWindowAnimations(R.style.BottomDialogAnimation);
        }
        Dialog dialog4 = getDialog();
        if (!(dialog4 == null || (window3 = dialog4.getWindow()) == null)) {
            window3.addFlags(2);
        }
        Dialog dialog5 = getDialog();
        if (!(dialog5 == null || (window2 = dialog5.getWindow()) == null)) {
            window2.setDimAmount(0.5f);
        }
        Dialog dialog6 = getDialog();
        if (!(dialog6 == null || (window = dialog6.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
            decorView.setOnClickListener(new j3(this));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "usdt_0_yuan_buy");
        hashMap.put("button_name", "usdt_0_yuan_pop_up");
        g.i("appexposure_contracts", hashMap);
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

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "usdt_0_yuan_pop_up");
        g.i("pageview_contracts", hashMap);
    }

    public final String xh(String str) {
        String str2 = (String) CollectionsKt___CollectionsKt.d0(StringsKt__StringsKt.L0(str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null), 0);
        return str2 == null ? "--" : str2;
    }

    public final String yh(String str) {
        String str2 = (String) CollectionsKt___CollectionsKt.d0(StringsKt__StringsKt.L0(str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null), 1);
        return str2 == null ? "--" : str2;
    }

    public final String zh(String str) {
        TradeType a11 = FutureTypeUtil.a((String) null, str, (String) null);
        if (a11 != TradeType.LINEAR_SWAP && a11 != TradeType.SWAP) {
            return str;
        }
        d0 d0Var = d0.f56774a;
        return String.format(StringsKt__StringsJVMKt.G(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null) + " %s", Arrays.copyOf(new Object[]{getString(R.string.n_market_contract_swap_trade_name)}, 1));
    }
}
