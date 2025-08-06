package com.hbg.module.content.utls.comment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.jvm.internal.Ref$ObjectRef;
import rd.s;

public final class CommentExtKt {

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18848c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18849d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18850e;

        public a(View view, long j11, FragmentActivity fragmentActivity, Ref$ObjectRef ref$ObjectRef) {
            this.f18847b = view;
            this.f18848c = j11;
            this.f18849d = fragmentActivity;
            this.f18850e = ref$ObjectRef;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18847b) > this.f18848c || (this.f18847b instanceof Checkable)) {
                sVar.e(this.f18847b, currentTimeMillis);
                FrameLayout frameLayout = (FrameLayout) this.f18847b;
                FragmentActivity fragmentActivity = this.f18849d;
                ImageData[] imageDataArr = new ImageData[1];
                Uri uri = (Uri) this.f18850e.element;
                String str = null;
                String uri2 = uri != null ? uri.toString() : null;
                Uri uri3 = (Uri) this.f18850e.element;
                if (uri3 != null) {
                    str = uri3.toString();
                }
                imageDataArr[0] = new ImageData(uri2, str);
                PhotoViewerUtils.a(fragmentActivity, CollectionsKt__CollectionsKt.p(imageDataArr), 0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18851b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18852c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18853d;

        public b(View view, long j11, FrameLayout frameLayout) {
            this.f18851b = view;
            this.f18852c = j11;
            this.f18853d = frameLayout;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18851b) > this.f18852c || (this.f18851b instanceof Checkable)) {
                sVar.e(this.f18851b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f18851b;
                this.f18853d.setVisibility(8);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18854b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18855c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18856d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f18857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18858f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18859g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18860h;

        public c(View view, long j11, FragmentActivity fragmentActivity, AppCompatImageView appCompatImageView, FrameLayout frameLayout, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
            this.f18854b = view;
            this.f18855c = j11;
            this.f18856d = fragmentActivity;
            this.f18857e = appCompatImageView;
            this.f18858f = frameLayout;
            this.f18859g = ref$ObjectRef;
            this.f18860h = ref$ObjectRef2;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18854b) > this.f18855c || (this.f18854b instanceof Checkable)) {
                sVar.e(this.f18854b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f18854b;
                hc.d.f19133a.h(this.f18856d, new d(this.f18857e, this.f18858f, this.f18859g, this.f18860h));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements hc.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f18869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18870b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Uri> f18871c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f18872d;

        public d(AppCompatImageView appCompatImageView, FrameLayout frameLayout, Ref$ObjectRef<Uri> ref$ObjectRef, Ref$ObjectRef<String> ref$ObjectRef2) {
            this.f18869a = appCompatImageView;
            this.f18870b = frameLayout;
            this.f18871c = ref$ObjectRef;
            this.f18872d = ref$ObjectRef2;
        }

        public void a(Uri uri, String str) {
            this.f18869a.setImageURI(uri);
            this.f18870b.setVisibility(0);
            this.f18871c.element = uri;
            this.f18872d.element = str;
        }
    }

    public static final class e implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18873b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18874c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Activity f18875d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18876e;

        public f(View view, long j11, Activity activity, Ref$ObjectRef ref$ObjectRef) {
            this.f18873b = view;
            this.f18874c = j11;
            this.f18875d = activity;
            this.f18876e = ref$ObjectRef;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18873b) > this.f18874c || (this.f18873b instanceof Checkable)) {
                sVar.e(this.f18873b, currentTimeMillis);
                FrameLayout frameLayout = (FrameLayout) this.f18873b;
                Activity activity = this.f18875d;
                ImageData[] imageDataArr = new ImageData[1];
                Uri uri = (Uri) this.f18876e.element;
                String str = null;
                String uri2 = uri != null ? uri.toString() : null;
                Uri uri3 = (Uri) this.f18876e.element;
                if (uri3 != null) {
                    str = uri3.toString();
                }
                imageDataArr[0] = new ImageData(uri2, str);
                PhotoViewerUtils.a(activity, CollectionsKt__CollectionsKt.p(imageDataArr), 0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18877b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18878c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18879d;

        public g(View view, long j11, FrameLayout frameLayout) {
            this.f18877b = view;
            this.f18878c = j11;
            this.f18879d = frameLayout;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18877b) > this.f18878c || (this.f18877b instanceof Checkable)) {
                sVar.e(this.f18877b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f18877b;
                this.f18879d.setVisibility(8);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class h implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f18881c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Activity f18882d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f18883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18884f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18885g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f18886h;

        public h(View view, long j11, Activity activity, AppCompatImageView appCompatImageView, FrameLayout frameLayout, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
            this.f18880b = view;
            this.f18881c = j11;
            this.f18882d = activity;
            this.f18883e = appCompatImageView;
            this.f18884f = frameLayout;
            this.f18885g = ref$ObjectRef;
            this.f18886h = ref$ObjectRef2;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f18880b) > this.f18881c || (this.f18880b instanceof Checkable)) {
                sVar.e(this.f18880b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f18880b;
                hc.d.f19133a.h(this.f18882d, new i(this.f18883e, this.f18884f, this.f18885g, this.f18886h));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class i implements hc.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f18887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f18888b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Uri> f18889c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f18890d;

        public i(AppCompatImageView appCompatImageView, FrameLayout frameLayout, Ref$ObjectRef<Uri> ref$ObjectRef, Ref$ObjectRef<String> ref$ObjectRef2) {
            this.f18887a = appCompatImageView;
            this.f18888b = frameLayout;
            this.f18889c = ref$ObjectRef;
            this.f18890d = ref$ObjectRef2;
        }

        public void a(Uri uri, String str) {
            this.f18887a.setImageURI(uri);
            this.f18888b.setVisibility(0);
            this.f18889c.element = uri;
            this.f18890d.element = str;
        }
    }

    public static final class j implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final void d(FragmentActivity fragmentActivity, String str, String str2, String str3, rc.a aVar, String str4, String str5, String str6) {
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            Dialog d11 = f.d(f.f18904a, fragmentActivity, R$layout.dialog_comment, 80, R$color.transparent, true, 0, true, true, false, R$style.inputDialog, 256, (Object) null);
            HbEditText hbEditText = (HbEditText) d11.findViewById(R$id.etComment);
            FrameLayout frameLayout = (FrameLayout) d11.findViewById(R$id.flShowImage);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = "";
            Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef2;
            AppCompatImageView appCompatImageView = (AppCompatImageView) d11.findViewById(R$id.aivDeleteImage);
            FrameLayout frameLayout2 = frameLayout;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) d11.findViewById(R$id.aivChooseImage);
            HbEditText hbEditText2 = hbEditText;
            FrameLayout frameLayout3 = frameLayout2;
            Ref$ObjectRef ref$ObjectRef5 = ref$ObjectRef3;
            Ref$ObjectRef ref$ObjectRef6 = ref$ObjectRef;
            rc.a aVar2 = aVar;
            CommentExtKt$createCommentDialog$sendFunction$1 commentExtKt$createCommentDialog$sendFunction$1 = new CommentExtKt$createCommentDialog$sendFunction$1(frameLayout, ref$ObjectRef, str, str2, str4, str5, d11, fragmentActivity, aVar, ref$ObjectRef4, ref$ObjectRef3);
            hbEditText.setOnEditorActionListener(new c(hbEditText2, frameLayout3, ref$ObjectRef5, ref$ObjectRef6, aVar2, commentExtKt$createCommentDialog$sendFunction$1));
            hbEditText.setOnSendListener(new CommentExtKt$createCommentDialog$2(hbEditText2, frameLayout3, ref$ObjectRef5, ref$ObjectRef6, aVar2, commentExtKt$createCommentDialog$sendFunction$1));
            s sVar = s.f23381a;
            FrameLayout frameLayout4 = frameLayout2;
            frameLayout4.setOnClickListener(new a(frameLayout2, 800, fragmentActivity, ref$ObjectRef));
            appCompatImageView.setOnClickListener(new b(appCompatImageView, 800, frameLayout4));
            appCompatImageView2.setOnClickListener(new c(appCompatImageView2, 800, fragmentActivity, (AppCompatImageView) d11.findViewById(R$id.aivShowImage), frameLayout4, ref$ObjectRef, ref$ObjectRef3));
            hbEditText.setHint(str6);
            d11.setOnShowListener(new b(hbEditText));
            hbEditText.addTextChangedListener(new e());
            d11.show();
            SoftInputUtils.m(fragmentActivity, hbEditText);
        }
    }

    public static /* synthetic */ void e(FragmentActivity fragmentActivity, String str, String str2, String str3, rc.a aVar, String str4, String str5, String str6, int i11, Object obj) {
        d(fragmentActivity, str, str2, str3, aVar, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? com.hbg.module.libkt.base.ext.b.j(R$string.n_write_comment) : str6);
    }

    public static final boolean f(HbEditText hbEditText, FrameLayout frameLayout, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, rc.a aVar, l lVar, TextView textView, int i11, KeyEvent keyEvent) {
        String valueOf = String.valueOf(hbEditText.getText());
        if (frameLayout.getVisibility() == 8 || TextUtils.isEmpty((CharSequence) ref$ObjectRef.element) || ref$ObjectRef2.element == null) {
            if (valueOf.length() == 0) {
                return false;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
        lVar.invoke(valueOf);
        return false;
    }

    public static final void g(HbEditText hbEditText, DialogInterface dialogInterface) {
        hbEditText.requestFocus();
        hbEditText.setSelection(String.valueOf(hbEditText.getText()).length());
    }

    public static final void h(Activity activity, String str, rc.b bVar) {
        if (activity != null && !activity.isFinishing()) {
            Dialog d11 = f.d(f.f18904a, activity, R$layout.dialog_comment, 80, R$color.transparent, false, 0, true, true, false, R$style.inputDialog, 256, (Object) null);
            EditText editText = (EditText) d11.findViewById(R$id.etComment);
            AppCompatImageView appCompatImageView = (AppCompatImageView) d11.findViewById(R$id.aivChooseImage);
            FrameLayout frameLayout = (FrameLayout) d11.findViewById(R$id.flShowImage);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) d11.findViewById(R$id.aivDeleteImage);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = "";
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            s sVar = s.f23381a;
            Activity activity2 = activity;
            frameLayout.setOnClickListener(new f(frameLayout, 800, activity2, ref$ObjectRef));
            appCompatImageView2.setOnClickListener(new g(appCompatImageView2, 800, frameLayout));
            Ref$ObjectRef ref$ObjectRef4 = ref$ObjectRef3;
            h hVar = r0;
            h hVar2 = new h(appCompatImageView, 800, activity2, (AppCompatImageView) d11.findViewById(R$id.aivShowImage), frameLayout, ref$ObjectRef, ref$ObjectRef2);
            appCompatImageView.setOnClickListener(hVar);
            if (editText != null) {
                editText.setHint(str);
            }
            d11.setOnShowListener(new a(editText));
            editText.addTextChangedListener(new j());
            editText.setOnEditorActionListener(new CommentExtKt$createH5CommentDialog$6(editText, frameLayout, ref$ObjectRef2, ref$ObjectRef, bVar, d11, activity, ref$ObjectRef4));
            d11.show();
            com.hbg.module.libkt.base.ext.b.S(activity);
        }
    }

    public static final void i(EditText editText, DialogInterface dialogInterface) {
        editText.requestFocus();
        editText.setSelection(editText.getText().toString().length());
    }

    public static final int j(float f11, float f12, int i11) {
        float f13 = (f12 / f11) * ((float) i11);
        if (f13 > ((float) com.hbg.module.libkt.base.ext.c.a(158.0f))) {
            return com.hbg.module.libkt.base.ext.c.a(158.0f);
        }
        return f13 < ((float) com.hbg.module.libkt.base.ext.c.a(20.0f)) ? com.hbg.module.libkt.base.ext.c.a(20.0f) : (int) f13;
    }
}
