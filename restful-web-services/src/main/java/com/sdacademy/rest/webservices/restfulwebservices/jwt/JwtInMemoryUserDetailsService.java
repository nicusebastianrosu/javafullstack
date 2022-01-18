package com.sdacademy.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "SDA",
				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "nicurosu",
				"$2a$10$O5M/y0XeumhO4desTDZD5ezzpp48HHJT.zrhF1oSmG08cRlntc/c2", "ROLE_USER_2"));
		// $2a$10$UmJHIm2643Oj/H7sGnJgiuVzu7a2M5gUCuJ0tUBGTzy2QrKxpdnv2
		// $2a$10$O5M/y0XeumhO4desTDZD5ezzpp48HHJT.zrhF1oSmG08cRlntc/c2
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
