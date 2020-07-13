package org.apache.zookeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZooKeeperExposed {
    private static final Logger LOG = LoggerFactory
            .getLogger(ZooKeeperTestable.class);

    private final ZooKeeper zooKeeper;
    private final ClientCnxn clientCnxn;

    public ZooKeeperExposed(ZooKeeper zooKeeper, ClientCnxn clientCnxn) {
        this.zooKeeper = zooKeeper;
        this.clientCnxn = clientCnxn;
    }

    public void setSendThreadState(ZooKeeper.States closed) {
        clientCnxn.state = ZooKeeper.States.CLOSED;
        clientCnxn.eventThread.queueEventOfDeath();
    }

//    @Override
//    public void injectSessionExpiration() {
//        LOG.info("injectSessionExpiration() called");
//
//        clientCnxn.eventThread.queueEvent(new WatchedEvent(
//                Watcher.Event.EventType.None,
//                Watcher.Event.KeeperState.Expired, null));
//        clientCnxn.eventThread.queueEventOfDeath();
//        clientCnxn.state = ZooKeeper.States.CLOSED;
//        clientCnxn.sendThread.getClientCnxnSocket().onClosing();
//    }
}