/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.action.spi;

import org.hibernate.engine.spi.SessionImplementor;

/**
 * Contract representing some process that needs to occur during before transaction completion.
 * 合同，表示在事务完成之前需要发生的某些过程。
 * @author Steve Ebersole
 */
public interface BeforeTransactionCompletionProcess {
	/**
	 * Perform whatever processing is encapsulated here before completion of the transaction.
	 *	在事务完成之前，请执行此处封装的所有处理。
	 * @param session The session on which the transaction is preparing to complete.
	 *                事务准备完成的会话。
	 */
	public void doBeforeTransactionCompletion(SessionImplementor session);
}
