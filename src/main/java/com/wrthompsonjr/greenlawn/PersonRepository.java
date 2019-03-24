package com.wrthompsonjr.greenlawn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Person findOne(long personId);

}
