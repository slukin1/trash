package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.sumsub.sns.internal.core.widget.autocompletePhone.util.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\r\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004R6\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter;", "", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "masks", "", "string", "", "checkCodeChanged", "countryCode", "", "", "formattedNumber", "prependCodeAndPlus", "format", "pureNumberString", "prepareFormattedString", "Lcom/sumsub/sns/core/widget/autocompletePhone/DetectFormatResult;", "targetFormat", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter$FormatResult;", "countryIsoCode", "", "Lcom/sumsub/sns/internal/core/data/model/PhoneCountryCodeWithMasks;", "phoneCountryCodeWithMasks", "Ljava/util/Map;", "getPhoneCountryCodeWithMasks", "()Ljava/util/Map;", "setPhoneCountryCodeWithMasks", "(Ljava/util/Map;)V", "defaultMask", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "getDefaultMask", "()Lcom/sumsub/sns/internal/core/data/model/remote/c;", "<init>", "()V", "FormatResult", "ResultCode", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class PhoneNumberFormatter {
    private final c defaultMask = new c("", CollectionsKt__CollectionsJVMKt.e(n0.h.f32190m));
    private Map<String, c> phoneCountryCodeWithMasks;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter$FormatResult;", "", "formattedString", "", "resultCode", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter$ResultCode;", "(Ljava/lang/String;Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter$ResultCode;)V", "getFormattedString", "()Ljava/lang/String;", "getResultCode", "()Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter$ResultCode;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FormatResult {
        private final String formattedString;
        private final ResultCode resultCode;

        public FormatResult(String str, ResultCode resultCode2) {
            this.formattedString = str;
            this.resultCode = resultCode2;
        }

        public static /* synthetic */ FormatResult copy$default(FormatResult formatResult, String str, ResultCode resultCode2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = formatResult.formattedString;
            }
            if ((i11 & 2) != 0) {
                resultCode2 = formatResult.resultCode;
            }
            return formatResult.copy(str, resultCode2);
        }

        public final String component1() {
            return this.formattedString;
        }

        public final ResultCode component2() {
            return this.resultCode;
        }

        public final FormatResult copy(String str, ResultCode resultCode2) {
            return new FormatResult(str, resultCode2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FormatResult)) {
                return false;
            }
            FormatResult formatResult = (FormatResult) obj;
            return x.b(this.formattedString, formatResult.formattedString) && this.resultCode == formatResult.resultCode;
        }

        public final String getFormattedString() {
            return this.formattedString;
        }

        public final ResultCode getResultCode() {
            return this.resultCode;
        }

        public int hashCode() {
            return (this.formattedString.hashCode() * 31) + this.resultCode.hashCode();
        }

        public String toString() {
            return "FormatResult(formattedString=" + this.formattedString + ", resultCode=" + this.resultCode + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter$ResultCode;", "", "(Ljava/lang/String;I)V", "OK", "CODE_CHANGED", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum ResultCode {
        OK,
        CODE_CHANGED
    }

    private final boolean checkCodeChanged(c cVar, String str) {
        String c11 = cVar.c();
        if (c11 == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (Character.isDigit(charAt)) {
                sb2.append(charAt);
            }
        }
        if (StringsKt__StringsJVMKt.M(sb2.toString(), c11, false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    private final List<Character> prepareFormattedString(String str, String str2) {
        List<Character> u12 = StringsKt___StringsKt.u1(str2);
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (u12.size() > i11) {
                if (str.charAt(i11) == ' ' && u12.get(i11).charValue() != ' ') {
                    u12.add(i11, ' ');
                } else if (str.charAt(i11) == '-' && u12.get(i11).charValue() != '-') {
                    u12.add(i11, '-');
                } else if (str.charAt(i11) == '(' && u12.get(i11).charValue() != '(') {
                    u12.add(i11, '(');
                } else if (str.charAt(i11) == ')' && u12.get(i11).charValue() != ')') {
                    u12.add(i11, ')');
                } else if (str.charAt(i11) == '+' && u12.get(i11).charValue() != '+') {
                    u12.add(i11, '+');
                }
            }
        }
        return u12;
    }

    private final List<Character> prependCodeAndPlus(String str, List<Character> list) {
        boolean isEmpty = list.isEmpty();
        List<Character> L0 = CollectionsKt___CollectionsKt.L0(list);
        boolean z11 = false;
        L0.add(0, '+');
        if (str != null) {
            if (str.length() > 0) {
                z11 = true;
            }
            if (!z11) {
                str = null;
            }
            if (str != null) {
                L0.addAll(1, StringsKt___StringsKt.t1(str));
                if (!isEmpty) {
                    L0.add(str.length() + 1, ' ');
                }
            }
        }
        return L0;
    }

    public final FormatResult format(DetectFormatResult detectFormatResult, String str) {
        return new FormatResult(a.a(prependCodeAndPlus(detectFormatResult.getCountryCode(), prepareFormattedString(detectFormatResult.getMask(), c.Companion.a(detectFormatResult.getCountryCode(), str)))), ResultCode.OK);
    }

    public final c getDefaultMask() {
        return this.defaultMask;
    }

    public final Map<String, c> getPhoneCountryCodeWithMasks() {
        return this.phoneCountryCodeWithMasks;
    }

    public final void setPhoneCountryCodeWithMasks(Map<String, c> map) {
        this.phoneCountryCodeWithMasks = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter.FormatResult format(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x00c9
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r1 = r11.phoneCountryCodeWithMasks
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r1.get(r12)
            com.sumsub.sns.internal.core.data.model.remote.c r1 = (com.sumsub.sns.internal.core.data.model.remote.c) r1
            if (r1 == 0) goto L_0x003f
            boolean r2 = r11.checkCodeChanged(r1, r13)
            if (r2 == 0) goto L_0x003f
            java.lang.String r12 = r1.a(r13)
            com.sumsub.sns.internal.core.data.model.remote.c r13 = r11.defaultMask
            java.util.List r13 = r13.e()
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r13)
            java.lang.String r13 = (java.lang.String) r13
            java.util.List r12 = r11.prepareFormattedString(r13, r12)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult r13 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult
            com.sumsub.sns.internal.core.data.model.remote.c r0 = r11.defaultMask
            java.lang.String r0 = r0.c()
            java.util.List r12 = r11.prependCodeAndPlus(r0, r12)
            java.lang.String r12 = com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(r12)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$ResultCode r0 = com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter.ResultCode.CODE_CHANGED
            r13.<init>(r12, r0)
            return r13
        L_0x003f:
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r1 = r11.phoneCountryCodeWithMasks
            if (r1 == 0) goto L_0x004b
            java.lang.Object r12 = r1.get(r12)
            com.sumsub.sns.internal.core.data.model.remote.c r12 = (com.sumsub.sns.internal.core.data.model.remote.c) r12
            if (r12 != 0) goto L_0x004d
        L_0x004b:
            com.sumsub.sns.internal.core.data.model.remote.c r12 = r11.defaultMask
        L_0x004d:
            java.util.List r1 = r12.e()
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$format$$inlined$sortedBy$1 r2 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$format$$inlined$sortedBy$1
            r2.<init>()
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r1, r2)
            java.lang.String r13 = r12.a(r13)
            java.util.Iterator r2 = r1.iterator()
        L_0x0062:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00a1
            java.lang.Object r3 = r2.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r4.length()
            r7 = r0
        L_0x0079:
            r8 = 1
            if (r7 >= r6) goto L_0x008e
            char r9 = r4.charAt(r7)
            r10 = 35
            if (r9 != r10) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r8 = r0
        L_0x0086:
            if (r8 == 0) goto L_0x008b
            r5.append(r9)
        L_0x008b:
            int r7 = r7 + 1
            goto L_0x0079
        L_0x008e:
            java.lang.String r4 = r5.toString()
            int r4 = r4.length()
            int r5 = r13.length()
            if (r4 < r5) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r8 = r0
        L_0x009e:
            if (r8 == 0) goto L_0x0062
            goto L_0x00a2
        L_0x00a1:
            r3 = 0
        L_0x00a2:
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x00ad
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r1)
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
        L_0x00ad:
            java.util.List r13 = r11.prepareFormattedString(r3, r13)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult r0 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult
            java.lang.String r12 = r12.c()
            if (r12 != 0) goto L_0x00bb
            java.lang.String r12 = ""
        L_0x00bb:
            java.util.List r12 = r11.prependCodeAndPlus(r12, r13)
            java.lang.String r12 = com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(r12)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$ResultCode r13 = com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter.ResultCode.OK
            r0.<init>(r12, r13)
            return r0
        L_0x00c9:
            com.sumsub.sns.internal.core.data.model.remote.c r12 = r11.defaultMask
            java.util.List r12 = r12.e()
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r12)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r13.length()
        L_0x00de:
            if (r0 >= r2) goto L_0x00f0
            char r3 = r13.charAt(r0)
            boolean r4 = java.lang.Character.isDigit(r3)
            if (r4 == 0) goto L_0x00ed
            r1.append(r3)
        L_0x00ed:
            int r0 = r0 + 1
            goto L_0x00de
        L_0x00f0:
            java.lang.String r13 = r1.toString()
            java.util.List r12 = r11.prepareFormattedString(r12, r13)
            com.sumsub.sns.internal.core.data.model.remote.c r13 = r11.defaultMask
            java.lang.String r13 = r13.c()
            java.util.List r12 = r11.prependCodeAndPlus(r13, r12)
            java.lang.String r12 = com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(r12)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$ResultCode r13 = com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter.ResultCode.OK
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult r0 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult
            r0.<init>(r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter.format(java.lang.String, java.lang.String):com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter$FormatResult");
    }
}
