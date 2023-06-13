package com.example231.crud.mapper;

import com.example231.crud.dto.CoordsDTO;
import com.example231.crud.dto.UserDTO;
import com.example231.crud.model.Avatar;
import com.example231.crud.model.Role;
import com.example231.crud.model.User;
import com.example231.crud.repositories.RoleRepository;
import com.example231.crud.service.ApiService;
import com.example231.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserMapper {
    private RoleRepository roleRepository;
    private UserService userService;

    private ApiService apiService;

    @Autowired
    public UserMapper(RoleRepository roleRepository, UserService userService, ApiService apiService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.apiService = apiService;
    }

    public User map(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getUsername(), userDto.getLastname(), userDto.getAge(),
                userDto.getEmail(), userDto.getPassword(), getUserRoles(userDto),
                getAvatar(userDto), getDaDataResponse(userDto));
    }

    public UserDTO map(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getLastname(), user.getAge(), user.getEmail(),
                user.getPassword(), getListRole(user), getUrlAvatar(user), user.getPostalAddress());
    }

    public User editMapUser(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getUsername(), userDto.getLastname(), userDto.getAge(),
                userDto.getEmail(), userDto.getPassword(), getUserRoles(userDto),
                getAvatar(userDto), userDto.getPostalAddress());
    }

    public List<UserDTO> mapList(List<User> users) {
        List<UserDTO> dtoList = new ArrayList<>();
        users.forEach(user -> {
            dtoList.add(map(user));
        });
        return dtoList;
    }

    private Set<Role> getUserRoles(UserDTO userDto) {
        Set<Role> roleSet = new HashSet<>();
        if (userDto.getRoles().contains("ROLE_ADMIN")) {
            roleSet.add(roleRepository.findByRole("ROLE_ADMIN"));
        } else if (userDto.getRoles().contains("ROLE_USER")) {
            roleSet.add(roleRepository.findByRole("ROLE_USER"));
        } else {
            roleSet = userService.getUserById(userDto.getId()).getRoles();
        }
        return roleSet;
    }

    private List<String> getListRole(User user) {
        List<String> roleList = new ArrayList<>();
        user.getRoles().forEach(role -> {
            roleList.add(role.getRole());
        });
        return roleList;
    }

    private Avatar getAvatar(UserDTO userDTO) {
        Avatar avatar = apiService.getAvatar();
        avatar.setId(userDTO.getId());
        return avatar;
    }

    private String getUrlAvatar(User user) {
        return user.getAvatar().getUrl();
    }

    private String getDaDataResponse(UserDTO userDTO) {
        CoordsDTO coordsDTO = new CoordsDTO();
        coordsDTO.setLat(userDTO.getCoords()[0]);
        coordsDTO.setLon(userDTO.getCoords()[1]);
        coordsDTO.setRadius_meters(1000D);
        return apiService.getPostDaData(coordsDTO);
    }
}
