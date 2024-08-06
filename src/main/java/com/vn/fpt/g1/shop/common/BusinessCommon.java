package com.vn.fpt.g1.shop.common;

import com.vn.fpt.g1.shop.exception.RestExceptionHandler;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class BusinessCommon {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX = "^(\\(\\d{3}\\)|\\d{3})[-\\s]?\\d{3}[-\\s]?\\d{4}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_-]{3,20}$";
    private static final String POSITIVE_NUMBER_REGEX = "^(?:0|[1-9]\\d*)(?:\\.\\d+)?$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";


    private static final Random RD = new Random();
    private static final String A2Z = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String FONT_VN = "UTF-8";

    /** codau. */
    private static final char[] VIET_CHARS = { 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ',
            'ẩ', 'ẫ', 'ậ', 'À', 'Á', 'Ả', 'Ã', 'Ạ', 'Ă', 'Ằ', 'Ắ', 'Ẳ', 'Ẵ', 'Ặ', 'Â', 'Ầ', 'Ấ', 'Ẩ', 'Ẫ', 'Ậ', 'è',
            'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'È', 'É', 'Ẻ', 'Ẽ', 'Ẹ', 'Ê', 'Ề', 'Ế', 'Ể', 'Ễ', 'Ệ',
            'ì', 'í', 'ỉ', 'ĩ', 'ị', 'Ì', 'Í', 'Ỉ', 'Ĩ', 'Ị', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ',
            'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ', 'Ò', 'Ó', 'Ỏ', 'Õ', 'Ọ', 'Ô', 'Ồ', 'Ố', 'Ổ', 'Ỗ', 'Ộ', 'Ơ', 'Ờ', 'Ớ', 'Ở',
            'Ỡ', 'Ợ', 'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'Ù', 'Ú', 'Ủ', 'Ũ', 'Ụ', 'ỳ', 'ý', 'ỷ',
            'ỹ', 'ỵ', 'Ỳ', 'Ý', 'Ỷ', 'Ỹ', 'Ỵ', 'đ', 'Đ', 'Ư', 'Ừ', 'Ử', 'Ữ', 'Ứ', 'Ự' };

    /** khongdau. */
    private static final char[] NORMAL_CHARS = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
            'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'e',
            'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
            'i', 'i', 'i', 'i', 'i', 'I', 'I', 'I', 'I', 'I', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
            'o', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
            'O', 'O', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'U', 'U', 'U', 'U', 'U', 'y', 'y', 'y',
            'y', 'y', 'Y', 'Y', 'Y', 'Y', 'Y', 'd', 'D', 'U', 'U', 'U', 'U', 'U', 'U' };

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final SecureRandom random = new SecureRandom();

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_REGEX, phoneNumber);
    }

    public static boolean isValidUsername(String username) {
        return Pattern.matches(USERNAME_REGEX, username);
    }

    public static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isValidPositiveNumber(String number) {
        return Pattern.matches(POSITIVE_NUMBER_REGEX, number);
    }

    public static boolean isValidPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    public static boolean isNullOrEmpty(final String s, boolean trim) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        return trim && s.trim().isEmpty();
    }

    public static boolean isNullOrEmpty(final String s) {
        return isNullOrEmpty(s, true);
    }

    public static void validLengthData(String str, String column, int max) {
        if (!isNullOrEmpty(str) && str.length() > max) {
            throw new RestExceptionHandler(column + " chỉ tối đa " + max + " kí tự.");
        }
    }

    public static String randomPassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(A2Z.charAt(RD.nextInt(A2Z.length())));
        }
        return sb.toString();
    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date convertLocalDateToDate(final LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }

    public static String convertDateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String cutAllSpace(String st) {
        if (!isNullOrEmpty(st)) {
            return st.replaceAll("\\s", "");
        }
        return null;
    }

    private static String genRandomStr(String input, int size) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("Invalid input.");
        if (size < 1)
            throw new IllegalArgumentException("Invalid size.");

        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            // produce a random order
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }

    public static <T> void require(String field, T value) {
        if (value == null || isNullOrEmpty(value.toString()))
            throw new RestExceptionHandler(field + " bắt buộc phải nhập");
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // type = 1 : get first / type = 2: get last
    public static Long convert(String str, int type) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] arr = str.split("-");
        for (String element : arr) {
            if (!isNumeric(element)) {
                return null;
            }
        }
        if (type == 1 && arr.length >= 1) {
            return Long.parseLong(arr[0]);
        }
        if (type == 2 && arr.length >= 2) {
            return Long.parseLong(arr[1]);
        }
        return null;
    }

}
