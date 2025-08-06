package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class Bucket implements Serializable {
    private static final long serialVersionUID = -8646831898339939580L;
    private Date creationDate = null;
    private String name = null;
    private Owner owner = null;

    public Bucket() {
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getName() {
        return this.name;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwner(Owner owner2) {
        this.owner = owner2;
    }

    public String toString() {
        return "S3Bucket [name=" + getName() + ", creationDate=" + getCreationDate() + ", owner=" + getOwner() + "]";
    }

    public Bucket(String str) {
        this.name = str;
    }
}
