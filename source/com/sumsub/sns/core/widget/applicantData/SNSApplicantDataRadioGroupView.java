package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.core.widget.SNSRadioGroup;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.l;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.sequences.g;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\b\b\u0002\u00101\u001a\u00020/¢\u0006\u0004\b2\u00103R>\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00022\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR(\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00168V@VX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R4\u0010'\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00108V@VX\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014¨\u00064"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataRadioGroupView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "", "Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;", "Lcom/sumsub/sns/core/widget/applicantData/Item;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Lcom/sumsub/sns/core/widget/SNSRadioGroup;", "getRadioGroup", "()Lcom/sumsub/sns/core/widget/SNSRadioGroup;", "radioGroup", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", "onSelectionChanged", "Ld10/l;", "getOnSelectionChanged", "()Ld10/l;", "setOnSelectionChanged", "(Ld10/l;)V", "getSelectedItem", "()Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;", "setSelectedItem", "(Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;)V", "selectedItem", "getError", "setError", "error", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataRadioGroupView extends SNSApplicantDataBaseFieldView {
    private List<h.e.a.C0341a> items;
    private l<? super String, Unit> onSelectionChanged;

    public SNSApplicantDataRadioGroupView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_items_$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final void m40_set_items_$lambda4$lambda3$lambda2(SNSApplicantDataRadioGroupView sNSApplicantDataRadioGroupView, CompoundButton compoundButton, boolean z11) {
        l<? super String, Unit> lVar;
        T t11 = null;
        sNSApplicantDataRadioGroupView.setError((CharSequence) null);
        Iterator<T> it2 = sNSApplicantDataRadioGroupView.items.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            String c11 = ((h.e.a.C0341a) next).c();
            Object tag = compoundButton.getTag();
            if (x.b(c11, tag instanceof String ? (String) tag : null)) {
                t11 = next;
                break;
            }
        }
        h.e.a.C0341a aVar = (h.e.a.C0341a) t11;
        if (aVar != null && z11 && (lVar = sNSApplicantDataRadioGroupView.onSelectionChanged) != null) {
            lVar.invoke(aVar.c());
        }
    }

    private final SNSRadioGroup getRadioGroup() {
        return (SNSRadioGroup) findViewById(R.id.sns_radiogroup);
    }

    public CharSequence getError() {
        TextView tvError = getTvError();
        if (tvError != null) {
            return tvError.getText();
        }
        return null;
    }

    public final List<h.e.a.C0341a> getItems() {
        return this.items;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence getLabel() {
        /*
            r1 = this;
            android.widget.TextView r0 = r1.getTvLabel$idensic_mobile_sdk_aar_release()
            if (r0 == 0) goto L_0x000c
            java.lang.CharSequence r0 = r0.getText()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView.getLabel():java.lang.CharSequence");
    }

    public final l<String, Unit> getOnSelectionChanged() {
        return this.onSelectionChanged;
    }

    public final h.e.a.C0341a getSelectedItem() {
        g<View> a11;
        g k11;
        g k12;
        g s11;
        Object n11;
        SNSRadioGroup radioGroup = getRadioGroup();
        T t11 = null;
        if (radioGroup == null || (a11 = ViewKt.a(radioGroup)) == null || (k11 = SequencesKt___SequencesKt.k(a11, SNSApplicantDataRadioGroupView$special$$inlined$filterIsInstance$1.INSTANCE)) == null || (k12 = SequencesKt___SequencesKt.k(k11, SNSApplicantDataRadioGroupView$selectedItem$1.INSTANCE)) == null || (s11 = SequencesKt___SequencesKt.s(k12, SNSApplicantDataRadioGroupView$selectedItem$2.INSTANCE)) == null || (n11 = SequencesKt___SequencesKt.n(s11)) == null) {
            return null;
        }
        Iterator<T> it2 = this.items.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (x.b(((h.e.a.C0341a) next).c(), n11 instanceof String ? (String) n11 : null)) {
                t11 = next;
                break;
            }
        }
        return (h.e.a.C0341a) t11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getValue() {
        /*
            r1 = this;
            com.sumsub.sns.internal.core.data.model.h$e$a$a r0 = r1.getSelectedItem()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.c()
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataRadioGroupView.getValue():java.lang.String");
    }

    public void setError(CharSequence charSequence) {
        SNSStepState sNSStepState;
        TextView tvError = getTvError();
        if (tvError != null) {
            i.a(tvError, charSequence);
        }
        SNSRadioGroup radioGroup = getRadioGroup();
        if (radioGroup != null) {
            if (charSequence == null || charSequence.length() == 0) {
                sNSStepState = SNSStepState.INIT;
            } else {
                sNSStepState = SNSStepState.REJECTED;
            }
            SNSStepViewExtensionsKt.setSnsStepState(radioGroup, sNSStepState);
        }
    }

    public final void setItems(List<h.e.a.C0341a> list) {
        SNSRadioGroup radioGroup = getRadioGroup();
        if (radioGroup != null) {
            radioGroup.removeAllViews();
        }
        for (h.e.a.C0341a aVar : list) {
            MaterialRadioButton materialRadioButton = new MaterialRadioButton(getContext());
            materialRadioButton.setText(aVar.d());
            materialRadioButton.setOnCheckedChangeListener(new e(this));
            materialRadioButton.setTag(aVar.c());
            SNSRadioGroup radioGroup2 = getRadioGroup();
            if (radioGroup2 != null) {
                radioGroup2.addView(materialRadioButton);
            }
            a.f31095a.a((TextView) materialRadioButton, SNSTypographyElement.SUBTITLE2, SNSColorElement.CONTENT_NEUTRAL);
        }
        this.items = list;
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public final void setOnSelectionChanged(l<? super String, Unit> lVar) {
        this.onSelectionChanged = lVar;
    }

    public final void setSelectedItem(h.e.a.C0341a aVar) {
        g<View> a11;
        g<RadioButton> k11;
        SNSRadioGroup radioGroup = getRadioGroup();
        if (radioGroup != null && (a11 = ViewKt.a(radioGroup)) != null && (k11 = SequencesKt___SequencesKt.k(a11, SNSApplicantDataRadioGroupView$special$$inlined$filterIsInstance$2.INSTANCE)) != null) {
            for (RadioButton radioButton : k11) {
                Object tag = radioButton.getTag();
                String str = null;
                String str2 = tag instanceof String ? (String) tag : null;
                if (aVar != null) {
                    str = aVar.c();
                }
                radioButton.setChecked(x.b(str2, str));
            }
        }
    }

    public void setValue(String str) {
        T t11;
        Iterator<T> it2 = this.items.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((h.e.a.C0341a) t11).c(), str)) {
                break;
            }
        }
        setSelectedItem((h.e.a.C0341a) t11);
    }

    public SNSApplicantDataRadioGroupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataRadioGroupView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataRadioGroupView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataRadioGroupViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataRadioGroupView : i12);
    }

    public SNSApplicantDataRadioGroupView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.items = CollectionsKt__CollectionsKt.k();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataRadioGroupView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataRadioGroupView_sns_applicantDataRadioGroupLayout, R.layout.sns_layout_applicant_data_radio_group_view), this, true);
        obtainStyledAttributes.recycle();
        onInitializationFinished();
    }
}
