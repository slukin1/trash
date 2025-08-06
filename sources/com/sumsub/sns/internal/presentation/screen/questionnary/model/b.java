package com.sumsub.sns.internal.presentation.screen.questionnary.model;

import com.sumsub.sns.internal.core.data.model.FieldType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.c0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.d;
import d10.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class b {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36240a;

        static {
            int[] iArr = new int[FieldType.values().length];
            iArr[FieldType.text.ordinal()] = 1;
            iArr[FieldType.textArea.ordinal()] = 2;
            iArr[FieldType.phone.ordinal()] = 3;
            iArr[FieldType.date.ordinal()] = 4;
            iArr[FieldType.dateTime.ordinal()] = 5;
            iArr[FieldType.bool.ordinal()] = 6;
            iArr[FieldType.select.ordinal()] = 7;
            iArr[FieldType.selectDropdown.ordinal()] = 8;
            iArr[FieldType.multiSelect.ordinal()] = 9;
            iArr[FieldType.countrySelect.ordinal()] = 10;
            iArr[FieldType.fileAttachment.ordinal()] = 11;
            iArr[FieldType.multiFileAttachments.ordinal()] = 12;
            f36240a = iArr;
        }
    }

    public static final List<b.C0375b> a(w wVar, d dVar, y yVar, Map<String, String> map, l<? super String, String> lVar) {
        u uVar;
        List<u> e11;
        T t11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (yVar == null || (e11 = yVar.e()) == null) {
            uVar = null;
        } else {
            Iterator<T> it2 = e11.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                if (x.b(((u) t11).c(), wVar.o())) {
                    break;
                }
            }
            uVar = (u) t11;
        }
        List<c0> u11 = wVar.u();
        if (u11 != null) {
            int i11 = 0;
            ArrayList arrayList3 = null;
            for (T next : u11) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                c0 c0Var = (c0) next;
                if (x.b(c0Var.l(), Boolean.TRUE)) {
                    if (arrayList3 != null) {
                        arrayList.add(new b.C0375b(arrayList.size(), wVar.w(), wVar.m(), new ArrayList(arrayList3)));
                    }
                    arrayList3 = null;
                    i11 = i12;
                } else {
                    k kVar = new k((String) null, c0Var.t(), c0Var.n(), FormItem.f33731j, Boolean.FALSE, (String) null, (String) null, c0Var.h(), (List) null, 256, (r) null);
                    String p11 = c0Var.p();
                    if (p11 == null) {
                        p11 = "sectionId";
                    }
                    FormItem.l lVar2 = new FormItem.l(kVar, p11);
                    lVar2.a(c0Var.h());
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    ArrayList arrayList4 = arrayList3;
                    arrayList4.add(lVar2);
                    List<k> r11 = c0Var.r();
                    if (r11 != null) {
                        for (k kVar2 : r11) {
                            String p12 = c0Var.p();
                            if (p12 == null) {
                                p12 = "";
                            }
                            FormItem a11 = a(kVar2, p12, dVar, uVar, map, lVar);
                            if (a11 != null) {
                                arrayList4.add(a11);
                            }
                        }
                    }
                    i11 = i12;
                    arrayList3 = arrayList4;
                }
            }
            arrayList2 = arrayList3;
        }
        if (arrayList2 != null) {
            int size = arrayList.size();
            String w11 = wVar.w();
            String m11 = wVar.m();
            List I0 = CollectionsKt___CollectionsKt.I0(arrayList2);
            if (I0 == null) {
                I0 = CollectionsKt__CollectionsKt.k();
            }
            arrayList.add(new b.C0375b(size, w11, m11, new ArrayList(I0)));
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem] */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r0v50, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$p] */
    /* JADX WARNING: type inference failed for: r0v51, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$k] */
    /* JADX WARNING: type inference failed for: r0v52, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$q] */
    /* JADX WARNING: type inference failed for: r0v53, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$k] */
    /* JADX WARNING: type inference failed for: r0v54, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$d] */
    /* JADX WARNING: type inference failed for: r0v55, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$e] */
    /* JADX WARNING: type inference failed for: r0v56, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$a] */
    /* JADX WARNING: type inference failed for: r0v57, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$m] */
    /* JADX WARNING: type inference failed for: r0v58, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$n] */
    /* JADX WARNING: type inference failed for: r0v59, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$j] */
    /* JADX WARNING: type inference failed for: r0v60, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$c] */
    /* JADX WARNING: type inference failed for: r0v61, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$g] */
    /* JADX WARNING: type inference failed for: r0v62, types: [com.sumsub.sns.internal.core.presentation.form.model.FormItem$i] */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r0 == false) goto L_0x0051;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.presentation.form.model.FormItem a(com.sumsub.sns.internal.core.data.source.applicant.remote.k r25, java.lang.String r26, com.sumsub.sns.internal.core.presentation.form.model.d r27, com.sumsub.sns.internal.core.data.source.applicant.remote.u r28, java.util.Map<java.lang.String, java.lang.String> r29, d10.l<? super java.lang.String, java.lang.String> r30) {
        /*
            r2 = r26
            r0 = r28
            r1 = r29
            r3 = r30
            com.sumsub.sns.internal.core.data.model.FieldType r4 = com.sumsub.sns.internal.core.presentation.form.model.g.c(r25)
            if (r4 != 0) goto L_0x0010
            r4 = -1
            goto L_0x0018
        L_0x0010:
            int[] r5 = com.sumsub.sns.internal.presentation.screen.questionnary.model.b.a.f36240a
            int r4 = r4.ordinal()
            r4 = r5[r4]
        L_0x0018:
            java.lang.String r5 = "sns_quiestionnaire_action_addFile"
            r12 = 0
            switch(r4) {
                case -1: goto L_0x02bf;
                case 0: goto L_0x001e;
                case 1: goto L_0x0256;
                case 2: goto L_0x0239;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01d7;
                case 5: goto L_0x01ba;
                case 6: goto L_0x019d;
                case 7: goto L_0x0180;
                case 8: goto L_0x0162;
                case 9: goto L_0x0144;
                case 10: goto L_0x0117;
                case 11: goto L_0x00d5;
                case 12: goto L_0x0024;
                default: goto L_0x001e;
            }
        L_0x001e:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0024:
            if (r0 == 0) goto L_0x0030
            java.lang.String r4 = r25.p()
            java.util.List r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.b(r0, r2, r4)
            r4 = r0
            goto L_0x0031
        L_0x0030:
            r4 = r12
        L_0x0031:
            java.lang.Boolean r0 = r25.v()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.x.b(r0, r6)
            r6 = 0
            r7 = 1
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r25.n()
            if (r0 == 0) goto L_0x004e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r0 = r6
            goto L_0x004f
        L_0x004e:
            r0 = r7
        L_0x004f:
            if (r0 != 0) goto L_0x0052
        L_0x0051:
            r6 = r7
        L_0x0052:
            if (r6 == 0) goto L_0x0057
            r0 = r25
            goto L_0x0058
        L_0x0057:
            r0 = r12
        L_0x0058:
            if (r0 != 0) goto L_0x0074
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 479(0x1df, float:6.71E-43)
            r24 = 0
            java.lang.String r19 = "min_value:1"
            r13 = r25
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r0 = com.sumsub.sns.internal.core.data.source.applicant.remote.k.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
        L_0x0074:
            r6 = r0
            java.lang.Object r0 = r1.get(r5)
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            if (r4 == 0) goto L_0x00bd
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IterablesKt.u(r4, r0)
            int r0 = kotlin.collections.MapsKt__MapsJVMKt.d(r0)
            r1 = 16
            int r0 = kotlin.ranges.RangesKt___RangesKt.d(r0, r1)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>(r0)
            java.util.Iterator r0 = r4.iterator()
        L_0x009b:
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x00bb
            java.lang.Object r11 = r0.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r13 = r3.invoke(r11)
            kotlin.Pair r11 = kotlin.l.a(r11, r13)
            java.lang.Object r13 = r11.getFirst()
            java.lang.Object r11 = r11.getSecond()
            r1.put(r13, r11)
            goto L_0x009b
        L_0x00bb:
            r11 = r1
            goto L_0x00be
        L_0x00bd:
            r11 = r12
        L_0x00be:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$i r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$i
            r14 = 240(0xf0, float:3.36E-43)
            r15 = 0
            r0 = r13
            r1 = r6
            r2 = r26
            r3 = r4
            r4 = r5
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r10
            r9 = r11
            r10 = r14
            r11 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x02c0
        L_0x00d5:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$g r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$g
            if (r0 == 0) goto L_0x00e2
            java.lang.String r4 = r25.p()
            java.lang.String r4 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r4)
            goto L_0x00e3
        L_0x00e2:
            r4 = r12
        L_0x00e3:
            java.lang.Object r1 = r1.get(r5)
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r6 = 0
            r7 = 0
            r8 = 0
            if (r0 == 0) goto L_0x00f9
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            if (r0 != 0) goto L_0x00fb
        L_0x00f9:
            java.lang.String r0 = ""
        L_0x00fb:
            java.lang.Object r0 = r3.invoke(r0)
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            r10 = 112(0x70, float:1.57E-43)
            r11 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x02c0
        L_0x0117:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$c
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.util.Map r1 = r1.h()
            if (r1 != 0) goto L_0x0127
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0127:
            r3 = r1
            if (r0 == 0) goto L_0x0134
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r4 = r0
            goto L_0x0135
        L_0x0134:
            r4 = r12
        L_0x0135:
            r5 = 1
            r6 = 0
            r7 = 32
            r8 = 0
            r0 = r13
            r1 = r26
            r2 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x02c0
        L_0x0144:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$j r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$j
            if (r0 == 0) goto L_0x0152
            java.lang.String r1 = r25.p()
            java.util.List r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.b(r0, r2, r1)
            r3 = r0
            goto L_0x0153
        L_0x0152:
            r3 = r12
        L_0x0153:
            r4 = 0
            r5 = 0
            r6 = 24
            r7 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x02c0
        L_0x0162:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$n r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$n
            if (r0 == 0) goto L_0x0170
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r3 = r0
            goto L_0x0171
        L_0x0170:
            r3 = r12
        L_0x0171:
            r4 = 0
            r5 = 0
            r6 = 24
            r7 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x02c0
        L_0x0180:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$m r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$m
            if (r0 == 0) goto L_0x018e
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r3 = r0
            goto L_0x018f
        L_0x018e:
            r3 = r12
        L_0x018f:
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x02c0
        L_0x019d:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$a r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$a
            if (r0 == 0) goto L_0x01ab
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r3 = r0
            goto L_0x01ac
        L_0x01ab:
            r3 = r12
        L_0x01ac:
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x02c0
        L_0x01ba:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$e r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$e
            if (r0 == 0) goto L_0x01c8
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r3 = r0
            goto L_0x01c9
        L_0x01c8:
            r3 = r12
        L_0x01c9:
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x02c0
        L_0x01d7:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$d r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$d
            r3 = 0
            if (r0 == 0) goto L_0x01e6
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r4 = r0
            goto L_0x01e7
        L_0x01e6:
            r4 = r12
        L_0x01e7:
            r5 = 0
            r6 = 20
            r7 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x02c0
        L_0x01f5:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$k r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$k
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.util.Map r1 = r1.h()
            if (r1 != 0) goto L_0x0205
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0205:
            r3 = r1
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.util.Map r1 = r1.k()
            if (r1 != 0) goto L_0x0214
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x0214:
            r4 = r1
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.lang.String r5 = r1.i()
            r6 = 0
            if (r0 == 0) goto L_0x022a
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r7 = r0
            goto L_0x022b
        L_0x022a:
            r7 = r12
        L_0x022b:
            r8 = 0
            r9 = 160(0xa0, float:2.24E-43)
            r10 = 0
            r0 = r13
            r1 = r26
            r2 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x02c0
        L_0x0239:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$q r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$q
            if (r0 == 0) goto L_0x0247
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r3 = r0
            goto L_0x0248
        L_0x0247:
            r3 = r12
        L_0x0248:
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x02c0
        L_0x0256:
            com.sumsub.sns.internal.core.data.model.p r1 = com.sumsub.sns.internal.core.presentation.form.model.g.a(r25)
            boolean r1 = r1 instanceof com.sumsub.sns.internal.core.data.model.p.m
            if (r1 == 0) goto L_0x02a1
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$k r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$k
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.util.Map r1 = r1.h()
            if (r1 != 0) goto L_0x026e
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x026e:
            r3 = r1
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.util.Map r1 = r1.k()
            if (r1 != 0) goto L_0x027d
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x027d:
            r4 = r1
            com.sumsub.sns.internal.core.domain.e r1 = r27.c()
            java.lang.String r5 = r1.i()
            r6 = 0
            if (r0 == 0) goto L_0x0293
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r7 = r0
            goto L_0x0294
        L_0x0293:
            r7 = r12
        L_0x0294:
            r8 = 0
            r9 = 160(0xa0, float:2.24E-43)
            r10 = 0
            r0 = r13
            r1 = r26
            r2 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x02c0
        L_0x02a1:
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$p r13 = new com.sumsub.sns.internal.core.presentation.form.model.FormItem$p
            if (r0 == 0) goto L_0x02af
            java.lang.String r1 = r25.p()
            java.lang.String r0 = com.sumsub.sns.internal.presentation.screen.questionnary.model.c.a(r0, r2, r1)
            r3 = r0
            goto L_0x02b0
        L_0x02af:
            r3 = r12
        L_0x02b0:
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = 48
            r8 = 0
            r0 = r13
            r1 = r25
            r2 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x02c0
        L_0x02bf:
            r13 = r12
        L_0x02c0:
            if (r13 == 0) goto L_0x02ca
            java.lang.String r0 = r25.j()
            r13.a(r0)
            r12 = r13
        L_0x02ca:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.questionnary.model.b.a(com.sumsub.sns.internal.core.data.source.applicant.remote.k, java.lang.String, com.sumsub.sns.internal.core.presentation.form.model.d, com.sumsub.sns.internal.core.data.source.applicant.remote.u, java.util.Map, d10.l):com.sumsub.sns.internal.core.presentation.form.model.FormItem");
    }
}
