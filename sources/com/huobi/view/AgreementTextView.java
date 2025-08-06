package com.huobi.view;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class AgreementTextView extends FrameLayout {
    private CompoundButton.OnCheckedChangeListener listener;
    private CheckBox mBox;
    private TextView mBoxContent;

    public AgreementTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addEvent() {
        this.mBox.setOnCheckedChangeListener(new a(this));
    }

    private void initView() {
        this.mBox = (CheckBox) findViewById(R.id.agreement_check_icon);
        this.mBoxContent = (TextView) findViewById(R.id.agreement_content);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(CompoundButton compoundButton, boolean z11) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.listener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public boolean isChecked() {
        return this.mBox.isChecked();
    }

    public void setBoxContent(CharSequence charSequence) {
        this.mBoxContent.setText(charSequence);
    }

    public void setLinkMovementMethod() {
        this.mBoxContent.setHighlightColor(0);
        this.mBoxContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.listener = onCheckedChangeListener;
    }

    public AgreementTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AgreementTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R.layout.transfer_agreement_view, this, true);
        initView();
        addEvent();
    }
}
