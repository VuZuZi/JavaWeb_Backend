package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Kiểm tra số điện thoại có chứa ít nhất 10 chữ số và bắt đầu bằng số 0
        return phoneNumber.matches("0\\d{9,10}");
    }
    public static boolean isValidPassword(String password) {
        // Kiểm tra mật khẩu có ít nhất 8 ký tự, bao gồm ít nhất một chữ cái và một chữ số
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public static void main(String[] args) {
        String phoneNumber = "0123456789";
        if (isValidPhoneNumber(phoneNumber)) {
            System.out.println("Số điện thoại hợp lệ.");
        } else {
            System.out.println("Số điện thoại không hợp lệ.");
        }
    }

}
