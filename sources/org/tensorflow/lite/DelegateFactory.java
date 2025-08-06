package org.tensorflow.lite;

public interface DelegateFactory {
    Delegate create(RuntimeFlavor runtimeFlavor);
}
