package com.huobi.kyc.presenter;

import com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter;
import java.io.File;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationUploadPhotoPresenter.a f74849b;

    public /* synthetic */ l(KycProBaseInformationUploadPhotoPresenter.a aVar) {
        this.f74849b = aVar;
    }

    public final void call(Object obj) {
        this.f74849b.n((File) obj);
    }
}
