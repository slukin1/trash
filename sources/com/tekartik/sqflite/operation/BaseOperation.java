package com.tekartik.sqflite.operation;

import yy.e;

public abstract class BaseOperation extends BaseReadOperation {
    public void error(String str, String str2, Object obj) {
        i().error(str, str2, obj);
    }

    public abstract e i();

    public void success(Object obj) {
        i().success(obj);
    }
}
