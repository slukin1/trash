package com.hbg.module.huobi.im.gift.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.hbg.module.huobi.im.utils.LiveGiftRule;
import com.tencent.imsdk.common.IMLog;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import id.o;
import id.p;
import java.util.HashMap;
import rd.q;

public final class LiveGiftFloatButton extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final String f19789b = LiveGiftFloatButton.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public View f19790c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19791d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19792e;

    /* renamed from: f  reason: collision with root package name */
    public CusMsgGiftSend f19793f;

    /* renamed from: g  reason: collision with root package name */
    public volatile CusMsgGiftSend f19794g;

    /* renamed from: h  reason: collision with root package name */
    public a f19795h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentActivity f19796i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19797j;

    public interface a {
        void a();
    }

    public LiveGiftFloatButton(Context context) {
        super(context);
        d(context);
    }

    public static final void i(LiveGiftFloatButton liveGiftFloatButton) {
        Integer prizeTime;
        Long startTime;
        Integer prizeTime2;
        Long startTime2;
        CusMsgGiftSend cusMsgGiftSend = liveGiftFloatButton.f19793f;
        if (cusMsgGiftSend != null) {
            if ((cusMsgGiftSend != null ? cusMsgGiftSend.getStartTime() : null) != null) {
                TextView textView = liveGiftFloatButton.f19791d;
                long j11 = 0;
                if (textView != null) {
                    CusMsgGiftSend cusMsgGiftSend2 = liveGiftFloatButton.f19793f;
                    long longValue = (cusMsgGiftSend2 == null || (startTime2 = cusMsgGiftSend2.getStartTime()) == null) ? 0 : startTime2.longValue();
                    CusMsgGiftSend cusMsgGiftSend3 = liveGiftFloatButton.f19793f;
                    textView.setText(DateUtils.c((longValue + ((long) (((cusMsgGiftSend3 == null || (prizeTime2 = cusMsgGiftSend3.getPrizeTime()) == null) ? 0 : prizeTime2.intValue()) * 1000))) - System.currentTimeMillis()));
                }
                CusMsgGiftSend cusMsgGiftSend4 = liveGiftFloatButton.f19793f;
                if (!(cusMsgGiftSend4 == null || (startTime = cusMsgGiftSend4.getStartTime()) == null)) {
                    j11 = startTime.longValue();
                }
                CusMsgGiftSend cusMsgGiftSend5 = liveGiftFloatButton.f19793f;
                if (j11 + ((long) (((cusMsgGiftSend5 == null || (prizeTime = cusMsgGiftSend5.getPrizeTime()) == null) ? 0 : prizeTime.intValue()) * 1000)) <= System.currentTimeMillis()) {
                    a aVar = liveGiftFloatButton.f19795h;
                    if (aVar != null) {
                        aVar.a();
                    }
                    View view = liveGiftFloatButton.f19790c;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    TextView textView2 = liveGiftFloatButton.f19791d;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    ImageView imageView = liveGiftFloatButton.f19792e;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        return;
                    }
                    return;
                }
                liveGiftFloatButton.h();
            }
        }
    }

    public static final void l(LiveGiftFloatButton liveGiftFloatButton, CusMsgGiftSend cusMsgGiftSend) {
        liveGiftFloatButton.k(cusMsgGiftSend, true);
    }

    public final void c() {
        setVisibility(8);
    }

    public final void d(Context context) {
        if (context instanceof FragmentActivity) {
            this.f19796i = (FragmentActivity) context;
        }
        addView(View.inflate(context, R$layout.lay_live_gift_float_btn, (ViewGroup) null));
        this.f19790c = findViewById(R$id.vBgLiveGiftFloatTime);
        this.f19791d = (TextView) findViewById(R$id.tvBgLiveGiftFloatTime);
        this.f19792e = (ImageView) findViewById(R$id.ivBgLiveGiftFloatTip);
    }

    public final void e() {
        this.f19793f = null;
    }

    public final void f() {
        setVisibility(0);
        n("APP_LIVE_notice_luckdraw");
    }

    public final void g(CusMsgGiftSend cusMsgGiftSend) {
        setVisibility(0);
        this.f19793f = cusMsgGiftSend;
        Integer rule = cusMsgGiftSend != null ? cusMsgGiftSend.getRule() : null;
        int value = LiveGiftRule.RULE_REALTIME.getValue();
        if (rule != null && rule.intValue() == value) {
            m();
        } else {
            int value2 = LiveGiftRule.RULE_FIXED_TIME.getValue();
            if (rule != null && rule.intValue() == value2) {
                h();
            } else {
                LiveGiftRule.RULE_TASK.getValue();
                if (rule != null) {
                    rule.intValue();
                }
            }
        }
        n("APP_LIVE_notice_luckdraw");
    }

    public final boolean getAlreadyTaskWatch() {
        return this.f19797j;
    }

    public final a getCountDownListener() {
        return this.f19795h;
    }

    public final CusMsgGiftSend getGiftBean() {
        return this.f19793f;
    }

    public final ImageView getIvBgLiveGiftFloatTip() {
        return this.f19792e;
    }

    public final FragmentActivity getMAct() {
        return this.f19796i;
    }

    public final TextView getTvBgLiveGiftFloatTime() {
        return this.f19791d;
    }

    public final View getVBgLiveGiftFloatTime() {
        return this.f19790c;
    }

    public final CusMsgGiftSend getWatchTimeGift() {
        return this.f19794g;
    }

    public final void h() {
        Integer prizeTime;
        Long startTime;
        FragmentActivity fragmentActivity = this.f19796i;
        if (fragmentActivity != null) {
            if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                CusMsgGiftSend cusMsgGiftSend = this.f19793f;
                long longValue = (cusMsgGiftSend == null || (startTime = cusMsgGiftSend.getStartTime()) == null) ? 0 : startTime.longValue();
                CusMsgGiftSend cusMsgGiftSend2 = this.f19793f;
                long intValue = (longValue + ((long) (((cusMsgGiftSend2 == null || (prizeTime = cusMsgGiftSend2.getPrizeTime()) == null) ? 0 : prizeTime.intValue()) * 1000))) - System.currentTimeMillis();
                if (intValue > 0) {
                    View view = this.f19790c;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    TextView textView = this.f19791d;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    ImageView imageView = this.f19792e;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    TextView textView2 = this.f19791d;
                    if (textView2 != null) {
                        textView2.setText(DateUtils.c(intValue));
                    }
                    getHandler().postDelayed(new o(this), 1000);
                    return;
                }
                View view2 = this.f19790c;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView textView3 = this.f19791d;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                ImageView imageView2 = this.f19792e;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            }
        }
    }

    public final void j(CusMsgGiftSend cusMsgGiftSend) {
        k(cusMsgGiftSend, false);
    }

    public final void k(CusMsgGiftSend cusMsgGiftSend, boolean z11) {
        CusMsgGiftSend cusMsgGiftSend2;
        if (!this.f19797j) {
            this.f19794g = cusMsgGiftSend;
            this.f19797j = true;
        } else if (!z11) {
            return;
        }
        FragmentActivity fragmentActivity = this.f19796i;
        if (fragmentActivity != null) {
            if ((fragmentActivity != null && !fragmentActivity.isFinishing()) && (cusMsgGiftSend2 = this.f19794g) != null) {
                setVisibility(0);
                View view = this.f19790c;
                if (view != null) {
                    view.setVisibility(0);
                }
                TextView textView = this.f19791d;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                ImageView imageView = this.f19792e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                String c11 = DateUtils.c(cusMsgGiftSend2.getLiveWatchTimeRemain() * ((long) 1000));
                TextView textView2 = this.f19791d;
                if (textView2 != null) {
                    textView2.setText(c11);
                }
                String str = this.f19789b;
                IMLog.d(str, "更新时间Button：" + this);
                String str2 = this.f19789b;
                IMLog.d(str2, "更新时间：" + c11);
                if (cusMsgGiftSend2.getLiveWatchTimeRemain() >= 1) {
                    cusMsgGiftSend2.setLiveWatchTimeRemain(cusMsgGiftSend2.getLiveWatchTimeRemain() - 1);
                    getHandler().postDelayed(new p(this, cusMsgGiftSend), 1000);
                    return;
                }
                cusMsgGiftSend2.setLiveWatchTimeRemain(0);
                this.f19797j = false;
                d dVar = d.f19724a;
                dVar.b0(false);
                View view2 = this.f19790c;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView textView3 = this.f19791d;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                ImageView imageView2 = this.f19792e;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                c();
                d.h(dVar, false, 1, (Object) null);
            }
        }
    }

    public final void m() {
        View view = this.f19790c;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.f19791d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f19792e;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public final void n(String str) {
        Object rule;
        HashMap hashMap = new HashMap();
        d dVar = d.f19724a;
        String k11 = dVar.k();
        if (k11 == null) {
            k11 = "";
        }
        hashMap.put("groupid", k11);
        String p11 = dVar.p();
        if (p11 == null) {
            p11 = "";
        }
        hashMap.put("liveid", p11);
        Object obj = "1";
        hashMap.put(VineCardUtils.PLAYER_CARD, obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        CusMsgGiftSend cusMsgGiftSend = this.f19793f;
        if (!(cusMsgGiftSend == null || (rule = cusMsgGiftSend.getRule()) == null)) {
            obj = rule;
        }
        sb2.append(obj);
        hashMap.put("lotterytype", sb2.toString());
        q.a(str, hashMap);
    }

    public final void o(CusMsgGiftSend cusMsgGiftSend) {
        if (this.f19794g != null) {
            long j11 = 0;
            long liveWatchTimeRemain = cusMsgGiftSend != null ? cusMsgGiftSend.getLiveWatchTimeRemain() : 0;
            CusMsgGiftSend cusMsgGiftSend2 = this.f19794g;
            if (cusMsgGiftSend2 != null) {
                j11 = cusMsgGiftSend2.getLiveWatchTimeRemain();
            }
            if (Math.abs(liveWatchTimeRemain - j11) > ((long) (cusMsgGiftSend != null ? cusMsgGiftSend.getMinUpdateSecond() : 0))) {
                this.f19794g = cusMsgGiftSend;
            }
        }
    }

    public final void setAlreadyTaskWatch(boolean z11) {
        this.f19797j = z11;
    }

    public final void setCountDownListener(a aVar) {
        this.f19795h = aVar;
    }

    public final void setGiftBean(CusMsgGiftSend cusMsgGiftSend) {
        this.f19793f = cusMsgGiftSend;
    }

    public final void setIvBgLiveGiftFloatTip(ImageView imageView) {
        this.f19792e = imageView;
    }

    public final void setMAct(FragmentActivity fragmentActivity) {
        this.f19796i = fragmentActivity;
    }

    public final void setTvBgLiveGiftFloatTime(TextView textView) {
        this.f19791d = textView;
    }

    public final void setVBgLiveGiftFloatTime(View view) {
        this.f19790c = view;
    }

    public final void setWatchTimeGift(CusMsgGiftSend cusMsgGiftSend) {
        this.f19794g = cusMsgGiftSend;
    }

    public LiveGiftFloatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public LiveGiftFloatButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(context);
    }
}
