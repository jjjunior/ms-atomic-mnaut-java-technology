package br.com.jstack.technology.application.port.output;

import br.com.jstack.technology.domain.entity.BusinessUnit;

public interface BusinessUnitOutputPort extends PersistencePort<BusinessUnit, Long> {
	boolean existsByName(String name);
	
	boolean existsByNameAndIdNot(String name, Long id);
}
