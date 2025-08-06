package r8;

import com.hbg.lib.network.option.response.OptionStatusResponse;
import com.hbg.lib.network.option.retrofit.OptionRetrofit;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OptionStatusResponse f70520b;

    public /* synthetic */ a(OptionStatusResponse optionStatusResponse) {
        this.f70520b = optionStatusResponse;
    }

    public final void call(Object obj) {
        OptionRetrofit.e(this.f70520b, (Subscriber) obj);
    }
}
