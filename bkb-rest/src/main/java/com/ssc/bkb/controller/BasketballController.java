package com.ssc.bkb.controller;

import com.ssc.bkb.entity.Basketball;
import com.ssc.bkb.exception.BasketballNotFoundException;
import com.ssc.bkb.repository.BasketballRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * BasketballController
 *
 * @author Lebonheur
 * @date 1/7/2020 15:55
 * @version 1.0,新建
 */
@RestController
@RequestMapping("/bkb")
public class BasketballController {

	private final BasketballRepository repository;

	BasketballController(BasketballRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	CollectionModel<EntityModel<Basketball>> all() {

		List<EntityModel<Basketball>> basketballs = repository.findAll().stream()
				.map(basketball -> EntityModel.of(basketball,
						linkTo(methodOn(BasketballController.class).one(basketball.getUserId())).withSelfRel(),
						linkTo(methodOn(BasketballController.class).all()).withRel("basketballs")))
				.collect(Collectors.toList());

		return CollectionModel.of(basketballs, linkTo(methodOn(BasketballController.class).all()).withSelfRel());
	}

	@PostMapping
	Basketball newBasketball(@RequestBody Basketball newBasketball) {
		return repository.save(newBasketball);
	}

	@GetMapping("/{id}")
	EntityModel<Basketball> one(@PathVariable Long id) {

		Basketball basketball = repository.findById(id)
				.orElseThrow(() -> new BasketballNotFoundException(id));

		return EntityModel.of(basketball,
				linkTo(methodOn(BasketballController.class).one(id)).withSelfRel(),
				linkTo(methodOn(BasketballController.class).all()).withRel("basketballs"));
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
