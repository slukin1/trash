package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huobi.contract.entity.PriceType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class PriceTypeLabelsView extends ConstraintLayout {
    private PriceTypeLabel mCurrentLabel;
    private final List<TextView> mLabelTextViews;
    private OnItemSelectedListener mOnItemSelectedListener;
    private final List<PriceTypeLabel> mPriceTypeLabels;

    public interface OnItemSelectedListener {
        void onItemSelected(PriceTypeLabel priceTypeLabel);
    }

    public static class PriceTypeLabel {
        /* access modifiers changed from: private */
        public boolean selected;
        /* access modifiers changed from: private */
        public final PriceType type;

        public PriceTypeLabel(PriceType priceType, boolean z11) {
            this.type = priceType;
            this.selected = z11;
        }

        public PriceType getType() {
            return this.type;
        }

        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean z11) {
            this.selected = z11;
        }
    }

    public PriceTypeLabelsView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void bindItemData(TextView textView, PriceTypeLabel priceTypeLabel) {
        textView.setText(priceTypeLabel.type.getName());
        textView.setTextColor(getColor(priceTypeLabel.selected));
        textView.setOnClickListener(new l1(this, priceTypeLabel));
    }

    private int getColor(boolean z11) {
        return getResources().getColor(z11 ? R.color.baseColorMajorTheme100 : R.color.baseColorPrimaryText);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_optimal_price_labels, this);
        this.mPriceTypeLabels.add(new PriceTypeLabel(PriceType.OPTIMAL_FIVE, false));
        this.mPriceTypeLabels.add(new PriceTypeLabel(PriceType.OPTIMAL_TEN, false));
        this.mPriceTypeLabels.add(new PriceTypeLabel(PriceType.OPTIMAL_TWENTY, false));
        this.mLabelTextViews.add((TextView) findViewById(R.id.optimal_five));
        this.mLabelTextViews.add((TextView) findViewById(R.id.optimal_ten));
        this.mLabelTextViews.add((TextView) findViewById(R.id.optimal_twenty));
        for (int i11 = 0; i11 < this.mPriceTypeLabels.size(); i11++) {
            bindItemData(this.mLabelTextViews.get(i11), this.mPriceTypeLabels.get(i11));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$bindItemData$0(PriceTypeLabel priceTypeLabel, View view) {
        setSelected(priceTypeLabel.type);
        OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(priceTypeLabel);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public PriceTypeLabel getCurrentLabel() {
        return this.mCurrentLabel;
    }

    public List<PriceTypeLabel> getLabels() {
        return this.mPriceTypeLabels;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    public void setSelected(PriceType priceType) {
        for (int i11 = 0; i11 < this.mPriceTypeLabels.size(); i11++) {
            TextView textView = this.mLabelTextViews.get(i11);
            PriceTypeLabel priceTypeLabel = this.mPriceTypeLabels.get(i11);
            boolean unused = priceTypeLabel.selected = priceTypeLabel.type == priceType;
            if (priceTypeLabel.selected) {
                this.mCurrentLabel = priceTypeLabel;
            }
            textView.setTextColor(getColor(priceTypeLabel.selected));
        }
    }

    public PriceTypeLabelsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PriceTypeLabelsView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public PriceTypeLabelsView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mPriceTypeLabels = new ArrayList();
        this.mLabelTextViews = new ArrayList();
        init();
    }
}
