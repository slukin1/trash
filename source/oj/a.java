package oj;

import com.huobi.domain.data.source.remote.DomainRemoteDataSource;
import java.io.File;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f58866b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58867c;

    public /* synthetic */ a(File file, String str) {
        this.f58866b = file;
        this.f58867c = str;
    }

    public final void call(Object obj) {
        DomainRemoteDataSource.i(this.f58866b, this.f58867c, (Subscriber) obj);
    }
}
