package br.com.jstack.technology.domain.policy;

import br.com.jstack.technology.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.technology.domain.entity.BusinessUnit;
import br.com.jstack.technology.domain.specification.Specification;
import br.com.jstack.technology.domain.specification.SpecificationFactory;
import br.com.jstack.technology.domain.vo.OperationType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessUnitPolicy implements ValidationPolicy<BusinessUnit> {
	
	private final SpecificationFactory   specFactory;
	private final BusinessUnitOutputPort outputPort;
	
	@Override
	public void validate(BusinessUnit domain, OperationType operation) {
		
		if (operation == OperationType.CREATE) {
			Specification<BusinessUnit> uniqueNameSpec = specFactory.uniqueName(outputPort::existsByName, BusinessUnit::getName);
			if (!uniqueNameSpec.isSatisfiedBy(domain)) {
				throw new IllegalArgumentException("Business Unit Name must be unique.");
			}
		}
		
		if (operation == OperationType.UPDATE) {
			Specification<BusinessUnit> uniqueNameExclIdSpec = specFactory.uniqueNameExcludingSelf(outputPort::existsByNameAndIdNot, BusinessUnit::getName, BusinessUnit::getId);
			if (!uniqueNameExclIdSpec.isSatisfiedBy(domain)) {
				throw new IllegalArgumentException("Business Unit Name must be unique (excluding self).");
			}
		}
	}
	
	@Override
	public boolean supports(OperationType operation) {
		return operation == OperationType.CREATE || operation == OperationType.UPDATE;
	}
	
	@Override
	public Class<BusinessUnit> getTargetType() {
		return BusinessUnit.class;
	}
	
	public BusinessUnit getValidBusinessUnit(Long id) {
		return outputPort.findById(id);
	}
}