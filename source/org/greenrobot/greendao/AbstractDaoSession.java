package org.greenrobot.greendao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxTransaction;
import rx.schedulers.Schedulers;

public class AbstractDaoSession {

    /* renamed from: db  reason: collision with root package name */
    private final Database f68294db;
    private final Map<Class<?>, AbstractDao<?, ?>> entityToDao = new HashMap();
    private volatile RxTransaction rxTxIo;
    private volatile RxTransaction rxTxPlain;

    public AbstractDaoSession(Database database) {
        this.f68294db = database;
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.f68294db.beginTransaction();
        try {
            V call = callable.call();
            this.f68294db.setTransactionSuccessful();
            return call;
        } finally {
            this.f68294db.endTransaction();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.f68294db.beginTransaction();
        try {
            V call = callable.call();
            this.f68294db.setTransactionSuccessful();
            this.f68294db.endTransaction();
            return call;
        } catch (Exception e11) {
            throw new DaoException("Callable failed", e11);
        } catch (Throwable th2) {
            this.f68294db.endTransaction();
            throw th2;
        }
    }

    public <T> void delete(T t11) {
        getDao(t11.getClass()).delete(t11);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public Collection<AbstractDao<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.entityToDao.values());
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> cls) {
        AbstractDao<?, ?> abstractDao = this.entityToDao.get(cls);
        if (abstractDao != null) {
            return abstractDao;
        }
        throw new DaoException("No DAO registered for " + cls);
    }

    public Database getDatabase() {
        return this.f68294db;
    }

    public <T> long insert(T t11) {
        return getDao(t11.getClass()).insert(t11);
    }

    public <T> long insertOrReplace(T t11) {
        return getDao(t11.getClass()).insertOrReplace(t11);
    }

    public <T, K> T load(Class<T> cls, K k11) {
        return getDao(cls).load(k11);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return getDao(cls).loadAll();
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> cls) {
        return getDao(cls).queryBuilder();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return getDao(cls).queryRaw(str, strArr);
    }

    public <T> void refresh(T t11) {
        getDao(t11.getClass()).refresh(t11);
    }

    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.entityToDao.put(cls, abstractDao);
    }

    public void runInTx(Runnable runnable) {
        this.f68294db.beginTransaction();
        try {
            runnable.run();
            this.f68294db.setTransactionSuccessful();
        } finally {
            this.f68294db.endTransaction();
        }
    }

    @Experimental
    public RxTransaction rxTx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new RxTransaction(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    @Experimental
    public RxTransaction rxTxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new RxTransaction(this);
        }
        return this.rxTxPlain;
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }

    public <T> void update(T t11) {
        getDao(t11.getClass()).update(t11);
    }
}
