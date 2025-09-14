import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Trial {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("password"));
        System.out.println(bCryptPasswordEncoder.encode("password"));
    }
}
