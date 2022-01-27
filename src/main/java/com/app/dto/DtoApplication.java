package com.app.dto;

import com.app.dto.model.Location;
import com.app.dto.model.User;
import com.app.dto.repository.LocationRepository;
import com.app.dto.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoApplication implements CommandLineRunner {
    private UserRepository userRepository;
    private LocationRepository locationRepository;


    public DtoApplication(UserRepository userRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(DtoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Location location = new Location();
        location.setPlace("Pune");
        location.setDescription("Great place");
        location.setLongitude(24.4);
        location.setLatitude(45.5);

        locationRepository.save(location);

        User user1 = new User();
        user1.setFirstName("Ramesh");
        user1.setLastName("Ramlal");
        user1.setEmail("ramlal@gmail.com");
        user1.setLocation(location);
        user1.setPassword("password");

        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("John");
        user2.setLastName("Xina");
        user2.setEmail("john@gmail.com");
        user2.setLocation(location);
        user2.setPassword("password");

        userRepository.save(user2);
    }
}
