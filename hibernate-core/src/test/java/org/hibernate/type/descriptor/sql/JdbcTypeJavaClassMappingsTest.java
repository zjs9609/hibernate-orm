/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.type.descriptor.sql;

import java.sql.Types;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Jdbc类型与Java类映射测试
 * @author Tiger Wang
 */
public class JdbcTypeJavaClassMappingsTest {

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * 测试确定JavaClass的Jdbc类型代码
	 * @throws Exception
	 */
	@Test
	public void testDetermineJdbcTypeCodeForJavaClass() throws Exception {
		int jdbcTypeCode = JdbcTypeJavaClassMappings.INSTANCE.determineJdbcTypeCodeForJavaClass( Short.class );
		int jdbcTypeCode = JdbcTypeJavaClassMappings.INSTANCE.determineJdbcTypeCodeForJavaClass( Integer.class );
		assertEquals( jdbcTypeCode, Types.SMALLINT );
	}

	/**
	 * 测试确定Jdbc类型代码的JavaClass类型代码
	 * @throws Exception
	 */
	@Test
	public void testDetermineJavaClassForJdbcTypeCodeTypeCode() throws Exception {
		Class javaClass = JdbcTypeJavaClassMappings.INSTANCE.determineJavaClassForJdbcTypeCode( Types.TINYINT );
		assertEquals( javaClass, Short.class );
	}

}
