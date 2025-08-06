package com.hbg.lib.network.php.core.bean;

import java.io.Serializable;

public class CurrencyIntro implements Serializable {
    private static final long serialVersionUID = 1645954052878579298L;
    private String ICOProgress;
    private String application;
    private String blockQuery;
    private String circulateVolume;
    private String consensusMechanism;
    private String crowdfundingPrice;
    private String financingHistory;
    private String fullName;
    private String officialWebsite;
    private String projectConsultant;
    private String projectPosition;
    private String projectProgress;
    private String projectTeam;
    private String projectType;
    private String projectValuation;
    private String publishTime;
    private String publishVolume;
    private String summary;
    private String technicalCharacteristics;
    private String whitePaper;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyIntro;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyIntro)) {
            return false;
        }
        CurrencyIntro currencyIntro = (CurrencyIntro) obj;
        if (!currencyIntro.canEqual(this)) {
            return false;
        }
        String fullName2 = getFullName();
        String fullName3 = currencyIntro.getFullName();
        if (fullName2 != null ? !fullName2.equals(fullName3) : fullName3 != null) {
            return false;
        }
        String summary2 = getSummary();
        String summary3 = currencyIntro.getSummary();
        if (summary2 != null ? !summary2.equals(summary3) : summary3 != null) {
            return false;
        }
        String publishTime2 = getPublishTime();
        String publishTime3 = currencyIntro.getPublishTime();
        if (publishTime2 != null ? !publishTime2.equals(publishTime3) : publishTime3 != null) {
            return false;
        }
        String publishVolume2 = getPublishVolume();
        String publishVolume3 = currencyIntro.getPublishVolume();
        if (publishVolume2 != null ? !publishVolume2.equals(publishVolume3) : publishVolume3 != null) {
            return false;
        }
        String circulateVolume2 = getCirculateVolume();
        String circulateVolume3 = currencyIntro.getCirculateVolume();
        if (circulateVolume2 != null ? !circulateVolume2.equals(circulateVolume3) : circulateVolume3 != null) {
            return false;
        }
        String crowdfundingPrice2 = getCrowdfundingPrice();
        String crowdfundingPrice3 = currencyIntro.getCrowdfundingPrice();
        if (crowdfundingPrice2 != null ? !crowdfundingPrice2.equals(crowdfundingPrice3) : crowdfundingPrice3 != null) {
            return false;
        }
        String projectPosition2 = getProjectPosition();
        String projectPosition3 = currencyIntro.getProjectPosition();
        if (projectPosition2 != null ? !projectPosition2.equals(projectPosition3) : projectPosition3 != null) {
            return false;
        }
        String projectProgress2 = getProjectProgress();
        String projectProgress3 = currencyIntro.getProjectProgress();
        if (projectProgress2 != null ? !projectProgress2.equals(projectProgress3) : projectProgress3 != null) {
            return false;
        }
        String technicalCharacteristics2 = getTechnicalCharacteristics();
        String technicalCharacteristics3 = currencyIntro.getTechnicalCharacteristics();
        if (technicalCharacteristics2 != null ? !technicalCharacteristics2.equals(technicalCharacteristics3) : technicalCharacteristics3 != null) {
            return false;
        }
        String projectTeam2 = getProjectTeam();
        String projectTeam3 = currencyIntro.getProjectTeam();
        if (projectTeam2 != null ? !projectTeam2.equals(projectTeam3) : projectTeam3 != null) {
            return false;
        }
        String projectConsultant2 = getProjectConsultant();
        String projectConsultant3 = currencyIntro.getProjectConsultant();
        if (projectConsultant2 != null ? !projectConsultant2.equals(projectConsultant3) : projectConsultant3 != null) {
            return false;
        }
        String iCOProgress = getICOProgress();
        String iCOProgress2 = currencyIntro.getICOProgress();
        if (iCOProgress != null ? !iCOProgress.equals(iCOProgress2) : iCOProgress2 != null) {
            return false;
        }
        String projectValuation2 = getProjectValuation();
        String projectValuation3 = currencyIntro.getProjectValuation();
        if (projectValuation2 != null ? !projectValuation2.equals(projectValuation3) : projectValuation3 != null) {
            return false;
        }
        String financingHistory2 = getFinancingHistory();
        String financingHistory3 = currencyIntro.getFinancingHistory();
        if (financingHistory2 != null ? !financingHistory2.equals(financingHistory3) : financingHistory3 != null) {
            return false;
        }
        String whitePaper2 = getWhitePaper();
        String whitePaper3 = currencyIntro.getWhitePaper();
        if (whitePaper2 != null ? !whitePaper2.equals(whitePaper3) : whitePaper3 != null) {
            return false;
        }
        String officialWebsite2 = getOfficialWebsite();
        String officialWebsite3 = currencyIntro.getOfficialWebsite();
        if (officialWebsite2 != null ? !officialWebsite2.equals(officialWebsite3) : officialWebsite3 != null) {
            return false;
        }
        String blockQuery2 = getBlockQuery();
        String blockQuery3 = currencyIntro.getBlockQuery();
        if (blockQuery2 != null ? !blockQuery2.equals(blockQuery3) : blockQuery3 != null) {
            return false;
        }
        String consensusMechanism2 = getConsensusMechanism();
        String consensusMechanism3 = currencyIntro.getConsensusMechanism();
        if (consensusMechanism2 != null ? !consensusMechanism2.equals(consensusMechanism3) : consensusMechanism3 != null) {
            return false;
        }
        String projectType2 = getProjectType();
        String projectType3 = currencyIntro.getProjectType();
        if (projectType2 != null ? !projectType2.equals(projectType3) : projectType3 != null) {
            return false;
        }
        String application2 = getApplication();
        String application3 = currencyIntro.getApplication();
        return application2 != null ? application2.equals(application3) : application3 == null;
    }

    public String getApplication() {
        return this.application;
    }

    public String getBlockQuery() {
        return this.blockQuery;
    }

    public String getCirculateVolume() {
        return this.circulateVolume;
    }

    public String getConsensusMechanism() {
        return this.consensusMechanism;
    }

    public String getCrowdfundingPrice() {
        return this.crowdfundingPrice;
    }

    public String getFinancingHistory() {
        return this.financingHistory;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getICOProgress() {
        return this.ICOProgress;
    }

    public String getOfficialWebsite() {
        return this.officialWebsite;
    }

    public String getProjectConsultant() {
        return this.projectConsultant;
    }

    public String getProjectPosition() {
        return this.projectPosition;
    }

    public String getProjectProgress() {
        return this.projectProgress;
    }

    public String getProjectTeam() {
        return this.projectTeam;
    }

    public String getProjectType() {
        return this.projectType;
    }

    public String getProjectValuation() {
        return this.projectValuation;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public String getPublishVolume() {
        return this.publishVolume;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTechnicalCharacteristics() {
        return this.technicalCharacteristics;
    }

    public String getWhitePaper() {
        return this.whitePaper;
    }

    public int hashCode() {
        String fullName2 = getFullName();
        int i11 = 43;
        int hashCode = fullName2 == null ? 43 : fullName2.hashCode();
        String summary2 = getSummary();
        int hashCode2 = ((hashCode + 59) * 59) + (summary2 == null ? 43 : summary2.hashCode());
        String publishTime2 = getPublishTime();
        int hashCode3 = (hashCode2 * 59) + (publishTime2 == null ? 43 : publishTime2.hashCode());
        String publishVolume2 = getPublishVolume();
        int hashCode4 = (hashCode3 * 59) + (publishVolume2 == null ? 43 : publishVolume2.hashCode());
        String circulateVolume2 = getCirculateVolume();
        int hashCode5 = (hashCode4 * 59) + (circulateVolume2 == null ? 43 : circulateVolume2.hashCode());
        String crowdfundingPrice2 = getCrowdfundingPrice();
        int hashCode6 = (hashCode5 * 59) + (crowdfundingPrice2 == null ? 43 : crowdfundingPrice2.hashCode());
        String projectPosition2 = getProjectPosition();
        int hashCode7 = (hashCode6 * 59) + (projectPosition2 == null ? 43 : projectPosition2.hashCode());
        String projectProgress2 = getProjectProgress();
        int hashCode8 = (hashCode7 * 59) + (projectProgress2 == null ? 43 : projectProgress2.hashCode());
        String technicalCharacteristics2 = getTechnicalCharacteristics();
        int hashCode9 = (hashCode8 * 59) + (technicalCharacteristics2 == null ? 43 : technicalCharacteristics2.hashCode());
        String projectTeam2 = getProjectTeam();
        int hashCode10 = (hashCode9 * 59) + (projectTeam2 == null ? 43 : projectTeam2.hashCode());
        String projectConsultant2 = getProjectConsultant();
        int hashCode11 = (hashCode10 * 59) + (projectConsultant2 == null ? 43 : projectConsultant2.hashCode());
        String iCOProgress = getICOProgress();
        int hashCode12 = (hashCode11 * 59) + (iCOProgress == null ? 43 : iCOProgress.hashCode());
        String projectValuation2 = getProjectValuation();
        int hashCode13 = (hashCode12 * 59) + (projectValuation2 == null ? 43 : projectValuation2.hashCode());
        String financingHistory2 = getFinancingHistory();
        int hashCode14 = (hashCode13 * 59) + (financingHistory2 == null ? 43 : financingHistory2.hashCode());
        String whitePaper2 = getWhitePaper();
        int hashCode15 = (hashCode14 * 59) + (whitePaper2 == null ? 43 : whitePaper2.hashCode());
        String officialWebsite2 = getOfficialWebsite();
        int hashCode16 = (hashCode15 * 59) + (officialWebsite2 == null ? 43 : officialWebsite2.hashCode());
        String blockQuery2 = getBlockQuery();
        int hashCode17 = (hashCode16 * 59) + (blockQuery2 == null ? 43 : blockQuery2.hashCode());
        String consensusMechanism2 = getConsensusMechanism();
        int hashCode18 = (hashCode17 * 59) + (consensusMechanism2 == null ? 43 : consensusMechanism2.hashCode());
        String projectType2 = getProjectType();
        int hashCode19 = (hashCode18 * 59) + (projectType2 == null ? 43 : projectType2.hashCode());
        String application2 = getApplication();
        int i12 = hashCode19 * 59;
        if (application2 != null) {
            i11 = application2.hashCode();
        }
        return i12 + i11;
    }

    public void setApplication(String str) {
        this.application = str;
    }

    public void setBlockQuery(String str) {
        this.blockQuery = str;
    }

    public void setCirculateVolume(String str) {
        this.circulateVolume = str;
    }

    public void setConsensusMechanism(String str) {
        this.consensusMechanism = str;
    }

    public void setCrowdfundingPrice(String str) {
        this.crowdfundingPrice = str;
    }

    public void setFinancingHistory(String str) {
        this.financingHistory = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setICOProgress(String str) {
        this.ICOProgress = str;
    }

    public void setOfficialWebsite(String str) {
        this.officialWebsite = str;
    }

    public void setProjectConsultant(String str) {
        this.projectConsultant = str;
    }

    public void setProjectPosition(String str) {
        this.projectPosition = str;
    }

    public void setProjectProgress(String str) {
        this.projectProgress = str;
    }

    public void setProjectTeam(String str) {
        this.projectTeam = str;
    }

    public void setProjectType(String str) {
        this.projectType = str;
    }

    public void setProjectValuation(String str) {
        this.projectValuation = str;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public void setPublishVolume(String str) {
        this.publishVolume = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTechnicalCharacteristics(String str) {
        this.technicalCharacteristics = str;
    }

    public void setWhitePaper(String str) {
        this.whitePaper = str;
    }

    public String toString() {
        return "CurrencyIntro(fullName=" + getFullName() + ", summary=" + getSummary() + ", publishTime=" + getPublishTime() + ", publishVolume=" + getPublishVolume() + ", circulateVolume=" + getCirculateVolume() + ", crowdfundingPrice=" + getCrowdfundingPrice() + ", projectPosition=" + getProjectPosition() + ", projectProgress=" + getProjectProgress() + ", technicalCharacteristics=" + getTechnicalCharacteristics() + ", projectTeam=" + getProjectTeam() + ", projectConsultant=" + getProjectConsultant() + ", ICOProgress=" + getICOProgress() + ", projectValuation=" + getProjectValuation() + ", financingHistory=" + getFinancingHistory() + ", whitePaper=" + getWhitePaper() + ", officialWebsite=" + getOfficialWebsite() + ", blockQuery=" + getBlockQuery() + ", consensusMechanism=" + getConsensusMechanism() + ", projectType=" + getProjectType() + ", application=" + getApplication() + ")";
    }
}
