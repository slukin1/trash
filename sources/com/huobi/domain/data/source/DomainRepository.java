package com.huobi.domain.data.source;

import com.huobi.domain.data.DomainInfo;
import com.huobi.domain.data.source.cache.DomainCacheDataSource;
import com.huobi.domain.data.source.local.DomainLocalDataSource;
import com.huobi.domain.data.source.remote.DomainRemoteDataSource;
import rx.Observable;

public class DomainRepository {

    /* renamed from: a  reason: collision with root package name */
    public final DomainRemoteDataSource f43848a = new DomainRemoteDataSource();

    /* renamed from: b  reason: collision with root package name */
    public final DomainCacheDataSource f43849b = new DomainCacheDataSource();

    /* renamed from: c  reason: collision with root package name */
    public final DomainLocalDataSource f43850c = new DomainLocalDataSource();

    public Observable<DomainInfo> a() {
        return this.f43848a.p();
    }
}
