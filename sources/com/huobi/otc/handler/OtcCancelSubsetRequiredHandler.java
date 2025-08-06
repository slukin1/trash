package com.huobi.otc.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import com.huobi.otc.widget.AutoWrapViewGroup;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import v9.c;

public class OtcCancelSubsetRequiredHandler extends OtcCancelNoSubsetHandler {
    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup) {
        super.handleView(cVar, i11, otcCancelReasonDataType, viewGroup);
        OtcCancelReasonBean dataBean = otcCancelReasonDataType.getDataBean();
        AutoWrapViewGroup autoWrapViewGroup = (AutoWrapViewGroup) cVar.e().b(R$id.vg_subset);
        View b11 = cVar.e().b(R$id.cl_required);
        TextView textView = (TextView) cVar.e().b(R$id.tv_required);
        if (!dataBean.isChecked() || !dataBean.hasSubset()) {
            b11.setVisibility(8);
            return;
        }
        b11.setVisibility(0);
        int a11 = UIUtil.a(autoWrapViewGroup.getContext(), 8.0d);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        autoWrapViewGroup.setSpacingHorizontal(a11);
        autoWrapViewGroup.setSpacingVertical(a11);
        autoWrapViewGroup.c(otcCancelReasonDataType, dataBean.getSubset(), otcCancelReasonDataType.getOnReasonClickListener(), textView.getMeasuredWidth());
    }

    /* renamed from: c */
    public void a(c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup, List<Object> list) {
        super.a(cVar, i11, otcCancelReasonDataType, viewGroup, list);
        ((AutoWrapViewGroup) cVar.e().b(R$id.vg_subset)).b(otcCancelReasonDataType.getDataBean().getSubset());
    }

    public boolean d() {
        return true;
    }

    public int getResId() {
        return R$layout.item_cancel_subset_required;
    }
}
