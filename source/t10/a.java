package t10;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public interface a extends FileFilter, FilenameFilter {
    boolean accept(File file);

    boolean accept(File file, String str);
}
