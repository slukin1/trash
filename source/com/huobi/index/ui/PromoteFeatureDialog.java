package com.huobi.index.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.index.bean.IndexFeatureItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import i6.n;
import i6.r;
import java.io.Serializable;
import pro.huobi.R;
import yl.o;

public class PromoteFeatureDialog extends BaseDialogFragment {

    /* renamed from: e  reason: collision with root package name */
    public static IndexFeatureItem f73801e;

    /* renamed from: b  reason: collision with root package name */
    public View f73802b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f73803c;

    /* renamed from: d  reason: collision with root package name */
    public IndexFeatureItem f73804d;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        o.p(getActivity(), this.f73804d);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static IndexFeatureItem uh() {
        return f73801e;
    }

    public static PromoteFeatureDialog wh(IndexFeatureItem indexFeatureItem) {
        PromoteFeatureDialog promoteFeatureDialog = new PromoteFeatureDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PROMOTE_FEATURE", indexFeatureItem);
        promoteFeatureDialog.setArguments(bundle);
        return promoteFeatureDialog;
    }

    public static void xh(IndexFeatureItem indexFeatureItem) {
        f73801e = indexFeatureItem;
    }

    public void addEvent(r rVar) {
        this.f73803c.setOnClickListener(new o1(this));
        this.f73802b.setOnClickListener(new p1(this));
    }

    public void afterInit() {
        IndexFeatureItem indexFeatureItem = this.f73804d;
        if (indexFeatureItem != null && !TextUtils.isEmpty(indexFeatureItem.getImgUrl())) {
            b.c().h(this.f73803c, this.f73804d.getImgUrl());
        }
    }

    public int getContentViewResId() {
        return R.layout.dialog_promote_feature;
    }

    public int getGravity() {
        return 8388611;
    }

    public void initView(r rVar) {
        vh();
        ConstraintLayout constraintLayout = (ConstraintLayout) rVar.b(R.id.cl_push_feature);
        View b11 = rVar.b(R.id.header);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = (n.f(b11.getContext()) - n.h(b11.getContext())) / 5;
        b11.setLayoutParams(layoutParams);
        this.f73803c = (ImageView) rVar.b(R.id.iv_poster);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.p(constraintLayout);
        constraintSet.R(R.id.iv_poster, String.valueOf(0.7375f));
        constraintSet.i(constraintLayout);
        this.f73802b = rVar.b(R.id.iv_close);
    }

    public boolean isTransparent() {
        return false;
    }

    public final void vh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("PROMOTE_FEATURE");
            if (serializable instanceof IndexFeatureItem) {
                this.f73804d = (IndexFeatureItem) serializable;
            }
        }
    }
}
