package org.boticordjava.api.impl;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

class Limiter {

    private final AtomicInteger stats = new AtomicInteger(1);
    private final AtomicInteger server = new AtomicInteger(1);

    private final AtomicInteger other = new AtomicInteger(5);

    private static volatile Limiter limiter;

    private Limiter() {
    }

    protected static Limiter getInstance() {
        if (limiter == null) {
            synchronized (Limiter.class) {
                if (limiter == null) {
                    limiter = new Limiter();
                    limiter.setStatsAndServer();
                    limiter.setOther();
                }
            }
        }
        return limiter;
    }

    protected synchronized void getStats() {
        try {
            stats.set(0);
            wait();
        } catch (InterruptedException ignored) {
        }
    }

    protected synchronized void getServer() {
        try {
            wait();
            server.set(0);
        } catch (InterruptedException ignored) {
        }
    }

    protected void getOther() {
        try {
            if (other.get() == 1) {
                synchronized (other) {
                    other.wait();
                }
            } else {
                other.decrementAndGet();
            }
        } catch (InterruptedException ignored) {
        }
    }

    private void setStatsAndServer() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() throws NullPointerException {
                try {
                    synchronized (Limiter.getInstance()) {
                        server.set(1);
                        stats.set(1);
                        Limiter.getInstance().notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, 0, 2500);
    }


    private void setOther() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() throws NullPointerException {
                try {
                    synchronized (Limiter.getInstance().other) {
                        other.set(5);
                        Limiter.getInstance().other.notifyAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, 0, 6000);
    }

}
