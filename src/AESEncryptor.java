import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Coded With Love by Amdadul Bari Imad
 * Created at 29/7/18
 */
public class AESEncryptor {
    public  String doDecryption(String key, String iv, String text) {
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivSpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
            String decryptedText = new String(decryptedBytes);
            System.out.println(decryptedText);
            return decryptedText;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String doEncryption(String key, String iv, String text) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivSpec);

            byte[] encryptedBytes = cipher.doFinal(text.getBytes());
            String encryptedText = new String(Base64.getEncoder().encode(encryptedBytes));

            return encryptedText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
