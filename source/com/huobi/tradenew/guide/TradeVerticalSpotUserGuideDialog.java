package com.huobi.tradenew.guide;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.coupon.bean.CouponReturn;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class TradeVerticalSpotUserGuideDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public c f82817b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeVerticalSpotUserGuideDialog.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeVerticalSpotUserGuideDialog.this.dismiss();
            if (TradeVerticalSpotUserGuideDialog.this.f82817b != null) {
                TradeVerticalSpotUserGuideDialog.this.f82817b.Df();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface c {
        void Df();
    }

    public TradeVerticalSpotUserGuideDialog(c cVar) {
        this.f82817b = cVar;
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.iv_close).setOnClickListener(new a());
        rVar.b(R.id.tv_go_study).setOnClickListener(new b());
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_trade_vertical_spot_user_guide;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        ((TextView) rVar.b(R.id.tv_title)).setText(getResources().getString(R.string.n_exchange_new_guide_brief, new Object[]{CouponReturn.TYPE_EXPERIENCE}));
    }

    public boolean isTransparent() {
        return false;
    }
}
