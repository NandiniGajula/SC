import javax.crypto.*;
import java.util.Base64;
import java.util.Scanner;
public class DESDemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        SecretKey key = generateDESKey();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted text (Base64): " + encryptedBase64);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted text: " + decryptedText);
    }
    private static SecretKey generateDESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        return keyGen.generateKey();
    }
}

