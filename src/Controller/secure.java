package Controller;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class secure{
    public String plainText;
    private final String key = "ClinicManagement"; // Should be 16 bytes
    public String cipherText;
    private final String iv = "1234567890123456"; // 16-byte IV for AES

    // public static void main(String[] args) {
    //     Security security = new Security();
    //     security.plainText = "Hello";
    //     try {
    //         security.encrypt();
    //         System.out.println("Encrypted: " + security.cipherText);
    //         security.decrypt();
    //         System.out.println("Decrypted: " + security.plainText);
    //     } catch (Exception e) {
    //         System.err.println("Error: " + e.getMessage());
    //     }
    // }

    public void encrypt() throws Exception {
        try {
            byte[] keyBytes = key.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
            cipherText = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new Exception("Encryption error: " + e.getMessage());
        }
    }

    public void decrypt() throws Exception {
        try {
            byte[] keyBytes = key.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

            byte[] encryptedBytes = Base64.getDecoder().decode(cipherText);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            plainText = new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            throw new Exception("Decryption error: " + e.getMessage());
        }
    }
}
