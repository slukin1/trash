package qp;

import com.hbg.lib.network.otc.core.FileUploadSubscriber;
import com.huobi.otc.persenter.OtcLiteChatPresenter;
import java.io.File;
import rx.functions.Func1;

public final /* synthetic */ class k implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileUploadSubscriber f60082b;

    public /* synthetic */ k(FileUploadSubscriber fileUploadSubscriber) {
        this.f60082b = fileUploadSubscriber;
    }

    public final Object call(Object obj) {
        return OtcLiteChatPresenter.h1(this.f60082b, (File) obj);
    }
}
