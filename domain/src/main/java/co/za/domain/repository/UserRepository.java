package co.za.domain.repository;

import co.za.domain.entity.Credentials;
import co.za.domain.entity.User;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

/**
 * Repository interface for user authentication operations.
 * This defines what operations can be performed without specifying how they're implemented.
 */
public interface UserRepository {

    /**
     * Log in a user with email and password.
     * @param credentials User login credentials
     * @return A Single that emits the User if successful, or an error
     */
    Single<User> login(Credentials credentials);

    /**
     * Register a new user account.
     * @param credentials User registration credentials
     * @param username Username for the new account
     * @return A Single that emits the created User if successful, or an error
     */
    Single<User> register(Credentials credentials, String username);

    /**
     * Check if a user is currently logged in.
     * @return A Single that emits true if a user is logged in, false otherwise
     */
    Single<Boolean> isLoggedIn();

    /**
     * Get the currently logged-in user.
     * @return A Single that emits the current User if logged in, or an error
     */
    Single<User> getCurrentUser();

    /**
     * Log out the current user.
     * @return A Completable that completes when logout is successful, or emits an error
     */
    Completable logout();

}
