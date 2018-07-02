package com.ley.springboot.mybatis.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BeanMapper {
	
	@Autowired
	@Qualifier("org.dozer.Mapper")
	private Mapper dozer;

	public <T> T map(Object source, Class<T> destinationClass) {
		return source == null ? null : this.dozer.map(source, destinationClass);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> List<T> mapList(Collection sourceList, Class destinationClass) {
		ArrayList destinationList = new ArrayList();
		if (sourceList == null) {
			return destinationList;
		} else {
			Iterator sourceIterator = sourceList.iterator();

			while (sourceIterator.hasNext()) {
				Object sourceObject = sourceIterator.next();
				Object destinationObject = this.dozer.map(sourceObject, destinationClass);
				destinationList.add(destinationObject);
			}

			return destinationList;
		}
	}

	public void copy(Object source, Object destinationObject) {
		this.dozer.map(source, destinationObject);
	}
}