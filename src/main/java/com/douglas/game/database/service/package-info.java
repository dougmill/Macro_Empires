/**
 * Provides high level database access. Methods may do complex data manipulation. All methods that call
 * {@link com.douglas.game.database.transaction.SubTransactional} dao methods should be annotated with
 * {@link com.douglas.game.database.transaction.Transactional}.
 */
package com.douglas.game.database.service;