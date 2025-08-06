package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

public class AlertDialog extends e {
    public static final int LAYOUT_HINT_NONE = 0;
    public static final int LAYOUT_HINT_SIDE = 1;
    public final AlertController mAlert;

    public static class a {
        private final AlertController.f P;
        private final int mTheme;

        public a(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.P.f3771a, this.mTheme);
            this.P.a(alertDialog.mAlert);
            alertDialog.setCancelable(this.P.f3788r);
            if (this.P.f3788r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.f3789s);
            alertDialog.setOnDismissListener(this.P.f3790t);
            DialogInterface.OnKeyListener onKeyListener = this.P.f3791u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Context getContext() {
            return this.P.f3771a;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3793w = listAdapter;
            fVar.f3794x = onClickListener;
            return this;
        }

        public a setCancelable(boolean z11) {
            this.P.f3788r = z11;
            return this;
        }

        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.L = str;
            fVar.f3794x = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.P.f3777g = view;
            return this;
        }

        public a setIcon(int i11) {
            this.P.f3773c = i11;
            return this;
        }

        public a setIconAttribute(int i11) {
            TypedValue typedValue = new TypedValue();
            this.P.f3771a.getTheme().resolveAttribute(i11, typedValue, true);
            this.P.f3773c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z11) {
            this.P.N = z11;
            return this;
        }

        public a setItems(int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3792v = fVar.f3771a.getResources().getTextArray(i11);
            this.P.f3794x = onClickListener;
            return this;
        }

        public a setMessage(int i11) {
            AlertController.f fVar = this.P;
            fVar.f3778h = fVar.f3771a.getText(i11);
            return this;
        }

        public a setMultiChoiceItems(int i11, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3792v = fVar.f3771a.getResources().getTextArray(i11);
            AlertController.f fVar2 = this.P;
            fVar2.J = onMultiChoiceClickListener;
            fVar2.F = zArr;
            fVar2.G = true;
            return this;
        }

        public a setNegativeButton(int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3782l = fVar.f3771a.getText(i11);
            this.P.f3784n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.P.f3783m = drawable;
            return this;
        }

        public a setNeutralButton(int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3785o = fVar.f3771a.getText(i11);
            this.P.f3787q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.P.f3786p = drawable;
            return this;
        }

        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.f3789s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.f3790t = onDismissListener;
            return this;
        }

        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.O = onItemSelectedListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.f3791u = onKeyListener;
            return this;
        }

        public a setPositiveButton(int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3779i = fVar.f3771a.getText(i11);
            this.P.f3781k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.P.f3780j = drawable;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z11) {
            this.P.Q = z11;
            return this;
        }

        public a setSingleChoiceItems(int i11, int i12, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3792v = fVar.f3771a.getResources().getTextArray(i11);
            AlertController.f fVar2 = this.P;
            fVar2.f3794x = onClickListener;
            fVar2.I = i12;
            fVar2.H = true;
            return this;
        }

        public a setTitle(int i11) {
            AlertController.f fVar = this.P;
            fVar.f3776f = fVar.f3771a.getText(i11);
            return this;
        }

        public a setView(int i11) {
            AlertController.f fVar = this.P;
            fVar.f3796z = null;
            fVar.f3795y = i11;
            fVar.E = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public a(Context context, int i11) {
            this.P = new AlertController.f(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i11)));
            this.mTheme = i11;
        }

        public a setIcon(Drawable drawable) {
            this.P.f3774d = drawable;
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.P.f3778h = charSequence;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.P.f3776f = charSequence;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3792v = charSequenceArr;
            fVar.f3794x = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3782l = charSequence;
            fVar.f3784n = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3785o = charSequence;
            fVar.f3787q = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3779i = charSequence;
            fVar.f3781k = onClickListener;
            return this;
        }

        public a setView(View view) {
            AlertController.f fVar = this.P;
            fVar.f3796z = view;
            fVar.f3795y = 0;
            fVar.E = false;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3792v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i11, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.f3794x = onClickListener;
            fVar.I = i11;
            fVar.L = str;
            fVar.H = true;
            return this;
        }

        @Deprecated
        public a setView(View view, int i11, int i12, int i13, int i14) {
            AlertController.f fVar = this.P;
            fVar.f3796z = view;
            fVar.f3795y = 0;
            fVar.E = true;
            fVar.A = i11;
            fVar.B = i12;
            fVar.C = i13;
            fVar.D = i14;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.J = onMultiChoiceClickListener;
            fVar.M = str;
            fVar.L = str2;
            fVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3792v = charSequenceArr;
            fVar.f3794x = onClickListener;
            fVar.I = i11;
            fVar.H = true;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f3793w = listAdapter;
            fVar.f3794x = onClickListener;
            fVar.I = i11;
            fVar.H = true;
            return this;
        }
    }

    public AlertDialog(Context context) {
        this(context, 0);
    }

    public static int resolveDialogTheme(Context context, int i11) {
        if (((i11 >>> 24) & 255) >= 1) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i11) {
        return this.mAlert.c(i11);
    }

    public ListView getListView() {
        return this.mAlert.e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.f();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (this.mAlert.h(i11, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (this.mAlert.i(i11, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i11, keyEvent);
    }

    public void setButton(int i11, CharSequence charSequence, Message message) {
        this.mAlert.l(i11, charSequence, (DialogInterface.OnClickListener) null, message, (Drawable) null);
    }

    public void setButtonPanelLayoutHint(int i11) {
        this.mAlert.m(i11);
    }

    public void setCustomTitle(View view) {
        this.mAlert.n(view);
    }

    public void setIcon(int i11) {
        this.mAlert.o(i11);
    }

    public void setIconAttribute(int i11) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i11, typedValue, true);
        this.mAlert.o(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.q(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.s(charSequence);
    }

    public void setView(View view) {
        this.mAlert.u(view);
    }

    public AlertDialog(Context context, int i11) {
        super(context, resolveDialogTheme(context, i11));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public void setButton(int i11, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i11, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.p(drawable);
    }

    public void setView(View view, int i11, int i12, int i13, int i14) {
        this.mAlert.v(view, i11, i12, i13, i14);
    }

    public void setButton(int i11, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i11, charSequence, onClickListener, (Message) null, drawable);
    }

    public AlertDialog(Context context, boolean z11, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z11);
        setOnCancelListener(onCancelListener);
    }
}
