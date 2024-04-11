import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.*;
public class Shaex{
    public static void main(String [] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter message:");
        String msg=sc.next();
        System.out.print("Enter secretkey:");
        String sk=sc.next();
        Key key=new SecretKeySpec(sk.getBytes(),"HmacSHA256");
        Mac mac=Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] hmac=mac.doFinal(msg.getBytes());
        System.out.println("Original message:"+msg);
        System.out.println("Generated Hmac is:"+Base64.getEncoder().encodeToString(hmac));
   }
}
        
