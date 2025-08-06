package com.huobi.domain.data.source.remote;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.huobi.domain.AppDomainConfigUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.domain.c;
import com.huobi.domain.data.DomainInfo;
import com.huobi.domain.data.source.cache.DomainCacheDataSource;
import com.huobi.utils.download.FileDownloadHelper;
import i6.d;
import i6.k;
import java.io.File;
import java.util.concurrent.TimeUnit;
import oj.a;
import oj.b;
import oj.e;
import oj.f;
import oj.g;
import rx.Observable;
import rx.Subscriber;

public class DomainRemoteDataSource {
    public static /* synthetic */ void i(File file, String str, Subscriber subscriber) {
        if (new FileDownloadHelper().e(str, file.getAbsolutePath(), 0)) {
            d.c("DOMAIN_TEST", "下载config文件成功");
            subscriber.onNext(file);
            subscriber.onCompleted();
            return;
        }
        subscriber.onError(new RuntimeException("downloadError"));
    }

    public static /* synthetic */ File k(Throwable th2) {
        th2.printStackTrace();
        k.g("DOMAIN_TEST", "downlaod s3 file error", th2);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable m(Throwable th2) {
        th2.printStackTrace();
        k.g("DOMAIN_TEST", "downlaod myqcloud file error", th2);
        return h(AppDomainConfigUtils.f43774b, AppDomainConfigUtils.e()).timeout(3, TimeUnit.SECONDS).onErrorReturn(g.f58873b).doOnNext(b.f58868b);
    }

    public static /* synthetic */ Observable n(File file) {
        SmartDomainData smartDomainData;
        if (file == null) {
            return null;
        }
        AppDomainConfigUtils.i();
        String d11 = AppDomainConfigUtils.d(AppDomainConfigUtils.f43774b);
        DomainInfo j11 = AppDomainConfigUtils.j(d11, (SmartDomainData) null);
        if (j11 == null) {
            return Observable.just(null);
        }
        DomainSwitcher.A().F0(j11.i());
        if (j11.i() == null) {
            return Observable.just(null);
        }
        String str = j11.i().url_security;
        if (str != null) {
            d.c("DOMAIN_TEST", "请求域名url security：" + str);
            smartDomainData = DomainSwitcher.i0(str);
        } else {
            smartDomainData = null;
        }
        if (smartDomainData == null) {
            k.d("DOMAIN_TEST", "get domain返回为空，从本地读取域名");
            smartDomainData = c.c();
        }
        if (smartDomainData == null) {
            k.d("DOMAIN_TEST", "smartDomainData为空，域名获取失败！！！");
            return Observable.just(null);
        }
        c.f(smartDomainData);
        DomainInfo k11 = AppDomainConfigUtils.k(j11, smartDomainData);
        j11.u(!d11.equals(DomainCacheDataSource.f43852b));
        AppDomainConfigUtils.f43774b.renameTo(AppDomainConfigUtils.f43773a);
        j11.H(1);
        d.c("DOMAIN_TEST", "config文件解析成功：" + d11);
        return Observable.just(k11);
    }

    public final Observable<File> h(File file, String str) {
        return Observable.create(new a(file, str));
    }

    public Observable<DomainInfo> p() {
        return h(AppDomainConfigUtils.f43774b, AppDomainConfigUtils.f()).timeout(3, TimeUnit.SECONDS).doOnNext(oj.c.f58869b).onErrorResumeNext(new e(this)).flatMap(f.f58872b).doOnError(oj.d.f58870b).compose(RxJavaHelper.s());
    }
}
