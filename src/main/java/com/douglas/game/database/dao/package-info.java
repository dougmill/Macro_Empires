/**
 * Provides low level access to objects stored in the database. All Hibernate queries belong in this package.
 * Methods are limited to simple retrieval, storage, and updates. All methods that perform database access directly
 * should be annotated with {@link com.douglas.game.database.transaction.SubTransactional}.
 */
package com.douglas.game.database.dao;