package covid.project.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("input: ");
        String encodedPassword = encoder.encode(scan.next());
        System.out.println(encodedPassword);
    }

}

