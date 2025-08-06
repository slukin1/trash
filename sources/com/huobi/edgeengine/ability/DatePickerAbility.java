package com.huobi.edgeengine.ability;

import com.alibaba.fastjson.JSON;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.view.DatePickerDialog;
import io.flutter.Log;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class DatePickerAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43885a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements DatePickerDialog.ResultListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f43886a;

        public b(AbilityFunction.a aVar) {
            this.f43886a = aVar;
        }

        public void onCancel() {
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            AbilityFunction.a aVar = this.f43886a;
            if (aVar != null) {
                aVar.a(true, Long.valueOf(j11));
            }
            if (datePickerDialog != null) {
                datePickerDialog.dismiss();
            }
        }
    }

    public void a(rj.b bVar, Object obj, AbilityFunction.a aVar) {
        if (obj instanceof String) {
            String str = (String) obj;
            Log.d("DatePickerAbility", str);
            Map map = (Map) JSON.parseObject(str, Map.class);
            if (map != null) {
                DatePickerDialog.Builder builder = new DatePickerDialog.Builder();
                String str2 = (String) map.get("title");
                if (str2 != null) {
                    builder.setTitleText(str2);
                }
                Integer num = (Integer) map.get("isSelectedStartDate");
                if (num != null) {
                    int intValue = num.intValue();
                    Long l11 = (Long) map.get("startDate");
                    Long l12 = (Long) map.get("endDate");
                    if (intValue == 1) {
                        if (l11 != null) {
                            long longValue = l11.longValue();
                            builder.setInitDate(longValue);
                            if (l12 != null) {
                                longValue = l12.longValue();
                            }
                            builder.setMaxDate(longValue);
                        }
                    } else if (l12 != null) {
                        long longValue2 = l12.longValue();
                        builder.setInitDate(longValue2);
                        if (l11 != null) {
                            longValue2 = l11.longValue();
                        }
                        builder.setMinDate(longValue2);
                    }
                }
                builder.setResultListener(new b(aVar)).show(com.blankj.utilcode.util.a.c());
            }
            Log.d("DatePickerAbility", String.valueOf(bVar != null ? bVar.d() : null));
            Log.d("DatePickerAbility", String.valueOf(com.blankj.utilcode.util.a.c()));
        }
    }
}
