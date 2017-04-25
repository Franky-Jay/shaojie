package com.mashen.demo1.domain;

import java.io.Serializable;
import java.util.Date;

public class DemoVO implements Serializable {
    private Integer testid;

    private String testname;

    private String testsex;

    private Date ctime;

    private Date lastmodifytime;

    private String creatorDepartmentId;

    private String creatorUserId;

    private static final long serialVersionUID = 1L;

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }

    public String getTestsex() {
        return testsex;
    }

    public void setTestsex(String testsex) {
        this.testsex = testsex == null ? null : testsex.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getCreatorDepartmentId() {
        return creatorDepartmentId;
    }

    public void setCreatorDepartmentId(String creatorDepartmentId) {
        this.creatorDepartmentId = creatorDepartmentId == null ? null : creatorDepartmentId.trim();
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId == null ? null : creatorUserId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testid=").append(testid);
        sb.append(", testname=").append(testname);
        sb.append(", testsex=").append(testsex);
        sb.append(", ctime=").append(ctime);
        sb.append(", lastmodifytime=").append(lastmodifytime);
        sb.append(", creatorDepartmentId=").append(creatorDepartmentId);
        sb.append(", creatorUserId=").append(creatorUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DemoVO other = (DemoVO) that;
        return (this.getTestid() == null ? other.getTestid() == null : this.getTestid().equals(other.getTestid()))
            && (this.getTestname() == null ? other.getTestname() == null : this.getTestname().equals(other.getTestname()))
            && (this.getTestsex() == null ? other.getTestsex() == null : this.getTestsex().equals(other.getTestsex()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getLastmodifytime() == null ? other.getLastmodifytime() == null : this.getLastmodifytime().equals(other.getLastmodifytime()))
            && (this.getCreatorDepartmentId() == null ? other.getCreatorDepartmentId() == null : this.getCreatorDepartmentId().equals(other.getCreatorDepartmentId()))
            && (this.getCreatorUserId() == null ? other.getCreatorUserId() == null : this.getCreatorUserId().equals(other.getCreatorUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTestid() == null) ? 0 : getTestid().hashCode());
        result = prime * result + ((getTestname() == null) ? 0 : getTestname().hashCode());
        result = prime * result + ((getTestsex() == null) ? 0 : getTestsex().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getLastmodifytime() == null) ? 0 : getLastmodifytime().hashCode());
        result = prime * result + ((getCreatorDepartmentId() == null) ? 0 : getCreatorDepartmentId().hashCode());
        result = prime * result + ((getCreatorUserId() == null) ? 0 : getCreatorUserId().hashCode());
        return result;
    }
}