package br.com.jstack.technology.application.usecase;

public interface DeleteByIdUseCase<T, ID> {
	void deleteById(ID id);
}