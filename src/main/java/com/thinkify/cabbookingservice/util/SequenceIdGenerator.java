package com.thinkify.cabbookingservice.util;

public class SequenceIdGenerator {
    public static synchronized Long generateId(int initialValue) {
        return (long) (initialValue + 1);
    }
}
