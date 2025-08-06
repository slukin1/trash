package w8;

import com.hbg.lib.network.php.core.response.IntStatusResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f61230b = new c();

    public final Object call(Object obj) {
        return Observable.create(new a((IntStatusResponse) obj));
    }
}
