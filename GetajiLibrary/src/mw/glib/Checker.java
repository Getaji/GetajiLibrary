package mw.glib;

/**
 * <p>オブジェクトの検査を行うクラスです。
 *
 * <p>nullチェック、真偽値チェック、文字列チェック、数値チェックが用意されています。
 *
 * @since build003
 * @author Getaji
 */
public class Checker {

    private Checker() {}

    /**
     * 渡されたオブジェクトが<tt>null</tt>であるかを返します。
     *
     * @param obj 対象オブジェクト
     * @return <tt>null</tt>であるか
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 渡された単数～複数のオブジェクトがすべて<tt>null</tt>であるかを返します。
     * 何もパタメータが渡されなかった場合にも<tt>true</tt>を返します。
     *
     * @param objects 単数～複数のオブジェクト
     * @return すべてのオブジェクトが<tt>null</tt>であるか
     */
    public static boolean andNull(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object obj : objects) {
            if (obj != null)
                return false;
        }
        return true;
    }

    /**
     * 渡された単数～複数のオブジェクトの最低1つが<tt>null</tt>であるかを返します。
     * 何もパタメータが渡されなかった場合にも<tt>true</tt>を返します。
     *
     * @param objects 単数～複数のオブジェクト
     * @return 最低1つのオブジェクトが<tt>null</tt>であるか
     */
    public static boolean orNull(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object obj : objects) {
            if (obj == null)
                return true;
        }
        return false;
    }

    /**
     * 渡されたオブジェクトが<tt>null</tt>なら<tt>caseObject</tt>を返します。
     * <tt>null</tt>でなかったなら<tt>null</tt>を返します。
     *
     * @param obj オブジェクト
     * @param caseObject <tt>null</tt>の場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return オブジェクトが<tt>null</tt>なら<tt>caseObject</tt>、そうでないなら<tt>null</tt>
     */
    public static <R> R caseNull(Object obj, R caseObject) {
        return caseNull(obj, caseObject, null);
    }

    /**
     * 渡されたオブジェクトが<tt>null</tt>なら<tt>caseObject</tt>を返します。
     * <tt>null</tt>でなかったなら<tt>nonNullObject</tt>を返します。
     *
     * @param obj オブジェクト
     * @param caseObject <tt>null</tt>の場合に返すオブジェクト
     * @param nonNullObject <tt>null</tt>でない場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return オブジェクトが<tt>null</tt>なら<tt>caseObject</tt>、そうでないなら<tt>null</tt>
     */
    public static <R> R caseNull(Object obj, R caseObject, R nonNullObject) {
        return isNull(obj) ? caseObject : nonNullObject;
    }

    /**
     * 渡されたオブジェクトが<tt>null</tt>でなかったなら<tt>caseObject</tt>を返します。
     * <tt>null</tt>なら<tt>null</tt>が返ります。
     *
     * @param obj オブジェクト
     * @param caseObject <tt>null</tt>でなかった場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return オブジェクトが<tt>null</tt>でなかったなら<tt>caseObject</tt>、<tt>null</tt>なら<tt>null</tt>
     */
    public static <R> R caseNonNull(Object obj, R caseObject) {
        return caseNonNull(obj, caseObject, null);
    }

    /**
     * 渡されたオブジェクトが<tt>null</tt>でなかったなら<tt>caseObject</tt>を返します。
     * <tt>null</tt>なら<tt>nullObject</tt>が返ります。
     *
     * @param obj オブジェクト
     * @param caseObject <tt>null</tt>でなかった場合に返すオブジェクト
     * @param nullObject <tt>null</tt>だった場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return オブジェクトが<tt>null</tt>でなかったなら<tt>caseObject</tt>、<tt>null</tt>なら<tt>null</tt>
     */
    public static <R> R caseNonNull(Object obj, R caseObject, R nullObject) {
        return !isNull(obj) ? caseObject: nullObject;
    }

    /**
     * 渡されたオブジェクトが<tt>null</tt>なら、
     * {@link NullPointerException}をスローします。
     * {@link NullPointerException}には何も渡されません。
     * 文字列を指定したい場合は、
     * {@link Checker#requireNonNull(Object, String)}を用いてください。
     *
     * @param obj オブジェクト
     * @throws NullPointerException オブジェクトが<tt>null</tt>の場合にスロー
     */
    public static void requireNonNull(Object obj) throws NullPointerException{
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    /**
     * 渡されたオブジェクトが<tt>null</tt>なら、
     * 受け取った文字列<tt>message</tt>を渡した{@link NullPointerException}をスローします。
     *
     * @param obj オブジェクト
     * @param message {@link NullPointerException}に渡す文字列
     * @throws NullPointerException オブジェクトが<tt>null</tt>の場合にスロー
     */
    public static void requireNonNull(Object obj, String message)
            throws NullPointerException {
        if (obj == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * <p>渡された単数～複数のオブジェクトの最低1つが<tt>null</tt>なら、
     * {@link NullPointerException}をスローします。
     *
     * <p>このメソッドはすべてのオブジェクトがnullでないことを保証するためのメソッドです。
     *
     * @param objects 単数～複数のオブジェクト
     * @throws NullPointerException オブジェクトの最低1つが<tt>null</tt>の場合にスロー
     */
    public static void requireAndNonNull(Object... objects)
            throws NullPointerException {
        requireNonNull(objects);
        for (Object obj : objects)
            if (obj == null)
                throw new NullPointerException();
    }

    /**
     * <p>渡された単数～複数のオブジェクトがすべて<tt>null</tt>なら、
     * {@link NullPointerException}をスローします。
     *
     * <p>このメソッドはオブジェクトが最低ひとつでも<tt>null</tt>でないことを保証するためのメソッドです。
     *
     * @param objects 単数～複数のオブジェクト
     * @throws NullPointerException オブジェクトのすべてが<tt>null</tt>の場合にスロー
     */
    public static void requireOrNonNull(Object... objects)
            throws NullPointerException {
        requireNonNull(objects);
        for (Object obj : objects)
            if (obj != null) {
                return;
            }
        throw new NullPointerException();
    }

    /**
     * 渡された単数～複数の真偽値がすべて<tt>true</tt>なら<tt>true</tt>を返します。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * @param booleans 単数～複数の真偽値
     * @return 真偽値がすべて<tt>true</tt>か
     */
    public static boolean andTrue(boolean... booleans) {
        requireNonNull(booleans);
        for (boolean bool : booleans) {
            requireNonNull(bool);
            if (!bool)
                return false;
        }
        return true;
    }

    /**
     * 渡された単数～複数の真偽値のいずれかが<tt>true</tt>なら<tt>true</tt>を返します。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * @param booleans 単数～複数の真偽値
     * @return 真偽値のいずれかが<tt>true</tt>か
     */
    public static boolean orTrue(boolean... booleans) {
        requireNonNull(booleans);
        for (boolean bool : booleans) {
            requireNonNull(bool);
            if (bool)
                return true;
        }
        return false;
    }

    /**
     * 渡された真偽値が<tt>true</tt>なら<tt>trueObject</tt>を返します。
     * <tt>false</tt>なら<tt>null</tt>を返します。
     *
     * @param bool 真偽値
     * @param trueObject <tt>true</tt>の場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return 真偽値が<tt>true</tt>なら<tt>trueObject</tt>、<tt>false</tt>なら<tt>null</tt>
     */
    public static <R> R caseTrue(boolean bool, R trueObject) {
        return caseTrue(bool, trueObject, null);
    }

    /**
     * 渡された真偽値が<tt>true</tt>なら<tt>trueObject</tt>を返します。
     * <tt>false</tt>なら<tt>falseObject</tt>を返します。
     *
     * @param bool 真偽値
     * @param trueObject <tt>true</tt>の場合に返すオブジェクト
     * @param falseObject <tt>false</tt>の場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return 真偽値が<tt>true</tt>なら<tt>trueObject</tt>、<tt>false</tt>なら<tt>falseObject</tt>
     */
    public static <R> R caseTrue(boolean bool, R trueObject, R falseObject) {
        return bool ? trueObject : falseObject;
    }

    /**
     * 渡された真偽値が<tt>false</tt>なら<tt>falseObject</tt>を返します。
     * <tt>true</tt>なら<tt>null</tt>を返します。
     *
     * @param bool 真偽値
     * @param falseObject <tt>false</tt>の場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return 真偽値が<tt>false</tt>なら<tt>falseObject</tt>、<tt>true</tt>なら<tt>null</tt>
     */
    public static <R> R caseFalse(boolean bool, R falseObject) {
        return caseTrue(bool, falseObject, null);
    }

    /**
     * 渡された真偽値が<tt>false</tt>なら<tt>falseObject</tt>を返します。
     * <tt>true</tt>なら<tt>trueObject</tt>を返します。
     *
     * @param bool 真偽値
     * @param falseObject <tt>false</tt>の場合に返すオブジェクト
     * @param trueObject <tt>true</tt>の場合に返すオブジェクト
     * @param <R> 返すオブジェクトの型
     * @return 真偽値が<tt>false</tt>なら<tt>falseObject</tt>、<tt>true</tt>なら<tt>trueObject</tt>
     */
    public static <R> R caseFalse(boolean bool, R falseObject, R trueObject) {
        return !bool ? falseObject : trueObject;
    }

    /**
     * <p>渡された<tt>CharSequence</tt>の長さが0なら<tt>true</tt>を返します。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequence CharSequence
     * @return charSequenceの長さが0か
     */
    public static boolean isEmpty(CharSequence charSequence) {
        requireNonNull(charSequence);
        return charSequence.length() == 0;
    }

    /**
     * <p>渡された<tt>CharSequence</tt>の長さが0より大きいなら<tt>true</tt>を返します。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequence CharSequence
     * @return charSequenceの長さが0以上であるか
     */
    public static boolean nonEmpty(CharSequence charSequence) {
        requireNonNull(charSequence);
        return 0 < charSequence.length();
    }

    /**
     * <p>渡された単数～複数の<tt>CharSequence</tt>の長さがすべて0より大きい場合に<tt>true</tt>を返します。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequences 単数～複数のCharSequence
     * @return charSequenceのすべての長さが0より大きいか
     */
    public static boolean andNonEmpty(CharSequence... charSequences) {
        requireNonNull(charSequences);
        for (CharSequence charSequence : charSequences) {
            requireNonNull(charSequence);
            if (0 < charSequence.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>渡された単数～複数の<tt>CharSequence</tt>の最低1つの長さが0より大きい場合に<tt>true</tt>を返します。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequences 単数～複数のCharSequence
     * @return charSequenceの最低1つの長さが0より大きいか
     */
    public static boolean orNonEmpty(CharSequence... charSequences) {
        requireNonNull(charSequences);
        for (CharSequence charSequence : charSequences) {
            requireNonNull(charSequence);
            if (0 < charSequence.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>渡された<tt>charSequence</tt>の長さが0なら<tt>IllegalArgumentException</tt>をスローします。
     * <tt>IllegalArgumentException</tt>には何も渡されません。
     * 文字列を指定したい場合は、
     * {@link Checker#requireNonEmpty(CharSequence, String)}を用いてください。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequence CharSequence
     * @throws IllegalArgumentException CharSequenceの長さが0ならスロー
     */
    public static void requireNonEmpty(CharSequence charSequence) {
        if (isEmpty(charSequence))
            throw new IllegalArgumentException();
    }

    /**
     * <p>渡された<tt>charSequence</tt>の長さが0の場合に、
     * 受け取った文字列<tt>message</tt>を渡した<tt>IllegalArgumentException</tt>をスローします。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequence CharSequence
     * @param message <tt>IllegalArgumentException</tt>に渡す文字列
     * @throws IllegalArgumentException CharSequenceの長さが0の場合にスロー
     */
    public static void requireNonEmpty(CharSequence charSequence, String message) {
        if (isEmpty(charSequence)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * <p>渡された単数～複数の<tt>CharSequence</tt>のいずれかの長さが0なら、
     * <tt>IllegalArgumentException</tt>をスローします。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>このメソッドはすべての<tt>CharSequence</tt>の長さが0より大きいことを保証するためのメソッドです。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequences 単数～複数のCharSequence
     * @throws IllegalArgumentException CharSequenceのいずれかの長さが0ならスロー
     */
    public static void requireAndNonEmpty(CharSequence... charSequences) {
        requireNonNull(charSequences);
        for (CharSequence charSequence : charSequences) {
            requireNonNull(charSequence);
            if (charSequence.length() == 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * <p>渡された単数～複数の<tt>CharSequence</tt>の長さがすべて0なら、
     * <tt>IllegalArgumentException</tt>をスローします。
     * 同時に<tt>null</tt>チェックも行われます。
     *
     * <p>このメソッドは最低1つの<tt>CharSequence</tt>の長さが0より大きいことを保証するためのメソッドです。
     *
     * <p>{@link CharSequence}は{@link String}や{@link AbstractStringBuilder}が実装するインターフェースです。
     *
     * @param charSequences 単数～複数のCharSequence
     * @throws IllegalArgumentException CharSequenceのすべての長さが0なら
     */
    public static void requireOrNonEmpty(CharSequence... charSequences) {
        requireNonNull(charSequences);
        for (CharSequence charSequence : charSequences) {
            requireNonNull(charSequence);
            if (0 < charSequence.length()) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 渡された数値が0.0の場合に<tt>true</tt>を返します。
     * @param d 数値
     * @return 数値が0.0であるか
     */
    public static boolean isZero(double d) {
        return d == 0.0;
    }

    /**
     * 渡された数値が0でない場合に<tt>true</tt>を返します。
     * @param d 数値
     * @return 数値が0.0でない場合にtrue
     */
    public static boolean nonZero(double d) {
        return d != 0;
    }

    /**
     * 渡された数値が0.0以上の場合に<tt>true</tt>を返します。
     * @param d 数値
     * @return 数値が0.0以上か
     */
    public static boolean isPlus(double d) {
        return 0 <= d;
    }

    /**
     * 渡された数値が0.0より小さい場合に<tt>true</tt>を返します。
     * @param d 数値
     * @return 数値が0.0より小さいか
     */
    public static boolean isMinus(double d) {
        return d < 0;
    }
}
