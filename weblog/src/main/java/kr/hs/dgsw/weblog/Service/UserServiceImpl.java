package kr.hs.dgsw.weblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Repository.UserRepository;

@Service
//
public class UserServiceImpl implements UserService {

    @Autowired
    //의존하고 있는 Bean을 자동으로 주입해 주는 것.
    private UserRepository userRepository;

    @Override
    //슈퍼 클래스에 존재하는 필드나 메소드를 서브 클래스에서 재정의하여 사용할 수 있다.
    public User create(User user) {
        Optional<User> found = userRepository.findByAccount(user.getAccount());
        if(found.isPresent()) return null;
        return userRepository.save(user);
    }

    @Override
    //슈퍼 클래스에 존재하는 필드나 메소드를 서브 클래스에서 재정의하여 사용할 수 있다.
    public User update(Long id, User user) {

        return userRepository.findById(id)
                .map(found -> {
                    found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                    found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
                    return userRepository.save(found);
                })
                .orElse(null);
    }

    @Override
    //슈퍼 클래스에 존재하는 필드나 메소드를 서브 클래스에서 재정의하여 사용할 수 있다.
    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    //슈퍼 클래스에 존재하는 필드나 메소드를 서브 클래스에서 재정의하여 사용할 수 있다.
    public User read(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    @Override
    //슈퍼 클래스에 존재하는 필드나 메소드를 서브 클래스에서 재정의하여 사용할 수 있다.
    public List<User> readAll() {
        return userRepository.findAll();
    }
    
}