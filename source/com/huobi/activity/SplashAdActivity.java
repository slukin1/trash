package com.huobi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bh.j;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.network.hbg.core.bean.AdConfig;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import e7.s;
import gs.g;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import xg.r0;
import xg.s0;

public class SplashAdActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    public TextView f42104b;

    /* renamed from: c  reason: collision with root package name */
    public long f42105c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Subscriber<Long> f42106d;

    /* renamed from: e  reason: collision with root package name */
    public AdConfig.OpenScreenAdv f42107e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f42108f = new Handler(new a());

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            SplashAdActivity.this.e();
            return false;
        }
    }

    public class b extends BaseSubscriber<Long> {
        public b() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            Message message = new Message();
            message.obj = l11;
            message.what = 1;
            SplashAdActivity.this.f42108f.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        zn.a.d().v(Uri.parse(this.f42107e.jumpTo));
        zn.a.d().c();
        k("flash_click", this.f42107e);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        k("flash_close", this.f42107e);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void j(Context context) {
        long g11 = SP.g("splash_ad_recent_show_time", 0);
        if (g11 > 0 && com.huobi.lifecycle.a.j().i().openScreenCommonConfig.interval > ((int) ((System.currentTimeMillis() - g11) / 60000))) {
            return;
        }
        if (!SP.l("isAdEnabled", true)) {
            SP.y("isAdEnabled", true);
            return;
        }
        Intent intent = new Intent(context, SplashAdActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
        SP.r("splash_ad_recent_show_time", System.currentTimeMillis());
    }

    public final void e() {
        long j11 = this.f42105c - 1;
        this.f42105c = j11;
        if (j11 >= 0) {
            TextView textView = this.f42104b;
            textView.setText(this.f42105c + s.f70071a);
            return;
        }
        m();
        finish();
    }

    public final Subscriber<Long> f() {
        return new b();
    }

    public void g() {
        AdConfig i11 = com.huobi.lifecycle.a.j().i();
        AdConfig.OpenScreenAdv m11 = com.huobi.lifecycle.a.j().m();
        this.f42107e = m11;
        if (m11 == null) {
            finish();
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.iv_ad);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOnClickListener(new s0(this));
        ((c) com.bumptech.glide.a.v(j.c().getApplicationContext()).q(this.f42107e.imageUrl).h(DiskCacheStrategy.f63711c)).D0(imageView);
        ((TextView) findViewById(R.id.tv_skip)).setOnClickListener(new r0(this));
        TextView textView = (TextView) findViewById(R.id.tv_countdown);
        this.f42104b = textView;
        textView.setText(i11.openScreenCommonConfig.duration + s.f70071a);
        this.f42105c = (long) i11.openScreenCommonConfig.duration;
        com.huobi.lifecycle.a j11 = com.huobi.lifecycle.a.j();
        long j12 = this.f42107e.advId;
        j11.t(j12, j11.k(j12) + 1);
        j11.v(j11.n() + 1);
        j11.u();
        k("flash_show", this.f42107e);
    }

    public final void k(String str, AdConfig.OpenScreenAdv openScreenAdv) {
        HashMap hashMap = new HashMap();
        hashMap.put("flash_id", Long.valueOf(openScreenAdv.advId));
        hashMap.put("flash_name", openScreenAdv.advName);
        hashMap.put("material_id", Long.valueOf(openScreenAdv.materialId));
        hashMap.put("material_name", openScreenAdv.materialName);
        g.i(str, hashMap);
    }

    public final void l() {
        if (this.f42106d == null) {
            this.f42106d = f();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).subscribe(this.f42106d);
        }
    }

    public final void m() {
        Subscriber<Long> subscriber = this.f42106d;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().addFlags(Integer.MIN_VALUE);
        setContentView(R.layout.app_ad_activity_layout);
        g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mScreenAdv -- imageUrl:");
        AdConfig.OpenScreenAdv openScreenAdv = this.f42107e;
        sb2.append(openScreenAdv != null ? openScreenAdv.imageUrl : "mScreenAdv is null");
        Log.d("SplashAdActivity", sb2.toString());
        if (this.f42107e != null) {
            l();
        }
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
