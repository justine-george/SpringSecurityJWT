package com.jgeorge.springsecurityjwtdemo;

import com.jgeorge.springsecurityjwtdemo.entity.Role;
import com.jgeorge.springsecurityjwtdemo.entity.User;
import com.jgeorge.springsecurityjwtdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityJwtDemoApplication implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
  }

  public void run(String... args) {
    User adminAccount = userRepository.findByRole(Role.ADMIN);

    if (adminAccount == null) {
      User admin = new User();
      admin.setFirstName("Admin First Name");
      admin.setLastName("Admin Last Name");
      admin.setEmail("admin@test.com");
      admin.setRole(Role.ADMIN);
      admin.setPassword(new BCryptPasswordEncoder().encode("adminpassword"));

      userRepository.save(admin);
    }
  }
}
