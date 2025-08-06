package com.huobi.home.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class HomepageConfig implements Serializable {
    @SerializedName("modules")
    public ConcurrentHashMap<String, Module> modules;
    @SerializedName("structure")
    public Structure structure;

    public class Module implements Serializable {
        @SerializedName("isNeedAssets")
        public String isNeedAssets;
        @SerializedName("isNeedLogin")
        public String isNeedLogin;
        @SerializedName("params")
        public Params params;
        @SerializedName("type")
        public String type;
        @SerializedName("version")
        public List<Long> version;

        public Module() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Module;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Module)) {
                return false;
            }
            Module module = (Module) obj;
            if (!module.canEqual(this)) {
                return false;
            }
            String isNeedAssets2 = getIsNeedAssets();
            String isNeedAssets3 = module.getIsNeedAssets();
            if (isNeedAssets2 != null ? !isNeedAssets2.equals(isNeedAssets3) : isNeedAssets3 != null) {
                return false;
            }
            String isNeedLogin2 = getIsNeedLogin();
            String isNeedLogin3 = module.getIsNeedLogin();
            if (isNeedLogin2 != null ? !isNeedLogin2.equals(isNeedLogin3) : isNeedLogin3 != null) {
                return false;
            }
            Params params2 = getParams();
            Params params3 = module.getParams();
            if (params2 != null ? !params2.equals(params3) : params3 != null) {
                return false;
            }
            String type2 = getType();
            String type3 = module.getType();
            if (type2 != null ? !type2.equals(type3) : type3 != null) {
                return false;
            }
            List<Long> version2 = getVersion();
            List<Long> version3 = module.getVersion();
            return version2 != null ? version2.equals(version3) : version3 == null;
        }

        public String getIsNeedAssets() {
            return this.isNeedAssets;
        }

        public String getIsNeedLogin() {
            return this.isNeedLogin;
        }

        public Params getParams() {
            return this.params;
        }

        public String getType() {
            return this.type;
        }

        public List<Long> getVersion() {
            return this.version;
        }

        public int hashCode() {
            String isNeedAssets2 = getIsNeedAssets();
            int i11 = 43;
            int hashCode = isNeedAssets2 == null ? 43 : isNeedAssets2.hashCode();
            String isNeedLogin2 = getIsNeedLogin();
            int hashCode2 = ((hashCode + 59) * 59) + (isNeedLogin2 == null ? 43 : isNeedLogin2.hashCode());
            Params params2 = getParams();
            int hashCode3 = (hashCode2 * 59) + (params2 == null ? 43 : params2.hashCode());
            String type2 = getType();
            int hashCode4 = (hashCode3 * 59) + (type2 == null ? 43 : type2.hashCode());
            List<Long> version2 = getVersion();
            int i12 = hashCode4 * 59;
            if (version2 != null) {
                i11 = version2.hashCode();
            }
            return i12 + i11;
        }

        public void setIsNeedAssets(String str) {
            this.isNeedAssets = str;
        }

        public void setIsNeedLogin(String str) {
            this.isNeedLogin = str;
        }

        public void setParams(Params params2) {
            this.params = params2;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVersion(List<Long> list) {
            this.version = list;
        }

        public String toString() {
            return "HomepageConfig.Module(isNeedAssets=" + getIsNeedAssets() + ", isNeedLogin=" + getIsNeedLogin() + ", params=" + getParams() + ", type=" + getType() + ", version=" + getVersion() + ")";
        }
    }

    public class Params implements Serializable {
        @SerializedName("dataKey")
        public String dataKey;
        @SerializedName("engineName")
        public String engineName;
        @SerializedName("enterView")
        public String enterView;
        @SerializedName("startEvent")
        public String startEvent;
        @SerializedName("yuguImage")
        public String yuguImage;

        public Params() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Params;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (!params.canEqual(this)) {
                return false;
            }
            String engineName2 = getEngineName();
            String engineName3 = params.getEngineName();
            if (engineName2 != null ? !engineName2.equals(engineName3) : engineName3 != null) {
                return false;
            }
            String enterView2 = getEnterView();
            String enterView3 = params.getEnterView();
            if (enterView2 != null ? !enterView2.equals(enterView3) : enterView3 != null) {
                return false;
            }
            String startEvent2 = getStartEvent();
            String startEvent3 = params.getStartEvent();
            if (startEvent2 != null ? !startEvent2.equals(startEvent3) : startEvent3 != null) {
                return false;
            }
            String yuguImage2 = getYuguImage();
            String yuguImage3 = params.getYuguImage();
            if (yuguImage2 != null ? !yuguImage2.equals(yuguImage3) : yuguImage3 != null) {
                return false;
            }
            String dataKey2 = getDataKey();
            String dataKey3 = params.getDataKey();
            return dataKey2 != null ? dataKey2.equals(dataKey3) : dataKey3 == null;
        }

        public String getDataKey() {
            return this.dataKey;
        }

        public String getEngineName() {
            return this.engineName;
        }

        public String getEnterView() {
            return this.enterView;
        }

        public String getStartEvent() {
            return this.startEvent;
        }

        public String getYuguImage() {
            return this.yuguImage;
        }

        public int hashCode() {
            String engineName2 = getEngineName();
            int i11 = 43;
            int hashCode = engineName2 == null ? 43 : engineName2.hashCode();
            String enterView2 = getEnterView();
            int hashCode2 = ((hashCode + 59) * 59) + (enterView2 == null ? 43 : enterView2.hashCode());
            String startEvent2 = getStartEvent();
            int hashCode3 = (hashCode2 * 59) + (startEvent2 == null ? 43 : startEvent2.hashCode());
            String yuguImage2 = getYuguImage();
            int hashCode4 = (hashCode3 * 59) + (yuguImage2 == null ? 43 : yuguImage2.hashCode());
            String dataKey2 = getDataKey();
            int i12 = hashCode4 * 59;
            if (dataKey2 != null) {
                i11 = dataKey2.hashCode();
            }
            return i12 + i11;
        }

        public void setDataKey(String str) {
            this.dataKey = str;
        }

        public void setEngineName(String str) {
            this.engineName = str;
        }

        public void setEnterView(String str) {
            this.enterView = str;
        }

        public void setStartEvent(String str) {
            this.startEvent = str;
        }

        public void setYuguImage(String str) {
            this.yuguImage = str;
        }

        public String toString() {
            return "HomepageConfig.Params(engineName=" + getEngineName() + ", enterView=" + getEnterView() + ", startEvent=" + getStartEvent() + ", yuguImage=" + getYuguImage() + ", dataKey=" + getDataKey() + ")";
        }
    }

    public class Structure implements Serializable {
        @SerializedName("fluent")
        public List<String> fluent;
        @SerializedName("navigation")
        public List<String> navigation;

        public Structure() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Structure;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Structure)) {
                return false;
            }
            Structure structure = (Structure) obj;
            if (!structure.canEqual(this)) {
                return false;
            }
            List<String> fluent2 = getFluent();
            List<String> fluent3 = structure.getFluent();
            if (fluent2 != null ? !fluent2.equals(fluent3) : fluent3 != null) {
                return false;
            }
            List<String> navigation2 = getNavigation();
            List<String> navigation3 = structure.getNavigation();
            return navigation2 != null ? navigation2.equals(navigation3) : navigation3 == null;
        }

        public List<String> getFluent() {
            return this.fluent;
        }

        public List<String> getNavigation() {
            return this.navigation;
        }

        public int hashCode() {
            List<String> fluent2 = getFluent();
            int i11 = 43;
            int hashCode = fluent2 == null ? 43 : fluent2.hashCode();
            List<String> navigation2 = getNavigation();
            int i12 = (hashCode + 59) * 59;
            if (navigation2 != null) {
                i11 = navigation2.hashCode();
            }
            return i12 + i11;
        }

        public void setFluent(List<String> list) {
            this.fluent = list;
        }

        public void setNavigation(List<String> list) {
            this.navigation = list;
        }

        public String toString() {
            return "HomepageConfig.Structure(fluent=" + getFluent() + ", navigation=" + getNavigation() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HomepageConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomepageConfig)) {
            return false;
        }
        HomepageConfig homepageConfig = (HomepageConfig) obj;
        if (!homepageConfig.canEqual(this)) {
            return false;
        }
        Structure structure2 = getStructure();
        Structure structure3 = homepageConfig.getStructure();
        if (structure2 != null ? !structure2.equals(structure3) : structure3 != null) {
            return false;
        }
        ConcurrentHashMap<String, Module> modules2 = getModules();
        ConcurrentHashMap<String, Module> modules3 = homepageConfig.getModules();
        return modules2 != null ? modules2.equals(modules3) : modules3 == null;
    }

    public ConcurrentHashMap<String, Module> getModules() {
        return this.modules;
    }

    public Structure getStructure() {
        return this.structure;
    }

    public int hashCode() {
        Structure structure2 = getStructure();
        int i11 = 43;
        int hashCode = structure2 == null ? 43 : structure2.hashCode();
        ConcurrentHashMap<String, Module> modules2 = getModules();
        int i12 = (hashCode + 59) * 59;
        if (modules2 != null) {
            i11 = modules2.hashCode();
        }
        return i12 + i11;
    }

    public void setModules(ConcurrentHashMap<String, Module> concurrentHashMap) {
        this.modules = concurrentHashMap;
    }

    public void setStructure(Structure structure2) {
        this.structure = structure2;
    }

    public String toString() {
        return "HomepageConfig(structure=" + getStructure() + ", modules=" + getModules() + ")";
    }
}
