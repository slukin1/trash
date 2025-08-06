package com.hbg.module.huobi.im.group.ui.barrage;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.lang.ref.WeakReference;

public class b extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public final InputMethodManager f20417b;

    /* renamed from: c  reason: collision with root package name */
    public f f20418c;

    /* renamed from: d  reason: collision with root package name */
    public Context f20419d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f20420e;

    /* renamed from: f  reason: collision with root package name */
    public Button f20421f;

    /* renamed from: g  reason: collision with root package name */
    public View f20422g;

    /* renamed from: h  reason: collision with root package name */
    public View f20423h;

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<e> f20424i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String trim = b.this.f20420e.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                b.this.f20418c.onTextSend(trim);
                b.this.f20417b.showSoftInput(b.this.f20420e, 2);
                b.this.f20417b.hideSoftInputFromWindow(b.this.f20420e.getWindowToken(), 0);
                b.this.f20420e.setText("");
                b.this.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbg.module.huobi.im.group.ui.barrage.b$b  reason: collision with other inner class name */
    public class C0155b implements TextView.OnEditorActionListener {
        public C0155b() {
        }

        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 4) {
                return false;
            }
            String trim = b.this.f20420e.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                return true;
            }
            b.this.f20418c.onTextSend(trim);
            b.this.f20417b.showSoftInput(b.this.f20420e, 2);
            b.this.f20417b.hideSoftInputFromWindow(b.this.f20420e.getWindowToken(), 0);
            b.this.f20420e.setText("");
            b.this.dismiss();
            return true;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (view.getId() != R.id.ll_input_view) {
                b.this.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.this.f20417b.hideSoftInputFromWindow(b.this.f20420e.getWindowToken(), 0);
            b.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface e {
        void onHide(String str);
    }

    public interface f {
        void onTextSend(String str);
    }

    public b(Context context) {
        super(context, R.style.TUIBarrageInputDialog);
        setContentView(R.layout.tuibarrage_dialog_send);
        this.f20419d = context;
        this.f20417b = (InputMethodManager) context.getSystemService("input_method");
        g();
        f();
    }

    public void d(String str, String str2) {
        int selectionEnd;
        EditText editText = this.f20420e;
        if (editText != null && editText.getText() != null && (selectionEnd = this.f20420e.getSelectionEnd()) != -1) {
            String str3 = TIMMentionEditText.TIM_MENTION_TAG + str;
            FaceManager.handlerEmojiText(this.f20420e, this.f20420e.getText().insert(selectionEnd, str3).toString(), true);
            this.f20420e.setSelection(selectionEnd + str3.length());
        }
    }

    public void e() {
        this.f20420e.requestFocus();
        this.f20417b.showSoftInput(this.f20420e, 2);
    }

    public final void f() {
        this.f20421f.setOnClickListener(new a());
        this.f20420e.setOnEditorActionListener(new C0155b());
        this.f20422g.setOnClickListener(new c());
        this.f20423h.setOnClickListener(new d());
    }

    public final void g() {
        this.f20420e = (EditText) findViewById(R.id.et_input_message);
        this.f20421f = (Button) findViewById(R.id.btn_send);
        this.f20422g = findViewById(R.id.ll_outside_view);
        this.f20423h = findViewById(R.id.ll_input_view);
    }

    public void h(e eVar) {
        this.f20424i = new WeakReference<>(eVar);
    }

    public void i(f fVar) {
        this.f20418c = fVar;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<e> weakReference = this.f20424i;
        if (weakReference != null && weakReference.get() != null) {
            String obj = this.f20420e.getText().toString();
            if (obj == null) {
                obj = "";
            }
            ((e) this.f20424i.get()).onHide(obj);
        }
    }
}
