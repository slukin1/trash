package com.hbg.module.content.utls.comment;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.FrameLayout;
import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CommentExtKt$createCommentDialog$2 extends Lambda implements a<Unit> {
    public final /* synthetic */ HbEditText $etContent;
    public final /* synthetic */ FrameLayout $flShowImage;
    public final /* synthetic */ rc.a $listener;
    public final /* synthetic */ l<String, Unit> $sendFunction;
    public final /* synthetic */ Ref$ObjectRef<String> $upLoadName;
    public final /* synthetic */ Ref$ObjectRef<Uri> $upLoadUri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommentExtKt$createCommentDialog$2(HbEditText hbEditText, FrameLayout frameLayout, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<Uri> ref$ObjectRef2, rc.a aVar, l<? super String, Unit> lVar) {
        super(0);
        this.$etContent = hbEditText;
        this.$flShowImage = frameLayout;
        this.$upLoadName = ref$ObjectRef;
        this.$upLoadUri = ref$ObjectRef2;
        this.$listener = aVar;
        this.$sendFunction = lVar;
    }

    public final void invoke() {
        String valueOf = String.valueOf(this.$etContent.getText());
        if (this.$flShowImage.getVisibility() == 8 || TextUtils.isEmpty((CharSequence) this.$upLoadName.element) || this.$upLoadUri.element == null) {
            if (valueOf.length() == 0) {
                return;
            }
        }
        rc.a aVar = this.$listener;
        if (aVar != null) {
            aVar.b();
        }
        this.$sendFunction.invoke(valueOf);
    }
}
