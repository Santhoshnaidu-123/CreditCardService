package com.publicis.sapient.repository;

import com.publicis.sapient.model.CreditCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditCardRepository extends PagingAndSortingRepository<CreditCard,String> {
}
