package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import n3.b;
import o3.d;

public interface e {

    public interface a {
        void b(b bVar, Object obj, d<?> dVar, DataSource dataSource, b bVar2);

        void c(b bVar, Exception exc, d<?> dVar, DataSource dataSource);

        void f();
    }

    boolean a();

    void cancel();
}
