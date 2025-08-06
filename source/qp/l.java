package qp;

import com.hbg.lib.network.otc.core.FileUploadSubscriber;
import java.io.File;
import rx.functions.Func1;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileUploadSubscriber f60083b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60084c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60085d;

    public /* synthetic */ l(FileUploadSubscriber fileUploadSubscriber, boolean z11, boolean z12) {
        this.f60083b = fileUploadSubscriber;
        this.f60084c = z11;
        this.f60085d = z12;
    }

    public final Object call(Object obj) {
        return jp.l.J((File) obj, "CHAT", "", this.f60083b, this.f60084c, this.f60085d);
    }
}
