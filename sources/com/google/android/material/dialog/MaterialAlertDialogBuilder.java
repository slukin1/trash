package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAlertDialogBuilder extends AlertDialog.a {
    private static final int DEF_STYLE_ATTR = R.attr.alertDialogStyle;
    private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    private Drawable background;
    private final Rect backgroundInsets;

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    private static Context createMaterialAlertDialogThemedContext(Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context wrap = MaterialThemeOverlay.wrap(context, (AttributeSet) null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        if (materialAlertDialogThemeOverlay == 0) {
            return wrap;
        }
        return new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    private static int getMaterialAlertDialogThemeOverlay(Context context) {
        TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private static int getOverridingThemeResId(Context context, int i11) {
        return i11 == 0 ? getMaterialAlertDialogThemeOverlay(context) : i11;
    }

    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(h0.z(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.backgroundInsets));
        return create;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public MaterialAlertDialogBuilder setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int i11) {
        this.backgroundInsets.bottom = i11;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int i11) {
        if (Build.VERSION.SDK_INT < 17 || getContext().getResources().getConfiguration().getLayoutDirection() != 1) {
            this.backgroundInsets.right = i11;
        } else {
            this.backgroundInsets.left = i11;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int i11) {
        if (Build.VERSION.SDK_INT < 17 || getContext().getResources().getConfiguration().getLayoutDirection() != 1) {
            this.backgroundInsets.left = i11;
        } else {
            this.backgroundInsets.right = i11;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int i11) {
        this.backgroundInsets.top = i11;
        return this;
    }

    public MaterialAlertDialogBuilder(Context context, int i11) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i11));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i12 = DEF_STYLE_ATTR;
        int i13 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, i12, i13);
        int color = MaterialColors.getColor(context2, R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, (AttributeSet) null, i12, i13);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    public MaterialAlertDialogBuilder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    public MaterialAlertDialogBuilder setCancelable(boolean z11) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z11);
    }

    public MaterialAlertDialogBuilder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    public MaterialAlertDialogBuilder setCustomTitle(View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    public MaterialAlertDialogBuilder setIconAttribute(int i11) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i11);
    }

    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    public MaterialAlertDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    public MaterialAlertDialogBuilder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    public MaterialAlertDialogBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setIcon(int i11) {
        return (MaterialAlertDialogBuilder) super.setIcon(i11);
    }

    public MaterialAlertDialogBuilder setItems(int i11, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i11, onClickListener);
    }

    public MaterialAlertDialogBuilder setMessage(int i11) {
        return (MaterialAlertDialogBuilder) super.setMessage(i11);
    }

    public MaterialAlertDialogBuilder setNegativeButton(int i11, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i11, onClickListener);
    }

    public MaterialAlertDialogBuilder setNeutralButton(int i11, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i11, onClickListener);
    }

    public MaterialAlertDialogBuilder setPositiveButton(int i11, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i11, onClickListener);
    }

    public MaterialAlertDialogBuilder setTitle(int i11) {
        return (MaterialAlertDialogBuilder) super.setTitle(i11);
    }

    public MaterialAlertDialogBuilder setView(int i11) {
        return (MaterialAlertDialogBuilder) super.setView(i11);
    }

    public MaterialAlertDialogBuilder setIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    public MaterialAlertDialogBuilder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    public MaterialAlertDialogBuilder setMessage(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(int i11, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i11, zArr, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    public MaterialAlertDialogBuilder setView(View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(int i11, int i12, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i11, i12, onClickListener);
    }

    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor cursor, int i11, String str, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i11, str, onClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] charSequenceArr, int i11, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i11, onClickListener);
    }

    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter listAdapter, int i11, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i11, onClickListener);
    }
}
