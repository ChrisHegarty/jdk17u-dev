/*
 * Copyright 2019 Raffaello Giulietti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import jdk.internal.math.DoubleToDecimalChecker;
import jdk.test.lib.RandomFactory;

/*
 * @test
 * @bug 8202555
 * @author Raffaello Giulietti
 * @key randomness
 *
 * @modules java.base/jdk.internal.math
 * @library /test/lib
 * @library java.base
 * @build jdk.test.lib.RandomFactory
 * @build java.base/jdk.internal.math.*
 * @run main DoubleToDecimalTest 1_000_000
 */
public class DoubleToDecimalTest {

    private static final int RANDOM_COUNT = 100_000;

    public static void main(String[] args) {
        int count = RANDOM_COUNT;
        if (args.length == 0) {
            DoubleToDecimalChecker.test(count, RandomFactory.getRandom());
            return;
        }
        try {
            count = Integer.parseInt(args[0].replace("_", ""));
        } catch (NumberFormatException ignored) {
        }
        DoubleToDecimalChecker.test(count, RandomFactory.getRandom());
    }

}
