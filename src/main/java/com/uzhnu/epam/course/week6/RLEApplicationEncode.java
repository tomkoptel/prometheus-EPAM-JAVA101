package com.uzhnu.epam.course.week6;

public class RLEApplicationEncode {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println();
        } else {
            String firstArg = args[0];
            if (firstArg == null || firstArg.length() == 0) {
                System.out.println();
            } else {
                doRLE(firstArg);
            }
        }
    }

    private static void doRLE(String firstArg) {
        char[] chars = firstArg.toCharArray();
        if (chars.length == 1) {
            System.out.println(firstArg);
        } else  {
            char tmpChar = chars[0];
            int tmpCount = 1;

            StringBuilder result = new StringBuilder();

            for (int i = 1; i < chars.length; i++) {
                char aChar = chars[i];

                if (i == chars.length - 1) {
                    if (tmpChar == aChar) {
                        if (tmpCount < 9) {
                            tmpCount++;
                        }
                        result.append(tmpChar);
                        if (tmpCount > 1) {
                            result.append(tmpCount);
                        }
                    } else {
                        result.append(tmpChar);
                        if (tmpCount > 1) {
                            result.append(tmpCount);
                        }
                        result.append(aChar);
                    }
                } else {
                    if (tmpChar == aChar) {
                        if (tmpCount == 9) {
                            result.append(tmpChar);
                            result.append(tmpCount);

                            tmpChar = aChar;
                            tmpCount = 1;
                        } else {
                            tmpCount++;
                        }
                    } else {
                        result.append(tmpChar);
                        if (tmpCount > 1) {
                            result.append(tmpCount);
                        }

                        tmpChar = aChar;
                        tmpCount = 1;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
