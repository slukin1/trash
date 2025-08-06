package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<a> f9611b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public Context f9612c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f9613d;

    /* renamed from: e  reason: collision with root package name */
    public int f9614e;

    /* renamed from: f  reason: collision with root package name */
    public TabHost.OnTabChangeListener f9615f;

    /* renamed from: g  reason: collision with root package name */
    public a f9616g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9617h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public String curTab;

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

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.curTab);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f9618a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<?> f9619b;

        /* renamed from: c  reason: collision with root package name */
        public final Bundle f9620c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f9621d;
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public final FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        a b11 = b(str);
        if (this.f9616g != b11) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f9613d.q();
            }
            a aVar = this.f9616g;
            if (!(aVar == null || (fragment = aVar.f9621d) == null)) {
                fragmentTransaction.n(fragment);
            }
            if (b11 != null) {
                Fragment fragment2 = b11.f9621d;
                if (fragment2 == null) {
                    Fragment a11 = this.f9613d.z0().a(this.f9612c.getClassLoader(), b11.f9619b.getName());
                    b11.f9621d = a11;
                    a11.setArguments(b11.f9620c);
                    fragmentTransaction.c(this.f9614e, b11.f9621d, b11.f9618a);
                } else {
                    fragmentTransaction.i(fragment2);
                }
            }
            this.f9616g = b11;
        }
        return fragmentTransaction;
    }

    public final a b(String str) {
        int size = this.f9611b.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = this.f9611b.get(i11);
            if (aVar.f9618a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f9614e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f9611b.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = this.f9611b.get(i11);
            Fragment m02 = this.f9613d.m0(aVar.f9618a);
            aVar.f9621d = m02;
            if (m02 != null && !m02.isDetached()) {
                if (aVar.f9618a.equals(currentTabTag)) {
                    this.f9616g = aVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f9613d.q();
                    }
                    fragmentTransaction.n(aVar.f9621d);
                }
            }
        }
        this.f9617h = true;
        FragmentTransaction a11 = a(currentTabTag, fragmentTransaction);
        if (a11 != null) {
            a11.j();
            this.f9613d.i0();
        }
    }

    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9617h = false;
    }

    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction a11;
        if (this.f9617h && (a11 = a(str, (FragmentTransaction) null)) != null) {
            a11.j();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f9615f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f9615f = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
