package ld;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.huobi.im.group.bean.ImGroupChatBean;
import com.hbg.module.huobi.im.group.net.ILiveImService;
import kotlin.l;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final c f22886a;

    /* renamed from: b  reason: collision with root package name */
    public final ILiveImService f22887b = ((ILiveImService) HbgRetrofit.request(ILiveImService.class));

    /* renamed from: ld.a$a  reason: collision with other inner class name */
    public static final class C0197a extends EasySubscriber<HbgIntCodeResponse<ImGroupChatBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22888b;

        public C0197a(a aVar) {
            this.f22888b = aVar;
        }

        /* renamed from: a */
        public void onNext(HbgIntCodeResponse<ImGroupChatBean> hbgIntCodeResponse) {
            ImGroupChatBean data;
            c b11;
            if (hbgIntCodeResponse != null && (data = hbgIntCodeResponse.getData()) != null && (b11 = this.f22888b.b()) != null) {
                b11.t7(data);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public a(c cVar) {
        this.f22886a = cVar;
    }

    public void a(String str, int i11, int i12) {
        this.f22887b.getAllGroupChatList(MapsKt__MapsKt.m(l.a("HB-PRO-TOKEN", str)), i11, i12).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new C0197a(this));
    }

    public final c b() {
        return this.f22886a;
    }
}
