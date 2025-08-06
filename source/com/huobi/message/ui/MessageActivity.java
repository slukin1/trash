package com.huobi.message.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.huobi.im.RedPoint.a;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.libkt.custom.indicator.navigator.CommonNavigator;
import com.hbg.module.libkt.custom.indicator.navigator.adapter.NavigatorAdapter;
import com.hbg.module.libkt.custom.indicator.navigator.indicators.LinePagerIndicator;
import com.hbg.module.libkt.custom.indicator.navigator.titles.PagerTitleView;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.NewAccountTabRedDotHelper;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.presentation.screen.questionnary.SNSQuestionnaireFragment;
import java.util.ArrayList;
import java.util.HashMap;
import ko.f;
import ko.g;
import ko.h;
import ko.r;
import lj.q;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rd.s;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Route(path = "/account/MessageCenter")
public class MessageActivity extends BaseActivity<q> {

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<TabData> f77979i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<Fragment> f77980j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public int f77981k = 0;

    /* renamed from: l  reason: collision with root package name */
    public View f77982l;

    /* renamed from: m  reason: collision with root package name */
    public View f77983m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f77984n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f77985o;

    /* renamed from: p  reason: collision with root package name */
    public View f77986p;

    /* renamed from: q  reason: collision with root package name */
    public View f77987q;

    /* renamed from: r  reason: collision with root package name */
    public a.C0138a f77988r = new c();

    /* renamed from: s  reason: collision with root package name */
    public a.C0138a f77989s = new d();

    public class a extends NavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void i(int i11, View view) {
            ((q) MessageActivity.this.f24524b).H.setCurrentItem(i11, false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int a() {
            return MessageActivity.this.f77979i.size();
        }

        public pe.b b(Context context) {
            return MessageActivity.this.Nh(context);
        }

        public pe.c c(Context context, int i11) {
            MessageActivity messageActivity = MessageActivity.this;
            PagerTitleView Eh = messageActivity.Oh(context, ((TabData) messageActivity.f77979i.get(i11)).getName());
            Eh.setPadding(com.hbg.module.libkt.base.ext.c.a(15.0f), 0, com.hbg.module.libkt.base.ext.c.a(15.0f), 0);
            Eh.setSelectedTextSize(18.0f);
            Eh.setOnClickListener(new h(this, i11));
            if (i11 == 0) {
                MessageActivity messageActivity2 = MessageActivity.this;
                messageActivity2.f77982l = Eh;
                com.hbg.module.huobi.im.RedPoint.b a11 = com.hbg.module.huobi.im.RedPoint.b.a();
                MessageActivity messageActivity3 = MessageActivity.this;
                messageActivity2.f77984n = a11.c(messageActivity3, ((q) messageActivity3.f24524b).B);
                MessageActivity messageActivity4 = MessageActivity.this;
                com.hbg.module.huobi.im.RedPoint.b a12 = com.hbg.module.huobi.im.RedPoint.b.a();
                MessageActivity messageActivity5 = MessageActivity.this;
                messageActivity4.f77986p = a12.d(messageActivity5, ((q) messageActivity5.f24524b).B);
            } else if (i11 == 1) {
                MessageActivity messageActivity6 = MessageActivity.this;
                messageActivity6.f77983m = Eh;
                com.hbg.module.huobi.im.RedPoint.b a13 = com.hbg.module.huobi.im.RedPoint.b.a();
                MessageActivity messageActivity7 = MessageActivity.this;
                messageActivity6.f77985o = a13.c(messageActivity7, ((q) messageActivity7.f24524b).B);
                MessageActivity messageActivity8 = MessageActivity.this;
                com.hbg.module.huobi.im.RedPoint.b a14 = com.hbg.module.huobi.im.RedPoint.b.a();
                MessageActivity messageActivity9 = MessageActivity.this;
                messageActivity8.f77987q = a14.d(messageActivity9, ((q) messageActivity9.f24524b).B);
            }
            return Eh;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            MessageActivity.this.Vh();
            com.hbg.module.huobi.im.RedPoint.b.a().f(MessageActivity.this.f77988r);
            com.hbg.module.huobi.im.RedPoint.b.a().j(MessageActivity.this.f77989s);
        }
    }

    public class c implements a.C0138a {
        public c() {
        }

        public void a(com.hbg.module.huobi.im.RedPoint.a aVar) {
            int b11 = aVar.b();
            if (!aVar.a()) {
                MessageActivity.this.f77984n.setVisibility(8);
                MessageActivity.this.f77986p.setVisibility(8);
            } else if (b11 > 0) {
                MessageActivity.this.f77986p.setVisibility(8);
                if (b11 > 99) {
                    MessageActivity.this.f77984n.setText("99+");
                } else {
                    TextView textView = MessageActivity.this.f77984n;
                    textView.setText(b11 + "");
                }
                MessageActivity.this.f77984n.setVisibility(0);
            } else {
                MessageActivity.this.f77984n.setVisibility(8);
                MessageActivity.this.f77986p.setVisibility(0);
            }
        }
    }

    public class d implements a.C0138a {
        public d() {
        }

        public void a(com.hbg.module.huobi.im.RedPoint.a aVar) {
            int b11 = aVar.b();
            if (!aVar.a()) {
                MessageActivity.this.f77985o.setVisibility(8);
                MessageActivity.this.f77987q.setVisibility(8);
            } else if (b11 > 0) {
                MessageActivity.this.f77987q.setVisibility(8);
                if (b11 > 99) {
                    MessageActivity.this.f77985o.setText("99+");
                } else {
                    TextView textView = MessageActivity.this.f77985o;
                    textView.setText(b11 + "");
                }
                MessageActivity.this.f77985o.setVisibility(0);
            } else {
                MessageActivity.this.f77985o.setVisibility(8);
                MessageActivity.this.f77987q.setVisibility(0);
            }
        }
    }

    public class e extends BaseSubscriber<Integer> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            NewAccountTabRedDotHelper.f().d();
            ((MessageNotificationFragment) MessageActivity.this.f77980j.get(1)).Uh();
        }

        public void onCompleted() {
            super.onCompleted();
            MessageActivity.this.Df();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void onStart() {
            super.onStart();
            MessageActivity.this.sh();
        }
    }

    public static /* synthetic */ void Sh(int i11) {
        HashMap hashMap = new HashMap();
        if (i11 == 0) {
            hashMap.put("module_name", "chat");
        } else {
            hashMap.put("module_name", "message");
        }
        SensorsDataHelper.track("appClick_messgeCenter", hashMap);
    }

    public static /* synthetic */ void Th(int i11) {
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Uh(View view) {
        Yh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        Wh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final LinePagerIndicator Nh(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setLineHeight(0.0f);
        return linePagerIndicator;
    }

    public final PagerTitleView Oh(Context context, String str) {
        PagerTitleView pagerTitleView = new PagerTitleView(context);
        pagerTitleView.setText(str);
        pagerTitleView.setSelectedTextSize(18.0f);
        pagerTitleView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        pagerTitleView.setTextSize(16.0f);
        pagerTitleView.setNormalColor(getResources().getColor(R.color.message_tab_unselected));
        pagerTitleView.setSelectedColor(getResources().getColor(R.color.message_tab_selected));
        pagerTitleView.setPadding(com.hbg.module.libkt.base.ext.c.a(15.0f), 0, com.hbg.module.libkt.base.ext.c.a(15.0f), 0);
        return pagerTitleView;
    }

    /* renamed from: Ph */
    public q Og() {
        return q.K(getLayoutInflater());
    }

    public final void Qh() {
        this.f77980j.add(GroupChatListFragment.Dh());
        this.f77980j.add(MessageNotificationFragment.Th());
        ((q) this.f24524b).H.setOffscreenPageLimit(2);
        ((q) this.f24524b).H.setAdapter(new r(this, this.f77979i, this.f77980j));
        ((q) this.f24524b).H.setCurrentItem(this.f77981k);
    }

    public final void Rh(CoIndicator coIndicator) {
        CommonNavigator commonNavigator = new CommonNavigator(this, 0);
        commonNavigator.setAdapter(new a());
        coIndicator.setNavigator(commonNavigator);
        coIndicator.setOnPageSelectListener(f.f56601a);
        ne.d.f25383a.a(coIndicator, ((q) this.f24524b).H, g.f56602a);
        coIndicator.post(new b());
    }

    public final void Vh() {
        if (this.f77984n.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f77984n.getLayoutParams();
            layoutParams.leftMargin = this.f77982l.getRight() - PixelUtils.a(19.0f);
            layoutParams.topMargin = this.f77982l.getTop() + PixelUtils.a(8.0f);
            ((q) this.f24524b).B.addView(this.f77984n);
            this.f77984n.setVisibility(8);
        }
        if (this.f77986p.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f77986p.getLayoutParams();
            layoutParams2.leftMargin = this.f77982l.getRight() - PixelUtils.a(19.0f);
            layoutParams2.topMargin = this.f77982l.getTop() + PixelUtils.a(8.0f);
            ((q) this.f24524b).B.addView(this.f77986p);
            this.f77986p.setVisibility(8);
        }
        if (this.f77985o.getParent() == null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f77985o.getLayoutParams();
            layoutParams3.leftMargin = this.f77983m.getRight() - PixelUtils.a(19.0f);
            layoutParams3.topMargin = this.f77983m.getTop() + PixelUtils.a(8.0f);
            ((q) this.f24524b).B.addView(this.f77985o);
            this.f77985o.setVisibility(8);
        }
        if (this.f77987q.getParent() == null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f77987q.getLayoutParams();
            layoutParams4.leftMargin = this.f77983m.getRight() - PixelUtils.a(19.0f);
            layoutParams4.topMargin = this.f77983m.getTop() + PixelUtils.a(8.0f);
            ((q) this.f24524b).B.addView(this.f77987q);
            this.f77987q.setVisibility(8);
        }
    }

    public final void Wh() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "AllRead");
        SensorsDataHelper.track("appClick_messgeCenter", hashMap);
        if (this.f77980j.size() > 0 && (this.f77980j.get(0) instanceof GroupChatListFragment)) {
            ((GroupChatListFragment) this.f77980j.get(0)).Gh();
        }
        o9.a.a().requestClearReadNum(new HashMap()).b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e());
    }

    public final void Xh() {
    }

    public final void Yh() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "settingg");
        SensorsDataHelper.track("appClick_messgeCenter", hashMap);
        startActivity(new Intent(this, MessageConfigActivity.class));
    }

    @SuppressLint({"SetTextI18n"})
    public void initView() {
        super.initView();
        Qg(NightHelper.e().g());
        ((q) this.f24524b).H.setUserInputEnabled(false);
        ((q) this.f24524b).C.setOnClickListener(new ko.d(this));
        this.f77979i.add(new TabData(getResources().getString(R.string.message_chart_text), 0, 0));
        this.f77979i.add(new TabData(getResources().getString(R.string.message_notification_text), 0, 0));
        Qh();
        Rh(((q) this.f24524b).B);
        s sVar = s.f23381a;
        sVar.k(((q) this.f24524b).D, new ko.c(this), 800);
        sVar.k(((q) this.f24524b).E, new ko.e(this), 800);
        Xh();
        this.f77981k = getIntent().getIntExtra(SNSQuestionnaireFragment.f40105i, this.f77981k);
        SensorsDataHelper.track("messageCenter_view", new HashMap());
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        rn.c.i().m(this, new JumpTarget(h11, h11));
    }
}
