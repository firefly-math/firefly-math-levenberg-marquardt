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

import com.fireflysemantics.math.precision.PrecisionConstants;

import lombok.Value;

@Value
public class LMConfiguration {

	/** Initial step bound factor: 100 */
	public static final double INITIAL_STEP_BOUND_FACTOR_DEFAULT = 100.0;

	/** Cost relative tolerance: 1e-10 */
	public static final double COST_RELATIVE_TOLERANCE_DEFAULT = 1e-10;

	/** Parameters relative tolerance: 1e-10 */
	public static final double PARAMETERS_RELATIVE_TOLERANCE_DEFAULT = 1e-10;

	/** Orthogonality tolerance: 1e-10 */
	public static final double ORTHOGONALITY_TOLERANCE_DEFAULT = 1e-10;

	/** Default QR ranking threshold: {@link PrecisionConstants#SAFE_MIN} */
	public static final double QR_RANKING_THRESHOLD_DEFAULT = PrecisionConstants.SAFE_MIN;

	public static LMConfiguration DEFAULT =
			new LMConfiguration(INITIAL_STEP_BOUND_FACTOR_DEFAULT, COST_RELATIVE_TOLERANCE_DEFAULT,
					PARAMETERS_RELATIVE_TOLERANCE_DEFAULT, ORTHOGONALITY_TOLERANCE_DEFAULT,
					QR_RANKING_THRESHOLD_DEFAULT);

	/**
	 * Positive input variable used in determining the initial step bound. This
	 * bound is set to the product of initialStepBoundFactor and the euclidean
	 * norm of {@code diag * x} if non-zero. Otherwise to the
	 * {@code newInitialStepBoundFactor} itself. The interval
	 * {@code [0.1, 100.0]} is appropriate for the
	 * {@code newInitialStepBoundFactor}, and the default value of {@code 100}
	 * is recommended.
	 * 
	 * @return the {@code newInitialStepBoundFactor} value.
	 */
	double initialStepBoundFactor;

	/** Desired relative error in the sum of squares. */
	double costRelativeTolerance;

	/** Desired relative error in the approximate solution parameters. */
	double parRelativeTolerance;

	/**
	 * Desired max cosine on the orthogonality between the function vector and
	 * the columns of the jacobian.
	 * 
	 * @return the {@code orthoTolerance} value.
	 */
	double orthoTolerance;

	/**
	 * Threshold for QR ranking.
	 * 
	 * If the squared norm of a column vector is smaller or equal to this
	 * threshold during QR decomposition, it is considered to be a zero vector
	 * and hence the rank of the matrix is reduced.
	 * 
	 * @return the {@code newQRRankingThreshold} value.
	 */
	double qrRankingThreshold;
}
