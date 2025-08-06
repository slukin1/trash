package com.huobi.index.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.hbg.lib.common.mvp.AbstractPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.index.api.IndexService;
import com.huobi.index.bean.QuickAdditionFeature;
import com.huobi.utils.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;
import rx.Subscription;
import tg.r;
import tq.p;
import u6.g;

public class QuickAdditionPresenter extends AbstractPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public Subscription f73418a;

    /* renamed from: b  reason: collision with root package name */
    public Subscription f73419b;

    public class a extends BaseSubscriber<QuickAdditionFeature> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(QuickAdditionFeature quickAdditionFeature) {
            if (QuickAdditionPresenter.this.getUI() != null && ((c) QuickAdditionPresenter.this.getUI()).isAlive()) {
                ((c) QuickAdditionPresenter.this.getUI()).dismissProgressDialog();
                ((c) QuickAdditionPresenter.this.getUI()).ya(quickAdditionFeature);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (QuickAdditionPresenter.this.getUI() != null && ((c) QuickAdditionPresenter.this.getUI()).isAlive()) {
                ((c) QuickAdditionPresenter.this.getUI()).dismissProgressDialog();
                ((c) QuickAdditionPresenter.this.getUI()).v3(th2 != null ? th2.getMessage() : "");
            }
        }

        public void onStart() {
            super.onStart();
            if (QuickAdditionPresenter.this.getUI() != null && ((c) QuickAdditionPresenter.this.getUI()).isAlive()) {
                ((c) QuickAdditionPresenter.this.getUI()).showProgressDialog(QuickAdditionPresenter.this.getResources().getString(R.string.n_asset_position_data_loading_hint), true);
            }
        }
    }

    public class b extends BaseSubscriber<String> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            if (QuickAdditionPresenter.this.getUI() != null && ((c) QuickAdditionPresenter.this.getUI()).isAlive()) {
                ((c) QuickAdditionPresenter.this.getUI()).dismissProgressDialog();
                ((c) QuickAdditionPresenter.this.getUI()).m4(str);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (QuickAdditionPresenter.this.getUI() != null && ((c) QuickAdditionPresenter.this.getUI()).isAlive()) {
                ((c) QuickAdditionPresenter.this.getUI()).dismissProgressDialog();
                ((c) QuickAdditionPresenter.this.getUI()).T3(th2 != null ? th2.getMessage() : "");
            }
        }

        public void onStart() {
            super.onStart();
            if (QuickAdditionPresenter.this.getUI() != null && ((c) QuickAdditionPresenter.this.getUI()).isAlive()) {
                ((c) QuickAdditionPresenter.this.getUI()).showProgressDialog(QuickAdditionPresenter.this.getResources().getString(R.string.n_asset_position_data_loading_hint), true);
            }
        }
    }

    public interface c extends g {
        void T3(String str);

        void dismissProgressDialog();

        void m4(String str);

        void showProgressDialog(String str, boolean z11);

        void v3(String str);

        void ya(QuickAdditionFeature quickAdditionFeature);
    }

    public final Subscription Q(Integer num, Integer num2) {
        String d11 = ConfigPreferences.d("user_config", "com.huobi.appFeatures.module.timeStamp");
        long parseLong = (TextUtils.isEmpty(d11) || Long.parseLong(d11) <= 0) ? 0 : Long.parseLong(d11);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", 1);
        hashMap.put("version", String.valueOf(105400));
        hashMap.put("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        hashMap.put("uid", num);
        if (parseLong > 0) {
            hashMap.put("timeStamp", Long.valueOf(parseLong));
        }
        return ((IndexService) p.V(IndexService.class)).requestHomeFeatures(AppLanguageHelper.getInstance().getCurLanguageHeader(), num2, String.valueOf(8), hashMap).compose(p.E()).compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public final Subscription R(Map<String, Object> map) {
        return ((IndexService) p.V(IndexService.class)).updateHomeFeatures(map).compose(p.E()).compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
    }

    public void T() {
        this.f73418a = Q(TextUtils.isEmpty(r.x().J()) ? null : Integer.valueOf(Integer.parseInt(r.x().J())), Integer.valueOf(TextUtils.isEmpty(x.b()) ? 1 : Integer.parseInt(x.b())));
    }

    public void U() {
        Log.d("QuickAdditionPresenter", "unSubscribe");
        Subscription subscription = this.f73418a;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.f73419b;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    public void V(ArrayList<String> arrayList) {
        String J = r.x().J();
        if (!TextUtils.isEmpty(J)) {
            ConfigPreferences.m("user_config", "com.huobi.appFeatures.module.timeStamp", String.valueOf(System.currentTimeMillis()));
            HashMap hashMap = new HashMap();
            hashMap.put("uid", Integer.valueOf(J));
            hashMap.put("code", 8);
            hashMap.put("platform", 1);
            hashMap.put("version", String.valueOf(105400));
            hashMap.put("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
            hashMap.put("moduleList", arrayList);
            this.f73419b = R(hashMap);
            return;
        }
        Log.e("QuickAdditionPresenter", "uid is null when update home features...");
    }

    public void onResume() {
        super.onResume();
    }
}
