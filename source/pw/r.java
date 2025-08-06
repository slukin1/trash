package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.NfcScanFragment;
import kotlin.Pair;

public final /* synthetic */ class r implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NfcScanFragment f53293b;

    public /* synthetic */ r(NfcScanFragment nfcScanFragment) {
        this.f53293b = nfcScanFragment;
    }

    public final void onChanged(Object obj) {
        NfcScanFragment.scanUpdateObserver$lambda$0(this.f53293b, (Pair) obj);
    }
}
