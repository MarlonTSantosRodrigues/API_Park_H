package app.prod.src.backend_user.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.prod.src.backend_user.entity.user;
import app.prod.src.backend_user.services.UserService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "user")
public class UserController {
    
	private final UserService userservice;
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}
	
	@GetMapping(value = "")
	public List<user> getAllUsers() {
		return userservice.getAllUsers();
	}
	
	@GetMapping(value = "{id}")
	public user getUserById(@PathVariable String id) throws Exception {
		if (!ObjectUtils.isEmpty(id)) {
			return userservice.getUserById(id);
		}
		throw new Exception("Usuário com código " + id + " não encontrado");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public user createUser(@RequestBody @NotNull user user) throws Exception {
        /*if (username.getUsername() != null) {
        	throw new Exception("Usuário com o nickname " + username + " já existe");
        }*/
		return userservice.saveUser(user);
	}
	
	@PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public user updateUser(@PathVariable String id, @RequestBody @NotNull user user)
		throws Exception {
		if (!id.equals(user.getId())) {
			throw new Exception("ID " + id + " não está correto");
		}
		if (!userservice.isUserExists(user)) {
			throw new Exception("Usuário com ID " + id + " não existe");
		}
		return userservice.saveUser(user);
	}
    
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public boolean deleteUser(@PathVariable String id) throws Exception {
		if (!userservice.isUserExists(id)) {
			throw new Exception("Usuário com o ID " + id + " não existe");
		}
		userservice.deleteUser(id);
		return true;
	}
}