package com.wrthompsonjr.greenlawn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CemeterySectionRepository extends JpaRepository<CemeterySection, Long> {

//	CemeterySection findById(String cemeterySection);

}