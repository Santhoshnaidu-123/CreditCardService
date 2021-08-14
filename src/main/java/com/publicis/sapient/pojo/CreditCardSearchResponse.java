package com.publicis.sapient.pojo;

import com.publicis.sapient.model.CreditCard;
import lombok.Data;

import java.util.List;

@Data
public class CreditCardSearchResponse {

    private List<CreditCard> creditCardList;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
