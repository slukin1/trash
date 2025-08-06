package org.tensorflow.lite.acceleration;

import org.tensorflow.lite.InterpreterApi;

public interface ValidatedAccelerationConfig {
    void apply(InterpreterApi.Options options);

    byte[] serialize();
}
