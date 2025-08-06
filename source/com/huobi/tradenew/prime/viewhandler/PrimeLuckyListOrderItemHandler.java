package com.huobi.tradenew.prime.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.huobi.trade.prime.bean.PrimeLuckyListOrderItem;
import i6.r;
import pro.huobi.R;
import s9.c;

public class PrimeLuckyListOrderItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, PrimeLuckyListOrderItem primeLuckyListOrderItem, ViewGroup viewGroup) {
        int i12;
        r e11 = cVar.e();
        View b11 = e11.b(R.id.id_prime_order_list_item_layout);
        View b12 = e11.b(R.id.id_prime_order_list_item_line);
        TextView textView = (TextView) e11.b(R.id.id_prime_order_list_item_flag);
        TextView textView2 = (TextView) e11.b(R.id.id_prime_order_list_item_title);
        TextView textView3 = (TextView) e11.b(R.id.id_prime_order_list_item_status);
        ImageView imageView = (ImageView) e11.b(R.id.id_prime_order_list_item_img);
        b11.setBackgroundResource(primeLuckyListOrderItem.f() ? R.drawable.prime_shape_rect_see_detail_bg_big : R.drawable.shape_prime_order_bg_corner_2_5);
        if (primeLuckyListOrderItem.f()) {
            i12 = b12.getResources().getColor(R.color.prime);
        } else {
            i12 = b12.getResources().getColor(R.color.baseColorDefaultPlaceholder);
        }
        b12.setBackgroundColor(i12);
        textView2.setText(primeLuckyListOrderItem.d());
        if (TextUtils.isEmpty(primeLuckyListOrderItem.c())) {
            textView2.setTextColor(textView2.getResources().getColor(R.color.baseColorSecondaryText));
        } else {
            textView2.setTextColor(textView2.getResources().getColor(R.color.baseColorPrimaryText));
        }
        textView3.setText(primeLuckyListOrderItem.c());
        ViewUtil.m(textView, !primeLuckyListOrderItem.f());
        ViewUtil.m(imageView, primeLuckyListOrderItem.f());
    }

    public int getResId() {
        return R.layout.prime_lucky_list_order_item_layout;
    }
}
