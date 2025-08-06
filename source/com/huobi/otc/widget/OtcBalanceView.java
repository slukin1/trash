package com.huobi.otc.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.OtcChannelInfo;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import g6.b;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import tx.a;

public class OtcBalanceView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79945b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79946c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f79947d;

    public OtcBalanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        View.inflate(context, R$layout.item_otc_fast_balance, this);
        this.f79945b = (TextView) findViewById(R$id.tv_balance_num);
        this.f79946c = (TextView) findViewById(R$id.tv_balance_recharge);
        this.f79947d = (LinearLayout) findViewById(R$id.ll_images);
    }

    public void setBalanceNum(String str) {
        this.f79945b.setText(str);
    }

    public void setImageList(List<OtcChannelInfo> list) {
        int i11;
        this.f79947d.removeAllViews();
        if (list != null && !list.isEmpty()) {
            int i12 = 0;
            while (i12 < list.size()) {
                OtcChannelInfo otcChannelInfo = list.get(i12);
                if (!TextUtils.isEmpty(otcChannelInfo.getPaymentIconUrl())) {
                    ImageView imageView = new ImageView(getContext());
                    int a11 = UIUtil.a(getContext(), 16.0d);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a11, a11);
                    layoutParams.rightMargin = UIUtil.a(getContext(), 5.0d);
                    this.f79947d.addView(imageView, layoutParams);
                    if (NightHelper.e().g()) {
                        i11 = R$drawable.balance_channel_default_icon_night;
                    } else {
                        i11 = R$drawable.balance_channel_default_icon;
                    }
                    int i13 = i11;
                    b.c().j(imageView, otcChannelInfo.getPaymentIconUrl(), i13, b.c().f(i13, UIUtil.a(getContext(), 3.0d)), (a) null);
                }
                if (i12 != 2) {
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public void setOnRechargeClickListener(View.OnClickListener onClickListener) {
        this.f79946c.setOnClickListener(onClickListener);
    }
}
