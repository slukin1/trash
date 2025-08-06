package com.hbg.module.libkt.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.libkt.R$color;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class ButtonDialog extends DialogFragment {

    /* renamed from: i  reason: collision with root package name */
    public static final a f24637i = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public FragmentManager f24638b;

    /* renamed from: c  reason: collision with root package name */
    public ke.a f24639c;

    /* renamed from: d  reason: collision with root package name */
    public ke.a f24640d;

    /* renamed from: e  reason: collision with root package name */
    public String f24641e;

    /* renamed from: f  reason: collision with root package name */
    public int f24642f = 2;

    /* renamed from: g  reason: collision with root package name */
    public String f24643g;

    /* renamed from: h  reason: collision with root package name */
    public String f24644h;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final ButtonDialog a(FragmentManager fragmentManager, String str, int i11, String str2, String str3, ke.a aVar, ke.a aVar2) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("ButtonDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                ButtonDialog buttonDialog = new ButtonDialog();
                buttonDialog.rh(fragmentManager);
                Bundle bundle = new Bundle();
                bundle.putString("content", str);
                bundle.putInt("btnType", i11);
                bundle.putString("confirmTitle", str2);
                bundle.putString("cancelTitle", str3);
                buttonDialog.setArguments(bundle);
                buttonDialog.th(aVar);
                buttonDialog.sh(aVar2);
                q11.e(buttonDialog, "ButtonDialog");
                q11.k();
                return buttonDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24645b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24646c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ButtonDialog f24647d;

        public b(View view, long j11, ButtonDialog buttonDialog) {
            this.f24645b = view;
            this.f24646c = j11;
            this.f24647d = buttonDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24645b) > this.f24646c || (this.f24645b instanceof Checkable)) {
                rVar.e(this.f24645b, currentTimeMillis);
                TextView textView = (TextView) this.f24645b;
                this.f24647d.dismiss();
                ke.a qh2 = this.f24647d.qh();
                if (qh2 != null) {
                    qh2.onClick();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24648b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24649c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ButtonDialog f24650d;

        public c(View view, long j11, ButtonDialog buttonDialog) {
            this.f24648b = view;
            this.f24649c = j11;
            this.f24650d = buttonDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24648b) > this.f24649c || (this.f24648b instanceof Checkable)) {
                rVar.e(this.f24648b, currentTimeMillis);
                TextView textView = (TextView) this.f24648b;
                this.f24650d.dismiss();
                ke.a ph2 = this.f24650d.ph();
                if (ph2 != null) {
                    ph2.onClick();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Unit unit;
        View decorView;
        te.a K = te.a.K(LayoutInflater.from(getActivity()));
        K.M(Boolean.valueOf(NightHelper.e().g()));
        K.D.setText(this.f24641e);
        K.B.setText(this.f24644h);
        K.C.setText(this.f24643g);
        String str = this.f24644h;
        WindowManager.LayoutParams layoutParams = null;
        if (str != null) {
            K.B.setText(str);
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            TextView textView = K.B;
            textView.setOnClickListener(new c(textView, 800, this));
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            K.B.setVisibility(8);
        }
        String str2 = this.f24643g;
        if (str2 != null) {
            K.C.setText(str2);
        }
        com.hbg.module.libkt.utils.r rVar2 = com.hbg.module.libkt.utils.r.f24939a;
        TextView textView2 = K.C;
        textView2.setOnClickListener(new b(textView2, 800, this));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.requestWindowFeature(1);
        dialog.setContentView(K.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        if (layoutParams != null) {
            layoutParams.width = -2;
        }
        if (window != null) {
            window.setAttributes(layoutParams);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R$color.transparent);
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

    public final ke.a ph() {
        return this.f24640d;
    }

    public final ke.a qh() {
        return this.f24639c;
    }

    public final void rh(FragmentManager fragmentManager) {
        this.f24638b = fragmentManager;
    }

    public void setArguments(Bundle bundle) {
        String string;
        String string2;
        String string3;
        super.setArguments(bundle);
        if (!(bundle == null || (string3 = bundle.getString("content")) == null)) {
            this.f24641e = string3;
        }
        if (bundle != null) {
            this.f24642f = bundle.getInt("btnType");
        }
        if (!(bundle == null || (string2 = bundle.getString("confirmTitle")) == null)) {
            this.f24643g = string2;
        }
        if (bundle != null && (string = bundle.getString("cancelTitle")) != null) {
            this.f24644h = string;
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void sh(ke.a aVar) {
        this.f24640d = aVar;
    }

    public final void th(ke.a aVar) {
        this.f24639c = aVar;
    }
}
