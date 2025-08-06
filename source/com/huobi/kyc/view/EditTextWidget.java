package com.huobi.kyc.view;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.huobi.edgeengine.template.widget.Widget;

public class EditTextWidget extends Widget {
    public View P(Context context) {
        return (EditText) super.P(context);
    }

    public View q(Context context) {
        return new EditText(context);
    }
}
