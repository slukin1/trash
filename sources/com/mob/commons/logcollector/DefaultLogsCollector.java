package com.mob.commons.logcollector;

import com.mob.tools.log.LogCollector;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;

@Deprecated
public class DefaultLogsCollector implements LogCollector, PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static DefaultLogsCollector f27276a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f27277b = new HashMap<>();

    private DefaultLogsCollector() {
    }

    public static synchronized DefaultLogsCollector get() {
        DefaultLogsCollector defaultLogsCollector;
        synchronized (DefaultLogsCollector.class) {
            if (f27276a == null) {
                f27276a = new DefaultLogsCollector();
            }
            defaultLogsCollector = f27276a;
        }
        return defaultLogsCollector;
    }

    public void addSDK(String str, int i11) {
        synchronized (this.f27277b) {
            this.f27277b.put(str, Integer.valueOf(i11));
        }
    }

    public final void log(String str, int i11, int i12, String str2, String str3) {
        Integer num = this.f27277b.get(str);
        if (num == null) {
            num = -1;
        }
        NLog.getInstance(str, num.intValue(), str).log(i11, str3, new Object[0]);
    }
}
