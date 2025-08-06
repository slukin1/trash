package dp;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.huobi.otc.dialog.GlobalDialogFragment1;

public final /* synthetic */ class f implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ f f53873a = new f();

    public final void onScanCompleted(String str, Uri uri) {
        GlobalDialogFragment1.yh(str, uri);
    }
}
