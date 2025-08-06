package com.appsflyer.oaid;

import android.content.Context;
import android.os.Build;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.framework.common.EmuiUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OaidClient {
    /* access modifiers changed from: private */
    public final Context context;
    private final Logger logger;
    private final long timeout;
    private final TimeUnit unit;

    public OaidClient(Context context2, long j11, TimeUnit timeUnit) {
        Logger logger2 = Logger.getLogger("AppsFlyerOaid6.2.4");
        this.logger = logger2;
        this.context = context2;
        this.timeout = j11;
        this.unit = timeUnit;
        logger2.setLevel(Level.OFF);
    }

    private Info fetchHuawei() {
        try {
            FutureTask futureTask = new FutureTask(new Callable<Info>() {
                public Info call() {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(OaidClient.this.context);
                    if (advertisingIdInfo == null) {
                        return null;
                    }
                    return new Info(advertisingIdInfo.getId(), Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled()));
                }
            });
            new Thread(futureTask).start();
            return (Info) futureTask.get(this.timeout, this.unit);
        } catch (Throwable th2) {
            this.logger.info(th2.getMessage());
            return null;
        }
    }

    private static boolean isHuawei() {
        try {
            if (Build.BRAND.equalsIgnoreCase(MTPushConstants.Manufacturer.HUAWEI) || ((Integer) Class.forName(EmuiUtil.BUILDEX_VERSION).getDeclaredField(EmuiUtil.EMUI_SDK_INT).get((Object) null)).intValue() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    private static boolean isMsaAvailableAtRuntime() {
        Class<IIdentifierListener> cls = IIdentifierListener.class;
        return true;
    }

    public Info fetch() {
        Info info;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (isHuawei()) {
                info = fetchHuawei();
            } else {
                info = isMsaAvailableAtRuntime() ? OaidMsaClient.fetchMsa(this.context, this.logger, this.timeout, this.unit) : null;
            }
            Logger logger2 = this.logger;
            logger2.info("Fetch " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return info;
        } catch (Throwable th2) {
            this.logger.info(th2.getMessage());
            return null;
        }
    }

    public void setLogging(boolean z11) {
        this.logger.setLevel(z11 ? null : Level.OFF);
    }

    public static class Info {

        /* renamed from: id  reason: collision with root package name */
        private final String f15591id;
        private final Boolean lat;

        public Info(String str, Boolean bool) {
            this.f15591id = str;
            this.lat = bool;
        }

        public String getId() {
            return this.f15591id;
        }

        public Boolean getLat() {
            return this.lat;
        }

        public Info(String str) {
            this(str, (Boolean) null);
        }
    }

    public OaidClient(Context context2) {
        this(context2, 1, TimeUnit.SECONDS);
    }
}
