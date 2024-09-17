package com.sermaluc.reto.user.mappers;

import com.sermaluc.reto.auth.model.User;
import com.sermaluc.reto.user.dtos.CreatePhoneInputDTO;
import com.sermaluc.reto.user.dtos.CreateUserInputDTO;
import com.sermaluc.reto.user.dtos.ListUserOutputDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void createUser(CreateUserInputDTO element);

    void createPhone(CreatePhoneInputDTO element);

    Boolean existsUser(@Param("email") String email);

    User findUser(@Param("email") String email);

    List<ListUserOutputDTO> listUsers();

}
