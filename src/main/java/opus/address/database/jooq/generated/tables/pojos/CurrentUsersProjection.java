/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.0"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CurrentUsersProjection implements java.io.Serializable {

	private static final long serialVersionUID = -795254311;

	private final java.lang.Long    userId;
	private final java.lang.Long    sequence;
	private final java.lang.String  username;
	private final java.lang.String  email;
	private final java.lang.String  password;
	private final java.lang.Boolean isDisabled;

	public CurrentUsersProjection(
		java.lang.Long    userId,
		java.lang.Long    sequence,
		java.lang.String  username,
		java.lang.String  email,
		java.lang.String  password,
		java.lang.Boolean isDisabled
	) {
		this.userId = userId;
		this.sequence = sequence;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isDisabled = isDisabled;
	}

	public java.lang.Long userId() {
		return this.userId;
	}

	public java.lang.Long sequence() {
		return this.sequence;
	}

	public java.lang.String username() {
		return this.username;
	}

	public java.lang.String email() {
		return this.email;
	}

	public java.lang.String password() {
		return this.password;
	}

	public java.lang.Boolean isDisabled() {
		return this.isDisabled;
	}
}
