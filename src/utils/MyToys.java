/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hoang Phuc
 */
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.printf(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n;
        if (upperBound < lowerBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        while (true) {
            try {
                System.out.printf(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                } else {
                    return n;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.printf(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        double n;
        if (upperBound < lowerBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        while (true) {
            try {
                System.out.printf(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                } else {
                    return n;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.printf(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);

            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else if (match) {
                return id;
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.printf(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static void main(String[] args) {
        String id = getID("Input ID(DXXXXX): ", "Your input must be under "
                + "the format of DXXXXX, X stands for a digit", "[D|d]\\d{5}$");
    }

    public static String updateString(String oldString, String msg) {
        String result = oldString;

        do {
            try {
                System.out.printf(msg);
                result = sc.nextLine();
                if (!result.isEmpty()) {
                    return result;
                }
            } catch (Exception e) {
                System.out.printf("Input new String: ");
            }
        } while (true);

    }

    public static int updateInt(int oldValue, String msg) {
        boolean check = true;
        int result = oldValue;
        try {
            do {
                System.out.printf(msg);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } while (check);
        } catch (Exception e) {
            System.out.printf("Input number: ");
        }
        return result;
    }

    public static String normalizeDateStr(String dateStr) {
        String result = dateStr.replaceAll("[\\s]+", "");
        result = result.replaceAll("[\\.\\-/]+", "-");
        return result;
    }

    public static Date parseDate(String inputStr, String dateFormat) {
        inputStr = normalizeDateStr(inputStr);
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        try {
            return formatter.parse(inputStr);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Date readDate(String promt, String dateFormat) {
        String input;
        Date d;
        do {
            System.out.print(promt + ": ");
            input = sc.nextLine().trim();
            d = parseDate(input, dateFormat);
            if (d == null) {
                System.out.println("Data is not valid!");
            }
        } while (d != null);
        return d;
    }

    public static String getDateFormat(String inputMsg, String errorMsg, String format) {
        String id;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); // Strict parsing
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                try {
                    sdf.parse(id);
                    return id;
                } catch (Exception e) {
                    System.out.println("Invalid format!!!");
                }
            }
        }
    }
}
