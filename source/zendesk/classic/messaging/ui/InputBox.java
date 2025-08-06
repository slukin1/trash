package zendesk.classic.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$drawable;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.commonui.TextWatcherAdapter;
import zendesk.commonui.UiUtils;

public class InputBox extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f62663b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f62664c;

    /* renamed from: d  reason: collision with root package name */
    public AttachmentsIndicator f62665d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62666e;

    /* renamed from: f  reason: collision with root package name */
    public f f62667f;

    /* renamed from: g  reason: collision with root package name */
    public TextWatcher f62668g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f62669h;

    /* renamed from: i  reason: collision with root package name */
    public final List<View.OnClickListener> f62670i = new ArrayList();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            InputBox.this.f62664c.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) InputBox.this.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.toggleSoftInput(2, 1);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (InputBox.this.f62669h != null) {
                InputBox.this.f62669h.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (InputBox.this.f62667f != null && InputBox.this.f62667f.a(InputBox.this.f62664c.getText().toString().trim())) {
                InputBox.this.f62665d.d();
                InputBox.this.f62664c.setText((CharSequence) null);
            }
            for (View.OnClickListener onClick : InputBox.this.f62670i) {
                onClick.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d extends TextWatcherAdapter {
        public d() {
        }

        public void afterTextChanged(Editable editable) {
            boolean c11 = mz.f.c(editable.toString());
            boolean z11 = true;
            boolean z12 = InputBox.this.f62665d.getAttachmentsCount() > 0;
            InputBox inputBox = InputBox.this;
            if (!c11 && !z12) {
                z11 = false;
            }
            inputBox.n(z11);
            if (InputBox.this.f62668g != null) {
                InputBox.this.f62668g.afterTextChanged(editable);
            }
        }
    }

    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                InputBox.this.f62663b.setBackgroundResource(R$drawable.zui_background_composer_selected);
            } else {
                InputBox.this.f62663b.setBackgroundResource(R$drawable.zui_background_composer_inactive);
            }
        }
    }

    public interface f {
        boolean a(String str);
    }

    public InputBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o(context);
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            this.f62664c.clearFocus();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return !isEnabled() || super.dispatchTouchEvent(motionEvent);
    }

    public boolean i(View.OnClickListener onClickListener) {
        return this.f62670i.add(onClickListener);
    }

    public final void j() {
        this.f62663b = (FrameLayout) findViewById(R$id.zui_view_input_box);
        this.f62664c = (EditText) findViewById(R$id.input_box_input_text);
        this.f62665d = (AttachmentsIndicator) findViewById(R$id.input_box_attachments_indicator);
        this.f62666e = (ImageView) findViewById(R$id.input_box_send_btn);
    }

    public final void k() {
        this.f62663b.setOnClickListener(new a());
        this.f62665d.setOnClickListener(new b());
        this.f62666e.setOnClickListener(new c());
        this.f62664c.addTextChangedListener(new d());
        this.f62664c.setOnFocusChangeListener(new e());
    }

    public final void l(boolean z11) {
        if (z11) {
            this.f62665d.setEnabled(true);
            this.f62665d.setVisibility(0);
            m(true);
            return;
        }
        this.f62665d.setEnabled(false);
        this.f62665d.setVisibility(8);
        m(false);
    }

    public final void m(boolean z11) {
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.zui_input_box_expanded_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.zui_input_box_collapsed_side_margin);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f62664c.getLayoutParams();
        if (z11) {
            dimensionPixelSize = dimensionPixelSize2;
        }
        layoutParams.leftMargin = dimensionPixelSize;
        this.f62664c.setLayoutParams(layoutParams);
    }

    public final void n(boolean z11) {
        int i11;
        Context context = getContext();
        if (z11) {
            i11 = UiUtils.c(R$attr.colorPrimary, context, R$color.zui_color_primary);
        } else {
            i11 = UiUtils.a(R$color.zui_color_disabled, context);
        }
        this.f62666e.setEnabled(z11);
        UiUtils.b(i11, this.f62666e.getDrawable(), this.f62666e);
    }

    public final void o(Context context) {
        FrameLayout.inflate(context, R$layout.zui_view_input_box, this);
        if (!isInEditMode()) {
            j();
            k();
            l(false);
            n(false);
        }
    }

    public boolean requestFocus(int i11, Rect rect) {
        return this.f62664c.requestFocus();
    }

    public void setAttachmentsCount(int i11) {
        this.f62665d.setAttachmentsCount(i11);
        boolean c11 = mz.f.c(this.f62664c.getText().toString());
        boolean z11 = true;
        boolean z12 = this.f62665d.getAttachmentsCount() > 0;
        if (!c11 && !z12) {
            z11 = false;
        }
        n(z11);
    }

    public void setAttachmentsIndicatorClickListener(View.OnClickListener onClickListener) {
        this.f62669h = onClickListener;
        l(onClickListener != null);
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.f62664c.setEnabled(z11);
        if (!z11) {
            this.f62664c.clearFocus();
        }
        this.f62663b.setEnabled(z11);
        float f11 = 1.0f;
        this.f62666e.setAlpha(z11 ? 1.0f : 0.2f);
        AttachmentsIndicator attachmentsIndicator = this.f62665d;
        if (!z11) {
            f11 = 0.2f;
        }
        attachmentsIndicator.setAlpha(f11);
    }

    public void setHint(String str) {
        this.f62664c.setHint(str);
    }

    public void setInputTextConsumer(f fVar) {
        this.f62667f = fVar;
    }

    public void setInputTextWatcher(TextWatcher textWatcher) {
        this.f62668g = textWatcher;
    }

    public void setInputType(Integer num) {
        this.f62664c.setInputType(num.intValue());
    }

    public InputBox(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        o(context);
    }
}
