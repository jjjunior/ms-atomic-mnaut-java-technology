package br.com.jstack.technology.framework.adapter.output.persistence.repository;

import java.util.Optional;

import br.com.jstack.technology.domain.entity.BusinessUnit;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, Long> {
	Optional<BusinessUnit> findByName(String name);
	
	Optional<BusinessUnit> findByNameAndIdNotEqual(String name, Long id);
}