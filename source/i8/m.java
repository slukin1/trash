package i8;

import android.text.TextUtils;
import h8.a;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

public class m {

    /* renamed from: b  reason: collision with root package name */
    public static volatile m f70366b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f70367a = new HashMap();

    public static m b() {
        if (f70366b == null) {
            synchronized (m.class) {
                if (f70366b == null) {
                    f70366b = new m();
                }
            }
        }
        return f70366b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str, String str2) {
        this.f70367a.put(str, str2);
    }

    public String c(String str) {
        return (TextUtils.isEmpty(str) || this.f70367a.get(str) == null) ? "" : this.f70367a.get(str);
    }

    public Observable<String> d(String str) {
        return a.a().getPriceInfo(str).b().doOnNext(new l(this, str));
    }
}
