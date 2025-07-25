package br.com.jstack.technology.application.port.input;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jstack.technology.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.technology.application.usecase.CreateUseCase;
import br.com.jstack.technology.application.usecase.DeleteByIdUseCase;
import br.com.jstack.technology.application.usecase.RetrieveAllUseCase;
import br.com.jstack.technology.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.technology.application.usecase.UpdateUseCase;
import br.com.jstack.technology.domain.entity.BusinessUnit;
import br.com.jstack.technology.domain.policy.PolicyResolver;
import br.com.jstack.technology.domain.policy.ValidationPolicy;
import br.com.jstack.technology.domain.vo.OperationType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessUnitInputPort implements
	CreateUseCase<BusinessUnit>,
	RetrieveByIdUseCase<BusinessUnit, Long>,
	RetrieveAllUseCase<BusinessUnit>,
	UpdateUseCase<BusinessUnit>,
	DeleteByIdUseCase<BusinessUnit, Long> {
	
	private final BusinessUnitOutputPort       outputPort;
	private final PolicyResolver<BusinessUnit> policyResolver;
	
	@Override
	public BusinessUnit create(@Valid BusinessUnit domain) {
		ValidationPolicy<BusinessUnit> policy = policyResolver.resolve(OperationType.CREATE, BusinessUnit.class);
		policy.validate(domain, OperationType.CREATE);
		return outputPort.save(domain);
	}
	
	@Override
	public BusinessUnit retrieveById(Long id) {
		return outputPort.findById(id);
	}
	
	@Override
	public List<BusinessUnit> retrieveAll() {
		return outputPort.findAll().stream().collect(Collectors.toList());
	}
	
	@Override
	public BusinessUnit update(@Valid BusinessUnit domain) {
		ValidationPolicy<BusinessUnit> policy = policyResolver.resolve(OperationType.UPDATE, BusinessUnit.class);
		policy.validate(domain, OperationType.UPDATE);
		return outputPort.update(domain);
	}
	
	@Override
	public void deleteById(Long id) {
		outputPort.deleteById(id);
	}
}
