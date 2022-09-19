package com.example.res.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1, "Deniz", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Ibraham", LocalDate.now().minusYears(35)));
        users.add(new User(3, "Cem", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

}