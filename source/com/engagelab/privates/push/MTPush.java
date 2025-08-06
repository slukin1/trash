package com.engagelab.privates.push;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.j;
import com.engagelab.privates.common.k;
import com.engagelab.privates.common.l;
import com.engagelab.privates.common.m;
import com.engagelab.privates.common.n;
import com.engagelab.privates.common.o;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.common.q;
import com.engagelab.privates.common.r;
import com.engagelab.privates.common.s;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

public class MTPush extends MTObserver {
    public void dispatchMessage(Context context, int i11, Bundle bundle) {
        switch (i11) {
            case 3001:
                m.b().a(context, i11, bundle);
                return;
            case 3002:
            case 3003:
            case 3004:
            case 3005:
                n.b().a(context, i11, bundle);
                return;
            case 3006:
                j.a().a(context, bundle);
                return;
            case MTPushConstants.MainWhat.TAG_ADD /*3011*/:
            case MTPushConstants.MainWhat.TAG_DELETE /*3012*/:
            case MTPushConstants.MainWhat.TAG_UPDATE /*3013*/:
            case MTPushConstants.MainWhat.TAG_QUERY /*3014*/:
            case MTPushConstants.MainWhat.TAG_DELETE_ALL /*3015*/:
            case MTPushConstants.MainWhat.TAG_QUERY_ALL /*3016*/:
                s.b().a(context, i11, bundle);
                return;
            case MTPushConstants.MainWhat.ALIAS_SET /*3017*/:
            case MTPushConstants.MainWhat.ALIAS_GET /*3018*/:
            case MTPushConstants.MainWhat.ALIAS_CLEAR /*3019*/:
                q.b().a(context, i11, bundle);
                return;
            case MTPushConstants.MainWhat.ON_PLATFORM_TOKEN /*3021*/:
                o.b().e(context, bundle);
                return;
            case MTPushConstants.MainWhat.ON_PLATFORM_NODE /*3022*/:
                o.b().b(context, bundle);
                return;
            case MTPushConstants.MainWhat.ON_MOBILE_NUMBER /*3023*/:
                r.b().a(context, i11, bundle);
                return;
            default:
                MTCommonPrivatesApi.sendMessage(context, "ENGAGELAB-PRIVATES-PUSH", i11, bundle);
                return;
        }
    }

    public short getSdkFlag() {
        return 1;
    }

    public String getSdkName() {
        return HiAnalyticsConstant.BI_KEY_SDK_VER;
    }

    public int getSdkPriority() {
        return 2;
    }

    public String getSdkVersion() {
        return MTPushPrivatesApi.SDK_VERSION_NAME;
    }

    public String[] getThreadName() {
        return new String[]{"ENGAGELAB-PRIVATES-PUSH"};
    }

    public void handleDelayMessage(Context context, int i11, Bundle bundle) {
        switch (i11) {
            case 26:
                r.b().a(context, bundle);
                return;
            case 27:
                o.b().c(context, bundle);
                return;
            case 28:
                s.b().a(context, bundle);
                return;
            case 29:
                q.b().a(context, bundle);
                return;
            default:
                return;
        }
    }

    public void handleMessage(Context context, int i11, Bundle bundle) {
        if (i11 == 3) {
            l.a().a(context, bundle);
        } else if (i11 == 59) {
            n.b().c(context, bundle);
        } else if (i11 == 2001) {
            o.b().a(context);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.ON_GEOFENCE, (Bundle) null);
        } else if (i11 == 2997) {
            j.a().b(context, 0);
        } else if (i11 == 2999) {
            j.a().e(context);
            j.a().b(context, 2);
        } else if (i11 == 3978) {
            r.b().b(context, i11, bundle);
        } else if (i11 != 3979) {
            switch (i11) {
                case 26:
                    r.b().b(context, bundle);
                    return;
                case 27:
                    o.b().d(context, bundle);
                    return;
                case 28:
                    s.b().b(context, bundle);
                    return;
                case 29:
                    q.b().b(context, bundle);
                    return;
                default:
                    switch (i11) {
                        case MTCommonConstants.RemoteWhat.TO_BACKGROUND:
                            k.a().a(context);
                            return;
                        case MTCommonConstants.RemoteWhat.TO_FOREGROUND:
                            k.a().b(context);
                            j.a().b(context, 1);
                            return;
                        case MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED:
                            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, (Bundle) null);
                            return;
                        case MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED:
                            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, (Bundle) null);
                            return;
                        default:
                            switch (i11) {
                                case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_BADGE /*3884*/:
                                    j.a().f(context);
                                    return;
                                case MTPushConstants.RemoteWhat.SET_NOTIFICATION_BADGE /*3885*/:
                                    j.a().c(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_COUNT /*3886*/:
                                    j.a().g(context);
                                    return;
                                case MTPushConstants.RemoteWhat.SET_NOTIFICATION_COUNT /*3887*/:
                                    j.a().d(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_LAYOUT /*3888*/:
                                    j.a().b(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.SET_NOTIFICATION_LAYOUT /*3889*/:
                                    j.a().e(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SILENCE_TIME /*3890*/:
                                    j.a().i(context);
                                    return;
                                case MTPushConstants.RemoteWhat.SET_NOTIFICATION_SILENCE_TIME /*3891*/:
                                    j.a().g(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SHOW_TIME /*3892*/:
                                    j.a().h(context);
                                    return;
                                case MTPushConstants.RemoteWhat.SET_NOTIFICATION_SHOW_TIME /*3893*/:
                                    j.a().f(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.CLEAR_NOTIFICATION /*3894*/:
                                    n.b().b(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.SHOW_NOTIFICATION /*3895*/:
                                    n.b().d(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.ON_NOTIFICATION_MESSAGE /*3896*/:
                                    n.b().a(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.ON_CUSTOM_MESSAGE /*3897*/:
                                    m.b().a(context, bundle);
                                    return;
                                case MTPushConstants.RemoteWhat.TURN_OFF_PUSH /*3898*/:
                                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.TURN_OFF_CONNECT, (Bundle) null);
                                    MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.TURN_OFF_PLATFORM_PUSH, (Bundle) null);
                                    return;
                                case MTPushConstants.RemoteWhat.TURN_ON_PUSH /*3899*/:
                                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.TURN_ON_CONNECT, (Bundle) null);
                                    MTCommonPrivatesApi.sendMessageToMainProcess(context, 3102, (Bundle) null);
                                    return;
                                default:
                                    switch (i11) {
                                        case MTPushConstants.RemoteWhat.ALIAS_CLEAR /*3981*/:
                                        case MTPushConstants.RemoteWhat.ALIAS_GET /*3982*/:
                                        case MTPushConstants.RemoteWhat.ALIAS_SET /*3983*/:
                                            q.b().b(context, i11, bundle);
                                            return;
                                        case MTPushConstants.RemoteWhat.TAG_QUERY_ALL /*3984*/:
                                        case MTPushConstants.RemoteWhat.TAG_DELETE_ALL /*3985*/:
                                        case MTPushConstants.RemoteWhat.TAG_QUERY /*3986*/:
                                        case MTPushConstants.RemoteWhat.TAG_UPDATE /*3987*/:
                                        case MTPushConstants.RemoteWhat.TAG_DELETE /*3988*/:
                                        case MTPushConstants.RemoteWhat.TAG_ADD /*3989*/:
                                            s.b().b(context, i11, bundle);
                                            return;
                                        default:
                                            switch (i11) {
                                                case MTPushConstants.RemoteWhat.ON_NOTIFICATION_OPENED /*3995*/:
                                                case MTPushConstants.RemoteWhat.ON_NOTIFICATION_DELETED /*3996*/:
                                                case MTPushConstants.RemoteWhat.ON_NOTIFICATION_CLICKED /*3997*/:
                                                    break;
                                                case MTPushConstants.RemoteWhat.ON_NOTIFICATION_ARRIVED /*3998*/:
                                                    j.a().b(context, 3);
                                                    break;
                                                case MTPushConstants.RemoteWhat.ON_CUSTOM_ARRIVED /*3999*/:
                                                    m.b().b(context, i11, bundle);
                                                    return;
                                                default:
                                                    return;
                                            }
                                            n.b().b(context, i11, bundle);
                                            return;
                                    }
                            }
                    }
            }
        } else {
            o.b().f(context, bundle);
        }
    }

    public boolean isSdk() {
        return true;
    }

    public boolean isSupport(int i11) {
        if (i11 == 3102 || i11 == 3103 || i11 == 3797 || i11 == 3798 || i11 == 3978 || i11 == 3979 || i11 == 3 || i11 == 59 || i11 == 2001 || i11 == 2999) {
            return true;
        }
        switch (i11) {
            case MTPushConstants.RemoteWhat.DELETE_GEOFENCE /*3880*/:
            case MTPushConstants.RemoteWhat.ADD_GEOFENCE /*3881*/:
            case MTPushConstants.RemoteWhat.SET_GEOFENCE_INTERVAL /*3882*/:
            case MTPushConstants.RemoteWhat.SET_GEOFENCE_COUNT /*3883*/:
            case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_BADGE /*3884*/:
            case MTPushConstants.RemoteWhat.SET_NOTIFICATION_BADGE /*3885*/:
            case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_COUNT /*3886*/:
            case MTPushConstants.RemoteWhat.SET_NOTIFICATION_COUNT /*3887*/:
            case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_LAYOUT /*3888*/:
            case MTPushConstants.RemoteWhat.SET_NOTIFICATION_LAYOUT /*3889*/:
            case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SILENCE_TIME /*3890*/:
            case MTPushConstants.RemoteWhat.SET_NOTIFICATION_SILENCE_TIME /*3891*/:
            case MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SHOW_TIME /*3892*/:
            case MTPushConstants.RemoteWhat.SET_NOTIFICATION_SHOW_TIME /*3893*/:
            case MTPushConstants.RemoteWhat.CLEAR_NOTIFICATION /*3894*/:
            case MTPushConstants.RemoteWhat.SHOW_NOTIFICATION /*3895*/:
            case MTPushConstants.RemoteWhat.ON_NOTIFICATION_MESSAGE /*3896*/:
            case MTPushConstants.RemoteWhat.ON_CUSTOM_MESSAGE /*3897*/:
            case MTPushConstants.RemoteWhat.TURN_OFF_PUSH /*3898*/:
            case MTPushConstants.RemoteWhat.TURN_ON_PUSH /*3899*/:
                return true;
            default:
                switch (i11) {
                    case MTPushConstants.RemoteWhat.ON_NOTIFICATION_STATE /*3994*/:
                    case MTPushConstants.RemoteWhat.ON_NOTIFICATION_OPENED /*3995*/:
                    case MTPushConstants.RemoteWhat.ON_NOTIFICATION_DELETED /*3996*/:
                    case MTPushConstants.RemoteWhat.ON_NOTIFICATION_CLICKED /*3997*/:
                    case MTPushConstants.RemoteWhat.ON_NOTIFICATION_ARRIVED /*3998*/:
                    case MTPushConstants.RemoteWhat.ON_CUSTOM_ARRIVED /*3999*/:
                        return true;
                    default:
                        switch (i11) {
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                return true;
                            default:
                                switch (i11) {
                                    case MTCommonConstants.RemoteWhat.TO_BACKGROUND:
                                    case MTCommonConstants.RemoteWhat.TO_FOREGROUND:
                                    case MTCommonConstants.RemoteWhat.ON_NETWORK_DISCONNECTED:
                                    case MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED:
                                        return true;
                                    default:
                                        switch (i11) {
                                            case 3001:
                                            case 3002:
                                            case 3003:
                                            case 3004:
                                            case 3005:
                                            case 3006:
                                                return true;
                                            default:
                                                switch (i11) {
                                                    case MTPushConstants.MainWhat.TAG_ADD /*3011*/:
                                                    case MTPushConstants.MainWhat.TAG_DELETE /*3012*/:
                                                    case MTPushConstants.MainWhat.TAG_UPDATE /*3013*/:
                                                    case MTPushConstants.MainWhat.TAG_QUERY /*3014*/:
                                                    case MTPushConstants.MainWhat.TAG_DELETE_ALL /*3015*/:
                                                    case MTPushConstants.MainWhat.TAG_QUERY_ALL /*3016*/:
                                                    case MTPushConstants.MainWhat.ALIAS_SET /*3017*/:
                                                    case MTPushConstants.MainWhat.ALIAS_GET /*3018*/:
                                                    case MTPushConstants.MainWhat.ALIAS_CLEAR /*3019*/:
                                                        return true;
                                                    default:
                                                        switch (i11) {
                                                            case MTPushConstants.MainWhat.ON_PLATFORM_TOKEN /*3021*/:
                                                            case MTPushConstants.MainWhat.ON_PLATFORM_NODE /*3022*/:
                                                            case MTPushConstants.MainWhat.ON_MOBILE_NUMBER /*3023*/:
                                                                return true;
                                                            default:
                                                                switch (i11) {
                                                                    case MTPushConstants.RemoteWhat.ALIAS_CLEAR /*3981*/:
                                                                    case MTPushConstants.RemoteWhat.ALIAS_GET /*3982*/:
                                                                    case MTPushConstants.RemoteWhat.ALIAS_SET /*3983*/:
                                                                    case MTPushConstants.RemoteWhat.TAG_QUERY_ALL /*3984*/:
                                                                    case MTPushConstants.RemoteWhat.TAG_DELETE_ALL /*3985*/:
                                                                    case MTPushConstants.RemoteWhat.TAG_QUERY /*3986*/:
                                                                    case MTPushConstants.RemoteWhat.TAG_UPDATE /*3987*/:
                                                                    case MTPushConstants.RemoteWhat.TAG_DELETE /*3988*/:
                                                                    case MTPushConstants.RemoteWhat.TAG_ADD /*3989*/:
                                                                        return true;
                                                                    default:
                                                                        return false;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
