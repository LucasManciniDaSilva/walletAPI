package com.wallet.logger;

public interface MessageFormatter {

    boolean handle(String message);

    String format(String message);
}
