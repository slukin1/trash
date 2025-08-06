package com.huobi.edgeengine.ability;

import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.view.DatePickerDialog;
import io.flutter.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.r;

public final class ShowDatePicker implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43902a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements DatePickerDialog.ResultListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f43903a;

        public b(AbilityFunction.a aVar) {
            this.f43903a = aVar;
        }

        public void onCancel() {
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("formatTime", new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date(j11)));
            jSONObject.put(CrashHianalyticsData.TIME, Long.valueOf(j11));
            Log.d("ShowDatePicker", jSONObject + "    -- " + jSONObject.toJSONString());
            AbilityFunction.a aVar = this.f43903a;
            if (aVar != null) {
                aVar.a(true, jSONObject.toJSONString());
            }
            if (datePickerDialog != null) {
                datePickerDialog.dismiss();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rj.b r5, java.lang.Object r6, com.huobi.edgeengine.ability.AbilityFunction.a r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L_0x002c
            java.lang.String r6 = (java.lang.String) r6
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x002c
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "yyyy/MM/dd"
            r1.<init>(r3, r2)
            java.util.Date r6 = r1.parse(r6)
            if (r6 == 0) goto L_0x002a
            long r1 = r6.getTime()
            java.lang.Long r6 = java.lang.Long.valueOf(r1)
            goto L_0x0034
        L_0x002a:
            r6 = r0
            goto L_0x0034
        L_0x002c:
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r6 = java.lang.Long.valueOf(r1)
        L_0x0034:
            com.huobi.view.DatePickerDialog$Builder r1 = new com.huobi.view.DatePickerDialog$Builder
            r1.<init>()
            if (r6 == 0) goto L_0x0040
            long r2 = r6.longValue()
            goto L_0x0044
        L_0x0040:
            long r2 = java.lang.System.currentTimeMillis()
        L_0x0044:
            com.huobi.view.DatePickerDialog$Builder r6 = r1.setInitDate(r2)
            r1 = 2132021685(0x7f1411b5, float:1.9681768E38)
            com.huobi.view.DatePickerDialog$Builder r6 = r6.setTitle(r1)
            long r1 = java.lang.System.currentTimeMillis()
            com.huobi.view.DatePickerDialog$Builder r6 = r6.setMinDate(r1)
            long r1 = r4.b()
            com.huobi.view.DatePickerDialog$Builder r6 = r6.setMaxDate(r1)
            com.huobi.edgeengine.ability.ShowDatePicker$b r1 = new com.huobi.edgeengine.ability.ShowDatePicker$b
            r1.<init>(r7)
            com.huobi.view.DatePickerDialog$Builder r6 = r6.setResultListener(r1)
            android.app.Activity r7 = com.blankj.utilcode.util.a.c()
            r6.show(r7)
            if (r5 == 0) goto L_0x0075
            android.content.Context r0 = r5.d()
        L_0x0075:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            java.lang.String r6 = "ShowDatePicker"
            io.flutter.Log.d(r6, r5)
            android.app.Activity r5 = com.blankj.utilcode.util.a.c()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            io.flutter.Log.d(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ability.ShowDatePicker.a(rj.b, java.lang.Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final long b() {
        Calendar instance = Calendar.getInstance();
        instance.add(1, 1);
        instance.set(6, instance.getActualMaximum(6));
        instance.set(11, instance.getActualMaximum(11));
        instance.set(12, instance.getActualMaximum(12));
        instance.set(13, instance.getActualMaximum(13));
        instance.set(14, instance.getActualMaximum(14));
        return instance.getTimeInMillis();
    }
}
