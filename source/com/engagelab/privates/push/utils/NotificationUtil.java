package com.engagelab.privates.push.utils;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import android.widget.RemoteViews;
import com.engagelab.privates.common.component.MTCommonActivity;
import com.engagelab.privates.common.j;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.t;
import com.engagelab.privates.push.api.NotificationLayout;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class NotificationUtil {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String NOTIFICATION_ICON = "mtpush_notification_icon";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String TAG = "NotificationUtil";

    public static String[] convertJsonToArray(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String[] strArr = new String[jSONObject.length()];
            int i11 = 0;
            while (keys.hasNext()) {
                strArr[i11] = jSONObject.optString(keys.next());
                i11++;
            }
            return strArr;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "convertJsonToArray failed " + th2.getMessage());
            return null;
        }
    }

    public static Bundle convertJsonToBundle(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(jSONObject.toString())) {
                return null;
            }
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            return bundle;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "convertJsonToBundle failed " + th2.getMessage());
            return null;
        }
    }

    public static Bundle convertMapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }

    public static Notification.BigPictureStyle getBigPictureStyle(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 16 || TextUtils.isEmpty(str)) {
                return null;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            Bitmap pictureBitmap = getPictureBitmap(context, str);
            if (pictureBitmap == null) {
                return null;
            }
            return bigPictureStyle.bigPicture(pictureBitmap);
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "get bigPictureStyle failed " + th2.getMessage());
            return null;
        }
    }

    public static Notification.BigTextStyle getBigTextStyle(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(str)) {
            return new Notification.BigTextStyle().bigText(str);
        }
        return null;
    }

    public static String getContent(Context context, NotificationMessage notificationMessage) {
        if (TextUtils.isEmpty(notificationMessage.getContent())) {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        }
        return notificationMessage.getContent();
    }

    public static int getDefaults(Context context, boolean z11, NotificationMessage notificationMessage) {
        if (!z11) {
            switch (notificationMessage.getDefaults()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return notificationMessage.getDefaults();
                default:
                    return -1;
            }
        } else if ((notificationMessage.getDefaults() & 1) == 0) {
            return notificationMessage.getDefaults();
        } else {
            return notificationMessage.getDefaults() - 1;
        }
    }

    public static Notification.InboxStyle getInboxStyle(Context context, String[] strArr) {
        try {
            if (Build.VERSION.SDK_INT >= 16 && strArr != null) {
                if (strArr.length != 0) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    for (String addLine : strArr) {
                        inboxStyle.addLine(addLine);
                    }
                    inboxStyle.setSummaryText(" + " + strArr.length + " new messages");
                    return inboxStyle;
                }
            }
            return null;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getInboxStyle failed " + th2.getMessage());
            return null;
        }
    }

    public static Bitmap getLargeIcon(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getPictureBitmap(context, str);
    }

    private static String getLaunchActivityClassName(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(launchIntentForPackage, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
            return "";
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getLaunchActivityClassName failed " + th2.getMessage());
            return "";
        }
    }

    public static String getMessageId(JSONObject jSONObject) {
        String optString = jSONObject.optString("ad_id");
        if (TextUtils.isEmpty(optString)) {
            optString = jSONObject.optString("msg_id");
        }
        return TextUtils.isEmpty(optString) ? jSONObject.optString("_jmsgid_") : optString;
    }

    public static int getNotificationId(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getNotificationId failed " + th2.getMessage());
            return 0;
        }
    }

    public static RemoteViews getNotificationLayout(Context context, NotificationMessage notificationMessage) {
        Icon smallIcon;
        try {
            NotificationLayout a11 = j.a().a(context, notificationMessage.getBuilderId());
            if (a11 == null) {
                MTCommonLog.d(TAG, "getNotificationLayout builderId:" + notificationMessage.getBuilderId() + ", notificationLayout is null");
                return null;
            }
            MTCommonLog.d(TAG, "getNotificationLayout builderId:" + notificationMessage.getBuilderId() + ", notificationLayout:" + a11.toString());
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), a11.getLayoutId());
            if (a11.getIconViewId() > 0) {
                remoteViews.setImageViewResource(a11.getIconViewId(), getSmallIcon(context));
                if (Build.VERSION.SDK_INT >= 23 && (smallIcon = getSmallIcon(context, notificationMessage)) != null) {
                    remoteViews.setImageViewIcon(a11.getIconViewId(), smallIcon);
                }
            }
            if (a11.getTitleViewId() > 0) {
                remoteViews.setTextViewText(a11.getTitleViewId(), getTitle(context, notificationMessage));
            }
            if (a11.getContentViewId() > 0) {
                remoteViews.setTextViewText(a11.getContentViewId(), getContent(context, notificationMessage));
            }
            if (a11.getTimeViewId() > 0) {
                remoteViews.setLong(a11.getTimeViewId(), "setTime", System.currentTimeMillis());
            }
            return remoteViews;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getNotificationLayout failed " + th2.getMessage());
            return null;
        }
    }

    public static boolean getNotificationState(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                if (notificationManager == null) {
                    return false;
                }
                return notificationManager.areNotificationsEnabled();
            } catch (Throwable th2) {
                MTCommonLog.w(TAG, "getNotificationState failed " + th2.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i11 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class cls2 = Integer.TYPE;
                if (((Integer) cls.getMethod(CHECK_OP_NO_THROW, new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i11), packageName})).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Throwable th3) {
                MTCommonLog.w(TAG, "getNotificationState failed " + th3.getMessage());
            }
        }
        return false;
    }

    public static PendingIntent getPendingIntent(Context context, String str, NotificationMessage notificationMessage) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 11) {
            return null;
        }
        Intent intent = new Intent();
        intent.setClass(context, MTCommonActivity.class);
        intent.setAction(str);
        intent.addFlags(276824064);
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", notificationMessage);
        intent.putExtras(bundle);
        int i12 = i11 >= 23 ? 67108864 : 134217728;
        int notificationId = notificationMessage.getNotificationId();
        PushAutoTrackHelper.hookIntentGetActivity(context, notificationId, intent, i12);
        PendingIntent activity = PendingIntent.getActivity(context, notificationId, intent, i12);
        PushAutoTrackHelper.hookPendingIntentGetActivity(activity, context, notificationId, intent, i12);
        return activity;
    }

    public static Bitmap getPictureBitmap(Context context, String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                if (!URLUtil.isValidUrl(str)) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
                    Runtime.getRuntime().gc();
                    return decodeResource;
                }
            }
            byte[] bArr = new HttpUtils().get(context, str);
            if (bArr == null) {
                MTCommonLog.d(TAG, "getPicture bytes is null");
                return null;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Runtime.getRuntime().gc();
            return decodeByteArray;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "get pictureBitmap failed " + th2.getMessage());
            return null;
        } finally {
            Runtime.getRuntime().gc();
        }
    }

    public static int getPriority(Context context, boolean z11, NotificationMessage notificationMessage) {
        if (Build.VERSION.SDK_INT < 16) {
            return 0;
        }
        if (z11) {
            return -1;
        }
        int priority = notificationMessage.getPriority();
        if (priority == -2 || priority == -1 || priority == 0 || priority == 1 || priority == 2) {
            return notificationMessage.getPriority();
        }
        return 0;
    }

    public static int getSmallIcon(Context context) {
        int identifier = context.getResources().getIdentifier(NOTIFICATION_ICON, "drawable", context.getPackageName());
        if (identifier > 0) {
            return identifier;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).icon;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "get getSmallIcon failed " + th2.getMessage());
            MTCommonLog.e(TAG, "please put icon [mtpush_notification_icon] in res/drawable");
            return 0;
        }
    }

    public static Uri getSoundUri(Context context, boolean z11, NotificationMessage notificationMessage) {
        if (z11) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(notificationMessage.getSound())) {
                return null;
            }
            if (context.getResources().getIdentifier(notificationMessage.getSound(), "raw", context.getPackageName()) == 0) {
                MTCommonLog.d(TAG, "there are no sound resource");
                return null;
            }
            return Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + notificationMessage.getSound());
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getSoundUri failed " + th2.getMessage());
            return null;
        }
    }

    public static Notification.Style getStyle(Context context, NotificationMessage notificationMessage) {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        int style = notificationMessage.getStyle();
        if (style == 1) {
            return getBigTextStyle(context, notificationMessage.getBigText());
        }
        if (style == 2) {
            return getInboxStyle(context, notificationMessage.getInbox());
        }
        if (style != 3) {
            return null;
        }
        return getBigPictureStyle(context, notificationMessage.getBigPicture());
    }

    public static String getTitle(Context context, NotificationMessage notificationMessage) {
        if (TextUtils.isEmpty(notificationMessage.getTitle())) {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        }
        return notificationMessage.getTitle();
    }

    public static int getVisibility(Context context, boolean z11, NotificationMessage notificationMessage) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        int i11 = -1;
        if (z11) {
            return -1;
        }
        int priority = notificationMessage.getPriority();
        if (!(priority == -2 || priority == -1)) {
            i11 = 1;
            if (priority == 1 || priority == 2) {
                return i11;
            }
            return 0;
        }
        return i11;
    }

    public static boolean goToAppNotificationSettings(Context context) {
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            } else if (i11 >= 21) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("app_package", context.getPackageName());
                intent2.putExtra("app_uid", context.getApplicationInfo().uid);
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return true;
            } else {
                Intent intent3 = new Intent();
                intent3.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent3.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
                context.startActivity(intent3);
                return true;
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "goToAppNotificationSettings failed " + th2.getMessage());
            return false;
        }
    }

    public static void setHuaweiBadgeNumber(Context context, int i11) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                Bundle bundle = new Bundle();
                bundle.putString("package", context.getPackageName());
                String launchActivityClassName = getLaunchActivityClassName(context);
                if (!TextUtils.isEmpty(launchActivityClassName)) {
                    MTCommonLog.d(TAG, "setHuaweiBadgeNumber " + i11);
                    bundle.putString(Constants.CLASS, launchActivityClassName);
                    bundle.putInt("badgenumber", i11);
                    context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "setHuaweiBadgeNumber failed " + th2.getMessage());
        }
    }

    public static void setNotificationBadge(Context context, Notification notification, int i11) {
        if (i11 != 0) {
            int a11 = j.a().a(context);
            int i12 = a11 + i11;
            t.b(context, i12);
            MTCommonLog.d(TAG, "setNotificationBadge cacheNotificationBadge[" + a11 + "]+currentNotificationBadge[" + i11 + "]");
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            lowerCase.hashCode();
            char c11 = 65535;
            switch (lowerCase.hashCode()) {
                case -1206476313:
                    if (lowerCase.equals(MTPushConstants.Manufacturer.HUAWEI)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -759499589:
                    if (lowerCase.equals("xiaomi")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 99462250:
                    if (lowerCase.equals(MTPushConstants.Manufacturer.HONOR)) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                case 2:
                    setHuaweiBadgeNumber(context, i12);
                    return;
                case 1:
                    setXiaomiBadgeNumber(context, notification, i11);
                    return;
                default:
                    return;
            }
        }
    }

    public static void setXiaomiBadgeNumber(Context context, Notification notification, int i11) {
        if (notification != null) {
            if (i11 <= 0) {
                i11 = 0;
            }
            try {
                Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i11)});
            } catch (Throwable th2) {
                MTCommonLog.w(TAG, "setXiaomiBadgeNumber failed " + th2.getMessage());
            }
        }
    }

    public static Icon getSmallIcon(Context context, NotificationMessage notificationMessage) {
        Bitmap pictureBitmap;
        try {
            if (Build.VERSION.SDK_INT >= 23 && !TextUtils.isEmpty(notificationMessage.getSmallIcon()) && (pictureBitmap = getPictureBitmap(context, notificationMessage.getSmallIcon())) != null) {
                return Icon.createWithBitmap(pictureBitmap);
            }
            return null;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getSmallIcon failed " + th2.getMessage());
            return null;
        }
    }
}
