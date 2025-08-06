package com.huobi.otc.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.coupon.bean.CouponReturn;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class OtcOperation1000uContentView extends RelativeLayout {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableString f80009b;

        public a(SpannableString spannableString) {
            this.f80009b = spannableString;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            DialogUtils.Z((FragmentActivity) oa.a.g().b(), OtcOperation1000uContentView.this.getContext().getString(R$string.n_otc_advert_reward_ad_can_got_all), this.f80009b, (String) null, OtcOperation1000uContentView.this.getContext().getString(R$string.n_known), o0.f12469a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableString f80011b;

        public b(SpannableString spannableString) {
            this.f80011b = spannableString;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            DialogUtils.Z((FragmentActivity) oa.a.g().b(), OtcOperation1000uContentView.this.getContext().getString(R$string.n_otc_advert_reward_ad_online_got), this.f80011b, (String) null, OtcOperation1000uContentView.this.getContext().getString(R$string.n_known), o0.f12469a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableString f80013b;

        public c(SpannableString spannableString) {
            this.f80013b = spannableString;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            DialogUtils.Z((FragmentActivity) oa.a.g().b(), OtcOperation1000uContentView.this.getContext().getString(R$string.n_otc_advert_reward_ad_finish_got), this.f80013b, (String) null, OtcOperation1000uContentView.this.getContext().getString(R$string.n_known), o0.f12469a);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public OtcOperation1000uContentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SpannableString a(String str, String str2, String str3) {
        if (!str.contains(str2)) {
            str2 = str.contains(str3) ? str3 : "";
        }
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(str2);
        int length = str2.length() + indexOf;
        if (length < 0 || length > str.length()) {
            length = 0;
        }
        if (indexOf < 0 || indexOf > length) {
            indexOf = 0;
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R$color.otc_u1000_activity_text)), indexOf, length, 34);
        return spannableString;
    }

    public OtcOperation1000uContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.otc_operation_1000u_content, this);
        findViewById(R$id.operation_1000u_rule_highest).setOnClickListener(new a(a(context.getString(R$string.n_otc_advert_reward_ad_can_got_all_detail), "1,000 USDT", "1000 USDT")));
        findViewById(R$id.operation_1000u_rule_online).setOnClickListener(new b(a(context.getString(R$string.n_otc_advert_reward_ad_online_got_detail), "500 USDT", "500")));
        findViewById(R$id.operation_1000u_rule_order).setOnClickListener(new c(a(context.getString(R$string.n_otc_advert_reward_ad_finish_got_detail), "10 USDT", CouponReturn.TYPE_EXPERIENCE)));
        findViewById(R$id.otc_operation_1000u_content_root).setOnClickListener(new d());
    }
}
