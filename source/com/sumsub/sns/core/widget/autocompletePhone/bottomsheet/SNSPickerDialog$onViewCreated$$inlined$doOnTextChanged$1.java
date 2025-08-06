package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Filter;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
public final class SNSPickerDialog$onViewCreated$$inlined$doOnTextChanged$1 implements TextWatcher {
    public final /* synthetic */ SNSPickerDialog.ItemAdapter $adapter$inlined;
    public final /* synthetic */ TextInputLayout $searchEditLayout$inlined;

    public SNSPickerDialog$onViewCreated$$inlined$doOnTextChanged$1(SNSPickerDialog.ItemAdapter itemAdapter, TextInputLayout textInputLayout) {
        this.$adapter$inlined = itemAdapter;
        this.$searchEditLayout$inlined = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        Filter filter = this.$adapter$inlined.getFilter();
        EditText editText = this.$searchEditLayout$inlined.getEditText();
        filter.filter(editText != null ? editText.getText() : null);
    }
}
