package ru.kirilushkin.housemanaging.enums;

import ru.kirilushkin.housemanaging.exception.UserTypeNotFoundException;

public enum UserType {
    OWNER("owner"),
    MANAGER("manager");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static UserType getByType(String type) {
        for (UserType userType : UserType.values()) {
            if (userType.getType().equals(type)) {
                return userType;
            }
        }

        throw new UserTypeNotFoundException("UserType not found: " + type);
    }
}
