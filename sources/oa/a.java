package oa;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Stack;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Stack<WeakReference<Activity>> f76378a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Activity> f76379b;

    /* renamed from: c  reason: collision with root package name */
    public static a f76380c;

    public static a g() {
        if (f76380c == null) {
            synchronized (a.class) {
                if (f76380c == null) {
                    f76380c = new a();
                }
            }
        }
        return f76380c;
    }

    public void a(Activity activity) {
        Activity activity2;
        Stack<WeakReference<Activity>> stack = f76378a;
        stack.add(new WeakReference(activity));
        int size = stack.size();
        if (size > 4) {
            int i11 = 1;
            while (true) {
                int i12 = size - 3;
                if (i11 < i12) {
                    Stack<WeakReference<Activity>> stack2 = f76378a;
                    if (((WeakReference) stack2.get(i11)).get() != null) {
                        String name = ((Activity) ((WeakReference) stack2.get(i11)).get()).getClass().getName();
                        while (true) {
                            if (i12 >= size) {
                                break;
                            }
                            Stack<WeakReference<Activity>> stack3 = f76378a;
                            if (((WeakReference) stack3.get(i12)).get() != null && name.equals(((Activity) ((WeakReference) stack3.get(i12)).get()).getClass().getName()) && !name.contains("WebActivity") && !name.contains("EdgeEngineContainerActivity") && (activity2 = (Activity) ((WeakReference) stack3.get(i11)).get()) != null) {
                                activity2.finish();
                                break;
                            }
                            i12++;
                        }
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public Activity b() {
        WeakReference<Activity> weakReference = f76379b;
        return weakReference == null ? c() : (Activity) weakReference.get();
    }

    @Deprecated
    public final Activity c() {
        Stack<WeakReference<Activity>> stack = f76378a;
        if (stack.size() == 0) {
            return null;
        }
        return (Activity) ((WeakReference) stack.lastElement()).get();
    }

    public void d(Activity activity) {
        if (activity != null) {
            k(activity);
            activity.finish();
        }
    }

    public void e(Class<?> cls) {
        Iterator it2 = f76378a.iterator();
        while (it2.hasNext()) {
            WeakReference weakReference = (WeakReference) it2.next();
            if (weakReference.get() != null && ((Activity) weakReference.get()).getClass().equals(cls)) {
                d((Activity) weakReference.get());
                return;
            }
        }
    }

    public Activity f(Class<?> cls) {
        Iterator it2 = f76378a.iterator();
        while (it2.hasNext()) {
            WeakReference weakReference = (WeakReference) it2.next();
            if (weakReference.get() != null && ((Activity) weakReference.get()).getClass().equals(cls)) {
                return (Activity) weakReference.get();
            }
        }
        return null;
    }

    public Activity h() {
        Stack<WeakReference<Activity>> stack = f76378a;
        int size = stack.size();
        if (size < 2) {
            return null;
        }
        return (Activity) ((WeakReference) stack.get(size - 2)).get();
    }

    public void i(Class<?> cls) {
        int size = f76378a.size();
        int i11 = 0;
        while (i11 < size) {
            Activity activity = (Activity) ((WeakReference) f76378a.get(i11)).get();
            if (activity == null || !activity.getClass().equals(cls)) {
                i11++;
            } else {
                activity.recreate();
                return;
            }
        }
    }

    public void j(Class<?> cls) {
        for (int size = f76378a.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) ((WeakReference) f76378a.get(size)).get();
            if (activity != null && !activity.getClass().equals(cls)) {
                String simpleName = activity.getClass().getSimpleName();
                if (!simpleName.equals("TradeContainerActivity") && !simpleName.equals("FutureTradeContainerActivity") && !simpleName.equals("MarketContainerActivity") && !simpleName.equals("AccountContainerActivity")) {
                    activity.recreate();
                }
            }
        }
    }

    public void k(Activity activity) {
        for (int size = f76378a.size() - 1; size >= 0; size--) {
            Stack<WeakReference<Activity>> stack = f76378a;
            if (((WeakReference) stack.get(size)).get() == null || activity == ((WeakReference) stack.get(size)).get()) {
                stack.remove(stack.get(size));
            }
        }
    }

    public void l(Activity activity) {
        f76379b = new WeakReference<>(activity);
    }
}
