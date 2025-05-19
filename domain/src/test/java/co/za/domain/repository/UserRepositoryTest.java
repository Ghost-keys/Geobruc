package co.za.domain.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.za.domain.entity.Credentials;
import co.za.domain.entity.User;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.TestObserver;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository repository;

    private final Credentials validCredentials = new Credentials(
            "bonganialfred@gmail.com",
            "mySecurePassword"
    );

    private final Credentials invalidCredentials = new Credentials(
            "invalidmail@gmail.com",
            "invalidPassword"
    );

    private final User testUser = new User(
            "123",
            "bonganialfred@gmail.com",
            "mySecurePassword");

    private final String  username = "test_user";

    @Before
    public void setUp() {
        when(repository.login(validCredentials)).thenReturn(Single.just(testUser));
        when(repository.login(invalidCredentials))
                .thenReturn(Single.error(new Throwable("Invalid Credentials")));
        when(repository.register(validCredentials, username)).thenReturn(Single.just(testUser));
    }

    @Test
    public void login_ValidCredentials_ReturnUser() {
        TestObserver<User> testObserver = repository.login(validCredentials).test();

        testObserver.assertComplete();
        testObserver.assertNoErrors();
        testObserver.assertValue(user ->
                user.userId().equals("123") &&  // Record accessor syntax
                        user.email().equals("bonganialfred@gmail.com")
        );
    }

    @Test
    public void login_invalidCredentials_ThrowError() {
        TestObserver<User> testObserver = repository.login(invalidCredentials).test();

        testObserver.assertNotComplete();
        testObserver.assertError(Throwable.class);
    }

    @Test
    public void register_validCredential_ReturnUser() {
        TestObserver<User> testObserver = repository.register(validCredentials, username).test();

        testObserver.assertComplete();
        testObserver.assertValue(testUser);
    }
}