package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

abstract class AbstractQueryWithLimit<T> extends AbstractQuery<T> {
    public final int limitPosition;
    public final int offsetPosition;

    public AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i11, int i12) {
        super(abstractDao, str, strArr);
        this.limitPosition = i11;
        this.offsetPosition = i12;
    }

    public void setLimit(int i11) {
        checkThread();
        int i12 = this.limitPosition;
        if (i12 != -1) {
            this.parameters[i12] = Integer.toString(i11);
            return;
        }
        throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    }

    public void setOffset(int i11) {
        checkThread();
        int i12 = this.offsetPosition;
        if (i12 != -1) {
            this.parameters[i12] = Integer.toString(i11);
            return;
        }
        throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    }

    public AbstractQueryWithLimit<T> setParameter(int i11, Object obj) {
        if (i11 < 0 || (i11 != this.limitPosition && i11 != this.offsetPosition)) {
            return (AbstractQueryWithLimit) super.setParameter(i11, obj);
        }
        throw new IllegalArgumentException("Illegal parameter index: " + i11);
    }
}
