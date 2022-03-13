package com.zz.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zz.task.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	Client findByEmail(String email);

	List<Client> findByTotalBill(Double topBill);

}
