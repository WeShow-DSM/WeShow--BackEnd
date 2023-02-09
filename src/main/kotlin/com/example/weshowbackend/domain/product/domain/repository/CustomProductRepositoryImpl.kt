package com.example.weshowbackend.domain.product.domain.repository

import com.example.weshowbackend.domain.product.domain.Product
import com.example.weshowbackend.domain.product.domain.QProduct.product
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.jpa.impl.JPAQueryFactory


class CustomProductRepositoryImpl (
        private val query: JPAQueryFactory
) : CustomProductRepository {
    override fun todayProduct(): Product {
        return query.selectFrom(product)
                .orderBy(product.createdAt.desc())
                .fetchFirst()
    }

    override fun popularProducts(): List<Product> {
        return query.selectFrom(product)
                .orderBy(product.average.desc())
                .limit(6)
                .fetch()
    }

    override fun randomProducts(): List<Product> {
        return query.selectFrom(product)
                .orderBy(Expressions.numberTemplate(Double::class.java, "function('rand')").asc())
                .limit(4)
                .fetch();
    }
}