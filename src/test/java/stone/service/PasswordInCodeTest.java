package stone.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordInCodeTest {


    @Test
    public void shuoldReturnCorrectResult() {
        String hello = PasswordInCode.passwordEncoded("Hello");
        String actual = PasswordInCode.passwordDecoded(hello);
        assertEquals("Hello", actual);

    }

}