package com.sumsub.sns.internal.core.presentation.form.model;

import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.d;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f33832a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final f f33833b = new f();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f33834a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<FieldId> f33835b;

        public a(Set<String> set, Set<FieldId> set2) {
            this.f33834a = set;
            this.f33835b = set2;
        }

        public final Set<String> a() {
            return this.f33834a;
        }

        public final Set<FieldId> b() {
            return this.f33835b;
        }

        public final Set<FieldId> c() {
            return this.f33835b;
        }

        public final Set<String> d() {
            return this.f33834a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f33834a, aVar.f33834a) && x.b(this.f33835b, aVar.f33835b);
        }

        public int hashCode() {
            return (this.f33834a.hashCode() * 31) + this.f33835b.hashCode();
        }

        public String toString() {
            return "CheckResult(illegalSectionIds=" + this.f33834a + ", illegalItemIds=" + this.f33835b + ')';
        }

        public final a a(Set<String> set, Set<FieldId> set2) {
            return new a(set, set2);
        }

        public static /* synthetic */ a a(a aVar, Set<String> set, Set<FieldId> set2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                set = aVar.f33834a;
            }
            if ((i11 & 2) != 0) {
                set2 = aVar.f33835b;
            }
            return aVar.a(set, set2);
        }
    }

    public final a a(List<? extends FormItem> list, d dVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList<FormItem.l> arrayList = new ArrayList<>();
        for (T next : list) {
            if (next instanceof FormItem.l) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (T next2 : list) {
            if (((FormItem) next2).d().p() != null) {
                arrayList2.add(next2);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next3 : arrayList2) {
            String e11 = ((FormItem) next3).e();
            Object obj = linkedHashMap.get(e11);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(e11, obj);
            }
            ((List) obj).add(next3);
        }
        for (FormItem.l lVar : arrayList) {
            List<FormItem> list2 = (List) linkedHashMap.get(lVar.e());
            if (f33832a.a(lVar, list, linkedHashSet2, linkedHashSet, dVar)) {
                if (!(list2 == null || (r10 = list2.iterator()) == null)) {
                    for (FormItem formItem : list2) {
                        if (!(f33832a.a(formItem, list, linkedHashSet2, linkedHashSet, dVar) || formItem.e() == null || formItem.d().p() == null)) {
                            linkedHashSet.add(new FieldId(formItem.e(), formItem.d().p()));
                        }
                    }
                }
            } else if (!(list2 == null || (r0 = list2.iterator()) == null)) {
                for (FormItem formItem2 : list2) {
                    if (!(formItem2.e() == null || formItem2.d().p() == null)) {
                        linkedHashSet.add(new FieldId(formItem2.e(), formItem2.d().p()));
                    }
                    String e12 = formItem2.e();
                    if (e12 != null) {
                        linkedHashSet2.add(e12);
                    }
                }
            }
        }
        return new a(linkedHashSet2, linkedHashSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if ((!r1.contains(new com.sumsub.sns.internal.core.presentation.form.FieldId(r3.c(), r3.b())) && !r0.contains(r3.c())) != false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dc, code lost:
        if ((!r1.contains(new com.sumsub.sns.internal.core.presentation.form.FieldId(r3.c(), r3.b())) && !r0.contains(r3.c())) != false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010d, code lost:
        if (r4 == false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0139, code lost:
        if (r4 == false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0182, code lost:
        if (r4 == false) goto L_0x0185;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.sumsub.sns.internal.core.presentation.form.model.FormItem r17, java.util.List<? extends com.sumsub.sns.internal.core.presentation.form.model.FormItem> r18, java.util.Set<java.lang.String> r19, java.util.Set<com.sumsub.sns.internal.core.presentation.form.FieldId> r20, com.sumsub.sns.internal.core.presentation.form.d r21) {
        /*
            r16 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = r17.a()
            r5 = 1
            if (r3 == 0) goto L_0x001a
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0015
            r3 = r5
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 != r5) goto L_0x001a
            r3 = r5
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x01cd
            java.lang.String r3 = r17.a()
            java.lang.String r6 = r17.a()
            java.util.List r6 = com.sumsub.sns.internal.core.presentation.form.model.c.a(r6)
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r6, r8)
            r7.<init>(r8)
            java.util.Iterator r6 = r6.iterator()
            r8 = r3
        L_0x0039:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x01b9
            java.lang.Object r3 = r6.next()
            com.sumsub.sns.internal.core.presentation.form.model.a r3 = (com.sumsub.sns.internal.core.presentation.form.model.a) r3
            com.sumsub.sns.internal.core.presentation.form.model.b r9 = f33832a
            java.lang.String r10 = r3.c()
            java.lang.String r11 = r3.b()
            r14 = r18
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r9 = r9.a(r14, r10, r11)
            java.lang.String r10 = ""
            r11 = 0
            if (r9 == 0) goto L_0x0095
            java.lang.String r12 = r9.e()
            if (r12 != 0) goto L_0x0061
            r12 = r10
        L_0x0061:
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r13 = r9.d()
            java.lang.String r13 = r13.p()
            if (r13 != 0) goto L_0x006c
            r13 = r10
        L_0x006c:
            java.lang.String r12 = r2.a(r12, r13)
            if (r12 == 0) goto L_0x0095
            com.sumsub.sns.internal.core.presentation.form.FieldId r13 = new com.sumsub.sns.internal.core.presentation.form.FieldId
            java.lang.String r15 = r3.c()
            java.lang.String r4 = r3.b()
            r13.<init>(r15, r4)
            boolean r4 = r1.contains(r13)
            if (r4 != 0) goto L_0x0091
            java.lang.String r4 = r3.c()
            boolean r4 = r0.contains(r4)
            if (r4 != 0) goto L_0x0091
            r4 = r5
            goto L_0x0092
        L_0x0091:
            r4 = 0
        L_0x0092:
            if (r4 == 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r12 = r11
        L_0x0096:
            if (r9 == 0) goto L_0x00df
            java.lang.String r4 = r9.e()
            if (r4 != 0) goto L_0x009f
            r4 = r10
        L_0x009f:
            com.sumsub.sns.internal.core.data.source.applicant.remote.k r9 = r9.d()
            java.lang.String r9 = r9.p()
            if (r9 != 0) goto L_0x00aa
            goto L_0x00ab
        L_0x00aa:
            r10 = r9
        L_0x00ab:
            java.util.List r4 = r2.b(r4, r10)
            if (r4 == 0) goto L_0x00df
            boolean r9 = r4.isEmpty()
            r9 = r9 ^ r5
            if (r9 == 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r4 = r11
        L_0x00ba:
            if (r4 == 0) goto L_0x00df
            com.sumsub.sns.internal.core.presentation.form.FieldId r9 = new com.sumsub.sns.internal.core.presentation.form.FieldId
            java.lang.String r10 = r3.c()
            java.lang.String r13 = r3.b()
            r9.<init>(r10, r13)
            boolean r9 = r1.contains(r9)
            if (r9 != 0) goto L_0x00db
            java.lang.String r9 = r3.c()
            boolean r9 = r0.contains(r9)
            if (r9 != 0) goto L_0x00db
            r9 = r5
            goto L_0x00dc
        L_0x00db:
            r9 = 0
        L_0x00dc:
            if (r9 == 0) goto L_0x00df
            goto L_0x00e0
        L_0x00df:
            r4 = r11
        L_0x00e0:
            boolean r9 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.a.C0377a
            if (r9 == 0) goto L_0x0111
            r9 = r3
            com.sumsub.sns.internal.core.presentation.form.model.a$a r9 = (com.sumsub.sns.internal.core.presentation.form.model.a.C0377a) r9
            java.lang.String r10 = r9.d()
            java.lang.CharSequence r10 = kotlin.text.StringsKt__StringsKt.i1(r10)
            java.lang.String r10 = r10.toString()
            boolean r10 = kotlin.jvm.internal.x.b(r12, r10)
            if (r4 == 0) goto L_0x010a
            java.lang.String r9 = r9.d()
            java.lang.CharSequence r9 = kotlin.text.StringsKt__StringsKt.i1(r9)
            java.lang.String r9 = r9.toString()
            boolean r4 = r4.contains(r9)
            goto L_0x010b
        L_0x010a:
            r4 = 0
        L_0x010b:
            if (r10 != 0) goto L_0x0187
            if (r4 == 0) goto L_0x0185
            goto L_0x0187
        L_0x0111:
            boolean r9 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.a.b
            if (r9 == 0) goto L_0x013c
            if (r12 == 0) goto L_0x0120
            int r9 = r12.length()
            if (r9 != 0) goto L_0x011e
            goto L_0x0120
        L_0x011e:
            r9 = 0
            goto L_0x0121
        L_0x0120:
            r9 = r5
        L_0x0121:
            if (r9 != 0) goto L_0x012d
            java.lang.String r9 = "false"
            boolean r9 = kotlin.jvm.internal.x.b(r12, r9)
            if (r9 != 0) goto L_0x012d
            r9 = r5
            goto L_0x012e
        L_0x012d:
            r9 = 0
        L_0x012e:
            if (r4 == 0) goto L_0x0136
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r5
            goto L_0x0137
        L_0x0136:
            r4 = 0
        L_0x0137:
            if (r9 != 0) goto L_0x0187
            if (r4 == 0) goto L_0x0185
            goto L_0x0187
        L_0x013c:
            boolean r9 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.a.c
            if (r9 == 0) goto L_0x01b3
            if (r4 == 0) goto L_0x014b
            boolean r9 = r4.isEmpty()
            if (r9 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            r9 = 0
            goto L_0x014c
        L_0x014b:
            r9 = r5
        L_0x014c:
            if (r9 == 0) goto L_0x0165
            r9 = r3
            com.sumsub.sns.internal.core.presentation.form.model.a$c r9 = (com.sumsub.sns.internal.core.presentation.form.model.a.c) r9
            java.lang.String r9 = r9.d()
            java.lang.CharSequence r9 = kotlin.text.StringsKt__StringsKt.i1(r9)
            java.lang.String r9 = r9.toString()
            boolean r9 = kotlin.jvm.internal.x.b(r12, r9)
            if (r9 != 0) goto L_0x0165
            r9 = r5
            goto L_0x0166
        L_0x0165:
            r9 = 0
        L_0x0166:
            if (r4 == 0) goto L_0x017f
            r10 = r3
            com.sumsub.sns.internal.core.presentation.form.model.a$c r10 = (com.sumsub.sns.internal.core.presentation.form.model.a.c) r10
            java.lang.String r10 = r10.d()
            java.lang.CharSequence r10 = kotlin.text.StringsKt__StringsKt.i1(r10)
            java.lang.String r10 = r10.toString()
            boolean r4 = r4.contains(r10)
            if (r4 != 0) goto L_0x017f
            r4 = r5
            goto L_0x0180
        L_0x017f:
            r4 = 0
        L_0x0180:
            if (r9 != 0) goto L_0x0187
            if (r4 == 0) goto L_0x0185
            goto L_0x0187
        L_0x0185:
            r4 = 0
            goto L_0x0188
        L_0x0187:
            r4 = r5
        L_0x0188:
            if (r8 == 0) goto L_0x01ab
            java.lang.String r9 = r3.a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r10 = 32
            r3.append(r10)
            r3.append(r4)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r3 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r9, r10, r11, r12, r13)
            r8 = r3
            goto L_0x01ac
        L_0x01ab:
            r8 = r11
        L_0x01ac:
            kotlin.Unit r3 = kotlin.Unit.f56620a
            r7.add(r3)
            goto L_0x0039
        L_0x01b3:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01b9:
            com.sumsub.sns.internal.core.presentation.form.model.f r0 = f33833b
            if (r8 == 0) goto L_0x01c7
            java.lang.CharSequence r1 = kotlin.text.StringsKt__StringsKt.i1(r8)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x01c9
        L_0x01c7:
            java.lang.String r1 = "true"
        L_0x01c9:
            boolean r5 = r0.c(r1)
        L_0x01cd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.form.model.b.a(com.sumsub.sns.internal.core.presentation.form.model.FormItem, java.util.List, java.util.Set, java.util.Set, com.sumsub.sns.internal.core.presentation.form.d):boolean");
    }

    public final FormItem a(List<? extends FormItem> list, String str, String str2) {
        T t11;
        boolean z11;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            FormItem formItem = (FormItem) t11;
            if (!x.b(formItem.e(), str) || !x.b(formItem.d().p(), str2)) {
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
        return (FormItem) t11;
    }
}
