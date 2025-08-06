package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.MobLink;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

public class MobLinkLog extends NLog {
    public static final String FORMAT = "[MOBLINK]%s";

    private MobLinkLog() {
        NLog.setCollector(MobLink.getSdkTag(), new LogsCollector() {
            public String getSDKTag() {
                return MobLink.getSdkTag();
            }

            public int getSDKVersion() {
                return MobLink.getSdkVersion();
            }
        });
    }

    public static NLog getInstance() {
        return NLog.getInstanceForSDK(MobLink.getSdkTag(), true);
    }

    public static MobLinkLog prepare() {
        return new MobLinkLog();
    }
}
