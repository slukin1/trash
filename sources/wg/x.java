package wg;

import android.graphics.Bitmap;
import com.huobi.account.widget.NftHexagonView;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NftHexagonView.a f61274b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f61275c;

    public /* synthetic */ x(NftHexagonView.a aVar, Bitmap bitmap) {
        this.f61274b = aVar;
        this.f61275c = bitmap;
    }

    public final void run() {
        this.f61274b.b(this.f61275c);
    }
}
