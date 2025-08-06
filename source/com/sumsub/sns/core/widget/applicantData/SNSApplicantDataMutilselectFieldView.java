package com.sumsub.sns.core.widget.applicantData;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.core.widget.SNSCheckGroup;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.sequences.g;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010-\u001a\u00020+¢\u0006\u0004\b.\u0010/R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R6\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u00168V@VX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u00168V@VX\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001a¨\u00060"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataMutilselectFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView;", "", "isUpdating", "Z", "", "Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "aValue", "selectedItems", "getSelectedItems", "setSelectedItems", "Lcom/sumsub/sns/core/widget/SNSCheckGroup;", "getCheckGroup", "()Lcom/sumsub/sns/core/widget/SNSCheckGroup;", "checkGroup", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "Lkotlin/Function0;", "", "onSelectionChanged", "Ld10/a;", "getOnSelectionChanged", "()Ld10/a;", "setOnSelectionChanged", "(Ld10/a;)V", "getError", "setError", "error", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataMutilselectFieldView extends SNSApplicantDataBaseFieldView {
    private boolean isUpdating;
    private List<h.e.a.C0341a> items;
    private a<Unit> onSelectionChanged;
    private List<h.e.a.C0341a> selectedItems;

    public SNSApplicantDataMutilselectFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_items_$lambda-5$lambda-4$lambda-3  reason: not valid java name */
    public static final void m39_set_items_$lambda5$lambda4$lambda3(SNSApplicantDataMutilselectFieldView sNSApplicantDataMutilselectFieldView, CompoundButton compoundButton, boolean z11) {
        T t11 = null;
        sNSApplicantDataMutilselectFieldView.setError((CharSequence) null);
        String str = (String) compoundButton.getTag();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(sNSApplicantDataMutilselectFieldView.selectedItems);
        boolean unused = CollectionsKt__MutableCollectionsKt.G(arrayList, new SNSApplicantDataMutilselectFieldView$items$1$1$2$1(str));
        if (z11) {
            Iterator<T> it2 = sNSApplicantDataMutilselectFieldView.items.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (x.b(((h.e.a.C0341a) next).c(), str)) {
                    t11 = next;
                    break;
                }
            }
            h.e.a.C0341a aVar = (h.e.a.C0341a) t11;
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        if (!sNSApplicantDataMutilselectFieldView.isUpdating) {
            sNSApplicantDataMutilselectFieldView.setSelectedItems(arrayList);
            a<Unit> aVar2 = sNSApplicantDataMutilselectFieldView.onSelectionChanged;
            if (aVar2 != null) {
                aVar2.invoke();
            }
        }
    }

    private final SNSCheckGroup getCheckGroup() {
        return (SNSCheckGroup) findViewById(R.id.sns_checkgroup);
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
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.applicantData.SNSApplicantDataMutilselectFieldView.getLabel():java.lang.CharSequence");
    }

    public final a<Unit> getOnSelectionChanged() {
        return this.onSelectionChanged;
    }

    public final List<h.e.a.C0341a> getSelectedItems() {
        return this.selectedItems;
    }

    public void setError(CharSequence charSequence) {
        SNSStepState sNSStepState;
        TextView tvError = getTvError();
        if (tvError != null) {
            i.a(tvError, charSequence);
        }
        SNSCheckGroup checkGroup = getCheckGroup();
        if (checkGroup != null) {
            if (charSequence == null || charSequence.length() == 0) {
                sNSStepState = SNSStepState.INIT;
            } else {
                sNSStepState = SNSStepState.REJECTED;
            }
            SNSStepViewExtensionsKt.setSnsStepState(checkGroup, sNSStepState);
        }
    }

    public final void setItems(List<h.e.a.C0341a> list) {
        SNSCheckGroup checkGroup = getCheckGroup();
        if (checkGroup != null) {
            checkGroup.removeAllViews();
        }
        setSelectedItems(CollectionsKt__CollectionsKt.k());
        for (h.e.a.C0341a next : list) {
            MaterialCheckBox materialCheckBox = new MaterialCheckBox(getContext());
            String d11 = next.d();
            if (!Boolean.valueOf(d11.length() > 0).booleanValue()) {
                d11 = null;
            }
            if (d11 == null) {
                d11 = " ";
            }
            materialCheckBox.setText(d11);
            materialCheckBox.setOnCheckedChangeListener(new d(this));
            com.sumsub.sns.core.presentation.helper.a.f31095a.a((TextView) materialCheckBox, SNSTypographyElement.SUBTITLE2, SNSColorElement.CONTENT_NEUTRAL);
            materialCheckBox.setTag(next.c());
            SNSCheckGroup checkGroup2 = getCheckGroup();
            if (checkGroup2 != null) {
                checkGroup2.addView(materialCheckBox);
            }
        }
        this.items = list;
    }

    public void setLabel(CharSequence charSequence) {
        TextView tvLabel$idensic_mobile_sdk_aar_release = getTvLabel$idensic_mobile_sdk_aar_release();
        if (tvLabel$idensic_mobile_sdk_aar_release != null) {
            i.a(tvLabel$idensic_mobile_sdk_aar_release, charSequence);
        }
    }

    public final void setOnSelectionChanged(a<Unit> aVar) {
        this.onSelectionChanged = aVar;
    }

    public final void setSelectedItems(List<h.e.a.C0341a> list) {
        g<View> a11;
        boolean z11;
        this.isUpdating = true;
        SNSCheckGroup checkGroup = getCheckGroup();
        if (!(checkGroup == null || (a11 = ViewGroupKt.a(checkGroup)) == null)) {
            Iterator<View> it2 = a11.iterator();
            while (it2.hasNext()) {
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) it2.next();
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (x.b(((h.e.a.C0341a) it3.next()).c(), materialCheckBox.getTag())) {
                                z11 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    materialCheckBox.setChecked(z11);
                }
                z11 = false;
                materialCheckBox.setChecked(z11);
            }
        }
        this.isUpdating = false;
        this.selectedItems = list;
    }

    public SNSApplicantDataMutilselectFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSApplicantDataMutilselectFieldView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataMutilselectFieldView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_applicantDataMutilselectFieldViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSApplicantDataMutilselectFieldView : i12);
    }

    public SNSApplicantDataMutilselectFieldView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.items = new ArrayList();
        this.selectedItems = CollectionsKt__CollectionsKt.k();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSApplicantDataMutilselectFieldView, i11, i12);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSApplicantDataMutilselectFieldView_sns_applicantDataMutilselectFieldViewLayout, R.layout.sns_layout_applicant_data_multiselect_view), this, true);
        obtainStyledAttributes.recycle();
        onInitializationFinished();
    }
}
