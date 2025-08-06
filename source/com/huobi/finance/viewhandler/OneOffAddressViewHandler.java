package com.huobi.finance.viewhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.huobi.finance.bean.OneOffAddress;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public class OneOffAddressViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OneOffAddress oneOffAddress, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R.id.one_off_address_state_iv);
        TextView textView = (TextView) e11.b(R.id.one_off_address_state_tv);
        TextView textView2 = (TextView) e11.b(R.id.one_off_address_tv);
        TextView textView3 = (TextView) e11.b(R.id.one_off_address_create_date_tv);
        textView3.setText(String.format(context.getString(R.string.currency_deposit_address_create_date), new Object[]{DateTimeUtils.j(oneOffAddress.getAssignedAt())}));
        textView2.setText(oneOffAddress.getAddress());
        if (OneOffAddress.STATE_ASSIGNED.equals(oneOffAddress.getState())) {
            imageView.setImageResource(R.drawable.address_unused_image);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_jump_btn_color));
            textView.setText(R.string.currency_deposit_one_off_address_not_used);
            textView2.setTextColor(ContextCompat.getColor(context, R.color.global_main_text_color));
            textView3.setTextColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
            view.setOnClickListener(this);
            view.setTag(R.id.item_data, oneOffAddress);
            return;
        }
        imageView.setImageResource(R.drawable.address_used_image);
        textView.setTextColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
        textView.setText(R.string.currency_deposit_one_off_address_used);
        textView2.setTextColor(ContextCompat.getColor(context, R.color.global_default_text_color));
        textView3.setTextColor(ContextCompat.getColor(context, R.color.global_default_text_color));
        view.setOnClickListener((View.OnClickListener) null);
    }

    public int getResId() {
        return R.layout.item_one_off_address_history;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Activity activity = (Activity) view.getContext();
        Intent intent = new Intent();
        intent.putExtra("one_off_address", (OneOffAddress) view.getTag(R.id.item_data));
        activity.setResult(-1, intent);
        activity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
