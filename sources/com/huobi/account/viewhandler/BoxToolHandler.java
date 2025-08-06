package com.huobi.account.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.account.bean.BoxToolRespBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import gs.g;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;

public class BoxToolHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(BoxToolRespBean.ToolBean toolBean, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "我的工具");
        hashMap.put("business_category", toolBean.a());
        hashMap.put("type", "normal");
        g.i("box_Me_click", hashMap);
        BaseModuleConfig.a().k0(toolBean.e());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, BoxToolRespBean.ToolBean toolBean, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getContext();
        ImageView imageView = (ImageView) e11.b(R.id.img);
        TextView textView = (TextView) e11.b(R.id.title);
        b.c().h(imageView, NightHelper.e().g() ? toolBean.c() : toolBean.d());
        textView.setText(toolBean.f());
        int i12 = 0;
        e11.b(R.id.line_end).setVisibility(i11 % 2 == 0 ? 0 : 8);
        View b11 = e11.b(R.id.line_bottom);
        if (i11 >= 2) {
            i12 = 8;
        }
        b11.setVisibility(i12);
        if (!TextUtils.isEmpty(toolBean.e())) {
            cVar.itemView.setOnClickListener(new vg.b(toolBean));
        }
    }

    public int getResId() {
        return R.layout.part_home_account_box_tool_item;
    }
}
