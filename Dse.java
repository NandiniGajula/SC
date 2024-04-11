import javax.crypto.*;
import java.security.*;
import java.util.*;
public class Dse{
    public static void main(String [] args) throws Exception{
        KeyPair kp=KeyPairGenerator.getInstance("RSA").generateKeyPair();
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter msg:");
        String msg=sc.next();
        Signature signer= Signature.getInstance("SHA256withRSA");
           signer.initSign(kp.getPrivate());
           signer.update(msg.getBytes());
          byte[] signa=signer.sign();
         System.out.println("Digital Signature:"+Base64.getEncoder().encodeToString(signa));
         Signature veri= Signature.getInstance("SHA256withRSA");
           veri.initVerify(kp.getPublic());
           veri.update(msg.getBytes());
           boolean isVerified =veri.verify(signa);
         System.out.println("Signature verified:"+isVerified);
   }
}        
 