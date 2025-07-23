package br.com.jstack.technology.application.usecase;

public interface UpdateUseCase<T> {
	T update(T domain);
}