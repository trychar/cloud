import com.web.cloud.PaymentApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(classes = PaymentApplication.class)
public class MyTest {
    @Test
    public void testSubStr() {
        String v = "CN=郭志强,T=142327198911306613,OU=06,L=00,L=00,ST=12,O=NHSA,C=CN";
        String v = "CN=郭志强,OU=06,L=00,L=00,ST=12,O=NHSA,C=CN";
//        System.out.println(v.indexOf("T="));
        System.out.println(v.substring(v.indexOf("T=")+2,v.indexOf("T=")+2+18));
    }
}
