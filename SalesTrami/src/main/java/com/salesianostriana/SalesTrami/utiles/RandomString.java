package com.salesianostriana.SalesTrami.utiles;

import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;


public class RandomString {

    /**
     * Generate a random string.
     */

    public static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String lower = upper.toLowerCase(Locale.ROOT);

    public static String digits = "0123456789";

    public static String alphanum = upper + lower + digits;
    private static char[] buf;

    private static Random random;

    private static char[] symbols;

    public RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    public RandomString(int length, Random random) {
        this(length, random, alphanum);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    public RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Create session identifiers.
     */
    public RandomString() {
        this(21);
    }

    public static String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

}
