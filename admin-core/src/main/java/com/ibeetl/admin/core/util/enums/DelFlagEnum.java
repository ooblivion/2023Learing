package com.ibeetl.admin.core.util.enums;

import org.beetl.sql.annotation.entity.EnumValue;

/**
 * 描述:数据是否被逻辑删除
 * @author : xiandafu
 */
public enum DelFlagEnum {
    NORMAL(0), DELETED(1);

    @EnumValue
    private int value;

    DelFlagEnum(int value) {
        this.value = value;
    }

    public static DelFlagEnum getEnum(int value) {
        for (DelFlagEnum type : DelFlagEnum.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
