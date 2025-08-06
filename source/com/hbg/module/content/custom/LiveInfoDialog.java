package com.hbg.module.content.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import kotlin.jvm.internal.r;

public final class LiveInfoDialog extends DialogFragment {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18016d = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public String f18017b;

    /* renamed from: c  reason: collision with root package name */
    public String f18018c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final LiveInfoDialog a(FragmentManager fragmentManager, String str, String str2) {
            Fragment fragment;
            if (fragmentManager == null) {
                return null;
            }
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("LiveInfoDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                LiveInfoDialog liveInfoDialog = new LiveInfoDialog();
                Bundle bundle = new Bundle();
                bundle.putString("content", str);
                bundle.putString("title", str2);
                liveInfoDialog.setArguments(bundle);
                q11.e(liveInfoDialog, "LiveInfoDialog");
                q11.k();
                return liveInfoDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
                return null;
            }
        }
    }

    @SensorsDataInstrumented
    public static final void qh(Dialog dialog, View view) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        WindowManager.LayoutParams layoutParams = null;
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.dialog_live_info, (ViewGroup) null);
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
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
        TextView textView = (TextView) inflate.findViewById(R$id.tvContent);
        inflate.findViewById(R$id.vSpace).setOnClickListener(new g(dialog));
        TextView textView2 = (TextView) inflate.findViewById(R$id.tvTitle);
        if (!TextUtils.isEmpty(this.f18018c)) {
            textView2.setText(this.f18018c);
        }
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(this.f18017b);
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
        String string;
        String string2;
        super.setArguments(bundle);
        if (!(bundle == null || (string2 = bundle.getString("content")) == null)) {
            this.f18017b = string2;
        }
        if (bundle != null && (string = bundle.getString("title")) != null) {
            this.f18018c = string;
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
