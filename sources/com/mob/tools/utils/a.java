package com.mob.tools.utils;

import com.mob.tools.utils.ExecutorDispatcher;

public interface a {
    <T extends ExecutorDispatcher.SafeRunnable> void executeDelayed(T t11, long j11);

    <T extends ExecutorDispatcher.SafeRunnable> void executeDuctile(T t11);

    <T extends ExecutorDispatcher.SafeRunnable> void executeImmediately(T t11);

    <T extends ExecutorDispatcher.SafeRunnable> void executeSerial(T t11);
}
