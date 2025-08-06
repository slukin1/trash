package com.huobi.view.showcaseview.targets;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.util.ArrayList;

class ActionBarViewWrapper {
    private Class mAbsActionBarViewClass;
    private ViewParent mActionBarView;
    private Class mActionBarViewClass;

    public ActionBarViewWrapper(ViewParent viewParent) {
        if (!viewParent.getClass().getName().contains("ActionBarView")) {
            String name = viewParent.getClass().getName();
            viewParent = viewParent.getParent();
            String name2 = viewParent.getClass().getName();
            if (!viewParent.getClass().getName().contains("ActionBarView")) {
                throw new IllegalStateException("Cannot find ActionBarView for Activity, instead found " + name + " and " + name2);
            }
        }
        this.mActionBarView = viewParent;
        this.mActionBarViewClass = viewParent.getClass();
        this.mAbsActionBarViewClass = viewParent.getClass().getSuperclass();
    }

    private Object getMediaRouteButton(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mActionView");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if ("android.support.v7.app.MediaRouteButton".equals(obj2.getClass().getName())) {
                return obj2;
            }
            return null;
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return null;
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    public View getActionItem(int i11) {
        Field field;
        try {
            Field declaredField = this.mAbsActionBarViewClass.getDeclaredField("mActionMenuPresenter");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.mActionBarView);
            Field declaredField2 = obj.getClass().getSuperclass().getDeclaredField("mMenuView");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2.getClass().toString().contains("com.actionbarsherlock")) {
                field = obj2.getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            } else if (obj2.getClass().toString().contains("android.support.v7")) {
                field = obj2.getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            } else {
                field = obj2.getClass().getSuperclass().getSuperclass().getDeclaredField("mChildren");
            }
            field.setAccessible(true);
            for (Object obj3 : (Object[]) field.get(obj2)) {
                if (obj3 != null) {
                    View view = (View) obj3;
                    if (view.getId() == i11) {
                        return view;
                    }
                }
            }
            return null;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    public View getMediaRouterButtonView() {
        try {
            Field declaredField = this.mActionBarViewClass.getDeclaredField("mOptionsMenu");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.mActionBarView);
            Field declaredField2 = obj.getClass().getDeclaredField("mActionItems");
            declaredField2.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField2.get(obj);
            if (arrayList != null) {
                for (Object next : arrayList) {
                    System.out.println(next);
                    Object mediaRouteButton = getMediaRouteButton(next);
                    if (mediaRouteButton != null) {
                        return (View) mediaRouteButton;
                    }
                }
            }
            return null;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    public View getOverflowView() {
        try {
            Field declaredField = this.mAbsActionBarViewClass.getDeclaredField("mActionMenuPresenter");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.mActionBarView);
            Field declaredField2 = obj.getClass().getDeclaredField("mOverflowButton");
            declaredField2.setAccessible(true);
            return (View) declaredField2.get(obj);
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    public View getSpinnerView() {
        try {
            Field declaredField = this.mActionBarViewClass.getDeclaredField("mSpinner");
            declaredField.setAccessible(true);
            return (View) declaredField.get(this.mActionBarView);
        } catch (NoSuchFieldException e11) {
            Log.e("TAG", "Failed to find actionbar spinner", e11);
            return null;
        } catch (IllegalAccessException e12) {
            Log.e("TAG", "Failed to access actionbar spinner", e12);
            return null;
        }
    }

    public View getTitleView() {
        try {
            Field declaredField = this.mActionBarViewClass.getDeclaredField("mTitleView");
            declaredField.setAccessible(true);
            return (View) declaredField.get(this.mActionBarView);
        } catch (NoSuchFieldException e11) {
            Log.e("TAG", "Failed to find actionbar title", e11);
            return null;
        } catch (IllegalAccessException e12) {
            Log.e("TAG", "Failed to access actionbar title", e12);
            return null;
        }
    }
}
