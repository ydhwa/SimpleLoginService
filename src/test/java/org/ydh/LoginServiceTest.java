package org.ydh;

import org.junit.Before;
import org.junit.Test;
import org.ydh.Exception.AlreadyUserIdExistException;
import org.ydh.Exception.PasswordNotSuitableException;
import org.ydh.Exception.UserIdNotFoundException;
import org.ydh.Exception.UserIdNotSuitableException;

import static org.junit.Assert.*;

public class LoginServiceTest {
    private LoginService loginService;

    @Before
    public void setUp() {
        loginService = new LoginService();
    }

    @Test
    public void 아이디가_존재하고_패스워드가_맞으면_로그인_성공() {
        boolean loginResult = loginService.login("admin", "admin123!");
        assertTrue(loginResult);
    }

    @Test(expected = UserIdNotFoundException.class)
    public void 아이디가_존재하지_않으면_UserIdNotFoundException() {
        loginService.login("ydh", "ehdghk123@");
    }

    @Test
    public void 패스워드가_틀리면_로그인_실패() {
        boolean loginResult = loginService.login("admin", "ehdghk123@");
        assertFalse(loginResult);
    }

    @Test
    public void 회원가입_성공하면_회원_수가_늘어남() {
        int beforeUserDatabaseSize = loginService.getUserDatabaseSize();
        loginService.userRegistration("ydhwa_18", "didehdghk123!");
        assertEquals(loginService.getUserDatabaseSize(), beforeUserDatabaseSize + 1);
    }

    @Test(expected = AlreadyUserIdExistException.class)
    public void 이미_존재하는_아이디로_회원가입을_시도하면_AlreadyUserIdExistException() {
        loginService.userRegistration("admin", "ehdghk123!");
    }

    @Test(expected = UserIdNotSuitableException.class)
    public void 너무_짧은_아이디로_회원가입을_시도하면_UserIdNotSuitableException() {
        // 4자리 이상, 20자리 이하. 영어 대소문자, 숫자, 언더 바(_) 사용 가능
        loginService.userRegistration("ydh", "ehdghk123!");
    }

    @Test(expected = UserIdNotSuitableException.class)
    public void 너무_긴_아이디로_회원가입을_시도하면_UserIdNotSuitableException() {
        // 4자리 이상, 20자리 이하. 영어 대소문자, 숫자, 언더 바(_) 사용 가능
        loginService.userRegistration("ydhwaydhwaydhwaydhwaydhwa", "ehdghk123!");
    }

    @Test(expected = UserIdNotSuitableException.class)
    public void 영어_대소문자_숫자_언더바_외의_문자로_작성된_아이디로_회원가입을_시도하면_UserIdNotSuitableException() {
        // 4자리 이상, 20자리 이하. 영어 대소문자, 숫자, 언더 바(_) 사용 가능
        loginService.userRegistration("양동화", "ehdghk123!");
    }

    @Test(expected = PasswordNotSuitableException.class)
    public void 너무_짧은_패스워드로_회원가입을_시도하면_PasswordNotSuitableException() {
        // 최소 8자리, 숫자, 문자, 특수문자 각각 1개 이상 포함
        loginService.userRegistration("Ydhwa_18", "ehd123!");
    }

    @Test(expected = PasswordNotSuitableException.class)
    public void 숫자_문자_특수문자_중_하나라도_빼먹은_패스워드로_회원가입을_시도하면_PasswordNotSuitableException() {
        // 최소 8자리, 숫자, 문자, 특수문자 각각 1개 이상 포함
        loginService.userRegistration("ydhwa_18", "ehdghk123");
    }
}
