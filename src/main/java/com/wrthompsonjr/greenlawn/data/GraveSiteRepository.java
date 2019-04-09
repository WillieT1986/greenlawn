package com.wrthompsonjr.greenlawn.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wrthompsonjr.greenlawn.models.GraveSite;

@Repository
public interface GraveSiteRepository extends JpaRepository<GraveSite, Long> {

}