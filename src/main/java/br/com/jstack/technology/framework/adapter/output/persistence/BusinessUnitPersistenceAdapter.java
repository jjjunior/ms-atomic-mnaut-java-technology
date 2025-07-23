package br.com.jstack.technology.framework.adapter.output.persistence;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.jstack.technology.application.port.output.BusinessUnitOutputPort;
import br.com.jstack.technology.domain.entity.BusinessUnit;
import br.com.jstack.technology.framework.adapter.output.persistence.repository.BusinessUnitRepository;
import io.micronaut.data.model.Sort;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessUnitPersistenceAdapter implements BusinessUnitOutputPort {
	
	private final EntityManager          entityManager;
	private final BusinessUnitRepository repository;
	
	@Override
	public boolean existsByName(String name) {
		return repository.findByName(name).isPresent();
	}
	
	@Override
	public boolean existsByNameAndIdNot(String name, Long id) {
		return repository.findByNameAndIdNotEqual(name, id).isPresent();
	}
	
	@Transactional
	@Override
	public BusinessUnit save(BusinessUnit domain) {
		BusinessUnit businessUnit = repository.saveAndFlush(domain);
		entityManager.clear();
		return businessUnit;
	}
	
	@Override
	public BusinessUnit findById(Long id) {
		BusinessUnit businessUnit = repository.findById(id)
			.orElseThrow(() -> new NoSuchElementException("Business Unit not found with id: " + id));
		return businessUnit;
	}
	
	@Override
	public List<BusinessUnit> findAll() {
		return repository.findAll(Sort.of(Sort.Order.asc("name")));
	}
	
	@Transactional
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	@Override
	public BusinessUnit update(BusinessUnit domain) {
		BusinessUnit existing = findById(domain.getId());
		existing.setName(domain.getName());
		existing.setDescription(domain.getDescription());
		existing.setActive(domain.getActive());
		repository.saveAndFlush(existing);
		return existing;
	}
}