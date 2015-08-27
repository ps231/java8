package com.threading.lock;

public class ReentrantLockExample {

    public static void main(String... args){
        Account sharedAccount = new Account(20);
        Runnable r = new WithdrawalRunnable(sharedAccount);

        Thread husband = new Thread(r, "husband");
        Thread wife = new Thread(r, "wife");

        husband.start();
        wife.start();
    }

    private static class WithdrawalRunnable implements Runnable {
        private final Account account;
        public WithdrawalRunnable(final Account account) {
            this.account=account;
        }

        @Override public void run() {
            for (int i = 0; i < 2; i++) {
                    account.withdraw();
            }
        }
    }
}
