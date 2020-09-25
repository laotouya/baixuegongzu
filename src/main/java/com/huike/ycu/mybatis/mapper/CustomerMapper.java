package com.huike.ycu.mybatis.mapper;

import com.huike.ycu.mybatis.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    List<Customer> getAll();

    Customer getOne(Long id);

    void insert(Customer customer);

    void update(Customer customer);

    void delete(Long id);
}
