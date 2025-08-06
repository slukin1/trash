package je;

import android.graphics.Bitmap;
import com.hbg.module.libkt.common.HexagonImageView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HexagonImageView f55928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f55929c;

    public /* synthetic */ a(HexagonImageView hexagonImageView, Bitmap bitmap) {
        this.f55928b = hexagonImageView;
        this.f55929c = bitmap;
    }

    public final void run() {
        HexagonImageView.a.c(this.f55928b, this.f55929c);
    }
}
