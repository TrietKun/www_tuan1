package com.example.tuan1.repositories;

import com.example.tuan1.models.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private final EntityManager em;
    private final EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    public AccountRepository() {
        em = Persistence.createEntityManagerFactory("tuan1").createEntityManager();
        trans = em.getTransaction();
    }

    public List<Account> getAllAccounts() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    public Optional<Account> getAccountById(String accountId) {
        Account account = em.find(Account.class, accountId);
        return Optional.ofNullable(account);
    }

    public void saveOrUpdateAccount(Account account) {
        trans.begin();
        em.persist(account);
        trans.commit();
    }

    public void deleteAccount(String accountId) {
        trans.begin();
        Account account = em.find(Account.class, accountId);
        if (account != null) {
            em.remove(account);
        }
        trans.commit();
    }

    public Optional<Account> findByEmail(String email) {
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.email = :email", Account.class);
        query.setParameter("email", email);
        Account account = query.getSingleResult();
        return account == null ? Optional.empty() : Optional.of(account);
    }
    public Optional<Account> createAccount(Account newAccount) {
        trans.begin();
        try {
            TypedQuery<Account> query = em.createQuery(
                    "SELECT a FROM Account a WHERE a.email = :email",
                    Account.class
            );
            query.setParameter("email", newAccount.getEmail());
            List<Account> existingAccounts = query.getResultList();

            if (existingAccounts.isEmpty()) {
                em.persist(newAccount);
                trans.commit();
                return Optional.of(newAccount);
            } else {
                trans.rollback();
                return Optional.empty();
            }
        } catch (Exception e) {
            trans.rollback();
            return Optional.empty();
        } finally {
            if (trans.isActive()) {
                trans.rollback();
            }
        }
    }
    public void closeEntityManager() {
        em.close();
    }
}
