package m9;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import l9.a;
import rx.Observable;

public class t {

    /* renamed from: b  reason: collision with root package name */
    public static volatile t f70917b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f70918a = new HashMap();

    public static t b() {
        if (f70917b == null) {
            synchronized (t.class) {
                if (f70917b == null) {
                    f70917b = new t();
                }
            }
        }
        return f70917b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str, String str2) {
        this.f70918a.put(str, str2);
    }

    public String c(String str) {
        return (TextUtils.isEmpty(str) || this.f70918a.get(str) == null) ? "" : this.f70918a.get(str);
    }

    public Observable<String> d(String str) {
        return a.a().getMarketPriceInfo(str).b().doOnNext(new s(this, str));
    }
}
