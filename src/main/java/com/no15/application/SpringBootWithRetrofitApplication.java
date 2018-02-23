package com.no15.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class SpringBootWithRetrofitApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootWithRetrofitApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithRetrofitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String userName = args[0];

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		GitHubAPI gitHubAPI = retrofit.create(GitHubAPI.class);
		Call<User> call = gitHubAPI.getUserWithUserName(userName);
		call.enqueue(new Callback<User>() {

			@Override
			public void onResponse(Call<User> call, Response<User> response) {
				User user = response.body();
				if(null == user){
					LOGGER.info("Record not found with : " + userName);
					System.exit(0);
				}


				LOGGER.info("Login : " + user.getLogin());
				LOGGER.info("Username : " + user.getName());
				LOGGER.info("Blog : " + user.getBlog());
				LOGGER.info("Bio : " + user.getBio());
				LOGGER.info("Avatar Url : " + user.getAvatarUrl());
				System.exit(0);
			}

			@Override
			public void onFailure(Call<User> call, Throwable t) {
				LOGGER.info("Error Msg : " + t.getMessage());
				System.exit(0);
			}
		});
	}
}
