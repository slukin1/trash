package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.zendesk.logger.Logger;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.classic.messaging.R$dimen;
import zendesk.classic.messaging.R$drawable;
import zendesk.commonui.UiUtils;

public class ResponseOptionView extends AppCompatTextView {
    public ResponseOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void init() {
        setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R$drawable.zui_background_response_option));
        int c11 = UiUtils.c(R$attr.colorPrimary, getContext(), R$color.zui_color_primary);
        setTextColor(c11);
        Drawable mutate = getBackground().mutate();
        if (mutate instanceof GradientDrawable) {
            ((GradientDrawable) mutate).setStroke((int) getResources().getDimension(R$dimen.zui_cell_response_option_stroke_width), c11);
            return;
        }
        Logger.l("ResponseOptionView", "Unable to set stroke on background as background is not of type GradientDrawable", new Object[0]);
    }

    public ResponseOptionView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
