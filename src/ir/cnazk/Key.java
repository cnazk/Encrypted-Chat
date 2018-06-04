package ir.cnazk;

public class Key {
    public long n;

    protected long powAndMod(long base, long exp, long modulus) {
        base %= modulus;
        long result = 1;
        while (exp > 0) {
            if (exp % 2 != 0) result = (result * base) % modulus;
            if (result < 0)
                System.out.println("RID");
            base = (base * base) % modulus;
            exp >>= 1;
        }
        return result;
    }

    private long test(long sub, long sup, long mod) {
        while (sup > 1) {
            if (sub >= mod)
                sub %= mod;
            sub *= sub;
            if (sub < 0)
                System.out.println("asd");
            sup--;
        }
        return sub % mod;
    }

}
