package org.example.manager;
public class Manager {
    private static final String xpath = "//input[@id='%s']";
    private static final String resultValue = "//span[contains(@class, 'text-success')]";
    private boolean isEnable;
    private String value;

    public static String Format_xPath(String id) {
        return String.format(xpath, id);
    }
    public static String getAttributeValue() {
        return resultValue;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}