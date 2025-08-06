package qt;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.margin.entity.OrderConfirmResponse;
import u6.g;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f84692a = new f();

    public class a extends EasySubscriber<OrderConfirmResponse> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f84693b;

        public a(b bVar) {
            this.f84693b = bVar;
        }

        /* renamed from: a */
        public void onNext(OrderConfirmResponse orderConfirmResponse) {
            super.onNext(orderConfirmResponse);
            this.f84693b.a(orderConfirmResponse);
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
        }
    }

    public interface b {
        void a(OrderConfirmResponse orderConfirmResponse);
    }

    public static f a() {
        return f84692a;
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, b bVar) {
        x8.a.a().getOrderConfirmInfo(str, str2, str3, str4, str5, str6, str7).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(bVar));
    }
}
