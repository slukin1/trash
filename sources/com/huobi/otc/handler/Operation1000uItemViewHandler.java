package com.huobi.otc.handler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.Operation1000uItemData;
import i6.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import s9.c;

public class Operation1000uItemViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, Operation1000uItemData operation1000uItemData, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        TextView textView = (TextView) e11.b(R$id.u1000_detail_title);
        TextView textView2 = (TextView) e11.b(R$id.u1000_detail_time);
        ImageView imageView = (ImageView) e11.b(R$id.u1000_item_by_online);
        ImageView imageView2 = (ImageView) e11.b(R$id.u1000_item_by_order);
        TextView textView3 = (TextView) e11.b(R$id.u1000_item_by_online_text);
        TextView textView4 = (TextView) e11.b(R$id.u1000_item_by_order_text);
        if (operation1000uItemData.getType().equals("2")) {
            textView.setText(resources.getString(R$string.n_otc_advert_reward_ad_online_8h));
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
            textView3.setVisibility(0);
            textView4.setVisibility(8);
            if (!TextUtils.isEmpty(operation1000uItemData.getAdvertiseDays())) {
                textView3.setText(operation1000uItemData.getAdvertiseDays() + " " + resources.getString(R$string.n_day));
            }
        } else if (operation1000uItemData.getType().equals("1")) {
            textView.setText(resources.getString(R$string.n_otc_advert_reward_ad_success_order));
            imageView2.setVisibility(0);
            imageView.setVisibility(8);
            textView4.setVisibility(0);
            textView3.setVisibility(8);
        }
        if (operation1000uItemData.getType().equals("2")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            if (operation1000uItemData.getTime() != null) {
                textView2.setText(simpleDateFormat.format(new Date(Long.valueOf(Long.parseLong(operation1000uItemData.getTime())).longValue())));
            }
        } else if (operation1000uItemData.getType().equals("1")) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            if (operation1000uItemData.getTime() != null) {
                textView2.setText(simpleDateFormat2.format(new Date(Long.valueOf(Long.parseLong(operation1000uItemData.getTime())).longValue())));
            }
        }
    }

    public int getResId() {
        return R$layout.otc_operation_100u_item;
    }
}
