import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

/**
 * Coded With Love by Amdadul Bari Imad
 * Created at 29/7/18
 */
public class RSAEncryptor {
    public KeyPair getKeyPair(int size){
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(size);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyPairGenerator.genKeyPair();
    }

    public String encrypt(PublicKey pubKey,String plainText){
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            String encryptedText = new String(Base64.getEncoder().encode(encryptedBytes));
            return encryptedText;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(PrivateKey privateKey,String encryptedText){
        try{
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            return decryptedText;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
