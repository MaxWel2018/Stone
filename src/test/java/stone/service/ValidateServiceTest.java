package stone.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stone.exception.dontCorrectArgumentRuntimeException;

import static org.hamcrest.CoreMatchers.containsString;
import static stone.service.ValidateService.notNull;
import static stone.service.ValidateService.validate;
public class ValidateServiceTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturnExceptionWithNull() {
        exception.expect(dontCorrectArgumentRuntimeException.class);
        exception.expectMessage(containsString("Arrgument = Null"));
        notNull(null);
    }

    @Test
    public void shouldReturnExceptionWithDontCorrectParametr() {
        exception.expect(dontCorrectArgumentRuntimeException.class);
        exception.expectMessage(containsString("The received data does not match the specified pattern"));
        validate("HelloWordl12312","[A-z]");
    }


}