package com.sumsub.sns.core.widget.autocompletePhone;

import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.a;
import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.core.widget.SNSTextInputEditText;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001-Ba\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010#j\u0004\u0018\u0001`$\u0012\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010#j\u0004\u0018\u0001`&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0016@RX\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00128\u0016@RX\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\"\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKitV2;", "Lcom/sumsub/sns/core/widget/PhoneKit;", "", "number", "", "validate", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "country", "isUser", "", "setCountry", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "input", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "<set-?>", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "getCountry", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "mask", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "getMask", "()Lcom/sumsub/sns/internal/core/data/model/remote/c;", "", "manuallySelectedCountryKey", "Ljava/lang/String;", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText;", "getEditText", "()Lcom/sumsub/sns/core/widget/SNSTextInputEditText;", "editText", "isValid", "()Z", "getPurePhoneNumber", "()Ljava/lang/String;", "purePhoneNumber", "", "Lcom/sumsub/sns/internal/core/data/model/CountryCodeToNameMap;", "countries", "Lcom/sumsub/sns/internal/core/data/model/PhoneCountryCodeWithMasks;", "phoneMasks", "Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;", "validListener", "initialValue", "<init>", "(Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;Ljava/util/Map;Ljava/util/Map;Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;Ljava/lang/CharSequence;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class PhoneNumberKitV2 extends PhoneKit {
    private static final Companion Companion = new Companion((r) null);
    @Deprecated
    public static final int MAX_PHONE_LENGTH = 15;
    private SNSCountryPicker.CountryItem country;
    private final SNSFlaggedInputLayout input;
    /* access modifiers changed from: private */
    public String manuallySelectedCountryKey;
    private c mask;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKitV2$Companion;", "", "()V", "MAX_PHONE_LENGTH", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneNumberKitV2(SNSFlaggedInputLayout sNSFlaggedInputLayout, Map map, Map map2, ValidationListener validationListener, CharSequence charSequence, int i11, r rVar) {
        this(sNSFlaggedInputLayout, map, map2, (i11 & 8) != 0 ? null : validationListener, (i11 & 16) != 0 ? null : charSequence);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: _init_$lambda-12  reason: not valid java name */
    public static final void m49_init_$lambda12(List list, List list2, PhoneNumberKitV2 phoneNumberKitV2, View view) {
        a.a(e0.f32018a.getCountryPicker(), view.getContext(), list, new PhoneNumberKitV2$1$1(list2, phoneNumberKitV2), (String) null, (String) null, 24, (Object) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final SNSTextInputEditText getEditText() {
        SNSFlaggedInputLayout sNSFlaggedInputLayout = this.input;
        TextView editText = sNSFlaggedInputLayout != null ? sNSFlaggedInputLayout.getEditText() : null;
        if (editText instanceof SNSTextInputEditText) {
            return (SNSTextInputEditText) editText;
        }
        return null;
    }

    private final boolean validate(CharSequence charSequence) {
        String obj;
        if (charSequence == null || (obj = charSequence.toString()) == null) {
            return false;
        }
        return com.sumsub.sns.internal.core.widget.autocompletePhone.util.a.a(obj);
    }

    public SNSCountryPicker.CountryItem getCountry() {
        return this.country;
    }

    public c getMask() {
        return this.mask;
    }

    public final String getPurePhoneNumber() {
        String rawText;
        c mask2;
        SNSTextInputEditText editText = getEditText();
        if (editText == null || (rawText = editText.getRawText()) == null || (mask2 = getMask()) == null) {
            return null;
        }
        return mask2.a(rawText);
    }

    public boolean isValid() {
        SNSTextInputEditText editText = getEditText();
        boolean validate = validate(editText != null ? editText.getRawText() : null);
        if (!validate) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, Constants.logTag, "valid=" + validate, (Throwable) null, 4, (Object) null);
        }
        return validate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r6 == null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCountry(com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem r5, boolean r6) {
        /*
            r4 = this;
            com.sumsub.sns.core.widget.SNSTextInputEditText r6 = r4.getEditText()
            r0 = 0
            if (r6 == 0) goto L_0x000c
            android.content.Context r6 = r6.getContext()
            goto L_0x000d
        L_0x000c:
            r6 = r0
        L_0x000d:
            if (r6 != 0) goto L_0x0010
            return
        L_0x0010:
            if (r5 == 0) goto L_0x002b
            android.graphics.drawable.Drawable r6 = com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt.getFlagDrawable(r5, r6)
            if (r6 == 0) goto L_0x0028
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r1 = r4.input
            if (r1 == 0) goto L_0x0028
            com.sumsub.sns.core.widget.SNSFlagView r1 = r1.getFlagView()
            if (r1 == 0) goto L_0x0028
            r1.setImageDrawable(r6)
            kotlin.Unit r6 = kotlin.Unit.f56620a
            goto L_0x0029
        L_0x0028:
            r6 = r0
        L_0x0029:
            if (r6 != 0) goto L_0x004c
        L_0x002b:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r6 = r4.input
            if (r6 == 0) goto L_0x004c
            com.sumsub.sns.core.widget.SNSFlagView r6 = r6.getFlagView()
            if (r6 == 0) goto L_0x004c
            android.content.res.Resources r1 = r6.getResources()
            int r2 = com.sumsub.sns.R.drawable.sns_ic_flag_placeholder
            android.content.Context r3 = r6.getContext()
            android.content.res.Resources$Theme r3 = r3.getTheme()
            android.graphics.drawable.Drawable r1 = androidx.core.content.res.ResourcesCompat.f(r1, r2, r3)
            r6.setImageDrawable(r1)
            kotlin.Unit r6 = kotlin.Unit.f56620a
        L_0x004c:
            r4.country = r5
            if (r5 == 0) goto L_0x0061
            java.util.Map r6 = r4.getPhoneMasks()
            if (r6 == 0) goto L_0x0061
            java.lang.String r5 = r5.getCode()
            java.lang.Object r5 = r6.get(r5)
            r0 = r5
            com.sumsub.sns.internal.core.data.model.remote.c r0 = (com.sumsub.sns.internal.core.data.model.remote.c) r0
        L_0x0061:
            r4.mask = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2.setCountry(com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0093, code lost:
        r6 = r1.get(r9.getKey());
     */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PhoneNumberKitV2(com.sumsub.sns.core.widget.SNSFlaggedInputLayout r25, java.util.Map<java.lang.String, java.lang.String> r26, java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r27, com.sumsub.sns.core.widget.autocompletePhone.ValidationListener r28, java.lang.CharSequence r29) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r2 = r27
            r3 = r28
            r0.<init>(r1, r2, r3)
            r4 = r25
            r0.input = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            if (r2 == 0) goto L_0x0194
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = r27.size()
            r8.<init>(r9)
            java.util.Set r2 = r27.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x002c:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x014e
            java.lang.Object r9 = r2.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getValue()
            com.sumsub.sns.internal.core.data.model.remote.c r10 = (com.sumsub.sns.internal.core.data.model.remote.c) r10
            java.util.List r10 = r10.e()
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$_init_$lambda-8$$inlined$sortedBy$1 r11 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$_init_$lambda-8$$inlined$sortedBy$1
            r11.<init>()
            java.util.List r10 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r10, r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = kotlin.collections.CollectionsKt__IterablesKt.u(r10, r12)
            r11.<init>(r12)
            java.util.Iterator r10 = r10.iterator()
        L_0x005a:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x0137
            java.lang.Object r12 = r10.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r9.getValue()
            com.sumsub.sns.internal.core.data.model.remote.c r13 = (com.sumsub.sns.internal.core.data.model.remote.c) r13
            java.lang.String r13 = r13.c()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "+ "
            r14.append(r15)
            r14.append(r13)
            r15 = 32
            r14.append(r15)
            r14.append(r12)
            java.lang.String r17 = r14.toString()
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r14 = new com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem
            java.lang.Object r15 = r9.getKey()
            java.lang.String r15 = (java.lang.String) r15
            if (r1 == 0) goto L_0x009f
            java.lang.Object r6 = r9.getKey()
            java.lang.Object r6 = r1.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x00a1
        L_0x009f:
            java.lang.String r6 = ""
        L_0x00a1:
            r14.<init>(r15, r6)
            com.sumsub.sns.core.widget.SNSTextInputEditText$Mask r6 = new com.sumsub.sns.core.widget.SNSTextInputEditText$Mask
            r18 = 1
            r19 = 0
            r20 = 0
            r22 = 12
            r23 = 0
            r16 = r6
            r21 = r14
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            int r15 = r12.length()
            r7 = 0
        L_0x00c1:
            if (r7 >= r15) goto L_0x00d7
            r27 = r2
            char r2 = r12.charAt(r7)
            boolean r17 = java.lang.Character.isDigit(r2)
            if (r17 == 0) goto L_0x00d2
            r14.append(r2)
        L_0x00d2:
            int r7 = r7 + 1
            r2 = r27
            goto L_0x00c1
        L_0x00d7:
            r27 = r2
            java.lang.String r2 = r14.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r13)
            r7.append(r2)
            java.lang.String r17 = r7.toString()
            r20 = 0
            r21 = 4
            r22 = 0
            java.lang.String r18 = " "
            java.lang.String r19 = ""
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r17, r18, r19, r20, r21, r22)
            java.lang.Object r7 = r4.get(r2)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            if (r7 != 0) goto L_0x010c
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r4.put(r2, r7)
            kotlin.Unit r2 = kotlin.Unit.f56620a
        L_0x010c:
            r7.add(r6)
            if (r13 == 0) goto L_0x012e
            java.lang.Object r2 = r9.getKey()
            java.lang.Object r2 = r5.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            if (r2 != 0) goto L_0x012b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.Object r7 = r9.getKey()
            r5.put(r7, r2)
            kotlin.Unit r7 = kotlin.Unit.f56620a
        L_0x012b:
            r2.add(r6)
        L_0x012e:
            kotlin.Unit r2 = kotlin.Unit.f56620a
            r11.add(r6)
            r2 = r27
            goto L_0x005a
        L_0x0137:
            r27 = r2
            java.lang.Object r2 = r9.getValue()
            com.sumsub.sns.internal.core.data.model.remote.c r2 = (com.sumsub.sns.internal.core.data.model.remote.c) r2
            java.lang.String r2 = r2.c()
            kotlin.Pair r2 = kotlin.l.a(r2, r11)
            r8.add(r2)
            r2 = r27
            goto L_0x002c
        L_0x014e:
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$sortedBy$1 r2 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$sortedBy$1
            r2.<init>()
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r8, r2)
            if (r2 == 0) goto L_0x0194
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0162:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0178
            java.lang.Object r7 = r2.next()
            kotlin.Pair r7 = (kotlin.Pair) r7
            java.lang.Object r7 = r7.getSecond()
            java.util.List r7 = (java.util.List) r7
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r6, r7)
            goto L_0x0162
        L_0x0178:
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r6)
            if (r2 == 0) goto L_0x0194
            com.sumsub.sns.core.widget.SNSTextInputEditText$Mask r14 = new com.sumsub.sns.core.widget.SNSTextInputEditText$Mask
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 16
            r13 = 0
            java.lang.String r7 = "+ "
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r6 = 0
            r2.add(r6, r14)
            kotlin.Unit r6 = kotlin.Unit.f56620a
            goto L_0x0195
        L_0x0194:
            r2 = 0
        L_0x0195:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem$Companion r6 = com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem.Companion
            if (r1 != 0) goto L_0x019d
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
        L_0x019d:
            java.util.List r1 = r6.fromMap(r1)
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r6 = r0.input
            if (r6 == 0) goto L_0x01b5
            android.widget.FrameLayout r6 = r6.getFlagTouchInterceptor()
            if (r6 == 0) goto L_0x01b5
            com.sumsub.sns.core.widget.autocompletePhone.c r7 = new com.sumsub.sns.core.widget.autocompletePhone.c
            r7.<init>(r1, r2, r0)
            r6.setOnClickListener(r7)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x01b5:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r1 = r0.input
            r6 = 0
            if (r1 != 0) goto L_0x01bb
            goto L_0x01be
        L_0x01bb:
            r1.setStartIconVisible(r6)
        L_0x01be:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r1 = r0.input
            if (r1 != 0) goto L_0x01c3
            goto L_0x01c6
        L_0x01c3:
            r1.setStartIconCheckable(r6)
        L_0x01c6:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r1 = r0.input
            if (r1 == 0) goto L_0x01d0
            r6 = 0
            r1.setStartIconTintList(r6)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x01d0:
            java.util.Set r1 = r4.keySet()
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$sortedByDescending$1 r6 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$sortedByDescending$1
            r6.<init>()
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r1, r6)
            com.sumsub.sns.core.widget.SNSTextInputEditText r6 = r24.getEditText()
            if (r6 != 0) goto L_0x01e4
            goto L_0x01ec
        L_0x01e4:
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$2 r7 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$2
            r7.<init>(r0, r5, r1, r4)
            r6.setMaskListener(r7)
        L_0x01ec:
            com.sumsub.sns.core.widget.SNSTextInputEditText r1 = r24.getEditText()
            if (r1 == 0) goto L_0x01f9
            r4 = 15
            r1.setMaxLength(r4)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x01f9:
            com.sumsub.sns.core.widget.SNSTextInputEditText r1 = r24.getEditText()
            if (r1 == 0) goto L_0x0204
            r1.setMasks(r2)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x0204:
            com.sumsub.sns.core.widget.SNSTextInputEditText r1 = r24.getEditText()
            if (r1 == 0) goto L_0x0214
            r2 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.updateInputType(r2)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x0214:
            com.sumsub.sns.core.widget.SNSTextInputEditText r1 = r24.getEditText()
            if (r1 == 0) goto L_0x0222
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$addTextChangedListener$default$1 r2 = new com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$special$$inlined$addTextChangedListener$default$1
            r2.<init>(r3, r0)
            r1.addTextChangedListener(r2)
        L_0x0222:
            com.sumsub.sns.core.widget.SNSTextInputEditText r1 = r24.getEditText()
            if (r1 == 0) goto L_0x022f
            r2 = r29
            r1.setText(r2)
            kotlin.Unit r1 = kotlin.Unit.f56620a
        L_0x022f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2.<init>(com.sumsub.sns.core.widget.SNSFlaggedInputLayout, java.util.Map, java.util.Map, com.sumsub.sns.core.widget.autocompletePhone.ValidationListener, java.lang.CharSequence):void");
    }
}
