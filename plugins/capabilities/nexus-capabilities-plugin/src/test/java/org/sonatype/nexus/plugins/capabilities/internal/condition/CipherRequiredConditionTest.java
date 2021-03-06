/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2007-2013 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */

package org.sonatype.nexus.plugins.capabilities.internal.condition;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

import org.sonatype.sisu.goodies.crypto.CryptoHelper;
import org.sonatype.sisu.goodies.eventbus.EventBus;
import org.sonatype.sisu.litmus.testsupport.TestSupport;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link CipherRequiredCondition}.
 *
 * @since 2.7
 */
public class CipherRequiredConditionTest
    extends TestSupport
{
  public static final String FAKE_TRANSFORMATION = "fake-transformation";

  private CipherRequiredCondition condition;

  @Mock
  private CryptoHelper crypto;

  @Before
  public void setUp() throws Exception {
    EventBus eventBus = mock(EventBus.class);
    condition = new CipherRequiredCondition(eventBus, crypto, FAKE_TRANSFORMATION);
  }

  @Test
  public void unsatisfiedWhenTransformMissing() throws Exception {
    when(crypto.createCipher(FAKE_TRANSFORMATION)).thenThrow(new NoSuchAlgorithmException());
    condition.bind();
    assertThat(condition.isSatisfied(), is(false));
  }

  @Test
  public void satisfiedWhenTransformAvailable() throws Exception {
    when(crypto.createCipher(FAKE_TRANSFORMATION)).thenReturn(mock(Cipher.class));
    condition.bind();
    assertThat(condition.isSatisfied(), is(true));
  }
}
