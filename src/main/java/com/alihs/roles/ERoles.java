package com.alihs.roles;

public enum ERoles {
    ADMIN(1, "admin"), WRITER(2, "writer"), USER(3, "user");

    private final Integer key;

    private final String value;

    private ERoles(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer getKey() {
        return key;
    }
}
