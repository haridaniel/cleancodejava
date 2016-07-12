package com.cleancodejava.util.observable;

import java.util.HashSet;
import java.util.Set;

public class Observable<T> {

	private T value;
	private Set<ChangeListener<T>> changeListeners = new HashSet<>();

	public Observable(T initialValue) {
		this.value = initialValue;
	}
	
	public Observable() {
		this(null);
	}
	
	public void set(T value) {
		this.value = value;
		notifyListeners();
	}
	
	private void notifyListeners() {
		for (ChangeListener<T> changeListener : changeListeners) {
			changeListener.onChanged(value);
		}
	}

	public T get() {
		return value;
	}

	public void addChangeListener(ChangeListener<T> changeListener) {
		changeListeners.add(changeListener);
	}
	
	public interface ChangeListener<T> {
		void onChanged(T newValue);
	}
	
}
