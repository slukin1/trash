package com.huobi.kyc.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.huobi.kyc.binder.KycCountryBinder;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import u6.g;

public class KycCountryAreaSelectPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public MultiTypeAdapter f74828a;

    /* renamed from: b  reason: collision with root package name */
    public List<KycCountryInfo> f74829b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<KycCountryInfo> f74830c = new ArrayList();

    public interface a extends g {
        LoadingLayout f1();

        void k9(MultiTypeAdapter multiTypeAdapter);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(List list) {
        ((a) getUI()).f1().g();
        this.f74829b.addAll(list);
        this.f74828a.setItems(this.f74829b);
        this.f74828a.notifyDataSetChanged();
        this.f74830c.addAll(this.f74829b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).f1().k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(Throwable th2) {
        ((a) getUI()).f1().k();
    }

    /* renamed from: W */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter();
        this.f74828a = multiTypeAdapter;
        multiTypeAdapter.g(KycCountryInfo.class, new KycCountryBinder());
        ((a) getUI()).k9(this.f74828a);
        X();
    }

    public void X() {
        Y();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void Y() {
        ((a) getUI()).f1().p();
        n8.a.a().getKycCountryList().b().retry(3).compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(new c(this), new a(this), new b(this)));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void Z(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            this.f74829b.clear();
            this.f74829b.addAll(this.f74830c);
            this.f74828a.notifyDataSetChanged();
            ((a) getUI()).f1().g();
            return;
        }
        if (!m.Y(str)) {
            for (KycCountryInfo next : this.f74830c) {
                if (!AppLanguageHelper.getInstance().isChineseLanguage()) {
                    String nameEn = next.getNameEn();
                    Locale locale = Locale.US;
                    if (nameEn.toLowerCase(locale).contains(str.toLowerCase(locale))) {
                        arrayList.add(next);
                    }
                } else if (next.getNameCn().contains(str)) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() == 0) {
            ((a) getUI()).f1().i();
            return;
        }
        this.f74829b.clear();
        this.f74829b.addAll(arrayList);
        this.f74828a.notifyDataSetChanged();
        ((a) getUI()).f1().g();
    }
}
