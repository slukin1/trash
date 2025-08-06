package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.e0;
import androidx.core.view.h0;

public class AppCompatSpinner extends Spinner implements e0 {
    @SuppressLint({"ResourceType"})

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f4363j = {16843505};

    /* renamed from: b  reason: collision with root package name */
    public final c f4364b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4365c;

    /* renamed from: d  reason: collision with root package name */
    public t f4366d;

    /* renamed from: e  reason: collision with root package name */
    public SpinnerAdapter f4367e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4368f;

    /* renamed from: g  reason: collision with root package name */
    public i f4369g;

    /* renamed from: h  reason: collision with root package name */
    public int f4370h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f4371i;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean mShowDropdown;

        public class a implements Parcelable.Creator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mShowDropdown = parcel.readByte() != 0;
        }
    }

    public class a extends t {

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ h f4372k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, h hVar) {
            super(view);
            this.f4372k = hVar;
        }

        public h.e b() {
            return this.f4372k;
        }

        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().isShowing()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                c.a(viewTreeObserver, this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    public static final class c {
        public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static final class d {
        public static int a(View view) {
            return view.getTextAlignment();
        }

        public static int b(View view) {
            return view.getTextDirection();
        }

        public static void c(View view, int i11) {
            view.setTextAlignment(i11);
        }

        public static void d(View view, int i11) {
            view.setTextDirection(i11);
        }
    }

    public static final class e {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!androidx.core.util.b.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    public class f implements i, DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public AlertDialog f4375b;

        /* renamed from: c  reason: collision with root package name */
        public ListAdapter f4376c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f4377d;

        public f() {
        }

        public Drawable b() {
            return null;
        }

        public void c(int i11) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void d(int i11) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void dismiss() {
            AlertDialog alertDialog = this.f4375b;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f4375b = null;
            }
        }

        public void e(int i11, int i12) {
            if (this.f4376c != null) {
                AlertDialog.a aVar = new AlertDialog.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f4377d;
                if (charSequence != null) {
                    aVar.setTitle(charSequence);
                }
                AlertDialog create = aVar.setSingleChoiceItems(this.f4376c, AppCompatSpinner.this.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                this.f4375b = create;
                ListView listView = create.getListView();
                if (Build.VERSION.SDK_INT >= 17) {
                    d.d(listView, i11);
                    d.c(listView, i12);
                }
                this.f4375b.show();
            }
        }

        public int f() {
            return 0;
        }

        public int i() {
            return 0;
        }

        public boolean isShowing() {
            AlertDialog alertDialog = this.f4375b;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public void j(int i11) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public CharSequence k() {
            return this.f4377d;
        }

        public void l(CharSequence charSequence) {
            this.f4377d = charSequence;
        }

        public void m(ListAdapter listAdapter) {
            this.f4376c = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            AppCompatSpinner.this.setSelection(i11);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i11, this.f4376c.getItemId(i11));
            }
            dismiss();
        }

        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }
    }

    public static class g implements ListAdapter, SpinnerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public SpinnerAdapter f4379b;

        /* renamed from: c  reason: collision with root package name */
        public ListAdapter f4380c;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f4379b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f4380c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            } else if (spinnerAdapter instanceof a0) {
                a0 a0Var = (a0) spinnerAdapter;
                if (a0Var.getDropDownViewTheme() == null) {
                    a0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f4380c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i11, view, viewGroup);
        }

        public Object getItem(int i11) {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i11);
        }

        public long getItemId(int i11) {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i11);
        }

        public int getItemViewType(int i11) {
            return 0;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            return getDropDownView(i11, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i11) {
            ListAdapter listAdapter = this.f4380c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i11);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4379b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class h extends ListPopupWindow implements i {
        public CharSequence K;
        public ListAdapter L;
        public final Rect M = new Rect();
        public int N;

        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AppCompatSpinner f4381b;

            public a(AppCompatSpinner appCompatSpinner) {
                this.f4381b = appCompatSpinner;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                AppCompatSpinner.this.setSelection(i11);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    AppCompatSpinner.this.performItemClick(view, i11, hVar.L.getItemId(i11));
                }
                h.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.R(AppCompatSpinner.this)) {
                    h.this.dismiss();
                    return;
                }
                h.this.P();
                h.super.show();
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f4384b;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f4384b = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f4384b);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
            A(AppCompatSpinner.this);
            G(true);
            L(0);
            I(new a(AppCompatSpinner.this));
        }

        public void P() {
            int i11;
            int i12;
            Drawable b11 = b();
            int i13 = 0;
            if (b11 != null) {
                b11.getPadding(AppCompatSpinner.this.f4371i);
                if (o0.b(AppCompatSpinner.this)) {
                    i12 = AppCompatSpinner.this.f4371i.right;
                } else {
                    i12 = -AppCompatSpinner.this.f4371i.left;
                }
                i13 = i12;
            } else {
                Rect rect = AppCompatSpinner.this.f4371i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i14 = appCompatSpinner.f4370h;
            if (i14 == -2) {
                int a11 = appCompatSpinner.a((SpinnerAdapter) this.L, b());
                int i15 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f4371i;
                int i16 = (i15 - rect2.left) - rect2.right;
                if (a11 > i16) {
                    a11 = i16;
                }
                C(Math.max(a11, (width - paddingLeft) - paddingRight));
            } else if (i14 == -1) {
                C((width - paddingLeft) - paddingRight);
            } else {
                C(i14);
            }
            if (o0.b(AppCompatSpinner.this)) {
                i11 = i13 + (((width - paddingRight) - w()) - Q());
            } else {
                i11 = i13 + paddingLeft + Q();
            }
            j(i11);
        }

        public int Q() {
            return this.N;
        }

        public boolean R(View view) {
            return h0.Z(view) && view.getGlobalVisibleRect(this.M);
        }

        public void d(int i11) {
            this.N = i11;
        }

        public void e(int i11, int i12) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            P();
            F(2);
            super.show();
            ListView h11 = h();
            h11.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                d.d(h11, i11);
                d.c(h11, i12);
            }
            M(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                H(new c(bVar));
            }
        }

        public CharSequence k() {
            return this.K;
        }

        public void l(CharSequence charSequence) {
            this.K = charSequence;
        }

        public void m(ListAdapter listAdapter) {
            super.m(listAdapter);
            this.L = listAdapter;
        }
    }

    public interface i {
        Drawable b();

        void c(int i11);

        void d(int i11);

        void dismiss();

        void e(int i11, int i12);

        int f();

        int i();

        boolean isShowing();

        void j(int i11);

        CharSequence k();

        void l(CharSequence charSequence);

        void m(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i11 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i12 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i12 = Math.max(i12, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i12;
        }
        drawable.getPadding(this.f4371i);
        Rect rect = this.f4371i;
        return i12 + rect.left + rect.right;
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f4369g.e(d.b(this), d.a(this));
        } else {
            this.f4369g.e(-1, -1);
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.f4364b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        i iVar = this.f4369g;
        if (iVar != null) {
            return iVar.i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        i iVar = this.f4369g;
        if (iVar != null) {
            return iVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f4369g != null) {
            return this.f4370h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public final i getInternalPopup() {
        return this.f4369g;
    }

    public Drawable getPopupBackground() {
        i iVar = this.f4369g;
        if (iVar != null) {
            return iVar.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f4365c;
    }

    public CharSequence getPrompt() {
        i iVar = this.f4369g;
        return iVar != null ? iVar.k() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        c cVar = this.f4364b;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c cVar = this.f4364b;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f4369g;
        if (iVar != null && iVar.isShowing()) {
            this.f4369g.dismiss();
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f4369g != null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i11)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.mShowDropdown && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        i iVar = this.f4369g;
        savedState.mShowDropdown = iVar != null && iVar.isShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar = this.f4366d;
        if (tVar == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        i iVar = this.f4369g;
        if (iVar == null) {
            return super.performClick();
        }
        if (iVar.isShowing()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c cVar = this.f4364b;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i11) {
        super.setBackgroundResource(i11);
        c cVar = this.f4364b;
        if (cVar != null) {
            cVar.g(i11);
        }
    }

    public void setDropDownHorizontalOffset(int i11) {
        i iVar = this.f4369g;
        if (iVar != null) {
            iVar.d(i11);
            this.f4369g.j(i11);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i11);
        }
    }

    public void setDropDownVerticalOffset(int i11) {
        i iVar = this.f4369g;
        if (iVar != null) {
            iVar.c(i11);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i11);
        }
    }

    public void setDropDownWidth(int i11) {
        if (this.f4369g != null) {
            this.f4370h = i11;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i11);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        i iVar = this.f4369g;
        if (iVar != null) {
            iVar.setBackgroundDrawable(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i11) {
        setPopupBackgroundDrawable(c.a.b(getPopupContext(), i11));
    }

    public void setPrompt(CharSequence charSequence) {
        i iVar = this.f4369g;
        if (iVar != null) {
            iVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        c cVar = this.f4364b;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        c cVar = this.f4364b;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f4368f) {
            this.f4367e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f4369g != null) {
            Context context = this.f4365c;
            if (context == null) {
                context = getContext();
            }
            this.f4369g.m(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i11, int i12) {
        this(context, attributeSet, i11, i12, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r11 != null) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f4371i = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.z.a(r6, r0)
            int[] r0 = androidx.appcompat.R$styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.d0 r0 = androidx.appcompat.widget.d0.v(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.c r2 = new androidx.appcompat.widget.c
            r2.<init>(r6)
            r6.f4364b = r2
            if (r11 == 0) goto L_0x0029
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
            r6.f4365c = r2
            goto L_0x003b
        L_0x0029:
            int r11 = androidx.appcompat.R$styleable.Spinner_popupTheme
            int r11 = r0.n(r11, r1)
            if (r11 == 0) goto L_0x0039
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (int) r11)
            r6.f4365c = r2
            goto L_0x003b
        L_0x0039:
            r6.f4365c = r7
        L_0x003b:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x006b
            int[] r11 = f4363j     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0053 }
            if (r3 == 0) goto L_0x004f
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0053 }
        L_0x004f:
            r11.recycle()
            goto L_0x006b
        L_0x0053:
            r3 = move-exception
            goto L_0x0059
        L_0x0055:
            r7 = move-exception
            goto L_0x0065
        L_0x0057:
            r3 = move-exception
            r11 = r2
        L_0x0059:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0063 }
            if (r11 == 0) goto L_0x006b
            goto L_0x004f
        L_0x0063:
            r7 = move-exception
            r2 = r11
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.recycle()
        L_0x006a:
            throw r7
        L_0x006b:
            r11 = 1
            if (r10 == 0) goto L_0x00a8
            if (r10 == r11) goto L_0x0071
            goto L_0x00b8
        L_0x0071:
            androidx.appcompat.widget.AppCompatSpinner$h r10 = new androidx.appcompat.widget.AppCompatSpinner$h
            android.content.Context r3 = r6.f4365c
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f4365c
            int[] r4 = androidx.appcompat.R$styleable.Spinner
            androidx.appcompat.widget.d0 r1 = androidx.appcompat.widget.d0.v(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.m(r3, r4)
            r6.f4370h = r3
            int r3 = androidx.appcompat.R$styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r10.setBackgroundDrawable(r3)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r3 = r0.o(r3)
            r10.l(r3)
            r1.w()
            r6.f4369g = r10
            androidx.appcompat.widget.AppCompatSpinner$a r1 = new androidx.appcompat.widget.AppCompatSpinner$a
            r1.<init>(r6, r10)
            r6.f4366d = r1
            goto L_0x00b8
        L_0x00a8:
            androidx.appcompat.widget.AppCompatSpinner$f r10 = new androidx.appcompat.widget.AppCompatSpinner$f
            r10.<init>()
            r6.f4369g = r10
            int r1 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r1 = r0.o(r1)
            r10.l(r1)
        L_0x00b8:
            int r10 = androidx.appcompat.R$styleable.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.q(r10)
            if (r10 == 0) goto L_0x00d0
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.R$layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00d0:
            r0.w()
            r6.f4368f = r11
            android.widget.SpinnerAdapter r7 = r6.f4367e
            if (r7 == 0) goto L_0x00de
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f4367e = r2
        L_0x00de:
            androidx.appcompat.widget.c r7 = r6.f4364b
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
