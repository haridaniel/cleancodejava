package hu.daniel.hari.cleancodejava.filter.async;

public interface Filter<T> {
	void filter(T input, FilterOutput<T> output);
}
