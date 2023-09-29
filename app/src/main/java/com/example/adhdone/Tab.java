package com.example.adhdone;

public class Tab {
    private int tabId;
    private String tabName;
    private int position;

    public Tab(int tabId, String tabName, int position) {
        this.tabId = tabId;
        this.tabName = tabName;
        this.position = position;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Tab{" +
                "tabId=" + tabId +
                ", tabName='" + tabName + '\'' +
                ", position=" + position +
                '}';
    }
}
