/**
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.fireflysemantics.math.optimization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fireflysemantics.math.precision.PrecisionConstants;

public class LMConfigurationTest {

	@Test
	public void verifyDefaults() {
		LMConfiguration DEFAULT = LMConfiguration.DEFAULT;
		assertEquals(DEFAULT.getInitialStepBoundFactor(), 100.0, PrecisionConstants.EPSILON);
		assertEquals(DEFAULT.getCostRelativeTolerance(), 1e-10, PrecisionConstants.EPSILON);
		assertEquals(DEFAULT.getParRelativeTolerance(), 1e-10, PrecisionConstants.EPSILON);
		assertEquals(DEFAULT.getOrthoTolerance(), 1e-10, PrecisionConstants.EPSILON);
		assertEquals(DEFAULT.getQrRankingThreshold(), PrecisionConstants.SAFE_MIN,
				PrecisionConstants.EPSILON);
	}

	@Test
	public void verifyCustom() {
		LMConfiguration CUSTOM = new LMConfiguration(100, 200, 300, 400, 500);
		assertEquals(CUSTOM.getInitialStepBoundFactor(), 100.0, PrecisionConstants.EPSILON);
		assertEquals(CUSTOM.getCostRelativeTolerance(), 200, PrecisionConstants.EPSILON);
		assertEquals(CUSTOM.getParRelativeTolerance(), 300, PrecisionConstants.EPSILON);
		assertEquals(CUSTOM.getOrthoTolerance(), 400, PrecisionConstants.EPSILON);
		assertEquals(CUSTOM.getQrRankingThreshold(), 500, PrecisionConstants.EPSILON);
	}
}
