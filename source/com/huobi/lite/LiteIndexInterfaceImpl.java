package com.huobi.lite;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c6.b;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CommonFunc;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lite.index.bean.LiteHomeActivityEntity;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.domain.d;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.index.api.IndexService;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.utils.d1;
import com.huobi.webview2.ui.IndexWebActivity;
import com.tencent.android.tpush.common.Constants;
import fn.c;
import fn.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import ra.a;
import tg.r;
import tq.p;
import u6.g;

public class LiteIndexInterfaceImpl implements a {

    /* renamed from: a  reason: collision with root package name */
    public final List<HomeActivityEntity> f75363a = new ArrayList();

    /* access modifiers changed from: private */
    public /* synthetic */ void i(b bVar, HomeActivityEntityResponse homeActivityEntityResponse) {
        SP.r("sp_key_load_time_banner", System.currentTimeMillis());
        List<HomeActivityEntity> list = homeActivityEntityResponse.adList;
        this.f75363a.clear();
        if (list != null && !list.isEmpty()) {
            this.f75363a.addAll(list);
        }
        if (bVar != null) {
            bVar.onCallback(h(this.f75363a));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(b bVar, APIStatusErrorException aPIStatusErrorException) {
        aPIStatusErrorException.printStackTrace();
        if (bVar != null) {
            bVar.onCallback(h(this.f75363a));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(b bVar, Throwable th2) {
        th2.printStackTrace();
        if (bVar != null) {
            bVar.onCallback(h(this.f75363a));
        }
    }

    public boolean a(Context context, String str, String str2, String str3, boolean z11) {
        return HBBaseWebActivity.showWebView(context, str, str2, str3, z11);
    }

    public void b(RequestCallback1<ZendeskTopNotice> requestCallback1) {
        v8.a.a().b("360000098281", d1.h()).d(requestCallback1);
    }

    public void c(Context context, String str, String str2, String str3) {
        GrowingIOStatics.d(str3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("huobiapp://?action=openbrowser")) {
            try {
                String m11 = StringUtils.m(StringUtils.l(new URI(str).getQuery()), "url");
                if (!TextUtils.isEmpty(m11)) {
                    CommonFunc.a(context, m11);
                }
            } catch (URISyntaxException e11) {
                e11.printStackTrace();
            }
        } else {
            String c11 = d.c(str);
            Intent intent = new Intent();
            intent.putExtra("url", c11);
            intent.putExtra("title_back", context.getString(R.string.head_return));
            intent.putExtra("title", str2);
            intent.setClass(context, IndexWebActivity.class);
            context.startActivity(intent);
        }
    }

    public void d(Context context, g gVar, b<List<LiteHomeActivityEntity>> bVar) {
        if (ConfigPreferences.j(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "52");
            hashMap.put("userAgent", "M:huobiapp:phone:android");
            hashMap.put("channel_name", "huobi");
            hashMap.put("version", 105400);
            hashMap.put(Constants.FLAG_DEVICE_ID, PhoneUtils.e());
            hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
            if (!TextUtils.isEmpty(r.x().J())) {
                hashMap.put("uId", r.x().J());
            }
            int g11 = yl.g.h().g();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("clientCountryId", Integer.valueOf(g11));
            ((IndexService) p.C(IndexService.class)).requestAdvertisements(hashMap, hashMap2).compose(p.E()).compose(RxJavaHelper.t(gVar)).subscribe(EasySubscriber.create(new fn.d(this, bVar), new c(this, bVar), new e(this, bVar)));
        }
    }

    public final List<LiteHomeActivityEntity> h(List<HomeActivityEntity> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (list != null && !list.isEmpty()) {
            boolean F0 = r.x().F0();
            for (HomeActivityEntity next : list) {
                if (next != null && next.getIsShow() == 0 && next.getAndroidLite() == 1) {
                    int isNeedLogin = next.getIsNeedLogin();
                    if (isNeedLogin != 0) {
                        if (isNeedLogin == 1 && F0) {
                        }
                    } else if (!F0) {
                    }
                    arrayList.add(next.transfor());
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new LiteHomeActivityEntity());
        }
        return arrayList;
    }
}
