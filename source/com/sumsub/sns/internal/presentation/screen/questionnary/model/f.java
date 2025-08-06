package com.sumsub.sns.internal.presentation.screen.questionnary.model;

import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.x;

public final class f {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r0.w() == r4) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        if (r0.x() == com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT) goto L_0x0075;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean b(com.sumsub.sns.internal.core.presentation.form.b.C0375b r6) {
        /*
            java.util.List r6 = r6.f()
            boolean r0 = r6 instanceof java.util.Collection
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0012
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0012
            goto L_0x0079
        L_0x0012:
            java.util.Iterator r6 = r6.iterator()
        L_0x0016:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0079
            java.lang.Object r0 = r6.next()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r0 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem) r0
            boolean r3 = r0 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.g
            if (r3 == 0) goto L_0x0037
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$g r0 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.g) r0
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r3 = r0.t()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r4 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT
            if (r3 != r4) goto L_0x0073
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r0 = r0.w()
            if (r0 != r4) goto L_0x0073
            goto L_0x0075
        L_0x0037:
            boolean r3 = r0 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.i
            if (r3 == 0) goto L_0x0075
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$i r0 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.i) r0
            java.util.List r3 = r0.u()
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x004c
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x004c
            goto L_0x0067
        L_0x004c:
            java.util.Iterator r3 = r3.iterator()
        L_0x0050:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0067
            java.lang.Object r4 = r3.next()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r4 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState) r4
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r5 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.LOADING
            if (r4 != r5) goto L_0x0062
            r4 = r2
            goto L_0x0063
        L_0x0062:
            r4 = r1
        L_0x0063:
            if (r4 == 0) goto L_0x0050
            r3 = r1
            goto L_0x0068
        L_0x0067:
            r3 = r2
        L_0x0068:
            if (r3 == 0) goto L_0x0073
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r0 = r0.x()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$ItemState r3 = com.sumsub.sns.internal.core.presentation.form.model.FormItem.ItemState.DEFAULT
            if (r0 != r3) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r0 = r1
            goto L_0x0076
        L_0x0075:
            r0 = r2
        L_0x0076:
            if (r0 != 0) goto L_0x0016
            goto L_0x007a
        L_0x0079:
            r1 = r2
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.f.b(com.sumsub.sns.internal.core.presentation.form.b$b):boolean");
    }

    public static final FormItem a(List<b.C0375b> list, FieldId fieldId) {
        T t11;
        Iterator<b.C0375b> it2 = list.iterator();
        do {
            t11 = null;
            if (!it2.hasNext()) {
                break;
            }
            Iterator<T> it3 = it2.next().f().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                T next = it3.next();
                if (x.b(a((FormItem) next), fieldId)) {
                    t11 = next;
                    break;
                }
            }
            t11 = (FormItem) t11;
        } while (t11 == null);
        return t11;
    }

    public static final FieldId a(FormItem formItem) {
        String e11 = formItem.e();
        String str = "";
        if (e11 == null) {
            e11 = str;
        }
        String p11 = formItem.d().p();
        if (p11 != null) {
            str = p11;
        }
        return new FieldId(e11, str);
    }
}
