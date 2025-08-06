package com.tencent.thumbplayer.tcmedia.utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class m extends ReentrantReadWriteLock {

    /* renamed from: a  reason: collision with root package name */
    private Condition f49719a = writeLock().newCondition();
}
