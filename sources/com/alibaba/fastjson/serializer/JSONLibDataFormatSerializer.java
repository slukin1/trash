package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.facebook.places.model.PlaceFields;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.android.tpush.common.MessageKey;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class JSONLibDataFormatSerializer implements k {
    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        if (obj == null) {
            jSONSerializer.f14277k.H();
            return;
        }
        Date date = (Date) obj;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MessageKey.MSG_DATE, (Object) Integer.valueOf(date.getDate()));
        jSONObject.put(MTPushConstants.NotificationTime.KEY_DAYS, (Object) Integer.valueOf(date.getDay()));
        jSONObject.put(PlaceFields.HOURS, (Object) Integer.valueOf(date.getHours()));
        jSONObject.put("minutes", (Object) Integer.valueOf(date.getMinutes()));
        jSONObject.put("month", (Object) Integer.valueOf(date.getMonth()));
        jSONObject.put("seconds", (Object) Integer.valueOf(date.getSeconds()));
        jSONObject.put(CrashHianalyticsData.TIME, (Object) Long.valueOf(date.getTime()));
        jSONObject.put("timezoneOffset", (Object) Integer.valueOf(date.getTimezoneOffset()));
        jSONObject.put("year", (Object) Integer.valueOf(date.getYear()));
        jSONSerializer.E(jSONObject);
    }
}
