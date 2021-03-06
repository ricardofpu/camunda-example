package br.com.camunda.example.domain.service

import br.com.camunda.example.domain.enums.CustomerStatus
import br.com.camunda.example.domain.model.Customer

interface CustomerService {

    fun findById(id: String): Customer

    fun save(customer: Customer): Customer

    fun update(customer: Customer): Customer

    fun updateStatus(customerId: String, status: CustomerStatus): Customer

    fun delete(customerId: String)

    fun validateStatus(customerId: String)

}