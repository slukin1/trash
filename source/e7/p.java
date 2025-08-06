package e7;

import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import com.hbg.lib.network.hbg.core.bean.HbgDialogItem;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HbgDialogManager f54294b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HbgDialogConfigInfo f54295c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HbgDialogItem f54296d;

    public /* synthetic */ p(HbgDialogManager hbgDialogManager, HbgDialogConfigInfo hbgDialogConfigInfo, HbgDialogItem hbgDialogItem) {
        this.f54294b = hbgDialogManager;
        this.f54295c = hbgDialogConfigInfo;
        this.f54296d = hbgDialogItem;
    }

    public final void run() {
        this.f54294b.M(this.f54295c, this.f54296d);
    }
}
