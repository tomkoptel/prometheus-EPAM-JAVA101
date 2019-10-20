package com.uzhnu.epam.course.week6;

public class RLEApplicationDecode {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println();
        } else {
            String firstArg = args[0];
            if (firstArg == null || firstArg.length() == 0) {
                System.out.println();
            } else {
                if (firstArg.length() == 1) {
                    System.out.println();
                } else {
                    String result = decode(firstArg);
                    if (result == null) {
                        System.out.println();
                    } else {
                        System.out.println(result);
                    }
                }
            }
        }
    }

    private static String decode(String firstArg) {
        char[] chars = firstArg.toCharArray();
        char tmpChar = chars[0];
        boolean containsInts = false;

        if (Character.isDigit(tmpChar)) return null;

        StringBuilder result = new StringBuilder();
        result.append(tmpChar);

        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            if (Character.isDigit(aChar)) {
                containsInts = true;

                if (i != chars.length - 1) {
                    char nextChar = chars[i + 1];
                    if (Character.isDigit(nextChar)) {
                        return null;
                    }
                }

                int count = Integer.parseInt("" + aChar);
                if (count == 0) {
                    return null;
                }
                for (int j = 1; j < count; j++) {
                    result.append(tmpChar);
                }
            } else {
                tmpChar = aChar;
                result.append(aChar);
            }
        }

        if (!containsInts) return null;
        return result.toString();
    }
}
