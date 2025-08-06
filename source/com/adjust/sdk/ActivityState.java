package com.adjust.sdk;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

public class ActivityState implements Serializable, Cloneable {
    private static final int EVENT_DEDUPLICATION_IDS_MAX_SIZE = 10;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 9039439291143138148L;
    public String adid = null;
    public boolean askingAttribution = false;
    public long clickTime = 0;
    public long clickTimeHuawei = 0;
    public long clickTimeMeta = 0;
    public long clickTimeSamsung = 0;
    public long clickTimeServer = 0;
    public long clickTimeServerXiaomi = 0;
    public long clickTimeVivo = 0;
    public long clickTimeXiaomi = 0;
    public boolean enabled = true;
    public int eventCount = 0;
    public int eventDeduplicationIdsMaxSize = 10;
    public Boolean googlePlayInstant = null;
    public long installBegin = 0;
    public long installBeginHuawei = 0;
    public long installBeginSamsung = 0;
    public long installBeginServer = 0;
    public long installBeginServerXiaomi = 0;
    public long installBeginVivo = 0;
    public long installBeginXiaomi = 0;
    public String installReferrer = null;
    public String installReferrerHuawei = null;
    public String installReferrerHuaweiAppGallery = null;
    public String installReferrerMeta = null;
    public String installReferrerSamsung = null;
    public String installReferrerVivo = null;
    public String installReferrerXiaomi = null;
    public String installVersion = null;
    public String installVersionVivo = null;
    public String installVersionXiaomi = null;
    public Boolean isClickMeta = null;
    public boolean isGdprForgotten = false;
    public boolean isThirdPartySharingDisabledForCoppa = false;
    public long lastActivity = -1;
    public long lastInterval = -1;
    private transient ILogger logger = AdjustFactory.getLogger();
    public LinkedList<String> orderIds = null;
    public String pushToken = null;
    public int sessionCount = 0;
    public long sessionLength = -1;
    public int subsessionCount = -1;
    public long timeSpent = -1;
    public String uuid = Util.createUuid();

    static {
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        Class cls3 = Boolean.TYPE;
        Class cls4 = Integer.TYPE;
        Class cls5 = Long.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField(ZendeskIdentityStorage.UUID_KEY, cls2), new ObjectStreamField(Constants.ENABLED, cls3), new ObjectStreamField("isGdprForgotten", cls3), new ObjectStreamField("askingAttribution", cls3), new ObjectStreamField("eventCount", cls4), new ObjectStreamField("sessionCount", cls4), new ObjectStreamField("subsessionCount", cls4), new ObjectStreamField("sessionLength", cls5), new ObjectStreamField("timeSpent", cls5), new ObjectStreamField("lastActivity", cls5), new ObjectStreamField("lastInterval", cls5), new ObjectStreamField("orderIds", LinkedList.class), new ObjectStreamField("pushToken", cls2), new ObjectStreamField("adid", cls2), new ObjectStreamField(com.tencent.android.tpush.common.Constants.FLAG_CLICK_TIME, cls5), new ObjectStreamField("installBegin", cls5), new ObjectStreamField("installReferrer", cls2), new ObjectStreamField("googlePlayInstant", cls), new ObjectStreamField("clickTimeServer", cls5), new ObjectStreamField("installBeginServer", cls5), new ObjectStreamField("installVersion", cls2), new ObjectStreamField("clickTimeHuawei", cls5), new ObjectStreamField("installBeginHuawei", cls5), new ObjectStreamField("installReferrerHuawei", cls2), new ObjectStreamField("installReferrerHuaweiAppGallery", cls2), new ObjectStreamField("isThirdPartySharingDisabledForCoppa", cls3), new ObjectStreamField("clickTimeXiaomi", cls5), new ObjectStreamField("installBeginXiaomi", cls5), new ObjectStreamField("installReferrerXiaomi", cls2), new ObjectStreamField("clickTimeServerXiaomi", cls5), new ObjectStreamField("installBeginServerXiaomi", cls5), new ObjectStreamField("installVersionXiaomi", cls2), new ObjectStreamField("clickTimeSamsung", cls5), new ObjectStreamField("installBeginSamsung", cls5), new ObjectStreamField("installReferrerSamsung", cls2), new ObjectStreamField("clickTimeVivo", cls5), new ObjectStreamField("installBeginVivo", cls5), new ObjectStreamField("installReferrerVivo", cls2), new ObjectStreamField("installVersionVivo", cls2), new ObjectStreamField("installReferrerMeta", cls2), new ObjectStreamField("clickTimeMeta", cls5), new ObjectStreamField("isClickMeta", cls)};
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.eventCount = Util.readIntField(readFields, "eventCount", 0);
        this.sessionCount = Util.readIntField(readFields, "sessionCount", 0);
        this.subsessionCount = Util.readIntField(readFields, "subsessionCount", -1);
        this.sessionLength = Util.readLongField(readFields, "sessionLength", -1);
        this.timeSpent = Util.readLongField(readFields, "timeSpent", -1);
        this.lastActivity = Util.readLongField(readFields, "lastActivity", -1);
        this.lastInterval = Util.readLongField(readFields, "lastInterval", -1);
        this.uuid = Util.readStringField(readFields, ZendeskIdentityStorage.UUID_KEY, (String) null);
        this.enabled = Util.readBooleanField(readFields, Constants.ENABLED, true);
        this.isGdprForgotten = Util.readBooleanField(readFields, "isGdprForgotten", false);
        this.isThirdPartySharingDisabledForCoppa = Util.readBooleanField(readFields, "isThirdPartySharingDisabledForCoppa", false);
        this.askingAttribution = Util.readBooleanField(readFields, "askingAttribution", false);
        this.orderIds = (LinkedList) Util.readObjectField(readFields, "orderIds", null);
        this.pushToken = Util.readStringField(readFields, "pushToken", (String) null);
        this.adid = Util.readStringField(readFields, "adid", (String) null);
        this.clickTime = Util.readLongField(readFields, com.tencent.android.tpush.common.Constants.FLAG_CLICK_TIME, -1);
        this.installBegin = Util.readLongField(readFields, "installBegin", -1);
        this.installReferrer = Util.readStringField(readFields, "installReferrer", (String) null);
        this.googlePlayInstant = (Boolean) Util.readObjectField(readFields, "googlePlayInstant", null);
        this.clickTimeServer = Util.readLongField(readFields, "clickTimeServer", -1);
        this.installBeginServer = Util.readLongField(readFields, "installBeginServer", -1);
        this.installVersion = Util.readStringField(readFields, "installVersion", (String) null);
        this.clickTimeHuawei = Util.readLongField(readFields, "clickTimeHuawei", -1);
        this.installBeginHuawei = Util.readLongField(readFields, "installBeginHuawei", -1);
        this.installReferrerHuawei = Util.readStringField(readFields, "installReferrerHuawei", (String) null);
        this.installReferrerHuaweiAppGallery = Util.readStringField(readFields, "installReferrerHuaweiAppGallery", (String) null);
        this.clickTimeXiaomi = Util.readLongField(readFields, "clickTimeXiaomi", -1);
        this.installBeginXiaomi = Util.readLongField(readFields, "installBeginXiaomi", -1);
        this.installReferrerXiaomi = Util.readStringField(readFields, "installReferrerXiaomi", (String) null);
        this.clickTimeServerXiaomi = Util.readLongField(readFields, "clickTimeServerXiaomi", -1);
        this.installBeginServerXiaomi = Util.readLongField(readFields, "installBeginServerXiaomi", -1);
        this.installVersionXiaomi = Util.readStringField(readFields, "installVersionXiaomi", (String) null);
        this.clickTimeSamsung = Util.readLongField(readFields, "clickTimeSamsung", -1);
        this.installBeginSamsung = Util.readLongField(readFields, "installBeginSamsung", -1);
        this.installReferrerSamsung = Util.readStringField(readFields, "installReferrerSamsung", (String) null);
        this.clickTimeVivo = Util.readLongField(readFields, "clickTimeVivo", -1);
        this.installBeginVivo = Util.readLongField(readFields, "installBeginVivo", -1);
        this.installReferrerVivo = Util.readStringField(readFields, "installReferrerVivo", (String) null);
        this.installVersionVivo = Util.readStringField(readFields, "installVersionVivo", (String) null);
        this.installReferrerMeta = Util.readStringField(readFields, "installReferrerMeta", (String) null);
        this.clickTimeMeta = Util.readLongField(readFields, "clickTimeMeta", -1);
        this.isClickMeta = (Boolean) Util.readObjectField(readFields, "isClickMeta", null);
        if (this.uuid == null) {
            this.uuid = Util.createUuid();
        }
        this.eventDeduplicationIdsMaxSize = 10;
    }

    private static String stamp(long j11) {
        Calendar.getInstance().setTimeInMillis(j11);
        return Util.formatString("%02d:%02d:%02d", 11, 12, 13);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public void addDeduplicationId(String str) {
        if (this.eventDeduplicationIdsMaxSize != 0) {
            if (this.orderIds == null) {
                this.orderIds = new LinkedList<>();
            } else {
                while (this.orderIds.size() >= this.eventDeduplicationIdsMaxSize) {
                    this.orderIds.removeLast();
                }
            }
            this.orderIds.addFirst(str);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityState activityState = (ActivityState) obj;
        return Util.equalString(this.uuid, activityState.uuid) && Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(activityState.enabled)) && Util.equalBoolean(Boolean.valueOf(this.isGdprForgotten), Boolean.valueOf(activityState.isGdprForgotten)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Boolean.valueOf(activityState.isThirdPartySharingDisabledForCoppa)) && Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(activityState.askingAttribution)) && Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(activityState.eventCount)) && Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(activityState.sessionCount)) && Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(activityState.subsessionCount)) && Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(activityState.sessionLength)) && Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(activityState.timeSpent)) && Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(activityState.lastInterval)) && Util.equalObject(this.orderIds, activityState.orderIds) && Util.equalString(this.pushToken, activityState.pushToken) && Util.equalString(this.adid, activityState.adid) && Util.equalLong(Long.valueOf(this.clickTime), Long.valueOf(activityState.clickTime)) && Util.equalLong(Long.valueOf(this.installBegin), Long.valueOf(activityState.installBegin)) && Util.equalString(this.installReferrer, activityState.installReferrer) && Util.equalBoolean(this.googlePlayInstant, activityState.googlePlayInstant) && Util.equalLong(Long.valueOf(this.clickTimeServer), Long.valueOf(activityState.clickTimeServer)) && Util.equalLong(Long.valueOf(this.installBeginServer), Long.valueOf(activityState.installBeginServer)) && Util.equalString(this.installVersion, activityState.installVersion) && Util.equalLong(Long.valueOf(this.clickTimeHuawei), Long.valueOf(activityState.clickTimeHuawei)) && Util.equalLong(Long.valueOf(this.installBeginHuawei), Long.valueOf(activityState.installBeginHuawei)) && Util.equalString(this.installReferrerHuawei, activityState.installReferrerHuawei) && Util.equalString(this.installReferrerHuaweiAppGallery, activityState.installReferrerHuaweiAppGallery) && Util.equalLong(Long.valueOf(this.clickTimeXiaomi), Long.valueOf(activityState.clickTimeXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginXiaomi), Long.valueOf(activityState.installBeginXiaomi)) && Util.equalString(this.installReferrerXiaomi, activityState.installReferrerXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeServerXiaomi), Long.valueOf(activityState.clickTimeServerXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginServerXiaomi), Long.valueOf(activityState.installBeginServerXiaomi)) && Util.equalString(this.installVersionXiaomi, activityState.installVersionXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeSamsung), Long.valueOf(activityState.clickTimeSamsung)) && Util.equalLong(Long.valueOf(this.installBeginSamsung), Long.valueOf(activityState.installBeginSamsung)) && Util.equalString(this.installReferrerSamsung, activityState.installReferrerSamsung) && Util.equalLong(Long.valueOf(this.clickTimeVivo), Long.valueOf(activityState.clickTimeVivo)) && Util.equalLong(Long.valueOf(this.installBeginVivo), Long.valueOf(activityState.installBeginVivo)) && Util.equalString(this.installReferrerVivo, activityState.installReferrerVivo) && Util.equalString(this.installVersionVivo, activityState.installVersionVivo) && Util.equalString(this.installReferrerMeta, activityState.installReferrerMeta) && Util.equalLong(Long.valueOf(this.clickTimeMeta), Long.valueOf(activityState.clickTimeMeta)) && Util.equalBoolean(this.isClickMeta, activityState.isClickMeta);
    }

    public boolean eventDeduplicationIdExists(String str) {
        LinkedList<String> linkedList = this.orderIds;
        if (linkedList == null) {
            return false;
        }
        return linkedList.contains(str);
    }

    public int hashCode() {
        return Util.hashBoolean(this.isClickMeta, Util.hashLong(Long.valueOf(this.clickTimeMeta), Util.hashString(this.installReferrerMeta, Util.hashString(this.installVersionVivo, Util.hashString(this.installReferrerVivo, Util.hashLong(Long.valueOf(this.installBeginVivo), Util.hashLong(Long.valueOf(this.clickTimeVivo), Util.hashString(this.installReferrerSamsung, Util.hashLong(Long.valueOf(this.installBeginSamsung), Util.hashLong(Long.valueOf(this.clickTimeSamsung), Util.hashString(this.installVersionXiaomi, Util.hashLong(Long.valueOf(this.installBeginServerXiaomi), Util.hashLong(Long.valueOf(this.clickTimeServerXiaomi), Util.hashString(this.installReferrerXiaomi, Util.hashLong(Long.valueOf(this.installBeginXiaomi), Util.hashLong(Long.valueOf(this.clickTimeXiaomi), Util.hashString(this.installReferrerHuaweiAppGallery, Util.hashString(this.installReferrerHuawei, Util.hashLong(Long.valueOf(this.installBeginHuawei), Util.hashLong(Long.valueOf(this.clickTimeHuawei), Util.hashString(this.installVersion, Util.hashLong(Long.valueOf(this.installBeginServer), Util.hashLong(Long.valueOf(this.clickTimeServer), Util.hashBoolean(this.googlePlayInstant, Util.hashString(this.installReferrer, Util.hashLong(Long.valueOf(this.installBegin), Util.hashLong(Long.valueOf(this.clickTime), Util.hashString(this.adid, Util.hashString(this.pushToken, Util.hashObject(this.orderIds, Util.hashLong(Long.valueOf(this.lastInterval), Util.hashLong(Long.valueOf(this.timeSpent), Util.hashLong(Long.valueOf(this.sessionLength), (((((Util.hashBoolean(Boolean.valueOf(this.askingAttribution), Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Util.hashBoolean(Boolean.valueOf(this.isGdprForgotten), Util.hashBoolean(Boolean.valueOf(this.enabled), Util.hashString(this.uuid, 17))))) * 37) + this.eventCount) * 37) + this.sessionCount) * 37) + this.subsessionCount)))))))))))))))))))))))))))))))));
    }

    public void resetSessionAttributes(long j11) {
        this.subsessionCount = 1;
        this.sessionLength = 0;
        this.timeSpent = 0;
        this.lastActivity = j11;
        this.lastInterval = -1;
    }

    public void setEventDeduplicationIdsMaxSize(Integer num) {
        if (num != null && num.intValue() >= 0) {
            this.eventDeduplicationIdsMaxSize = num.intValue();
        }
    }

    public String toString() {
        return Util.formatString("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.eventCount), Integer.valueOf(this.sessionCount), Integer.valueOf(this.subsessionCount), Double.valueOf(((double) this.sessionLength) / 1000.0d), Double.valueOf(((double) this.timeSpent) / 1000.0d), stamp(this.lastActivity), this.uuid);
    }
}
