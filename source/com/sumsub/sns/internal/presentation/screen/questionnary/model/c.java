package com.sumsub.sns.internal.presentation.screen.questionnary.model;

import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.v;
import com.sumsub.sns.internal.core.data.source.applicant.remote.x;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class c {
    public static final u a(u uVar, String str, String str2, String str3) {
        x xVar;
        a(uVar, str);
        if (str == null || str2 == null || (xVar = uVar.e().get(str)) == null) {
            return uVar;
        }
        if (str3 == null) {
            xVar.b().remove(str2);
            return uVar;
        }
        xVar.b().put(str2, new v(str3, (List) null, 2, (r) null));
        return uVar;
    }

    public static final List<String> b(u uVar, String str, String str2) {
        x xVar;
        v vVar;
        if (str2 == null || str == null || (xVar = uVar.e().get(str)) == null || (vVar = xVar.b().get(str2)) == null) {
            return null;
        }
        return vVar.e();
    }

    public static final u a(u uVar, String str, String str2, List<String> list) {
        x xVar;
        a(uVar, str);
        if (str == null || str2 == null || (xVar = uVar.e().get(str)) == null) {
            return uVar;
        }
        if (list == null || list.isEmpty()) {
            xVar.b().remove(str2);
            return uVar;
        }
        xVar.b().put(str2, new v((String) null, (List) list, 1, (r) null));
        return uVar;
    }

    public static final String a(u uVar, String str, String str2) {
        x xVar;
        v vVar;
        if (str2 == null || str == null || (xVar = uVar.e().get(str)) == null || (vVar = xVar.b().get(str2)) == null) {
            return null;
        }
        return vVar.c();
    }

    public static final u a(u uVar, String str) {
        if (str != null && uVar.e().get(str) == null) {
            uVar.e().put(str, new x((Map) null, 1, (r) null));
        }
        return uVar;
    }
}
