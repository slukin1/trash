package com.huobi.setting.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import hr.d;
import i6.r;
import java.util.concurrent.TimeUnit;
import kr.f;
import pro.huobi.R;
import s9.c;

public class SettingItemHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public long f80835b;

    /* access modifiers changed from: private */
    public /* synthetic */ void d(v9.c cVar, Void voidR) {
        onClick(cVar.itemView);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        if (cVar != null && dVar != null) {
            Resources resources = cVar.itemView.getResources();
            r e11 = cVar.e();
            TextView textView = (TextView) e11.b(R.id.id_setting_list_item_title);
            TextView textView2 = (TextView) e11.b(R.id.id_setting_list_item_desc);
            View b11 = e11.b(R.id.id_setting_list_item_dot);
            View b12 = e11.b(R.id.id_setting_list_item_divider);
            ViewUtil.m(b12, dVar.a());
            cVar.itemView.setTag(dVar);
            a.a(cVar.itemView).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new f(this, cVar));
            cVar.itemView.setOnClickListener(this);
            d.a aVar = dVar.f84201c;
            if (aVar != null) {
                textView.setText(aVar.a(dVar.f84200b));
                textView2.setText(dVar.f84201c.D(dVar.f84200b));
                if (!dVar.f84201c.E8(dVar.f84200b, b12)) {
                    b12.setBackgroundColor(resources.getColor(R.color.global_divider_color));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b12.getLayoutParams();
                    layoutParams.leftMargin = resources.getDimensionPixelOffset(R.dimen.dimen_15);
                    layoutParams.height = resources.getDimensionPixelOffset(R.dimen.global_divider_height);
                    b12.setLayoutParams(layoutParams);
                }
                b11.setVisibility(dVar.f84201c.v8(dVar.f84200b) ? 0 : 8);
            }
        }
    }

    public int getResId() {
        return R.layout.layout_setting_list_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        d.a aVar;
        if (System.currentTimeMillis() - this.f80835b > 1000) {
            this.f80835b = System.currentTimeMillis();
            d dVar = (d) view.getTag();
            if (!(dVar == null || (aVar = dVar.f84201c) == null)) {
                aVar.onItemClick(dVar.f84200b);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
