package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.elements.android.window.WindowRootViewCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

final class ApplicationDescriptor extends AbstractChainedDescriptor<Application> {
    /* access modifiers changed from: private */
    public final ActivityTracker mActivityTracker = ActivityTracker.get();
    private final Map<Application, ElementContext> mElementToContextMap = Collections.synchronizedMap(new IdentityHashMap());

    public class ElementContext {
        private Application mElement;
        private final ActivityTracker.Listener mListener = new ActivityTracker.Listener() {
            public void onActivityAdded(Activity activity) {
            }

            public void onActivityRemoved(Activity activity) {
            }
        };

        public ElementContext() {
        }

        public List<WeakReference<Activity>> getActivitiesList() {
            return ApplicationDescriptor.this.mActivityTracker.getActivitiesView();
        }

        public void hook(Application application) {
            this.mElement = application;
            ApplicationDescriptor.this.mActivityTracker.registerListener(this.mListener);
        }

        public void unhook() {
            ApplicationDescriptor.this.mActivityTracker.unregisterListener(this.mListener);
            this.mElement = null;
        }
    }

    private ElementContext getContext(Application application) {
        return this.mElementToContextMap.get(application);
    }

    private static boolean isDecorViewOfActivity(View view, List<WeakReference<Activity>> list) {
        Util.throwIfNull(list);
        for (WeakReference<Activity> weakReference : list) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null && activity.getWindow().getDecorView() == view) {
                return true;
            }
        }
        return false;
    }

    private void storeWindowIfNeeded(Application application, Accumulator<Object> accumulator, List<WeakReference<Activity>> list) {
        for (View next : WindowRootViewCompat.get(application).getRootViews()) {
            if (!isDecorViewOfActivity(next, list)) {
                accumulator.store(next);
            }
        }
    }

    public void onGetChildren(Application application, Accumulator<Object> accumulator) {
        List<WeakReference<Activity>> activitiesList = getContext(application).getActivitiesList();
        for (int size = activitiesList.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) activitiesList.get(size).get();
            if (activity != null) {
                accumulator.store(activity);
            }
        }
        storeWindowIfNeeded(application, accumulator, activitiesList);
    }

    public NodeType onGetNodeType(Application application) {
        return NodeType.ELEMENT_NODE;
    }

    public void onHook(Application application) {
        ElementContext elementContext = new ElementContext();
        elementContext.hook(application);
        this.mElementToContextMap.put(application, elementContext);
    }

    public void onUnhook(Application application) {
        this.mElementToContextMap.remove(application).unhook();
    }
}
