package com.wrthompsonjr.greenlawn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraveSiteRepository extends JpaRepository<GraveSite, Long> {
	GraveSite getAll();
}