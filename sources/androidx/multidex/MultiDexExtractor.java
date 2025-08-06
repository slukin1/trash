package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.huobi.finance.bean.LoanOrderItem;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class MultiDexExtractor implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final File f10198b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10199c;

    /* renamed from: d  reason: collision with root package name */
    public final File f10200d;

    /* renamed from: e  reason: collision with root package name */
    public final RandomAccessFile f10201e;

    /* renamed from: f  reason: collision with root package name */
    public final FileChannel f10202f;

    /* renamed from: g  reason: collision with root package name */
    public final FileLock f10203g;

    public static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    public class a implements FileFilter {
        public a() {
        }

        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f10198b = file;
        this.f10200d = file2;
        this.f10199c = j(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f10201e = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f10202f = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f10203g = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e11) {
                e = e11;
                b(this.f10202f);
                throw e;
            } catch (RuntimeException e12) {
                e = e12;
                b(this.f10202f);
                throw e;
            } catch (Error e13) {
                e = e13;
                b(this.f10202f);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e14) {
            b(this.f10201e);
            throw e14;
        }
    }

    public static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e11) {
            Log.w("MultiDex", "Failed to close resource", e11);
        }
    }

    public static void e(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    b(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th2) {
            b(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    public static SharedPreferences f(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static long g(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static long j(File file) throws IOException {
        long c11 = b.c(file);
        return c11 == -1 ? c11 - 1 : c11;
    }

    public static boolean k(Context context, File file, long j11, String str) {
        SharedPreferences f11 = f(context);
        if (f11.getLong(str + "timestamp", -1) == g(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("crc");
            return f11.getLong(sb2.toString(), -1) != j11;
        }
    }

    public static void o(Context context, String str, long j11, long j12, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = f(context).edit();
        edit.putLong(str + "timestamp", j11);
        edit.putLong(str + "crc", j12);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i11 = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + "dex.crc." + i11, next.crc);
            edit.putLong(str + "dex.time." + i11, next.lastModified());
            i11++;
        }
        edit.commit();
    }

    public final void a() {
        File[] listFiles = this.f10200d.listFiles(new a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f10200d.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    public void close() throws IOException {
        this.f10203g.release();
        this.f10202f.close();
        this.f10201e.close();
    }

    public List<? extends File> l(Context context, String str, boolean z11) throws IOException {
        List<ExtractedDex> list;
        List<ExtractedDex> list2;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f10198b.getPath() + ", " + z11 + ", " + str + ")");
        if (this.f10203g.isValid()) {
            if (z11 || k(context, this.f10198b, this.f10199c, str)) {
                if (z11) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                list2 = n();
                o(context, str, g(this.f10198b), this.f10199c, list2);
            } else {
                try {
                    list = m(context, str);
                } catch (IOException e11) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e11);
                    list2 = n();
                    o(context, str, g(this.f10198b), this.f10199c, list2);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            list = list2;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public final List<ExtractedDex> m(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.f10198b.getName() + ".classes";
        SharedPreferences f11 = f(context);
        int i11 = f11.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i11 + -1);
        int i12 = 2;
        while (i12 <= i11) {
            ExtractedDex extractedDex = new ExtractedDex(this.f10200d, str3 + i12 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.crc = j(extractedDex);
                long j11 = f11.getLong(str2 + "dex.crc." + i12, -1);
                long j12 = f11.getLong(str2 + "dex.time." + i12, -1);
                long lastModified = extractedDex.lastModified();
                if (j12 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = f11;
                    if (j11 == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i12++;
                        f11 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j12 + ", modification time: " + lastModified + ", expected crc: " + j11 + ", file crc: " + extractedDex.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    public final List<ExtractedDex> n() throws IOException {
        ExtractedDex extractedDex;
        boolean z11;
        String str = this.f10198b.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f10198b);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i11 = 2;
            while (entry != null) {
                extractedDex = new ExtractedDex(this.f10200d, str + i11 + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                int i12 = 0;
                boolean z12 = false;
                while (i12 < 3 && !z12) {
                    int i13 = i12 + 1;
                    e(zipFile, entry, extractedDex, str);
                    extractedDex.crc = j(extractedDex);
                    z11 = true;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Extraction ");
                    sb2.append(z11 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : LoanOrderItem.FAILED);
                    sb2.append(" '");
                    sb2.append(extractedDex.getAbsolutePath());
                    sb2.append("': length ");
                    int i14 = i13;
                    sb2.append(extractedDex.length());
                    sb2.append(" - crc: ");
                    sb2.append(extractedDex.crc);
                    Log.i("MultiDex", sb2.toString());
                    if (!z11) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z12 = z11;
                    i12 = i14;
                }
                if (z12) {
                    i11++;
                    entry = zipFile.getEntry("classes" + i11 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i11 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e11) {
                Log.w("MultiDex", "Failed to close resource", e11);
            }
            return arrayList;
        } catch (IOException e12) {
            Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e12);
            z11 = false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            try {
                zipFile.close();
            } catch (IOException e13) {
                Log.w("MultiDex", "Failed to close resource", e13);
            }
            throw th3;
        }
    }
}
