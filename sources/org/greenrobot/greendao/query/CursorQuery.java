package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;

public class CursorQuery<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;

    public static final class QueryData<T2> extends AbstractQueryData<T2, CursorQuery<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        public QueryData(AbstractDao abstractDao, String str, String[] strArr, int i11, int i12) {
            super(abstractDao, str, strArr);
            this.limitPosition = i11;
            this.offsetPosition = i12;
        }

        public CursorQuery<T2> createQuery() {
            return new CursorQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> CursorQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i11, int i12) {
        return (CursorQuery) new QueryData(abstractDao, str, AbstractQuery.toStringArray(objArr), i11, i12).forCurrentThread();
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    public CursorQuery forCurrentThread() {
        return (CursorQuery) this.queryData.forCurrentThread(this);
    }

    public Cursor query() {
        checkThread();
        return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    }

    public /* bridge */ /* synthetic */ void setLimit(int i11) {
        super.setLimit(i11);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i11) {
        super.setOffset(i11);
    }

    private CursorQuery(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i11, int i12) {
        super(abstractDao, str, strArr, i11, i12);
        this.queryData = queryData2;
    }

    public CursorQuery<T> setParameter(int i11, Object obj) {
        return (CursorQuery) super.setParameter(i11, obj);
    }

    public CursorQuery<T> setParameter(int i11, Date date) {
        return (CursorQuery) super.setParameter(i11, date);
    }

    public CursorQuery<T> setParameter(int i11, Boolean bool) {
        return (CursorQuery) super.setParameter(i11, bool);
    }
}
