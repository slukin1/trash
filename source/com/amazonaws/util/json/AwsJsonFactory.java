package com.amazonaws.util.json;

import java.io.Reader;
import java.io.Writer;

public interface AwsJsonFactory {
    AwsJsonWriter a(Writer writer);

    AwsJsonReader b(Reader reader);
}
