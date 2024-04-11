import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;
import java.security.*;
import java.util.*;
public class MD5Mac{
    public static void main(String[] args)throws Exception{
         Scanner sc= new Scanner(System.in);
         System.out.print("Enter message:");
         String msg=sc.next();
         System.out.print("Enter secretkey:");
         String sk=sc.next();
         Key key=new SecretKeySpec(sk.getBytes(),"HmacMD5");
         MessageDigest md = MessageDigest.getInstance("MD5");
         Mac mac= Mac.getInstance("HmacMD5");
         mac.init(key);
         byte[] MDmac= mac.doFinal(msg.getBytes());
         System.out.println("Original msg:"+msg);
         System.out.println("Generated mac is:"+Base64.getEncoder().encodeToString(MDmac));
    }
}
