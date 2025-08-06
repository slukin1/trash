package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TabHost;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WindowHelper {
    private static boolean sArrayListWindowViews = false;
    private static final String sCustomWindowPrefix = "/CustomWindow";
    private static final String sDialogWindowPrefix = "/DialogWindow";
    private static boolean sIsInitialized = false;
    private static Method sItemViewGetDataMethod = null;
    private static Class<?> sListMenuItemViewClazz = null;
    private static final String sMainWindowPrefix = "/MainWindow";
    private static Class sPhoneWindowClazz = null;
    private static Class sPopupWindowClazz = null;
    private static final String sPopupWindowPrefix = "/PopupWindow";
    private static boolean sViewArrayWindowViews = false;
    private static Comparator<View> sViewSizeComparator = new Comparator<View>() {
        public int compare(View view, View view2) {
            int hashCode = view.hashCode();
            int hashCode2 = view2.hashCode();
            int currentRootWindowsHashCode = AppStateManager.getInstance().getCurrentRootWindowsHashCode();
            if (hashCode == currentRootWindowsHashCode) {
                return -1;
            }
            if (hashCode2 == currentRootWindowsHashCode) {
                return 1;
            }
            return (view2.getWidth() * view2.getHeight()) - (view.getWidth() * view.getHeight());
        }
    };
    private static Object sWindowManger;
    private static Field viewsField;

    private static View[] filterNullAndDismissToastView(View[] viewArr) {
        ArrayList arrayList = new ArrayList(viewArr.length);
        System.currentTimeMillis();
        for (View view : viewArr) {
            if (view != null) {
                arrayList.add(view);
            }
        }
        View[] viewArr2 = new View[arrayList.size()];
        arrayList.toArray(viewArr2);
        return viewArr2;
    }

    private static View findMenuItemView(View view, MenuItem menuItem) throws InvocationTargetException, IllegalAccessException {
        View view2;
        if ((ViewUtil.instanceOfActionMenuItem(menuItem) && menuItem.getItemId() == 16908332 && ViewUtil.instanceOfToolbar(view.getParent()) && (view instanceof ImageButton) && (view2 = (View) ReflectUtil.findField(new String[]{"androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar"}, (Object) view.getParent(), "mNavButtonView")) != null && view2 == view) || getMenuItemData(view) == menuItem) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i11 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i11 >= viewGroup.getChildCount()) {
                return null;
            }
            View findMenuItemView = findMenuItemView(viewGroup.getChildAt(i11), menuItem);
            if (findMenuItemView != null) {
                return findMenuItemView;
            }
            i11++;
        }
    }

    private static View findTabView(View view, String str) {
        int i11 = 0;
        if (TextUtils.equals(str, getTabHostTag(view))) {
            return (View) ReflectUtil.callMethod(view, "getCurrentTabView", new Object[0]);
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i11 >= viewGroup.getChildCount()) {
                return null;
            }
            View findTabView = findTabView(viewGroup.getChildAt(i11), str);
            if (findTabView != null) {
                return findTabView;
            }
            i11++;
        }
    }

    public static View getClickView(MenuItem menuItem) {
        View findMenuItemView;
        View findMenuItemView2;
        if (menuItem == null) {
            return null;
        }
        init();
        View[] windowViews = getWindowViews();
        try {
            for (View view : windowViews) {
                if (view.getClass() == sPopupWindowClazz && (findMenuItemView2 = findMenuItemView(view, menuItem)) != null) {
                    return findMenuItemView2;
                }
            }
            for (View view2 : windowViews) {
                if (view2.getClass() != sPopupWindowClazz && (findMenuItemView = findMenuItemView(view2, menuItem)) != null) {
                    return findMenuItemView;
                }
            }
        } catch (Exception | IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    public static String getMainWindowPrefix() {
        return sMainWindowPrefix;
    }

    @SuppressLint({"RestrictedApi"})
    private static Object getMenuItemData(View view) throws InvocationTargetException, IllegalAccessException {
        if (view.getClass() == sListMenuItemViewClazz) {
            return sItemViewGetDataMethod.invoke(view, new Object[0]);
        }
        if (ViewUtil.instanceOfAndroidXListMenuItemView(view) || ViewUtil.instanceOfSupportListMenuItemView(view) || ViewUtil.instanceOfBottomNavigationItemView(view)) {
            return ViewUtil.getItemData(view);
        }
        return null;
    }

    public static View[] getSortedWindowViews() {
        View[] windowViews = getWindowViews();
        if (windowViews.length <= 1) {
            return windowViews;
        }
        View[] viewArr = (View[]) Arrays.copyOf(windowViews, windowViews.length);
        Arrays.sort(viewArr, sViewSizeComparator);
        return viewArr;
    }

    private static String getSubWindowPrefix(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof WindowManager.LayoutParams)) {
            int i11 = ((WindowManager.LayoutParams) layoutParams).type;
            if (i11 == 1) {
                return sMainWindowPrefix;
            }
            if (i11 < 99 && view.getClass() == sPhoneWindowClazz) {
                return sDialogWindowPrefix;
            }
            if (i11 < 1999 && view.getClass() == sPopupWindowClazz) {
                return sPopupWindowPrefix;
            }
            if (i11 < 2999) {
                return sCustomWindowPrefix;
            }
        }
        Class<?> cls = view.getClass();
        if (cls == sPhoneWindowClazz) {
            return sDialogWindowPrefix;
        }
        return cls == sPopupWindowClazz ? sPopupWindowPrefix : sCustomWindowPrefix;
    }

    private static String getTabHostTag(View view) {
        if (view instanceof TabHost) {
            return (String) ReflectUtil.callMethod(view, "getCurrentTabTag", new Object[0]);
        }
        return null;
    }

    public static String getWindowPrefix(View view) {
        if (view.hashCode() == AppStateManager.getInstance().getCurrentRootWindowsHashCode()) {
            return getMainWindowPrefix();
        }
        return getSubWindowPrefix(view);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.view.View[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.view.View[]} */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.View[] getWindowViews() {
        /*
            r0 = 0
            android.view.View[] r1 = new android.view.View[r0]
            java.lang.Object r2 = sWindowManger
            r3 = 0
            if (r2 != 0) goto L_0x0028
            com.sensorsdata.analytics.android.sdk.AppStateManager r2 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()
            android.app.Activity r2 = r2.getForegroundActivity()
            if (r2 == 0) goto L_0x0020
            android.view.Window r4 = r2.getWindow()
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x0020
            android.view.View r3 = r4.getDecorView()
        L_0x0020:
            if (r2 == 0) goto L_0x0027
            r1 = 1
            android.view.View[] r1 = new android.view.View[r1]
            r1[r0] = r3
        L_0x0027:
            return r1
        L_0x0028:
            boolean r0 = sArrayListWindowViews     // Catch:{ Exception -> 0x004c }
            if (r0 == 0) goto L_0x003c
            java.lang.reflect.Field r0 = viewsField     // Catch:{ Exception -> 0x004c }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x004c }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x004c }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ Exception -> 0x004c }
            r3 = r0
            android.view.View[] r3 = (android.view.View[]) r3     // Catch:{ Exception -> 0x004c }
            goto L_0x0049
        L_0x003c:
            boolean r0 = sViewArrayWindowViews     // Catch:{ Exception -> 0x004c }
            if (r0 == 0) goto L_0x0049
            java.lang.reflect.Field r0 = viewsField     // Catch:{ Exception -> 0x004c }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x004c }
            r3 = r0
            android.view.View[] r3 = (android.view.View[]) r3     // Catch:{ Exception -> 0x004c }
        L_0x0049:
            if (r3 == 0) goto L_0x004c
            r1 = r3
        L_0x004c:
            android.view.View[] r0 = filterNullAndDismissToastView(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.WindowHelper.getWindowViews():android.view.View[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:2|(1:4)(1:5)|6|(6:7|8|(1:10)(2:11|(1:13)(1:14))|15|(1:17)(2:18|(1:20))|21)|22|(2:24|25)|26|28|29|(3:31|32|33)(1:38)|39|40|(1:42)(1:43)|44|46) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008f */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093 A[Catch:{ ClassNotFoundException -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c A[Catch:{ ClassNotFoundException -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init() {
        /*
            boolean r0 = sIsInitialized
            if (r0 != 0) goto L_0x00a6
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 < r1) goto L_0x000d
            java.lang.String r2 = "android.view.WindowManagerGlobal"
            goto L_0x000f
        L_0x000d:
            java.lang.String r2 = "android.view.WindowManagerImpl"
        L_0x000f:
            r3 = 1
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = "sDefaultWindowManager"
            goto L_0x0022
        L_0x0019:
            r1 = 13
            if (r0 < r1) goto L_0x0020
            java.lang.String r0 = "sWindowManager"
            goto L_0x0022
        L_0x0020:
            java.lang.String r0 = "mWindowManager"
        L_0x0022:
            java.lang.String r1 = "mViews"
            java.lang.reflect.Field r1 = r2.getDeclaredField(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            viewsField = r1     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.reflect.Field r0 = r2.getDeclaredField(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.reflect.Field r1 = viewsField     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            r1.setAccessible(r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.reflect.Field r1 = viewsField     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.Class r1 = r1.getType()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.Class<java.util.ArrayList> r2 = java.util.ArrayList.class
            if (r1 != r2) goto L_0x0040
            sArrayListWindowViews = r3     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            goto L_0x004c
        L_0x0040:
            java.lang.reflect.Field r1 = viewsField     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.Class r1 = r1.getType()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            java.lang.Class<android.view.View[]> r2 = android.view.View[].class
            if (r1 != r2) goto L_0x004c
            sViewArrayWindowViews = r3     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
        L_0x004c:
            r0.setAccessible(r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
            sWindowManger = r0     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchFieldException -> 0x0056 }
        L_0x0056:
            java.lang.String r0 = "com.android.internal.view.menu.ListMenuItemView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x006f }
            sListMenuItemViewClazz = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x006f }
            java.lang.String r0 = "com.android.internal.view.menu.MenuView$ItemView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x006f }
            java.lang.String r1 = "getItemData"
            r2 = 0
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x006f }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x006f }
            sItemViewGetDataMethod = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x006f }
        L_0x006f:
            r0 = 23
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x008f }
            if (r1 < r0) goto L_0x0087
            java.lang.String r1 = "com.android.internal.policy.PhoneWindow$DecorView"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x007e }
            sPhoneWindowClazz = r1     // Catch:{ ClassNotFoundException -> 0x007e }
            goto L_0x008f
        L_0x007e:
            java.lang.String r1 = "com.android.internal.policy.DecorView"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x008f }
            sPhoneWindowClazz = r1     // Catch:{ ClassNotFoundException -> 0x008f }
            goto L_0x008f
        L_0x0087:
            java.lang.String r1 = "com.android.internal.policy.impl.PhoneWindow$DecorView"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x008f }
            sPhoneWindowClazz = r1     // Catch:{ ClassNotFoundException -> 0x008f }
        L_0x008f:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x00a4 }
            if (r1 < r0) goto L_0x009c
            java.lang.String r0 = "android.widget.PopupWindow$PopupDecorView"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            sPopupWindowClazz = r0     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00a4
        L_0x009c:
            java.lang.String r0 = "android.widget.PopupWindow$PopupViewContainer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            sPopupWindowClazz = r0     // Catch:{ ClassNotFoundException -> 0x00a4 }
        L_0x00a4:
            sIsInitialized = r3
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.WindowHelper.init():void");
    }

    public static boolean isCustomWindow(View view) {
        return TextUtils.equals(sCustomWindowPrefix, getSubWindowPrefix(view));
    }

    public static boolean isDecorView(Class cls) {
        if (!sIsInitialized) {
            init();
        }
        return cls == sPhoneWindowClazz || cls == sPopupWindowClazz;
    }

    public static boolean isDialogOrPopupWindow(View view) {
        String subWindowPrefix = getSubWindowPrefix(view);
        return TextUtils.equals(sDialogWindowPrefix, subWindowPrefix) || TextUtils.equals(sPopupWindowPrefix, subWindowPrefix);
    }

    public static boolean isMainWindow(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 1) {
            return false;
        }
        return true;
    }

    public static View getClickView(String str) {
        View findTabView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        init();
        View[] windowViews = getWindowViews();
        int i11 = 0;
        while (i11 < windowViews.length) {
            try {
                View view = windowViews[i11];
                if (view.getClass() != sPopupWindowClazz && (findTabView = findTabView(view, str)) != null) {
                    return findTabView;
                }
                i11++;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
