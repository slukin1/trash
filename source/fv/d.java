package fv;

import android.app.Activity;
import android.content.Intent;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.AppStartRecord;
import com.huobi.woodpecker.monitor.base.BaseLifecycleMonitor;
import com.huobi.woodpecker.utils.RecordUtil;
import java.util.Set;
import kv.e;
import wu.c;

public class d extends BaseLifecycleMonitor {

    /* renamed from: d  reason: collision with root package name */
    public static final String f22766d = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public AppStartRecord f22767c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f22768a = new d();
    }

    public static d h() {
        return b.f22768a;
    }

    public void e() {
        super.e();
        e.c(f22766d, "HBWP::: stopAppStartMonitor");
        g.c().b(ActionType.APP_START);
    }

    public d i() {
        this.f22767c = new AppStartRecord();
        if (ActionType.APP_START.isEnable()) {
            ((AppStartRecord.AppStartRecordData) this.f22767c.getData()).setAppLaunchStartTime(System.currentTimeMillis());
        } else {
            ((AppStartRecord.AppStartRecordData) this.f22767c.getData()).setAppLaunchStartTime(-1);
        }
        return this;
    }

    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        g();
        if (((AppStartRecord.AppStartRecordData) this.f22767c.getData()).getAppLaunchStartTime() < 0) {
            e.c(f22766d, "app_start 开始值未记录");
        } else if (ActionType.APP_START.isDisable()) {
            e.c(f22766d, "app_start 开关是关闭的");
        } else {
            Intent intent = activity.getIntent();
            Set<String> categories = intent.getCategories();
            String action = intent.getAction();
            if (categories != null && "android.intent.action.MAIN".equals(action) && categories.contains("android.intent.category.LAUNCHER")) {
                ((AppStartRecord.AppStartRecordData) this.f22767c.getData()).setAppLaunchEndTime(System.currentTimeMillis());
                if (((AppStartRecord.AppStartRecordData) this.f22767c.getData()).getUser() < SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) {
                    RecordUtil.a(this.f22767c);
                    if (e.l()) {
                        e.k(f22766d, "QA:" + "action=" + this.f22767c.getAction().action + " , startTime=" + ((AppStartRecord.AppStartRecordData) this.f22767c.getData()).getAppLaunchStartTime() + " , endTime=" + ((AppStartRecord.AppStartRecordData) this.f22767c.getData()).getAppLaunchEndTime() + " , costTime=" + ((AppStartRecord.AppStartRecordData) this.f22767c.getData()).getUser());
                    }
                    c.b(this.f22767c);
                }
                String str = f22766d;
                e.c(str, "AppLaunchMonitor#onActivityResumed " + this.f22767c.toString());
            }
        }
    }

    public d() {
        i();
    }
}
