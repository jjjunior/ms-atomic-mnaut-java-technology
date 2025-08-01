package br.com.jstack.technology.domain.specification;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SpecificationFactory {
	
	public <T> Specification<T> uniqueName(Function<String, Boolean> existsByNameFn,
	                                       Function<T, String> nameExtractor) {
		return new UniqueNameSpec<>(existsByNameFn, nameExtractor);
	}
	
	public <T> Specification<T> uniqueNameExcludingSelf(BiFunction<String, Long, Boolean> existsByNameExcludingIdFn,
	                                                    Function<T, String> nameExtractor,
	                                                    Function<T, Long> idExtractor) {
		return new UniqueNameExcludingSelfSpec<>(existsByNameExcludingIdFn, nameExtractor, idExtractor);
	}
}