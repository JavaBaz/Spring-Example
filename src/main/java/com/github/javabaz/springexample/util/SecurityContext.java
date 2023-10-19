package com.github.javabaz.springexample.util;

public class SecurityContext {
    public static Long id;
    public static String firstname;
    public static String lastname;
    public static String email;
    public static String role;

    public static void clear() {
        id = null;
        firstname = null;
        lastname = null;
        email = null;
        role = null;
    }
}
