package br.com.jstack.technology.application.usecase;

import java.util.List;

public interface RetrieveAllUseCase<T> {
	List<T> retrieveAll();
}