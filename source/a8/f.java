package a8;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f3497b = new f();

    public final Object call(Object obj) {
        return Observable.create(new d((HbgIntCodeResponse) obj));
    }
}
