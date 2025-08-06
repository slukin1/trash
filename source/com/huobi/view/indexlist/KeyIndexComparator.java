package com.huobi.view.indexlist;

import com.huobi.view.indexlist.IndexPartEntity;
import java.util.Comparator;

public class KeyIndexComparator<T extends IndexPartEntity> implements Comparator<EntityWrapper<T>> {
    public int compare(EntityWrapper<T> entityWrapper, EntityWrapper<T> entityWrapper2) {
        String indexByField = entityWrapper.getIndexByField();
        String indexByField2 = entityWrapper2.getIndexByField();
        if (indexByField == null) {
            indexByField = "";
        }
        if (indexByField2 == null) {
            indexByField2 = "";
        }
        return indexByField.compareTo(indexByField2);
    }
}
