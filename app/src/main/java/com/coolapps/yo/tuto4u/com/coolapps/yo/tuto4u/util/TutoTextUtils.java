package com.coolapps.yo.tuto4u.com.coolapps.yo.tuto4u.util;

public class TutoTextUtils {

    public static boolean isNonEmpty(String input) {
        return input != null && input.trim().length() != 0;
    }

    public static boolean isNonEmpty(CharSequence input) {
        return input != null && input.toString().trim().length() != 0;
    }
}
