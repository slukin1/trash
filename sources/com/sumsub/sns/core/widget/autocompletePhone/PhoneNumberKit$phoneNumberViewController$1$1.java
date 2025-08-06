package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.internal.core.data.model.remote.c;
import d10.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "Lcom/sumsub/sns/core/widget/autocompletePhone/ViewState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberKit$phoneNumberViewController$1$1 extends Lambda implements l<ViewState, Unit> {
    public final /* synthetic */ Map<String, String> $countries;
    public final /* synthetic */ Map<String, c> $phoneMasks;
    public final /* synthetic */ ValidationListener $validListener;
    public final /* synthetic */ PhoneNumberKit this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNumberKit$phoneNumberViewController$1$1(PhoneNumberKit phoneNumberKit, ValidationListener validationListener, Map<String, String> map, Map<String, c> map2) {
        super(1);
        this.this$0 = phoneNumberKit;
        this.$validListener = validationListener;
        this.$countries = map;
        this.$phoneMasks = map2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ViewState) obj);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        if (r7 == null) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.sumsub.sns.core.widget.autocompletePhone.ViewState r7) {
        /*
            r6 = this;
            com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onViewStateUpdated: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = r1.toString()
            java.lang.String r1 = "SNSPhoneNumberKit"
            r3 = 0
            r4 = 4
            r5 = 0
            com.sumsub.log.logger.a.d(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r0 = r6.this$0
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r0 = r0.getCountry()
            r1 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = r0.getCode()
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            java.lang.String r2 = r7.getCountryCode()
            boolean r0 = kotlin.jvm.internal.x.b(r0, r2)
            r2 = 0
            if (r0 != 0) goto L_0x0055
            java.lang.String r0 = r7.getCountryCode()
            if (r0 == 0) goto L_0x004e
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.$countries
            if (r3 == 0) goto L_0x0047
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0048
        L_0x0047:
            r3 = r0
        L_0x0048:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r4 = new com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem
            r4.<init>(r0, r3)
            goto L_0x004f
        L_0x004e:
            r4 = r1
        L_0x004f:
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r0 = r6.this$0
            r3 = 2
            com.sumsub.sns.core.widget.PhoneKit.setCountry$default(r0, r4, r2, r3, r1)
        L_0x0055:
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r0 = r6.this$0
            java.lang.String r3 = r7.getText()
            r0.setRawInput(r3)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r0 = r6.this$0
            java.lang.String r7 = r7.getCountryCode()
            if (r7 == 0) goto L_0x0074
            java.util.Map<java.lang.String, com.sumsub.sns.internal.core.data.model.remote.c> r3 = r6.$phoneMasks
            if (r3 == 0) goto L_0x0071
            java.lang.Object r7 = r3.get(r7)
            com.sumsub.sns.internal.core.data.model.remote.c r7 = (com.sumsub.sns.internal.core.data.model.remote.c) r7
            goto L_0x0072
        L_0x0071:
            r7 = r1
        L_0x0072:
            if (r7 != 0) goto L_0x007a
        L_0x0074:
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r7 = r6.this$0
            com.sumsub.sns.internal.core.data.model.remote.c r7 = r7.defaultMask
        L_0x007a:
            r0.mask = r7
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r7 = r6.this$0
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r7 = r7.input
            if (r7 == 0) goto L_0x0089
            android.widget.EditText r1 = r7.getEditText()
        L_0x0089:
            if (r1 != 0) goto L_0x008c
            goto L_0x00a8
        L_0x008c:
            r7 = 1
            android.text.InputFilter$LengthFilter[] r7 = new android.text.InputFilter.LengthFilter[r7]
            android.text.InputFilter$LengthFilter r0 = new android.text.InputFilter$LengthFilter
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r3 = r6.this$0
            com.sumsub.sns.internal.core.data.model.remote.c r3 = r3.getMask()
            if (r3 == 0) goto L_0x009e
            int r3 = r3.g()
            goto L_0x00a0
        L_0x009e:
            r3 = 15
        L_0x00a0:
            r0.<init>(r3)
            r7[r2] = r0
            r1.setFilters(r7)
        L_0x00a8:
            com.sumsub.sns.core.widget.autocompletePhone.ValidationListener r7 = r6.$validListener
            if (r7 == 0) goto L_0x00bb
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r0 = r6.this$0
            boolean r0 = r0.isValid()
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit r1 = r6.this$0
            boolean r1 = r1.isBlank()
            r7.onValidate(r0, r1)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit$phoneNumberViewController$1$1.invoke(com.sumsub.sns.core.widget.autocompletePhone.ViewState):void");
    }
}
