package com.jeesite.modules.sz.entity;

public class SzRoadLampLoginEntity {
    private String user;
    private String password;
    private boolean remember;
    private String langKey;
    private boolean pkeyMode;
    private String pkey;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public boolean isPkeyMode() {
        return pkeyMode;
    }

    public void setPkeyMode(boolean pkeyMode) {
        this.pkeyMode = pkeyMode;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }
}
