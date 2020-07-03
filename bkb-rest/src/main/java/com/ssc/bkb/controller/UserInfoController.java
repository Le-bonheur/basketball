package com.ssc.bkb.controller;

import com.ssc.bkb.entity.Basketball;
import com.ssc.bkb.exception.UserInfoNotFoundException;
import com.ssc.bkb.repository.UserInfoRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * 用户Controller
 *
 * @author Lebonheur
 * @date 1/7/2020 15:55
 * @version 1.0,新建
 */
@RestController
@RequestMapping("/bkb")
public class UserInfoController {

	private final UserInfoRepository repository;

	UserInfoController(UserInfoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	CollectionModel<EntityModel<Basketball>> all() {

		List<EntityModel<Basketball>> basketballs = repository.findAll().stream()
				.map(basketball -> EntityModel.of(basketball,
						linkTo(methodOn(UserInfoController.class).one(basketball.getUserId())).withSelfRel(),
						linkTo(methodOn(UserInfoController.class).all()).withRel("basketballs")))
				.collect(Collectors.toList());

		return CollectionModel.of(basketballs, linkTo(methodOn(UserInfoController.class).all()).withSelfRel());
	}

	@PostMapping
	Basketball newBasketball(@RequestBody Basketball newBasketball) {
		return repository.save(newBasketball);
	}

	@GetMapping("/{id}")
	EntityModel<Basketball> one(@PathVariable Long id) {

		Basketball basketball = repository.findById(id)
				.orElseThrow(() -> new UserInfoNotFoundException(id));

		return EntityModel.of(basketball,
				linkTo(methodOn(UserInfoController.class).one(id)).withSelfRel(),
				linkTo(methodOn(UserInfoController.class).all()).withRel("basketballs"));
	}

	@PutMapping("/{id}")
	Basketball replaceBasketball(@RequestBody Basketball newBasketball, @PathVariable Long id) {

		return repository.findById(id)
				.map(basketball -> {
					basketball.setName(newBasketball.getName());
					basketball.setRole(newBasketball.getRole());
					return repository.save(basketball);
				})
				.orElseGet(() -> {
					newBasketball.setUserId(id);
					return repository.save(newBasketball);
				});
	}

	@DeleteMapping("/{id}")
	void deleteBasketball(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
