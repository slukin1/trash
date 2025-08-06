package com.engagelab.privates.push.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.MTCore;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.engagelab.privates.push.MTPush;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.engagelab.privates.push.utils.NotificationUtil;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.Set;

public class MTPushPrivatesApi {
    public static final byte PLATFORM_DEFAULT = 0;
    public static final byte PLATFORM_GOOGLE = 8;
    public static final byte PLATFORM_HONOR = 7;
    public static final byte PLATFORM_HUAWEI = 2;
    public static final byte PLATFORM_MEIZU = 3;
    public static final byte PLATFORM_OPPO = 4;
    public static final byte PLATFORM_VIVO = 5;
    public static final byte PLATFORM_XIAOMI = 1;
    public static int SDK_VERSION_CODE = 426;
    public static String SDK_VERSION_NAME = "4.2.6";
    private static final String TAG = "MTPushPrivatesApi";

    public static class Code {
        public static int CONNECT_NOT_ENABLE = 6012;
        public static int INVALID_ALIAS = 6003;
        public static int INVALID_JSON = 6010;
        public static int INVALID_MOBILE_NUMBER = 6023;
        public static int INVALID_TAGS = 6005;
        public static int INVOKE_TOO_SOON = 6011;
        public static int NULL_TAG_AND_ALIAS = 6001;
        public static final int SUCCESS = 0;
        public static int TIMEOUT = 6002;
        public static int TOO_LONG_ALIAS = 6004;
        public static int TOO_LONG_TAG = 6006;
        public static int TOO_LONG_TAGS = 6008;
        public static int TOO_MANY_TAGS = 6007;
        public static int UNKNOWN_ERROR = 6009;
    }

    public static void addTag(Context context, int i11, String... strArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "addTag context can't be null, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "addTag sequence can't be 0, please check it");
        } else if (strArr == null) {
            MTCommonLog.e(TAG, "addTag tag can't be null, please check it");
        } else if (strArr.length == 0) {
            MTCommonLog.e(TAG, "addTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            bundle.putStringArray("tag", strArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_ADD, bundle);
        }
    }

    @Deprecated
    public static void addTags(Context context, int i11, Set<String> set) {
        if (set == null) {
            MTCommonLog.e(TAG, "addTags tags can't be null, please check it");
        } else if (set.isEmpty()) {
            MTCommonLog.e(TAG, "addTags tags can't be empty, please check it");
        } else {
            addTag(context, i11, (String[]) set.toArray(new String[set.size()]));
        }
    }

    @Deprecated
    public static void checkTagBindState(Context context, int i11, String str) {
        queryTag(context.getApplicationContext(), i11, str);
    }

    @Deprecated
    public static void cleanTags(Context context, int i11) {
        deleteAllTag(context.getApplicationContext(), i11);
    }

    public static void clearAlias(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearAlias context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ALIAS_CLEAR, bundle);
        }
    }

    @Deprecated
    public static void clearAllNotifications(Context context) {
        clearNotification(context);
    }

    public static void clearNotification(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearNotification context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Notification.KEY_NOTIFY_ID, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.CLEAR_NOTIFICATION, bundle);
        }
    }

    @Deprecated
    public static void clearNotificationById(Context context, int i11) {
        clearNotification(context, i11);
    }

    public static void configOldPushVersion(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "init context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            SDK_VERSION_CODE = 396;
            SDK_VERSION_NAME = "3.9.6";
            MTCommonLog.d(TAG, "configOldPushVersion " + SDK_VERSION_NAME);
        }
    }

    @Deprecated
    public static void deleteAlias(Context context, int i11) {
        clearAlias(context, i11);
    }

    public static void deleteAllTag(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "deleteAllTag context can't be null, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "deleteAllTag sequence can't be 0, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_DELETE_ALL, bundle);
        }
    }

    public static void deleteGeofence(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "deleteGeofence context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "deleteGeofence geofenceId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.DELETE_GEOFENCE, bundle);
        }
    }

    public static void deleteTag(Context context, int i11, String... strArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "deleteTag context can't be null, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "deleteTag sequence can't be 0, please check it");
        } else if (strArr == null) {
            MTCommonLog.e(TAG, "deleteTag tag can't be null, please check it");
        } else if (strArr.length == 0) {
            MTCommonLog.e(TAG, "deleteTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            bundle.putStringArray("tag", strArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_DELETE, bundle);
        }
    }

    @Deprecated
    public static void deleteTags(Context context, int i11, Set<String> set) {
        if (set == null) {
            MTCommonLog.e(TAG, "deleteTags tags can't be null, please check it");
        } else if (set.isEmpty()) {
            MTCommonLog.e(TAG, "deleteTags tags can't be empty, please check it");
        } else {
            deleteTag(context, i11, (String[]) set.toArray(new String[set.size()]));
        }
    }

    public static void getAlias(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "getAlias context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ALIAS_GET, bundle);
        }
    }

    @Deprecated
    public static void getAllTags(Context context, int i11) {
        queryAllTag(context.getApplicationContext(), i11);
    }

    @Deprecated
    public static String getRegistrationID(Context context) {
        return MTCorePrivatesApi.getRegistrationId(context);
    }

    public static void goToAppNotificationSettings(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "goToAppNotificationSettings context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationUtil.goToAppNotificationSettings(context.getApplicationContext());
        }
    }

    public static void init(Context context) {
        MTCommonLog.d(TAG, "MTPushPrivatesApi.init 3.0.0");
        if (context == null) {
            MTCommonLog.e(TAG, "init context can't be null, please check it");
            return;
        }
        MTCommonLog.d(TAG, "init setAddress");
        if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.init(context.getApplicationContext(), true);
            if (MTGlobal.isMainProcess(context.getApplicationContext())) {
                MTCommonPrivatesApi.observer(context.getApplicationContext(), new MTCore());
                MTCommonPrivatesApi.observer(context.getApplicationContext(), new MTPush());
                return;
            }
            return;
        }
        MTCommonLog.e(TAG, "Please call the MTPushPrivatesApi.init function in the main process or the push process");
    }

    public static void queryAllTag(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "queryAllTag context can't be null, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "queryAllTag sequence can't be 0, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_QUERY_ALL, bundle);
        }
    }

    public static void queryTag(Context context, int i11, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "queryTag context can't be null, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "queryTag sequence can't be 0, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "queryTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            bundle.putString("tag", str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_QUERY, bundle);
        }
    }

    public static void reportNotificationArrived(Context context, String str, byte b11, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationArrived context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationArrived messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b11).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_ARRIVED, bundle);
        }
    }

    public static void reportNotificationClicked(Context context, String str, byte b11, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationClicked context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationClicked messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b11).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_CLICKED, bundle);
        }
    }

    public static void reportNotificationDeleted(Context context, String str, byte b11, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationDeleted context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationDeleted messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b11).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_DELETED, bundle);
        }
    }

    public static void reportNotificationOpened(Context context, String str, byte b11, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "reportNotificationOpened context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "reportNotificationOpened messageId can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            NotificationMessage platformMessageId = new NotificationMessage().setMessageId(str).setPlatform(b11).setPlatformMessageId(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", platformMessageId);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_NOTIFICATION_OPENED, bundle);
        }
    }

    @Deprecated
    public static void reportThirdToken(Context context, String str, byte b11, String str2) {
        uploadPlatformToken(context.getApplicationContext(), b11, str, str2);
    }

    public static void resetNotificationBadge(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationBadge context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_BADGE, (Bundle) null);
        }
    }

    public static void resetNotificationCount(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationCount context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_COUNT, (Bundle) null);
        }
    }

    public static void resetNotificationLayout(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationLayout context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_LAYOUT, bundle);
        }
    }

    public static void resetNotificationShowTime(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationShowTime context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SHOW_TIME, (Bundle) null);
        }
    }

    public static void resetNotificationSilenceTime(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "resetNotificationSilenceTime context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.RESET_NOTIFICATION_SILENCE_TIME, (Bundle) null);
        }
    }

    @Deprecated
    public static void resumePush(Context context) {
        turnOnPush(context.getApplicationContext());
    }

    public static void setAlias(Context context, int i11, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "setAlias context can't be null, please check it");
        } else if (str == null) {
            MTCommonLog.e(TAG, "setAlias alias can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            bundle.putString(MTPushConstants.Operation.KEY_ALIAS, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ALIAS_SET, bundle);
        }
    }

    @Deprecated
    public static void setBadgeNumber(Context context, int i11) {
        setNotificationBadge(context, i11);
    }

    @Deprecated
    public static void setDefaultNotifactionNumber(Context context) {
        resetNotificationCount(context);
    }

    public static void setGeofenceCount(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "setGeofenceCount context can't be null, please check it");
        } else if (i11 <= 0 || i11 >= 100) {
            MTCommonLog.e(TAG, "setGeofenceCount count must between 0~100, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("count", i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_GEOFENCE_COUNT, bundle);
        }
    }

    public static void setGeofenceInterval(Context context, long j11) {
        if (context == null) {
            MTCommonLog.e(TAG, "setGeofenceInterval context can't be null, please check it");
        } else if (j11 < 180000 || j11 > Period.DAY_MILLS) {
            MTCommonLog.e(TAG, "setGeofenceInterval interval must between 3 * 60 * 1000 ~ 24 * 60 * 60 * 1000, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putLong(MTPushConstants.Geofence.KEY_INTERVAL, j11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_GEOFENCE_INTERVAL, bundle);
        }
    }

    @Deprecated
    public static void setLatestNotificationNumber(Context context, int i11) {
        setNotificationCount(context.getApplicationContext(), i11);
    }

    @Deprecated
    public static void setMaxGeofenceNumber(Context context, int i11) {
        setGeofenceCount(context.getApplicationContext(), i11);
    }

    @Deprecated
    public static void setMobileNumber(Context context, int i11, String str) {
        uploadMobileNumber(context, i11, str);
    }

    public static void setNotificationBadge(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationBadge context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.NotificationBadge.KEY_BADGE, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_BADGE, bundle);
        }
    }

    public static void setNotificationCount(Context context, int i11) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationCount context can't be null, please check it");
        } else if (i11 < 0) {
            MTCommonLog.e(TAG, "setNotificationCount count can't small than 0, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "setNotificationCount count can't equal with 0, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.NotificationCount.KEY_COUNT, i11);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_COUNT, bundle);
        }
    }

    public static void setNotificationLayout(Context context, int i11, NotificationLayout notificationLayout) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationLayout context can't be null, please check it");
        } else if (notificationLayout == null) {
            MTCommonLog.e(TAG, "setNotificationLayout notificationLayout can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", i11);
            bundle.putParcelable(MTPushConstants.NotificationLayout.KEY_NOTIFICATION_LAYOUT, notificationLayout);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_LAYOUT, bundle);
        }
    }

    public static void setNotificationShowTime(Context context, int i11, int i12, int... iArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationShowTime context can't be null, please check it");
        } else if (i11 < 0 || i11 > 23) {
            MTCommonLog.e(TAG, "setNotificationShowTime beginHour must between 0~23, please check it");
        } else if (i12 < 0 || i12 > 23) {
            MTCommonLog.e(TAG, "setNotificationShowTime endHour must between 0~23, please check it");
        } else if (i11 > i12) {
            MTCommonLog.e(TAG, "setNotificationShowTime beginHour can't large than endHour, please check it");
        } else if (i11 == i12) {
            MTCommonLog.e(TAG, "setNotificationShowTime beginHour can't equal with endHour, please check it");
        } else if (iArr.length > 7) {
            MTCommonLog.e(TAG, "setNotificationShowTime weekDays.length must between 0~7, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR, i11);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_END_HOUR, i12);
            bundle.putIntArray(MTPushConstants.NotificationTime.KEY_DAYS, iArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_SHOW_TIME, bundle);
        }
    }

    public static void setNotificationSilenceTime(Context context, int i11, int i12, int i13, int i14) {
        if (context == null) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime context can't be null, please check it");
        } else if (i11 < 0 || i11 > 23) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime beginHour must between 0~23, please check it");
        } else if (i12 < 0 || i12 > 59) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime beginMinute must between 0~59, please check it");
        } else if (i13 < 0 || i13 > 23) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime endHour must between 0~23, please check it");
        } else if (i14 < 0 || i14 > 59) {
            MTCommonLog.e(TAG, "setNotificationSilenceTime endMinute must between 0~59, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.NotificationTime.KEY_BEGIN_HOUR, i11);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_BEGIN_MINUTE, i12);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_END_HOUR, i13);
            bundle.putInt(MTPushConstants.NotificationTime.KEY_END_MINUTE, i14);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SET_NOTIFICATION_SILENCE_TIME, bundle);
        }
    }

    @Deprecated
    public static void setPushTime(Context context, Set<Integer> set, int i11, int i12) {
        if (set == null) {
            resetNotificationShowTime(context);
        } else if (set.isEmpty()) {
            setNotificationShowTime(context.getApplicationContext(), i11, i12, new int[0]);
        } else {
            int size = set.size();
            int[] iArr = new int[size];
            Integer[] numArr = new Integer[set.size()];
            set.toArray(numArr);
            System.arraycopy(numArr, 0, iArr, 0, size);
            setNotificationShowTime(context.getApplicationContext(), i11, i12, iArr);
        }
    }

    @Deprecated
    public static void setSilenceTime(Context context, int i11, int i12, int i13, int i14) {
        setNotificationSilenceTime(context.getApplicationContext(), i11, i12, i13, i14);
    }

    @Deprecated
    public static void setTags(Context context, int i11, Set<String> set) {
        if (set == null) {
            MTCommonLog.e(TAG, "setTags tags can't be null, please check it");
        } else if (set.isEmpty()) {
            MTCommonLog.e(TAG, "setTags tags can't be empty, please check it");
        } else {
            updateTag(context, i11, (String[]) set.toArray(new String[set.size()]));
        }
    }

    public static void showNotification(Context context, NotificationMessage notificationMessage) {
        if (context == null) {
            MTCommonLog.e(TAG, "showNotification context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", notificationMessage);
            bundle.putBoolean(MTPushConstants.Message.KEY_MESSAGE_LIMIT, false);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.SHOW_NOTIFICATION, bundle);
        }
    }

    @Deprecated
    public static void stopPush(Context context) {
        turnOffPush(context.getApplicationContext());
    }

    public static void turnOffGeofenceSwitch(Context context) {
        if (context == null) {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOffGeofenceSwitch context can't be null, please check it");
        } else if (!MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOffGeofenceSwitch should be called in main process");
        } else {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_OFF_GEOFENCESWITCH, (Bundle) null);
        }
    }

    public static void turnOffPush(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "turnOffPush context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_OFF_PUSH, (Bundle) null);
        }
    }

    public static void turnOnGeofenceSwitch(Context context) {
        if (context == null) {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOnGeofenceSwitch context can't be null, please check it");
        } else if (!MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonLog.e("MTCommonPrivatesApi", "turnOnGeofenceSwitch should be called in main process");
        } else {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_ON_GEOFENCESWITCH, (Bundle) null);
        }
    }

    public static void turnOnPush(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "turnOnPush context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TURN_ON_PUSH, (Bundle) null);
        }
    }

    public static void updateTag(Context context, int i11, String... strArr) {
        if (context == null) {
            MTCommonLog.e(TAG, "updateTag context can't be null, please check it");
        } else if (i11 == 0) {
            MTCommonLog.e(TAG, "updateTag sequence can't be 0, please check it");
        } else if (strArr == null) {
            MTCommonLog.e(TAG, "updateTag tag can't be null, please check it");
        } else if (strArr.length == 0) {
            MTCommonLog.e(TAG, "updateTag tag can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            bundle.putStringArray("tag", strArr);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.TAG_UPDATE, bundle);
        }
    }

    public static void uploadMobileNumber(Context context, int i11, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "uploadMobileNumber context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "uploadMobileNumber mobileNumber can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            Bundle bundle = new Bundle();
            bundle.putInt(MTPushConstants.Operation.KEY_SEQUENCE, i11);
            bundle.putString(MTPushConstants.Operation.KEY_MOBILE_NUMBER, str);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_MOBILE_NUMBER, bundle);
        }
    }

    public static void uploadPlatformToken(Context context, byte b11, String str, String str2) {
        if (context == null) {
            MTCommonLog.e(TAG, "onPlatformToken context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            PlatformTokenMessage region = new PlatformTokenMessage().setPlatform(b11).setToken(str).setRegion(str2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", region);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.ON_PLATFORM_TOKEN, bundle);
        }
    }

    public static void clearNotification(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "clearNotification context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context.getApplicationContext(), MTPushConstants.RemoteWhat.CLEAR_NOTIFICATION, (Bundle) null);
        }
    }

    @Deprecated
    public static void reportNotificationArrived(Context context, String str, byte b11) {
        reportNotificationArrived(context, str, b11, "");
    }

    @Deprecated
    public static void reportNotificationOpened(Context context, String str, byte b11) {
        reportNotificationOpened(context, str, b11, "");
    }
}
