package ys;

import com.hbg.lib.network.pro.core.bean.CallAuction;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, CallAuction> f85086a = new HashMap();

    /* renamed from: ys.a$a  reason: collision with other inner class name */
    public class C0890a implements Action1<CallAuction> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f85087b;

        public C0890a(String str) {
            this.f85087b = str;
        }

        /* renamed from: a */
        public void call(CallAuction callAuction) {
            a.f85086a.put(this.f85087b, callAuction);
        }
    }

    public static CallAuction b(String str) {
        return f85086a.get(str);
    }

    public static Observable<CallAuction> c(String str) {
        return x8.a.a().getForeCast(str).b().doOnNext(new C0890a(str));
    }
}
