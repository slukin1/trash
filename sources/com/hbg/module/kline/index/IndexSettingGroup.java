package com.hbg.module.kline.index;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import be.i;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;

public class IndexSettingGroup extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f23584b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f23585c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f23586d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f23587e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23588f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23589g;

    /* renamed from: h  reason: collision with root package name */
    public String f23590h;

    /* renamed from: i  reason: collision with root package name */
    public String f23591i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f23592j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23593k;

    /* renamed from: l  reason: collision with root package name */
    public String f23594l;

    /* renamed from: m  reason: collision with root package name */
    public final int f23595m = 1000;

    /* renamed from: n  reason: collision with root package name */
    public final int f23596n = 0;

    /* renamed from: o  reason: collision with root package name */
    public final String f23597o = "0";

    /* renamed from: p  reason: collision with root package name */
    public final int f23598p = 5;

    /* renamed from: q  reason: collision with root package name */
    public e f23599q;

    public class a implements View.OnFocusChangeListener {

        /* renamed from: com.hbg.module.kline.index.IndexSettingGroup$a$a  reason: collision with other inner class name */
        public class C0213a implements Runnable {
            public C0213a() {
            }

            public void run() {
                if (IndexSettingGroup.this.f23585c.getText() != null) {
                    IndexSettingGroup.this.f23585c.setSelection(IndexSettingGroup.this.f23585c.getText().toString().length());
                }
            }
        }

        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                ((InputMethodManager) IndexSettingGroup.this.getContext().getSystemService("input_method")).showSoftInput(view, 2);
                IndexSettingGroup.this.f23585c.postDelayed(new C0213a(), 5);
            }
            if (IndexSettingGroup.this.f23599q != null) {
                IndexSettingGroup.this.f23599q.c(z11, IndexSettingGroup.this);
            }
            if (IndexSettingGroup.this.f23586d.getVisibility() != 0) {
                IndexSettingGroup.this.f23585c.setTextColor(IndexSettingGroup.this.f23592j);
                IndexSettingGroup.this.f23585c.setSelected(!TextUtils.isEmpty(IndexSettingGroup.this.f23585c.getText().toString()) && !IndexSettingGroup.this.f23590h.endsWith(IndexSettingGroup.this.f23585c.getText().toString()));
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (IndexSettingGroup.this.f23586d.getVisibility() != 0) {
                IndexSettingGroup.this.f23585c.setTextColor(IndexSettingGroup.this.f23592j);
                IndexSettingGroup.this.f23585c.setSelected(!TextUtils.isEmpty(editable.toString()) && !IndexSettingGroup.this.f23590h.endsWith(editable.toString()));
            } else if (!IndexSettingGroup.this.f23586d.isSelected()) {
                IndexSettingGroup.this.f23585c.setTextColor(IndexSettingGroup.this.getColor());
            } else {
                IndexSettingGroup.this.f23585c.setTextColor(IndexSettingGroup.this.f23592j);
            }
            String obj = editable.toString();
            if (IndexSettingGroup.this.f23594l.equals(obj)) {
                IndexSettingGroup.this.f23585c.setSelection(IndexSettingGroup.this.f23585c.getText().toString().length());
                if (IndexSettingGroup.this.f23599q != null) {
                    IndexSettingGroup.this.f23599q.b(IndexSettingGroup.this.f23594l, IndexSettingGroup.this);
                }
            } else if (TextUtils.isEmpty(editable) || "0".equals(editable.toString())) {
                IndexSettingGroup.this.f23585c.setHint("");
                IndexSettingGroup.this.f23585c.setText("");
                if (IndexSettingGroup.this.f23599q != null) {
                    IndexSettingGroup.this.f23599q.b("", IndexSettingGroup.this);
                }
            } else if (!IndexSettingGroup.this.k(obj)) {
                if (IndexSettingGroup.this.f23599q != null) {
                    IndexSettingGroup.this.f23599q.b(IndexSettingGroup.this.f23594l, IndexSettingGroup.this);
                }
                IndexSettingGroup.this.f23585c.setText(IndexSettingGroup.this.f23594l);
                IndexSettingGroup.this.f23585c.setSelection(IndexSettingGroup.this.f23585c.getText().toString().length());
            } else if (m.k0(obj) < 0 || m.k0(obj) >= 1000) {
                if (IndexSettingGroup.this.f23599q != null) {
                    IndexSettingGroup.this.f23599q.b(IndexSettingGroup.this.f23594l, IndexSettingGroup.this);
                }
                IndexSettingGroup.this.f23585c.setText(IndexSettingGroup.this.f23594l);
                IndexSettingGroup.this.f23585c.setSelection(IndexSettingGroup.this.f23585c.getText().toString().length());
            } else {
                IndexSettingGroup.this.f23585c.setHint(String.valueOf(Integer.valueOf(obj)));
                if (IndexSettingGroup.this.f23599q != null) {
                    IndexSettingGroup.this.f23599q.b(String.valueOf(m.k0(obj)), IndexSettingGroup.this);
                }
                IndexSettingGroup.this.f23585c.setText(String.valueOf(m.k0(obj)));
                IndexSettingGroup.this.f23585c.setSelection(IndexSettingGroup.this.f23585c.getText().toString().length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            String unused = IndexSettingGroup.this.f23594l = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 6) {
                return false;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService("input_method");
            if (!inputMethodManager.isActive()) {
                return true;
            }
            inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
            return true;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            IndexSettingGroup indexSettingGroup = IndexSettingGroup.this;
            indexSettingGroup.setSelectStatus(!indexSettingGroup.f23586d.isSelected());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface e {
        void a(boolean z11);

        void b(String str, IndexSettingGroup indexSettingGroup);

        void c(boolean z11, IndexSettingGroup indexSettingGroup);
    }

    public IndexSettingGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R$layout.index_setting_group, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndexSettingGroup);
        this.f23587e = obtainStyledAttributes.getDrawable(R$styleable.IndexSettingGroup_imageviewDrawable);
        this.f23589g = obtainStyledAttributes.getBoolean(R$styleable.IndexSettingGroup_imageviewVisible, false);
        this.f23588f = obtainStyledAttributes.getDrawable(R$styleable.IndexSettingGroup_frameDrawable);
        this.f23590h = obtainStyledAttributes.getString(R$styleable.IndexSettingGroup_editTextHintText);
        this.f23591i = obtainStyledAttributes.getString(R$styleable.IndexSettingGroup_textViewHintText);
        this.f23593k = obtainStyledAttributes.getBoolean(R$styleable.IndexSettingGroup_needSeleted, false);
        this.f23592j = obtainStyledAttributes.getColorStateList(R$styleable.IndexSettingGroup_indexEditTextColor);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: private */
    public int getColor() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R$attr.kline_four_level_text_color, typedValue, true);
        return typedValue.data;
    }

    public String getEditText() {
        String charSequence = this.f23585c.getHint().toString();
        return TextUtils.isEmpty(charSequence) ? "" : charSequence;
    }

    public String getKey() {
        return this.f23591i;
    }

    public boolean getSelectVisible() {
        return this.f23586d.isShown();
    }

    public String getText() {
        String obj = this.f23585c.getText().toString();
        return TextUtils.isEmpty(obj) ? "" : obj;
    }

    public void j() {
        this.f23586d.setSelected(this.f23593k);
        this.f23585c.setSelected(this.f23593k);
        this.f23585c.setHint(this.f23590h);
        this.f23585c.setText(this.f23590h);
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(getApplicationWindowToken(), 0);
        }
    }

    public final boolean k(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean l() {
        return this.f23586d.isSelected();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f23584b = (TextView) findViewById(R$id.name_text);
        this.f23586d = (ImageView) findViewById(R$id.select);
        EditText editText = (EditText) findViewById(R$id.count_edittext);
        this.f23585c = editText;
        Drawable drawable = this.f23588f;
        if (drawable != null) {
            editText.setBackground(drawable);
        }
        this.f23585c.setTextColor(this.f23592j);
        this.f23584b.setText(this.f23591i);
        this.f23585c.setHint(this.f23590h);
        if (this.f23589g) {
            this.f23586d.setVisibility(0);
            this.f23586d.setImageDrawable(this.f23587e);
        } else {
            this.f23586d.setVisibility(8);
        }
        this.f23585c.setOnFocusChangeListener(new a());
        this.f23585c.addTextChangedListener(new b());
        if (this.f23593k) {
            this.f23586d.setSelected(true);
            EditText editText2 = this.f23585c;
            editText2.setText(editText2.getHint() == null ? "" : this.f23585c.getHint());
            this.f23585c.setSelected(true);
        }
        this.f23585c.setOnEditorActionListener(new c());
        this.f23586d.setOnClickListener(new d());
    }

    public void setBaseData(i iVar) {
        CharSequence charSequence = "";
        this.f23585c.setHint(TextUtils.isEmpty(iVar.b()) ? charSequence : iVar.b());
        boolean z11 = true;
        if (iVar.d()) {
            EditText editText = this.f23585c;
            if (editText.getHint() != null) {
                charSequence = this.f23585c.getHint();
            }
            editText.setText(charSequence);
            this.f23586d.setSelected(true);
            this.f23585c.setSelected(true);
            this.f23585c.setTextColor(this.f23592j);
            if (TextUtils.isEmpty(iVar.b()) || "0".equals(iVar.b())) {
                this.f23599q.a(false);
            } else {
                this.f23599q.a(true);
            }
        } else {
            EditText editText2 = this.f23585c;
            if (editText2.getHint() != null) {
                charSequence = this.f23585c.getHint();
            }
            editText2.setText(charSequence);
            this.f23586d.setSelected(false);
            this.f23585c.setSelected(false);
            this.f23585c.setTextColor(getColor());
            this.f23599q.a(false);
        }
        if (this.f23586d.getVisibility() != 0) {
            this.f23585c.setTextColor(this.f23592j);
            EditText editText3 = this.f23585c;
            if (!this.f23586d.isSelected() || TextUtils.isEmpty(this.f23585c.getText().toString()) || this.f23590h.endsWith(this.f23585c.getText().toString())) {
                z11 = false;
            }
            editText3.setSelected(z11);
        }
    }

    public void setCallback(e eVar) {
        this.f23599q = eVar;
    }

    public void setSelectStatus(boolean z11) {
        if (z11) {
            if (!this.f23586d.isSelected()) {
                this.f23586d.setSelected(true);
                this.f23585c.setSelected(true);
                this.f23599q.a(TextUtils.isEmpty(this.f23585c.getHint()));
                if (!TextUtils.isEmpty(this.f23585c.getText()) || !TextUtils.isEmpty(this.f23585c.getHint())) {
                    EditText editText = this.f23585c;
                    editText.setText(editText.getHint());
                }
            } else {
                return;
            }
        } else if (this.f23586d.isSelected()) {
            this.f23586d.setSelected(false);
            this.f23585c.setSelected(false);
            this.f23585c.setTextColor(getColor());
        } else {
            return;
        }
        if (this.f23586d.getVisibility() == 0) {
            this.f23599q.a(z11);
        } else {
            this.f23599q.a(true ^ TextUtils.isEmpty(this.f23585c.getHint()));
        }
    }
}
