package com.zz.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zz.task.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	Agency findByAgencyId(Integer agencyId);

}
