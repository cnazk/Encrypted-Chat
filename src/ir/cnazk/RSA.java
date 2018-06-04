package ir.cnazk;

import java.math.BigInteger;
import java.util.Random;

class RSA {

    private long p, q, k, phi;
    PublicKey publicKey;
    PrivateKey privateKey;
    private static Random random;

    private RSA() {
        random = new Random();
        publicKey = new PublicKey();
        privateKey = new PrivateKey();
    }

    static RSA generate() {
        RSA key = new RSA();
        key.p = BigInteger.probablePrime(8, new Random()).longValue();
        while (key.p < 2)
            key.p = BigInteger.probablePrime(8, new Random()).longValue();
        key.q = BigInteger.probablePrime(8, new Random()).longValue();
        while (key.q == key.p || key.q < 2)
            key.q = BigInteger.probablePrime(8, new Random()).longValue();
        key.publicKey.n = key.p * key.q;
        key.privateKey.n = key.publicKey.n;
        key.phi = (key.p - 1) * (key.q - 1);
        key.publicKey.e = random.nextInt(20);
        while (key.publicKey.e < 2)
            key.publicKey.e = random.nextInt(20);
        while (key.publicKey.n % key.publicKey.e == 0 || gcb(key.publicKey.e, key.phi) != 1)
            key.publicKey.e++;
        for (int i = 1; i < 100; i++) {
            if ((i * key.phi + 1) % key.publicKey.e == 0) {
                key.k = i;
                break;
            }
        }
        key.privateKey.d = (key.k * key.phi + 1) / key.publicKey.e;
        return key;
    }

    private static long gcb(long a, long b) {
        long temp;
        while (true)
        {
            temp = a % b;
            if (temp == 0)
                return b;
            a = b;
            b = temp;
        }
    }

//    private long prime(int n) {
//        for (;;n++){
//            boolean flag = true;
//            for (long i = n - 1; i > (int) Math.sqrt(n) - 1; i--)
//                if (n % i == 0) {
//                    flag = false;
//                    break;
//                }
//            if (flag)
//                return n;
//        }
//    }

}
