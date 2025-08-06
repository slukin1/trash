package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.view.ViewGroup;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerItemViewHolder;", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog;", "parentView", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSPickerDialog$onViewCreated$adapter$1 extends Lambda implements l<ViewGroup, SNSPickerDialog.PickerItemViewHolder> {
    public final /* synthetic */ SNSPickerDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPickerDialog$onViewCreated$adapter$1(SNSPickerDialog sNSPickerDialog) {
        super(1);
        this.this$0 = sNSPickerDialog;
    }

    public final SNSPickerDialog.PickerItemViewHolder invoke(ViewGroup viewGroup) {
        return this.this$0.createItemViewHolder(viewGroup);
    }
}
