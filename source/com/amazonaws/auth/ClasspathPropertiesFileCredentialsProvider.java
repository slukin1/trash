package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {

    /* renamed from: b  reason: collision with root package name */
    public static String f14843b = "AwsCredentials.properties";

    /* renamed from: a  reason: collision with root package name */
    public final String f14844a;

    public ClasspathPropertiesFileCredentialsProvider() {
        this(f14843b);
    }

    public AWSCredentials a() {
        InputStream resourceAsStream = getClass().getResourceAsStream(this.f14844a);
        if (resourceAsStream != null) {
            try {
                return new PropertiesCredentials(resourceAsStream);
            } catch (IOException e11) {
                throw new AmazonClientException("Unable to load AWS credentials from the " + this.f14844a + " file on the classpath", e11);
            }
        } else {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.f14844a + " file on the classpath");
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f14844a + ")";
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Credentials file path cannot be null");
        } else if (!str.startsWith("/")) {
            this.f14844a = "/" + str;
        } else {
            this.f14844a = str;
        }
    }
}
