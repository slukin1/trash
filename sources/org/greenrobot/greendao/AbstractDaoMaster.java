package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public abstract class AbstractDaoMaster {
    public final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap = new HashMap();

    /* renamed from: db  reason: collision with root package name */
    public final Database f68293db;
    public final int schemaVersion;

    public AbstractDaoMaster(Database database, int i11) {
        this.f68293db = database;
        this.schemaVersion = i11;
    }

    public Database getDatabase() {
        return this.f68293db;
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType identityScopeType);

    public void registerDaoClass(Class<? extends AbstractDao<?, ?>> cls) {
        this.daoConfigMap.put(cls, new DaoConfig(this.f68293db, cls));
    }
}
