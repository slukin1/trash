package com.sumsub.sns.presentation.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.widget.SNSApplicantDataFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.autocompletePhone.ValidationListener;
import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.h;
import d10.l;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40153a;

        static {
            int[] iArr = new int[FieldName.values().length];
            iArr[FieldName.gender.ordinal()] = 1;
            iArr[FieldName.country.ordinal()] = 2;
            iArr[FieldName.countryOfBirth.ordinal()] = 3;
            iArr[FieldName.nationality.ordinal()] = 4;
            iArr[FieldName.state.ordinal()] = 5;
            iArr[FieldName.stateOfBirth.ordinal()] = 6;
            f40153a = iArr;
        }
    }

    public static final class b extends Lambda implements l<h.e.a.C0341a, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f40154a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.e f40155b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b bVar, h.e eVar) {
            super(1);
            this.f40154a = bVar;
            this.f40155b = eVar;
        }

        public final void a(h.e.a.C0341a aVar) {
            b bVar = this.f40154a;
            if (bVar != null) {
                bVar.a((h) this.f40155b, aVar);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h.e.a.C0341a) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.sumsub.sns.presentation.utils.c$c  reason: collision with other inner class name */
    public static final class C0541c extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f40156a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.d f40157b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0541c(b bVar, h.d dVar) {
            super(1);
            this.f40156a = bVar;
            this.f40157b = dVar;
        }

        public final void a(String str) {
            b bVar = this.f40156a;
            if (bVar != null) {
                bVar.a((h) this.f40157b, (CharSequence) str);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements l<SNSCountryPicker.CountryItem, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f40158a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.d f40159b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, h.d dVar) {
            super(1);
            this.f40158a = bVar;
            this.f40159b = dVar;
        }

        public final void a(SNSCountryPicker.CountryItem countryItem) {
            b bVar = this.f40158a;
            if (bVar != null) {
                bVar.a((h) this.f40159b, countryItem);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SNSCountryPicker.CountryItem) obj);
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements l<SNSCountryPicker.CountryItem, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f40160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.d f40161b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, h.d dVar) {
            super(1);
            this.f40160a = bVar;
            this.f40161b = dVar;
        }

        public final void a(SNSCountryPicker.CountryItem countryItem) {
            b bVar = this.f40160a;
            if (bVar != null) {
                bVar.a((h) this.f40161b, countryItem);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SNSCountryPicker.CountryItem) obj);
            return Unit.f56620a;
        }
    }

    public static final class f implements ValidationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f40162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h.d f40163b;

        public f(b bVar, h.d dVar) {
            this.f40162a = bVar;
            this.f40163b = dVar;
        }

        public void onValidate(boolean z11, boolean z12) {
            b bVar = this.f40162a;
            if (bVar != null) {
                bVar.a(this.f40163b, z11, z12);
            }
        }
    }

    public static final class g extends Lambda implements l<View, com.sumsub.sns.internal.domain.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f40164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.domain.c f40165b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar) {
            super(1);
            this.f40164a = viewGroup;
            this.f40165b = cVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.domain.a invoke(View view) {
            SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView = view instanceof SNSApplicantDataBaseFieldView ? (SNSApplicantDataBaseFieldView) view : null;
            if (sNSApplicantDataBaseFieldView != null) {
                return c.b(sNSApplicantDataBaseFieldView, this.f40164a, this.f40165b);
            }
            return null;
        }
    }

    public static final String b(ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar) {
        return a(FieldName.country, viewGroup, cVar);
    }

    public static final String c(ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar) {
        return a(FieldName.countryOfBirth, viewGroup, cVar);
    }

    public static final View a(h hVar, Context context, b bVar, com.sumsub.sns.internal.domain.c cVar, com.sumsub.sns.internal.domain.a aVar, String str, String str2) {
        if (hVar instanceof h.d) {
            return a((h.d) hVar, context, bVar, cVar, aVar, str, str2);
        }
        if (hVar instanceof h.c) {
            return a((h.c) hVar, context, aVar, str2);
        }
        if (hVar instanceof h.e) {
            return a((h.e) hVar, context, bVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final com.sumsub.sns.internal.domain.a b(SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView, ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar) {
        String str;
        String str2;
        Set entrySet;
        String str3;
        Set entrySet2;
        String str4;
        Object tag = sNSApplicantDataBaseFieldView.getTag();
        T t11 = null;
        if (tag instanceof h.d) {
            FieldName q11 = ((h.d) tag).q();
            switch (q11 == null ? -1 : a.f40153a[q11.ordinal()]) {
                case 1:
                    Iterator<T> it2 = cVar.j().entrySet().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            T next = it2.next();
                            if (x.b(((Map.Entry) next).getValue(), sNSApplicantDataBaseFieldView.getValue())) {
                                t11 = next;
                            }
                        }
                    }
                    Map.Entry entry = (Map.Entry) t11;
                    if (entry == null || (str = (String) entry.getKey()) == null) {
                        return new com.sumsub.sns.internal.domain.a((h) tag, "", (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                    }
                    return new com.sumsub.sns.internal.domain.a((h) tag, str, (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                case 2:
                case 3:
                case 4:
                    Iterator<T> it3 = cVar.h().entrySet().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            T next2 = it3.next();
                            if (x.b(((Map.Entry) next2).getValue(), sNSApplicantDataBaseFieldView.getValue())) {
                                t11 = next2;
                            }
                        }
                    }
                    Map.Entry entry2 = (Map.Entry) t11;
                    if (entry2 == null || (str2 = (String) entry2.getKey()) == null) {
                        return new com.sumsub.sns.internal.domain.a((h) tag, "", (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                    }
                    return new com.sumsub.sns.internal.domain.a((h) tag, str2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                case 5:
                    Map map = cVar.i().get(b(viewGroup, cVar));
                    if (!(map == null || (entrySet = map.entrySet()) == null)) {
                        Iterator it4 = entrySet.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                T next3 = it4.next();
                                if (x.b(((Map.Entry) next3).getValue(), sNSApplicantDataBaseFieldView.getValue())) {
                                    t11 = next3;
                                }
                            }
                        }
                        Map.Entry entry3 = (Map.Entry) t11;
                        if (!(entry3 == null || (str3 = (String) entry3.getKey()) == null)) {
                            return new com.sumsub.sns.internal.domain.a((h) tag, str3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                        }
                    }
                    return new com.sumsub.sns.internal.domain.a((h) tag, sNSApplicantDataBaseFieldView.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                case 6:
                    Map map2 = cVar.i().get(c(viewGroup, cVar));
                    if (!(map2 == null || (entrySet2 = map2.entrySet()) == null)) {
                        Iterator it5 = entrySet2.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                T next4 = it5.next();
                                if (x.b(((Map.Entry) next4).getValue(), sNSApplicantDataBaseFieldView.getValue())) {
                                    t11 = next4;
                                }
                            }
                        }
                        Map.Entry entry4 = (Map.Entry) t11;
                        if (!(entry4 == null || (str4 = (String) entry4.getKey()) == null)) {
                            return new com.sumsub.sns.internal.domain.a((h) tag, str4, (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                        }
                    }
                    return new com.sumsub.sns.internal.domain.a((h) tag, sNSApplicantDataBaseFieldView.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
                default:
                    return new com.sumsub.sns.internal.domain.a((h) tag, sNSApplicantDataBaseFieldView.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
            }
        } else if (tag instanceof h.c) {
            return new com.sumsub.sns.internal.domain.a((h) tag, sNSApplicantDataBaseFieldView.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
        } else {
            if (tag instanceof h.e) {
                return new com.sumsub.sns.internal.domain.a((h) tag, sNSApplicantDataBaseFieldView.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 28, (r) null);
            }
            return null;
        }
    }

    public static final kotlin.sequences.g<com.sumsub.sns.internal.domain.a> a(ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar) {
        return SequencesKt___SequencesKt.t(ViewGroupKt.a(viewGroup), new g(viewGroup, cVar));
    }

    public static final Unit a(ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar, Bundle bundle) {
        String str;
        FieldName q11;
        if (cVar == null) {
            return null;
        }
        for (com.sumsub.sns.internal.domain.a next : a(viewGroup, cVar)) {
            h g11 = next.g();
            h.d dVar = g11 instanceof h.d ? (h.d) g11 : null;
            if (dVar == null || (q11 = dVar.q()) == null || (str = q11.getValue()) == null) {
                h g12 = next.g();
                h.c cVar2 = g12 instanceof h.c ? (h.c) g12 : null;
                str = cVar2 != null ? cVar2.i() : null;
            }
            bundle.putString(str, next.j());
        }
        return Unit.f56620a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.sumsub.sns.core.widget.SNSSubtitle2TextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView} */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View a(com.sumsub.sns.internal.core.data.model.h.e r7, android.content.Context r8, com.sumsub.sns.presentation.utils.b r9) {
        /*
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.model.h.e.a
            if (r0 == 0) goto L_0x0041
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView r0 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r0
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            r8 = r7
            com.sumsub.sns.internal.core.data.model.h$e$a r8 = (com.sumsub.sns.internal.core.data.model.h.e.a) r8
            java.util.List r1 = r8.h()
            r0.setItems(r1)
            java.util.List r1 = r8.h()
            int r2 = r8.g()
            java.lang.Object r1 = r1.get(r2)
            com.sumsub.sns.internal.core.data.model.h$e$a$a r1 = (com.sumsub.sns.internal.core.data.model.h.e.a.C0341a) r1
            java.lang.String r1 = r1.d()
            r0.setValue(r1)
            java.lang.String r8 = r8.i()
            r0.setLabel(r8)
            com.sumsub.sns.presentation.utils.c$b r8 = new com.sumsub.sns.presentation.utils.c$b
            r8.<init>(r9, r7)
            r0.setOnSelectedCallback(r8)
            r0.disableInput()
            goto L_0x0072
        L_0x0041:
            boolean r9 = r7 instanceof com.sumsub.sns.internal.core.data.model.h.e.b
            if (r9 == 0) goto L_0x0076
            com.sumsub.sns.core.widget.SNSSubtitle2TextView r9 = new com.sumsub.sns.core.widget.SNSSubtitle2TextView
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            r0 = r9
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8 = 12
            int r8 = com.sumsub.sns.internal.core.common.i.a((int) r8)
            int r0 = r9.getPaddingLeft()
            int r1 = r9.getPaddingRight()
            int r2 = r9.getPaddingBottom()
            r9.setPadding(r0, r8, r1, r2)
            r8 = r7
            com.sumsub.sns.internal.core.data.model.h$e$b r8 = (com.sumsub.sns.internal.core.data.model.h.e.b) r8
            java.lang.CharSequence r8 = r8.e()
            r9.setText(r8)
            r0 = r9
        L_0x0072:
            r0.setTag(r7)
            return r0
        L_0x0076:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.utils.c.a(com.sumsub.sns.internal.core.data.model.h$e, android.content.Context, com.sumsub.sns.presentation.utils.b):android.view.View");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: java.util.List<java.lang.String>} */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.View, com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r9v8, types: [com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem] */
    /* JADX WARNING: type inference failed for: r4v44 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r7v22, types: [com.sumsub.sns.core.widget.SNSApplicantDataFieldView] */
    /* JADX WARNING: type inference failed for: r7v23, types: [com.sumsub.sns.core.widget.SNSApplicantDataFieldView] */
    /* JADX WARNING: type inference failed for: r6v37, types: [com.sumsub.sns.core.widget.SNSApplicantDataFieldView] */
    /* JADX WARNING: type inference failed for: r7v24, types: [com.sumsub.sns.core.widget.SNSApplicantDataFieldView] */
    /* JADX WARNING: type inference failed for: r7v25, types: [com.sumsub.sns.core.widget.SNSApplicantDataFieldView] */
    /* JADX WARNING: type inference failed for: r10v28, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView] */
    /* JADX WARNING: type inference failed for: r10v29, types: [com.sumsub.sns.core.widget.SNSApplicantDataFieldView] */
    /* JADX WARNING: type inference failed for: r10v30, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView] */
    /* JADX WARNING: type inference failed for: r9v23, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView] */
    /* JADX WARNING: type inference failed for: r9v24, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView] */
    /* JADX WARNING: type inference failed for: r9v25, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView] */
    /* JADX WARNING: type inference failed for: r9v26, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView] */
    /* JADX WARNING: type inference failed for: r9v27, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView] */
    /* JADX WARNING: type inference failed for: r6v38, types: [com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView a(com.sumsub.sns.internal.core.data.model.h.d r21, android.content.Context r22, com.sumsub.sns.presentation.utils.b r23, com.sumsub.sns.internal.domain.c r24, com.sumsub.sns.internal.domain.a r25, java.lang.String r26, java.lang.String r27) {
        /*
            r0 = r21
            r1 = r23
            r2 = r26
            r3 = r27
            boolean r4 = r21.y()
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x004a
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView r2 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            r6 = r2
            r7 = r22
            r6.<init>(r7, r8, r9, r10, r11, r12)
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r6 = 5
            r7 = -1
            r4.add(r6, r7)
            kotlin.Unit r6 = kotlin.Unit.f56620a
            com.google.android.material.datepicker.CalendarConstraints$Builder r6 = new com.google.android.material.datepicker.CalendarConstraints$Builder
            r6.<init>()
            java.util.Date r4 = r4.getTime()
            long r7 = r4.getTime()
            com.google.android.material.datepicker.DateValidatorPointBackward r4 = com.google.android.material.datepicker.DateValidatorPointBackward.before(r7)
            com.google.android.material.datepicker.CalendarConstraints$Builder r4 = r6.setValidator(r4)
            com.google.android.material.datepicker.CalendarConstraints r4 = r4.build()
            r2.setConstraints(r4)
            r2.setValue(r3)
            goto L_0x04e3
        L_0x004a:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.gender
            r7 = 0
            r8 = 10
            if (r4 != r6) goto L_0x00b1
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView r2 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r2
            r10 = r22
            r9.<init>(r10, r11, r12, r13, r14)
            java.util.Map r4 = r24.j()
            java.util.Collection r4 = r4.values()
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r4, r8)
            r6.<init>(r8)
            java.util.Iterator r4 = r4.iterator()
        L_0x0076:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0097
            java.lang.Object r8 = r4.next()
            int r9 = r7 + 1
            if (r7 >= 0) goto L_0x0087
            kotlin.collections.CollectionsKt__CollectionsKt.t()
        L_0x0087:
            java.lang.String r8 = (java.lang.String) r8
            com.sumsub.sns.internal.core.data.model.h$e$a$a r10 = new com.sumsub.sns.internal.core.data.model.h$e$a$a
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r10.<init>(r7, r8)
            r6.add(r10)
            r7 = r9
            goto L_0x0076
        L_0x0097:
            r2.setItems(r6)
            java.util.Map r4 = r24.j()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x00a7
            r3 = r5
        L_0x00a7:
            r2.setValue(r3)
            r2.disableInput()
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x00b1:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.state
            if (r4 != r6) goto L_0x0124
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView r4 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r4
            r10 = r22
            r9.<init>(r10, r11, r12, r13, r14)
            java.util.Map r6 = r24.i()
            java.lang.Object r2 = r6.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x0105
            java.util.Collection r2 = r2.values()
            if (r2 == 0) goto L_0x0105
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r2, r8)
            r6.<init>(r8)
            java.util.Iterator r2 = r2.iterator()
        L_0x00e4:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x010a
            java.lang.Object r8 = r2.next()
            int r9 = r7 + 1
            if (r7 >= 0) goto L_0x00f5
            kotlin.collections.CollectionsKt__CollectionsKt.t()
        L_0x00f5:
            java.lang.String r8 = (java.lang.String) r8
            com.sumsub.sns.internal.core.data.model.h$e$a$a r10 = new com.sumsub.sns.internal.core.data.model.h$e$a$a
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r10.<init>(r7, r8)
            r6.add(r10)
            r7 = r9
            goto L_0x00e4
        L_0x0105:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x010a:
            r4.setItems(r6)
            r4.setValue(r3)
            java.util.List r2 = r4.getItems()
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x011f
            r4.disableInput()
        L_0x011f:
            kotlin.Unit r2 = kotlin.Unit.f56620a
        L_0x0121:
            r2 = r4
            goto L_0x04e3
        L_0x0124:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.stateOfBirth
            if (r4 != r6) goto L_0x013f
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView r2 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r2
            r10 = r22
            r9.<init>(r10, r11, r12, r13, r14)
            r2.setValue(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x013f:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.nationality
            if (r4 != r6) goto L_0x0176
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView r2 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r9 = r2
            r10 = r22
            r9.<init>(r10, r11, r12, r13, r14, r15)
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem$Companion r4 = com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem.Companion
            java.util.Map r6 = r24.h()
            java.util.List r4 = r4.fromMap(r6)
            r2.setItems(r4)
            java.util.Map r4 = r24.h()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x016f
            r3 = r5
        L_0x016f:
            r2.setValue(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x0176:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.countryOfBirth
            if (r4 != r6) goto L_0x01b5
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView r2 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r9 = r2
            r10 = r22
            r9.<init>(r10, r11, r12, r13, r14, r15)
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem$Companion r4 = com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem.Companion
            java.util.Map r6 = r24.h()
            java.util.List r4 = r4.fromMap(r6)
            r2.setItems(r4)
            java.util.Map r4 = r24.h()
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x01a6
            r3 = r5
        L_0x01a6:
            r2.setValue(r3)
            com.sumsub.sns.presentation.utils.c$d r3 = new com.sumsub.sns.presentation.utils.c$d
            r3.<init>(r1, r0)
            r2.setOnCountrySelectedCallback(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x01b5:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.country
            r9 = 0
            if (r4 != r6) goto L_0x02a6
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView r2 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r2
            r11 = r22
            r10.<init>(r11, r12, r13, r14, r15, r16)
            com.sumsub.sns.internal.ff.a r4 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r4 = r4.i()
            boolean r4 = r4.g()
            if (r4 != 0) goto L_0x0281
            com.sumsub.sns.internal.core.data.model.g r4 = r24.g()
            if (r4 == 0) goto L_0x022a
            com.sumsub.sns.internal.core.data.model.g$c r4 = r4.I()
            if (r4 == 0) goto L_0x022a
            java.util.List r4 = r4.i()
            if (r4 == 0) goto L_0x022a
            boolean r6 = r4.isEmpty()
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x01f4
            goto L_0x01f5
        L_0x01f4:
            r4 = r9
        L_0x01f5:
            if (r4 == 0) goto L_0x022a
            java.util.Map r6 = r24.h()
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0208:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0285
            java.lang.Object r8 = r6.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            boolean r9 = r4.contains(r9)
            if (r9 == 0) goto L_0x0208
            java.lang.Object r9 = r8.getKey()
            java.lang.Object r8 = r8.getValue()
            r7.put(r9, r8)
            goto L_0x0208
        L_0x022a:
            com.sumsub.sns.internal.core.data.model.g r4 = r24.g()
            if (r4 == 0) goto L_0x027c
            com.sumsub.sns.internal.core.data.model.g$c r4 = r4.I()
            if (r4 == 0) goto L_0x027c
            java.util.List r4 = r4.h()
            if (r4 == 0) goto L_0x027c
            boolean r6 = r4.isEmpty()
            r6 = r6 ^ 1
            if (r6 == 0) goto L_0x0245
            r9 = r4
        L_0x0245:
            if (r9 == 0) goto L_0x027c
            java.util.Map r4 = r24.h()
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0258:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0285
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r8 = r6.getKey()
            boolean r8 = r9.contains(r8)
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x0258
            java.lang.Object r8 = r6.getKey()
            java.lang.Object r6 = r6.getValue()
            r7.put(r8, r6)
            goto L_0x0258
        L_0x027c:
            java.util.Map r7 = r24.h()
            goto L_0x0285
        L_0x0281:
            java.util.Map r7 = r24.h()
        L_0x0285:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem$Companion r4 = com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem.Companion
            java.util.List r4 = r4.fromMap(r7)
            r2.setItems(r4)
            java.lang.Object r3 = r7.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0297
            r3 = r5
        L_0x0297:
            r2.setValue(r3)
            com.sumsub.sns.presentation.utils.c$e r3 = new com.sumsub.sns.presentation.utils.c$e
            r3.<init>(r1, r0)
            r2.setOnCountrySelectedCallback(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x02a6:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.email
            if (r4 != r6) goto L_0x02d0
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r2 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r2
            r11 = r22
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r2.setValue(r3)
            android.widget.EditText r3 = r2.getEditText()
            if (r3 != 0) goto L_0x02c7
            goto L_0x02cc
        L_0x02c7:
            r4 = 32
            r3.setInputType(r4)
        L_0x02cc:
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x02d0:
            com.sumsub.sns.internal.core.data.model.FieldName r4 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r6 = com.sumsub.sns.internal.core.data.model.FieldName.phone
            if (r4 != r6) goto L_0x0402
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView r4 = new com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r4
            r11 = r22
            r10.<init>(r11, r12, r13, r14, r15, r16)
            java.util.Map r6 = r24.h()
            java.util.Set r6 = r6.entrySet()
            java.util.ArrayList r12 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r6, r8)
            r12.<init>(r8)
            java.util.Iterator r6 = r6.iterator()
        L_0x02fc:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x031d
            java.lang.Object r8 = r6.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r10 = new com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem
            java.lang.Object r11 = r8.getKey()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            r10.<init>(r11, r8)
            r12.add(r10)
            goto L_0x02fc
        L_0x031d:
            com.sumsub.sns.internal.core.data.model.e r6 = r24.f()
            if (r6 != 0) goto L_0x0325
            goto L_0x03fe
        L_0x0325:
            com.sumsub.sns.internal.core.data.model.e r8 = r24.f()
            if (r8 == 0) goto L_0x03f3
            boolean r8 = r12.isEmpty()
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x03f3
            java.util.Map r8 = r6.B()
            if (r8 == 0) goto L_0x037b
            java.util.Set r8 = r8.entrySet()
            if (r8 == 0) goto L_0x037b
            java.util.Iterator r8 = r8.iterator()
        L_0x0343:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x0377
            java.lang.Object r10 = r8.next()
            r11 = r10
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r14 = 43
            r13.append(r14)
            java.lang.Object r11 = r11.getValue()
            com.sumsub.sns.internal.core.data.model.remote.c r11 = (com.sumsub.sns.internal.core.data.model.remote.c) r11
            java.lang.String r11 = r11.c()
            if (r11 != 0) goto L_0x0368
            java.lang.String r11 = "-1"
        L_0x0368:
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r13 = 2
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.M(r3, r11, r7, r13, r9)
            if (r11 == 0) goto L_0x0343
            goto L_0x0378
        L_0x0377:
            r10 = r9
        L_0x0378:
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            goto L_0x037c
        L_0x037b:
            r10 = r9
        L_0x037c:
            java.util.Iterator r7 = r12.iterator()
        L_0x0380:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x03a2
            java.lang.Object r8 = r7.next()
            r11 = r8
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r11 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r11
            java.lang.String r11 = r11.getCode()
            if (r10 == 0) goto L_0x039a
            java.lang.Object r13 = r10.getKey()
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x039b
        L_0x039a:
            r13 = r9
        L_0x039b:
            boolean r11 = kotlin.jvm.internal.x.b(r11, r13)
            if (r11 == 0) goto L_0x0380
            goto L_0x03a3
        L_0x03a2:
            r8 = r9
        L_0x03a3:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r8 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r8
            if (r8 != 0) goto L_0x03c9
            if (r2 == 0) goto L_0x03c7
            java.util.Iterator r7 = r12.iterator()
        L_0x03ad:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x03c5
            java.lang.Object r8 = r7.next()
            r10 = r8
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r10 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r10
            java.lang.String r10 = r10.getCode()
            boolean r10 = kotlin.jvm.internal.x.b(r10, r2)
            if (r10 == 0) goto L_0x03ad
            r9 = r8
        L_0x03c5:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r9 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r9
        L_0x03c7:
            r13 = r9
            goto L_0x03ca
        L_0x03c9:
            r13 = r8
        L_0x03ca:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r14 = r4.getPhoneInputLayout()
            java.util.Map r15 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.e) r6)
            java.util.Map r16 = com.sumsub.sns.internal.core.data.model.f.o(r6)
            com.sumsub.sns.presentation.utils.c$f r2 = new com.sumsub.sns.presentation.utils.c$f
            r2.<init>(r1, r0)
            r18 = 0
            r19 = 16
            r20 = 0
            r17 = r2
            com.sumsub.sns.core.widget.PhoneKit r10 = com.sumsub.sns.core.widget.autocompletePhone.PhoneKitProviderKt.getPhoneKit$default(r14, r15, r16, r17, r18, r19, r20)
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r11 = r4.getPhoneInputLayout()
            r14 = 0
            r15 = 8
            r16 = 0
            com.sumsub.sns.core.widget.PhoneKit.attachToInput$default(r10, r11, r12, r13, r14, r15, r16)
        L_0x03f3:
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.z(r27)
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x03fe
            r4.setValue(r3)
        L_0x03fe:
            kotlin.Unit r2 = kotlin.Unit.f56620a
            goto L_0x0121
        L_0x0402:
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.firstName
            r6 = 8193(0x2001, float:1.1481E-41)
            if (r2 == r4) goto L_0x04c6
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.lastName
            if (r2 == r4) goto L_0x04c6
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.middleName
            if (r2 != r4) goto L_0x041e
            goto L_0x04c6
        L_0x041e:
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.street
            if (r2 == r4) goto L_0x04a8
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.subStreet
            if (r2 == r4) goto L_0x04a8
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.town
            if (r2 == r4) goto L_0x04a8
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.placeOfBirth
            if (r2 == r4) goto L_0x04a8
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.postCode
            if (r2 != r4) goto L_0x0447
            goto L_0x04a8
        L_0x0447:
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.legalName
            if (r2 != r4) goto L_0x046e
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r2 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r2
            r8 = r22
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r2.setValue(r3)
            android.widget.EditText r3 = r2.getEditText()
            if (r3 != 0) goto L_0x0467
            goto L_0x046a
        L_0x0467:
            r3.setInputType(r6)
        L_0x046a:
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x046e:
            com.sumsub.sns.internal.core.data.model.FieldName r2 = r21.q()
            com.sumsub.sns.internal.core.data.model.FieldName r4 = com.sumsub.sns.internal.core.data.model.FieldName.tin
            if (r2 != r4) goto L_0x0494
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r2 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r2
            r8 = r22
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r2.setValue(r3)
            android.widget.EditText r3 = r2.getEditText()
            if (r3 != 0) goto L_0x048e
            goto L_0x0491
        L_0x048e:
            r3.setInputType(r6)
        L_0x0491:
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x0494:
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r2 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            r6 = r2
            r7 = r22
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r2.setValue(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x04a8:
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r2 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r2
            r8 = r22
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r2.setValue(r3)
            android.widget.EditText r3 = r2.getEditText()
            if (r3 != 0) goto L_0x04c0
            goto L_0x04c3
        L_0x04c0:
            r3.setInputType(r6)
        L_0x04c3:
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x04e3
        L_0x04c6:
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r2 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 14
            r13 = 0
            r7 = r2
            r8 = r22
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r2.setValue(r3)
            android.widget.EditText r3 = r2.getEditText()
            if (r3 != 0) goto L_0x04de
            goto L_0x04e1
        L_0x04de:
            r3.setInputType(r6)
        L_0x04e1:
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x04e3:
            java.lang.CharSequence r3 = r25.i()
            if (r3 == 0) goto L_0x04f7
            boolean r4 = r21.A()
            r6 = r22
            java.lang.CharSequence r3 = com.sumsub.sns.core.common.b.a((java.lang.CharSequence) r3, (android.content.Context) r6, (boolean) r4)
            if (r3 != 0) goto L_0x04f6
            goto L_0x04f7
        L_0x04f6:
            r5 = r3
        L_0x04f7:
            r2.setLabel(r5)
            r2.setTag(r0)
            java.lang.CharSequence r3 = r25.h()
            r2.setHint(r3)
            java.lang.CharSequence r3 = r25.f()
            r2.setExample(r3)
            com.sumsub.sns.presentation.utils.c$c r3 = new com.sumsub.sns.presentation.utils.c$c
            r3.<init>(r1, r0)
            r2.setTextChangedCallback(r3)
            com.sumsub.sns.internal.core.data.model.p r0 = r21.k()
            if (r0 == 0) goto L_0x0520
            android.widget.EditText r1 = r2.getEditText()
            com.sumsub.sns.internal.core.presentation.util.a.a((com.sumsub.sns.internal.core.data.model.p) r0, (android.widget.EditText) r1)
        L_0x0520:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.utils.c.a(com.sumsub.sns.internal.core.data.model.h$d, android.content.Context, com.sumsub.sns.presentation.utils.b, com.sumsub.sns.internal.domain.c, com.sumsub.sns.internal.domain.a, java.lang.String, java.lang.String):com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r9 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.core.widget.SNSApplicantDataFieldView a(com.sumsub.sns.internal.core.data.model.h.c r8, android.content.Context r9, com.sumsub.sns.internal.domain.a r10, java.lang.String r11) {
        /*
            com.sumsub.sns.core.widget.SNSApplicantDataFieldView r7 = new com.sumsub.sns.core.widget.SNSApplicantDataFieldView
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            r0 = r7
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.lang.CharSequence r0 = r10.i()
            if (r0 == 0) goto L_0x0025
            java.lang.Boolean r1 = r8.k()
            if (r1 == 0) goto L_0x001e
            boolean r1 = r1.booleanValue()
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            java.lang.CharSequence r9 = com.sumsub.sns.core.common.b.a((java.lang.CharSequence) r0, (android.content.Context) r9, (boolean) r1)
            if (r9 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r9 = ""
        L_0x0027:
            r7.setLabel(r9)
            r7.setTag(r8)
            java.lang.CharSequence r8 = r10.h()
            r7.setHint(r8)
            r7.setValue(r11)
            java.lang.CharSequence r8 = r10.f()
            r7.setExample(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.utils.c.a(com.sumsub.sns.internal.core.data.model.h$c, android.content.Context, com.sumsub.sns.internal.domain.a, java.lang.String):com.sumsub.sns.core.widget.SNSApplicantDataFieldView");
    }

    public static final String a(FieldName fieldName, ViewGroup viewGroup, com.sumsub.sns.internal.domain.c cVar) {
        View view;
        T t11;
        kotlin.sequences.g<View> a11;
        View view2;
        boolean z11;
        if (viewGroup == null || (a11 = ViewGroupKt.a(viewGroup)) == null) {
            view = null;
        } else {
            Iterator<View> it2 = a11.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    view2 = null;
                    break;
                }
                view2 = it2.next();
                Object tag = view2.getTag();
                h.d dVar = tag instanceof h.d ? (h.d) tag : null;
                if ((dVar != null ? dVar.q() : null) == fieldName) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            view = view2;
        }
        SNSApplicantDataFieldView sNSApplicantDataFieldView = view instanceof SNSApplicantDataFieldView ? (SNSApplicantDataFieldView) view : null;
        Iterator<T> it3 = cVar.h().entrySet().iterator();
        while (true) {
            if (!it3.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it3.next();
            if (x.b(((Map.Entry) t11).getValue(), sNSApplicantDataFieldView != null ? sNSApplicantDataFieldView.getValue() : null)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) t11;
        if (entry != null) {
            return (String) entry.getKey();
        }
        return null;
    }
}
