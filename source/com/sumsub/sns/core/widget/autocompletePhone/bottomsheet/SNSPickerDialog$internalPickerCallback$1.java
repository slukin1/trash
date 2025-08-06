package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.os.Bundle;
import androidx.fragment.app.p;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$internalPickerCallback$1", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$PickerCallBack;", "onItemSelected", "", "item", "Lcom/sumsub/sns/core/widget/autocompletePhone/bottomsheet/SNSPickerDialog$Item;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSPickerDialog$internalPickerCallback$1 implements SNSPickerDialog.PickerCallBack {
    public final /* synthetic */ SNSPickerDialog this$0;

    public SNSPickerDialog$internalPickerCallback$1(SNSPickerDialog sNSPickerDialog) {
        this.this$0 = sNSPickerDialog;
    }

    public /* synthetic */ void onCancel() {
        e.a(this);
    }

    public /* synthetic */ void onDialogClose() {
        e.b(this);
    }

    public /* synthetic */ void onDismiss() {
        e.c(this);
    }

    public void onItemSelected(SNSPickerDialog.Item item) {
        Bundle arguments = this.this$0.getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString(SNSPickerDialog.EXTRA_REQUEST_KEY) : null;
        Bundle arguments2 = this.this$0.getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(SNSPickerDialog.EXTRA_RESULT_KEY);
        }
        if (string == null || str == null) {
            SNSPickerDialog.PickerCallBack pickerCallBack = this.this$0.getPickerCallBack();
            if (pickerCallBack != null) {
                pickerCallBack.onItemSelected(item);
            }
        } else {
            SNSPickerDialog sNSPickerDialog = this.this$0;
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, item);
            Unit unit = Unit.f56620a;
            p.a(sNSPickerDialog, string, bundle);
        }
        SNSPickerDialog.PickerCallBack pickerCallBack2 = this.this$0.getPickerCallBack();
        if (pickerCallBack2 != null) {
            pickerCallBack2.onDialogClose();
        }
        this.this$0.dismiss();
    }
}
