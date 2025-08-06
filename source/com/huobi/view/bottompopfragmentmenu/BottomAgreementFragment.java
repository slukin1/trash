package com.huobi.view.bottompopfragmentmenu;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.CommonCheckBox;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import pro.huobi.R;

public class BottomAgreementFragment extends DialogFragment {
    private View.OnClickListener agreeListener;
    private View btnConfirm;
    private Builder builder;
    private CommonCheckBox cbConfirm;
    private Window window;

    public static class Builder {
        private String body;
        private String confirmLabel;
        private View.OnClickListener onConfirmListener;
        private String subTitle;
        private String title;

        public String getBody() {
            return this.body;
        }

        public String getConfirmLabel() {
            return this.confirmLabel;
        }

        public View.OnClickListener getOnConfirmListener() {
            return this.onConfirmListener;
        }

        public String getSubTitle() {
            return this.subTitle;
        }

        public String getTitle() {
            return this.title;
        }

        public Builder setBody(String str) {
            this.body = str;
            return this;
        }

        public Builder setConfirmLabel(String str) {
            this.confirmLabel = str;
            return this;
        }

        public Builder setOnConfirmListener(View.OnClickListener onClickListener) {
            this.onConfirmListener = onClickListener;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public void show(Activity activity) {
            BottomAgreementFragment bottomAgreementFragment = new BottomAgreementFragment();
            bottomAgreementFragment.setBuilder(this);
            bottomAgreementFragment.show(activity.getFragmentManager(), BottomAgreementFragment.class.getSimpleName());
        }
    }

    private View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_agreement, viewGroup, false);
        this.cbConfirm = (CommonCheckBox) inflate.findViewById(R.id.cb_confirm);
        View findViewById = inflate.findViewById(R.id.btn_confirm);
        this.btnConfirm = findViewById;
        findViewById.setEnabled(false);
        ((TextView) inflate.findViewById(R.id.tv_title)).setText(this.builder.getTitle());
        ((TextView) inflate.findViewById(R.id.tv_sub_title)).setText(this.builder.getSubTitle());
        ((TextView) inflate.findViewById(R.id.tv_body)).setText(this.builder.getBody());
        ((TextView) inflate.findViewById(R.id.tv_cb_confirm_label)).setText(this.builder.getConfirmLabel());
        this.agreeListener = this.builder.getOnConfirmListener();
        inflate.findViewById(R.id.btn_cancel).setOnClickListener(new c(this));
        this.btnConfirm.setOnClickListener(new a(this));
        inflate.findViewById(R.id.ll_cb_confirm).setOnClickListener(new b(this));
        return inflate;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        View.OnClickListener onClickListener = this.agreeListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$2(View view) {
        this.cbConfirm.toggle();
        this.btnConfirm.setEnabled(this.cbConfirm.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        Window window2 = getDialog().getWindow();
        this.window = window2;
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
            this.window.setWindowAnimations(R.style.menu_animation);
        }
        return initView(layoutInflater, viewGroup);
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
        super.onStart();
        Window window2 = this.window;
        if (window2 != null) {
            window2.setLayout(PixelUtils.g(), this.window.getAttributes().height);
            WindowManager.LayoutParams attributes = this.window.getAttributes();
            attributes.gravity = 80;
            this.window.setAttributes(attributes);
        }
    }

    public void onStop() {
        View view = getView();
        if (view != null) {
            view.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.menu_disappear));
        }
        super.onStop();
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setBuilder(Builder builder2) {
        this.builder = builder2;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.beginTransaction().remove(this).commit();
            super.show(fragmentManager, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
