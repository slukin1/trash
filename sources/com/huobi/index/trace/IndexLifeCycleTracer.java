package com.huobi.index.trace;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.core.ActionType;
import i6.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class IndexLifeCycleTracer {

    /* renamed from: a  reason: collision with root package name */
    public String f73493a = UUID.randomUUID().toString();

    /* renamed from: b  reason: collision with root package name */
    public IndexLifeCycleStep f73494b = IndexLifeCycleStep.AppStart;

    /* renamed from: c  reason: collision with root package name */
    public int f73495c = 1;

    /* renamed from: d  reason: collision with root package name */
    public Date f73496d;

    /* renamed from: e  reason: collision with root package name */
    public Date f73497e = new Date();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final IndexLifeCycleTracer f73498a = new IndexLifeCycleTracer();
    }

    public static IndexLifeCycleTracer c() {
        return a.f73498a;
    }

    public final Date a() {
        Date date = this.f73496d;
        if (date != null) {
            return date;
        }
        return this.f73497e;
    }

    public final String b(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    public final void d(IndexLifeCycleStep indexLifeCycleStep) {
        if (indexLifeCycleStep.index < IndexLifeCycleStep.AppEnterBackground.index) {
            this.f73494b = indexLifeCycleStep;
        } else if (indexLifeCycleStep == IndexLifeCycleStep.AppStart) {
            this.f73496d = new Date();
        }
    }

    public final boolean e(IndexLifeCycleStep indexLifeCycleStep) {
        if (((indexLifeCycleStep == IndexLifeCycleStep.AppEnterBackground || indexLifeCycleStep == IndexLifeCycleStep.AppEnterForgeground) && this.f73494b == IndexLifeCycleStep.AppHomePageDone) || indexLifeCycleStep.index <= this.f73494b.index) {
            return false;
        }
        return true;
    }

    public void f(IndexLifeCycleStep indexLifeCycleStep) {
        if (e(indexLifeCycleStep)) {
            HashMap hashMap = new HashMap();
            try {
                d(indexLifeCycleStep);
                Date date = new Date();
                hashMap.put("event", indexLifeCycleStep.name);
                hashMap.put("startTime", b(a()));
                hashMap.put("currentTime", b(date));
                hashMap.put("timeConsuming", Long.valueOf(date.getTime() - a().getTime()));
                hashMap.put("currentStep", this.f73494b.name);
                hashMap.put(SettingsJsonConstants.SESSION_KEY, Integer.valueOf(this.f73495c));
                hashMap.put("sessionID", this.f73493a);
                d.b("index_lifecycle_" + indexLifeCycleStep.name);
                d.b(JSON.toJSONString(hashMap));
            } catch (Exception e11) {
                Log.e("index_lifecycle", e11.getMessage());
            }
            WoodPeckerSDK.f().g().b(ActionType.APP_START, hashMap);
        }
    }
}
