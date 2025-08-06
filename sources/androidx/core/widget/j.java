package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class j {

    public static class a {
        public static boolean a(ListView listView, int i11) {
            return listView.canScrollList(i11);
        }

        public static void b(ListView listView, int i11) {
            listView.scrollListBy(i11);
        }
    }

    public static boolean a(ListView listView, int i11) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.a(listView, i11);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i11 > 0) {
            int bottom = listView.getChildAt(childCount - 1).getBottom();
            if (firstVisiblePosition + childCount < listView.getCount() || bottom > listView.getHeight() - listView.getListPaddingBottom()) {
                return true;
            }
            return false;
        }
        int top = listView.getChildAt(0).getTop();
        if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
            return true;
        }
        return false;
    }

    public static void b(ListView listView, int i11) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            a.b(listView, i11);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i11);
        }
    }
}
