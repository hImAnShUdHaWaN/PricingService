package com.hack.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the IndexPrice entity.
 * Repository annotation allows the component scanning support to find and
 * configure the DAO wihtout any XML configuration and also provide the Spring
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class IndexDao {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Return all the indexes stored in the database.
   */
  public List<IndexPrice> getAll() {
    return entityManager.createQuery(
        "from IndexPrice where isLatest = :isLatest")
        .setParameter("isLatest",true)
        .getResultList();
  }

  /**
   * Return the user having the passed email.
   */
  public IndexPrice getByCode(String code) {
    return (IndexPrice) entityManager.createQuery(
        "from IndexPrice where iCode = :code and isLatest = :isLatest")
        .setParameter("code", code)
        .setParameter("isLatest",true)
        .getSingleResult();
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;

} // class IndexDao
