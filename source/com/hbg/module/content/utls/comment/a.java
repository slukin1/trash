package com.hbg.module.content.utls.comment;

import android.content.DialogInterface;
import android.widget.EditText;

public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f18894a;

    public /* synthetic */ a(EditText editText) {
        this.f18894a = editText;
    }

    public final void onShow(DialogInterface dialogInterface) {
        CommentExtKt.i(this.f18894a, dialogInterface);
    }
}
