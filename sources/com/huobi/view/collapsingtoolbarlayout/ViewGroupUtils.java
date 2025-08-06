package com.huobi.view.collapsingtoolbarlayout;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils {
    private static final ViewGroupUtilsImpl IMPL;

    public interface ViewGroupUtilsImpl {
        void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect);
    }

    public static class ViewGroupUtilsImplBase implements ViewGroupUtilsImpl {
        public void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    public static class ViewGroupUtilsImplHoneycomb implements ViewGroupUtilsImpl {
        public void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
            ViewGroupUtilsHoneycomb.offsetDescendantRect(viewGroup, view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new ViewGroupUtilsImplHoneycomb();
        } else {
            IMPL = new ViewGroupUtilsImplBase();
        }
    }

    public static void getDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        offsetDescendantRect(viewGroup, view, rect);
    }

    public static void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        IMPL.offsetDescendantRect(viewGroup, view, rect);
    }
}
