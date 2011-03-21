package com.navigrad.m2m.webclient.entity;


public class CreateUser {

//	@NotEmpty
	private String login;
	private String firstName;
	private String lastName;
//	@Size(min = 4)
//	@NotEmpty
	private String password;
//	@Equal(propertyName = "password")
	private String confirmPassword;
//	@Size(min = 1, message = "You must fill login field")
	private String email;
	private String passwordError;
	private String loginError;
	private String firstNameError;
	private String lastNameError;
	private String confirmPasswordError;
//	private List<User> users = new ArrayList<User>();

	public String createNewUser() {
//		ValidatorFactory validatorFactory = Validation
//				.buildDefaultValidatorFactory();
//		Validator validator = validatorFactory.getValidator();
//		Set<ConstraintViolation<Class<CreateUser>>> result = validator
//				.validate(CreateUser.class);
//		if (result.isEmpty()) {
//			return "success";
//		} else {
//			for (ConstraintViolation<Class<CreateUser>> constraintViolation : result) {
//				System.out.println(constraintViolation.getPropertyPath()
//						.toString());
//				{
//				}
//			}
//		}
//		passwordError = CreateUserValidator.checkPassword(password);
//		if (!password.equals(confirmPassword)) {
//			confirmPasswordError = "Psswords didn't match";
//		}
//		loginError = CreateUserValidator.checkTextField("Login", login);
//		firstNameError = CreateUserValidator.checkTextField("First name",
//				firstName);
//		lastNameError = CreateUserValidator.checkTextField("Last name",
//				lastName);
//		if (passwordError != null || loginError != null
//				|| firstNameError != null || lastNameError != null)
//			return "error";
//		new UserServise().saveUser(login, password, firstName, lastName, email);
		return "success";

	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getConfirmPasswordError() {
		return confirmPasswordError;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFirstNameError() {
		return firstNameError;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLastNameError() {
		return lastNameError;
	}

	public String getLogin() {
		return login;
	}

	public String getLoginError() {
		return loginError;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordError() {
		return passwordError;
	}

//	public List<User> getUsers() {
//		users = UserServise.getSavedUsers();
//		return users;
//	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
}
