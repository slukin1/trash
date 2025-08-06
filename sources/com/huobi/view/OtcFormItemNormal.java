package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.zxing.client.android.clipboard.ClipboardInterface;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class OtcFormItemNormal extends RelativeLayout {
    private boolean canCopy = true;
    private View divider;
    private View.OnClickListener formOnClickListener;
    private TextView formTitle;
    private TextView formValue;
    private boolean isPayMethodStyle;
    private ImageView ivOtvCoin;
    private ImageView ivPayMethodIcon1;
    private ImageView ivPayMethodIcon2;
    private ImageView ivPayMethodIcon3;
    private Context mContext;
    private List<ImageView> payMethodIcons = new ArrayList(3);

    public OtcFormItemNormal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void hidePayMethodIcons() {
        for (ImageView visibility : this.payMethodIcons) {
            visibility.setVisibility(8);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OtcFormItem);
        String string = obtainStyledAttributes.getString(1);
        String string2 = obtainStyledAttributes.getString(3);
        int i11 = 0;
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        float dimension = obtainStyledAttributes.getDimension(8, (float) PixelUtils.a(12.0f));
        float dimension2 = obtainStyledAttributes.getDimension(6, (float) PixelUtils.a(12.0f));
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        boolean z11 = obtainStyledAttributes.getBoolean(5, false);
        this.canCopy = obtainStyledAttributes.getBoolean(0, true);
        this.isPayMethodStyle = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R.layout.item_otc_form_normal, this);
        setMinimumHeight(PixelUtils.a(50.0f));
        this.formTitle = (TextView) findViewById(R.id.tv_otc_form_title);
        this.formValue = (TextView) findViewById(R.id.tv_otc_form_value);
        this.ivOtvCoin = (ImageView) findViewById(R.id.iv_otc_coin);
        this.divider = findViewById(R.id.v_divider);
        this.ivPayMethodIcon1 = (ImageView) findViewById(R.id.iv_pay_method_icon_1);
        this.ivPayMethodIcon2 = (ImageView) findViewById(R.id.iv_pay_method_icon_2);
        this.ivPayMethodIcon3 = (ImageView) findViewById(R.id.iv_pay_method_icon_3);
        this.payMethodIcons.add(this.ivPayMethodIcon1);
        this.payMethodIcons.add(this.ivPayMethodIcon2);
        this.payMethodIcons.add(this.ivPayMethodIcon3);
        this.formTitle.setText(string);
        this.formValue.setText(string2);
        if (resourceId != 0) {
            this.ivOtvCoin.setImageResource(resourceId);
            this.ivOtvCoin.getLayoutParams().width = (int) dimension;
            this.ivOtvCoin.getLayoutParams().height = (int) dimension2;
        } else {
            this.ivOtvCoin.setVisibility(8);
        }
        if (resourceId2 != 0) {
            this.formValue.setCompoundDrawablesWithIntrinsicBounds(0, 0, resourceId2, 0);
        }
        View view = this.divider;
        if (!z11) {
            i11 = 8;
        }
        view.setVisibility(i11);
        setOnClickListener(new h1(this, context));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$init$0(Context context, View view) {
        if (this.canCopy && this.formOnClickListener == null) {
            ClipboardInterface.setCopyText(this.formValue.getText().toString(), context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View.OnClickListener getFormOnClickListener() {
        return this.formOnClickListener;
    }

    public TextView getFormTitleTextView() {
        return this.formTitle;
    }

    public String getFormValueText() {
        return this.formValue.getText().toString();
    }

    public ImageView getIvPayMethodIcon1() {
        return this.ivPayMethodIcon1;
    }

    public ImageView getIvPayMethodIcon2() {
        return this.ivPayMethodIcon2;
    }

    public ImageView getIvPayMethodIcon3() {
        return this.ivPayMethodIcon3;
    }

    public List<ImageView> getPayMethodIcons() {
        return this.payMethodIcons;
    }

    public boolean isCanCopy() {
        return this.canCopy;
    }

    public void setCanCopy(boolean z11) {
        this.canCopy = z11;
    }

    public void setDividerVisibility(boolean z11) {
        this.divider.setVisibility(z11 ? 0 : 8);
    }

    public void setFormOnClickListener(View.OnClickListener onClickListener) {
        this.formOnClickListener = onClickListener;
        setOnClickListener(onClickListener);
    }

    public void setFormTitleText(String str) {
        this.formTitle.setText(str);
    }

    public void setFormValueRightImage(int i11) {
        this.formValue.setCompoundDrawablesWithIntrinsicBounds(0, 0, i11, 0);
        this.formValue.setCompoundDrawablePadding(PixelUtils.a(3.0f));
    }

    public void setFormValueText(String str) {
        this.formValue.setText(str);
    }

    public void setMultiPayMethodStyle(int i11) {
        this.formValue.setVisibility(8);
        hidePayMethodIcons();
        for (int i12 = 0; i12 < i11; i12++) {
            this.payMethodIcons.get(i12).setVisibility(0);
        }
        setRightImageVisibility(0);
        setRightImageRes(R.drawable.otc_right_icon);
        setRightImageWidthAndHeight((float) PixelUtils.a(12.0f), (float) PixelUtils.a(12.0f));
    }

    public void setOnePayMethodStyle() {
        hidePayMethodIcons();
        this.formValue.setVisibility(0);
        this.payMethodIcons.get(2).setVisibility(0);
        setRightImageVisibility(8);
        this.formValue.setGravity(3);
        ((LinearLayout.LayoutParams) this.formValue.getLayoutParams()).setMargins(PixelUtils.a(10.0f), 0, 0, 0);
    }

    public void setRightImageRes(int i11) {
        if (i11 != 0) {
            this.ivOtvCoin.setVisibility(0);
        } else {
            this.ivOtvCoin.setVisibility(8);
        }
        this.ivOtvCoin.setImageResource(i11);
    }

    public void setRightImageVisibility(int i11) {
        this.ivOtvCoin.setVisibility(i11);
    }

    public void setRightImageWidthAndHeight(float f11, float f12) {
        this.ivOtvCoin.getLayoutParams().width = (int) f11;
        this.ivOtvCoin.getLayoutParams().height = (int) f12;
    }

    public OtcFormItemNormal(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
