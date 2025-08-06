package com.tencent.qcloud.tuikit.tuichat.component.progress;

import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgressPresenter {
    private static final String TAG = "ProgressPresenter";
    private final Map<String, List<WeakReference<ProgressListener>>> progressListenerMap;

    public interface ProgressListener {
        void onProgress(int i11);
    }

    public static final class ProgressPresenterHolder {
        /* access modifiers changed from: private */
        public static final ProgressPresenter instance = new ProgressPresenter();

        private ProgressPresenterHolder() {
        }
    }

    public static ProgressPresenter getInstance() {
        return ProgressPresenterHolder.instance;
    }

    public void registerProgressListener(String str, ProgressListener progressListener) {
        String str2 = TAG;
        Log.i(str2, "registerProgressListener id : " + str + ", listener : " + progressListener);
        if (!TextUtils.isEmpty(str) && progressListener != null) {
            List list = this.progressListenerMap.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.progressListenerMap.put(str, list);
            }
            list.add(new WeakReference(progressListener));
        }
    }

    public void unregisterProgressListener(String str, ProgressListener progressListener) {
        List list;
        String str2 = TAG;
        Log.i(str2, "unregisterProgressListener id : " + str + ", listener : " + progressListener);
        if (!TextUtils.isEmpty(str) && progressListener != null && (list = this.progressListenerMap.get(str)) == null) {
            WeakReference weakReference = null;
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WeakReference weakReference2 = (WeakReference) it2.next();
                if (weakReference2.get() == progressListener) {
                    weakReference = weakReference2;
                    break;
                }
            }
            list.remove(weakReference);
        }
    }

    public void updateProgress(String str, int i11) {
        List list = this.progressListenerMap.get(str);
        if (list == null || list.isEmpty()) {
            this.progressListenerMap.remove(str);
            return;
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ProgressListener progressListener = (ProgressListener) ((WeakReference) listIterator.next()).get();
            if (progressListener != null) {
                progressListener.onProgress(i11);
            }
        }
    }

    private ProgressPresenter() {
        this.progressListenerMap = new ConcurrentHashMap();
    }
}
