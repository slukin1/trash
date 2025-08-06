package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$drawable;
import zendesk.commonui.UiUtils;

public class ResponseOptionSelectedView extends AppCompatTextView {
    public ResponseOptionSelectedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void init() {
        setTextColor(ContextCompat.getColor(getContext(), R$color.zui_color_white_100));
        setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R$drawable.zui_background_response_option_selected));
        getBackground().mutate().setColorFilter(new PorterDuffColorFilter(UiUtils.c(R$attr.colorPrimary, getContext(), R$color.zui_color_primary), PorterDuff.Mode.SRC_ATOP));
    }

    public ResponseOptionSelectedView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
