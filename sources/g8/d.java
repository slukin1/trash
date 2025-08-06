package g8;

import com.hbg.lib.network.inst.response.InstCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f54793b = new d();

    public final Object call(Object obj) {
        return Observable.create(new b((InstCodeResponse) obj));
    }
}
