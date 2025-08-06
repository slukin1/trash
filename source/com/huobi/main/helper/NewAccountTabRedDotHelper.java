package com.huobi.main.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import bh.j;
import com.hbg.lib.core.model.AccountRedDotMgtOpen;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.retrofit.bean.MessageNoReadNum;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.huobi.im.RedPoint.AbsRedPointNodeImp;
import com.hbg.module.huobi.im.event.MessageSwitchEvent;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.message.ui.MessageActivity;
import com.huobi.store.AppConfigManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tg.r;

public class NewAccountTabRedDotHelper implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public AbsRedPointNodeImp f77710b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f77711c;

    /* renamed from: d  reason: collision with root package name */
    public MultiRedDotData f77712d;

    /* renamed from: e  reason: collision with root package name */
    public AbsRedPointNodeImp f77713e;

    public static class MultiRedDotData {

        /* renamed from: a  reason: collision with root package name */
        public SubscribeBox f77714a;

        /* renamed from: b  reason: collision with root package name */
        public MessageNoReadNum f77715b;

        public MessageNoReadNum a() {
            return this.f77715b;
        }

        public SubscribeBox b() {
            return this.f77714a;
        }

        public void c(MessageNoReadNum messageNoReadNum) {
            this.f77715b = messageNoReadNum;
        }

        public void d(SubscribeBox subscribeBox) {
            this.f77714a = subscribeBox;
        }
    }

    public class a extends AbsRedPointNodeImp {
        public a() {
        }

        public boolean a() {
            if (NewAccountTabRedDotHelper.this.f77712d == null || NewAccountTabRedDotHelper.this.f77712d.a() == null) {
                return false;
            }
            MessageNoReadNum a11 = NewAccountTabRedDotHelper.this.f77712d.a();
            int d11 = a11.d();
            int a12 = a11.a();
            if (a11.b() > 0 || (d11 > 0 && a12 != 2)) {
                return true;
            }
            return false;
        }

        public int b() {
            if (NewAccountTabRedDotHelper.this.f77712d == null || NewAccountTabRedDotHelper.this.f77712d.a() == null) {
                return 0;
            }
            return NewAccountTabRedDotHelper.this.f77712d.a().b();
        }
    }

    public class b extends AbsRedPointNodeImp {
        public b() {
        }

        public boolean a() {
            SubscribeBox.MySubscribeBean mySubscribe;
            List<SubscribeBox.ListBean> list;
            if (NewAccountTabRedDotHelper.this.f77712d == null || NewAccountTabRedDotHelper.this.f77712d.b() == null || (mySubscribe = NewAccountTabRedDotHelper.this.f77712d.b().getMySubscribe()) == null || (list = mySubscribe.getList()) == null || list.isEmpty()) {
                return false;
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (list.get(i11).getInfoSum() == -1) {
                    return true;
                }
            }
            return false;
        }

        public int b() {
            SubscribeBox.MySubscribeBean mySubscribe;
            List<SubscribeBox.ListBean> list;
            if (NewAccountTabRedDotHelper.this.f77712d == null || NewAccountTabRedDotHelper.this.f77712d.b() == null || (mySubscribe = NewAccountTabRedDotHelper.this.f77712d.b().getMySubscribe()) == null || (list = mySubscribe.getList()) == null || list.isEmpty()) {
                return 0;
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                int infoSum = list.get(i11).getInfoSum();
                if (infoSum > 0) {
                    return 0 + infoSum;
                }
            }
            return 0;
        }
    }

    public class c extends BaseSubscriber<MultiRedDotData> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(MultiRedDotData multiRedDotData) {
            NewAccountTabRedDotHelper.this.k(multiRedDotData);
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
        }
    }

    public class d implements Func1<Long, Observable<MultiRedDotData>> {
        public d() {
        }

        public static /* synthetic */ SubscribeBox e(Throwable th2) {
            return null;
        }

        public static /* synthetic */ MessageNoReadNum f(Throwable th2) {
            return null;
        }

        public static /* synthetic */ MultiRedDotData g(SubscribeBox subscribeBox, MessageNoReadNum messageNoReadNum) {
            MultiRedDotData multiRedDotData = new MultiRedDotData();
            multiRedDotData.d(subscribeBox);
            multiRedDotData.c(messageNoReadNum);
            return multiRedDotData;
        }

        /* renamed from: d */
        public Observable<MultiRedDotData> call(Long l11) {
            return Observable.zip(v7.b.a().getSubscribeBox().b().subscribeOn(Schedulers.io()).onErrorReturn(i.f77733b), o9.a.a().b().b().subscribeOn(Schedulers.io()).onErrorReturn(h.f77732b), j.f77734b);
        }
    }

    public static class e {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static NewAccountTabRedDotHelper f77720a = new NewAccountTabRedDotHelper((a) null);
    }

    public /* synthetic */ NewAccountTabRedDotHelper(a aVar) {
        this();
    }

    public static int e() {
        AccountRedDotMgtOpen accountRedDotMgtOpen = (AccountRedDotMgtOpen) AppConfigManager.c(MgtConfigNumber.ACCOUNT_RED_DOT.number, AccountRedDotMgtOpen.class);
        if (accountRedDotMgtOpen == null) {
            return 1;
        }
        return Math.max(accountRedDotMgtOpen.getAccount(), 1);
    }

    public static NewAccountTabRedDotHelper f() {
        return e.f77720a;
    }

    public static /* synthetic */ MultiRedDotData h(Throwable th2) {
        return null;
    }

    public void d() {
        MessageNoReadNum a11;
        MultiRedDotData multiRedDotData = this.f77712d;
        if (multiRedDotData != null && (a11 = multiRedDotData.a()) != null) {
            a11.e(0);
            a11.f(0);
            this.f77713e.c();
        }
    }

    public void g() {
        j.c().registerActivityLifecycleCallbacks(this);
        this.f77713e = new a();
        com.hbg.module.huobi.im.RedPoint.b.a().i(this.f77713e);
        this.f77710b = new b();
        com.hbg.module.huobi.im.RedPoint.b.a().b().f(this.f77710b);
    }

    public void i() {
        Subscription subscription = this.f77711c;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f77711c.unsubscribe();
        }
        if (r.x().F0()) {
            this.f77711c = Observable.interval(0, (long) e(), TimeUnit.MINUTES).observeOn(Schedulers.io()).flatMap(new d()).onErrorReturn(g.f77731b).observeOn(AndroidSchedulers.mainThread()).subscribe(new c());
        }
    }

    public void j() {
        l();
        k((MultiRedDotData) null);
    }

    public final void k(MultiRedDotData multiRedDotData) {
        this.f77712d = multiRedDotData;
        this.f77713e.c();
        this.f77710b.c();
    }

    public final void l() {
        Subscription subscription = this.f77711c;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f77711c.unsubscribe();
        }
        this.f77711c = null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (activity instanceof MessageActivity) {
            i();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (activity instanceof HuobiMainActivity) {
            i();
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity instanceof HuobiMainActivity) {
            l();
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onMessageNoDisturbUpdate(MessageSwitchEvent messageSwitchEvent) {
        if (!TextUtils.equals("Push-Chat", messageSwitchEvent.f19696a)) {
            i();
        } else {
            IMConversationHelper.o().z(messageSwitchEvent.f19697b);
        }
    }

    public NewAccountTabRedDotHelper() {
        EventBus.d().p(this);
    }
}
