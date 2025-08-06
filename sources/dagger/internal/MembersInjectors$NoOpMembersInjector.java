package dagger.internal;

import oz.a;

enum MembersInjectors$NoOpMembersInjector implements a<Object> {
    INSTANCE;

    public void injectMembers(Object obj) {
        d.c(obj, "Cannot inject members into a null reference");
    }
}
