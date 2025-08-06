package jp;

import java.io.File;
import retrofit2.Response;
import rx.functions.Func1;

public final /* synthetic */ class i implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f56026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f56027c;

    public /* synthetic */ i(boolean z11, File file) {
        this.f56026b = z11;
        this.f56027c = file;
    }

    public final Object call(Object obj) {
        return l.C(this.f56026b, this.f56027c, (Response) obj);
    }
}
