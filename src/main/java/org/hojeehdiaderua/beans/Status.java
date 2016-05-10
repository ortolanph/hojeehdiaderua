package org.hojeehdiaderua.beans;

public enum Status {
    INFO("info"),
    SUCCESS("success"),
    WARNING("warning"),
    ERROR("error");

    private String style;

    Status(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
