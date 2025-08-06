package com.huobi.kyc.presenter;

import com.hbg.lib.core.network.response.StringStatusResponse;
import com.huobi.kyc.presenter.KycProBaseInformationUploadPhotoPresenter;
import java.io.File;
import rx.functions.Func1;

public final /* synthetic */ class q implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f74855b;

    public /* synthetic */ q(File file) {
        this.f74855b = file;
    }

    public final Object call(Object obj) {
        return KycProBaseInformationUploadPhotoPresenter.a.o(this.f74855b, (StringStatusResponse) obj);
    }
}
