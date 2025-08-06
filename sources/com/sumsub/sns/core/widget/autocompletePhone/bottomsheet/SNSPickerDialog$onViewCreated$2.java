package com.sumsub.sns.core.widget.autocompletePhone.bottomsheet;

import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog$onViewCreated$2", f = "SNSPickerDialog.kt", l = {186}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SNSPickerDialog$onViewCreated$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ TextInputLayout $searchEditLayout;
    public int label;
    public final /* synthetic */ SNSPickerDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPickerDialog$onViewCreated$2(SNSPickerDialog sNSPickerDialog, TextInputLayout textInputLayout, c<? super SNSPickerDialog$onViewCreated$2> cVar) {
        super(2, cVar);
        this.this$0 = sNSPickerDialog;
        this.$searchEditLayout = textInputLayout;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SNSPickerDialog$onViewCreated$2(this.this$0, this.$searchEditLayout, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        a f11;
        b p11;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        EditText editText = null;
        if (i11 == 0) {
            k.b(obj);
            FragmentActivity requireActivity = this.this$0.requireActivity();
            com.sumsub.sns.core.presentation.a aVar = requireActivity instanceof com.sumsub.sns.core.presentation.a ? (com.sumsub.sns.core.presentation.a) requireActivity : null;
            if (!(aVar == null || (f11 = aVar.f()) == null || (p11 = f11.p()) == null)) {
                this.label = 1;
                obj = p11.d(this);
                if (obj == d11) {
                    return d11;
                }
            }
            return Unit.f56620a;
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.c cVar = (b.c) obj;
        if (cVar != null) {
            TextInputLayout textInputLayout = this.$searchEditLayout;
            if (textInputLayout != null) {
                editText = textInputLayout.getEditText();
            }
            if (editText != null) {
                editText.setHint(cVar.a("sns_general_search_placeholder"));
            }
        }
        return Unit.f56620a;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SNSPickerDialog$onViewCreated$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }
}
