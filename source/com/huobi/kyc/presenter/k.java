package com.huobi.kyc.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationUploadPhotoPresenter.a f74848b;

    public /* synthetic */ k(KycProBaseInformationUploadPhotoPresenter.a aVar) {
        this.f74848b = aVar;
    }

    public final void call(Object obj) {
        this.f74848b.s((APIStatusErrorException) obj);
    }
}
