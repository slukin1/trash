package com.sumsub.sns.core.presentation.form;

import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.form.viewutils.c;
import com.sumsub.sns.core.presentation.form.viewutils.d;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.g;
import com.sumsub.sns.internal.core.presentation.util.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.x;

public final class f {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r1v38 */
    /* JADX WARNING: type inference failed for: r1v39 */
    /* JADX WARNING: type inference failed for: r1v40 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView r2, com.sumsub.sns.internal.core.presentation.form.model.FormItem r3, com.sumsub.sns.core.presentation.form.e r4) {
        /*
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.p
            if (r0 == 0) goto L_0x0006
            r0 = 1
            goto L_0x0008
        L_0x0006:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.q
        L_0x0008:
            if (r0 == 0) goto L_0x0019
            android.widget.EditText r2 = r2.getEditText()
            if (r2 == 0) goto L_0x0104
            java.lang.String r3 = r4.a(r3)
            r2.setText(r3)
            goto L_0x0104
        L_0x0019:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.a
            r1 = 0
            if (r0 == 0) goto L_0x003a
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView
            if (r0 == 0) goto L_0x0025
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView) r1
        L_0x0025:
            if (r1 != 0) goto L_0x0029
            goto L_0x0104
        L_0x0029:
            java.lang.String r2 = r4.a(r3)
            if (r2 == 0) goto L_0x0034
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            r1.setChecked(r2)
            goto L_0x0104
        L_0x003a:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.d
            if (r0 == 0) goto L_0x0050
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView
            if (r0 == 0) goto L_0x0045
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataCalendarFieldView) r1
        L_0x0045:
            if (r1 == 0) goto L_0x0104
            java.lang.String r2 = r4.a(r3)
            com.sumsub.sns.core.presentation.form.viewutils.d.a(r1, r2)
            goto L_0x0104
        L_0x0050:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.e
            if (r0 == 0) goto L_0x0066
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView
            if (r0 == 0) goto L_0x005b
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataDateTimeFieldView) r1
        L_0x005b:
            if (r1 == 0) goto L_0x0104
            java.lang.String r2 = r4.a(r3)
            com.sumsub.sns.core.presentation.form.viewutils.c.a(r1, r2)
            goto L_0x0104
        L_0x0066:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.m
            if (r0 == 0) goto L_0x007c
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView
            if (r0 == 0) goto L_0x0071
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView) r1
        L_0x0071:
            if (r1 == 0) goto L_0x0104
            java.lang.String r2 = r4.a(r3)
            com.sumsub.sns.core.presentation.form.viewutils.k.a(r1, r2)
            goto L_0x0104
        L_0x007c:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.n
            if (r0 == 0) goto L_0x0092
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView
            if (r0 == 0) goto L_0x0087
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionFieldView) r1
        L_0x0087:
            if (r1 == 0) goto L_0x0104
            java.lang.String r2 = r4.a(r3)
            com.sumsub.sns.core.presentation.form.viewutils.j.a(r1, r2)
            goto L_0x0104
        L_0x0092:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.c
            if (r0 == 0) goto L_0x00aa
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView
            if (r0 == 0) goto L_0x009d
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView) r1
        L_0x009d:
            if (r1 == 0) goto L_0x0104
            r2 = r3
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$c r2 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.c) r2
            java.lang.String r3 = r4.a(r3)
            com.sumsub.sns.core.presentation.form.viewutils.b.a((com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView) r1, (com.sumsub.sns.internal.core.presentation.form.model.FormItem.c) r2, (java.lang.String) r3)
            goto L_0x0104
        L_0x00aa:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.k
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView
            if (r0 == 0) goto L_0x00b5
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView) r1
        L_0x00b5:
            if (r1 == 0) goto L_0x0104
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$k r3 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.k) r3
            com.sumsub.sns.core.presentation.form.viewutils.h.a((com.sumsub.sns.core.widget.applicantData.SNSApplicantDataPhoneFieldView) r1, (com.sumsub.sns.internal.core.presentation.form.model.FormItem.k) r3, (com.sumsub.sns.core.presentation.form.e) r4)
            goto L_0x0104
        L_0x00bd:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.g
            if (r0 == 0) goto L_0x00d5
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView
            if (r0 == 0) goto L_0x00c8
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView) r1
        L_0x00c8:
            if (r1 == 0) goto L_0x0104
            r2 = r3
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$g r2 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.g) r2
            java.lang.String r3 = r4.a(r3)
            com.sumsub.sns.core.presentation.form.viewutils.e.a((com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView) r1, (com.sumsub.sns.internal.core.presentation.form.model.FormItem.g) r2, (java.lang.String) r3)
            goto L_0x0104
        L_0x00d5:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.j
            if (r0 == 0) goto L_0x00ed
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView
            if (r0 == 0) goto L_0x00e0
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView) r1
        L_0x00e0:
            if (r1 == 0) goto L_0x0104
            r2 = r3
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$j r2 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.j) r2
            java.util.List r3 = r4.b(r3)
            com.sumsub.sns.core.presentation.form.viewutils.g.a(r1, r2, r3)
            goto L_0x0104
        L_0x00ed:
            boolean r0 = r3 instanceof com.sumsub.sns.internal.core.presentation.form.model.FormItem.i
            if (r0 == 0) goto L_0x0104
            boolean r0 = r2 instanceof com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView
            if (r0 == 0) goto L_0x00f8
            r1 = r2
            com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView r1 = (com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView) r1
        L_0x00f8:
            if (r1 == 0) goto L_0x0104
            r2 = r3
            com.sumsub.sns.internal.core.presentation.form.model.FormItem$i r2 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem.i) r2
            java.util.List r3 = r4.b(r3)
            com.sumsub.sns.core.presentation.form.viewutils.f.a((com.sumsub.sns.core.widget.applicantData.SNSApplicantDataFileFieldView) r1, (com.sumsub.sns.internal.core.presentation.form.model.FormItem.i) r2, (java.util.List<java.lang.String>) r3)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.f.a(com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView, com.sumsub.sns.internal.core.presentation.form.model.FormItem, com.sumsub.sns.core.presentation.form.e):void");
    }

    public static final String b(SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView, FormItem formItem) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        List<SNSApplicantDataFileFieldView.Attachment> files;
        SNSApplicantDataFileFieldView.Attachment attachment;
        SNSCountryPicker.CountryItem selectedCountry;
        h.e.a.C0341a selectedItem;
        boolean z18 = true;
        if (formItem instanceof FormItem.p) {
            z11 = true;
        } else {
            z11 = formItem instanceof FormItem.q;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = formItem instanceof FormItem.m;
        }
        Boolean bool = null;
        if (z12) {
            String value = sNSApplicantDataBaseFieldView.getValue();
            if (!StringsKt__StringsJVMKt.z(value)) {
                return value;
            }
            return null;
        } else if (formItem instanceof FormItem.k) {
            SNSApplicantDataPhoneFieldView sNSApplicantDataPhoneFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataPhoneFieldView ? (SNSApplicantDataPhoneFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataPhoneFieldView != null) {
                return com.sumsub.sns.core.presentation.form.viewutils.h.a(sNSApplicantDataPhoneFieldView);
            }
            return null;
        } else if (formItem instanceof FormItem.n) {
            SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataSelectionFieldView ? (SNSApplicantDataSelectionFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataSelectionFieldView == null || (selectedItem = sNSApplicantDataSelectionFieldView.getSelectedItem()) == null) {
                return null;
            }
            return selectedItem.c();
        } else if (formItem instanceof FormItem.a) {
            SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataBoolFieldView ? (SNSApplicantDataBoolFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataBoolFieldView != null) {
                bool = Boolean.valueOf(sNSApplicantDataBoolFieldView.isChecked());
            }
            return String.valueOf(bool);
        } else if (formItem instanceof FormItem.d) {
            SNSApplicantDataCalendarFieldView sNSApplicantDataCalendarFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataCalendarFieldView ? (SNSApplicantDataCalendarFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataCalendarFieldView != null) {
                return d.a(sNSApplicantDataCalendarFieldView);
            }
            return null;
        } else if (formItem instanceof FormItem.e) {
            SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataDateTimeFieldView ? (SNSApplicantDataDateTimeFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataDateTimeFieldView != null) {
                return c.a(sNSApplicantDataDateTimeFieldView);
            }
            return null;
        } else if (formItem instanceof FormItem.c) {
            SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataSelectionCountryFieldView ? (SNSApplicantDataSelectionCountryFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataSelectionCountryFieldView == null || (selectedCountry = sNSApplicantDataSelectionCountryFieldView.getSelectedCountry()) == null) {
                return null;
            }
            return selectedCountry.getCode();
        } else if (formItem instanceof FormItem.g) {
            SNSApplicantDataFileFieldView sNSApplicantDataFileFieldView = sNSApplicantDataBaseFieldView instanceof SNSApplicantDataFileFieldView ? (SNSApplicantDataFileFieldView) sNSApplicantDataBaseFieldView : null;
            if (sNSApplicantDataFileFieldView == null || (files = sNSApplicantDataFileFieldView.getFiles()) == null || (attachment = (SNSApplicantDataFileFieldView.Attachment) CollectionsKt___CollectionsKt.c0(files)) == null) {
                return null;
            }
            return attachment.getId();
        } else {
            if (formItem instanceof FormItem.i) {
                z13 = true;
            } else {
                z13 = formItem instanceof FormItem.j;
            }
            if (z13) {
                z14 = true;
            } else {
                z14 = formItem instanceof FormItem.f;
            }
            if (z14) {
                z15 = true;
            } else {
                z15 = formItem instanceof FormItem.h;
            }
            if (z15) {
                z16 = true;
            } else {
                z16 = formItem instanceof FormItem.l;
            }
            if (z16) {
                z17 = true;
            } else {
                z17 = formItem instanceof FormItem.o;
            }
            if (!z17) {
                z18 = formItem instanceof FormItem.r;
            }
            if (z18) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final List<String> c(SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView, FormItem formItem) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        if (formItem instanceof FormItem.j) {
            List<h.e.a.C0341a> selectedItems = ((SNSApplicantDataMutilselectFieldView) sNSApplicantDataBaseFieldView).getSelectedItems();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(selectedItems, 10));
            for (h.e.a.C0341a c11 : selectedItems) {
                arrayList.add(c11.c());
            }
            return arrayList;
        }
        boolean z25 = true;
        if (formItem instanceof FormItem.i) {
            List<SNSApplicantDataFileFieldView.Attachment> files = ((SNSApplicantDataFileFieldView) sNSApplicantDataBaseFieldView).getFiles();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(files, 10));
            for (SNSApplicantDataFileFieldView.Attachment id2 : files) {
                arrayList2.add(id2.getId());
            }
            if (!arrayList2.isEmpty()) {
                return arrayList2;
            }
        } else {
            if (formItem instanceof FormItem.a) {
                z11 = true;
            } else {
                z11 = formItem instanceof FormItem.c;
            }
            if (z11) {
                z12 = true;
            } else {
                z12 = formItem instanceof FormItem.d;
            }
            if (z12) {
                z13 = true;
            } else {
                z13 = formItem instanceof FormItem.e;
            }
            if (z13) {
                z14 = true;
            } else {
                z14 = formItem instanceof FormItem.g;
            }
            if (z14) {
                z15 = true;
            } else {
                z15 = formItem instanceof FormItem.k;
            }
            if (z15) {
                z16 = true;
            } else {
                z16 = formItem instanceof FormItem.m;
            }
            if (z16) {
                z17 = true;
            } else {
                z17 = formItem instanceof FormItem.n;
            }
            if (z17) {
                z18 = true;
            } else {
                z18 = formItem instanceof FormItem.p;
            }
            if (z18) {
                z19 = true;
            } else {
                z19 = formItem instanceof FormItem.q;
            }
            if (z19) {
                z21 = true;
            } else {
                z21 = formItem instanceof FormItem.h;
            }
            if (z21) {
                z22 = true;
            } else {
                z22 = formItem instanceof FormItem.f;
            }
            if (z22) {
                z23 = true;
            } else {
                z23 = formItem instanceof FormItem.l;
            }
            if (z23) {
                z24 = true;
            } else {
                z24 = formItem instanceof FormItem.o;
            }
            if (!z24) {
                z25 = formItem instanceof FormItem.r;
            }
            if (!z25) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return null;
    }

    public static final boolean a(SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView, FormItem formItem) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        if (formItem instanceof FormItem.p) {
            z11 = true;
        } else {
            z11 = formItem instanceof FormItem.q;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = formItem instanceof FormItem.a;
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = formItem instanceof FormItem.d;
        }
        if (z13) {
            z14 = true;
        } else {
            z14 = formItem instanceof FormItem.e;
        }
        if (z14) {
            z15 = true;
        } else {
            z15 = formItem instanceof FormItem.c;
        }
        if (z15) {
            z16 = true;
        } else {
            z16 = formItem instanceof FormItem.n;
        }
        if (z16) {
            if (g.a(formItem.d(), b(sNSApplicantDataBaseFieldView, formItem)) == null) {
                return true;
            }
            return false;
        } else if (formItem instanceof FormItem.k) {
            return com.sumsub.sns.core.presentation.form.viewutils.h.a((SNSApplicantDataPhoneFieldView) sNSApplicantDataBaseFieldView, (FormItem.k) formItem);
        } else {
            if (formItem instanceof FormItem.m) {
                String b11 = b(sNSApplicantDataBaseFieldView, formItem);
                boolean z17 = b11 == null || b11.length() == 0;
                if (!x.b(formItem.d().v(), Boolean.TRUE) || !z17) {
                    return true;
                }
            } else if (formItem instanceof FormItem.j) {
                List<String> c11 = c(sNSApplicantDataBaseFieldView, formItem);
                boolean z18 = c11 == null || c11.isEmpty();
                if (!x.b(formItem.d().v(), Boolean.TRUE) || !z18) {
                    return true;
                }
            } else if (formItem instanceof FormItem.g) {
                String b12 = b(sNSApplicantDataBaseFieldView, formItem);
                if (!x.b(formItem.d().v(), Boolean.TRUE) || b12 != null) {
                    return true;
                }
            } else if (!(formItem instanceof FormItem.i)) {
                return true;
            } else {
                List<String> c12 = c(sNSApplicantDataBaseFieldView, formItem);
                if (c12 == null) {
                    c12 = CollectionsKt__CollectionsKt.k();
                }
                if (!com.sumsub.sns.core.presentation.form.viewutils.f.a(sNSApplicantDataBaseFieldView, (FormItem.i) formItem) || a.a(g.a(formItem.d()), String.valueOf(c12.size()))) {
                    return true;
                }
            }
            return false;
        }
    }
}
