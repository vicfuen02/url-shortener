package es.vicfuen.url_shortening_service.service.urlHashing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class UrlHashingServiceImpl implements UrlHashingService {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LENGTH_HASH = 7;

    @Override
    public String urlHashing(String url) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(url.getBytes(StandardCharsets.UTF_8));

            BigInteger value = new BigInteger(1, hashBytes);
            String encoded = encodeBase62(value);

            return encoded.substring(0, Math.min(encoded.length(), LENGTH_HASH));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to find SHA-256 algorithm", e);
        }
    }

    private String encodeBase62(BigInteger value) {
        StringBuilder sb = new StringBuilder();
        BigInteger sixtyTwo = BigInteger.valueOf(62);

        while (value.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] quotientAndRemainder = value.divideAndRemainder(sixtyTwo);
            sb.append(BASE62.charAt(quotientAndRemainder[1].intValue()));
            value = quotientAndRemainder[0];
        }

        return sb.reverse().toString();
    }

}
