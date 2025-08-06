package com.hbg.lib.common.dynamic.downloader;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
public class DyanmicConfig {
    public List<Color> colors;
    public List<JsonConfig> configs;
    public List<EdgeEdnge> edgeEdnges;
    public List<I18n> i18n;
    public List<Image> images;
    public List<OfflinePackage> offlinePackages;
    public String version = "";

    @Keep
    public static class Color extends DynamicBaseBean {
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Color{isEnable='");
            sb2.append(isEnable());
            sb2.append('\'');
            sb2.append(isEnable() ? "" : "补丁不可用  ");
            sb2.append("sourcePath='");
            sb2.append(this.sourcePath);
            sb2.append('\'');
            sb2.append(", destPath='");
            sb2.append(this.destPath);
            sb2.append('\'');
            sb2.append(", md5='");
            sb2.append(this.md5);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static class DynamicBaseBean {
        public List<String> dependents = new ArrayList();
        public String destPath;
        public boolean enable = true;
        public String md5;
        public String sourcePath;

        public boolean isEnable() {
            return this.enable && !TextUtils.isEmpty(this.md5) && !TextUtils.isEmpty(this.sourcePath) && !TextUtils.isEmpty(this.destPath);
        }
    }

    @Keep
    public static class EdgeEdnge extends DynamicBaseBean {
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("EdgeEdnges{isEnable='");
            sb2.append(isEnable());
            sb2.append('\'');
            sb2.append(isEnable() ? "" : "补丁不可用  ");
            sb2.append("sourcePath='");
            sb2.append(this.sourcePath);
            sb2.append('\'');
            sb2.append(", destPath='");
            sb2.append(this.destPath);
            sb2.append('\'');
            sb2.append(", md5='");
            sb2.append(this.md5);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    @Keep
    public static class I18n extends DynamicBaseBean {
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("I18n{isEnable='");
            sb2.append(isEnable());
            sb2.append('\'');
            sb2.append(isEnable() ? "" : "补丁不可用  ");
            sb2.append("md5='");
            sb2.append(this.md5);
            sb2.append('\'');
            sb2.append(", sourcePath='");
            sb2.append(this.sourcePath);
            sb2.append('\'');
            sb2.append(", destPath='");
            sb2.append(this.destPath);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    @Keep
    public static class Image extends DynamicBaseBean {
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Image{isEnable='");
            sb2.append(isEnable());
            sb2.append('\'');
            sb2.append(isEnable() ? "" : "补丁不可用  ");
            sb2.append("sourcePath='");
            sb2.append(this.sourcePath);
            sb2.append('\'');
            sb2.append(", destPath='");
            sb2.append(this.destPath);
            sb2.append('\'');
            sb2.append(", md5='");
            sb2.append(this.md5);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    @Keep
    public static class JsonConfig extends DynamicBaseBean {
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JsonConfig{isEnable='");
            sb2.append(isEnable());
            sb2.append('\'');
            sb2.append(isEnable() ? "" : "补丁不可用  ");
            sb2.append("md5='");
            sb2.append(this.md5);
            sb2.append('\'');
            sb2.append(", sourcePath='");
            sb2.append(this.sourcePath);
            sb2.append('\'');
            sb2.append(", destPath='");
            sb2.append(this.destPath);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    @Keep
    public static class OfflinePackage extends DynamicBaseBean {
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OfflinePackage{isEnable='");
            sb2.append(isEnable());
            sb2.append('\'');
            sb2.append(isEnable() ? "" : "补丁不可用  ");
            sb2.append("md5='");
            sb2.append(this.md5);
            sb2.append('\'');
            sb2.append(", sourcePath='");
            sb2.append(this.sourcePath);
            sb2.append('\'');
            sb2.append(", destPath='");
            sb2.append(this.destPath);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    public String toString() {
        return "DyanmicConfig{\tedgeEdnges=" + this.edgeEdnges + "\t, i18n=" + this.i18n + "\t, colors=" + this.colors + "\t, images=" + this.images + "\t, configs=" + this.configs + "\t, offlinePackages=" + this.offlinePackages + '}';
    }
}
