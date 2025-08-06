package un;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class z implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ z f60904b = new z();

    public final Object call(Object obj) {
        return Observable.create(new w((UcIntCodeResponse) obj));
    }
}
