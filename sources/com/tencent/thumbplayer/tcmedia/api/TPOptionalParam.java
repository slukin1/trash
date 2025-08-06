package com.tencent.thumbplayer.tcmedia.api;

import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;

public class TPOptionalParam {
    public static final int TP_OPTIONAL_PARAM_TYPE_BOOLEAN = 1;
    public static final int TP_OPTIONAL_PARAM_TYPE_FLOAT = 6;
    public static final int TP_OPTIONAL_PARAM_TYPE_LONG = 2;
    public static final int TP_OPTIONAL_PARAM_TYPE_OBJECT = 7;
    public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_INT = 4;
    public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_STRING = 5;
    public static final int TP_OPTIONAL_PARAM_TYPE_STRING = 3;
    public static final int TP_OPTIONAL_PARAM_TYPE_UNKNOWN = -1;
    @TPCommonEnum.TPOptionalId
    private int key;
    private OptionalParamBoolean paramBoolean;
    private OptionalParamFloat paramFloat;
    private OptionalParamLong paramLong;
    private OptionalParamObject paramObject;
    private OptionalParamQueueInt paramQueueInt;
    private OptionalParamQueueString paramQueueString;
    private OptionalParamString paramString;
    private int paramType = -1;

    public static class OptionalParamBoolean {
        public boolean value;
    }

    public static class OptionalParamFloat {
        public float param1;
        public float param2;
        public float value;
    }

    public static class OptionalParamLong {
        public long param1;
        public long param2;
        public long value;
    }

    public static class OptionalParamObject {
        public Object objectValue;
    }

    public static class OptionalParamQueueInt {
        public int[] queueValue;
    }

    public static class OptionalParamQueueString {
        public String[] queueValue;
    }

    public static class OptionalParamString {
        public String param1;
        public String param2;
        public String value;
    }

    public TPOptionalParam buildBoolean(@TPCommonEnum.TPOptionalId int i11, boolean z11) {
        this.paramType = 1;
        this.key = i11;
        OptionalParamBoolean optionalParamBoolean = new OptionalParamBoolean();
        this.paramBoolean = optionalParamBoolean;
        optionalParamBoolean.value = z11;
        return this;
    }

    public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int i11, float f11) {
        this.paramType = 6;
        this.key = i11;
        OptionalParamFloat optionalParamFloat = new OptionalParamFloat();
        this.paramFloat = optionalParamFloat;
        optionalParamFloat.value = f11;
        return this;
    }

    public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int i11, float f11, float f12, float f13) {
        this.paramType = 6;
        this.key = i11;
        OptionalParamFloat optionalParamFloat = new OptionalParamFloat();
        this.paramFloat = optionalParamFloat;
        optionalParamFloat.value = f11;
        optionalParamFloat.param1 = f12;
        optionalParamFloat.param2 = f13;
        return this;
    }

    public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int i11, long j11) {
        this.paramType = 2;
        this.key = i11;
        OptionalParamLong optionalParamLong = new OptionalParamLong();
        this.paramLong = optionalParamLong;
        optionalParamLong.value = j11;
        return this;
    }

    public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int i11, long j11, long j12, long j13) {
        this.paramType = 2;
        this.key = i11;
        OptionalParamLong optionalParamLong = new OptionalParamLong();
        this.paramLong = optionalParamLong;
        optionalParamLong.value = j11;
        optionalParamLong.param1 = j12;
        optionalParamLong.param2 = j13;
        return this;
    }

    public TPOptionalParam buildObject(int i11, Object obj) {
        this.paramType = 7;
        this.key = i11;
        OptionalParamObject optionalParamObject = new OptionalParamObject();
        this.paramObject = optionalParamObject;
        optionalParamObject.objectValue = obj;
        return this;
    }

    public TPOptionalParam buildQueueInt(@TPCommonEnum.TPOptionalId int i11, int[] iArr) {
        this.paramType = 4;
        this.key = i11;
        OptionalParamQueueInt optionalParamQueueInt = new OptionalParamQueueInt();
        this.paramQueueInt = optionalParamQueueInt;
        optionalParamQueueInt.queueValue = iArr;
        return this;
    }

    public TPOptionalParam buildQueueString(@TPCommonEnum.TPOptionalId int i11, String[] strArr) {
        this.paramType = 5;
        this.key = i11;
        OptionalParamQueueString optionalParamQueueString = new OptionalParamQueueString();
        this.paramQueueString = optionalParamQueueString;
        optionalParamQueueString.queueValue = strArr;
        return this;
    }

    public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int i11, String str) {
        this.paramType = 3;
        this.key = i11;
        OptionalParamString optionalParamString = new OptionalParamString();
        this.paramString = optionalParamString;
        optionalParamString.value = str;
        return this;
    }

    public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int i11, String str, String str2, String str3) {
        this.paramType = 3;
        this.key = i11;
        OptionalParamString optionalParamString = new OptionalParamString();
        this.paramString = optionalParamString;
        optionalParamString.value = str;
        optionalParamString.param1 = str2;
        optionalParamString.param2 = str3;
        return this;
    }

    @TPCommonEnum.TPOptionalId
    public int getKey() {
        return this.key;
    }

    public OptionalParamBoolean getParamBoolean() {
        return this.paramBoolean;
    }

    public OptionalParamFloat getParamFloat() {
        return this.paramFloat;
    }

    public OptionalParamLong getParamLong() {
        return this.paramLong;
    }

    public OptionalParamObject getParamObject() {
        return this.paramObject;
    }

    public OptionalParamQueueInt getParamQueueInt() {
        return this.paramQueueInt;
    }

    public OptionalParamQueueString getParamQueueString() {
        return this.paramQueueString;
    }

    public OptionalParamString getParamString() {
        return this.paramString;
    }

    public int getParamType() {
        return this.paramType;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        switch (this.paramType) {
            case 1:
                sb2.append("type:long, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                sb2.append(this.paramBoolean.value);
                break;
            case 2:
                sb2.append("type:long, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                sb2.append(this.paramLong.value);
                sb2.append(", param1:");
                sb2.append(this.paramLong.param1);
                sb2.append(", param2:");
                sb2.append(this.paramLong.param2);
                break;
            case 3:
                sb2.append("type:string, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                sb2.append(this.paramString.value);
                sb2.append(", param1:");
                sb2.append(this.paramString.param1);
                sb2.append(", param2:");
                str = this.paramString.param2;
                break;
            case 4:
                sb2.append("type:quint_int, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                int[] iArr = this.paramQueueInt.queueValue;
                if (iArr != null) {
                    int length = iArr.length;
                    while (i11 < length) {
                        sb2.append(iArr[i11]);
                        sb2.append(", ");
                        i11++;
                    }
                    break;
                }
                break;
            case 5:
                sb2.append("type:quint_string, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                String[] strArr = this.paramQueueString.queueValue;
                if (strArr != null) {
                    int length2 = strArr.length;
                    while (i11 < length2) {
                        sb2.append(strArr[i11]);
                        sb2.append(", ");
                        i11++;
                    }
                    break;
                }
                break;
            case 6:
                sb2.append("type:float, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                sb2.append(this.paramFloat.value);
                sb2.append(", param1:");
                sb2.append(this.paramFloat.param1);
                sb2.append(", param2:");
                sb2.append(this.paramFloat.param2);
                break;
            case 7:
                sb2.append("type:object, key:");
                sb2.append(this.key);
                sb2.append(", \nname:");
                sb2.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb2.append(", value:");
                sb2.append(this.paramObject.objectValue);
                break;
            default:
                str = "type:unknown";
                break;
        }
        sb2.append(str);
        return sb2.toString();
    }
}
