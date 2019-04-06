package com.wrthompsonjr.greenlawn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GraveSiteRepository extends JpaRepository<GraveSite, Long> {

	String findCemeterySectionByGraveSite(@Param("cemeterySection") String cemeterySection);
}