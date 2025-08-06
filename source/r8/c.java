package r8;

import com.hbg.lib.network.option.response.OptionStatusResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f70522b = new c();

    public final Object call(Object obj) {
        return Observable.create(new a((OptionStatusResponse) obj));
    }
}
