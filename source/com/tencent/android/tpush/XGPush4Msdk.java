package com.tencent.android.tpush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Set;

public class XGPush4Msdk {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static long f67819a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static long f67820b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f67821c = "";

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "addLocalNotification:msg=" + xGLocalMessage.toString() + ",qqAppid=" + f67819a + ",xg_accessid=" + getQQAccessId(context));
        }
        return XGPushManager.a(context, xGLocalMessage, getQQAccessId(context));
    }

    public static void addTags(final Context context, final String str, final Set<String> set) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                Set set;
                if (XGPushConfig.enableDebug) {
                    TLogger.d("XGPush4Msdk", "addTags: operateName=" + str + ",qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                if (context == null || (set = set) == null || set.isEmpty()) {
                    TLogger.ee("XGPush4Msdk", "the parameter context or tags of addTags is invalid.");
                    return;
                }
                String a11 = XGPushManager.a((Set<String>) set, "addTags");
                if (a11 == null) {
                    TLogger.ee("XGPush4Msdk", "addTags -> getTagsFromSet return null!!!");
                    return;
                }
                if (XGPushConfig.enableDebug) {
                    TLogger.ii("XGPush4Msdk", "addTags -> setTags with all tags = " + a11);
                }
                Context context = context;
                XGPushManager.a(context, a11, 5, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), str);
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean b(long j11, long j12, long j13) {
        return j11 >= j12 && j11 < j13;
    }

    public static void cleanTags(final Context context, final String str) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("XGPush4Msdk", "cleanTags: operateName=" + str + ",qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                if (context == null) {
                    TLogger.ee("XGPush4Msdk", "the parameter context of cleanTags is invalid");
                    return;
                }
                if (XGPushConfig.enableDebug) {
                    TLogger.ii("XGPush4Msdk", "Action -> cleanTags");
                }
                Context context = context;
                XGPushManager.a(context, "*", 8, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), str);
            }
        });
    }

    public static void deleteTag(final Context context, final String str) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("XGPush4Msdk", "deleteTag: tagName=" + str + ",qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                Context context = context;
                XGPushManager.a(context, str, 2, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), str);
            }
        });
    }

    public static void deleteTags(final Context context, final String str, final Set<String> set) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                Set set;
                if (XGPushConfig.enableDebug) {
                    TLogger.d("XGPush4Msdk", "deleteTags: operateName=" + str + ",qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                if (context == null || (set = set) == null || set.isEmpty()) {
                    TLogger.ee("XGPush4Msdk", "the parameter context or tags of deleteTags is invalid.");
                    return;
                }
                String a11 = XGPushManager.a((Set<String>) set, "deleteTags");
                if (a11 == null) {
                    TLogger.ee("XGPush4Msdk", "deleteTags -> getTagsFromSet return null!!!");
                    return;
                }
                if (XGPushConfig.enableDebug) {
                    TLogger.ii("XGPush4Msdk", "deleteTags -> setTags with all tags = " + a11);
                }
                Context context = context;
                XGPushManager.a(context, a11, 7, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), str);
            }
        });
    }

    public static String getDebugServerInfo(Context context) {
        return PushPreferences.getString(context, b(context), (String) null);
    }

    public static long getQQAccessId(Context context) {
        long j11 = f67820b;
        if (j11 <= 0) {
            f67820b = PushPreferences.getLong(context, "TPUSH_QQ_ACCESS_ID", j11);
        }
        return f67820b;
    }

    public static String getQQAppKey(Context context) {
        if (!TextUtils.isEmpty(f67821c)) {
            return f67821c;
        }
        String string = PushPreferences.getString(context, "__en__TPUSH_QQ_ACCESS_KEY", f67821c);
        if (!TextUtils.isEmpty(string)) {
            f67821c = Rijndael.decrypt(string);
        } else {
            f67821c = PushPreferences.getString(context, "TPUSH_QQ_ACCESS_KEY", "");
            PushPreferences.putString(context, "TPUSH_QQ_ACCESS_KEY", "");
        }
        return f67821c;
    }

    public static boolean isDebugServerInfoStrategyItem(Context context) {
        try {
            String debugServerInfo = getDebugServerInfo(b.e());
            if (!j.b(debugServerInfo)) {
                String[] split = debugServerInfo.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length != 2 || split[0].length() <= 4) {
                    return false;
                }
                return true;
            }
        } catch (Throwable th2) {
            TLogger.e("XGPush4Msdk", " .isDebugServerInfoStrategyItem", th2);
        }
        return false;
    }

    public static void registerPush(final Context context, final XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.e("XGPush4Msdk", "xg register push onFail. token:" + obj + ", errCode:" + i11 + ",msg:" + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.i("XGPush4Msdk", "xg register push onSuccess. token:" + obj);
                }
            };
        }
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (XGPushConfig.enableDebug) {
                    TLogger.i("XGPush4Msdk", "registerPush=,qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                Context context = context;
                XGPushManager.a(context, (String) null, -1, (String) null, xGIOperateCallback, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), (String) null, (String) null, (String) null, -1);
            }
        });
    }

    public static void setDebugServerInfo(final Context context, String str, int i11) {
        if (!j.b(str)) {
            String b11 = b(context);
            PushPreferences.putString(context, b11, str + Constants.ACCEPT_TIME_SEPARATOR_SP + i11);
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                Context context = context;
                if (!j.b(PushPreferences.getString(context, XGPush4Msdk.b(context), (String) null))) {
                    Context context2 = context;
                    PushPreferences.remove(context2, XGPush4Msdk.b(context2));
                }
            }
        });
    }

    public static void setDefaultNotificationBuilder(final Context context, final XGPushNotificationBuilder xGPushNotificationBuilder) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                XGPushManager.setDefaultNotificationBuilder(context, xGPushNotificationBuilder);
            }
        });
    }

    public static void setPushNotificationBuilder(final Context context, final int i11, final XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        } else if (i11 < 5000 || i11 > 6000) {
            throw new IllegalArgumentException("notificationBulderId超过范围[5000, 6000].");
        } else if (xGPushNotificationBuilder != null) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    com.tencent.android.tpush.message.b.a(context, i11, xGPushNotificationBuilder);
                }
            });
        }
    }

    public static void setQQAppId(final Context context, final long j11) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                long j11 = 0;
                if (XGPush4Msdk.b(j11, 0, 200000)) {
                    j11 = 90000000;
                } else if (!XGPush4Msdk.b(j11, 99000000, 100000000)) {
                    if (XGPush4Msdk.b(j11, 100200000, 100600000)) {
                        j11 = -10000000;
                    } else if (XGPush4Msdk.b(j11, 101000000, 101400000)) {
                        j11 = -10400000;
                    } else if (XGPush4Msdk.b(j11, 900000000, 900100000)) {
                        j11 = -809000000;
                    } else if (XGPush4Msdk.b(j11, 1000000000, 1000100000)) {
                        j11 = -908900000;
                    } else if (XGPush4Msdk.b(j11, 1101000000, 1104500000)) {
                        j11 = -1009800000;
                    } else if (XGPush4Msdk.b(j11, 1150000000, 1150100000)) {
                        j11 = -1055300000;
                    } else if (XGPush4Msdk.b(j11, 100600000, 101000000)) {
                        j11 = -5800000;
                    } else if (XGPush4Msdk.b(j11, 1104500000, 1109300000)) {
                        j11 = -1009300000;
                    } else if (XGPush4Msdk.b(j11, 1109300000, 1119300000)) {
                        j11 = -1029300000;
                    } else if (XGPush4Msdk.b(j11, 1119300000, 1120000000)) {
                        j11 = -1049300000;
                    } else {
                        TLogger.e("XGPush4Msdk", "手Q的appid：" + j11 + " 不在固定的范围，请联系msdk和信鸽的同事解决之。");
                    }
                }
                long j12 = j11;
                long unused = XGPush4Msdk.f67819a = j12;
                long unused2 = XGPush4Msdk.f67820b = j11 + 2100000000 + j12;
                PushPreferences.putLong(context, "TPUSH_QQ_ACCESS_ID", XGPush4Msdk.f67820b);
                PushPreferences.remove(context, "TPUSH_QQ_APP_ID");
                String unused3 = XGPush4Msdk.f67821c = "MSDK_" + j11;
                PushPreferences.putString(context, "__en__TPUSH_QQ_ACCESS_KEY", Rijndael.encrypt(XGPush4Msdk.f67821c));
                PushPreferences.remove(context, "TPUSH_QQ_ACCESS_KEY");
            }
        });
    }

    public static void setQQAppKey(Context context, String str) {
    }

    public static void setTag(final Context context, final String str) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                TLogger.d("XGPush4Msdk", "setTag: tagName=" + str + ",qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                Context context = context;
                XGPushManager.a(context, str, 1, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), str);
            }
        });
    }

    public static void setTags(final Context context, final String str, final Set<String> set) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                Set set;
                if (XGPushConfig.enableDebug) {
                    TLogger.d("XGPush4Msdk", "setTags: operateName=" + str + ",qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                if (context == null || (set = set) == null || set.isEmpty()) {
                    TLogger.ee("XGPush4Msdk", "the parameter context or tags of setTags is invalid.");
                    return;
                }
                String a11 = XGPushManager.a((Set<String>) set, "setTags");
                if (a11 == null) {
                    TLogger.ee("XGPush4Msdk", "setTags -> getTagsFromSet return null!!!");
                    return;
                }
                TLogger.ii("XGPush4Msdk", "Action -> setTags with all tags = " + a11);
                Context context = context;
                XGPushManager.a(context, a11, 6, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), str);
            }
        });
    }

    public static void unregisterPush(final Context context, final XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() {
                public void onFail(Object obj, int i11, String str) {
                    TLogger.e("XGPush4Msdk", "xg unregisterPush push onFail. token:" + obj + ", errCode:" + i11 + ",msg:" + str);
                }

                public void onSuccess(Object obj, int i11) {
                    TLogger.i("XGPush4Msdk", "xg unregisterPush push onSuccess. flag:" + i11);
                }
            };
        }
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (XGPushConfig.enableDebug) {
                    TLogger.i("XGPush4Msdk", "unregisterPush,qqAppid=" + XGPush4Msdk.f67819a + ",xg_accessid=" + XGPush4Msdk.getQQAccessId(context));
                }
                Context context = context;
                XGPushManager.a(context, xGIOperateCallback, XGPush4Msdk.getQQAccessId(context), XGPush4Msdk.getQQAppKey(context), (String) null, (String) null, (String) null);
            }
        });
    }

    /* access modifiers changed from: private */
    public static String b(Context context) {
        return context.getPackageName() + ":" + "XG_DEBUG_SERVER_INFO";
    }
}
