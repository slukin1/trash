package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class HBSearchView extends LinearLayout implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener {
    private View.OnClickListener clearOnClickListener;
    private EditText editTextHbsSearchView;
    private ImageView imageViewHbSearchViewClear;
    private ImageView imageViewHbSearchViewIcon;

    public HBSearchView(Context context) {
        super(context);
        initView(context, (AttributeSet) null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        setBackgroundResource(R$drawable.selector_bh_search_view_background);
        LayoutInflater.from(context).inflate(R$layout.layout_hb_search_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HBSearchView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.HBSearchView_searchTextSize, context.getResources().getDimensionPixelOffset(R$dimen.global_text_size_12));
        int i11 = R$styleable.HBSearchView_textHintColor;
        int i12 = R$color.baseColorPrimaryText;
        int color = obtainStyledAttributes.getColor(i11, ContextCompat.getColor(context, i12));
        int color2 = obtainStyledAttributes.getColor(R$styleable.HBSearchView_iconColor, ContextCompat.getColor(context, i12));
        String string = obtainStyledAttributes.getString(R$styleable.HBSearchView_textHint);
        String string2 = obtainStyledAttributes.getString(R$styleable.HBSearchView_textDefault);
        this.imageViewHbSearchViewIcon = (ImageView) findViewById(R$id.image_view_hb_search_view_icon);
        this.editTextHbsSearchView = (EditText) findViewById(R$id.edit_text_hb_search_view);
        int i13 = R$id.image_view_hb_search_view_clear;
        this.imageViewHbSearchViewClear = (ImageView) findViewById(i13);
        this.imageViewHbSearchViewClear = (ImageView) findViewById(i13);
        setSearchHint(string);
        setSearchText(string2);
        setIconColor(color2);
        setTextSize(0, dimensionPixelOffset);
        this.editTextHbsSearchView.setHintTextColor(color);
        this.editTextHbsSearchView.addTextChangedListener(this);
        this.imageViewHbSearchViewClear.setOnClickListener(this);
        this.editTextHbsSearchView.setOnFocusChangeListener(this);
    }

    public void addTextChangeListener(TextWatcher textWatcher) {
        this.editTextHbsSearchView.addTextChangedListener(textWatcher);
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable)) {
            this.imageViewHbSearchViewClear.setVisibility(8);
        } else {
            this.imageViewHbSearchViewClear.setVisibility(0);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public EditText getEditTextHbsSearchView() {
        return this.editTextHbsSearchView;
    }

    public ImageView getImageViewHbSearchViewClear() {
        return this.imageViewHbSearchViewClear;
    }

    public ImageView getImageViewHbSearchViewIcon() {
        return this.imageViewHbSearchViewIcon;
    }

    public String getSearchText() {
        Editable text = this.editTextHbsSearchView.getText();
        return TextUtils.isEmpty(text) ? "" : text.toString();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.editTextHbsSearchView.setText("");
        View.OnClickListener onClickListener = this.clearOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onFocusChange(View view, boolean z11) {
        setSelected(z11);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void setClearOnClickListener(View.OnClickListener onClickListener) {
        this.clearOnClickListener = onClickListener;
    }

    public void setIconColor(int i11) {
        this.imageViewHbSearchViewIcon.setColorFilter(i11);
    }

    public void setInputActionType(int i11) {
        this.editTextHbsSearchView.setImeOptions(i11);
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        this.editTextHbsSearchView.setOnEditorActionListener(onEditorActionListener);
    }

    public void setSearchHint(String str) {
        this.editTextHbsSearchView.setHint(str);
    }

    public void setSearchText(String str) {
        this.editTextHbsSearchView.setText(str);
    }

    public void setSearchViewEmptyBackground() {
        setBackground((Drawable) null);
    }

    public void setSelection(int i11) {
        Editable text = this.editTextHbsSearchView.getText();
        if (!TextUtils.isEmpty(text)) {
            try {
                this.editTextHbsSearchView.setSelection(text.length());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setTextSize(int i11, int i12) {
        this.editTextHbsSearchView.setTextSize(i11, (float) i12);
    }

    public void setTextSize(int i11) {
        this.editTextHbsSearchView.setTextSize((float) i11);
    }

    public HBSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public HBSearchView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context, attributeSet);
    }
}
