package com.sumsub.sns.core.presentation.form.viewutils;

import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.r;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.x;

public final class g {
    public static final void a(SNSApplicantDataMutilselectFieldView sNSApplicantDataMutilselectFieldView, FormItem.j jVar, List<String> list) {
        h.e.a.C0341a aVar;
        T t11;
        List<r> r11 = jVar.d().r();
        if (r11 != null && list != null && sNSApplicantDataMutilselectFieldView != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                Iterator<T> it2 = r11.iterator();
                while (true) {
                    aVar = null;
                    if (!it2.hasNext()) {
                        t11 = null;
                        break;
                    }
                    t11 = it2.next();
                    if (x.b(str, ((r) t11).e())) {
                        break;
                    }
                }
                r rVar = (r) t11;
                if (rVar != null) {
                    String e11 = rVar.e();
                    String str2 = "";
                    if (e11 == null) {
                        e11 = str2;
                    }
                    String c11 = rVar.c();
                    if (c11 != null) {
                        str2 = c11;
                    }
                    aVar = new h.e.a.C0341a(e11, str2);
                }
                if (aVar != null) {
                    arrayList.add(aVar);
                }
            }
            sNSApplicantDataMutilselectFieldView.setSelectedItems(arrayList);
        }
    }
}
