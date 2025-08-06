package o7;

import android.text.TextUtils;
import com.hbg.lib.network.content.core.bean.WorkOrderConfig;
import com.jumio.sdk.reject.JumioRejectReason;
import n7.a;
import rx.Observable;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static WorkOrderConfig f70132a;

    public static String b() {
        WorkOrderConfig workOrderConfig = f70132a;
        return (workOrderConfig == null || workOrderConfig.getLink() == null) ? "" : e((String) f70132a.getLink().get(JumioRejectReason.COLOR_PHOTOCOPY));
    }

    public static String c() {
        WorkOrderConfig workOrderConfig = f70132a;
        return (workOrderConfig == null || workOrderConfig.getLink() == null) ? "" : e((String) f70132a.getLink().get(JumioRejectReason.DIGITAL_COPY));
    }

    public static String d() {
        WorkOrderConfig workOrderConfig = f70132a;
        return (workOrderConfig == null || workOrderConfig.getLink() == null) ? "" : e((String) f70132a.getLink().get("105"));
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceFirst("/", "%s");
    }

    public static Observable<WorkOrderConfig> f(boolean z11) {
        WorkOrderConfig workOrderConfig = f70132a;
        if (workOrderConfig == null || !z11) {
            return a.a().workOrderConfigGet().b().doOnNext(a.f58800b);
        }
        return Observable.just(workOrderConfig);
    }
}
