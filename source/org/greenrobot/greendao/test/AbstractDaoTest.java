package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;

public abstract class AbstractDaoTest<D extends AbstractDao<T, K>, T, K> extends DbTest {
    public D dao;
    public InternalUnitTestDaoAccess<T, K> daoAccess;
    public final Class<D> daoClass;
    public IdentityScope<K, T> identityScopeForDao;
    public Property pkColumn;

    public AbstractDaoTest(Class<D> cls) {
        this(cls, true);
    }

    public void clearIdentityScopeIfAny() {
        IdentityScope<K, T> identityScope = this.identityScopeForDao;
        if (identityScope != null) {
            identityScope.clear();
            DaoLog.d("Identity scope cleared");
            return;
        }
        DaoLog.d("No identity scope to clear");
    }

    public void logTableDump() {
        logTableDump(this.dao.getTablename());
    }

    public void setIdentityScopeBeforeSetUp(IdentityScope<K, T> identityScope) {
        this.identityScopeForDao = identityScope;
    }

    public void setUp() throws Exception {
        super.setUp();
        try {
            setUpTableForDao();
            InternalUnitTestDaoAccess<T, K> internalUnitTestDaoAccess = new InternalUnitTestDaoAccess<>(this.f70136db, this.daoClass, this.identityScopeForDao);
            this.daoAccess = internalUnitTestDaoAccess;
            this.dao = internalUnitTestDaoAccess.getDao();
        } catch (Exception e11) {
            throw new RuntimeException("Could not prepare DAO Test", e11);
        }
    }

    public void setUpTableForDao() throws Exception {
        try {
            this.daoClass.getMethod("createTable", new Class[]{Database.class, Boolean.TYPE}).invoke((Object) null, new Object[]{this.f70136db, Boolean.FALSE});
        } catch (NoSuchMethodException unused) {
            DaoLog.i("No createTable method");
        }
    }

    public AbstractDaoTest(Class<D> cls, boolean z11) {
        super(z11);
        this.daoClass = cls;
    }
}
