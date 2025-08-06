package org.junit.runner;

import org.junit.runner.notification.RunNotifier;

public abstract class Runner implements a {
    public abstract void b(RunNotifier runNotifier);

    public abstract Description getDescription();
}
