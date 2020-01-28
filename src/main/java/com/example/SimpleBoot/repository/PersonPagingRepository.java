package com.example.SimpleBoot.repository;

import com.example.SimpleBoot.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  PersonPagingRepository extends PagingAndSortingRepository<Person, Integer>  {
}
