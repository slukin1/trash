package com.zendesk.service;

import lz.a;

public abstract class ZendeskCallback<T> {
    public abstract void onError(a aVar);

    public abstract void onSuccess(T t11);
}
