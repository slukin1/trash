package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.e;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.CachedMessageIntent;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.e.a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTSCHEMECHECK, EType.INTENTCHECK, EType.RECEIVERCHECK})
public class MessageManager {
    public static final int MSG_CTRL_CMD_TYPE = 3;
    public static final int MSG_CTRL_CMD_TYPE_ACTION_CLEAR_PKG = 2;
    public static final int MSG_CTRL_CMD_TYPE_ACTION_CLEAR_PUSHID = 1;
    public static final int MSG_CTRL_CMD_TYPE_ACTION_LOG_ENABLED = 3;
    public static final String SHARED_PREFERENCES_CACHE_MSG_KEY = ".tpns.msg.id.cached";
    public static final String SHARED_PREFERENCES_KEY = ".tpns.msg.id";

    /* renamed from: a  reason: collision with root package name */
    private static MessageManager f69395a = new MessageManager();

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f69396b = new byte[0];

    private MessageManager() {
    }

    private void a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(e.a((Serializable) arrayList));
            PushPreferences.putString(context, str + str2, encrypt);
        } catch (Throwable th2) {
            TLogger.e("MessageManager", "putSettings", th2);
        }
    }

    public static MessageManager getInstance() {
        return f69395a;
    }

    public static String getNotifiedMsgIds(Context context, long j11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(PushMd5Pref.getString(context, "tpush_msgId_" + j11, true));
        String sb3 = sb2.toString();
        if (sb3 != null && sb3.length() > 20480) {
            sb3 = sb3.substring(0, sb3.indexOf("@@", 5120));
        }
        if (sb3 != null) {
            return sb3;
        }
        return "";
    }

    public static boolean setNotifiedMsgIds(Context context, long j11, String str, String str2) {
        PushMd5Pref.putString(context, "tpush_msgId_" + j11, str + str2, true);
        String string = PushMd5Pref.getString(context, "tpush_msgId_" + j11, true);
        if (string != null && string.contains(str)) {
            return true;
        }
        TLogger.e("MessageManager", str + " flag write failed");
        return false;
    }

    public void addCachedMsgIntentByPkgName(Context context, String str, Intent intent) {
        int size;
        synchronized (f69396b) {
            if (context != null) {
                if (!j.b(str) && intent != null) {
                    CachedMessageIntent cachedMessageIntent = new CachedMessageIntent();
                    cachedMessageIntent.pkgName = str;
                    cachedMessageIntent.msgId = intent.getLongExtra("msgId", -1);
                    cachedMessageIntent.intent = Rijndael.encrypt(intent.toUri(1));
                    ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
                    if (cachedMsgIntentListByPkgName == null) {
                        cachedMsgIntentListByPkgName = new ArrayList<>();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i11 = 0; i11 < cachedMsgIntentListByPkgName.size(); i11++) {
                            CachedMessageIntent cachedMessageIntent2 = cachedMsgIntentListByPkgName.get(i11);
                            if (cachedMessageIntent2.equals(cachedMessageIntent)) {
                                arrayList.add(cachedMessageIntent2);
                            }
                        }
                        cachedMsgIntentListByPkgName.removeAll(arrayList);
                    }
                    if (cachedMsgIntentListByPkgName.size() > 45 && (size = cachedMsgIntentListByPkgName.size() - 45) >= 0) {
                        TLogger.w("MessageManager", "too much cache msg, try to cut " + size + " list.size: " + cachedMsgIntentListByPkgName.size());
                        cachedMsgIntentListByPkgName.subList(0, size).clear();
                    }
                    cachedMsgIntentListByPkgName.add(cachedMessageIntent);
                    updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
                }
            }
        }
    }

    public void addDonotCachedMsgId(Context context, String str, ArrayList<Intent> arrayList) {
        synchronized (f69396b) {
            if (!(context == null || arrayList == null)) {
                a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY, arrayList);
            }
        }
    }

    public void addDonotSendCachedMsgIntentList(Context context, Intent intent) {
        if (context != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(intent);
            addDonotCachedMsgId(context, context.getPackageName(), arrayList);
        }
    }

    public void addMsgId(Context context, String str, MessageId messageId) {
        synchronized (f69396b) {
            if (context != null) {
                if (!j.b(str) && messageId != null) {
                    ArrayList<MessageId> messageIdListByPkgName = getMessageIdListByPkgName(context, str);
                    if (messageIdListByPkgName == null) {
                        messageIdListByPkgName = new ArrayList<>();
                    } else {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= messageIdListByPkgName.size()) {
                                break;
                            } else if (messageIdListByPkgName.get(i11).f69316id == messageId.f69316id) {
                                messageIdListByPkgName.remove(i11);
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    messageIdListByPkgName.add(messageId);
                    updateMsgId(context, str, messageIdListByPkgName);
                }
            }
        }
    }

    public void addNewCachedMsgIntent(Context context, Intent intent) {
        if (context != null) {
            a.a(context, intent);
        }
    }

    public void clearAllLocalMsg(Context context) {
        if (context != null) {
            a.b(context);
        }
    }

    public void clearLocalCachedMsgIntentList(Context context) {
        List<String> registerInfos;
        if (context != null && (registerInfos = CacheManager.getRegisterInfos(context)) != null && registerInfos.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String next : registerInfos) {
                arrayList.clear();
                ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, next);
                if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                    for (int i11 = 0; i11 < cachedMsgIntentListByPkgName.size(); i11++) {
                        CachedMessageIntent cachedMessageIntent = cachedMsgIntentListByPkgName.get(i11);
                        try {
                            String decrypt = Rijndael.decrypt(cachedMessageIntent.intent);
                            if (!j.b(decrypt)) {
                                if (Intent.parseUri(decrypt, 1).getLongExtra("msgId", 0) != 0) {
                                    arrayList.add(cachedMessageIntent);
                                }
                            }
                        } catch (Throwable th2) {
                            TLogger.e("MessageManager", "clearLocalCachedMsgIntentList", th2);
                        }
                    }
                    cachedMsgIntentListByPkgName.removeAll(arrayList);
                    updateCachedMsgIntentByPkgName(context, next, cachedMsgIntentListByPkgName);
                }
            }
        }
    }

    public void deleteAllCachedMsgIntent(Context context) {
        if (context != null) {
            a.a(context);
        }
    }

    public void deleteAllCachedMsgIntentByPkgName(Context context, String str) {
        synchronized (f69396b) {
            if (context != null) {
                updateCachedMsgIntentByPkgName(context, str, new ArrayList());
            }
        }
    }

    public void deleteCachedMsgIntent(Context context, long j11) {
        if (context != null) {
            a.e(context, j11);
        }
    }

    public void deleteCachedMsgIntentByBusiId(Context context, long j11) {
        if (context != null) {
            a.f(context, j11);
        }
    }

    public void deleteCachedMsgIntentByPkgName(Context context, String str, long j11) {
        synchronized (f69396b) {
            if (context != null) {
                ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
                if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < cachedMsgIntentListByPkgName.size(); i11++) {
                        CachedMessageIntent cachedMessageIntent = cachedMsgIntentListByPkgName.get(i11);
                        if (cachedMessageIntent.msgId == j11) {
                            arrayList.add(cachedMessageIntent);
                        }
                    }
                    if (arrayList.size() == 0) {
                        TLogger.e("MessageManager", "deleteCachedMsgIntentByPkgName do not have MessageId = " + j11);
                    }
                    cachedMsgIntentListByPkgName.removeAll(arrayList);
                }
                updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
            }
        }
    }

    public void deleteCachedMsgIntentByPkgNameBusiId(Context context, String str, long j11) {
        synchronized (f69396b) {
            if (context != null) {
                ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName = getCachedMsgIntentListByPkgName(context, str);
                if (cachedMsgIntentListByPkgName != null && cachedMsgIntentListByPkgName.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < cachedMsgIntentListByPkgName.size(); i11++) {
                        CachedMessageIntent cachedMessageIntent = cachedMsgIntentListByPkgName.get(i11);
                        if (j11 == Intent.parseUri(Rijndael.decrypt(cachedMessageIntent.intent), 1).getLongExtra(MessageKey.MSG_BUSI_MSG_ID, -1)) {
                            arrayList.add(cachedMessageIntent);
                        }
                    }
                    cachedMsgIntentListByPkgName.removeAll(arrayList);
                }
                updateCachedMsgIntentByPkgName(context, str, cachedMsgIntentListByPkgName);
            }
        }
    }

    public ArrayList<CachedMessageIntent> getCachedMsgIntentList(Context context) {
        List<String> registerInfos;
        if (context == null || (registerInfos = CacheManager.getRegisterInfos(context)) == null || registerInfos.size() <= 0) {
            return null;
        }
        ArrayList<CachedMessageIntent> arrayList = new ArrayList<>();
        for (String cachedMsgIntentListByPkgName : registerInfos) {
            ArrayList<CachedMessageIntent> cachedMsgIntentListByPkgName2 = getCachedMsgIntentListByPkgName(context, cachedMsgIntentListByPkgName);
            if (cachedMsgIntentListByPkgName2 != null && cachedMsgIntentListByPkgName2.size() > 0) {
                arrayList.addAll(cachedMsgIntentListByPkgName2);
            }
        }
        return arrayList;
    }

    public ArrayList<CachedMessageIntent> getCachedMsgIntentListByPkgName(Context context, String str) {
        Object a11;
        ArrayList<CachedMessageIntent> arrayList = null;
        if (context != null) {
            try {
                if (!j.b(str) && (a11 = a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY)) != null) {
                    arrayList = (ArrayList) a11;
                }
            } catch (Throwable unused) {
                return new ArrayList<>();
            }
        }
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public ArrayList<Intent> getDonotCachedMsgId(Context context, String str) {
        Object a11;
        synchronized (f69396b) {
            ArrayList<Intent> arrayList = null;
            if (context != null) {
                try {
                    if (!j.b(str) && (a11 = a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY)) != null) {
                        arrayList = (ArrayList) a11;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (arrayList != null) {
                return arrayList;
            }
            ArrayList<Intent> arrayList2 = new ArrayList<>();
            return arrayList2;
        }
    }

    public ArrayList<Intent> getDonotSendCachedMsgIntentList(Context context) {
        if (context != null) {
            return getDonotCachedMsgId(context, context.getPackageName());
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = a(r2, r3, SHARED_PREFERENCES_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.tencent.android.tpush.data.MessageId> getMessageIdListByPkgName(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0013
            boolean r0 = com.tencent.android.tpush.common.j.b((java.lang.String) r3)
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = ".tpns.msg.id"
            java.lang.Object r2 = r1.a(r2, r3, r0)
            if (r2 == 0) goto L_0x0013
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r2 != 0) goto L_0x001b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x001b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.MessageManager.getMessageIdListByPkgName(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    public MessageId getMsgId(Context context, String str, long j11) {
        ArrayList<MessageId> messageIdListByPkgName;
        if (context == null || j.b(str) || j11 <= 0 || (messageIdListByPkgName = getMessageIdListByPkgName(context, str)) == null || messageIdListByPkgName.size() <= 0) {
            return null;
        }
        for (MessageId next : messageIdListByPkgName) {
            if (next.f69316id == j11) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<Intent> getNewCachedMsgIntentList(Context context) {
        if (context != null) {
            return a.c(context);
        }
        return null;
    }

    public boolean isMsgAcked(Context context, String str, long j11) {
        ArrayList<MessageId> messageIdListByPkgName;
        if (context == null || j.b(str) || j11 <= 0 || (messageIdListByPkgName = getMessageIdListByPkgName(context, str)) == null || messageIdListByPkgName.size() <= 0) {
            return false;
        }
        for (MessageId next : messageIdListByPkgName) {
            if (next.f69316id == j11) {
                return next.isMsgAcked();
            }
        }
        return false;
    }

    public boolean isMsgCached(Context context, long j11) {
        if (context == null) {
            return false;
        }
        a.g(context, j11);
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [int] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCrtlMsgHandle(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "MessageManager"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0061 }
            r1.<init>(r8)     // Catch:{ all -> 0x0061 }
            java.lang.String r8 = "action"
            r2 = 2
            int r8 = r1.optInt(r8, r2)     // Catch:{ all -> 0x0061 }
            r3 = 0
            r4 = 1
            if (r8 == r4) goto L_0x0040
            if (r8 == r2) goto L_0x003c
            r2 = 3
            if (r8 == r2) goto L_0x0018
            goto L_0x0067
        L_0x0018:
            java.lang.String r8 = "enabled"
            r2 = -1
            int r8 = r1.optInt(r8, r2)     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r1.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "setLogToFile with cmd = "
            r1.append(r5)     // Catch:{ all -> 0x0061 }
            r1.append(r8)     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0061 }
            com.tencent.android.tpush.logging.TLogger.ii(r0, r1)     // Catch:{ all -> 0x0061 }
            if (r8 == r2) goto L_0x0067
            if (r8 <= 0) goto L_0x0038
            r3 = r4
        L_0x0038:
            com.tencent.android.tpush.logging.TLogger.enableDebug(r7, r3)     // Catch:{ all -> 0x0061 }
            goto L_0x0067
        L_0x003c:
            r6.deleteAllCachedMsgIntent(r7)     // Catch:{ all -> 0x0061 }
            goto L_0x0067
        L_0x0040:
            java.lang.String r8 = "pushIdList"
            java.lang.String r2 = ""
            java.lang.String r8 = r1.optString(r8, r2)     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = ","
            java.lang.String[] r8 = r8.split(r1)     // Catch:{ all -> 0x0061 }
            int r1 = r8.length     // Catch:{ all -> 0x0061 }
        L_0x004f:
            if (r3 >= r1) goto L_0x0067
            r2 = r8[r3]     // Catch:{ all -> 0x0061 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0061 }
            long r4 = r2.longValue()     // Catch:{ all -> 0x0061 }
            r6.deleteCachedMsgIntentByBusiId(r7, r4)     // Catch:{ all -> 0x0061 }
            int r3 = r3 + 1
            goto L_0x004f
        L_0x0061:
            r7 = move-exception
            java.lang.String r8 = "onCrtlMsgHandle"
            com.tencent.android.tpush.logging.TLogger.e(r0, r8, r7)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.MessageManager.onCrtlMsgHandle(android.content.Context, java.lang.String):void");
    }

    public void updateCachedMsgIntentByPkgName(Context context, String str, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (f69396b) {
            if (!(context == null || arrayList == null)) {
                TLogger.v("MessageManager", "updateCachedMsgIntentByPkgName, size: " + arrayList.size());
                a(context, str, SHARED_PREFERENCES_CACHE_MSG_KEY, arrayList);
            }
        }
    }

    public void updateCachedMsgIntentToCancel(Context context, long j11) {
        if (context != null) {
            a.d(context, j11);
        }
    }

    public void updateCachedMsgIntentToClick(Context context, long j11) {
        if (context != null) {
            a.c(context, j11);
        }
    }

    public void updateCachedMsgIntentToShowed(Context context, long j11) {
        if (context != null) {
            a.a(context, j11);
        }
    }

    public void updateCachedMsgIntentToVerifyErr(Context context, long j11) {
        if (context != null) {
            a.b(context, j11);
        }
    }

    public void updateMsgId(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (f69396b) {
            if (!(context == null || arrayList == null)) {
                a(context, str, SHARED_PREFERENCES_KEY, arrayList);
            }
        }
    }

    public void deleteCachedMsgIntent(Context context, List<CachedMessageIntent> list, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (f69396b) {
            if (!(context == null || list == null)) {
                if (list.size() > 0) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        if (arrayList != null && arrayList.size() > 0) {
                            HashMap hashMap = new HashMap();
                            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                CachedMessageIntent cachedMessageIntent = arrayList.get(i11);
                                for (CachedMessageIntent next : list) {
                                    if (cachedMessageIntent.equals(next)) {
                                        arrayList2.add(cachedMessageIntent);
                                        ArrayList arrayList3 = (ArrayList) hashMap.get(next.pkgName);
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        hashMap.put(next.pkgName, arrayList3);
                                    }
                                }
                            }
                            arrayList.removeAll(arrayList2);
                            Iterator<CachedMessageIntent> it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                CachedMessageIntent next2 = it2.next();
                                ArrayList arrayList4 = (ArrayList) hashMap.get(next2.pkgName);
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList();
                                }
                                arrayList4.add(next2);
                                hashMap.put(next2.pkgName, arrayList4);
                            }
                            for (Map.Entry entry : hashMap.entrySet()) {
                                updateCachedMsgIntentByPkgName(context, (String) entry.getKey(), (ArrayList) entry.getValue());
                            }
                        }
                    } catch (Throwable th2) {
                        TLogger.e("MessageManager", "deleteCachedMsgIntent", th2);
                    }
                }
            }
        }
    }

    private Object a(Context context, String str, String str2) {
        try {
            return e.a(Rijndael.decrypt(PushPreferences.getString(context, str + str2, (String) null)));
        } catch (Throwable th2) {
            TLogger.e("MessageManager", "getSettings", th2);
            return null;
        }
    }
}
