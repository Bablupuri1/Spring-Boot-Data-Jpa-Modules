package com.ecom.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Model.Users;
import com.ecom.Service.UserService;
import com.ecom.payload.LoginRequest;
import com.ecom.payload.UserPayload;
import com.ecom.responseapi.ApiResponse;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5175") // ✅ allow React frontend

public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public ApiResponse createUser(@RequestBody UserPayload user) {

		ApiResponse resp = userService.createUser(user);
		return resp;
	}
	
	
	
	@PostMapping("/login")
	public ApiResponse Authenticate(@RequestBody LoginRequest loginRequest) {
	    return userService.Authenticate(loginRequest.getUsername(), loginRequest.getPassword());
	}

	
	
	
	
	@GetMapping
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<Users> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/{id}")
	public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
		return userService.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		return deleted ? "User deleted successfully" : "User not found";
	}
}
