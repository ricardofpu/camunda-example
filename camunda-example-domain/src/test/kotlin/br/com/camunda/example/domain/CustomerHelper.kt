package br.com.camunda.example.domain

import br.com.camunda.example.domain.enums.PaymentStatus
import br.com.camunda.example.domain.enums.PaymentType
import br.com.camunda.example.domain.model.Account
import br.com.camunda.example.domain.model.Credit
import br.com.camunda.example.domain.model.Customer
import br.com.camunda.example.domain.model.Debit
import br.com.camunda.example.domain.model.Transference
import java.util.*

const val EXCEPTION_TEST_FAILED_MESSAGE = "Your test failed because your business rule broke. Please check this."

fun dummyCustomer() =
    Customer(
        fullName = "Ricardo Borges",
        nickName = "Ricardo",
        email = "ricardoborges@test.com",
        gender = "MALE",
        phoneNumber = "3499998888",
        birthDate = Date(1992, 6, 29)
    )

fun dummyAccount(
    balanceAmount: Long = 1000,
    balanceScale: Int = 2,
    balanceCurrency: String = "BRL",
    customer: Customer = dummyCustomer()
): Account =
    Account(
        balanceAmount = balanceAmount,
        balanceScale = balanceScale,
        balanceCurrency = balanceCurrency,
        customer = customer
    )

fun dummyDebit(
    origin: String = "ORIGIN",
    description: String? = "Description",
    priceAmount: Long = 1000,
    priceScale: Int = 2,
    priceCurrency: String = "BRL",
    transactionId: String = randomUUID(),
    type: PaymentType = PaymentType.DEBIT,
    account: Account = dummyAccount()
): Debit =
    Debit(
        priceAmount = priceAmount,
        priceScale = priceScale,
        priceCurrency = priceCurrency,
        transactionId = transactionId,
        description = description,
        origin = origin,
        type = type,
        account = account
    )

fun dummyCredit(
    origin: String = "ORIGIN",
    description: String? = "Description",
    valueAmount: Long = 1000,
    valueScale: Int = 2,
    valueCurrency: String = "BRL",
    transactionId: String = randomUUID(),
    type: PaymentType = PaymentType.CREDIT,
    account: Account = dummyAccount()
): Credit =
    Credit(
        valueAmount = valueAmount,
        valueScale = valueScale,
        valueCurrency = valueCurrency,
        transactionId = transactionId,
        description = description,
        origin = origin,
        type = type,
        account = account
    )

fun dummyTransference(
    description: String? = "Description",
    priceAmount: Long = 1000,
    priceScale: Int = 2,
    priceCurrency: String = "BRL",
    transactionId: String = randomUUID(),
    status: PaymentStatus = PaymentStatus.PENDING,
    originAccount: Account = dummyAccount(),
    destinationAccount: Account = dummyAccount()
): Transference =
    Transference(
        priceAmount = priceAmount,
        priceScale = priceScale,
        priceCurrency = priceCurrency,
        transactionId = transactionId,
        description = description,
        status = status,
        originAccount = originAccount,
        destinationAccount = destinationAccount
    )