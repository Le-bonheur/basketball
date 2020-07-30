package com.ssc.bkb.controller;

import com.ssc.bkb.entity.UserInfo;
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
	CollectionModel<EntityModel<UserInfo>> all() {

		List<EntityModel<UserInfo>> userInfos = repository.getAllUser().stream()
				.map(userInfo -> EntityModel.of(userInfo,
						linkTo(methodOn(UserInfoController.class).one(userInfo.getUserId())).withSelfRel(),
						linkTo(methodOn(UserInfoController.class).all()).withRel("userInfos")))
				.collect(Collectors.toList());

		return CollectionModel.of(userInfos, linkTo(methodOn(UserInfoController.class).all()).withSelfRel());
	}

	@PostMapping
	int newUserInfo(@RequestBody UserInfo newUserInfo) {
		return repository.insertSelective(newUserInfo);
	}

	@GetMapping("/{id}")
	EntityModel<UserInfo> one(@PathVariable Integer id) {

		UserInfo userInfo = repository.selectByPrimaryKey(id)
				.orElseThrow(() -> new UserInfoNotFoundException(id));

		return EntityModel.of(userInfo,
				linkTo(methodOn(UserInfoController.class).one(id)).withSelfRel(),
				linkTo(methodOn(UserInfoController.class).all()).withRel("userInfos"));
	}

	@PutMapping("/{id}")
	int replaceUserInfo(@RequestBody UserInfo newUserInfo, @PathVariable Integer id) {

		return repository.selectByPrimaryKey(id)
				.map(userInfo -> {
					userInfo.setCity(newUserInfo.getCity());
					userInfo.setCountry(newUserInfo.getCountry());
					return repository.insertSelective(userInfo);
				})
				.orElseGet(() -> {
					newUserInfo.setUserId(id);
					return repository.insertSelective(newUserInfo);
				});
	}

	@DeleteMapping("/{id}")
	void deleteUserInfo(@PathVariable Integer id) {
		repository.deleteByPrimaryKey(id);
	}
}
