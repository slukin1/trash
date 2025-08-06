package com.hbg.module.content.utls.comment;

import android.content.DialogInterface;

public final /* synthetic */ class b implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HbEditText f18895a;

    public /* synthetic */ b(HbEditText hbEditText) {
        this.f18895a = hbEditText;
    }

    public final void onShow(DialogInterface dialogInterface) {
        CommentExtKt.g(this.f18895a, dialogInterface);
    }
}
