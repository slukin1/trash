package e7;

import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.hbg.core.bean.HbgDialogConfigInfo;
import java.util.Comparator;

public final /* synthetic */ class q implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q f54297b = new q();

    public final int compare(Object obj, Object obj2) {
        return HbgDialogManager.I((HbgDialogConfigInfo) obj, (HbgDialogConfigInfo) obj2);
    }
}
