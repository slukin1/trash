package ld;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.module.huobi.im.group.bean.ImGroupChatBean;
import com.hbg.module.huobi.im.group.net.ILiveImService;
import kotlin.l;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final d f22889a;

    /* renamed from: b  reason: collision with root package name */
    public final ILiveImService f22890b = ((ILiveImService) HbgRetrofit.request(ILiveImService.class));

    public static final class a extends EasySubscriber<HbgIntCodeResponse<ImGroupChatBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22891b;

        public a(b bVar) {
            this.f22891b = bVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<ImGroupChatBean> hbgIntCodeResponse) {
            ImGroupChatBean data;
            d b11;
            if (hbgIntCodeResponse != null && (data = hbgIntCodeResponse.getData()) != null && (b11 = this.f22891b.b()) != null) {
                b11.l9(data);
            }
        }
    }

    public b(d dVar) {
        this.f22889a = dVar;
    }

    public void a(String str) {
        this.f22890b.getAllGroupChatList(MapsKt__MapsKt.m(l.a("HB-PRO-TOKEN", str)), 1, 10).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(this));
    }

    public final d b() {
        return this.f22889a;
    }
}
