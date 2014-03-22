package mw.glib;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * 例外・エラーのスローを代行するクラスです。
 *
 * @since build004
 * @author Getaji
 */
public class Thrower {

    private Thrower() {}

    /* ******** Throwable ******** */

    /**
     * {@link Throwable}をスローします。
     *
     * @throws Throwable
     */
    public static void throwT() throws Throwable {
        throw new Throwable();
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @param message 渡すmessage
     * @throws Throwable
     */
    public static void throwT(String message) throws Throwable {
        throw new Throwable(message);
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws Throwable
     */
    public static void throwT(String message, Throwable throwable) throws Throwable {
        throw new Throwable(message, throwable);
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws Throwable
     */
    public static void throwT(Throwable throwable) throws Throwable {
        throw new Throwable(throwable);
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @throws Throwable
     */
    public static void throwThrowable() throws Throwable {
        throw new Throwable();
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @param message 渡すmessage
     * @throws Throwable
     */
    public static void throwThrowable(String message) throws Throwable {
        throw new Throwable(message);
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws Throwable
     */
    public static void throwThrowable(String message, Throwable throwable) throws Throwable {
        throw new Throwable(message, throwable);
    }

    /**
     * {@link Throwable}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws Throwable
     */
    public static void throwThrowable(Throwable throwable) throws Throwable {
        throw new Throwable(throwable);
    }

    /* ******** Exception ******** */

    /**
     * {@link Exception}をスローします。
     *
     * @throws Exception
     */
    public static void throwEx() throws Exception {
        throw new Exception();
    }

    /**
     * {@link Exception}をスローします。
     *
     * @param message 渡すmessage
     * @throws Exception
     */
    public static void throwEx(String message) throws Exception {
        throw new Exception(message);
    }

    /**
     * {@link Exception}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws Exception
     */
    public static void throwEx(String message, Throwable throwable) throws Exception {
        throw new Exception(message, throwable);
    }

    /**
     * {@link Exception}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws Exception
     */
    public static void throwEx(Throwable throwable) throws Exception {
        throw new Exception(throwable);
    }

    /**
     * {@link Exception}をスローします。
     *
     * @throws Exception
     */
    public static void throwException() throws Exception {
        throw new Exception();
    }

    /**
     * {@link Exception}をスローします。
     *
     * @param message 渡すmessage
     * @throws Exception
     */
    public static void throwException(String message) throws Exception {
        throw new Exception(message);
    }

    /**
     * {@link Exception}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws Exception
     */
    public static void throwException(String message, Throwable throwable) throws Exception {
        throw new Exception(message, throwable);
    }

    /**
     * {@link Exception}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws Exception
     */
    public static void throwException(Throwable throwable) throws Exception {
        throw new Exception(throwable);
    }

    /* ******** Error ******** */

    /**
     * {@link Error}をスローします。
     *
     * @throws Error
     */
    public static void throwErr() throws Error {
        throw new Error();
    }

    /**
     * {@link Error}をスローします。
     *
     * @param message 渡すmessage
     * @throws Error
     */
    public static void throwErr(String message) throws Error {
        throw new Error(message);
    }

    /**
     * {@link Error}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws Error
     */
    public static void throwErr(String message, Throwable throwable) throws Error {
        throw new Error(message, throwable);
    }

    /**
     * {@link Error}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws Error
     */
    public static void throwErr(Throwable throwable) throws Error {
        throw new Error(throwable);
    }

    /**
     * {@link Error}をスローします。
     *
     * @throws Error
     */
    public static void throwError() throws Error {
        throw new Error();
    }

    /**
     * {@link Error}をスローします。
     *
     * @param message 渡すmessage
     * @throws Error
     */
    public static void throwError(String message) throws Error {
        throw new Error(message);
    }

    /**
     * {@link Error}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws Error
     */
    public static void throwError(String message, Throwable throwable) throws Error {
        throw new Error(message, throwable);
    }

    /**
     * {@link Error}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws Error
     */
    public static void throwError(Throwable throwable) throws Error {
        throw new Error(throwable);
    }

    /* ******** RuntimeException ******** */

    /**
     * {@link RuntimeException}をスローします。
     *
     * @throws RuntimeException
     */
    public static void throwRE() throws RuntimeException {
        throw new RuntimeException();
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @param message 渡すmessage
     * @throws RuntimeException
     */
    public static void throwRE(String message) throws RuntimeException {
        throw new RuntimeException(message);
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws RuntimeException
     */
    public static void throwRE(String message, Throwable throwable) throws RuntimeException {
        throw new RuntimeException(message, throwable);
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws RuntimeException
     */
    public static void throwRE(Throwable throwable) throws RuntimeException {
        throw new RuntimeException(throwable);
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @throws RuntimeException
     */
    public static void throwRuntimeRuntimeException() throws RuntimeException {
        throw new RuntimeException();
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @param message 渡すmessage
     * @throws RuntimeException
     */
    public static void throwRuntimeException(String message) throws RuntimeException {
        throw new RuntimeException(message);
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws RuntimeException
     */
    public static void throwRuntimeException(String message, Throwable throwable) throws RuntimeException {
        throw new RuntimeException(message, throwable);
    }

    /**
     * {@link RuntimeException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws RuntimeException
     */
    public static void throwRuntimeException(Throwable throwable) throws RuntimeException {
        throw new RuntimeException(throwable);
    }

    /* ******** NullPointerException ******** */

    /**
     * {@link NullPointerException}をスローします。
     *
     * @throws NullPointerException
     */
    public static void throwNPE() throws NullPointerException {
        throw new NullPointerException();
    }

    /**
     * {@link NullPointerException}をスローします。
     *
     * @param message 渡すmessage
     * @throws NullPointerException
     */
    public static void throwNPE(String message) throws NullPointerException {
        throw new NullPointerException(message);
    }

    /**
     * {@link NullPointerException}をスローします。
     *
     * @throws NullPointerException
     */
    public static void throwNullPointerException() throws NullPointerException {
        throw new NullPointerException();
    }

    /**
     * {@link NullPointerException}をスローします。
     *
     * @param message 渡すmessage
     * @throws NullPointerException
     */
    public static void throwNullPointerException(String message) throws NullPointerException {
        throw new NullPointerException(message);
    }

    /* ******** ClassCastException ******** */

    /**
     * {@link ClassCastException}をスローします。
     *
     * @throws ClassCastException
     */
    public static void throwCCE() throws ClassCastException {
        throw new ClassCastException();
    }

    /**
     * {@link ClassCastException}をスローします。
     *
     * @param message 渡すmessage
     * @throws ClassCastException
     */
    public static void throwCCE(String message) throws ClassCastException {
        throw new ClassCastException(message);
    }

    /**
     * {@link ClassCastException}をスローします。
     *
     * @throws ClassCastException
     */
    public static void throwClassCastException() throws ClassCastException {
        throw new ClassCastException();
    }

    /**
     * {@link ClassCastException}をスローします。
     *
     * @param message 渡すmessage
     * @throws ClassCastException
     */
    public static void throwClassCastException(String message) throws ClassCastException {
        throw new ClassCastException(message);
    }

    /* ******** IllegalAugmentException ******** */

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @throws IllegalArgumentException
     */
    public static void throwIAE() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @param message 渡すmessage
     * @throws IllegalArgumentException
     */
    public static void throwIAE(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws IllegalArgumentException
     */
    public static void throwIAE(String message, Throwable throwable) throws IllegalArgumentException {
        throw new IllegalArgumentException(message, throwable);
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws IllegalArgumentException
     */
    public static void throwIAE(Throwable throwable) throws IllegalArgumentException {
        throw new IllegalArgumentException(throwable);
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @throws IllegalArgumentException
     */
    public static void throwIllegalAugmentException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @param message 渡すmessage
     * @throws IllegalArgumentException
     */
    public static void throwIllegalAugmentException(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws IllegalArgumentException
     */
    public static void throwIllegalAugmentException(String message, Throwable throwable) throws IllegalArgumentException {
        throw new IllegalArgumentException(message, throwable);
    }

    /**
     * {@link IllegalArgumentException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws IllegalArgumentException
     */
    public static void throwIllegalAugmentException(Throwable throwable) throws IllegalArgumentException {
        throw new IllegalArgumentException(throwable);
    }

    /* ******** NoClassDefFoundError ******** */

    /**
     * {@link NoClassDefFoundError}をスローします。
     *
     * @throws NoClassDefFoundError
     */
    public static void throwNCDFE() throws NoClassDefFoundError {
        throw new NoClassDefFoundError();
    }

    /**
     * {@link NoClassDefFoundError}をスローします。
     *
     * @param message 渡すmessage
     * @throws NoClassDefFoundError
     */
    public static void throwNCDFE(String message) throws NoClassDefFoundError {
        throw new NoClassDefFoundError(message);
    }

    /**
     * {@link NoClassDefFoundError}をスローします。
     *
     * @throws NoClassDefFoundError
     */
    public static void throwNoClassDefFoundError() throws NoClassDefFoundError {
        throw new NoClassDefFoundError();
    }

    /**
     * {@link NoClassDefFoundError}をスローします。
     *
     * @param message 渡すmessage
     * @throws NoClassDefFoundError
     */
    public static void throwNoClassDefFoundError(String message) throws NoClassDefFoundError {
        throw new NoClassDefFoundError(message);
    }

    /* ******** UnsupportedOperationException ******** */

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @throws UnsupportedOperationException
     */
    public static void throwUOE() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @param message 渡すmessage
     * @throws UnsupportedOperationException
     */
    public static void throwUOE(String message) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(message);
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws UnsupportedOperationException
     */
    public static void throwUOE(String message, Throwable throwable) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(message, throwable);
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws UnsupportedOperationException
     */
    public static void throwUOE(Throwable throwable) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(throwable);
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @throws UnsupportedOperationException
     */
    public static void throwUnsupportedOperationException() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @param message 渡すmessage
     * @throws UnsupportedOperationException
     */
    public static void throwUnsupportedOperationException(String message) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(message);
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws UnsupportedOperationException
     */
    public static void throwUnsupportedOperationException(String message, Throwable throwable) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(message, throwable);
    }

    /**
     * {@link UnsupportedOperationException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws UnsupportedOperationException
     */
    public static void throwUnsupportedOperationException(Throwable throwable) throws UnsupportedOperationException {
        throw new UnsupportedOperationException(throwable);
    }

    /* ******** NoSuchFileException ******** */

    /**
     * {@link NoSuchFileException}をスローします。
     *
     * @param file 渡すfile
     * @throws NoSuchFileException
     */
    public static void throwNSFE(String file) throws NoSuchFileException {
        throw new NoSuchFileException(file);
    }

    /**
     * {@link NoSuchFileException}をスローします。
     *
     * @param file 渡すfile
     * @param other 渡すother
     * @param reason 渡すreason
     * @throws NoSuchFileException
     */
    public static void throwNSFE(String file, String other, String reason) throws NoSuchFileException {
        throw new NoSuchFileException(file, other, reason);
    }

    /**
     * {@link NoSuchFileException}をスローします。
     *
     * @param file 渡すfile
     * @throws NoSuchFileException
     */
    public static void throwNoSuchFileException(String file) throws NoSuchFileException {
        throw new NoSuchFileException(file);
    }

    /**
     * {@link NoSuchFileException}をスローします。
     *
     * @param file 渡すfile
     * @param other 渡すother
     * @param reason 渡すreason
     * @throws NoSuchFileException
     */
    public static void throwNoSuchFileException(String file, String other, String reason) throws NoSuchFileException {
        throw new NoSuchFileException(file, other, reason);
    }

    /* ******** IOException ******** */

    /**
     * {@link IOException}をスローします。
     *
     * @throws IOException
     */
    public static void throwIOE() throws IOException {
        throw new IOException();
    }

    /**
     * {@link IOException}をスローします。
     *
     * @param message 渡すmessage
     * @throws IOException
     */
    public static void throwIOE(String message) throws IOException {
        throw new IOException(message);
    }

    /**
     * {@link IOException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws IOException
     */
    public static void throwIOE(String message, Throwable throwable) throws IOException {
        throw new IOException(message, throwable);
    }

    /**
     * {@link IOException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws IOException
     */
    public static void throwIOE(Throwable throwable) throws IOException {
        throw new IOException(throwable);
    }

    /**
     * {@link IOException}をスローします。
     *
     * @throws IOException
     */
    public static void throwIOException() throws IOException {
        throw new IOException();
    }

    /**
     * {@link IOException}をスローします。
     *
     * @param message 渡すmessage
     * @throws IOException
     */
    public static void throwIOException(String message) throws IOException {
        throw new IOException(message);
    }

    /**
     * {@link IOException}をスローします。
     *
     * @param message 渡すmessage
     * @param throwable 渡すthrowable
     * @throws IOException
     */
    public static void throwIOException(String message, Throwable throwable) throws IOException {
        throw new IOException(message, throwable);
    }

    /**
     * {@link IOException}をスローします。
     *
     * @param throwable 渡すthrowable
     * @throws IOException
     */
    public static void throwIOException(Throwable throwable) throws IOException {
        throw new IOException(throwable);
    }

    /* ******** ArrayIndexOutOfBoundsException ******** */

    /**
     * {@link ArrayIndexOutOfBoundsException}をスローします。
     *
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void throwAIOOBE() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * {@link ArrayIndexOutOfBoundsException}をスローします。
     *
     * @param index 渡すindex
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void throwAIOOBE(int index) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(index);
    }

    /**
     * {@link ArrayIndexOutOfBoundsException}をスローします。
     *
     * @param message 渡すmessage
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void throwAIOOBE(String message) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(message);
    }

    /**
     * {@link ArrayIndexOutOfBoundsException}をスローします。
     *
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void throwArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * {@link ArrayIndexOutOfBoundsException}をスローします。
     *
     * @param index 渡すindex
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void throwArrayIndexOutOfBoundsException(int index) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(index);
    }

    /**
     * {@link ArrayIndexOutOfBoundsException}をスローします。
     *
     * @param message 渡すmessage
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void throwArrayIndexOutOfBoundsException(String message) throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException(message);
    }

    /* ******** IndexOutOfBoundsException ******** */

    /**
     * {@link IndexOutOfBoundsException}をスローします。
     *
     * @throws IndexOutOfBoundsException
     */
    public static void throwIOOBE() throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException();
    }

    /**
     * {@link IndexOutOfBoundsException}をスローします。
     *
     * @param message 渡すmessage
     * @throws IndexOutOfBoundsException
     */
    public static void throwIOOBE(String message) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException(message);
    }

    /**
     * {@link IndexOutOfBoundsException}をスローします。
     *
     * @throws IndexOutOfBoundsException
     */
    public static void throwIndexOutOfBoundsException() throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException();
    }

    /**
     * {@link IndexOutOfBoundsException}をスローします。
     *
     * @param message 渡すmessage
     * @throws IndexOutOfBoundsException
     */
    public static void throwIndexOutOfBoundsException(String message) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException(message);
    }

    /* ******** NumberFormatException ******** */

    /**
     * {@link NumberFormatException}をスローします。
     *
     * @throws NumberFormatException
     */
    public static void throwNFE() throws NumberFormatException {
        throw new NumberFormatException();
    }

    /**
     * {@link NumberFormatException}をスローします。
     *
     * @param message 渡すmessage
     * @throws NumberFormatException
     */
    public static void throwNFE(String message) throws NumberFormatException {
        throw new NumberFormatException(message);
    }

    /**
     * {@link NumberFormatException}をスローします。
     *
     * @throws NumberFormatException
     */
    public static void throwNumberFormatException() throws NumberFormatException {
        throw new NumberFormatException();
    }

    /**
     * {@link NumberFormatException}をスローします。
     *
     * @param message 渡すmessage
     * @throws NumberFormatException
     */
    public static void throwNumberFormatException(String message) throws NumberFormatException {
        throw new NumberFormatException(message);
    }
}
