package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;
import zendesk.classic.messaging.R$string;
import zendesk.commonui.UiUtils;

public class AttachmentsIndicator extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final String f62631h = (String.valueOf(9) + "+");

    /* renamed from: b  reason: collision with root package name */
    public ImageView f62632b;

    /* renamed from: c  reason: collision with root package name */
    public View f62633c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62634d;

    /* renamed from: e  reason: collision with root package name */
    public int f62635e;

    /* renamed from: f  reason: collision with root package name */
    public int f62636f;

    /* renamed from: g  reason: collision with root package name */
    public int f62637g;

    public AttachmentsIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public static String b(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getString(R$string.zui_attachment_indicator_accessibility));
        sb2.append(". ");
        if (i11 == 0) {
            sb2.append(context.getString(R$string.zui_attachment_indicator_no_attachments_selected_accessibility));
        } else if (i11 == 1) {
            sb2.append(context.getString(R$string.zui_attachment_indicator_one_attachments_selected_accessibility));
        } else {
            sb2.append(context.getString(R$string.zui_attachment_indicator_n_attachments_selected_accessibility, new Object[]{Integer.valueOf(i11)}));
        }
        return sb2.toString();
    }

    public void a(boolean z11) {
        UiUtils.b(z11 ? this.f62635e : this.f62636f, this.f62632b.getDrawable(), this.f62632b);
    }

    public void c(Context context) {
        FrameLayout.inflate(context, R$layout.zui_view_attachments_indicator, this);
        if (!isInEditMode()) {
            this.f62632b = (ImageView) findViewById(R$id.attachments_indicator_icon);
            this.f62633c = findViewById(R$id.attachments_indicator_bottom_border);
            this.f62634d = (TextView) findViewById(R$id.attachments_indicator_counter);
            this.f62635e = UiUtils.c(R$attr.colorPrimary, context, R$color.zui_color_primary);
            this.f62636f = UiUtils.a(R$color.zui_attachment_indicator_color_inactive, context);
            ((GradientDrawable) ((LayerDrawable) this.f62634d.getBackground()).findDrawableByLayerId(R$id.inner_circle)).setColor(this.f62635e);
            setContentDescription(b(getContext(), this.f62637g));
        }
    }

    public void d() {
        setCounterVisible(false);
        setAttachmentsCount(0);
        setBottomBorderVisible(false);
        a(false);
    }

    public int getAttachmentsCount() {
        return this.f62637g;
    }

    public void setAttachmentsCount(int i11) {
        int i12;
        String str;
        this.f62637g = i11;
        if (i11 > 9) {
            i12 = R$dimen.zui_attachment_indicator_counter_width_double_digit;
        } else {
            i12 = R$dimen.zui_attachment_indicator_counter_width_single_digit;
        }
        ViewGroup.LayoutParams layoutParams = this.f62634d.getLayoutParams();
        layoutParams.width = getResources().getDimensionPixelSize(i12);
        this.f62634d.setLayoutParams(layoutParams);
        TextView textView = this.f62634d;
        if (i11 > 9) {
            str = f62631h;
        } else {
            str = String.valueOf(i11);
        }
        textView.setText(str);
        boolean z11 = i11 > 0;
        setCounterVisible(z11);
        setBottomBorderVisible(z11);
        a(z11);
        setContentDescription(b(getContext(), i11));
    }

    public void setBottomBorderVisible(boolean z11) {
        this.f62633c.setVisibility(z11 ? 0 : 4);
    }

    public void setCounterVisible(boolean z11) {
        this.f62634d.setVisibility(z11 ? 0 : 4);
    }

    public AttachmentsIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
