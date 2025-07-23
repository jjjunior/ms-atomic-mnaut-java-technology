package br.com.jstack.technology.application.usecase;

public interface RetrieveByIdUseCase<T, ID> {
	T retrieveById(ID id);
}