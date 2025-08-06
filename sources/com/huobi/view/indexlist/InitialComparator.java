package com.huobi.view.indexlist;

import com.huobi.view.indexlist.IndexPartEntity;
import java.util.Comparator;

public class InitialComparator<T extends IndexPartEntity> implements Comparator<EntityWrapper<T>> {
    public int compare(EntityWrapper<T> entityWrapper, EntityWrapper<T> entityWrapper2) {
        return entityWrapper.getIndex().compareTo(entityWrapper2.getIndex());
    }
}
