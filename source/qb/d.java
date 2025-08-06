package qb;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.hbg.lite.trade.ui.TradeSuccessWechatQrCodeFragment;

public final /* synthetic */ class d implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f53320a = new d();

    public final void onScanCompleted(String str, Uri uri) {
        TradeSuccessWechatQrCodeFragment.yh(str, uri);
    }
}
