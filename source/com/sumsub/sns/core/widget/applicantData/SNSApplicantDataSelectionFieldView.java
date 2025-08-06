package com.sumsub.sns.core.widget.applicantData;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.core.widget.SNSApplicantDataFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.internal.core.data.model.h;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016R6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataSelectionFieldView;", "Lcom/sumsub/sns/core/widget/SNSApplicantDataFieldView;", "Lcom/sumsub/sns/core/widget/applicantData/SNSApplicantDataBaseFieldView$Selectable;", "", "showDialog", "", "enabled", "setEnabled", "openSelector", "", "Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "aValue", "selectedItem", "Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;", "getSelectedItem", "()Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;", "setSelectedItem", "(Lcom/sumsub/sns/internal/core/data/model/h$e$a$a;)V", "Landroid/graphics/drawable/Drawable;", "endIcon", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Function1;", "onSelectedCallback", "Ld10/l;", "getOnSelectedCallback", "()Ld10/l;", "setOnSelectedCallback", "(Ld10/l;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
public final class SNSApplicantDataSelectionFieldView extends SNSApplicantDataFieldView implements SNSApplicantDataBaseFieldView.Selectable {
    private Drawable endIcon;
    private List<h.e.a.C0341a> items;
    private l<? super h.e.a.C0341a, Unit> onSelectedCallback;
    private h.e.a.C0341a selectedItem;

    public SNSApplicantDataSelectionFieldView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m44_init_$lambda0(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final void showDialog() {
        SNSAlertDialogBuilder sNSAlertDialogBuilder = new SNSAlertDialogBuilder(getContext());
        List<h.e.a.C0341a> list = this.items;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (h.e.a.C0341a d11 : list) {
            arrayList.add(d11.d());
        }
        sNSAlertDialogBuilder.setItems((CharSequence[]) arrayList.toArray(new String[0]), (DialogInterface.OnClickListener) new i(this)).setCancelable(true).setOnDismissListener((DialogInterface.OnDismissListener) new j(this)).create().show();
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [d10.l<? super com.sumsub.sns.internal.core.data.model.h$e$a$a, kotlin.Unit>, d10.l, android.content.DialogInterface] */
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    /* renamed from: showDialog$lambda-3  reason: not valid java name */
    public static final void m45showDialog$lambda3(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        sNSApplicantDataSelectionFieldView.setValue(sNSApplicantDataSelectionFieldView.items.get(i11).d());
        sNSApplicantDataSelectionFieldView.setSelectedItem(sNSApplicantDataSelectionFieldView.items.get(i11));
        ? r12 = sNSApplicantDataSelectionFieldView.onSelectedCallback;
        if (r12 != 0) {
            r12.invoke(sNSApplicantDataSelectionFieldView.items.get(i11));
        }
        SensorsDataAutoTrackHelper.trackDialog(r12, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-4  reason: not valid java name */
    public static final void m46showDialog$lambda4(SNSApplicantDataSelectionFieldView sNSApplicantDataSelectionFieldView, DialogInterface dialogInterface) {
        EditText editText;
        TextInputLayout inputLayout = sNSApplicantDataSelectionFieldView.getInputLayout();
        if (inputLayout != null && (editText = inputLayout.getEditText()) != null) {
            editText.clearFocus();
        }
    }

    public final List<h.e.a.C0341a> getItems() {
        return this.items;
    }

    public final l<h.e.a.C0341a, Unit> getOnSelectedCallback() {
        return this.onSelectedCallback;
    }

    public final h.e.a.C0341a getSelectedItem() {
        return this.selectedItem;
    }

    public void openSelector() {
        if (!this.items.isEmpty()) {
            showDialog();
        }
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        TextInputLayout inputLayout = getInputLayout();
        if (inputLayout != null) {
            inputLayout.setEndIconDrawable(z11 ? this.endIcon : null);
        }
    }

    public final void setItems(List<h.e.a.C0341a> list) {
        if (!x.b(this.items, list)) {
            this.items = list;
            if (!list.isEmpty()) {
                disableInput();
            } else {
                enableInput();
            }
        }
    }

    public final void setOnSelectedCallback(l<? super h.e.a.C0341a, Unit> lVar) {
        this.onSelectedCallback = lVar;
    }

    public final void setSelectedItem(h.e.a.C0341a aVar) {
        String str;
        this.selectedItem = aVar;
        if (aVar == null || (str = aVar.d()) == null) {
            str = "";
        }
        setValue(str);
    }

    public SNSApplicantDataSelectionFieldView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSApplicantDataSelectionFieldView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_applicantDataFieldViewStyle : i11);
    }

    public SNSApplicantDataSelectionFieldView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, 0, 8, (r) null);
        EditText editText;
        this.items = new ArrayList();
        GestureDetector gestureDetector = new GestureDetector(context, new SNSApplicantDataSelectionFieldView$gestureDetector$1(this));
        TextInputLayout inputLayout = getInputLayout();
        if (!(inputLayout == null || (editText = inputLayout.getEditText()) == null)) {
            editText.setOnTouchListener(new k(gestureDetector));
        }
        a aVar = a.f31095a;
        Drawable a11 = aVar.a(context, SNSIconHandler.SNSCommonIcons.MORE.getImageName());
        this.endIcon = a11 == null ? aVar.a(context, SNSIconHandler.SNSCommonIcons.DISCLOSURE.getImageName()) : a11;
        TextInputLayout inputLayout2 = getInputLayout();
        if (inputLayout2 != null) {
            inputLayout2.setEndIconDrawable(this.endIcon);
        }
        onInitializationFinished();
    }
}
