package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import v1.q;

@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f11815b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11816c = true;

    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f11815b = viewGroup;
        viewGroup.setTag(R$id.ghost_view_holder, this);
        q.b(this.f11815b).add(this);
    }

    public static GhostViewHolder b(ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R$id.ghost_view_holder);
    }

    public static void d(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    public static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT < 21 || view.getZ() == view2.getZ()) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(q.a(viewGroup, i11));
                if (childAt == view) {
                    return false;
                }
                if (childAt == view2) {
                    break;
                }
            }
            return true;
        } else if (view.getZ() > view2.getZ()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i11 = 1; i11 < min; i11++) {
            View view = arrayList.get(i11);
            View view2 = arrayList2.get(i11);
            if (view != view2) {
                return e(view, view2);
            }
        }
        if (arrayList2.size() == min) {
            return true;
        }
        return false;
    }

    public void a(GhostViewPort ghostViewPort) {
        ArrayList arrayList = new ArrayList();
        d(ghostViewPort.f11819d, arrayList);
        int c11 = c(arrayList);
        if (c11 < 0 || c11 >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, c11);
        }
    }

    public final int c(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i11 = 0;
        while (i11 <= childCount) {
            int i12 = (i11 + childCount) / 2;
            d(((GhostViewPort) getChildAt(i12)).f11819d, arrayList2);
            if (f(arrayList, arrayList2)) {
                i11 = i12 + 1;
            } else {
                childCount = i12 - 1;
            }
            arrayList2.clear();
        }
        return i11;
    }

    public void g() {
        if (this.f11816c) {
            q.b(this.f11815b).remove(this);
            q.b(this.f11815b).add(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewAdded(View view) {
        if (this.f11816c) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f11815b.setTag(R$id.ghost_view_holder, (Object) null);
            q.b(this.f11815b).remove(this);
            this.f11816c = false;
        }
    }
}
