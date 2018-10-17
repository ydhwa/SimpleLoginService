package org.ydh;

import org.ydh.Exception.AlreadyUserIdExistException;
import org.ydh.Exception.PasswordNotSuitableException;
import org.ydh.Exception.UserIdNotFoundException;
import org.ydh.Exception.UserIdNotSuitableException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginService {
    private Map<String, String> userDatabase = new HashMap<String, String>();

    public LoginService() {
        userDatabase.put("admin", "admin123!");
    }

    public boolean login(String userId, String password) {
        checkIfUserIdExist(userId);
        return userDatabase.get(userId).equals(password);
    }

    public void userRegistration(String userId, String password) {
        checkIfAlreadyUserIdExist(userId);
        checkIfUserIdSuitable(userId);
        checkIfPasswordSuitable(password);
        userDatabase.put(userId, password);
    }

    public int getUserDatabaseSize() {
        return userDatabase.size();
    }

    private void checkIfUserIdExist(String userId) {
        if(!userDatabase.containsKey(userId)) {
            throw new UserIdNotFoundException("아이디가 존재하지 않습니다.");
        }
    }

    private void checkIfAlreadyUserIdExist(String userId) {
        if(userDatabase.containsKey(userId)) {
            throw new AlreadyUserIdExistException("이미 존재하는 아이디입니다.");
        }
    }

    private void checkIfUserIdSuitable(String userId) {
        // 4자리 이상, 20자리 이하. 영어 대소문자, 숫자, 언더 바(_) 사용 가능
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]{4,20}");
        Matcher matcher = pattern.matcher(userId);
        if(!matcher.matches()) {
            throw new UserIdNotSuitableException("아이디가 적절하지 않습니다.");
        }
    }

    private void checkIfPasswordSuitable(String password) {
        // 최소 8자리, 숫자, 문자, 특수문자 각각 1개 이상 포함
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()) {
            throw new PasswordNotSuitableException("패스워드가 적절하지 않습니다.");
        }
    }
}
