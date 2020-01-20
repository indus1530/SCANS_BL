package edu.aku.hassannaqvi.uen_midline.otherClasses;

/**
 * Created by Ali on 04-Feb-17.
 */

public class familyMembers {
    String memberName;
    String cStatus;
    String DSSid;
    String dob;

    public familyMembers(String memberName, String DSSid, String cStatus, String dob) {
        this.memberName = memberName;
        this.cStatus = cStatus;
        this.DSSid = DSSid;
        this.dob = dob;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {

        this.cStatus = cStatus;
    }

    public String getDSSid() {
        return DSSid;
    }

    public void setDSSid(String DSSid) {
        this.DSSid = DSSid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


}
