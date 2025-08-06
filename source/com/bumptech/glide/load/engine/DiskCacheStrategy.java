package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DiskCacheStrategy f63709a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final DiskCacheStrategy f63710b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final DiskCacheStrategy f63711c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final DiskCacheStrategy f63712d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final DiskCacheStrategy f63713e = new e();

    public class a extends DiskCacheStrategy {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean d(boolean z11, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    public class b extends DiskCacheStrategy {
        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean c(DataSource dataSource) {
            return false;
        }

        public boolean d(boolean z11, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    public class c extends DiskCacheStrategy {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean d(boolean z11, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    public class d extends DiskCacheStrategy {
        public boolean a() {
            return false;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return false;
        }

        public boolean d(boolean z11, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    public class e extends DiskCacheStrategy {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean d(boolean z11, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z11 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z11, DataSource dataSource, EncodeStrategy encodeStrategy);
}
