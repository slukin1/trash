package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;

public class CountQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    public static final class QueryData<T2> extends AbstractQueryData<T2, CountQuery<T2>> {
        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }

        public CountQuery<T2> createQuery() {
            return new CountQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    public static <T2> CountQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (CountQuery) new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr)).forCurrentThread();
    }

    public long count() {
        checkThread();
        Cursor rawQuery = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        try {
            if (!rawQuery.moveToNext()) {
                throw new DaoException("No result for count");
            } else if (!rawQuery.isLast()) {
                throw new DaoException("Unexpected row count: " + rawQuery.getCount());
            } else if (rawQuery.getColumnCount() == 1) {
                return rawQuery.getLong(0);
            } else {
                throw new DaoException("Unexpected column count: " + rawQuery.getColumnCount());
            }
        } finally {
            rawQuery.close();
        }
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery) this.queryData.forCurrentThread(this);
    }

    private CountQuery(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData2;
    }

    public CountQuery<T> setParameter(int i11, Object obj) {
        return (CountQuery) super.setParameter(i11, obj);
    }

    public CountQuery<T> setParameter(int i11, Date date) {
        return (CountQuery) super.setParameter(i11, date);
    }

    public CountQuery<T> setParameter(int i11, Boolean bool) {
        return (CountQuery) super.setParameter(i11, bool);
    }
}
