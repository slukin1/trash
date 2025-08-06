package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;

public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest {
    public T daoMaster;
    private final Class<T> daoMasterClass;
    public S daoSession;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    public void setUp() throws Exception {
        Class<Database> cls = Database.class;
        super.setUp();
        try {
            this.daoMaster = (AbstractDaoMaster) this.daoMasterClass.getConstructor(new Class[]{cls}).newInstance(new Object[]{this.f70136db});
            this.daoMasterClass.getMethod("createAllTables", new Class[]{cls, Boolean.TYPE}).invoke((Object) null, new Object[]{this.f70136db, Boolean.FALSE});
            this.daoSession = this.daoMaster.newSession();
        } catch (Exception e11) {
            throw new RuntimeException("Could not prepare DAO session test", e11);
        }
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z11) {
        super(z11);
        this.daoMasterClass = cls;
    }
}
