package com.huobi.account.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.account.bean.KnapsackItem;
import dw.a;
import gs.g;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;

public class KnapsackHandler implements c {
    public static /* synthetic */ void d(KnapsackItem.BagItem bagItem, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "我的背包");
        hashMap.put("business_category", bagItem.a());
        hashMap.put("type", "normal");
        g.i("box_Me_click", hashMap);
        BaseModuleConfig.a().k0(bagItem.f());
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, KnapsackItem.BagItem bagItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.count);
        TextView textView2 = (TextView) e11.b(R.id.title);
        int i12 = 0;
        if (m.a(bagItem.d()).compareTo(BigDecimal.ZERO) >= 1) {
            textView.setText(String.format("+%s", new Object[]{bagItem.d()}));
            if (context != null) {
                textView.setTextColor(context.getResources().getColor(R.color.base_up_color));
            }
        } else {
            textView.setText(bagItem.c());
            if (context != null) {
                textView.setTextColor(context.getResources().getColor(R.color.baseColorPrimaryText));
            }
        }
        textView2.setText(bagItem.e());
        e11.b(R.id.line_end).setVisibility(i11 % 2 == 0 ? 0 : 8);
        View b11 = e11.b(R.id.line_bottom);
        if (i11 >= 2) {
            i12 = 8;
        }
        b11.setVisibility(i12);
        if (!TextUtils.isEmpty(bagItem.f())) {
            a.a(cVar.itemView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new sg.a(bagItem));
        }
    }

    public int getResId() {
        return R.layout.part_home_account_box_knapsack_item;
    }
}
