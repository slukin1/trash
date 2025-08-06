package com.huobi.kyc.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import um.a0;
import um.z;

public class VerificationTipsDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public String f74909b;

    /* renamed from: c  reason: collision with root package name */
    public a[] f74910c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f74911a;

        /* renamed from: b  reason: collision with root package name */
        public final String f74912b;

        /* renamed from: c  reason: collision with root package name */
        public final String f74913c;

        /* renamed from: d  reason: collision with root package name */
        public final View.OnClickListener f74914d;

        public a(int i11, String str, String str2, View.OnClickListener onClickListener) {
            this.f74911a = i11;
            this.f74912b = str;
            this.f74913c = str2;
            this.f74914d = onClickListener;
        }

        public final View b(Context context) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_verification_operate, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.iv_item_icon)).setImageResource(this.f74911a);
            ((TextView) inflate.findViewById(R.id.tv_item_title)).setText(this.f74912b);
            ((TextView) inflate.findViewById(R.id.tv_item_subtitle)).setText(this.f74913c);
            inflate.setOnClickListener(this.f74914d);
            return inflate;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        uh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        uh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.view_empty).setOnClickListener(new z(this));
        rVar.b(R.id.tv_close).setOnClickListener(new a0(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_verification_tips_container;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.e(R.id.tv_content).setText(this.f74909b);
        a[] aVarArr = this.f74910c;
        if (aVarArr != null && aVarArr.length > 0) {
            LinearLayout linearLayout = (LinearLayout) rVar.b(R.id.ll_controller);
            for (a a11 : this.f74910c) {
                linearLayout.addView(a11.b(linearLayout.getContext()));
            }
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void setContent(String str) {
        this.f74909b = str;
    }

    public final void uh() {
        doDismiss();
    }

    public void vh(a[] aVarArr) {
        this.f74910c = aVarArr;
    }
}
