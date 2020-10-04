package com.matafe.jsonbexample;

import static com.matafe.jsonbexample.TestUtils.getTestFileContent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	private static final Logger LOGGER = Logger.getLogger(UserTest.class.getName());

	private Jsonb jsonb;

	@BeforeEach
	void beforeTest() {
		this.jsonb = JsonbBuilder.create();
	}

	@Test
	void testUserSerialization() {

		User u1 = new User(1L, "user1", true, LocalDate.of(2020, 1, 21));
		u1.addRole(new Role("user_role"));

		String result = jsonb.toJson(u1);

		LOGGER.info("User Serialized: " + result);

	}

	@Test
	void testUserDeserialization() {

		String jsonString = "{\"active\":true,\"id\":1,\"lastUpdateDate\":\"2020-01-21\",\"user-name\":\"user1\"}";
		User u1 = jsonb.fromJson(jsonString, User.class);

		LOGGER.info("User derialized: " + u1);

		assertEquals(1L, u1.getId());
		assertEquals("user1", u1.getName());
		assertTrue(u1.getLastUpdateDate().isEqual(LocalDate.of(2020, 1, 21)));
		assertTrue(u1.isActive());

	}

	@Test
	void testUserDeserializationFromFile() throws Exception {
		String jsonString = getTestFileContent("data/user.json");
		User u1 = jsonb.fromJson(jsonString, User.class);

		LOGGER.info("User derialized from file: " + u1);

		assertEquals(1L, u1.getId());
		assertEquals("user1", u1.getName());
		assertTrue(u1.getLastUpdateDate().isEqual(LocalDate.of(2020, 1, 21)));
		assertTrue(u1.isActive());
	}

	@Test
	void testUsersSerialization() {

		List<User> users = Arrays.asList(new User(1L, "user1", true, LocalDate.of(2020, 1, 21)),
				new User(2L, "user2", false, LocalDate.of(2020, 1, 22)));

		String result = jsonb.toJson(users);

		LOGGER.info("Users derialized: " + result);

		assertEquals(result,
				"[{\"active\":true,\"id\":1,\"lastUpdateDate\":\"2020-01-21\",\"user-name\":\"user1\"},{\"active\":false,\"id\":2,\"lastUpdateDate\":\"2020-01-22\",\"user-name\":\"user2\"}]");
	}

	@Test
	void testUsersDeserializationFromFile() throws Exception {
		String jsonString = getTestFileContent("data/users.json");
		List<User> users = jsonb.fromJson(jsonString, new ArrayList<User>() {
		}.getClass().getGenericSuperclass());

		LOGGER.info("Users derialized from file: " + users);

	}
}
