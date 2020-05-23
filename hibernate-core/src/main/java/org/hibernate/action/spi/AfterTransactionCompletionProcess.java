/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.action.spi;

import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * Contract representing some process that needs to occur during after transaction completion.
 * 表示完成事务后需要发生的某些过程的合同。
 *
 * @author Steve Ebersole
 */
public interface AfterTransactionCompletionProcess {
	/**
	 * Perform whatever processing is encapsulated here after completion of the transaction.
	 *	交易完成后，执行此处封装的所有处理。
	 * @param success Did the transaction complete successfully?  True means it did.
	 *                   交易成功完成了吗？真实意味着做到了。
	 * @param session The session on which the transaction is completing.
	 *                 交易完成的会话
	 */
	void doAfterTransactionCompletion(boolean success, SharedSessionContractImplementor session);
}
