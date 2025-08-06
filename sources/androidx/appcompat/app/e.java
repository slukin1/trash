package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.k;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.g;

public class e extends k implements a {
    private AppCompatDelegate mDelegate;
    private final g.a mKeyDispatcher;

    public e(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i11) {
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().c(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().z();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return g.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i11) {
        return getDelegate().j(i11);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.i(this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().s();
    }

    public void invalidateOptionsMenu() {
        getDelegate().u();
    }

    public void onCreate(Bundle bundle) {
        getDelegate().t();
        super.onCreate(bundle);
        getDelegate().y(bundle);
    }

    public void onStop() {
        super.onStop();
        getDelegate().E();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setContentView(int i11) {
        getDelegate().J(i11);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().Q(charSequence);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i11) {
        return getDelegate().H(i11);
    }

    public e(Context context, int i11) {
        super(context, getThemeResId(context, i11));
        this.mKeyDispatcher = new d(this);
        AppCompatDelegate delegate = getDelegate();
        delegate.P(getThemeResId(context, i11));
        delegate.y((Bundle) null);
    }

    public void setContentView(View view) {
        getDelegate().K(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().L(view, layoutParams);
    }

    public void setTitle(int i11) {
        super.setTitle(i11);
        getDelegate().Q(getContext().getString(i11));
    }

    public e(Context context, boolean z11, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.mKeyDispatcher = new d(this);
        setCancelable(z11);
        setOnCancelListener(onCancelListener);
    }
}
