package zendesk.classic.messaging.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import zendesk.classic.messaging.R$attr;
import zendesk.classic.messaging.R$color;
import zendesk.commonui.UiUtils;

public class FileUploadProgressView extends ProgressBar {
    public FileUploadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setIndeterminate(true);
        getIndeterminateDrawable().setColorFilter(UiUtils.c(R$attr.colorPrimary, getContext(), R$color.zui_color_primary), PorterDuff.Mode.SRC_IN);
    }

    public FileUploadProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
