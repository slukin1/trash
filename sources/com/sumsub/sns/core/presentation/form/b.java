package com.sumsub.sns.core.presentation.form;

import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public final class b {
    public static final void a(Map<a, ? extends SNSApplicantDataBaseFieldView> map, Set<FieldId> set, l<? super Map.Entry<a, ? extends SNSApplicantDataBaseFieldView>, Unit> lVar) {
        T t11;
        boolean z11;
        for (FieldId next : set) {
            Iterator<T> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                Map.Entry entry = (Map.Entry) t11;
                if (!x.b(((a) entry.getKey()).a().e(), next.getSectionId()) || !x.b(((a) entry.getKey()).a().d().p(), next.getItemId())) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) t11;
            if (entry2 != null) {
                lVar.invoke(entry2);
            }
        }
    }

    public static final void b(Map<a, ? extends SNSApplicantDataBaseFieldView> map, Set<String> set, l<? super Map.Entry<a, ? extends SNSApplicantDataBaseFieldView>, Unit> lVar) {
        T t11;
        boolean z11;
        for (String next : set) {
            Iterator<T> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                Map.Entry entry = (Map.Entry) t11;
                if (!x.b(((a) entry.getKey()).a().e(), next) || ((a) entry.getKey()).a().d().p() != null) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) t11;
            if (entry2 != null) {
                lVar.invoke(entry2);
            }
        }
    }

    public static final SNSApplicantDataBaseFieldView a(Map<a, ? extends SNSApplicantDataBaseFieldView> map, FormItem formItem) {
        T t11;
        boolean z11;
        Iterator<T> it2 = map.keySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            a aVar = (a) t11;
            if (!x.b(aVar.a().e(), formItem.e()) || !x.b(aVar.a().d().p(), formItem.d().p())) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        a aVar2 = (a) t11;
        if (aVar2 != null) {
            return (SNSApplicantDataBaseFieldView) map.get(aVar2);
        }
        return null;
    }
}
