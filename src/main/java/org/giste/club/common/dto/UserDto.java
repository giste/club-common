package org.giste.club.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.giste.util.dto.BaseDto;

/**
 * DTO object for user entity.
 * 
 * @author Giste
 */
public class UserDto extends BaseDto {

	private static final long serialVersionUID = -1770090907385341277L;

	@NotNull
	@Size(max = 64)
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String email;

	@NotNull
	@Size(min = 3, max = 64)
	private String name;
	
	private String passwordHash;

	@NotNull
	private Role role = Role.USER;

	/**
	 * Default constructor.
	 */
	public UserDto() {
		super();
	}

	/**
	 * Constructs a user with given parameters.
	 * 
	 * @param id User identifier.
	 * @param email Mail of the user.
	 * @param name The user's name.
	 * @param passwordHash Password hash of the user.
	 * @param role Role of the user.
	 */
	public UserDto(Long id, String email, String name, String passwordHash, Role role) {
		super(id);
		this.email = email;
		this.name = name;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	/**
	 * Gets the user email.
	 * 
	 * @return The email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user email.
	 * 
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the user's name.
	 * 
	 * @return The user's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user's name.
	 * 
	 * @param name The user's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password hash.
	 * 
	 * @return The passwordHash.
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Sets the password hash.
	 * 
	 * @param passwordHash The passwordHash to set.
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Gets the role of the user.
	 * 
	 * @return The role.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role of the user.
	 * 
	 * @param role The role to set.
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
