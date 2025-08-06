package com.hbg.module.content.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.Arrays;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import lc.q0;
import rd.s;

public final class LiveRecommendReasonDialog extends DialogFragment {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18051d = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public String f18052b;

    /* renamed from: c  reason: collision with root package name */
    public String f18053c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveRecommendReasonDialog a(FragmentManager fragmentManager, String str, String str2) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("LiveRecommendReasonDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                LiveRecommendReasonDialog liveRecommendReasonDialog = new LiveRecommendReasonDialog();
                Bundle bundle = new Bundle();
                bundle.putString("liveId", str);
                bundle.putString("userSign", str2);
                liveRecommendReasonDialog.setArguments(bundle);
                q11.e(liveRecommendReasonDialog, "LiveRecommendReasonDialog");
                q11.k();
                return liveRecommendReasonDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18054b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18055c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendReasonDialog f18056d;

        public b(View view, long j11, LiveRecommendReasonDialog liveRecommendReasonDialog) {
            this.f18054b = view;
            this.f18055c = j11;
            this.f18056d = liveRecommendReasonDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18054b) > this.f18055c || (this.f18054b instanceof Checkable)) {
                sVar.e(this.f18054b, currentTimeMillis);
                TextView textView = (TextView) this.f18054b;
                this.f18056d.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18057b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18058c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveRecommendReasonDialog f18059d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q0 f18060e;

        public c(View view, long j11, LiveRecommendReasonDialog liveRecommendReasonDialog, q0 q0Var) {
            this.f18057b = view;
            this.f18058c = j11;
            this.f18059d = liveRecommendReasonDialog;
            this.f18060e = q0Var;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18057b) > this.f18058c || (this.f18057b instanceof Checkable)) {
                sVar.e(this.f18057b, currentTimeMillis);
                TextView textView = (TextView) this.f18057b;
                LiveDetailActivity liveDetailActivity = (LiveDetailActivity) this.f18059d.getActivity();
                if (liveDetailActivity != null) {
                    liveDetailActivity.sh();
                }
                RequestExtKt.d(v7.b.a().k(this.f18059d.f18052b, this.f18059d.f18053c, this.f18060e.B.getText().toString()), new LiveRecommendReasonDialog$onCreateDialog$2$1(this.f18059d), new LiveRecommendReasonDialog$onCreateDialog$2$2(this.f18059d), (MutableLiveData) null, 4, (Object) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        q0 K = q0.K(LayoutInflater.from(getActivity()));
        EditText editText = K.B;
        d0 d0Var = d0.f56774a;
        editText.setHint(String.format(getResources().getString(R$string.input_unknow_text), Arrays.copyOf(new Object[]{""}, 1)));
        s sVar = s.f23381a;
        TextView textView = K.C;
        textView.setOnClickListener(new b(textView, 800, this));
        TextView textView2 = K.D;
        textView2.setOnClickListener(new c(textView2, 800, this, K));
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(K.getRoot());
        Window window = dialog.getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.height = -2;
        }
        if (attributes != null) {
            attributes.width = -2;
        }
        if (window != null) {
            window.setAttributes(attributes);
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

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        String str = null;
        this.f18052b = bundle != null ? bundle.getString("liveId") : null;
        if (bundle != null) {
            str = bundle.getString("userSign");
        }
        this.f18053c = str;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
