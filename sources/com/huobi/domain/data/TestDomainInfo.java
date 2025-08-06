package com.huobi.domain.data;

import java.io.Serializable;
import java.util.Objects;

public class TestDomainInfo implements Serializable {
    public String host;
    public boolean isTestOk;
    public long testTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.host.equals(((TestDomainInfo) obj).host);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.host});
    }

    public String toString() {
        return "TestDomainInfo{host='" + this.host + '\'' + ", testTime=" + this.testTime + ", isTestOk=" + this.isTestOk + '}';
    }
}
