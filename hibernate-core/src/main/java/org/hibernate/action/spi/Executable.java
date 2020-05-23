/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.action.spi;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

/**
 * An operation which may be scheduled for later execution.  Usually, the operation is a database
 * insert/update/delete, together with required second-level cache management.
 *
 *  可以安排在以后执行的操作 通常，该操作是数据库插入/更新/删除以及所需的二级缓存管理。
 * @author Gavin King
 * @author Steve Ebersole
 */
public interface Executable {
	/**
	 * 哪些空间（表）受此操作影响？
	 * What spaces (tables) are affected by this action?
	 *	//受此操作影响的空间。
	 * @return The spaces affected by this action.
	 */
	Serializable[] getPropertySpaces();

	/**
	 * Called before executing any actions.  Gives actions a chance to perform any preparation.
	 * 在执行任何操作之前调用。使行动有机会进行任何准备。
	 * @throws HibernateException Indicates a problem during preparation.
	 * 表示准备过程中有问题。
	 */
	void beforeExecutions() throws HibernateException;

	/**
	 * Execute this action.
	 * 执行此操作。
	 * @throws HibernateException Indicates a problem during execution.
	 * 指示执行期间有问题
	 */
	void execute() throws HibernateException;

	/**
	 * Get the after-transaction-completion process, if any, for this action.
	 *	获取此操作的事务完成后过程（如果有）。
	 * @return The after-transaction-completion process, or null if we have no
	 * after-transaction-completion process
	 *  交易后完成过程；如果没有交易后完成过程，则为null
	 */
	AfterTransactionCompletionProcess getAfterTransactionCompletionProcess();

	/**
	 * Get the before-transaction-completion process, if any, for this action.
	 * 获取此操作的事务完成前过程（如果有）。
	 *	他是交易完成前的流程，如果没有交易完成前的流程，则为null
	 * @return The before-transaction-completion process, or null if we have no
	 * before-transaction-completion process
	 */
	BeforeTransactionCompletionProcess getBeforeTransactionCompletionProcess();
	
	/**
	 * Reconnect to session after deserialization
	 * 反序列化后重新连接到会话
	 * @param session The session being deserialized 反序列化会话
	 */
	void afterDeserialize(SharedSessionContractImplementor session);
}
