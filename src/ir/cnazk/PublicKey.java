package ir.cnazk;

import java.util.ArrayList;

public class PublicKey extends Key {
    public long e;

    public ArrayList<Long> encrypt(String message) {
        StringBuilder builder = new StringBuilder();

        ArrayList<Long> encrypted = new ArrayList<>();

        for (int i = 0; i < message.length(); i++) {
            encrypted.add(encrypt(message.charAt(i)));
//            builder.append((char) encrypt(message.charAt(i)));
        }
        return encrypted;
//        return builder.toString();
    }

    private long encrypt(long c) {
        return powAndMod(c, e, n);
    }

}
