package br.com.jstack.technology.framework.adapter.input.rest;

import java.util.List;

import br.com.jstack.system.acronym.api.BusinessUnitApi;
import br.com.jstack.technology.application.usecase.CreateUseCase;
import br.com.jstack.technology.application.usecase.DeleteByIdUseCase;
import br.com.jstack.technology.application.usecase.RetrieveAllUseCase;
import br.com.jstack.technology.application.usecase.RetrieveByIdUseCase;
import br.com.jstack.technology.application.usecase.UpdateUseCase;
import br.com.jstack.technology.domain.entity.BusinessUnit;
import br.com.jstack.technology.framework.mapper.BusinessUnitMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class BusinessUnitRestAdapter implements BusinessUnitApi {
	
	private final BusinessUnitMapper                      mapper;
	private final CreateUseCase<BusinessUnit>             createUseCase;
	private final RetrieveByIdUseCase<BusinessUnit, Long> retrieveByIdUseCase;
	private final RetrieveAllUseCase<BusinessUnit>        retrieveAllUseCase;
	private final UpdateUseCase<BusinessUnit>             updateUseCase;
	private final DeleteByIdUseCase<BusinessUnit, Long>   deleteUseCase;
	
	@Override
	public ResponseEntity<BusinessUnitResponse> createBusinessUnit(BusinessUnitRequest request) {
		BusinessUnit         created  = createUseCase.create(mapper.toDomain(request));
		BusinessUnitResponse response = mapper.toResponse(created);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Override
	public ResponseEntity<Void> deleteBusinessUnit(Long id) {
		deleteUseCase.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@Override
	public ResponseEntity<List<BusinessUnitResponse>> listBusinessUnits() {
		List<BusinessUnit>         businessUnits = retrieveAllUseCase.retrieveAll();
		List<BusinessUnitResponse> responses     = businessUnits.stream().map(mapper::toResponse).toList();
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	
	@Override
	public ResponseEntity<BusinessUnitResponse> retrieveBusinessUnit(Long id) {
		BusinessUnit         retrieveById = retrieveByIdUseCase.retrieveById(id);
		BusinessUnitResponse response     = mapper.toResponse(retrieveById);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Override
	public ResponseEntity<BusinessUnitResponse> updateBusinessUnit(Long id, BusinessUnitRequest request) {
		BusinessUnit businessUnit = mapper.toDomain(request);
		businessUnit.setId(id);
		BusinessUnit         updated  = updateUseCase.update(businessUnit);
		BusinessUnitResponse response = mapper.toResponse(updated);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
