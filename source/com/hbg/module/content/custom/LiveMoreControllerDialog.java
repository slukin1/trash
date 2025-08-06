package com.hbg.module.content.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$style;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.jvm.internal.r;
import lc.g0;
import rd.s;

public final class LiveMoreControllerDialog extends DialogFragment {

    /* renamed from: f  reason: collision with root package name */
    public static final a f18019f = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public FragmentManager f18020b;

    /* renamed from: c  reason: collision with root package name */
    public g0 f18021c;

    /* renamed from: d  reason: collision with root package name */
    public String f18022d;

    /* renamed from: e  reason: collision with root package name */
    public String f18023e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveMoreControllerDialog a(FragmentManager fragmentManager, String str, Integer num) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("LiveMoreControllerDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                LiveMoreControllerDialog liveMoreControllerDialog = new LiveMoreControllerDialog();
                liveMoreControllerDialog.sh(fragmentManager);
                Bundle bundle = new Bundle();
                bundle.putString("liveId", str);
                if (num != null) {
                    bundle.putString("traderId", String.valueOf(num.intValue()));
                }
                liveMoreControllerDialog.setArguments(bundle);
                q11.e(liveMoreControllerDialog, "LiveMoreControllerDialog");
                q11.k();
                return liveMoreControllerDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18025c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveMoreControllerDialog f18026d;

        public b(View view, long j11, LiveMoreControllerDialog liveMoreControllerDialog) {
            this.f18024b = view;
            this.f18025c = j11;
            this.f18026d = liveMoreControllerDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18024b) > this.f18025c || (this.f18024b instanceof Checkable)) {
                sVar.e(this.f18024b, currentTimeMillis);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.f18024b;
                this.f18026d.dismiss();
                LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.f18026d.getActivity();
                if (liveDetailActivity != null) {
                    liveDetailActivity.Dl();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18027b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18028c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveMoreControllerDialog f18029d;

        public c(View view, long j11, LiveMoreControllerDialog liveMoreControllerDialog) {
            this.f18027b = view;
            this.f18028c = j11;
            this.f18029d = liveMoreControllerDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18027b) > this.f18028c || (this.f18027b instanceof Checkable)) {
                sVar.e(this.f18027b, currentTimeMillis);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.f18027b;
                this.f18029d.dismiss();
                if (com.hbg.module.libkt.base.ext.b.x(this.f18029d.rh())) {
                    LiveTraderDialog.f18061h.a(this.f18029d.qh(), this.f18029d.ph());
                } else {
                    LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.f18029d.getActivity();
                    if (liveDetailActivity != null) {
                        String rh2 = this.f18029d.rh();
                        liveDetailActivity.Vj(rh2 != null ? Integer.valueOf(Integer.parseInt(rh2)) : null, 1);
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18030b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18031c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveMoreControllerDialog f18032d;

        public d(View view, long j11, LiveMoreControllerDialog liveMoreControllerDialog) {
            this.f18030b = view;
            this.f18031c = j11;
            this.f18032d = liveMoreControllerDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18030b) > this.f18031c || (this.f18030b instanceof Checkable)) {
                sVar.e(this.f18030b, currentTimeMillis);
                TextView textView = (TextView) this.f18030b;
                this.f18032d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        View decorView;
        this.f18021c = g0.K(LayoutInflater.from(getActivity()));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        g0 g0Var = this.f18021c;
        WindowManager.LayoutParams layoutParams = null;
        dialog.setContentView(g0Var != null ? g0Var.getRoot() : null);
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (window != null) {
            window.setAttributes(layoutParams);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
        }
        if (window != null) {
            window.setWindowAnimations(R$style.bottom_dialog_animation);
        }
        g0 g0Var2 = this.f18021c;
        if (!(g0Var2 == null || (constraintLayout2 = g0Var2.C) == null)) {
            s sVar = s.f23381a;
            constraintLayout2.setOnClickListener(new b(constraintLayout2, 800, this));
        }
        g0 g0Var3 = this.f18021c;
        if (!(g0Var3 == null || (constraintLayout = g0Var3.B) == null)) {
            s sVar2 = s.f23381a;
            constraintLayout.setOnClickListener(new c(constraintLayout, 800, this));
        }
        g0 g0Var4 = this.f18021c;
        if (!(g0Var4 == null || (textView = g0Var4.F) == null)) {
            s sVar3 = s.f23381a;
            textView.setOnClickListener(new d(textView, 800, this));
        }
        return dialog;
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

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final String ph() {
        return this.f18022d;
    }

    public final FragmentManager qh() {
        return this.f18020b;
    }

    public final String rh() {
        return this.f18023e;
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        String str = null;
        this.f18022d = bundle != null ? bundle.getString("liveId") : null;
        if (bundle != null) {
            str = bundle.getString("traderId");
        }
        this.f18023e = str;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void sh(FragmentManager fragmentManager) {
        this.f18020b = fragmentManager;
    }
}
