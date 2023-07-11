package com.projeto.quiz.services;

import com.projeto.quiz.controllers.UserController;
import com.projeto.quiz.exceptions.RequiredFieldNotInformed;
import com.projeto.quiz.exceptions.RequiredObjectIsNullException;
import com.projeto.quiz.exceptions.ResourceNotFoundException;
import com.projeto.quiz.mapper.DozerMapper;
import com.projeto.quiz.models.Address;
import com.projeto.quiz.models.User;
import com.projeto.quiz.repositories.UserRepository;
import com.projeto.quiz.vo.AddressVO;
import com.projeto.quiz.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String delete(Long id) {
        var dbUser = userRepository.findById(id);
        if (dbUser.isPresent()) {
            userRepository.deleteById(id);
            return "User with id " + id + " has been deleted!";
        } else {
            return "ID " + id + " not found!";
        }
    }

    public UserVO findById(Long id) throws Exception {
        var userDb = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this user"));
        var user = DozerMapper.parseObject(userDb, UserVO.class);
        user.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        return user;
    }


    public UserVO save(UserVO userVO) throws Exception {
        if (userVO == null) throw new RequiredObjectIsNullException("Object cannot be null");
        if (!verifyUser(userVO)) throw new RequiredFieldNotInformed("Uninformed user data");
        if (!verifyUserDocument(userVO)) throw new RequiredFieldNotInformed("Uninformed document data");
        if (!verifyUserAddress(userVO)) throw new RequiredFieldNotInformed("Address data not informed");

        User user = DozerMapper.parseObject(userVO, User.class);
        user.getDocument().setUser(user);
        var userDb = userRepository.save(user);
        userVO = DozerMapper.parseObject(userDb, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    @Transactional
    public UserVO update(UserVO userVO) throws Exception {

        if (userVO == null) throw new RequiredObjectIsNullException("Object cannot be null");
        if (!verifyUserUpdate(userVO)) throw new RequiredFieldNotInformed("Uninformed user data");
        if (!verifyUserAddress(userVO)) throw new RequiredFieldNotInformed("Address data not informed");

        var dbUser = userRepository.findById(userVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this user"));

        User user = dbUser;

        user.setPassword(userVO.getPassword());
        user.setPhone(userVO.getPhone());

        List<Address> addresses = user.getAddresses();
        List<Address> updatedAddresses = userVO.getAddresses();

        if (addresses != null && updatedAddresses != null) {
            addresses.clear();
            addresses.addAll(updatedAddresses);
        }

        user = userRepository.save(user);
        userVO = DozerMapper.parseObject(user, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    private boolean verifyUser(UserVO userVO) {
        if (!userVO.getFirstName().isBlank() && !userVO.getFirstName().isEmpty() &&
                !userVO.getLastName().isBlank() && !userVO.getLastName().isEmpty() &&
                !userVO.getUserName().isBlank() && !userVO.getUserName().isEmpty() &&
                !userVO.getPassword().isBlank() && !userVO.getPassword().isEmpty() &&
                !userVO.getPhone().isBlank() && !userVO.getPhone().isEmpty() &&
                !userVO.getSex().isBlank() && !userVO.getSex().isEmpty()
        ) {
            return true;
        }
        return false;
    }

    private boolean verifyUserDocument(UserVO userVO) {
        if (!userVO.getDocument().getCpf().isBlank() && !userVO.getDocument().getCpf().isEmpty()) {
            return true;
        }
        return false;
    }


    private boolean verifyUserAddress(UserVO userVO) {
        List<Address> addresses = userVO.getAddresses();
        if (addresses != null && !addresses.isEmpty()) {
            for (Address address : addresses) {
                if (!address.getCep().isBlank() && !address.getCep().isEmpty() &&
                        !address.getPublicPlace().isBlank() && !address.getPublicPlace().isEmpty() &&
                        !address.getNeighborhood().isBlank() && !address.getNeighborhood().isEmpty() &&
                        !address.getState().isBlank() && !address.getState().isEmpty() &&
                        !address.getCity().isBlank() && !address.getCity().isEmpty() &&
                        !address.getCountry().isBlank() && !address.getCountry().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyUserUpdate(UserVO userVO){
        if(!userVO.getPassword().isBlank() && !userVO.getPassword().isEmpty() &&
                !userVO.getPhone().isBlank() && !userVO.getPhone().isEmpty()){
            return true;
        }
        return false;
    }
}
