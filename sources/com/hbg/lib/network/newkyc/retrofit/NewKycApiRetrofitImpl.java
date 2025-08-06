package com.hbg.lib.network.newkyc.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.network.newkyc.bean.AuthUserLevelInfo;
import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.hbg.lib.network.newkyc.bean.KycSDKTokenInfo;
import com.hbg.lib.network.newkyc.bean.KycTicketInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.newkyc.service.NewKycService;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.tencent.android.tpush.common.Constants;
import d9.a;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import n8.b;

public class NewKycApiRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public c9.b f68875a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f68876b = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public String f68877c;

    public void a(String str, Context context, c9.b bVar) {
        this.f68877c = str;
        RetrofitLogger.a(this.f68877c + "-->init");
        this.f68875a = bVar;
        NewKycRetrofit.d().init(str, context, bVar);
    }

    public a<String> b(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(Constants.FLAG_TICKET, str);
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).userLogin(hashMap).compose(NewKycRetrofit.h()).map(o8.a.f58801b));
    }

    public a<KycSDKTokenInfo> c() {
        HashMap hashMap = new HashMap(4, 1.0f);
        hashMap.put("authItem", "C2_SELF");
        hashMap.put("authStep", "C2");
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).fetchAuthTokenV2(hashMap).compose(RxJavaHelper.g((RequestCallback1) null)).compose(NewKycRetrofit.h()));
    }

    public a<KycTicketInfo> d() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("businessType", "2");
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).getTicket(hashMap).compose(RxJavaHelper.g((RequestCallback1) null)).compose(NewKycRetrofit.h()));
    }

    public a<String> e(String str, int i11, String str2) {
        HashMap hashMap = new HashMap(4, 1.0f);
        hashMap.put(Constants.FLAG_TICKET, str);
        hashMap.put("livingCode", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("livingMessage", str2);
        }
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).submitLiveness(hashMap).compose(RxJavaHelper.g((RequestCallback1) null)).compose(NewKycRetrofit.h()));
    }

    public a<String> f(String str, int i11, String str2) {
        HashMap hashMap = new HashMap(4, 1.0f);
        hashMap.put(Constants.FLAG_TICKET, str);
        hashMap.put("reasonCode", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("message", str2);
        }
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).submitLivingIdentitySelf(hashMap).compose(RxJavaHelper.g((RequestCallback1) null)).compose(NewKycRetrofit.h()));
    }

    public a<UserKycInfoNew> getAuthInfo() {
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).getAuthInfo().compose(NewKycRetrofit.h()));
    }

    public a<AuthUserLevelInfo> getAuthUserLevel() {
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).getAuthUserLevel().compose(NewKycRetrofit.h()));
    }

    public a<DominicaKycPageInfo> getDominicaKycPageInfo() {
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).getDominicaKycPageInfo().compose(NewKycRetrofit.h()));
    }

    public a<List<KycCountryInfo>> getKycCountryList() {
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).getKycCountryList().compose(NewKycRetrofit.h()));
    }

    public a<UnifyKycInfo> getUnifyKycInfoV2() {
        return new a<>(((NewKycService) NewKycRetrofit.request(NewKycService.class)).getUnifyKycInfoV2().compose(NewKycRetrofit.h()));
    }
}
