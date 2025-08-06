package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

public class FileEntry implements Serializable {
    public static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
    private static final long serialVersionUID = -2505664948818681153L;
    private FileEntry[] children;
    private boolean directory;
    private boolean exists;
    private final File file;
    private long lastModified;
    private long length;
    private String name;
    private final FileEntry parent;

    public FileEntry(File file2) {
        this((FileEntry) null, file2);
    }

    public FileEntry[] getChildren() {
        FileEntry[] fileEntryArr = this.children;
        return fileEntryArr != null ? fileEntryArr : EMPTY_ENTRIES;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public long getLength() {
        return this.length;
    }

    public int getLevel() {
        FileEntry fileEntry = this.parent;
        if (fileEntry == null) {
            return 0;
        }
        return fileEntry.getLevel() + 1;
    }

    public String getName() {
        return this.name;
    }

    public FileEntry getParent() {
        return this.parent;
    }

    public boolean isDirectory() {
        return this.directory;
    }

    public boolean isExists() {
        return this.exists;
    }

    public FileEntry newChildInstance(File file2) {
        return new FileEntry(this, file2);
    }

    public boolean refresh(File file2) {
        boolean z11 = this.exists;
        long j11 = this.lastModified;
        boolean z12 = this.directory;
        long j12 = this.length;
        this.name = file2.getName();
        boolean exists2 = file2.exists();
        this.exists = exists2;
        this.directory = exists2 && file2.isDirectory();
        long j13 = 0;
        this.lastModified = this.exists ? file2.lastModified() : 0;
        if (this.exists && !this.directory) {
            j13 = file2.length();
        }
        this.length = j13;
        if (this.exists == z11 && this.lastModified == j11 && this.directory == z12 && j13 == j12) {
            return false;
        }
        return true;
    }

    public void setChildren(FileEntry[] fileEntryArr) {
        this.children = fileEntryArr;
    }

    public void setDirectory(boolean z11) {
        this.directory = z11;
    }

    public void setExists(boolean z11) {
        this.exists = z11;
    }

    public void setLastModified(long j11) {
        this.lastModified = j11;
    }

    public void setLength(long j11) {
        this.length = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public FileEntry(FileEntry fileEntry, File file2) {
        if (file2 != null) {
            this.file = file2;
            this.parent = fileEntry;
            this.name = file2.getName();
            return;
        }
        throw new IllegalArgumentException("File is missing");
    }
}
