package bj;

import android.text.TextUtils;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.module.contract.service.ContractService;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

public class n0 {

    /* renamed from: b  reason: collision with root package name */
    public static volatile n0 f40873b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f40874a = new HashMap();

    public static n0 b() {
        if (f40873b == null) {
            synchronized (n0.class) {
                if (f40873b == null) {
                    f40873b = new n0();
                }
            }
        }
        return f40873b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str, String str2) {
        this.f40874a.put(str, str2);
    }

    public String c(String str) {
        return (TextUtils.isEmpty(str) || this.f40874a.get(str) == null) ? "" : this.f40874a.get(str);
    }

    public Observable<String> d(String str) {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).getMarketPriceInfo(str).compose(ContractRetrofit.h()).doOnNext(new m0(this, str));
    }
}
