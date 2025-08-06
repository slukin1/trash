package org.apache.commons.io.monitor;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.NameFileComparator;
import u10.a;

public class FileAlterationObserver implements Serializable {
    private static final long serialVersionUID = 1185122225658782848L;
    private final Comparator<File> comparator;
    private final FileFilter fileFilter;
    private final List<a> listeners;
    private final FileEntry rootEntry;

    public FileAlterationObserver(String str) {
        this(new File(str));
    }

    private FileEntry createFileEntry(FileEntry fileEntry, File file) {
        FileEntry newChildInstance = fileEntry.newChildInstance(file);
        newChildInstance.refresh(file);
        newChildInstance.setChildren(doListFiles(file, newChildInstance));
        return newChildInstance;
    }

    private void doCreate(FileEntry fileEntry) {
        for (a next : this.listeners) {
            if (fileEntry.isDirectory()) {
                next.c(fileEntry.getFile());
            } else {
                next.a(fileEntry.getFile());
            }
        }
        for (FileEntry doCreate : fileEntry.getChildren()) {
            doCreate(doCreate);
        }
    }

    private void doDelete(FileEntry fileEntry) {
        for (a next : this.listeners) {
            if (fileEntry.isDirectory()) {
                next.g(fileEntry.getFile());
            } else {
                next.e(fileEntry.getFile());
            }
        }
    }

    private FileEntry[] doListFiles(File file, FileEntry fileEntry) {
        File[] listFiles = listFiles(file);
        FileEntry[] fileEntryArr = listFiles.length > 0 ? new FileEntry[listFiles.length] : FileEntry.EMPTY_ENTRIES;
        for (int i11 = 0; i11 < listFiles.length; i11++) {
            fileEntryArr[i11] = createFileEntry(fileEntry, listFiles[i11]);
        }
        return fileEntryArr;
    }

    private void doMatch(FileEntry fileEntry, File file) {
        if (fileEntry.refresh(file)) {
            for (a next : this.listeners) {
                if (fileEntry.isDirectory()) {
                    next.b(file);
                } else {
                    next.f(file);
                }
            }
        }
    }

    private File[] listFiles(File file) {
        File[] fileArr;
        if (file.isDirectory()) {
            FileFilter fileFilter2 = this.fileFilter;
            fileArr = fileFilter2 == null ? file.listFiles() : file.listFiles(fileFilter2);
        } else {
            fileArr = null;
        }
        if (fileArr == null) {
            fileArr = FileUtils.f58936i;
        }
        Comparator<File> comparator2 = this.comparator;
        if (comparator2 != null && fileArr.length > 1) {
            Arrays.sort(fileArr, comparator2);
        }
        return fileArr;
    }

    public void addListener(a aVar) {
        if (aVar != null) {
            this.listeners.add(aVar);
        }
    }

    public void checkAndNotify() {
        for (a d11 : this.listeners) {
            d11.d(this);
        }
        File file = this.rootEntry.getFile();
        if (file.exists()) {
            FileEntry fileEntry = this.rootEntry;
            checkAndNotify(fileEntry, fileEntry.getChildren(), listFiles(file));
        } else if (this.rootEntry.isExists()) {
            FileEntry fileEntry2 = this.rootEntry;
            checkAndNotify(fileEntry2, fileEntry2.getChildren(), FileUtils.f58936i);
        }
        for (a h11 : this.listeners) {
            h11.h(this);
        }
    }

    public void destroy() throws Exception {
    }

    public File getDirectory() {
        return this.rootEntry.getFile();
    }

    public FileFilter getFileFilter() {
        return this.fileFilter;
    }

    public Iterable<a> getListeners() {
        return this.listeners;
    }

    public void initialize() throws Exception {
        FileEntry fileEntry = this.rootEntry;
        fileEntry.refresh(fileEntry.getFile());
        this.rootEntry.setChildren(doListFiles(this.rootEntry.getFile(), this.rootEntry));
    }

    public void removeListener(a aVar) {
        if (aVar != null) {
            do {
            } while (this.listeners.remove(aVar));
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("[file='");
        sb2.append(getDirectory().getPath());
        sb2.append('\'');
        if (this.fileFilter != null) {
            sb2.append(", ");
            sb2.append(this.fileFilter.toString());
        }
        sb2.append(", listeners=");
        sb2.append(this.listeners.size());
        sb2.append("]");
        return sb2.toString();
    }

    public FileAlterationObserver(String str, FileFilter fileFilter2) {
        this(new File(str), fileFilter2);
    }

    public FileAlterationObserver(String str, FileFilter fileFilter2, IOCase iOCase) {
        this(new File(str), fileFilter2, iOCase);
    }

    public FileAlterationObserver(File file) {
        this(file, (FileFilter) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter2) {
        this(file, fileFilter2, (IOCase) null);
    }

    public FileAlterationObserver(File file, FileFilter fileFilter2, IOCase iOCase) {
        this(new FileEntry(file), fileFilter2, iOCase);
    }

    public FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter2, IOCase iOCase) {
        this.listeners = new CopyOnWriteArrayList();
        if (fileEntry == null) {
            throw new IllegalArgumentException("Root entry is missing");
        } else if (fileEntry.getFile() != null) {
            this.rootEntry = fileEntry;
            this.fileFilter = fileFilter2;
            if (iOCase == null || iOCase.equals(IOCase.SYSTEM)) {
                this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
            } else if (iOCase.equals(IOCase.INSENSITIVE)) {
                this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
            } else {
                this.comparator = NameFileComparator.NAME_COMPARATOR;
            }
        } else {
            throw new IllegalArgumentException("Root directory is missing");
        }
    }

    private void checkAndNotify(FileEntry fileEntry, FileEntry[] fileEntryArr, File[] fileArr) {
        FileEntry[] fileEntryArr2 = fileArr.length > 0 ? new FileEntry[fileArr.length] : FileEntry.EMPTY_ENTRIES;
        int length = fileEntryArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            FileEntry fileEntry2 = fileEntryArr[i12];
            while (i11 < fileArr.length && this.comparator.compare(fileEntry2.getFile(), fileArr[i11]) > 0) {
                fileEntryArr2[i11] = createFileEntry(fileEntry, fileArr[i11]);
                doCreate(fileEntryArr2[i11]);
                i11++;
            }
            if (i11 >= fileArr.length || this.comparator.compare(fileEntry2.getFile(), fileArr[i11]) != 0) {
                checkAndNotify(fileEntry2, fileEntry2.getChildren(), FileUtils.f58936i);
                doDelete(fileEntry2);
            } else {
                doMatch(fileEntry2, fileArr[i11]);
                checkAndNotify(fileEntry2, fileEntry2.getChildren(), listFiles(fileArr[i11]));
                fileEntryArr2[i11] = fileEntry2;
                i11++;
            }
        }
        while (i11 < fileArr.length) {
            fileEntryArr2[i11] = createFileEntry(fileEntry, fileArr[i11]);
            doCreate(fileEntryArr2[i11]);
            i11++;
        }
        fileEntry.setChildren(fileEntryArr2);
    }
}
