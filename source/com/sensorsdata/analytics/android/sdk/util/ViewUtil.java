package com.sensorsdata.analytics.android.sdk.util;

import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache;
import com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;

public class ViewUtil {
    private static boolean sHaveCustomRecyclerView = false;
    private static boolean sHaveRecyclerView = haveRecyclerView();
    private static Class<?> sRecyclerViewClass;
    private static Method sRecyclerViewGetChildAdapterPositionMethod;
    private static SparseArray<String> sViewCache = new SparseArray<>();

    private static void checkAndInvalidate(View view) {
        if (Build.VERSION.SDK_INT >= 11 && view.getLayerType() != 0) {
            view.invalidate();
        }
    }

    private static void checkCustomRecyclerView(Class<?> cls, String str) {
        if (!sHaveRecyclerView && !sHaveCustomRecyclerView && str != null && str.contains(RecyclerView.TAG)) {
            try {
                if (findRecyclerInSuper(cls) != null && sRecyclerViewGetChildAdapterPositionMethod != null) {
                    sRecyclerViewClass = cls;
                    sHaveCustomRecyclerView = true;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void clear() {
        synchronized (sViewCache) {
            sViewCache.clear();
        }
    }

    private static Class<?> findRecyclerInSuper(Class<?> cls) {
        Class<? super Object> cls2;
        while (cls2 != null && !cls2.equals(ViewGroup.class)) {
            try {
                sRecyclerViewGetChildAdapterPositionMethod = cls2.getMethod("getChildAdapterPosition", new Class[]{View.class});
            } catch (NoSuchMethodException unused) {
            }
            if (sRecyclerViewGetChildAdapterPositionMethod == null) {
                try {
                    sRecyclerViewGetChildAdapterPositionMethod = cls2.getMethod("getChildPosition", new Class[]{View.class});
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (sRecyclerViewGetChildAdapterPositionMethod != null) {
                return cls2;
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return null;
    }

    private static String getCanonicalAndCheckCustomView(Class<?> cls) {
        String canonicalName = SnapCache.getInstance().getCanonicalName(cls);
        if (canonicalName != null) {
            checkCustomRecyclerView(cls, canonicalName);
        }
        return canonicalName;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|(2:3|4)|5|(2:8|9)|10|11|(1:24)(2:15|16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return -1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getChildAdapterPositionInRecyclerView(android.view.View r6, android.view.ViewGroup r7) {
        /*
            boolean r0 = instanceOfRecyclerView(r7)
            if (r0 == 0) goto L_0x0045
            r0 = 0
            r1 = 1
            java.lang.Class r2 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.String r3 = "getChildAdapterPosition"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.Class<android.view.View> r5 = android.view.View.class
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x001a }
            sRecyclerViewGetChildAdapterPositionMethod = r2     // Catch:{ NoSuchMethodException -> 0x001a }
        L_0x001a:
            java.lang.reflect.Method r2 = sRecyclerViewGetChildAdapterPositionMethod
            if (r2 != 0) goto L_0x0030
            java.lang.Class r2 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.String r3 = "getChildPosition"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.Class<android.view.View> r5 = android.view.View.class
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x0030 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0030 }
            sRecyclerViewGetChildAdapterPositionMethod = r2     // Catch:{ NoSuchMethodException -> 0x0030 }
        L_0x0030:
            java.lang.reflect.Method r2 = sRecyclerViewGetChildAdapterPositionMethod     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            if (r2 == 0) goto L_0x004e
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            r1[r0] = r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            java.lang.Object r6 = r2.invoke(r7, r1)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            if (r6 == 0) goto L_0x004e
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            int r6 = r6.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x004e }
            return r6
        L_0x0045:
            boolean r0 = sHaveCustomRecyclerView
            if (r0 == 0) goto L_0x004e
            int r6 = invokeCRVGetChildAdapterPositionMethod(r7, r6)
            return r6
        L_0x004e:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getChildAdapterPositionInRecyclerView(android.view.View, android.view.ViewGroup):int");
    }

    private static int getCurrentItem(View view) {
        try {
            Object invoke = view.getClass().getMethod("getCurrentItem", new Class[0]).invoke(view, new Object[0]);
            if (invoke != null) {
                return ((Integer) invoke).intValue();
            }
            return -1;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static String getElementSelector(View view) {
        String str;
        String selectPath = SnapCache.getInstance().getSelectPath(view);
        if (selectPath != null) {
            return selectPath;
        }
        ViewParent parent = view.getParent();
        String str2 = null;
        View view2 = parent instanceof ViewGroup ? (View) parent : null;
        if (view2 != null) {
            str2 = SnapCache.getInstance().getSelectPath(view2);
        }
        String canonicalName = SnapCache.getInstance().getCanonicalName(view.getClass());
        if (view2 != null) {
            if (str2 == null) {
                str2 = getElementSelectorOrigin(view2);
                SnapCache.getInstance().setSelectPath(view2, str2);
            }
            StringBuilder sb2 = new StringBuilder();
            if (str2 != null && !str2.equals("")) {
                sb2.append(str2);
                sb2.append("/");
            }
            int childIndex = VisualUtil.getChildIndex(parent, view);
            sb2.append(canonicalName);
            sb2.append("[");
            sb2.append(childIndex);
            sb2.append("]");
            str = sb2.toString();
        } else {
            str = getElementSelectorOrigin(view);
        }
        SnapCache.getInstance().setSelectPath(view, str);
        return str;
    }

    private static String getElementSelectorOrigin(View view) {
        boolean z11;
        LinkedList linkedList = new LinkedList();
        do {
            ViewParent parent = view.getParent();
            linkedList.add(view.getClass().getCanonicalName() + "[" + VisualUtil.getChildIndex(parent, view) + "]");
            z11 = parent instanceof ViewGroup;
            if (z11) {
                view = (ViewGroup) parent;
                continue;
            }
        } while (z11);
        Collections.reverse(linkedList);
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 1; i11 < linkedList.size(); i11++) {
            sb2.append((String) linkedList.get(i11));
            if (i11 != linkedList.size() - 1) {
                sb2.append("/");
            }
        }
        return sb2.toString();
    }

    public static Object getItemData(View view) {
        try {
            return view.getClass().getMethod("getItemData", new Class[0]).invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static int getMainWindowCount(View[] viewArr) {
        WindowHelper.init();
        int i11 = 0;
        for (View view : viewArr) {
            if (view != null) {
                i11 += WindowHelper.getWindowPrefix(view).equals(WindowHelper.getMainWindowPrefix()) ? 1 : 0;
            }
        }
        return i11;
    }

    private static String getTabLayoutContent(Object obj) {
        String str = null;
        try {
            Class<?> currentClass = ReflectUtil.getCurrentClass(new String[]{"com.google.android.material.tabs.TabLayout$Tab", "com.google.android.material.tabs.TabLayout$Tab"});
            if (currentClass == null) {
                return null;
            }
            Object callMethod = ReflectUtil.callMethod(obj, "getText", new Object[0]);
            if (callMethod != null) {
                str = callMethod.toString();
            }
            View view = (View) ReflectUtil.findField(currentClass, obj, "mCustomView", "customView");
            if (view == null) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            if (!(view instanceof ViewGroup)) {
                return AopUtil.getViewText(view);
            }
            String traverseView = AopUtil.traverseView(sb2, (ViewGroup) view);
            if (!TextUtils.isEmpty(traverseView)) {
                return traverseView.toString().substring(0, traverseView.length() - 1);
            }
            return traverseView;
        } catch (Exception unused) {
            return null;
        }
    }

    public static ViewNode getViewContentAndType(View view) {
        return getViewContentAndType(view, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x023e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewNode(android.view.View r14, int r15, boolean r16) {
        /*
            r0 = r14
            int r1 = getViewPosition(r14, r15)
            android.view.ViewParent r2 = r14.getParent()
            r3 = 0
            if (r2 != 0) goto L_0x000d
            return r3
        L_0x000d:
            java.lang.Class r4 = r14.getClass()
            boolean r4 = com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(r4)
            if (r4 == 0) goto L_0x001b
            boolean r4 = r2 instanceof android.view.View
            if (r4 == 0) goto L_0x026d
        L_0x001b:
            boolean r4 = r2 instanceof android.view.View
            if (r4 == 0) goto L_0x026d
            r4 = r2
            android.view.View r4 = (android.view.View) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.Class r7 = r14.getClass()
            java.lang.String r7 = getCanonicalAndCheckCustomView(r7)
            android.view.ViewParent r8 = r4.getParent()
            boolean r9 = r8 instanceof android.view.View
            if (r9 == 0) goto L_0x0059
            android.view.View r8 = (android.view.View) r8
            android.util.SparseArray<java.lang.String> r9 = sViewCache
            monitor-enter(r9)
            android.util.SparseArray<java.lang.String> r10 = sViewCache     // Catch:{ all -> 0x0056 }
            int r8 = r8.hashCode()     // Catch:{ all -> 0x0056 }
            java.lang.Object r8 = r10.get(r8)     // Catch:{ all -> 0x0056 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0056 }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0056 }
            if (r10 != 0) goto L_0x0054
            r3 = r8
        L_0x0054:
            monitor-exit(r9)     // Catch:{ all -> 0x0056 }
            goto L_0x0059
        L_0x0056:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0056 }
            throw r0
        L_0x0059:
            boolean r8 = r4 instanceof android.widget.ExpandableListView
            r9 = 1
            r10 = 0
            if (r8 == 0) goto L_0x0164
            r2 = r4
            android.widget.ExpandableListView r2 = (android.widget.ExpandableListView) r2
            long r11 = r2.getExpandableListPosition(r1)
            int r8 = android.widget.ExpandableListView.getPackedPositionType(r11)
            r13 = 2
            if (r8 == r13) goto L_0x00fd
            int r1 = android.widget.ExpandableListView.getPackedPositionGroup(r11)
            int r2 = android.widget.ExpandableListView.getPackedPositionChild(r11)
            r3 = -1
            if (r2 == r3) goto L_0x00c5
            java.util.Locale r3 = java.util.Locale.CHINA
            java.lang.String r8 = "%d:%d"
            java.lang.Object[] r11 = new java.lang.Object[r13]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r10] = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
            r11[r9] = r12
            java.lang.String r3 = java.lang.String.format(r3, r8, r11)
            r6.append(r5)
            java.lang.String r8 = "/ELVG["
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = "]/ELVC[-]/"
            r6.append(r8)
            r6.append(r7)
            java.lang.String r8 = "[0]"
            r6.append(r8)
            java.lang.String r8 = "/ELVG["
            r5.append(r8)
            r5.append(r1)
            java.lang.String r1 = "]/ELVC["
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = "]/"
            r5.append(r1)
            r5.append(r7)
            java.lang.String r1 = "[0]"
            r5.append(r1)
            goto L_0x01a0
        L_0x00c5:
            java.util.Locale r2 = java.util.Locale.CHINA
            java.lang.String r3 = "%d"
            java.lang.Object[] r8 = new java.lang.Object[r9]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            r8[r10] = r11
            java.lang.String r2 = java.lang.String.format(r2, r3, r8)
            r6.append(r5)
            java.lang.String r3 = "/ELVG[-]/"
            r6.append(r3)
            r6.append(r7)
            java.lang.String r3 = "[0]"
            r6.append(r3)
            java.lang.String r3 = "/ELVG["
            r5.append(r3)
            r5.append(r1)
            java.lang.String r1 = "]/"
            r5.append(r1)
            r5.append(r7)
            java.lang.String r1 = "[0]"
            r5.append(r1)
            r3 = r2
            goto L_0x01a0
        L_0x00fd:
            int r8 = r2.getHeaderViewsCount()
            if (r1 >= r8) goto L_0x012e
            java.lang.String r2 = "/ELH["
            r5.append(r2)
            r5.append(r1)
            java.lang.String r2 = "]/"
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = "[0]"
            r5.append(r2)
            java.lang.String r2 = "/ELH["
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = "]/"
            r6.append(r1)
            r6.append(r7)
            java.lang.String r1 = "[0]"
            r6.append(r1)
            goto L_0x0162
        L_0x012e:
            int r8 = r2.getCount()
            int r2 = r2.getFooterViewsCount()
            int r8 = r8 - r2
            int r1 = r1 - r8
            java.lang.String r2 = "/ELF["
            r5.append(r2)
            r5.append(r1)
            java.lang.String r2 = "]/"
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = "[0]"
            r5.append(r2)
            java.lang.String r2 = "/ELF["
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = "]/"
            r6.append(r1)
            r6.append(r7)
            java.lang.String r1 = "[0]"
            r6.append(r1)
        L_0x0162:
            r9 = r10
            goto L_0x01a0
        L_0x0164:
            boolean r8 = isListView(r4)
            if (r8 == 0) goto L_0x01a3
            java.util.Locale r2 = java.util.Locale.CHINA
            java.lang.String r3 = "%d"
            java.lang.Object[] r8 = new java.lang.Object[r9]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8[r10] = r1
            java.lang.String r1 = java.lang.String.format(r2, r3, r8)
            r6.append(r5)
            java.lang.String r2 = "/"
            r6.append(r2)
            r6.append(r7)
            java.lang.String r2 = "[-]"
            r6.append(r2)
            java.lang.String r2 = "/"
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = "["
            r5.append(r2)
            r5.append(r1)
            java.lang.String r2 = "]"
            r5.append(r2)
            r3 = r1
        L_0x01a0:
            r8 = r9
            goto L_0x021c
        L_0x01a3:
            boolean r1 = instanceOfSupportSwipeRefreshLayout(r4)
            if (r1 == 0) goto L_0x01c4
            java.lang.String r1 = "/"
            r5.append(r1)
            r5.append(r7)
            java.lang.String r1 = "[0]"
            r5.append(r1)
            java.lang.String r1 = "/"
            r6.append(r1)
            r6.append(r7)
            java.lang.String r1 = "[0]"
            r6.append(r1)
            goto L_0x021b
        L_0x01c4:
            java.lang.Object r1 = instanceOfFragmentRootView(r4, r14)
            if (r1 == 0) goto L_0x01ed
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = getCanonicalAndCheckCustomView(r1)
            java.lang.String r2 = "/"
            r5.append(r2)
            r5.append(r1)
            java.lang.String r2 = "[0]"
            r5.append(r2)
            java.lang.String r2 = "/"
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = "[0]"
            r6.append(r1)
            goto L_0x021b
        L_0x01ed:
            int r1 = com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil.getChildIndex(r2, r14)
            java.lang.String r2 = "/"
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = "["
            r5.append(r2)
            r5.append(r1)
            java.lang.String r2 = "]"
            r5.append(r2)
            java.lang.String r2 = "/"
            r6.append(r2)
            r6.append(r7)
            java.lang.String r2 = "["
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = "]"
            r6.append(r1)
        L_0x021b:
            r8 = r10
        L_0x021c:
            java.lang.Class r1 = r4.getClass()
            boolean r1 = com.sensorsdata.analytics.android.sdk.util.WindowHelper.isDecorView(r1)
            if (r1 == 0) goto L_0x0238
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x022f
            r5.deleteCharAt(r10)
        L_0x022f:
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x0238
            r6.deleteCharAt(r10)
        L_0x0238:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x024f
            android.util.SparseArray<java.lang.String> r1 = sViewCache
            monitor-enter(r1)
            android.util.SparseArray<java.lang.String> r2 = sViewCache     // Catch:{ all -> 0x024c }
            int r4 = r4.hashCode()     // Catch:{ all -> 0x024c }
            r2.put(r4, r3)     // Catch:{ all -> 0x024c }
            monitor-exit(r1)     // Catch:{ all -> 0x024c }
            goto L_0x024f
        L_0x024c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x024c }
            throw r0
        L_0x024f:
            r1 = r16
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = getViewContentAndType(r14, r1)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r9 = new com.sensorsdata.analytics.android.sdk.visual.model.ViewNode
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = r1.getViewContent()
            java.lang.String r7 = r1.getViewType()
            r1 = r9
            r2 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x026d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewNode(android.view.View, int, boolean):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewPathAndPosition(android.view.View r13, boolean r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 8
            r0.<init>(r1)
            r0.add(r13)
            android.view.ViewParent r1 = r13.getParent()
        L_0x000e:
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x001d
            r2 = r1
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.add(r2)
            android.view.ViewParent r1 = r1.getParent()
            goto L_0x000e
        L_0x001d:
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r2 = r0.get(r1)
            android.view.View r2 = (android.view.View) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            boolean r5 = r2 instanceof android.view.ViewGroup
            r6 = 0
            if (r5 == 0) goto L_0x00b0
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r1 = r1 + -1
            r5 = r6
        L_0x003d:
            if (r1 < 0) goto L_0x009e
            java.lang.Object r7 = r0.get(r1)
            android.view.View r7 = (android.view.View) r7
            int r2 = r2.indexOfChild(r7)
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = getViewNode(r7, r2, r14)
            if (r2 == 0) goto L_0x0093
            java.lang.String r5 = r2.getViewPath()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x007b
            java.lang.String r5 = r2.getViewPath()
            java.lang.String r8 = "-"
            boolean r5 = r5.contains(r8)
            if (r5 == 0) goto L_0x007b
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L_0x007b
            int r5 = r4.indexOf(r8)
            r8 = -1
            if (r5 == r8) goto L_0x007b
            int r8 = r5 + 1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.replace(r5, r8, r6)
        L_0x007b:
            java.lang.String r5 = r2.getViewOriginalPath()
            r3.append(r5)
            java.lang.String r5 = r2.getViewPath()
            r4.append(r5)
            java.lang.String r5 = r2.getViewPosition()
            java.lang.String r2 = r2.getViewContent()
            r6 = r5
            r5 = r2
        L_0x0093:
            boolean r2 = r7 instanceof android.view.ViewGroup
            if (r2 != 0) goto L_0x0098
            goto L_0x009e
        L_0x0098:
            r2 = r7
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r1 = r1 + -1
            goto L_0x003d
        L_0x009e:
            r12 = r5
            r9 = r6
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r14 = new com.sensorsdata.analytics.android.sdk.visual.model.ViewNode
            java.lang.String r10 = r3.toString()
            java.lang.String r11 = r4.toString()
            r7 = r14
            r8 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            return r14
        L_0x00b0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewPathAndPosition(android.view.View, boolean):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }

    private static int getViewPosition(View view, int i11) {
        int childAdapterPositionInRecyclerView;
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return i11;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (instanceOfAndroidXViewPager(viewGroup) || instanceOfSupportViewPager(viewGroup)) {
            return getCurrentItem(viewGroup);
        }
        if (viewGroup instanceof AdapterView) {
            return i11 + ((AdapterView) viewGroup).getFirstVisiblePosition();
        }
        if (!instanceOfRecyclerView(viewGroup) || (childAdapterPositionInRecyclerView = getChildAdapterPositionInRecyclerView(view, viewGroup)) < 0) {
            return i11;
        }
        return childAdapterPositionInRecyclerView;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        java.lang.Class.forName("androidx.recyclerview.widget.RecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean haveRecyclerView() {
        /*
            java.lang.String r0 = "androidx.recyclerview.widget.RecyclerView"
            r1 = 1
            java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0007 }
            return r1
        L_0x0007:
            java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x000b }
            return r1
        L_0x000b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.haveRecyclerView():boolean");
    }

    public static boolean instanceOfActionMenuItem(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ActionMenuItem");
    }

    public static boolean instanceOfAndroidXListMenuItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    private static boolean instanceOfAndroidXViewPager(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    public static boolean instanceOfBottomNavigationItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.google.android.material.bottomnavigation.BottomNavigationItemView", "com.google.android.material.internal.NavigationMenuItemView");
    }

    private static Object instanceOfFragmentRootView(View view, View view2) {
        Object fragmentFromView = AopUtil.getFragmentFromView(view);
        Object fragmentFromView2 = AopUtil.getFragmentFromView(view2);
        if (fragmentFromView != null || fragmentFromView2 == null) {
            return null;
        }
        return fragmentFromView2;
    }

    private static boolean instanceOfNavigationView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.google.android.material.navigation.NavigationView", "com.google.android.material.navigation.NavigationView");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = sRecyclerViewClass;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean instanceOfRecyclerView(java.lang.Object r1) {
        /*
            java.lang.String r0 = "androidx.recyclerview.widget.RecyclerView"
            java.lang.String[] r0 = new java.lang.String[]{r0, r0}
            boolean r0 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.isInstance(r1, r0)
            if (r0 != 0) goto L_0x0024
            boolean r0 = sHaveCustomRecyclerView
            if (r0 == 0) goto L_0x0022
            if (r1 == 0) goto L_0x0022
            java.lang.Class<?> r0 = sRecyclerViewClass
            if (r0 == 0) goto L_0x0022
            java.lang.Class r1 = r1.getClass()
            boolean r1 = r0.isAssignableFrom(r1)
            if (r1 == 0) goto L_0x0022
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            r0 = r1
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.instanceOfRecyclerView(java.lang.Object):boolean");
    }

    public static boolean instanceOfSupportListMenuItemView(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.view.menu.ListMenuItemView");
    }

    private static boolean instanceOfSupportSwipeRefreshLayout(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.swiperefreshlayout.widget.SwipeRefreshLayout", "androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
    }

    private static boolean instanceOfSupportViewPager(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.viewpager.widget.ViewPager");
    }

    private static Object instanceOfTabView(View view) {
        try {
            Class<?> currentClass = ReflectUtil.getCurrentClass(new String[]{"com.google.android.material.tabs.TabLayout$TabView", "com.google.android.material.tabs.TabLayout$TabView"});
            if (currentClass == null || !currentClass.isAssignableFrom(view.getClass())) {
                return null;
            }
            return ReflectUtil.findField(currentClass, (Object) view, "mTab", "tab");
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean instanceOfToolbar(Object obj) {
        return ReflectUtil.isInstance(obj, "androidx.appcompat.widget.Toolbar", "androidx.appcompat.widget.Toolbar", "android.widget.Toolbar");
    }

    private static boolean instanceOfUCWebView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.alipay.mobile.nebulauc.impl.UCWebView$WebViewEx");
    }

    public static boolean instanceOfWebView(Object obj) {
        return (obj instanceof WebView) || instanceOfX5WebView(obj) || instanceOfUCWebView(obj);
    }

    public static boolean instanceOfX5WebView(Object obj) {
        return ReflectUtil.isInstance(obj, "com.tencent.smtt.sdk.WebView");
    }

    public static void invalidateLayerTypeView(View[] viewArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            for (ViewGroup viewGroup : viewArr) {
                if (viewVisibilityInParents(viewGroup) && viewGroup.isHardwareAccelerated()) {
                    checkAndInvalidate(viewGroup);
                    if (viewGroup instanceof ViewGroup) {
                        invalidateViewGroup(viewGroup);
                    }
                }
            }
        }
    }

    private static void invalidateViewGroup(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (isViewSelfVisible(childAt)) {
                checkAndInvalidate(childAt);
                if (childAt instanceof ViewGroup) {
                    invalidateViewGroup((ViewGroup) childAt);
                }
            }
        }
    }

    private static int invokeCRVGetChildAdapterPositionMethod(View view, View view2) {
        try {
            if (view.getClass() != sRecyclerViewClass) {
                return -1;
            }
            return ((Integer) sRecyclerViewGetChildAdapterPositionMethod.invoke(view, new Object[]{view2})).intValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return -1;
        }
    }

    private static boolean isListView(View view) {
        return (view instanceof AdapterView) || instanceOfRecyclerView(view) || instanceOfAndroidXViewPager(view) || instanceOfSupportViewPager(view);
    }

    public static boolean isTrackEvent(View view, boolean z11) {
        if (view instanceof CheckBox) {
            if (!z11) {
                return false;
            }
        } else if (view instanceof RadioButton) {
            if (!z11) {
                return false;
            }
        } else if (view instanceof ToggleButton) {
            if (!z11) {
                return false;
            }
        } else if ((view instanceof CompoundButton) && !z11) {
            return false;
        }
        if (!(view instanceof RatingBar) || z11) {
            return true;
        }
        return false;
    }

    public static boolean isViewSelfVisible(View view) {
        boolean z11;
        if (view == null || view.getWindowVisibility() == 8) {
            return false;
        }
        if (WindowHelper.isDecorView(view.getClass())) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            Boolean localVisibleRect = SnapCache.getInstance().getLocalVisibleRect(view);
            if (localVisibleRect == null) {
                z11 = view.getLocalVisibleRect(new Rect());
                SnapCache.getInstance().setLocalVisibleRect(view, Boolean.valueOf(z11));
            } else {
                z11 = localVisibleRect.booleanValue();
            }
            if (view.getWidth() <= 0 || view.getHeight() <= 0 || view.getAlpha() <= 0.0f || !z11) {
                return false;
            }
        }
        if ((view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) && view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isWindowNeedTraverse(View view, String str, boolean z11) {
        if (view.hashCode() == AppStateManager.getInstance().getCurrentRootWindowsHashCode()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            if (!z11) {
                return true;
            }
            if (!(view.getWindowVisibility() == 8 || view.getVisibility() != 0 || TextUtils.equals(str, WindowHelper.getMainWindowPrefix()) || view.getWidth() == 0 || view.getHeight() == 0)) {
                return true;
            }
        }
        if ((view.getWindowVisibility() == 0 || view.getVisibility() == 0) && WindowHelper.isCustomWindow(view)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean viewVisibilityInParents(android.view.View r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = isViewSelfVisible(r2)
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            android.view.ViewParent r2 = r2.getParent()
        L_0x000f:
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L_0x0024
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            boolean r1 = isViewSelfVisible(r1)
            if (r1 != 0) goto L_0x001d
            return r0
        L_0x001d:
            android.view.ViewParent r2 = r2.getParent()
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x0024:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.viewVisibilityInParents(android.view.View):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015d, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x011a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sensorsdata.analytics.android.sdk.visual.model.ViewNode getViewContentAndType(android.view.View r6, boolean r7) {
        /*
            com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache r0 = com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache.getInstance()
            java.lang.String r0 = r0.getViewType(r6)
            com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache r1 = com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache.getInstance()
            java.lang.String r1 = r1.getViewText(r6)
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0016
            if (r1 != 0) goto L_0x01df
        L_0x0016:
            com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache r0 = com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache.getInstance()
            java.lang.Class r1 = r6.getClass()
            java.lang.String r0 = r0.getCanonicalName(r1)
            boolean r1 = r6 instanceof android.widget.CheckBox
            r3 = 0
            if (r1 == 0) goto L_0x0036
            java.lang.String r1 = "CheckBox"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            java.lang.CharSequence r3 = r1.getText()
            goto L_0x01ad
        L_0x0036:
            boolean r1 = r6 instanceof android.widget.RadioButton
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = "RadioButton"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.RadioButton r1 = (android.widget.RadioButton) r1
            java.lang.CharSequence r3 = r1.getText()
            goto L_0x01ad
        L_0x0049:
            boolean r1 = r6 instanceof android.widget.ToggleButton
            if (r1 == 0) goto L_0x0059
            java.lang.String r1 = "ToggleButton"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            java.lang.String r3 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getCompoundButtonText(r6)
            goto L_0x01ad
        L_0x0059:
            boolean r1 = r6 instanceof android.widget.CompoundButton
            if (r1 == 0) goto L_0x0067
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewTypeByReflect(r6)
            java.lang.String r3 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getCompoundButtonText(r6)
            goto L_0x01ad
        L_0x0067:
            boolean r1 = r6 instanceof android.widget.Button
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = "Button"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.Button r1 = (android.widget.Button) r1
            java.lang.CharSequence r3 = r1.getText()
            goto L_0x01ad
        L_0x007a:
            boolean r1 = r6 instanceof android.widget.CheckedTextView
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = "CheckedTextView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.CheckedTextView r1 = (android.widget.CheckedTextView) r1
            java.lang.CharSequence r3 = r1.getText()
            goto L_0x01ad
        L_0x008d:
            boolean r1 = r6 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x00a0
            java.lang.String r1 = "TextView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r3 = r1.getText()
            goto L_0x01ad
        L_0x00a0:
            boolean r1 = r6 instanceof android.widget.ImageView
            if (r1 == 0) goto L_0x00c1
            java.lang.String r1 = "ImageView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.CharSequence r4 = r1.getContentDescription()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01ad
            java.lang.CharSequence r1 = r1.getContentDescription()
            java.lang.String r3 = r1.toString()
            goto L_0x01ad
        L_0x00c1:
            boolean r1 = r6 instanceof android.widget.RatingBar
            if (r1 == 0) goto L_0x00d8
            java.lang.String r1 = "RatingBar"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.RatingBar r1 = (android.widget.RatingBar) r1
            float r1 = r1.getRating()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            goto L_0x01ad
        L_0x00d8:
            boolean r1 = r6 instanceof android.widget.SeekBar
            if (r1 == 0) goto L_0x00ef
            java.lang.String r1 = "SeekBar"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            r1 = r6
            android.widget.SeekBar r1 = (android.widget.SeekBar) r1
            int r1 = r1.getProgress()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            goto L_0x01ad
        L_0x00ef:
            boolean r1 = r6 instanceof android.widget.Spinner
            r4 = 0
            if (r1 == 0) goto L_0x0123
            java.lang.String r1 = "Spinner"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r1.<init>()     // Catch:{ Exception -> 0x011d }
            r5 = r6
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5     // Catch:{ Exception -> 0x011d }
            java.lang.String r3 = com.sensorsdata.analytics.android.sdk.util.AopUtil.traverseView(r1, r5)     // Catch:{ Exception -> 0x011d }
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x011d }
            if (r1 != 0) goto L_0x01ad
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x011d }
            int r5 = r3.length()     // Catch:{ Exception -> 0x011d }
            int r5 = r5 + -1
            java.lang.String r1 = r1.substring(r4, r5)     // Catch:{ Exception -> 0x011d }
        L_0x011a:
            r3 = r1
            goto L_0x01ad
        L_0x011d:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            goto L_0x01ad
        L_0x0123:
            java.lang.Object r1 = instanceOfTabView(r6)
            if (r1 == 0) goto L_0x0135
            java.lang.String r3 = getTabLayoutContent(r1)
            java.lang.String r1 = "TabLayout"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            goto L_0x01ad
        L_0x0135:
            boolean r1 = instanceOfBottomNavigationItemView(r6)
            if (r1 == 0) goto L_0x0160
            java.lang.Object r1 = getItemData(r6)
            if (r1 == 0) goto L_0x01ad
            java.lang.String r4 = "androidx.appcompat.view.menu.MenuItemImpl"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x01ad }
            java.lang.Class r4 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.getCurrentClass(r4)     // Catch:{ Exception -> 0x01ad }
            if (r4 == 0) goto L_0x01ad
            java.lang.String r5 = "mTitle"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x01ad }
            java.lang.Object r1 = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findField((java.lang.Class<?>) r4, (java.lang.Object) r1, (java.lang.String[]) r5)     // Catch:{ Exception -> 0x01ad }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x01ad }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01ad }
            if (r4 != 0) goto L_0x01ad
            goto L_0x011a
        L_0x0160:
            boolean r1 = instanceOfNavigationView(r6)
            if (r1 == 0) goto L_0x0179
            boolean r1 = isViewSelfVisible(r6)
            if (r1 == 0) goto L_0x016f
            java.lang.String r1 = "Open"
            goto L_0x0171
        L_0x016f:
            java.lang.String r1 = "Close"
        L_0x0171:
            r3 = r1
            java.lang.String r1 = "NavigationView"
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewType(r0, r1)
            goto L_0x01ad
        L_0x0179:
            boolean r1 = r6 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x01ad
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewGroupTypeByReflect(r6)
            java.lang.CharSequence r3 = r6.getContentDescription()
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x01ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ad }
            r1.<init>()     // Catch:{ Exception -> 0x01ad }
            r5 = r6
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5     // Catch:{ Exception -> 0x01ad }
            java.lang.String r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.traverseView(r1, r5)     // Catch:{ Exception -> 0x01ad }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x011a
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x011a }
            int r5 = r1.length()     // Catch:{ Exception -> 0x011a }
            int r5 = r5 + -1
            java.lang.String r1 = r3.substring(r4, r5)     // Catch:{ Exception -> 0x011a }
            goto L_0x011a
        L_0x01ad:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x01be
            boolean r1 = r6 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x01be
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r3 = r1.getHint()
        L_0x01be:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x01c8
            java.lang.CharSequence r3 = r6.getContentDescription()
        L_0x01c8:
            if (r3 != 0) goto L_0x01cc
            r1 = r2
            goto L_0x01cd
        L_0x01cc:
            r1 = r3
        L_0x01cd:
            com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache r3 = com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache.getInstance()
            r3.setViewType(r6, r0)
            com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache r3 = com.sensorsdata.analytics.android.sdk.visual.snap.SnapCache.getInstance()
            java.lang.String r4 = r1.toString()
            r3.setViewText(r6, r4)
        L_0x01df:
            boolean r3 = r6 instanceof android.widget.EditText
            if (r3 == 0) goto L_0x01ed
            if (r7 == 0) goto L_0x01ec
            android.widget.EditText r6 = (android.widget.EditText) r6
            android.text.Editable r1 = r6.getText()
            goto L_0x01ed
        L_0x01ec:
            r1 = r2
        L_0x01ed:
            if (r1 != 0) goto L_0x01f0
            goto L_0x01f1
        L_0x01f0:
            r2 = r1
        L_0x01f1:
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r6 = new com.sensorsdata.analytics.android.sdk.visual.model.ViewNode
            java.lang.String r7 = r2.toString()
            r6.<init>(r7, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewContentAndType(android.view.View, boolean):com.sensorsdata.analytics.android.sdk.visual.model.ViewNode");
    }
}
