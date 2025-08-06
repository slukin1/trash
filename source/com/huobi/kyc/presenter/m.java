package com.huobi.kyc.presenter;

import com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter;
import java.io.File;
import rx.functions.Action1;

public final /* synthetic */ class m implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationUploadPhotoPresenter.a f74850b;

    public /* synthetic */ m(KycProBaseInformationUploadPhotoPresenter.a aVar) {
        this.f74850b = aVar;
    }

    public final void call(Object obj) {
        this.f74850b.r((File) obj);
    }
}
