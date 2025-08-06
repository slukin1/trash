package com.hbg.module.content.utls.comment;

import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import d10.l;
import kotlin.jvm.internal.Ref$ObjectRef;
import rc.a;

public final /* synthetic */ class c implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HbEditText f18896b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f18897c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f18898d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f18899e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ a f18900f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l f18901g;

    public /* synthetic */ c(HbEditText hbEditText, FrameLayout frameLayout, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, a aVar, l lVar) {
        this.f18896b = hbEditText;
        this.f18897c = frameLayout;
        this.f18898d = ref$ObjectRef;
        this.f18899e = ref$ObjectRef2;
        this.f18900f = aVar;
        this.f18901g = lVar;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return CommentExtKt.f(this.f18896b, this.f18897c, this.f18898d, this.f18899e, this.f18900f, this.f18901g, textView, i11, keyEvent);
    }
}
