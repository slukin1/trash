package com.engagelab.privates.common;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.DeviceUtil;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.NotificationLayout;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.engagelab.privates.push.utils.NotificationUtil;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class j {

    /* renamed from: b  reason: collision with root package name */
    public static volatile j f64963b;

    /* renamed from: a  reason: collision with root package name */
    public int f64964a = -1;

    public static j a() {
        if (f64963b == null) {
            synchronized (j.class) {
                f64963b = new j();
            }
        }
        return f64963b;
    }

    public int b(Context context) {
        return t.e(context);
    }

    public boolean c(Context context) {
        try {
            String f11 = t.f(context);
            if (TextUtils.isEmpty(f11)) {
                return true;
            }
            MTCommonLog.d("MTPushBusiness", "isNotificationShowTime showTime:" + f11);
            String[] split = f11.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar instance = Calendar.getInstance();
            int i11 = instance.get(7);
            int i12 = instance.get(11);
            MTCommonLog.d("MTPushBusiness", "isNotificationShowTime currentHour:" + i12 + ",currentDay:" + i11);
            int length = charArray.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length) {
                    break;
                }
                int parseInt = Integer.parseInt(String.valueOf(charArray[i13]));
                MTCommonLog.d("MTPushBusiness", "settingDay:" + parseInt);
                if (i11 != parseInt + 1) {
                    break;
                }
                int parseInt2 = Integer.parseInt(split2[0]);
                int parseInt3 = Integer.parseInt(split2[1]);
                if (i12 >= parseInt2 && i12 <= parseInt3) {
                    return true;
                }
                i13++;
            }
            return false;
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "isNotificationShowTime failed " + th2.getMessage());
            return true;
        }
    }

    public boolean d(Context context) {
        try {
            String g11 = t.g(context);
            if (TextUtils.isEmpty(g11)) {
                return false;
            }
            MTCommonLog.d("MTPushBusiness", "isNotificationSilenceTime cacheSilenceTime:" + g11);
            JSONObject jSONObject = new JSONObject(g11);
            int optInt = jSONObject.optInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR);
            int optInt2 = jSONObject.optInt(MTPushConstants.NotificationTime.KEY_BEGIN_MINUTE);
            int optInt3 = jSONObject.optInt(MTPushConstants.NotificationTime.KEY_END_HOUR);
            int optInt4 = jSONObject.optInt(MTPushConstants.NotificationTime.KEY_END_MINUTE);
            Calendar instance = Calendar.getInstance();
            int i11 = instance.get(11);
            int i12 = instance.get(12);
            MTCommonLog.d("MTPushBusiness", "isNotificationSilenceTime currentTime:" + i11 + ":" + i12 + ", silenceTime:" + optInt + ":" + optInt2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optInt3 + ":" + optInt4);
            if (optInt < optInt3) {
                if (i11 > optInt && i11 < optInt3) {
                    MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 1");
                    return true;
                } else if (i11 == optInt && i12 >= optInt2) {
                    MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 2");
                    return true;
                } else if (i11 != optInt3 || i12 > optInt4) {
                    MTCommonLog.d("MTPushBusiness", "not notificationSilenceTime 1");
                    return false;
                } else {
                    MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 3");
                    return true;
                }
            } else if (optInt != optInt3) {
                if (optInt > optInt3) {
                    if (i11 > optInt && i11 <= 23) {
                        MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 8");
                        return true;
                    } else if (i11 >= 0 && i11 < optInt3) {
                        MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 9");
                        return true;
                    } else if (i11 == optInt && i12 >= optInt2) {
                        MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 10");
                        return true;
                    } else if (i11 != optInt3 || i12 > optInt4) {
                        MTCommonLog.d("MTPushBusiness", "not notificationSilenceTime 4");
                        return false;
                    } else {
                        MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 11");
                        return true;
                    }
                }
                MTCommonLog.d("MTPushBusiness", "not notificationSilenceTime 5");
                return false;
            } else if (optInt2 >= optInt4) {
                if (i11 != optInt) {
                    MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 4");
                    return true;
                } else if (i12 >= optInt2) {
                    MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 5");
                    return true;
                } else if (i12 <= optInt4) {
                    MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 6");
                    return true;
                } else {
                    MTCommonLog.d("MTPushBusiness", "not notificationSilenceTime 2");
                    return false;
                }
            } else if (i11 != optInt || i12 < optInt2 || i12 > optInt4) {
                MTCommonLog.d("MTPushBusiness", "not notificationSilenceTime 3");
                return false;
            } else {
                MTCommonLog.d("MTPushBusiness", "is notificationSilenceTime 7");
                return true;
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "isNotificationSilenceTime failed " + th2.getMessage());
        }
    }

    public void e(Context context, Bundle bundle) {
        try {
            bundle.setClassLoader(NotificationLayout.class.getClassLoader());
            int i11 = bundle.getInt("id");
            NotificationLayout notificationLayout = (NotificationLayout) bundle.getParcelable(MTPushConstants.NotificationLayout.KEY_NOTIFICATION_LAYOUT);
            MTCommonLog.d("MTPushBusiness", "setNotificationLayout id:" + i11 + notificationLayout.toString());
            int layoutId = notificationLayout.getLayoutId();
            int iconViewId = notificationLayout.getIconViewId();
            int iconResourceId = notificationLayout.getIconResourceId();
            int titleViewId = notificationLayout.getTitleViewId();
            int contentViewId = notificationLayout.getContentViewId();
            int timeViewId = notificationLayout.getTimeViewId();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("layout_id", layoutId);
            jSONObject.put(MTPushConstants.NotificationLayout.KEY_ICON_VIEW_ID, iconViewId);
            jSONObject.put(MTPushConstants.NotificationLayout.KEY_ICON_RESOURCE_ID, iconResourceId);
            jSONObject.put(MTPushConstants.NotificationLayout.KEY_TITLE_VIEW_ID, titleViewId);
            jSONObject.put(MTPushConstants.NotificationLayout.KEY_CONTENT_VIEW_ID, contentViewId);
            jSONObject.put(MTPushConstants.NotificationLayout.KEY_TIME_VIEW_ID, timeViewId);
            t.a(context, i11, jSONObject.toString());
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "setNotificationLayout failed " + th2.getMessage());
        }
    }

    public void f(Context context, Bundle bundle) {
        try {
            MTCommonLog.d("MTPushBusiness", "setNotificationShowTime:" + MTCommonLog.toLogString(bundle));
            int[] intArray = bundle.getIntArray(MTPushConstants.NotificationTime.KEY_DAYS);
            if (intArray.length == 0) {
                MTCommonLog.d("MTPushBusiness", "setNotificationShowTime weekDays.length is 0, can't show notification everyTime");
                t.c(context, "");
                return;
            }
            int i11 = bundle.getInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR);
            int i12 = bundle.getInt(MTPushConstants.NotificationTime.KEY_END_HOUR);
            MTCommonLog.d("MTPushBusiness", "setNotificationShowTime startHour:" + i11 + ",endHour:" + i12 + ",weekDays:" + Arrays.toString(intArray));
            StringBuilder sb2 = new StringBuilder();
            for (int valueOf : intArray) {
                sb2.append(Integer.valueOf(valueOf));
            }
            sb2.append("_");
            sb2.append(i11);
            sb2.append("^");
            sb2.append(i12);
            if (Pattern.compile("([0-6]{0,7})_((" + "([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])" + ")|(" + "([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])" + "-)+(" + "([0-9]|1[0-9]|2[0-3])\\^([0-9]|1[0-9]|2[0-3])" + "))").matcher(sb2).matches()) {
                t.c(context, sb2.toString());
                return;
            }
            MTCommonLog.e("MTPushBusiness", "setNotificationShowTime invalid time format - " + sb2);
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "setNotificationPushTime failed " + th2.getMessage());
        }
    }

    public void g(Context context, Bundle bundle) {
        try {
            int i11 = bundle.getInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR);
            int i12 = bundle.getInt(MTPushConstants.NotificationTime.KEY_BEGIN_MINUTE);
            int i13 = bundle.getInt(MTPushConstants.NotificationTime.KEY_END_HOUR);
            int i14 = bundle.getInt(MTPushConstants.NotificationTime.KEY_END_MINUTE);
            MTCommonLog.d("MTPushBusiness", "setNotificationSilenceTime:" + i11 + ":" + i12 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i13 + ":" + i14);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR, i11);
            jSONObject.put(MTPushConstants.NotificationTime.KEY_BEGIN_MINUTE, i12);
            jSONObject.put(MTPushConstants.NotificationTime.KEY_END_HOUR, i13);
            jSONObject.put(MTPushConstants.NotificationTime.KEY_END_MINUTE, i14);
            t.d(context, jSONObject.toString());
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "setNotificationSilenceTime failed " + th2.getMessage());
        }
    }

    public void h(Context context) {
        MTCommonLog.d("MTPushBusiness", "resetNotificationShowTime");
        t.c(context, "");
    }

    public void i(Context context) {
        MTCommonLog.d("MTPushBusiness", "resetNotificationSilenceTime");
        t.d(context, "");
    }

    public void b(Context context, Bundle bundle) {
        int i11 = bundle.getInt("id");
        MTCommonLog.d("MTPushBusiness", "resetNotificationLayout builderId:" + i11);
        t.a(context, i11, "");
    }

    public void b(Context context, int i11) {
        boolean notificationState = NotificationUtil.getNotificationState(context);
        int i12 = this.f64964a;
        if (i12 == -1) {
            MTCommonLog.d("MTPushBusiness", "notification state is " + notificationState);
            this.f64964a = notificationState;
            a(context, i11, notificationState);
        } else if (i12 == notificationState) {
            MTCommonLog.d("MTPushBusiness", "no need update notification state lastNotificationState:" + this.f64964a + ",currentNotificationState:" + notificationState);
        } else {
            MTCommonLog.d("MTPushBusiness", "notification state is " + notificationState);
            this.f64964a = notificationState ? 1 : 0;
            a(context, i11, notificationState);
        }
    }

    public int a(Context context) {
        return t.d(context);
    }

    public NotificationLayout a(Context context, int i11) {
        try {
            String a11 = t.a(context, i11);
            if (TextUtils.isEmpty(a11)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(a11);
            if (jSONObject.length() == 0) {
                return null;
            }
            int optInt = jSONObject.optInt("layout_id");
            int optInt2 = jSONObject.optInt(MTPushConstants.NotificationLayout.KEY_ICON_VIEW_ID);
            int optInt3 = jSONObject.optInt(MTPushConstants.NotificationLayout.KEY_ICON_RESOURCE_ID);
            int optInt4 = jSONObject.optInt(MTPushConstants.NotificationLayout.KEY_TITLE_VIEW_ID);
            int optInt5 = jSONObject.optInt(MTPushConstants.NotificationLayout.KEY_CONTENT_VIEW_ID);
            NotificationLayout timeViewId = new NotificationLayout().setLayoutId(optInt).setIconViewId(optInt2).setIconResourceId(optInt3).setTitleViewId(optInt4).setContentViewId(optInt5).setTimeViewId(jSONObject.optInt(MTPushConstants.NotificationLayout.KEY_TIME_VIEW_ID));
            MTCommonLog.d("MTPushBusiness", "getNotificationLayout builderId:" + i11 + timeViewId.toString());
            return timeViewId;
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "getNotificationLayout builderId:" + i11 + " failed " + th2.getMessage());
            return null;
        }
    }

    public void g(Context context) {
        MTCommonLog.d("MTPushBusiness", "resetNotificationCount");
        t.c(context, 5);
    }

    public void c(Context context, Bundle bundle) {
        int i11 = bundle.getInt(MTPushConstants.NotificationBadge.KEY_BADGE);
        if (i11 < 0) {
            MTCommonLog.e("MTPushBusiness", "setNotificationBadge error: number count must >= 0");
            return;
        }
        t.b(context, i11);
        String str = Build.MANUFACTURER;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str.toLowerCase();
        lowerCase2.hashCode();
        if (lowerCase2.equals(MTPushConstants.Manufacturer.HUAWEI) || lowerCase2.equals(MTPushConstants.Manufacturer.HONOR)) {
            NotificationUtil.setHuaweiBadgeNumber(context, i11);
            return;
        }
        MTCommonLog.d("MTPushBusiness", "setNotificationBadge not support " + lowerCase);
    }

    public void e(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("itime", System.currentTimeMillis() / 1000);
            jSONObject.put("lang", DeviceUtil.getLanguage(context));
            jSONObject.put("contry", MTGlobal.getCountryCode(context));
            jSONObject.put("carrier", DeviceUtil.getCarrier(context));
            jSONObject.put(TPDownloadProxyEnum.USER_OS_VERSION, DeviceUtil.getSystemVersionRelease());
            jSONObject.put("os_version_code", DeviceUtil.getSystemVersionSdkInt());
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, DeviceUtil.getModel());
            jSONObject.put("device_name", DeviceUtil.getSystemDevice());
            jSONObject.put("product", DeviceUtil.getProduct());
            jSONObject.put("manufacturer", DeviceUtil.getManufacturer());
            jSONObject.put(VulcanInfo.TIME_ZONE, DeviceUtil.getTimeZone());
            jSONObject.put("time_zone_id", DeviceUtil.getTimeZoneId());
            jSONObject.put(Constants.EXTRA_KEY_APP_VERSION, MTGlobal.getAppVersionName(context));
            jSONObject.put("android_id", DeviceUtil.getAndroidId(context));
            MTReporter content = new MTReporter().setType("oversea_info").setContent(jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle);
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "reportSoverseaInfo failed " + th2.getMessage());
        }
    }

    public void f(Context context) {
        t.b(context, 0);
        String str = Build.MANUFACTURER;
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str.toLowerCase();
        lowerCase2.hashCode();
        if (lowerCase2.equals(MTPushConstants.Manufacturer.HUAWEI) || lowerCase2.equals(MTPushConstants.Manufacturer.HONOR)) {
            NotificationUtil.setHuaweiBadgeNumber(context, 0);
            return;
        }
        MTCommonLog.d("MTPushBusiness", "setNotificationBadge not support " + lowerCase);
    }

    public void a(Context context, Bundle bundle) {
        try {
            MTCommonReceiver commonReceiver = MTGlobal.getCommonReceiver(context);
            if (commonReceiver != null) {
                commonReceiver.onNotificationStatus(context, bundle.getBoolean(MTPushConstants.NotificationState.KEY_STATE));
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "processMainNotificationState failed " + th2.getMessage());
        }
    }

    public final void a(Context context, int i11, boolean z11) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MTPushConstants.NotificationState.KEY_STATE, z11);
            MTCommonPrivatesApi.sendMessageToMainProcess(context, 3006, bundle);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MTPushConstants.NotificationState.KEY_STATE, z11);
            jSONObject.put("trigger_scene", i11);
            MTReporter content = new MTReporter().setType("android_notification_state").setContent(jSONObject.toString());
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, content);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, bundle2);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTPushConstants.RemoteWhat.REPORT_NOTIFICATION_STATE, bundle2);
        } catch (Throwable th2) {
            MTCommonLog.w("MTPushBusiness", "onNotificationState failed " + th2.getMessage());
        }
    }

    public void d(Context context, Bundle bundle) {
        if (bundle != null) {
            int i11 = bundle.getInt(MTPushConstants.NotificationCount.KEY_COUNT);
            if (i11 <= 0) {
                MTCommonLog.e("MTPushBusiness", "setNotificationCount error: count must > 0");
                return;
            }
            MTCommonLog.e("MTPushBusiness", "setNotificationCount " + i11);
            t.c(context, i11);
        }
    }
}
