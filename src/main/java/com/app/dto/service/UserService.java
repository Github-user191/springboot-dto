package com.app.dto.service;

import com.app.dto.dto.UserLocationDTO;
import com.app.dto.model.User;
import com.app.dto.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserLocationDTO> getAllUsersLocations() {

        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // INEFFICIENT FOR MULTIPLE CONVERSIONS
//    private UserLocationDTO convertEntityToDto(User user) {
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//
//        return userLocationDTO;
//
//    }

    private UserLocationDTO convertEntityToDto(User user) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = new UserLocationDTO();

        userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
        return userLocationDTO;

    }
//
//    private User convertDtoToEntity(UserLocationDTO dto) {
//
//    }
}
