package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.flutter.plugins.firebase.crashlytics.Constants;

public class q implements LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    public final FragmentManager f9775b;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d0 f9776b;

        public a(d0 d0Var) {
            this.f9776b = d0Var;
        }

        public void onViewAttachedToWindow(View view) {
            Fragment k11 = this.f9776b.k();
            this.f9776b.m();
            SpecialEffectsController.r((ViewGroup) k11.mView.getParent(), q.this.f9775b).n();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public q(FragmentManager fragmentManager) {
        this.f9775b = fragmentManager;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        d0 d0Var;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f9775b);
        }
        Fragment fragment = null;
        if (!TUIConstants.TUIChat.FRAGMENT.equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, Constants.CLASS);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f9775b.l0(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f9775b.m0(string);
        }
        if (fragment == null && id2 != -1) {
            fragment = this.f9775b.l0(id2);
        }
        if (fragment == null) {
            fragment = this.f9775b.z0().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id2;
            fragment.mContainerId = id2;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.f9775b;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.C0();
            fragment.onInflate(this.f9775b.C0().f(), attributeSet, fragment.mSavedFragmentState);
            d0Var = this.f9775b.j(fragment);
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.f9775b;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.C0();
            fragment.onInflate(this.f9775b.C0().f(), attributeSet, fragment.mSavedFragmentState);
            d0Var = this.f9775b.z(fragment);
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.i(fragment, viewGroup);
        fragment.mContainer = viewGroup;
        d0Var.m();
        d0Var.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new a(d0Var));
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
