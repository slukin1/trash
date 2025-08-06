package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    private static final int DEF_STYLE_ATTR = 16843612;
    private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    private final Drawable background;
    private final Rect backgroundInsets;

    public MaterialStyledDatePickerDialog(Context context) {
        this(context, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.backgroundInsets));
    }

    public MaterialStyledDatePickerDialog(Context context, int i11) {
        this(context, i11, (DatePickerDialog.OnDateSetListener) null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int i11, int i12, int i13) {
        this(context, 0, onDateSetListener, i11, i12, i13);
    }

    public MaterialStyledDatePickerDialog(Context context, int i11, DatePickerDialog.OnDateSetListener onDateSetListener, int i12, int i13, int i14) {
        super(context, i11, onDateSetListener, i12, i13, i14);
        Context context2 = getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i15 = DEF_STYLE_RES;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, (AttributeSet) null, DEF_STYLE_ATTR, i15);
        if (Build.VERSION.SDK_INT >= 21) {
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        } else {
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
        }
        Rect dialogBackgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, DEF_STYLE_ATTR, i15);
        this.backgroundInsets = dialogBackgroundInsets;
        this.background = MaterialDialogs.insetDrawable(materialShapeDrawable, dialogBackgroundInsets);
    }
}
