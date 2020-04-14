package model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author vando
 */
public class AuthenticatedUser implements UserDetails{
    private final String userName;

    public AuthenticatedUser(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AuthenticatedUser)) {
			return false;
		}
		AuthenticatedUser other = (AuthenticatedUser) obj;
		return   Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthenticatedUser [username=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}
    
}
