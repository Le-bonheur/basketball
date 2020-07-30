package com.ssc.bkb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * author: Lebonheur
 * date: 1/7/2020 10:33
 * description: Basketball
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basketball {

	private Long userId;
	private String name;
	private String role;

	public Basketball(String name, String role) {
		this.name = name;
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (!(o instanceof Basketball)) {
			return false;
		}
		Basketball basketball = (Basketball) o;
		return Objects.equals(this.userId, basketball.userId) && Objects.equals(this.name, basketball.name)
				&& Objects.equals(this.role, basketball.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.userId, this.name, this.role);
	}

	@Override
	public String toString() {
		return "Basketball{" + "id=" + this.userId + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
	}
}
