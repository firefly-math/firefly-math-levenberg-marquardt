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

/**
 * This class solves a least-squares problem using the Levenberg-Marquardt
 * algorithm.
 *
 * <p>
 * This implementation <em>should</em> work even for over-determined systems
 * (i.e. systems having more unknowns than equations). Over-determined systems
 * are solved by ignoring the points which have the smallest impact according to
 * their jacobian column norm. Only the rank of the matrix and some loop bounds
 * are changed to implement this.
 * </p>
 *
 * <p>
 * The resolution engine is a simple translation of the MINPACK
 * <a href="http://www.netlib.org/minpack/lmder.f">lmder</a> routine with minor
 * changes. The changes include the over-determined resolution, the use of
 * inherited convergence checker and the Q.R. decomposition which has been
 * rewritten following the algorithm described in the P. Lascaux and R. Theodor
 * book <i>Analyse num&eacute;rique matricielle appliqu&eacute;e &agrave; l'art
 * de l'ing&eacute;nieur</i>, Masson 1986.
 * </p>
 * <p>
 * The authors of the original fortran version are:
 * <ul>
 * <li>Argonne National Laboratory. MINPACK project. March 1980</li>
 * <li>Burton S. Garbow</li>
 * <li>Kenneth E. Hillstrom</li>
 * <li>Jorge J. More</li>
 * </ul>
 * The redistribution policy for MINPACK is available
 * <a href="http://www.netlib.org/minpack/disclaimer">here</a>, for convenience,
 * it is reproduced below.
 * </p>
 *
 * <table border="0" width="80%" cellpadding="10" align="center" bgcolor=
 * "#E0E0E0">
 * <tr>
 * <td>Minpack Copyright Notice (1999) University of Chicago. All rights
 * reserved</td>
 * </tr>
 * <tr>
 * <td>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ol>
 * <li>Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.</li>
 * <li>Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.</li>
 * <li>The end-user documentation included with the redistribution, if any, must
 * include the following acknowledgment:
 * <code>This product includes software developed by the University of
 *           Chicago, as Operator of Argonne National Laboratory.</code>
 * Alternately, this acknowledgment may appear in the software itself, if and
 * wherever such third-party acknowledgments normally appear.</li>
 * <li><strong>WARRANTY DISCLAIMER. THE SOFTWARE IS SUPPLIED "AS IS" WITHOUT
 * WARRANTY OF ANY KIND. THE COPYRIGHT HOLDER, THE UNITED STATES, THE UNITED
 * STATES DEPARTMENT OF ENERGY, AND THEIR EMPLOYEES: (1) DISCLAIM ANY
 * WARRANTIES, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO ANY IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE OR
 * NON-INFRINGEMENT, (2) DO NOT ASSUME ANY LEGAL LIABILITY OR RESPONSIBILITY FOR
 * THE ACCURACY, COMPLETENESS, OR USEFULNESS OF THE SOFTWARE, (3) DO NOT
 * REPRESENT THAT USE OF THE SOFTWARE WOULD NOT INFRINGE PRIVATELY OWNED RIGHTS,
 * (4) DO NOT WARRANT THAT THE SOFTWARE WILL FUNCTION UNINTERRUPTED, THAT IT IS
 * ERROR-FREE OR THAT ANY ERRORS WILL BE CORRECTED.</strong></li>
 * <li><strong>LIMITATION OF LIABILITY. IN NO EVENT WILL THE COPYRIGHT HOLDER,
 * THE UNITED STATES, THE UNITED STATES DEPARTMENT OF ENERGY, OR THEIR
 * EMPLOYEES: BE LIABLE FOR ANY INDIRECT, INCIDENTAL, CONSEQUENTIAL, SPECIAL OR
 * PUNITIVE DAMAGES OF ANY KIND OR NATURE, INCLUDING BUT NOT LIMITED TO LOSS OF
 * PROFITS OR LOSS OF DATA, FOR ANY REASON WHATSOEVER, WHETHER SUCH LIABILITY IS
 * ASSERTED ON THE BASIS OF CONTRACT, TORT (INCLUDING NEGLIGENCE OR STRICT
 * LIABILITY), OR OTHERWISE, EVEN IF ANY OF SAID PARTIES HAS BEEN WARNED OF THE
 * POSSIBILITY OF SUCH LOSS OR DAMAGES.</strong></li>
 * <ol>
 * </td>
 * </tr>
 * </table>
 */

public class LevenbergMarquardtOptimizer {

	/** Twice the "epsilon machine". */
	private static final double TWO_EPS = 2
			* PrecisionConstants.EPSILON;

}
