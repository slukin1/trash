package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.sumsub.sns.internal.log.a;
import d10.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011RJ\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001f2\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001dj\u0002`\u001f8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR$\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020(8\u0002@BX\u000e¢\u0006\f\n\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@BX\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0011\"\u0004\b-\u0010\u0015R\u0014\u0010/\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberViewController;", "", "", "value", "Lcom/sumsub/sns/core/widget/autocompletePhone/DetectFormatResult;", "detectFormat", "countryIsoCode", "", "fixedCountry", "", "onCountrySelected", "text", "onTextChanged", "", "number", "validate", "applicantCountry", "Ljava/lang/String;", "getApplicantCountry", "()Ljava/lang/String;", "setApplicantCountry", "(Ljava/lang/String;)V", "allowUndefinedCountry", "Z", "getAllowUndefinedCountry", "()Z", "setAllowUndefinedCountry", "(Z)V", "logTag", "", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "Lcom/sumsub/sns/internal/core/data/model/PhoneCountryCodeWithMasks;", "phoneCountryCodeWithMasks", "Ljava/util/Map;", "getPhoneCountryCodeWithMasks", "()Ljava/util/Map;", "setPhoneCountryCodeWithMasks", "(Ljava/util/Map;)V", "getFixedCountry", "setFixedCountry", "Lcom/sumsub/sns/core/widget/autocompletePhone/ViewState;", "viewState", "Lcom/sumsub/sns/core/widget/autocompletePhone/ViewState;", "setViewState", "(Lcom/sumsub/sns/core/widget/autocompletePhone/ViewState;)V", "setCountryIsoCode", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter;", "formatter", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberFormatter;", "getCurrentMasks", "()Lcom/sumsub/sns/internal/core/data/model/remote/c;", "currentMasks", "Lkotlin/Function1;", "onViewStateUpdated", "Ld10/l;", "getOnViewStateUpdated", "()Ld10/l;", "setOnViewStateUpdated", "(Ld10/l;)V", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class PhoneNumberViewController {
    private boolean allowUndefinedCountry;
    private String applicantCountry;
    private String countryIsoCode;
    private boolean fixedCountry;
    private final PhoneNumberFormatter formatter = new PhoneNumberFormatter();
    private final String logTag = ("SNSPhoneNumberKit(" + i.a((Object) this) + ')');
    private l<? super ViewState, Unit> onViewStateUpdated;
    private Map<String, c> phoneCountryCodeWithMasks = MapsKt__MapsKt.h();
    private ViewState viewState = new ViewState("", (String) null, (CharSequence) null, 4, (r) null);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult detectFormat(java.lang.String r29) {
        /*
            r28 = this;
            r0 = r28
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r29.length()
            r3 = 0
            r4 = r3
        L_0x000d:
            if (r4 >= r2) goto L_0x0021
            r5 = r29
            char r6 = r5.charAt(r4)
            boolean r7 = java.lang.Character.isDigit(r6)
            if (r7 == 0) goto L_0x001e
            r1.append(r6)
        L_0x001e:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0021:
            java.lang.String r1 = r1.toString()
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r2 = r0.phoneCountryCodeWithMasks
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0034:
            boolean r5 = r2.hasNext()
            r6 = 2
            r7 = 0
            if (r5 == 0) goto L_0x0062
            java.lang.Object r5 = r2.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r8 = r5.getValue()
            com.sumsub.sns.internal.core.data.model.remote.c r8 = (com.sumsub.sns.internal.core.data.model.remote.c) r8
            java.lang.String r8 = r8.c()
            if (r8 == 0) goto L_0x0053
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.M(r1, r8, r3, r6, r7)
            goto L_0x0054
        L_0x0053:
            r6 = r3
        L_0x0054:
            if (r6 == 0) goto L_0x0034
            java.lang.Object r6 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            r4.put(r6, r5)
            goto L_0x0034
        L_0x0062:
            java.util.Set r2 = r4.keySet()
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$$inlined$sortedByDescending$1 r4 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$$inlined$sortedByDescending$1
            r4.<init>(r0)
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r2, r4)
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r2)
            boolean r4 = r0.fixedCountry
            java.lang.String r5 = "Required value was null."
            if (r4 == 0) goto L_0x009a
            java.lang.String r4 = r0.countryIsoCode
            if (r4 == 0) goto L_0x009a
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r8 = r0.phoneCountryCodeWithMasks
            java.lang.Object r4 = r8.get(r4)
            if (r4 == 0) goto L_0x009a
            r2.clear()
            java.lang.String r4 = r0.countryIsoCode
            if (r4 == 0) goto L_0x0090
            r2.add(r4)
            goto L_0x009a
        L_0x0090:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r5.toString()
            r1.<init>(r2)
            throw r1
        L_0x009a:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r10 = r2.iterator()
        L_0x00ad:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0250
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r13 = r0.phoneCountryCodeWithMasks
            java.lang.Object r13 = r13.get(r11)
            com.sumsub.sns.internal.core.data.model.remote.c r13 = (com.sumsub.sns.internal.core.data.model.remote.c) r13
            if (r13 == 0) goto L_0x0249
            java.lang.String r14 = r13.c()
            if (r14 == 0) goto L_0x023f
            int r15 = r14.length()
            java.lang.String r15 = kotlin.text.StringsKt___StringsKt.l1(r1, r15)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r17 = r13.e()
            java.util.Iterator r17 = r17.iterator()
        L_0x00e8:
            boolean r18 = r17.hasNext()
            if (r18 == 0) goto L_0x016d
            java.lang.Object r18 = r17.next()
            r7 = r18
            java.lang.String r7 = (java.lang.String) r7
            r18 = r1
            java.lang.String r1 = com.sumsub.sns.core.widget.autocompletePhone.StringExtensionsKt.getMaskNumbers(r7)
            r19 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r20 = r2
            int r2 = r7.length()
            r21 = r8
            r8 = 0
        L_0x010c:
            if (r8 >= r2) goto L_0x0122
            r22 = r2
            char r2 = r7.charAt(r8)
            boolean r23 = java.lang.Character.isDigit(r2)
            if (r23 == 0) goto L_0x011d
            r10.append(r2)
        L_0x011d:
            int r8 = r8 + 1
            r2 = r22
            goto L_0x010c
        L_0x0122:
            java.lang.String r2 = r10.toString()
            int r8 = r2.length()
            if (r8 != 0) goto L_0x012e
            r8 = 1
            goto L_0x012f
        L_0x012e:
            r8 = 0
        L_0x012f:
            if (r8 == 0) goto L_0x0143
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r1 = new com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult
            r1.<init>(r11, r14, r7)
            r6.add(r1)
            r1 = r18
            r10 = r19
            r2 = r20
            r8 = r21
            r7 = 0
            goto L_0x00e8
        L_0x0143:
            r16 = r6
            r6 = 0
            r8 = 2
            r10 = 0
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.M(r1, r2, r6, r8, r10)
            if (r1 == 0) goto L_0x0160
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r1 = new com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult
            r1.<init>(r11, r14, r7)
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.M(r15, r2, r6, r8, r10)
            if (r2 == 0) goto L_0x015d
            r3.add(r1)
            goto L_0x0160
        L_0x015d:
            r12.add(r1)
        L_0x0160:
            r7 = r10
            r6 = r16
            r1 = r18
            r10 = r19
            r2 = r20
            r8 = r21
            goto L_0x00e8
        L_0x016d:
            r18 = r1
            r20 = r2
            r16 = r6
            r21 = r8
            r19 = r10
            r6 = 0
            r8 = 2
            r10 = r7
            boolean r1 = r12.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x01db
            int r1 = r12.size()
            java.util.List r2 = r13.e()
            int r2 = r2.size()
            if (r1 != r2) goto L_0x01db
            com.sumsub.sns.internal.log.a r22 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = r0.logTag
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "detectFormat: dropping country "
            r2.append(r3)
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r12)
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r3 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r3
            java.lang.String r3 = r3.getCountryIsoCode()
            r2.append(r3)
            java.lang.String r3 = " from variants"
            r2.append(r3)
            java.lang.String r24 = r2.toString()
            r25 = 0
            r26 = 4
            r27 = 0
            r23 = r1
            com.sumsub.log.logger.a.d(r22, r23, r24, r25, r26, r27)
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r12)
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r1 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r1
            java.lang.String r1 = r1.getCountryIsoCode()
            if (r1 == 0) goto L_0x01d1
            r9.add(r1)
            r1 = r21
            goto L_0x0234
        L_0x01d1:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r5.toString()
            r1.<init>(r2)
            throw r1
        L_0x01db:
            r4.addAll(r3)
            boolean r1 = r16.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x022d
            int r1 = r16.size()
            if (r1 <= r2) goto L_0x01f7
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$lambda-14$lambda-13$$inlined$sortBy$1 r1 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$lambda-14$lambda-13$$inlined$sortBy$1
            r1.<init>()
            r2 = r16
            kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.z(r2, r1)
            goto L_0x01f9
        L_0x01f7:
            r2 = r16
        L_0x01f9:
            java.util.Iterator r1 = r2.iterator()
        L_0x01fd:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x021a
            java.lang.Object r3 = r1.next()
            r7 = r3
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r7 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r7
            int r7 = r7.getMaskLength()
            int r11 = r15.length()
            if (r7 < r11) goto L_0x0216
            r7 = 1
            goto L_0x0217
        L_0x0216:
            r7 = r6
        L_0x0217:
            if (r7 == 0) goto L_0x01fd
            goto L_0x021b
        L_0x021a:
            r3 = r10
        L_0x021b:
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r3 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r3
            if (r3 != 0) goto L_0x0226
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r2)
            r3 = r1
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r3 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r3
        L_0x0226:
            r2.clear()
            r2.add(r3)
            goto L_0x022f
        L_0x022d:
            r2 = r16
        L_0x022f:
            r1 = r21
            r1.addAll(r2)
        L_0x0234:
            kotlin.Unit r2 = kotlin.Unit.f56620a
            r3 = r6
            r6 = r8
            r7 = r10
            r10 = r19
            r2 = r20
            r8 = r1
            goto L_0x024c
        L_0x023f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r5.toString()
            r1.<init>(r2)
            throw r1
        L_0x0249:
            r18 = r1
            r1 = r8
        L_0x024c:
            r1 = r18
            goto L_0x00ad
        L_0x0250:
            r20 = r2
            r10 = r7
            r1 = r8
            java.util.Iterator r2 = r9.iterator()
        L_0x0258:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0277
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$2$1 r5 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$2$1
            r5.<init>(r3)
            r6 = r20
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.G(r6, r5)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$2$2 r5 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$2$2
            r5.<init>(r3)
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.G(r1, r5)
            goto L_0x0258
        L_0x0277:
            r6 = r20
            int r2 = r4.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0288
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$$inlined$sortBy$1 r2 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$$inlined$sortBy$1
            r2.<init>()
            kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.z(r4, r2)
        L_0x0288:
            java.lang.String r2 = r0.countryIsoCode
            if (r2 == 0) goto L_0x0291
            boolean r3 = r0.fixedCountry
            if (r3 == 0) goto L_0x0291
            goto L_0x0292
        L_0x0291:
            r2 = r10
        L_0x0292:
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r4)
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r3 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r3
            if (r3 != 0) goto L_0x02de
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r1)
            r3 = r1
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r3 = (com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult) r3
            if (r3 != 0) goto L_0x02de
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r6)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "###############"
            if (r1 == 0) goto L_0x02c1
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r4 = r0.phoneCountryCodeWithMasks
            java.lang.Object r4 = r4.get(r1)
            com.sumsub.sns.internal.core.data.model.remote.c r4 = (com.sumsub.sns.internal.core.data.model.remote.c) r4
            if (r4 == 0) goto L_0x02c1
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r5 = new com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult
            java.lang.String r4 = r4.c()
            r5.<init>(r1, r4, r3)
            goto L_0x02c2
        L_0x02c1:
            r5 = r10
        L_0x02c2:
            if (r5 != 0) goto L_0x02dd
            if (r2 == 0) goto L_0x02d5
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r1 = r0.phoneCountryCodeWithMasks
            java.lang.Object r1 = r1.get(r2)
            com.sumsub.sns.internal.core.data.model.remote.c r1 = (com.sumsub.sns.internal.core.data.model.remote.c) r1
            if (r1 == 0) goto L_0x02d5
            java.lang.String r7 = r1.c()
            goto L_0x02d6
        L_0x02d5:
            r7 = r10
        L_0x02d6:
            com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult r1 = new com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult
            r1.<init>(r2, r7, r3)
            r3 = r1
            goto L_0x02de
        L_0x02dd:
            r3 = r5
        L_0x02de:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController.detectFormat(java.lang.String):com.sumsub.sns.core.widget.autocompletePhone.DetectFormatResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.phoneCountryCodeWithMasks.get(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.sumsub.sns.internal.core.data.model.remote.c getCurrentMasks() {
        /*
            r2 = this;
            java.lang.String r0 = r2.countryIsoCode
            if (r0 == 0) goto L_0x000e
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r1 = r2.phoneCountryCodeWithMasks
            java.lang.Object r0 = r1.get(r0)
            com.sumsub.sns.internal.core.data.model.remote.c r0 = (com.sumsub.sns.internal.core.data.model.remote.c) r0
            if (r0 != 0) goto L_0x0014
        L_0x000e:
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberFormatter r0 = r2.formatter
            com.sumsub.sns.internal.core.data.model.remote.c r0 = r0.getDefaultMask()
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController.getCurrentMasks():com.sumsub.sns.internal.core.data.model.remote.c");
    }

    private final void setCountryIsoCode(String str) {
        if (!x.b(str, this.countryIsoCode)) {
            a aVar = a.f34862a;
            String str2 = this.logTag;
            com.sumsub.log.logger.a.d(aVar, str2, "countryIsoCode=" + str, (Throwable) null, 4, (Object) null);
        }
        this.countryIsoCode = str;
    }

    private final void setViewState(ViewState viewState2) {
        this.viewState = viewState2;
        l<? super ViewState, Unit> lVar = this.onViewStateUpdated;
        if (lVar != null) {
            lVar.invoke(viewState2);
        }
    }

    public final boolean getAllowUndefinedCountry() {
        return this.allowUndefinedCountry;
    }

    public final String getApplicantCountry() {
        return this.applicantCountry;
    }

    public final boolean getFixedCountry() {
        return this.fixedCountry;
    }

    public final l<ViewState, Unit> getOnViewStateUpdated() {
        return this.onViewStateUpdated;
    }

    public final Map<String, c> getPhoneCountryCodeWithMasks() {
        return this.phoneCountryCodeWithMasks;
    }

    public final void onCountrySelected(String str, boolean z11) {
        ViewState viewState2;
        if (z11 || !this.fixedCountry) {
            setCountryIsoCode(str);
        }
        setFixedCountry(this.fixedCountry || z11);
        c cVar = this.phoneCountryCodeWithMasks.get(this.countryIsoCode);
        String c11 = cVar != null ? cVar.c() : null;
        if (c11 == null) {
            viewState2 = new ViewState("", str, (CharSequence) null, 4, (r) null);
        } else {
            viewState2 = new ViewState('+' + c11, str, (CharSequence) null, 4, (r) null);
        }
        setViewState(viewState2);
    }

    public final void onTextChanged(String str) {
        boolean z11;
        String str2;
        int i11 = 0;
        while (true) {
            if (i11 >= str.length()) {
                z11 = true;
                break;
            } else if (Character.isDigit(str.charAt(i11))) {
                z11 = false;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            setFixedCountry(false);
            setCountryIsoCode((String) null);
            setViewState(new ViewState("+", (String) null, (CharSequence) null, 4, (r) null));
            return;
        }
        if (this.fixedCountry && this.countryIsoCode != null) {
            StringBuilder sb2 = new StringBuilder();
            int length = str.length();
            for (int i12 = 0; i12 < length; i12++) {
                char charAt = str.charAt(i12);
                if (Character.isDigit(charAt)) {
                    sb2.append(charAt);
                }
            }
            String sb3 = sb2.toString();
            Map<String, c> map = this.phoneCountryCodeWithMasks;
            String str3 = this.countryIsoCode;
            if (str3 != null) {
                c cVar = map.get(str3);
                if (cVar == null || (str2 = cVar.c()) == null) {
                    str2 = "";
                }
                if (!StringsKt__StringsJVMKt.M(sb3, str2, false, 2, (Object) null)) {
                    com.sumsub.log.logger.a.d(a.f34862a, this.logTag, "onTextChanged: edited country code", (Throwable) null, 4, (Object) null);
                    setFixedCountry(false);
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        DetectFormatResult detectFormat = detectFormat(str);
        com.sumsub.log.logger.a.d(a.f34862a, this.logTag, "onTextChanged: fixedCountry=" + this.fixedCountry + ", using format=" + detectFormat, (Throwable) null, 4, (Object) null);
        if (!this.fixedCountry) {
            setCountryIsoCode(detectFormat.getCountryIsoCode());
        }
        setViewState(new ViewState(this.formatter.format(detectFormat, str).getFormattedString(), detectFormat.getCountryIsoCode(), (CharSequence) null, 4, (r) null));
    }

    public final void setAllowUndefinedCountry(boolean z11) {
        this.allowUndefinedCountry = z11;
    }

    public final void setApplicantCountry(String str) {
        this.applicantCountry = str;
    }

    public final void setFixedCountry(boolean z11) {
        a aVar = a.f34862a;
        String str = this.logTag;
        com.sumsub.log.logger.a.d(aVar, str, "fixedCountry=" + z11, (Throwable) null, 4, (Object) null);
        this.fixedCountry = z11;
    }

    public final void setOnViewStateUpdated(l<? super ViewState, Unit> lVar) {
        this.onViewStateUpdated = lVar;
    }

    public final void setPhoneCountryCodeWithMasks(Map<String, c> map) {
        a aVar = a.f34862a;
        String str = this.logTag;
        com.sumsub.log.logger.a.d(aVar, str, "phoneCountryCodeWithMasks: count=" + map.size(), (Throwable) null, 4, (Object) null);
        this.phoneCountryCodeWithMasks = map;
        this.formatter.setPhoneCountryCodeWithMasks(map);
    }

    public final boolean validate(CharSequence charSequence) {
        if (!x.b(getCurrentMasks(), this.formatter.getDefaultMask()) || !this.allowUndefinedCountry) {
            return com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(charSequence.toString());
        }
        return true;
    }
}
