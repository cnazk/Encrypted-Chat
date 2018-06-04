package ir.cnazk;

import java.util.ArrayList;

public class PrivateKey extends Key {
    public long d;

    public String decrypt(ArrayList<Long> message) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.size(); i++) {
            builder.append((char) decrypt(message.get(i).longValue()));
        }
        return builder.toString();
    }

    private long decrypt(long c) {
        long a = powAndMod(c, d, n);
        return a;
    }

}
