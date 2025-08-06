package com.amazonaws.services.s3;

import com.amazonaws.ResponseMetadata;
import java.util.Map;

public class S3ResponseMetadata extends ResponseMetadata {
    public S3ResponseMetadata(Map<String, String> map) {
        super(map);
    }
}
