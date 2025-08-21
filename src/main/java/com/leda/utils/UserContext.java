package com.leda.utils;

public class UserContext {
    private static final ThreadLocal<Long> currentUserId = new ThreadLocal<>();
    private static final ThreadLocal<String> currentOpenId = new ThreadLocal<>();

    public static Long getCurrentUserId() {
        return currentUserId.get();
    }

    public static void setCurrentUserId(Long userId) {
        currentUserId.set(userId);
    }

    public static String getCurrentOpenId() {
        return currentOpenId.get();
    }

    public static void setCurrentOpenId(String openId) {
        currentOpenId.set(openId);
    }

    public static void clear() {
        currentUserId.remove();
        currentOpenId.remove();
    }
}
