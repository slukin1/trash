package com.huobi.finance.viewhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bl.e3;
import bl.f3;
import bl.g3;
import bl.h3;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.ui.AddAddrRiskActivity;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import pro.huobi.R;
import s9.c;

public class VirtualAddressViewHander implements c {

    /* renamed from: b  reason: collision with root package name */
    public GradientDrawable f67637b = new GradientDrawable();

    /* renamed from: c  reason: collision with root package name */
    public float f67638c = ((float) PixelUtils.a(3.0f));

    public interface a {
        void a(VirtualAddressInfo virtualAddressInfo);
    }

    public static /* synthetic */ void h(VirtualAddressInfo virtualAddressInfo, HBDialogFragment hBDialogFragment) {
        if (virtualAddressInfo.getOnDeleteClickListener() != null) {
            virtualAddressInfo.getOnDeleteClickListener().a(virtualAddressInfo);
        }
        hBDialogFragment.dismiss();
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(VirtualAddressInfo virtualAddressInfo, Context context, View view) {
        DialogUtils.c0((FragmentActivity) oa.a.g().b(), virtualAddressInfo.getAlias(), context.getString(R.string.address_delete_hint), context.getString(R.string.n_otc_new_otc_cancel), context.getString(R.string.address_delete_confirm), h3.f12608a, new g3(virtualAddressInfo));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(boolean z11, VirtualAddressInfo virtualAddressInfo, Context context, View view) {
        if (z11) {
            AddAddrRiskActivity.Gh(view.getContext(), String.valueOf(virtualAddressInfo.getId()));
        } else {
            Intent intent = new Intent();
            intent.putExtra("select_withdraw_address", virtualAddressInfo);
            Activity activity = (Activity) context;
            activity.setResult(-1, intent);
            activity.finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, VirtualAddressInfo virtualAddressInfo, ViewGroup viewGroup) {
        v9.c cVar2 = cVar;
        VirtualAddressInfo virtualAddressInfo2 = virtualAddressInfo;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        View b11 = e11.b(R.id.address_root);
        TextView textView = (TextView) e11.b(R.id.withdraw_address_remarks_tv);
        TextView textView2 = (TextView) e11.b(R.id.withdraw_chain_tv);
        TextView textView3 = (TextView) e11.b(R.id.withdraw_tag_tv);
        ImageView imageView = (ImageView) e11.b(R.id.delete);
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.withdraw_address_tag_ll);
        TextView textView4 = (TextView) e11.b(R.id.tv_verify);
        textView4.setVisibility(8);
        ((TextView) e11.b(R.id.withdraw_address_tv)).setText(virtualAddressInfo.getAddress());
        if (i11 == 0) {
            this.f67637b.setCornerRadius(this.f67638c);
            this.f67637b.setColor(ContextCompat.getColor(cVar2.itemView.getContext(), R.color.currency_order_detail_save_bg));
        }
        textView4.setText(String.format("(%s)", new Object[]{textView4.getContext().getResources().getString(R.string.currency_detail_status_verifying)}));
        boolean equalsIgnoreCase = VirtualAddressInfo.LEVEL_PROCESSING.equalsIgnoreCase(virtualAddressInfo.getLevel());
        ViewUtil.m(textView4, equalsIgnoreCase);
        String e12 = DepositWithdrawHelper.e(k.C().F(virtualAddressInfo.getCurrency(), virtualAddressInfo.getChain()));
        if (!TextUtils.isEmpty(e12)) {
            textView2.setBackground(this.f67637b);
            textView2.setText(String.format("%s %s", new Object[]{e12, context.getString(R.string.n_withdraw_address_chain)}));
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        imageView.setOnClickListener(new e3(virtualAddressInfo2, context));
        textView.setText(virtualAddressInfo.getAlias());
        b11.setOnClickListener(new f3(equalsIgnoreCase, virtualAddressInfo2, context));
        if (virtualAddressInfo.isChecked()) {
            cVar2.itemView.setBackgroundResource(R.drawable.selector_address_item_checked_bg);
        } else {
            cVar2.itemView.setBackgroundResource(R.drawable.selector_common_item_bg);
        }
        if (k.C().K(virtualAddressInfo.getCurrency(), virtualAddressInfo.getChain())) {
            linearLayout.setVisibility(0);
            textView3.setText(virtualAddressInfo.getTag());
            return;
        }
        linearLayout.setVisibility(8);
    }

    public int getResId() {
        return R.layout.item_manager_withdraw_address;
    }
}
