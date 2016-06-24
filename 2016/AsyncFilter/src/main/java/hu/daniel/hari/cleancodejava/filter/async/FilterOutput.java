package hu.daniel.hari.cleancodejava.filter.async;

public interface FilterOutput<T> {
	void filtered(T value);
}