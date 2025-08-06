package org.greenrobot.greendao.test;

import junit.framework.TestCase;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;

public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T> extends AbstractDaoTestSinglePk<D, T, Long> {
    public AbstractDaoTestLongPk(Class<D> cls) {
        super(cls);
    }

    public void testAssignPk() {
        if (this.daoAccess.isEntityUpdateable()) {
            Object createEntity = createEntity(null);
            if (createEntity != null) {
                Object createEntity2 = createEntity(null);
                this.dao.insert(createEntity);
                this.dao.insert(createEntity2);
                Long l11 = (Long) this.daoAccess.getKey(createEntity);
                TestCase.assertNotNull(l11);
                Long l12 = (Long) this.daoAccess.getKey(createEntity2);
                TestCase.assertNotNull(l12);
                TestCase.assertFalse(l11.equals(l12));
                TestCase.assertNotNull(this.dao.load(l11));
                TestCase.assertNotNull(this.dao.load(l12));
                return;
            }
            DaoLog.d("Skipping testAssignPk for " + this.daoClass + " (createEntity returned null for null key)");
            return;
        }
        DaoLog.d("Skipping testAssignPk for not updateable " + this.daoClass);
    }

    public Long createRandomPk() {
        return Long.valueOf(this.random.nextLong());
    }
}
