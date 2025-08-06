package com.hbg.module.monitor.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.x;

@Keep
public final class MonitorConfigModel {
    @SerializedName("cpu")
    private final CpuConfigModel cpu;
    @SerializedName("engine")
    private final EngineConfigModel engine;
    @SerializedName("netWork")
    private final NetWorkConfigModel netWork;
    @SerializedName("ram")
    private final RamConfigModel ram;

    public MonitorConfigModel(CpuConfigModel cpuConfigModel, EngineConfigModel engineConfigModel, NetWorkConfigModel netWorkConfigModel, RamConfigModel ramConfigModel) {
        this.cpu = cpuConfigModel;
        this.engine = engineConfigModel;
        this.netWork = netWorkConfigModel;
        this.ram = ramConfigModel;
    }

    public static /* synthetic */ MonitorConfigModel copy$default(MonitorConfigModel monitorConfigModel, CpuConfigModel cpuConfigModel, EngineConfigModel engineConfigModel, NetWorkConfigModel netWorkConfigModel, RamConfigModel ramConfigModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cpuConfigModel = monitorConfigModel.cpu;
        }
        if ((i11 & 2) != 0) {
            engineConfigModel = monitorConfigModel.engine;
        }
        if ((i11 & 4) != 0) {
            netWorkConfigModel = monitorConfigModel.netWork;
        }
        if ((i11 & 8) != 0) {
            ramConfigModel = monitorConfigModel.ram;
        }
        return monitorConfigModel.copy(cpuConfigModel, engineConfigModel, netWorkConfigModel, ramConfigModel);
    }

    public final CpuConfigModel component1() {
        return this.cpu;
    }

    public final EngineConfigModel component2() {
        return this.engine;
    }

    public final NetWorkConfigModel component3() {
        return this.netWork;
    }

    public final RamConfigModel component4() {
        return this.ram;
    }

    public final MonitorConfigModel copy(CpuConfigModel cpuConfigModel, EngineConfigModel engineConfigModel, NetWorkConfigModel netWorkConfigModel, RamConfigModel ramConfigModel) {
        return new MonitorConfigModel(cpuConfigModel, engineConfigModel, netWorkConfigModel, ramConfigModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonitorConfigModel)) {
            return false;
        }
        MonitorConfigModel monitorConfigModel = (MonitorConfigModel) obj;
        return x.b(this.cpu, monitorConfigModel.cpu) && x.b(this.engine, monitorConfigModel.engine) && x.b(this.netWork, monitorConfigModel.netWork) && x.b(this.ram, monitorConfigModel.ram);
    }

    public final CpuConfigModel getCpu() {
        return this.cpu;
    }

    public final EngineConfigModel getEngine() {
        return this.engine;
    }

    public final NetWorkConfigModel getNetWork() {
        return this.netWork;
    }

    public final RamConfigModel getRam() {
        return this.ram;
    }

    public int hashCode() {
        CpuConfigModel cpuConfigModel = this.cpu;
        int i11 = 0;
        int hashCode = (cpuConfigModel == null ? 0 : cpuConfigModel.hashCode()) * 31;
        EngineConfigModel engineConfigModel = this.engine;
        int hashCode2 = (hashCode + (engineConfigModel == null ? 0 : engineConfigModel.hashCode())) * 31;
        NetWorkConfigModel netWorkConfigModel = this.netWork;
        int hashCode3 = (hashCode2 + (netWorkConfigModel == null ? 0 : netWorkConfigModel.hashCode())) * 31;
        RamConfigModel ramConfigModel = this.ram;
        if (ramConfigModel != null) {
            i11 = ramConfigModel.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "MonitorConfigModel(cpu=" + this.cpu + ", engine=" + this.engine + ", netWork=" + this.netWork + ", ram=" + this.ram + ')';
    }
}
