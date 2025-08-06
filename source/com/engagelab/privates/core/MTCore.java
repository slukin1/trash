package com.engagelab.privates.core;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.a;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.b;
import com.engagelab.privates.common.c;
import com.engagelab.privates.common.f;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;

public class MTCore extends MTObserver {
    public void dispatchMessage(Context context, int i11, Bundle bundle) {
        if (i11 == 2001) {
            c.a().b(context);
        } else if (i11 == 2002) {
            c.a().c(context);
        } else if (i11 == 2233) {
            MTCommonPrivatesApi.sendMessage(context, "ENGAGELAB-PRIVATES-REPORT", i11, bundle);
        } else if (i11 == 2993) {
            MTCommonPrivatesApi.releaseHandler(context, "ENGAGELAB-PRIVATES-CONNECT");
            MTCommonPrivatesApi.sendMessage(context, "ENGAGELAB-PRIVATES-CONNECT", i11, bundle);
        } else if (i11 != 2994) {
            MTCommonPrivatesApi.buildHandler(context, "ENGAGELAB-PRIVATES-CORE", (int) (MTCoreGlobal.getHeartbeatInterval() + 10000));
            MTCommonPrivatesApi.sendMessage(context, "ENGAGELAB-PRIVATES-CORE", i11, bundle);
        } else {
            MTCommonPrivatesApi.buildHandler(context, "ENGAGELAB-PRIVATES-CONNECT", (int) (MTCoreGlobal.getHeartbeatInterval() + 10000));
            MTCommonPrivatesApi.sendMessage(context, "ENGAGELAB-PRIVATES-CONNECT", i11, bundle);
        }
    }

    public short getSdkFlag() {
        return 0;
    }

    public String getSdkName() {
        return "core_sdk_ver";
    }

    public int getSdkPriority() {
        return 1;
    }

    public String getSdkVersion() {
        return MTCorePrivatesApi.SDK_VERSION_NAME;
    }

    public String[] getThreadName() {
        return new String[]{"ENGAGELAB-PRIVATES-CORE", "ENGAGELAB-PRIVATES-REPORT", "ENGAGELAB-PRIVATES-CONNECT"};
    }

    public void handleDelayMessage(Context context, int i11, Bundle bundle) {
        if (i11 == 2) {
            c.a().a(context);
        } else if (i11 == 2992) {
            c.a().e(context);
        }
    }

    public void handleMessage(Context context, int i11, Bundle bundle) {
        if (i11 == 19) {
            c.a().a(context, bundle);
        } else if (i11 == 25) {
            a.a().a(context, bundle);
        } else if (i11 == 1999) {
            a.a().b(context);
            a.a().a(context);
        } else if (i11 == 2222) {
            c.a().b(context, bundle);
        } else if (i11 == 2233) {
            f.a().a(context, bundle);
        } else if (i11 == 1994) {
            b.a().a(context);
        } else if (i11 == 1995) {
            b.a().b(context);
        } else if (i11 == 2101) {
            a.a().c(context, bundle);
        } else if (i11 != 2102) {
            if (i11 != 2998) {
                if (i11 != 2999) {
                    switch (i11) {
                        case MTCoreConstants.RemoteWhat.STOP_HEARTBEAT /*2991*/:
                            break;
                        case MTCoreConstants.RemoteWhat.START_HEARTBEAT /*2992*/:
                            break;
                        case MTCoreConstants.RemoteWhat.STOP_CONNECT /*2993*/:
                            c.a().f(context);
                            return;
                        case MTCoreConstants.RemoteWhat.START_CONNECT /*2994*/:
                            c.a().d(context);
                            return;
                        case MTCoreConstants.RemoteWhat.TURN_OFF_CONNECT /*2995*/:
                            c.a().h(context);
                            return;
                        case MTCoreConstants.RemoteWhat.TURN_ON_CONNECT /*2996*/:
                            c.a().i(context);
                            return;
                        default:
                            return;
                    }
                }
                c.a().e(context);
                return;
            }
            c.a().g(context);
        } else {
            a.a().b(context, bundle);
        }
    }

    public boolean isSdk() {
        return true;
    }

    public boolean isSupport(int i11) {
        if (i11 == 2 || i11 == 19 || i11 == 25 || i11 == 2222 || i11 == 2233 || i11 == 1994 || i11 == 1995 || i11 == 1998 || i11 == 1999 || i11 == 2001 || i11 == 2002 || i11 == 2101 || i11 == 2102 || i11 == 2998 || i11 == 2999) {
            return true;
        }
        switch (i11) {
            case MTCoreConstants.RemoteWhat.STOP_HEARTBEAT /*2991*/:
            case MTCoreConstants.RemoteWhat.START_HEARTBEAT /*2992*/:
            case MTCoreConstants.RemoteWhat.STOP_CONNECT /*2993*/:
            case MTCoreConstants.RemoteWhat.START_CONNECT /*2994*/:
            case MTCoreConstants.RemoteWhat.TURN_OFF_CONNECT /*2995*/:
            case MTCoreConstants.RemoteWhat.TURN_ON_CONNECT /*2996*/:
                return true;
            default:
                return false;
        }
    }
}
