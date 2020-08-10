package com.ies.spring.back.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.spring.back.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

	
	
}
