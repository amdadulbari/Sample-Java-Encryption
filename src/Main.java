import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
       // AES
        AESEncryptor aesEncryptor = new AESEncryptor();
        String encryptedText = aesEncryptor.doEncryption("123HelloWorld123","345HelloWorld345","Hello World");
        String decryptedText = aesEncryptor.doDecryption("123HelloWorld123","345HelloWorld345","jSX0Y7kjYxcFU77I2ClOaA==");
        System.out.println("Encrypted Text = "+encryptedText);
        System.out.println("Decrypted Text = "+decryptedText);


        //RSA
        RSAEncryptor rsaEncryptor = new RSAEncryptor();
        KeyPair keyPair = rsaEncryptor.getKeyPair(2048);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String rsaEncryptedText = rsaEncryptor.encrypt(publicKey,"Hello World");
        System.out.println("RSA Encrypted Text = "+rsaEncryptedText);

        String rsaDecryptedText = rsaEncryptor.decrypt(privateKey,rsaEncryptedText);
        System.out.println("RSA Decrypted Text = "+rsaDecryptedText);

    }
}
