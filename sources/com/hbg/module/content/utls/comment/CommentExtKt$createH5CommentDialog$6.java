package com.hbg.module.content.utls.comment;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import rc.b;

public final class CommentExtKt$createH5CommentDialog$6 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f18861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f18862c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f18863d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Uri> f18864e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ b f18865f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Dialog f18866g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f18867h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<String> f18868i;

    public CommentExtKt$createH5CommentDialog$6(EditText editText, FrameLayout frameLayout, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<Uri> ref$ObjectRef2, b bVar, Dialog dialog, Activity activity, Ref$ObjectRef<String> ref$ObjectRef3) {
        this.f18861b = editText;
        this.f18862c = frameLayout;
        this.f18863d = ref$ObjectRef;
        this.f18864e = ref$ObjectRef2;
        this.f18865f = bVar;
        this.f18866g = dialog;
        this.f18867h = activity;
        this.f18868i = ref$ObjectRef3;
    }

    public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        boolean z11 = false;
        if (i11 != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        if (keyEvent != null && (keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 1)) {
            return true;
        }
        String obj = this.f18861b.getText().toString();
        if (this.f18862c.getVisibility() == 8 || TextUtils.isEmpty((CharSequence) this.f18863d.element) || this.f18864e.element == null) {
            if (obj.length() == 0) {
                z11 = true;
            }
            if (z11) {
                return true;
            }
        }
        if (this.f18862c.getVisibility() != 0 || this.f18864e.element == null) {
            b bVar = this.f18865f;
            if (bVar != null) {
                bVar.a(obj, "");
            }
        } else {
            RequestExtKt.d(v7.b.a().getS3Token(), new CommentExtKt$createH5CommentDialog$6$onEditorAction$1(this.f18864e, this.f18867h, this.f18868i, this.f18865f, obj, this.f18863d), CommentExtKt$createH5CommentDialog$6$onEditorAction$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        }
        this.f18866g.dismiss();
        return true;
    }
}
