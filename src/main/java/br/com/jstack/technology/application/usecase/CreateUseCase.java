package br.com.jstack.technology.application.usecase;

public interface CreateUseCase<T> {
	T create(T domain);
}
