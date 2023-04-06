package com.example.webshopping.data;

import com.example.webshopping.bussiness.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
}
