package com.amazonaws.services.s3.model;

import java.util.List;

public class CORSRule {

    /* renamed from: a  reason: collision with root package name */
    public String f15206a;

    /* renamed from: b  reason: collision with root package name */
    public List<AllowedMethods> f15207b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f15208c;

    /* renamed from: d  reason: collision with root package name */
    public int f15209d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f15210e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f15211f;

    public enum AllowedMethods {
        GET("GET"),
        PUT("PUT"),
        HEAD("HEAD"),
        POST("POST"),
        DELETE("DELETE");
        
        private final String AllowedMethod;

        private AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String allowedMethods2 = allowedMethods.toString();
                if (allowedMethods2 == null && str == null) {
                    return allowedMethods;
                }
                if (allowedMethods2 != null && allowedMethods2.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        public String toString() {
            return this.AllowedMethod;
        }
    }

    public void a(List<String> list) {
        this.f15211f = list;
    }

    public void b(List<AllowedMethods> list) {
        this.f15207b = list;
    }

    public void c(List<String> list) {
        this.f15208c = list;
    }

    public void d(List<String> list) {
        this.f15210e = list;
    }

    public void e(String str) {
        this.f15206a = str;
    }

    public void f(int i11) {
        this.f15209d = i11;
    }
}
