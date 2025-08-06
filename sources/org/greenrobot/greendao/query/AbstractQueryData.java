package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    public final AbstractDao<T, ?> dao;
    public final String[] initialValues;
    public final Map<Long, WeakReference<Q>> queriesForThreads = new HashMap();
    public final String sql;

    public AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    public abstract Q createQuery();

    public Q forCurrentThread(Q q11) {
        if (Thread.currentThread() != q11.ownerThread) {
            return forCurrentThread();
        }
        String[] strArr = this.initialValues;
        System.arraycopy(strArr, 0, q11.parameters, 0, strArr.length);
        return q11;
    }

    public void gc() {
        synchronized (this.queriesForThreads) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> it2 = this.queriesForThreads.entrySet().iterator();
            while (it2.hasNext()) {
                if (((WeakReference) it2.next().getValue()).get() == null) {
                    it2.remove();
                }
            }
        }
    }

    public Q forCurrentThread() {
        Q q11;
        long id2 = Thread.currentThread().getId();
        synchronized (this.queriesForThreads) {
            WeakReference weakReference = this.queriesForThreads.get(Long.valueOf(id2));
            q11 = weakReference != null ? (AbstractQuery) weakReference.get() : null;
            if (q11 == null) {
                gc();
                q11 = createQuery();
                this.queriesForThreads.put(Long.valueOf(id2), new WeakReference(q11));
            } else {
                String[] strArr = this.initialValues;
                System.arraycopy(strArr, 0, q11.parameters, 0, strArr.length);
            }
        }
        return q11;
    }
}
