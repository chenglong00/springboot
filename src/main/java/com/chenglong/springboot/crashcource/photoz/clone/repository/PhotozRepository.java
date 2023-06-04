package com.chenglong.springboot.crashcource.photoz.clone.repository;

import com.chenglong.springboot.crashcource.photoz.clone.model.Photoz;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotozRepository extends CrudRepository<Photoz, Integer> {

}