package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;
import com.xiaomi.push.gt;
import com.xiaomi.push.j;
import com.xiaomi.push.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f52434a = Log.isLoggable("NCHelper", 3);

    @TargetApi(26)
    private static void a(af afVar, NotificationChannel notificationChannel, String str) {
        char c11;
        int i11;
        int i12;
        Context a11 = afVar.a();
        String id2 = notificationChannel.getId();
        String a12 = af.a(id2, afVar.a());
        boolean z11 = f52434a;
        if (z11) {
            a("appChannelId:" + id2 + " oldChannelId:" + a12);
        }
        if (!j.a(a11) || TextUtils.equals(id2, a12)) {
            NotificationChannel a13 = afVar.a(id2);
            if (z11) {
                a("elseLogic getNotificationChannel:" + a13);
            }
            if (a13 == null) {
                afVar.a(notificationChannel);
            }
            i11 = 0;
            c11 = 0;
        } else {
            NotificationManager notificationManager = (NotificationManager) a11.getSystemService(RemoteMessageConst.NOTIFICATION);
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a12);
            NotificationChannel a14 = afVar.a(id2);
            if (z11) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + a14);
            }
            if (notificationChannel2 != null) {
                NotificationChannel a15 = a(id2, notificationChannel2);
                if (z11) {
                    a("copyXmsf copyXmsfChannel:" + a15);
                }
                if (a14 != null) {
                    i12 = a(a14);
                    afVar.a(a15, i12 == 0);
                    c11 = 3;
                } else {
                    i12 = a(notificationChannel2);
                    a(a11, afVar, a15, i12, notificationChannel2.getId());
                    c11 = 4;
                }
                b(a11, id2);
                notificationManager.deleteNotificationChannel(a12);
            } else if (a14 == null) {
                if (z11) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                afVar.a(notificationChannel);
                c11 = 1;
                i12 = 0;
            } else if (a(a11, id2) || !a(notificationChannel, a14)) {
                i12 = 0;
                c11 = 0;
            } else {
                if (z11) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                i12 = a(a14);
                afVar.a(notificationChannel, i12 == 0);
                c11 = 2;
            }
            i11 = i12;
        }
        f.a(afVar.a(), afVar.a(), id2, notificationChannel.getImportance(), str, c11 == 1 || c11 == 4 || c11 == 3, i11);
    }

    private static void b(Context context, String str) {
        if (f52434a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            af a11 = af.a(context, str);
            Set<String> keySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String next : keySet) {
                if (a11.a(next)) {
                    arrayList.add(next);
                    if (f52434a) {
                        a("delete channel copy record:" + next);
                    }
                }
            }
            a(context, (List<String>) arrayList);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z11;
        boolean z12 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        boolean z13 = true;
        if (!TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            if (f52434a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z11 = true;
        } else {
            z11 = false;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f52434a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z11 = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f52434a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z11 = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f52434a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z11 = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f52434a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z11 = true;
        }
        boolean z14 = notificationChannel.getSound() != null;
        if (notificationChannel2.getSound() != null) {
            z12 = true;
        }
        if (z14 != z12) {
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
            if (f52434a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
        } else {
            z13 = z11;
        }
        if (f52434a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z13);
        }
        return z13;
    }

    private static int a(NotificationChannel notificationChannel) {
        int i11 = 0;
        try {
            i11 = ((Integer) ax.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (f52434a) {
                a("isUserLockedChannel:" + i11 + " " + notificationChannel);
            }
        } catch (Exception e11) {
            b.a("NCHelper", "is user locked error" + e11);
        }
        return i11;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2967a(Context context, String str) {
        if (f52434a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void a(Context context, List<String> list) {
        if (f52434a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (!list.isEmpty()) {
            SharedPreferences.Editor edit = a(context).edit();
            for (String remove : list) {
                edit.remove(remove);
            }
            edit.apply();
        }
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(af afVar, String str, CharSequence charSequence, String str2, int i11, int i12, String str3, String str4) {
        String a11 = afVar.a(str);
        boolean z11 = f52434a;
        if (z11) {
            a("createChannel: appChannelId:" + a11 + " serverChannelId:" + str + " serverChannelName:" + charSequence + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i11 + " serverChannelName:" + charSequence + " serverChannelImportance:" + i12 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(a11, charSequence, i12);
        notificationChannel.setDescription(str2);
        boolean z12 = false;
        notificationChannel.enableVibration((i11 & 2) != 0);
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        notificationChannel.enableLights(z12);
        if ((i11 & 1) == 0) {
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
        } else if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + afVar.a())) {
                notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z11) {
            a("create channel:" + notificationChannel);
        }
        a(afVar, notificationChannel, str4);
        return a11;
    }

    private static void a(String str) {
        b.a("NCHelper", str);
    }

    public static void a(Context context, String str) {
        if (j.a(context) && !TextUtils.isEmpty(str)) {
            c(context, str);
            f.a(context, str);
        }
    }

    public static void a(gt gtVar) {
        Map<String, String> map;
        if (gtVar != null && (map = gtVar.f2977a) != null && map.containsKey("REMOVE_CHANNEL_MARK")) {
            gtVar.f2973a = 0;
            gtVar.f2977a.remove(MessageKey.MSG_CHANNEL_ID);
            gtVar.f2977a.remove("channel_importance");
            gtVar.f2977a.remove("channel_name");
            gtVar.f2977a.remove("channel_description");
            gtVar.f2977a.remove("channel_perm");
            b.a("delete channel info by:" + gtVar.f2977a.get("REMOVE_CHANNEL_MARK"));
            gtVar.f2977a.remove("REMOVE_CHANNEL_MARK");
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    public static void a(Context context, af afVar, NotificationChannel notificationChannel, int i11, String str) {
        if (i11 > 0) {
            int a11 = r.a(context) ? f.a(context.getPackageName(), str) : 0;
            NotificationChannel a12 = a(notificationChannel.getId(), notificationChannel);
            if ((i11 & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    a12.setSound((Uri) null, (AudioAttributes) null);
                } else {
                    a12.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i11 & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    a12.enableVibration(false);
                } else {
                    a12.enableVibration(true);
                }
            }
            if ((i11 & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    a12.enableLights(false);
                } else {
                    a12.enableLights(true);
                }
            }
            if ((i11 & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                a12.setImportance(importance);
            }
            if ((i11 & 2) != 0) {
                a12.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            afVar.a(a12);
            afVar.a(notificationChannel, true);
            f.a(afVar.a(), notificationChannel.getId(), a11, 0);
            return;
        }
        afVar.a(notificationChannel);
    }
}
