package zendesk.support.request;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.zendesk.sdk.R$attr;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import u0.a;
import zendesk.support.UiUtils;

public class ViewAttachmentsIndicator extends FrameLayout {
    private static final int COUNT_THRESHOLD = 9;
    private static final String COUNT_THRESHOLD_TEXT = (String.valueOf(9) + "+");
    private int attachmentsCount;
    private View attachmentsIndicatorBottomBorder;
    private TextView attachmentsIndicatorCounter;
    private ImageView attachmentsIndicatorIcon;
    private int colorActive;
    private int colorInactive;

    public ViewAttachmentsIndicator(Context context) {
        super(context);
        init(context);
    }

    public void enableActiveState(boolean z11) {
        a.n(a.r(this.attachmentsIndicatorIcon.getDrawable()).mutate(), z11 ? this.colorActive : this.colorInactive);
        this.attachmentsIndicatorIcon.invalidate();
    }

    public int getAttachmentsCount() {
        return this.attachmentsCount;
    }

    public void init(Context context) {
        FrameLayout.inflate(context, R$layout.zs_view_request_attachments_indicator, this);
        if (!isInEditMode()) {
            this.attachmentsIndicatorIcon = (ImageView) findViewById(R$id.attachments_indicator_icon);
            this.attachmentsIndicatorBottomBorder = findViewById(R$id.attachments_indicator_bottom_border);
            this.attachmentsIndicatorCounter = (TextView) findViewById(R$id.attachments_indicator_counter);
            this.colorActive = UiUtils.themeAttributeToColor(R$attr.colorPrimary, context, R$color.zs_request_fallback_color_primary);
            this.colorInactive = UiUtils.resolveColor(R$color.zs_request_attachment_indicator_color_inactive, context);
            ((GradientDrawable) ((LayerDrawable) this.attachmentsIndicatorCounter.getBackground()).findDrawableByLayerId(R$id.inner_circle)).setColor(this.colorActive);
            getContext().getString(R$string.zs_request_attachment_indicator_accessibility);
            setContentDescription(UtilsAttachment.getContentDescriptionForAttachmentButton(getContext(), getAttachmentsCount()));
        }
    }

    public void reset() {
        setCounterVisible(false);
        setAttachmentsCount(0);
        setBottomBorderVisible(false);
        enableActiveState(false);
    }

    public void setAttachmentsCount(int i11) {
        int i12;
        String str;
        this.attachmentsCount = i11;
        if (i11 > 9) {
            i12 = R$dimen.zs_request_attachment_indicator_counter_width_double_digit;
        } else {
            i12 = R$dimen.zs_request_attachment_indicator_counter_width_single_digit;
        }
        ViewGroup.LayoutParams layoutParams = this.attachmentsIndicatorCounter.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i12);
        this.attachmentsIndicatorCounter.setLayoutParams(layoutParams);
        TextView textView = this.attachmentsIndicatorCounter;
        if (i11 > 9) {
            str = COUNT_THRESHOLD_TEXT;
        } else {
            str = String.valueOf(i11);
        }
        textView.setText(str);
        boolean z11 = i11 > 0;
        setCounterVisible(z11);
        setBottomBorderVisible(z11);
        enableActiveState(z11);
        setContentDescription(UtilsAttachment.getContentDescriptionForAttachmentButton(getContext(), getAttachmentsCount()));
    }

    public void setBottomBorderVisible(boolean z11) {
        this.attachmentsIndicatorBottomBorder.setVisibility(z11 ? 0 : 4);
    }

    public void setCounterVisible(boolean z11) {
        this.attachmentsIndicatorCounter.setVisibility(z11 ? 0 : 4);
    }

    public ViewAttachmentsIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ViewAttachmentsIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }

    public ViewAttachmentsIndicator(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(context);
    }
}
