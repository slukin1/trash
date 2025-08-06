package com.huobi.future.ui;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$style;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.future.bean.FutureTpSlOrderDialogItem;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hl.a;
import i6.r;
import java.util.List;

public class FutureTpSlDetailDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView f72455b;

    /* renamed from: c  reason: collision with root package name */
    public View f72456c;

    /* renamed from: d  reason: collision with root package name */
    public List<FutureTpSlOrderDialogItem> f72457d;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f72456c.setOnClickListener(new a(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_future_tp_sl_detail;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f72456c = rVar.b(R$id.iv_close);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) rVar.b(R$id.detail_rv);
        this.f72455b = easyRecyclerView;
        easyRecyclerView.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getContext(), R$color.baseColorPrimarySeparator), PixelUtils.a(1.0f), false, false));
        List<FutureTpSlOrderDialogItem> list = this.f72457d;
        if (list != null) {
            this.f72455b.setData(list);
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void tc(List<FutureTpSlOrderDialogItem> list) {
        this.f72457d = list;
    }
}
