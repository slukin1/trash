package com.sumsub.sns.core.widget.applicantData;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.widget.SNSApplicantDataFieldView;
import com.sumsub.sns.core.widget.SNSFlagView;
import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.model.h;
import d10.l;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B1\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00106\u001a\u000205\u0012\b\b\u0002\u00107\u001a\u000205¢\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006;"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataSelectionCountryFieldView;", "Lcom/sumsub/sns/core/widget/SNSApplicantDataFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView$Selectable;", "", "setFragmentResultListener", "", "getCountryRequestKey", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "item", "", "onCountrySelected", "openSelector", "enabled", "setEnabled", "", "tag", "setTag", "", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "<set-?>", "selectedCountry", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "getSelectedCountry", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "fragmentListenerSet", "Z", "Ljava/lang/Runnable;", "picker", "Ljava/lang/Runnable;", "Landroid/graphics/drawable/Drawable;", "endIcon", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Function1;", "onCountrySelectedCallback", "Ld10/l;", "getOnCountrySelectedCallback", "()Ld10/l;", "setOnCountrySelectedCallback", "(Ld10/l;)V", "value", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
public final class SNSApplicantDataSelectionCountryFieldView extends SNSApplicantDataFieldView implements SNSApplicantDataBaseFieldView.Selectable {
    private static final String COUNTRY_PICKER_REQUEST_KEY = "SNSApplicantDataSelectionCountryFieldView_country_picker_request_key_%s";
    private static final String COUNTRY_PICKER_RESULT_KEY = "SNSApplicantDataSelectionCountryFieldView_country_picker_result_key";
    public static final Companion Companion = new Companion((r) null);
    private Drawable endIcon;
    private boolean fragmentListenerSet;
    private List<SNSCountryPicker.CountryItem> items;
    private l<? super SNSCountryPicker.CountryItem, Unit> onCountrySelectedCallback;
    private final Runnable picker;
    private SNSCountryPicker.CountryItem selectedCountry;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataSelectionCountryFieldView$Companion;", "", "()V", "COUNTRY_PICKER_REQUEST_KEY", "", "COUNTRY_PICKER_RESULT_KEY", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    public SNSApplicantDataSelectionCountryFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final boolean m41_init_$lambda5(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public final String getCountryRequestKey() {
        Object obj;
        Object tag = getTag();
        if (tag instanceof h.d) {
            obj = ((h.d) tag).q();
        } else {
            obj = tag instanceof h.c ? ((h.c) tag).i() : null;
        }
        if (obj == null) {
            return null;
        }
        d0 d0Var = d0.f56774a;
        return String.format(COUNTRY_PICKER_REQUEST_KEY, Arrays.copyOf(new Object[]{obj}, 1));
    }

    /* access modifiers changed from: private */
    public final void onCountrySelected(SNSCountryPicker.CountryItem countryItem) {
        SNSFlagView flagView;
        EditText editText;
        EditText editText2;
        TextInputLayout inputLayout = getInputLayout();
        if (!(inputLayout == null || (editText2 = inputLayout.getEditText()) == null)) {
            editText2.clearFocus();
        }
        TextInputLayout inputLayout2 = getInputLayout();
        if (!(inputLayout2 == null || (editText = inputLayout2.getEditText()) == null)) {
            editText.setText(countryItem.getName());
        }
        TextInputLayout inputLayout3 = getInputLayout();
        SNSFlaggedInputLayout sNSFlaggedInputLayout = inputLayout3 instanceof SNSFlaggedInputLayout ? (SNSFlaggedInputLayout) inputLayout3 : null;
        if (!(sNSFlaggedInputLayout == null || (flagView = sNSFlaggedInputLayout.getFlagView()) == null)) {
            flagView.setImageDrawable(SNSDefaultCountryPickerKt.getFlagDrawable(countryItem, flagView.getContext()));
        }
        this.selectedCountry = countryItem;
        l<? super SNSCountryPicker.CountryItem, Unit> lVar = this.onCountrySelectedCallback;
        if (lVar != null) {
            lVar.invoke(countryItem);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: picker$lambda-3  reason: not valid java name */
    public static final void m42picker$lambda3(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView, Context context) {
        if (sNSApplicantDataSelectionCountryFieldView.isEnabled()) {
            e0.f32018a.getCountryPicker().pickCountry(context, sNSApplicantDataSelectionCountryFieldView.items, new SNSApplicantDataSelectionCountryFieldView$picker$1$1(sNSApplicantDataSelectionCountryFieldView), sNSApplicantDataSelectionCountryFieldView.fragmentListenerSet ? sNSApplicantDataSelectionCountryFieldView.getCountryRequestKey() : null, sNSApplicantDataSelectionCountryFieldView.fragmentListenerSet ? COUNTRY_PICKER_RESULT_KEY : null);
        }
    }

    private final boolean setFragmentResultListener() {
        String countryRequestKey = getCountryRequestKey();
        if (countryRequestKey == null) {
            return false;
        }
        Context context = getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity == null) {
            return false;
        }
        fragmentActivity.getSupportFragmentManager().H1(countryRequestKey, fragmentActivity, new g(this));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: setFragmentResultListener$lambda-9$lambda-8  reason: not valid java name */
    public static final void m43setFragmentResultListener$lambda9$lambda8(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView, String str, Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable(COUNTRY_PICKER_RESULT_KEY);
        SNSPickerDialog.Item item = parcelable instanceof SNSPickerDialog.Item ? (SNSPickerDialog.Item) parcelable : null;
        if (item != null) {
            sNSApplicantDataSelectionCountryFieldView.onCountrySelected(new SNSCountryPicker.CountryItem(item.getId(), item.getTitle()));
        }
    }

    public final List<SNSCountryPicker.CountryItem> getItems() {
        return this.items;
    }

    public final l<SNSCountryPicker.CountryItem, Unit> getOnCountrySelectedCallback() {
        return this.onCountrySelectedCallback;
    }

    public final SNSCountryPicker.CountryItem getSelectedCountry() {
        return this.selectedCountry;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getEditText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getValue() {
        /*
            r1 = this;
            com.google.android.material.textfield.TextInputLayout r0 = r1.getInputLayout()
            if (r0 == 0) goto L_0x0011
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x0011
            android.text.Editable r0 = r0.getText()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView.getValue():java.lang.String");
    }

    public void openSelector() {
        this.picker.run();
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        TextInputLayout inputLayout = getInputLayout();
        if (inputLayout != null) {
            inputLayout.setEndIconDrawable(z11 ? this.endIcon : null);
        }
    }

    public final void setItems(List<SNSCountryPicker.CountryItem> list) {
        this.items = list;
    }

    public final void setOnCountrySelectedCallback(l<? super SNSCountryPicker.CountryItem, Unit> lVar) {
        this.onCountrySelectedCallback = lVar;
    }

    public void setTag(Object obj) {
        super.setTag(obj);
        this.fragmentListenerSet = setFragmentResultListener();
    }

    /* JADX WARNING: type inference failed for: r6v6, types: [com.google.android.material.textfield.TextInputLayout] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(java.lang.String r6) {
        /*
            r5 = this;
            com.google.android.material.textfield.TextInputLayout r0 = r5.getInputLayout()
            if (r0 == 0) goto L_0x000f
            android.widget.EditText r0 = r0.getEditText()
            if (r0 == 0) goto L_0x000f
            r0.setText(r6)
        L_0x000f:
            java.util.List<com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem> r0 = r5.items
            java.util.Iterator r0 = r0.iterator()
        L_0x0015:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r3 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r3
            java.lang.String r3 = r3.getName()
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r4 = r6.toLowerCase(r4)
            boolean r3 = kotlin.jvm.internal.x.b(r3, r4)
            if (r3 == 0) goto L_0x0015
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            com.sumsub.sns.core.data.listener.SNSCountryPicker$CountryItem r1 = (com.sumsub.sns.core.data.listener.SNSCountryPicker.CountryItem) r1
            if (r1 == 0) goto L_0x005e
            com.google.android.material.textfield.TextInputLayout r6 = r5.getInputLayout()
            boolean r0 = r6 instanceof com.sumsub.sns.core.widget.SNSFlaggedInputLayout
            if (r0 == 0) goto L_0x0048
            r2 = r6
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r2 = (com.sumsub.sns.core.widget.SNSFlaggedInputLayout) r2
        L_0x0048:
            if (r2 == 0) goto L_0x005b
            com.sumsub.sns.core.widget.SNSFlagView r6 = r2.getFlagView()
            if (r6 == 0) goto L_0x005b
            android.content.Context r0 = r5.getContext()
            android.graphics.drawable.Drawable r0 = com.sumsub.sns.core.data.listener.SNSDefaultCountryPickerKt.getFlagDrawable(r1, r0)
            r6.setImageDrawable(r0)
        L_0x005b:
            r5.selectedCountry = r1
            goto L_0x0077
        L_0x005e:
            com.google.android.material.textfield.TextInputLayout r6 = r5.getInputLayout()
            boolean r0 = r6 instanceof com.sumsub.sns.core.widget.SNSFlaggedInputLayout
            if (r0 == 0) goto L_0x0069
            com.sumsub.sns.core.widget.SNSFlaggedInputLayout r6 = (com.sumsub.sns.core.widget.SNSFlaggedInputLayout) r6
            goto L_0x006a
        L_0x0069:
            r6 = r2
        L_0x006a:
            if (r6 == 0) goto L_0x0075
            com.sumsub.sns.core.widget.SNSFlagView r6 = r6.getFlagView()
            if (r6 == 0) goto L_0x0075
            r6.setImageDrawable(r2)
        L_0x0075:
            r5.selectedCountry = r2
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataSelectionCountryFieldView.setValue(java.lang.String):void");
    }

    public SNSApplicantDataSelectionCountryFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataSelectionCountryFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataSelectionCountryFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataFieldView_Country : i12);
    }

    public SNSApplicantDataSelectionCountryFieldView(final Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        EditText editText;
        this.items = CollectionsKt__CollectionsKt.k();
        this.picker = new h(this, context);
        a aVar = a.f31095a;
        Drawable a11 = aVar.a(context, SNSIconHandler.SNSCommonIcons.MORE.getImageName());
        this.endIcon = a11 == null ? aVar.a(context, SNSIconHandler.SNSCommonIcons.DISCLOSURE.getImageName()) : a11;
        TextInputLayout inputLayout = getInputLayout();
        if (inputLayout != null) {
            inputLayout.setEndIconDrawable(this.endIcon);
        }
        GestureDetector gestureDetector = new GestureDetector(context, new SNSApplicantDataSelectionCountryFieldView$gestureDetector$1(this));
        TextInputLayout inputLayout2 = getInputLayout();
        if (!(inputLayout2 == null || (editText = inputLayout2.getEditText()) == null)) {
            editText.setOnTouchListener(new f(gestureDetector));
        }
        TextInputLayout inputLayout3 = getInputLayout();
        EditText editText2 = inputLayout3 != null ? inputLayout3.getEditText() : null;
        if (editText2 != null) {
            editText2.setKeyListener((KeyListener) null);
        }
        setOnClear(new d10.a<Unit>(this) {
            public final /* synthetic */ SNSApplicantDataSelectionCountryFieldView this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                FragmentActivity a11;
                FragmentManager supportFragmentManager;
                String access$getCountryRequestKey = this.this$0.getCountryRequestKey();
                if (access$getCountryRequestKey != null && (a11 = i.a(context)) != null && (supportFragmentManager = a11.getSupportFragmentManager()) != null) {
                    supportFragmentManager.w(access$getCountryRequestKey);
                }
            }
        });
        onInitializationFinished();
    }
}
