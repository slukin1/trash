package org.greenrobot.greendao.query;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.WhereCondition;

class WhereCollector<T> {
    private final AbstractDao<T, ?> dao;
    private final String tablePrefix;
    private final List<WhereCondition> whereConditions = new ArrayList();

    public WhereCollector(AbstractDao<T, ?> abstractDao, String str) {
        this.dao = abstractDao;
        this.tablePrefix = str;
    }

    public void add(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        checkCondition(whereCondition);
        this.whereConditions.add(whereCondition);
        for (WhereCondition whereCondition2 : whereConditionArr) {
            checkCondition(whereCondition2);
            this.whereConditions.add(whereCondition2);
        }
    }

    public void addCondition(StringBuilder sb2, List<Object> list, WhereCondition whereCondition) {
        checkCondition(whereCondition);
        whereCondition.appendTo(sb2, this.tablePrefix);
        whereCondition.appendValuesTo(list);
    }

    public void appendWhereClause(StringBuilder sb2, String str, List<Object> list) {
        ListIterator<WhereCondition> listIterator = this.whereConditions.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb2.append(" AND ");
            }
            WhereCondition next = listIterator.next();
            next.appendTo(sb2, str);
            next.appendValuesTo(list);
        }
    }

    public void checkCondition(WhereCondition whereCondition) {
        if (whereCondition instanceof WhereCondition.PropertyCondition) {
            checkProperty(((WhereCondition.PropertyCondition) whereCondition).property);
        }
    }

    public void checkProperty(Property property) {
        AbstractDao<T, ?> abstractDao = this.dao;
        if (abstractDao != null) {
            Property[] properties = abstractDao.getProperties();
            int length = properties.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (property == properties[i11]) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                throw new DaoException("Property '" + property.name + "' is not part of " + this.dao);
            }
        }
    }

    public WhereCondition combineWhereConditions(String str, WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        StringBuilder sb2 = new StringBuilder("(");
        ArrayList arrayList = new ArrayList();
        addCondition(sb2, arrayList, whereCondition);
        sb2.append(str);
        addCondition(sb2, arrayList, whereCondition2);
        for (WhereCondition addCondition : whereConditionArr) {
            sb2.append(str);
            addCondition(sb2, arrayList, addCondition);
        }
        sb2.append(')');
        return new WhereCondition.StringCondition(sb2.toString(), arrayList.toArray());
    }

    public boolean isEmpty() {
        return this.whereConditions.isEmpty();
    }
}
