package com.huobi.kyc.presenter;

import android.net.Uri;
import com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationUploadPhotoPresenter.a f74853b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f74854c;

    public /* synthetic */ p(KycProBaseInformationUploadPhotoPresenter.a aVar, Uri uri) {
        this.f74853b = aVar;
        this.f74854c = uri;
    }

    public final Object call(Object obj) {
        return this.f74853b.m(this.f74854c, (Integer) obj);
    }
}
