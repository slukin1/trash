package com.huobi.otc.helper;

import android.app.Activity;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.bean.OtcNewOrderInfo;
import com.huobi.otc.service.OTCService;
import i6.i;
import java.util.HashMap;
import java.util.Locale;
import u6.g;

public class OtcNewOrderTipHelper {

    /* renamed from: a  reason: collision with root package name */
    public static MediaPlayer f78904a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f78905b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f78906c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f78907d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f78908e = false;

    /* renamed from: f  reason: collision with root package name */
    public static HashMap f78909f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public static Runnable f78910g = new a();

    public class a implements Runnable {
        public void run() {
            OtcNewOrderTipHelper.n();
        }
    }

    public class b extends EasySubscriber<OtcNewOrderInfo> {

        public class a implements MediaPlayer.OnPreparedListener {
            public a() {
            }

            public void onPrepared(MediaPlayer mediaPlayer) {
                boolean unused = OtcNewOrderTipHelper.f78908e = true;
                mediaPlayer.start();
            }
        }

        /* renamed from: a */
        public void onNext(OtcNewOrderInfo otcNewOrderInfo) {
            super.onNext(otcNewOrderInfo);
            if (!OtcNewOrderTipHelper.f78907d && otcNewOrderInfo != null && otcNewOrderInfo.getOrderCount() > OtcNewOrderTipHelper.f78906c) {
                int unused = OtcNewOrderTipHelper.f78906c = otcNewOrderInfo.getOrderCount();
                if (OtcNewOrderTipHelper.f78904a == null) {
                    try {
                        MediaPlayer unused2 = OtcNewOrderTipHelper.f78904a = new MediaPlayer();
                        OtcNewOrderTipHelper.f78904a.setAudioStreamType(3);
                        boolean unused3 = OtcNewOrderTipHelper.f78908e = false;
                        OtcNewOrderTipHelper.f78904a.setOnPreparedListener(new a());
                    } catch (Exception unused4) {
                    }
                }
                if (!TextUtils.equals(OtcNewOrderTipHelper.m(), OtcNewOrderTipHelper.f78905b)) {
                    OtcNewOrderTipHelper.f78904a.reset();
                    boolean unused5 = OtcNewOrderTipHelper.f78908e = false;
                    String unused6 = OtcNewOrderTipHelper.f78905b = OtcNewOrderTipHelper.m();
                    try {
                        OtcNewOrderTipHelper.f78904a.setDataSource(OtcNewOrderTipHelper.f78905b);
                        OtcNewOrderTipHelper.f78904a.prepareAsync();
                    } catch (Exception unused7) {
                    }
                } else if (OtcNewOrderTipHelper.f78908e) {
                    OtcNewOrderTipHelper.f78904a.start();
                }
            }
        }

        public void onAfter() {
            super.onAfter();
            if (OtcNewOrderTipHelper.f78907d) {
                return;
            }
            if (OtcModuleConfig.a().a()) {
                OtcNewOrderTipHelper.p();
            } else {
                OtcNewOrderTipHelper.q();
            }
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public static String m() {
        Activity b11 = oa.a.g().b();
        if (b11 == null) {
            return null;
        }
        Locale locale = b11.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (!"zh".equalsIgnoreCase(language) || !"CN".equalsIgnoreCase(country)) {
            return p.c(b11) ? "https://otc-static.hbfile.net/common/audio/order/otc-order-ru.mp3" : "https://otc-static.hbfile.net/common/audio/order/otc-order-en.mp3";
        }
        return "https://otc-static.hbfile.net/common/audio/order/otc-order-cn.mp3";
    }

    public static void n() {
        if (!f78907d) {
            f78909f.put("orderIds", "");
            ((OTCService) OtcRetrofit.request(OTCService.class)).getNewOrder(f78909f).compose(OtcRetrofit.o()).compose(RxJavaHelper.t((g) null)).subscribe(new b());
        }
    }

    public static void o() {
        String uid = OtcModuleConfig.a().getUid();
        if ("1".equalsIgnoreCase(ConfigPreferences.e("user_config", "com.p2p.newOrder.hint." + uid, "1"))) {
            f78907d = false;
            p();
        }
    }

    public static void p() {
        if (!f78907d) {
            i.b().h(f78910g);
            i.b().g(f78910g, 5000);
        }
    }

    public static void q() {
        f78907d = true;
        i.b().h(f78910g);
        MediaPlayer mediaPlayer = f78904a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            f78904a = null;
        }
    }
}
