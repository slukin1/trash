package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class OtcOrderFilterMenuView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public String[] f80016b = {getResources().getString(R$string.n_otc_trade_type), getResources().getString(R$string.n_otc_trade_order_status), getResources().getString(R$string.n_otc_trade_order_area)};

    /* renamed from: c  reason: collision with root package name */
    public b f80017c;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f80018b;

        public a(int i11) {
            this.f80018b = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TextView textView = (TextView) view.findViewById(R$id.tv_order_filter_name);
            ImageView imageView = (ImageView) view.findViewById(R$id.iv_order_filter_arrow);
            if (!(textView == null || imageView == null)) {
                textView.setTextColor(OtcOrderFilterMenuView.this.getResources().getColor(R$color.baseColorMajorTheme100));
                imageView.setImageResource(R$drawable.otc_filter_arrow_select_up);
            }
            if (OtcOrderFilterMenuView.this.f80017c != null) {
                OtcOrderFilterMenuView.this.f80017c.onClick(this.f80018b);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface b {
        void a(int i11);

        void onClick(int i11);
    }

    public OtcOrderFilterMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void b(Context context) {
        View.inflate(context, R$layout.otc_order_filter_menu_layout, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_otc_filter_menu_content);
        for (int i11 = 0; i11 < linearLayout.getChildCount(); i11++) {
            View childAt = linearLayout.getChildAt(i11);
            TextView textView = (TextView) childAt.findViewById(R$id.tv_order_filter_name);
            if (textView != null) {
                String[] strArr = this.f80016b;
                textView.setText(strArr[i11 % strArr.length]);
            }
            childAt.setOnClickListener(new a(i11));
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        b bVar;
        super.onSizeChanged(i11, i12, i13, i14);
        if (i12 != i14 && (bVar = this.f80017c) != null) {
            bVar.a(i12);
        }
    }

    public void setOnFilterTypeClickListener(b bVar) {
        this.f80017c = bVar;
    }
}
