package de.cepesoft.playground.helloworld;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final SortedMap<Integer, User> users = new TreeMap<>();

    public UserService() {
        addUser("Frieda", "Tüddelkopp");
        addUser("Gustav", "Testmeister");
        addUser("Peter", "Parker");
    }

    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }
    
    public User addUser(String firstName, String lastName) {
        var newId = users.isEmpty() ? 1 : users.lastKey() + 1;
        var user = new User(newId, firstName, lastName);
        users.put(user.id(), user);
        return user;
    }

    public User findUserById(Integer id) {
        return users.get(id);
    }

    public void updateUser(User user) {
        users.put(user.id(), user);
    }

    public void deleteUserById(Integer id) {
        users.remove(id);
    }
    
}
