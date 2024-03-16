package com.Utilitties;

import java.util.Random;

import com.github.javafaker.Faker;

public class FakeData {
	static Faker fake;
	static Random random;

	public static String getFirstName() {
		fake = new Faker();
		return fake.address().firstName();
	}

	public static String getRole() {
		String[] roles = { "Developer", "Manager", "QA", "HumanResource", "Finance" };
		random = new Random();

		return roles[random.nextInt(roles.length)];
	}

}
