package e7;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgDialogItem;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HbgDialogManager f54290b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f54291c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HbgDialogConfigInfo f54292d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ HbgDialogItem f54293e;

    public /* synthetic */ o(HbgDialogManager hbgDialogManager, FragmentActivity fragmentActivity, HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        this.f54290b = hbgDialogManager;
        this.f54291c = fragmentActivity;
        this.f54292d = hbgDialogConfigInfo;
        this.f54293e = hbgDialogItem;
    }

    public final void run() {
        this.f54290b.J(this.f54291c, this.f54292d, this.f54293e);
    }
}
