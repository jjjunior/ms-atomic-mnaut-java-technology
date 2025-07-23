package br.com.jstack.technology.domain.policy;

import br.com.jstack.technology.domain.vo.OperationType;

public interface ValidationPolicy<T> {
	
	boolean supports(OperationType operation);
	
	void validate(T target, OperationType operation);
	
	Class<T> getTargetType();
}