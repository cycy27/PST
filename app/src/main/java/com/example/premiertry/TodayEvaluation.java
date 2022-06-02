package com.example.premiertry;

public class TodayEvaluation {
    private int userID;
    private String dateTime;
    private int painLevel=-1;
    private boolean headAche =false;
    private boolean outOfBreath =false;
    private boolean stiff =false;
    private boolean chestPain =false;
    private boolean faint =false;
    private boolean cough =false;
    private String other;

    public TodayEvaluation(){}
    public TodayEvaluation(int userID, String dateTime,int painLevel, boolean headAche, boolean outOfBreath, boolean stiff, boolean chestPain, boolean faint, boolean cough, String other) {
        this.userID=userID;
        this.dateTime=dateTime;
        this.painLevel = painLevel;
        this.headAche = headAche;
        this.outOfBreath = outOfBreath;
        this.stiff = stiff;
        this.chestPain = chestPain;
        this.faint = faint;
        this.cough = cough;
        this.other = other;
    }

    @Override
    public String toString() {
        return "TodayEvaluation{" +
                "userID=" + userID +
                ", dateTime='" + dateTime + '\'' +
                ", painLevel=" + painLevel +
                ", headAche=" + headAche +
                ", outOfBreath=" + outOfBreath +
                ", stiff=" + stiff +
                ", chestPain=" + chestPain +
                ", faint=" + faint +
                ", cough=" + cough +
                ", other='" + other + '\'' +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }

    public boolean isHeadAche() {
        return headAche;
    }

    public void setHeadAche(boolean headAche) {
        this.headAche = headAche;
    }

    public boolean isOutOfBreath() {
        return outOfBreath;
    }

    public void setOutOfBreath(boolean outOfBreath) {
        this.outOfBreath = outOfBreath;
    }

    public boolean isStiff() {
        return stiff;
    }

    public void setStiff(boolean stiff) {
        this.stiff = stiff;
    }

    public boolean isChestPain() {
        return chestPain;
    }

    public void setChestPain(boolean chestPain) {
        this.chestPain = chestPain;
    }

    public boolean isFaint() {
        return faint;
    }

    public void setFaint(boolean faint) {
        this.faint = faint;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
