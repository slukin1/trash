package com.sumsub.sns.core.widget.autocompletePhone;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.core.os.d;
import androidx.fragment.app.FragmentActivity;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.remote.c;
import com.sumsub.sns.internal.log.a;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\u0018\u0000 E2\u00020\u0001:\u0001EBU\u0012\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010=j\u0004\u0018\u0001`>\u0012\u001a\u0010@\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f\u0018\u00010=j\u0004\u0018\u0001`?\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J2\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\"R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0016@RX\u000e¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001f8\u0016@RX\u000e¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R(\u00105\u001a\u0004\u0018\u00010\u00022\b\u00100\u001a\u0004\u0018\u00010\u00028B@BX\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00106\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\u0004\u0018\u00010\t8FX\u0004¢\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b8\u0010\u001eR\u0014\u0010<\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b<\u00107¨\u0006F"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKit;", "Lcom/sumsub/sns/core/widget/PhoneKit;", "", "number", "", "validate", "Landroid/content/Context;", "context", "setFragmentResultListener", "", "getCountryRequestKey", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "country", "isUser", "", "setCountry", "Landroid/os/Bundle;", "state", "saveInstanceState", "detach", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "input", "", "countries", "defaultCountry", "savedInstanceState", "attachToInput", "viewId", "Ljava/lang/String;", "getViewId", "()Ljava/lang/String;", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "defaultMask", "Lcom/sumsub/sns/internal/core/data/model/remote/c;", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "<set-?>", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "getCountry", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "mask", "getMask", "()Lcom/sumsub/sns/internal/core/data/model/remote/c;", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberViewController;", "phoneNumberViewController", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberViewController;", "com/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKit$textWatcher$1", "textWatcher", "Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKit$textWatcher$1;", "value", "getRawInput", "()Ljava/lang/CharSequence;", "setRawInput", "(Ljava/lang/CharSequence;)V", "rawInput", "isBlank", "()Z", "getPurePhoneNumber", "getPurePhoneNumber$annotations", "()V", "purePhoneNumber", "isValid", "", "Lcom/sumsub/sns/internal/core/data/model/CountryCodeToNameMap;", "Lcom/sumsub/sns/internal/core/data/model/PhoneCountryCodeWithMasks;", "phoneMasks", "Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;", "validListener", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Lcom/sumsub/sns/core/widget/autocompletePhone/ValidationListener;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class PhoneNumberKit extends PhoneKit {
    private static final String ARG_COUNTRY = "country";
    private static final String COUNTRY_PICKER_REQUEST_KEY = "phone_number_kit_country_picker_request_key_%s";
    private static final String COUNTRY_PICKER_RESULT_KEY = "phone_number_kit_country_picker_result_key";
    public static final Companion Companion = new Companion((r) null);
    private SNSCountryPicker.CountryItem country;
    /* access modifiers changed from: private */
    public final c defaultMask;
    /* access modifiers changed from: private */
    public SNSFlaggedInputLayout input;
    /* access modifiers changed from: private */
    public c mask;
    /* access modifiers changed from: private */
    public final PhoneNumberViewController phoneNumberViewController;
    private final PhoneNumberKit$textWatcher$1 textWatcher;
    private final String viewId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/autocompletePhone/PhoneNumberKit$Companion;", "", "()V", "ARG_COUNTRY", "", "COUNTRY_PICKER_REQUEST_KEY", "COUNTRY_PICKER_RESULT_KEY", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneNumberKit(Map map, Map map2, String str, ValidationListener validationListener, int i11, r rVar) {
        this(map, map2, str, (i11 & 8) != 0 ? null : validationListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: attachToInput$lambda-7  reason: not valid java name */
    public static final void m47attachToInput$lambda7(List list, boolean z11, PhoneNumberKit phoneNumberKit, View view) {
        e0.f32018a.getCountryPicker().pickCountry(view.getContext(), list, new PhoneNumberKit$attachToInput$2$1(phoneNumberKit), z11 ? phoneNumberKit.getCountryRequestKey() : null, z11 ? COUNTRY_PICKER_RESULT_KEY : null);
    }

    private final String getCountryRequestKey() {
        String str = this.viewId;
        if (str == null) {
            return null;
        }
        d0 d0Var = d0.f56774a;
        return String.format(COUNTRY_PICKER_REQUEST_KEY, Arrays.copyOf(new Object[]{str}, 1));
    }

    public static /* synthetic */ void getPurePhoneNumber$annotations() {
    }

    private final CharSequence getRawInput() {
        EditText editText;
        SNSFlaggedInputLayout sNSFlaggedInputLayout = this.input;
        if (sNSFlaggedInputLayout == null || (editText = sNSFlaggedInputLayout.getEditText()) == null) {
            return null;
        }
        return editText.getText();
    }

    /* access modifiers changed from: private */
    public final boolean isBlank() {
        String purePhoneNumber = getPurePhoneNumber();
        if (purePhoneNumber != null) {
            return StringsKt__StringsJVMKt.z(purePhoneNumber);
        }
        return true;
    }

    private final boolean setFragmentResultListener(Context context) {
        String countryRequestKey;
        FragmentActivity a11 = i.a(context);
        if (a11 == null || (countryRequestKey = getCountryRequestKey()) == null) {
            return false;
        }
        a11.getSupportFragmentManager().H1(countryRequestKey, a11, new b(this));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: setFragmentResultListener$lambda-10  reason: not valid java name */
    public static final void m48setFragmentResultListener$lambda10(PhoneNumberKit phoneNumberKit, String str, Bundle bundle) {
        Object b11 = d.b(bundle, COUNTRY_PICKER_RESULT_KEY, SNSPickerDialog.Item.class);
        SNSPickerDialog.Item item = b11 instanceof SNSPickerDialog.Item ? (SNSPickerDialog.Item) b11 : null;
        if (item != null) {
            phoneNumberKit.setCountry(new SNSCountryPicker.CountryItem(item.getId(), item.getTitle()), true);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r3 = r3.getEditText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRawInput(java.lang.CharSequence r3) {
        /*
            r2 = this;
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r0 = r2.input
            if (r0 != 0) goto L_0x0005
            goto L_0x000a
        L_0x0005:
            java.lang.String r1 = "#"
            r0.setTag(r1)
        L_0x000a:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r0 = r2.input
            if (r0 == 0) goto L_0x0017
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x0017
            r0.setText(r3)
        L_0x0017:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r3 = r2.input
            r0 = 0
            if (r3 == 0) goto L_0x002b
            android.widget.EditText r3 = r3.getEditText()
            if (r3 == 0) goto L_0x002b
            int r3 = r3.length()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x002c
        L_0x002b:
            r3 = r0
        L_0x002c:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r1 = r2.input
            if (r1 == 0) goto L_0x0041
            android.widget.EditText r1 = r1.getEditText()
            if (r1 == 0) goto L_0x0041
            if (r3 == 0) goto L_0x003d
            int r3 = r3.intValue()
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            r1.setSelection(r3)
        L_0x0041:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r3 = r2.input
            if (r3 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            r3.setTag(r0)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit.setRawInput(java.lang.CharSequence):void");
    }

    private final boolean validate(CharSequence charSequence) {
        PhoneNumberViewController phoneNumberViewController2 = this.phoneNumberViewController;
        if (charSequence == null) {
            charSequence = "";
        }
        return phoneNumberViewController2.validate(charSequence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachToInput(com.sumsub.sns.core.widget.SNSFlaggedInputLayout r3, java.util.List<com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem> r4, com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem r5, android.os.Bundle r6) {
        /*
            r2 = this;
            if (r6 == 0) goto L_0x000f
            java.lang.Class<com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem> r5 = com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem.class
            java.lang.String r0 = "country"
            java.lang.Object r5 = androidx.core.os.d.b(r6, r0, r5)
            r6 = r5
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r6 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r6
            r2.country = r6
        L_0x000f:
            r2.input = r3
            com.sumsub.sns.core.widget.autocompletePhone.Constants r6 = com.sumsub.sns.core.widget.autocompletePhone.Constants.INSTANCE
            int r6 = r6.getTOOLKIT_TAG()
            r3.setTag(r6, r2)
            android.widget.EditText r6 = r3.getEditText()
            if (r6 != 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            r0 = 3
            r6.setInputType(r0)
        L_0x0025:
            android.widget.EditText r6 = r3.getEditText()
            if (r6 == 0) goto L_0x0030
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit$textWatcher$1 r0 = r2.textWatcher
            r6.addTextChangedListener(r0)
        L_0x0030:
            r6 = 0
            r3.setStartIconVisible(r6)
            r3.setStartIconCheckable(r6)
            r6 = 0
            r3.setStartIconTintList(r6)
            android.content.Context r0 = r3.getContext()
            boolean r0 = r2.setFragmentResultListener(r0)
            android.widget.FrameLayout r3 = r3.getFlagTouchInterceptor()
            com.sumsub.sns.core.widget.autocompletePhone.a r1 = new com.sumsub.sns.core.widget.autocompletePhone.a
            r1.<init>(r4, r0, r2)
            r3.setOnClickListener(r1)
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController r3 = r2.phoneNumberViewController
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r5 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r5
            if (r5 == 0) goto L_0x0059
            java.lang.String r6 = r5.getCode()
        L_0x0059:
            r3.setApplicantCountry(r6)
            r3 = 1
            r2.setCountry(r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit.attachToInput(com.sumsub.sns.core.widget.SNSFlaggedInputLayout, java.util.List, com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem, android.os.Bundle):void");
    }

    public void detach(Context context) {
        FragmentActivity a11;
        String countryRequestKey;
        EditText editText;
        SNSFlaggedInputLayout sNSFlaggedInputLayout = this.input;
        if (!(sNSFlaggedInputLayout == null || (editText = sNSFlaggedInputLayout.getEditText()) == null)) {
            editText.removeTextChangedListener(this.textWatcher);
        }
        SNSFlaggedInputLayout sNSFlaggedInputLayout2 = this.input;
        if (sNSFlaggedInputLayout2 != null) {
            sNSFlaggedInputLayout2.setTag(Constants.INSTANCE.getTOOLKIT_TAG(), (Object) null);
        }
        this.input = null;
        if (context != null && (a11 = i.a(context)) != null && (countryRequestKey = getCountryRequestKey()) != null) {
            a11.getSupportFragmentManager().w(countryRequestKey);
        }
    }

    public SNSCountryPicker.CountryItem getCountry() {
        return this.country;
    }

    public c getMask() {
        return this.mask;
    }

    public final String getPurePhoneNumber() {
        c mask2;
        CharSequence rawInput = getRawInput();
        if (rawInput == null || (mask2 = getMask()) == null) {
            return null;
        }
        return mask2.a(rawInput.toString());
    }

    public final String getViewId() {
        return this.viewId;
    }

    public boolean isValid() {
        boolean validate = validate(getRawInput());
        if (!validate) {
            a aVar = a.f34862a;
            com.sumsub.log.logger.a.d(aVar, Constants.logTag, "valid=" + validate, (Throwable) null, 4, (Object) null);
        }
        return validate;
    }

    public void saveInstanceState(Bundle bundle) {
        bundle.putParcelable("country", getCountry());
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCountry(com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem r9, boolean r10) {
        /*
            r8 = this;
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r0 = r8.getCountry()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getCode()
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            if (r9 == 0) goto L_0x0014
            java.lang.String r2 = r9.getCode()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            boolean r0 = kotlin.jvm.internal.x.b(r0, r2)
            r0 = r0 ^ 1
            if (r9 == 0) goto L_0x0082
            r8.country = r9
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "setCountry: "
            r3.append(r4)
            r3.append(r9)
            java.lang.String r4 = r3.toString()
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "SNSPhoneNumberKit"
            com.sumsub.log.logger.a.d(r2, r3, r4, r5, r6, r7)
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r2 = r8.input
            if (r2 == 0) goto L_0x0049
            android.widget.EditText r2 = r2.getEditText()
            if (r2 == 0) goto L_0x0049
            android.content.Context r2 = r2.getContext()
            goto L_0x004a
        L_0x0049:
            r2 = r1
        L_0x004a:
            if (r2 == 0) goto L_0x007f
            android.graphics.drawable.Drawable r2 = com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt.getFlagDrawable(r9, r2)
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r3 = r8.input
            if (r3 == 0) goto L_0x005d
            com.sumsub.sns.core.widget.SNSFlagView r3 = r3.getFlagView()
            if (r3 == 0) goto L_0x005d
            r3.setImageDrawable(r2)
        L_0x005d:
            if (r0 == 0) goto L_0x006b
            com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController r0 = r8.phoneNumberViewController
            java.lang.String r9 = r9.getCode()
            r0.onCountrySelected(r9, r10)
            kotlin.Unit r9 = kotlin.Unit.f56620a
            goto L_0x0080
        L_0x006b:
            com.sumsub.sns.core.widget.autocompletePhone.ValidationListener r9 = r8.getValidListener()
            if (r9 == 0) goto L_0x007f
            boolean r10 = r8.isValid()
            boolean r0 = r8.isBlank()
            r9.onValidate(r10, r0)
            kotlin.Unit r9 = kotlin.Unit.f56620a
            goto L_0x0080
        L_0x007f:
            r9 = r1
        L_0x0080:
            if (r9 != 0) goto L_0x00a5
        L_0x0082:
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r9 = r8.input
            if (r9 == 0) goto L_0x00a5
            com.sumsub.sns.core.widget.SNSFlagView r9 = r9.getFlagView()
            if (r9 == 0) goto L_0x00a5
            r8.country = r1
            android.content.res.Resources r10 = r9.getResources()
            int r0 = com.sumsub.sns.R.drawable.sns_ic_flag_placeholder
            android.content.Context r1 = r9.getContext()
            android.content.res.Resources$Theme r1 = r1.getTheme()
            android.graphics.drawable.Drawable r10 = androidx.core.content.res.ResourcesCompat.f(r10, r0, r1)
            r9.setImageDrawable(r10)
            kotlin.Unit r9 = kotlin.Unit.f56620a
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKit.setCountry(com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem, boolean):void");
    }

    public PhoneNumberKit(Map<String, String> map, Map<String, c> map2, String str, ValidationListener validationListener) {
        super(map, map2, validationListener);
        this.viewId = str;
        this.defaultMask = new c("", CollectionsKt__CollectionsJVMKt.e(n0.h.f32190m));
        PhoneNumberViewController phoneNumberViewController2 = new PhoneNumberViewController();
        phoneNumberViewController2.setPhoneCountryCodeWithMasks(map2 == null ? MapsKt__MapsKt.h() : map2);
        phoneNumberViewController2.setOnViewStateUpdated(new PhoneNumberKit$phoneNumberViewController$1$1(this, validationListener, map, map2));
        this.phoneNumberViewController = phoneNumberViewController2;
        this.textWatcher = new PhoneNumberKit$textWatcher$1(this);
    }
}
