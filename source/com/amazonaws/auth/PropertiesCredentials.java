package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCredentials implements AWSCredentials {

    /* renamed from: a  reason: collision with root package name */
    public final String f14851a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14852b;

    public PropertiesCredentials(File file) throws IOException {
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                    throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
                }
                this.f14851a = properties.getProperty("accessKey");
                this.f14852b = properties.getProperty("secretKey");
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
        }
    }

    public String a() {
        return this.f14851a;
    }

    public String b() {
        return this.f14852b;
    }

    public PropertiesCredentials(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
            this.f14851a = properties.getProperty("accessKey");
            this.f14852b = properties.getProperty("secretKey");
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
