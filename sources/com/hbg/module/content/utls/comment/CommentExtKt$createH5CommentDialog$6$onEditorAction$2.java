package com.hbg.module.content.utls.comment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;
import i6.d;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommentExtKt$createH5CommentDialog$6$onEditorAction$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public static final CommentExtKt$createH5CommentDialog$6$onEditorAction$2 INSTANCE = new CommentExtKt$createH5CommentDialog$6$onEditorAction$2();

    public CommentExtKt$createH5CommentDialog$6$onEditorAction$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("s3Token :onError : ");
        sb2.append(aPIStatusErrorException != null ? aPIStatusErrorException.getErrMsg() : null);
        d.c("SendComment", sb2.toString());
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        }
    }
}
