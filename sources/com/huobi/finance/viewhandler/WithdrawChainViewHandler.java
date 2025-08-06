package com.huobi.finance.viewhandler;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bl.i3;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.huobi.finance.bean.ChainItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;

public class WithdrawChainViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public float f67639b = ((float) PixelUtils.a(5.0f));

    /* renamed from: c  reason: collision with root package name */
    public float f67640c = ((float) PixelUtils.a(0.5f));

    /* renamed from: d  reason: collision with root package name */
    public int f67641d;

    /* renamed from: e  reason: collision with root package name */
    public int f67642e;

    /* renamed from: f  reason: collision with root package name */
    public int f67643f;

    @SensorsDataInstrumented
    public static /* synthetic */ void d(boolean z11, ChainItem chainItem, int i11, ChainInfo chainInfo, View view) {
        if (z11) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (chainItem.c() != null) {
            chainItem.c().b(i11, chainInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, ChainItem chainItem, ViewGroup viewGroup) {
        ChainInfo chainInfo;
        TextView textView = (TextView) cVar.e().b(R.id.balance_header_hint);
        if (chainItem == null) {
            chainInfo = null;
        } else {
            chainInfo = chainItem.d();
        }
        if (i11 == 0) {
            this.f67641d = ContextCompat.getColor(cVar.itemView.getContext(), R.color.baseColorMajorTheme100);
            this.f67642e = ContextCompat.getColor(cVar.itemView.getContext(), R.color.baseColorDeepestBackground);
            this.f67643f = ContextCompat.getColor(cVar.itemView.getContext(), R.color.baseColorPrimaryText);
        }
        if (chainInfo != null) {
            textView.setText(chainInfo.getDisplayName());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f67639b);
        boolean z11 = (chainItem == null || chainItem.c() == null || !chainItem.c().a(i11, chainInfo)) ? false : true;
        if (z11) {
            gradientDrawable.setStroke((int) this.f67640c, this.f67641d);
            textView.setTextColor(this.f67641d);
        } else {
            gradientDrawable.setColor(this.f67642e);
            textView.setTextColor(this.f67643f);
        }
        gradientDrawable.setCornerRadius(this.f67639b);
        cVar.itemView.setBackground(gradientDrawable);
        cVar.itemView.setOnClickListener(new i3(z11, chainItem, i11, chainInfo));
    }

    public int getResId() {
        return R.layout.item_chain_withdraw;
    }
}
