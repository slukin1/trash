package com.huobi.account.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SubscribeAllHeadHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, pg.c cVar2, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R.id.iv_timeline_block);
        View b11 = e11.b(R.id.vertical_divider1);
        TextView textView = (TextView) e11.b(R.id.tv_head_time);
        TextView textView2 = (TextView) e11.b(R.id.tv_head_hour_min);
        textView.setText(cVar2.g());
        textView2.setText(cVar2.f());
        if (cVar2.m()) {
            imageView.setBackgroundResource(R.drawable.timeline_block_subscribe_hightlight);
            textView.setTextColor(textView.getResources().getColor(R.color.community_black_font_color));
            textView2.setTextColor(textView.getResources().getColor(R.color.community_black_font_color));
        } else {
            imageView.setBackgroundResource(R.drawable.timeline_block_subscribe);
            textView.setTextColor(textView.getResources().getColor(R.color.message_tab_unselected));
            textView2.setTextColor(textView.getResources().getColor(R.color.message_tab_unselected));
        }
        if (cVar2.k()) {
            b11.setVisibility(0);
        } else {
            b11.setVisibility(8);
        }
    }

    public int getResId() {
        return R.layout.item_subscribe_all_head;
    }
}
