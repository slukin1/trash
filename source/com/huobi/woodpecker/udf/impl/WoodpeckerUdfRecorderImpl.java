package com.huobi.woodpecker.udf.impl;

import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.udf.ActionRecord;
import com.huobi.woodpecker.utils.RecordUtil;
import com.tencent.android.tpush.common.MessageKey;
import java.util.Map;
import jv.a;
import kv.e;
import wu.c;

public class WoodpeckerUdfRecorderImpl implements a {
    public void a(Map<String, Object> map) {
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.setAction(ActionType.APP_COMMON);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().putAll(map);
        e(actionRecord);
    }

    public void b(ActionType actionType, Map<String, Object> map) {
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.setAction(actionType);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().putAll(map);
        e(actionRecord);
    }

    public void c(String str, String str2, String str3) {
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.setAction(ActionType.APP_CUSTOM_EVENT);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put(MessageKey.MSG_DATE, Long.valueOf(System.currentTimeMillis()));
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("event", str);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("id", str2);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("xpath", str3);
        e(actionRecord);
    }

    public void d(String str, double d11, String str2) {
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.setAction(ActionType.APP_CUSTOM_GAUGE);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("key", str);
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("value", Double.valueOf(d11));
        ((ActionRecord.UdfRecordData) actionRecord.getData()).getMap().put("tag", str2);
        e(actionRecord);
    }

    public final void e(ActionRecord actionRecord) {
        if (WoodPeckerSDK.f().e() != null) {
            RecordUtil.a(actionRecord);
            e.c("sss", actionRecord.toJsonString());
            c.b(actionRecord);
            return;
        }
        e.c("sss", "save(threwrec) called with: udfRecord = [" + actionRecord + "]");
    }
}
