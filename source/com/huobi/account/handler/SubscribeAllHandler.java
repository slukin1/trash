package com.huobi.account.handler;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.account.widget.CountDownLayout;
import gs.g;
import i6.r;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import s9.c;
import sg.d;

public class SubscribeAllHandler implements c {

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLayout f40984b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ pg.c f40985c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Handler f40986d;

        public a(CountDownLayout countDownLayout, pg.c cVar, Handler handler) {
            this.f40984b = countDownLayout;
            this.f40985c = cVar;
            this.f40986d = handler;
        }

        public void run() {
            this.f40984b.setTime(this.f40985c.d() - (SystemClock.elapsedRealtime() - this.f40985c.e()));
            this.f40986d.postDelayed(this, 1000);
        }
    }

    public static /* synthetic */ void d(pg.c cVar, v9.c cVar2, Void voidR) {
        Intent intent = new Intent();
        intent.putExtra("url", cVar.j());
        intent.setClass(cVar2.itemView.getContext(), HBBaseWebActivity.class);
        cVar2.itemView.getContext().startActivity(intent);
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", cVar.c());
        g.i("My_Subscription_click", hashMap);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, pg.c cVar2, ViewGroup viewGroup) {
        r e11 = cVar.e();
        CountDownLayout countDownLayout = (CountDownLayout) e11.b(R.id.item_time_view);
        if (countDownLayout.getTag() instanceof Handler) {
            ((Handler) countDownLayout.getTag()).removeCallbacksAndMessages((Object) null);
        }
        Handler handler = new Handler();
        handler.postDelayed(new a(countDownLayout, cVar2, handler), 0);
        countDownLayout.setTag(handler);
        ((TextView) e11.b(R.id.title)).setText(cVar2.i());
        ((TextView) e11.b(R.id.name)).setText(cVar2.h());
        View b11 = e11.b(R.id.line);
        if (cVar2.l()) {
            b11.setVisibility(4);
            ((ViewGroup.MarginLayoutParams) b11.getLayoutParams()).topMargin = PixelUtils.a(22.0f);
        } else {
            b11.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) b11.getLayoutParams()).topMargin = PixelUtils.a(12.0f);
        }
        TextView textView = (TextView) e11.b(R.id.about_to_begin);
        if (TextUtils.isEmpty(cVar2.a())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(cVar2.a());
        }
        if (!TextUtils.isEmpty(cVar2.j())) {
            dw.a.a(cVar.itemView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new d(cVar2, cVar));
        }
    }

    public int getResId() {
        return R.layout.item_subscribe_all;
    }
}
