package com.wrthompsonjr.greenlawn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CemeterySectionRepository extends JpaRepository<CemeterySection, Long> {

	String findGraveSiteByCemeterySection(@Param("cemeterySection") String cemeterySection);

}