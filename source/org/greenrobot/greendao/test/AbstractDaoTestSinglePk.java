package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K> {
    private Property pkColumn;
    public Set<K> usedPks = new HashSet();

    public AbstractDaoTestSinglePk(Class<D> cls) {
        super(cls);
    }

    public boolean checkKeyIsNullable() {
        if (createEntity((Object) null) != null) {
            return true;
        }
        DaoLog.d("Test is not available for entities with non-null keys");
        return false;
    }

    public abstract T createEntity(K k11);

    public T createEntityWithRandomPk() {
        return createEntity(nextPk());
    }

    public abstract K createRandomPk();

    public K nextPk() {
        for (int i11 = 0; i11 < 100000; i11++) {
            K createRandomPk = createRandomPk();
            if (this.usedPks.add(createRandomPk)) {
                return createRandomPk;
            }
        }
        throw new IllegalStateException("Could not find a new PK");
    }

    public Cursor queryWithDummyColumnsInFront(int i11, String str, K k11) {
        StringBuilder sb2 = new StringBuilder("SELECT ");
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            sb2.append(str);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        SqlUtils.appendColumns(sb2, "T", this.dao.getAllColumns()).append(" FROM ");
        sb2.append('\"');
        sb2.append(this.dao.getTablename());
        sb2.append('\"');
        sb2.append(" T");
        if (k11 != null) {
            sb2.append(" WHERE ");
            TestCase.assertEquals(1, this.dao.getPkColumns().length);
            sb2.append(this.dao.getPkColumns()[0]);
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            DatabaseUtils.appendValueToSql(sb2, k11);
        }
        Cursor rawQuery = this.f70136db.rawQuery(sb2.toString(), (String[]) null);
        TestCase.assertTrue(rawQuery.moveToFirst());
        while (i12 < i11) {
            try {
                TestCase.assertEquals(str, rawQuery.getString(i12));
                i12++;
            } catch (RuntimeException e11) {
                rawQuery.close();
                throw e11;
            }
        }
        if (k11 != null) {
            TestCase.assertEquals(1, rawQuery.getCount());
        }
        return rawQuery;
    }

    public void runLoadPkTest(int i11) {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(i11, "42", nextPk);
        try {
            TestCase.assertEquals(nextPk, (Object) this.daoAccess.readKey(queryWithDummyColumnsInFront, i11));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    public void setUp() throws Exception {
        super.setUp();
        for (Property property : this.daoAccess.getProperties()) {
            if (property.primaryKey) {
                if (this.pkColumn == null) {
                    this.pkColumn = property;
                } else {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
            }
        }
        if (this.pkColumn == null) {
            throw new RuntimeException("Test does not work without a PK column");
        }
    }

    public void testCount() {
        this.dao.deleteAll();
        TestCase.assertEquals(0, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        TestCase.assertEquals(1, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        TestCase.assertEquals(2, this.dao.count());
    }

    public void testDelete() {
        Object nextPk = nextPk();
        this.dao.deleteByKey(nextPk);
        this.dao.insert(createEntity(nextPk));
        TestCase.assertNotNull(this.dao.load(nextPk));
        this.dao.deleteByKey(nextPk);
        TestCase.assertNull(this.dao.load(nextPk));
    }

    public void testDeleteAll() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < 10; i11++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        this.dao.deleteAll();
        TestCase.assertEquals(0, this.dao.count());
        for (Object key : arrayList) {
            K key2 = this.daoAccess.getKey(key);
            TestCase.assertNotNull(key2);
            TestCase.assertNull(this.dao.load(key2));
        }
    }

    public void testDeleteByKeyInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 10; i11++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.daoAccess.getKey(arrayList.get(0)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(3)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(4)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(8)));
        this.dao.deleteByKeyInTx(arrayList2);
        TestCase.assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object next : arrayList2) {
            TestCase.assertNotNull(next);
            TestCase.assertNull(this.dao.load(next));
        }
    }

    public void testDeleteInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 10; i11++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        ArrayList<Object> arrayList2 = new ArrayList<>();
        arrayList2.add(arrayList.get(0));
        arrayList2.add(arrayList.get(3));
        arrayList2.add(arrayList.get(4));
        arrayList2.add(arrayList.get(8));
        this.dao.deleteInTx(arrayList2);
        TestCase.assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object key : arrayList2) {
            K key2 = this.daoAccess.getKey(key);
            TestCase.assertNotNull(key2);
            TestCase.assertNull(this.dao.load(key2));
        }
    }

    public void testInsertAndLoad() {
        Object nextPk = nextPk();
        Object createEntity = createEntity(nextPk);
        this.dao.insert(createEntity);
        TestCase.assertEquals(nextPk, (Object) this.daoAccess.getKey(createEntity));
        Object load = this.dao.load(nextPk);
        TestCase.assertNotNull(load);
        TestCase.assertEquals((Object) this.daoAccess.getKey(createEntity), (Object) this.daoAccess.getKey(load));
    }

    public void testInsertInTx() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 20; i11++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        TestCase.assertEquals((long) arrayList.size(), this.dao.count());
    }

    public void testInsertOrReplaceInTx() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < 20; i11++) {
            Object createEntityWithRandomPk = createEntityWithRandomPk();
            if (i11 % 2 == 0) {
                arrayList.add(createEntityWithRandomPk);
            }
            arrayList2.add(createEntityWithRandomPk);
        }
        this.dao.insertOrReplaceInTx(arrayList);
        this.dao.insertOrReplaceInTx(arrayList2);
        TestCase.assertEquals((long) arrayList2.size(), this.dao.count());
    }

    public void testInsertOrReplaceTwice() {
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        long insert = this.dao.insert(createEntityWithRandomPk);
        long insertOrReplace = this.dao.insertOrReplace(createEntityWithRandomPk);
        if (this.dao.getPkProperty().type == Long.class) {
            TestCase.assertEquals(insert, insertOrReplace);
        }
    }

    public void testInsertTwice() {
        Object createEntity = createEntity(nextPk());
        this.dao.insert(createEntity);
        try {
            this.dao.insert(createEntity);
            TestCase.fail("Inserting twice should not work");
        } catch (SQLException unused) {
        }
    }

    public void testLoadAll() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 15; i11++) {
            arrayList.add(createEntity(nextPk()));
        }
        this.dao.insertInTx(arrayList);
        TestCase.assertEquals(arrayList.size(), this.dao.loadAll().size());
    }

    public void testLoadPk() {
        runLoadPkTest(0);
    }

    public void testLoadPkWithOffset() {
        runLoadPkTest(10);
    }

    public void testQuery() {
        this.dao.insert(createEntityWithRandomPk());
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        this.dao.insert(createEntityWithRandomPk());
        List queryRaw = this.dao.queryRaw("WHERE " + this.dao.getPkColumns()[0] + "=?", nextPk.toString());
        TestCase.assertEquals(1, queryRaw.size());
        TestCase.assertEquals(nextPk, (Object) this.daoAccess.getKey(queryRaw.get(0)));
    }

    public void testReadWithOffset() {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(5, "42", nextPk);
        try {
            TestCase.assertEquals(nextPk, (Object) this.daoAccess.getKey(this.daoAccess.readEntity(queryWithDummyColumnsInFront, 5)));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    public void testRowId() {
        TestCase.assertTrue(this.dao.insert(createEntityWithRandomPk()) != this.dao.insert(createEntityWithRandomPk()));
    }

    public void testSave() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            Object createEntity = createEntity((Object) null);
            if (createEntity != null) {
                this.dao.save(createEntity);
                this.dao.save(createEntity);
                TestCase.assertEquals(1, this.dao.count());
            }
        }
    }

    public void testSaveInTx() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < 20; i11++) {
                Object createEntity = createEntity((Object) null);
                if (i11 % 2 == 0) {
                    arrayList.add(createEntity);
                }
                arrayList2.add(createEntity);
            }
            this.dao.saveInTx(arrayList);
            this.dao.saveInTx(arrayList2);
            TestCase.assertEquals((long) arrayList2.size(), this.dao.count());
        }
    }

    public void testUpdate() {
        this.dao.deleteAll();
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        this.dao.insert(createEntityWithRandomPk);
        this.dao.update(createEntityWithRandomPk);
        TestCase.assertEquals(1, this.dao.count());
    }
}
