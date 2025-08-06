package oj;

import com.huobi.domain.data.source.remote.DomainRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DomainRemoteDataSource f58871b;

    public /* synthetic */ e(DomainRemoteDataSource domainRemoteDataSource) {
        this.f58871b = domainRemoteDataSource;
    }

    public final Object call(Object obj) {
        return this.f58871b.m((Throwable) obj);
    }
}
